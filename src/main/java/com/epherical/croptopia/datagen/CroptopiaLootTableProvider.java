package com.epherical.croptopia.datagen;

import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static com.epherical.croptopia.CroptopiaMod.MODID;

public class CroptopiaLootTableProvider extends BlockLootSubProvider {


    public CroptopiaLootTableProvider(HolderLookup.Provider registries) {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), registries);
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.entrySet()
                .stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(MODID))
                .map(Map.Entry::getValue)
                .toList();
    }

    @Override
    protected void generate() {
        for (FarmlandCrop farmlandCrop : FarmlandCrop.FARMLAND_CROPS) {
            LootItemCondition.Builder ageCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(farmlandCrop.asBlock())
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7));
            this.add(farmlandCrop.asBlock(),
                    this.applyExplosionDecay(farmlandCrop.asBlock(),
                            LootTable.lootTable()
                                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(farmlandCrop.asItem())))
                                    .withPool(LootPool.lootPool().when(ageCondition)
                                            .add(LootItem.lootTableItem(farmlandCrop.asItem())
                                                    .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registries.holderOrThrow(Enchantments.FORTUNE),  0.5714286F, 3))))));
        }
        for (TreeCrop treeCrop : TreeCrop.TREE_CROPS) {
            LootItemCondition.Builder ageCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(treeCrop.asBlock())
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_3, 3));
            this.add(treeCrop.asBlock(),
                    this.applyExplosionDecay(treeCrop.asBlock(),
                            LootTable.lootTable()
                                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(treeCrop.asItem()).when(ageCondition)))));
            this.dropSelf(treeCrop.getSaplingBlock());
        }
        for (Tree tree : Tree.copy()) {
            this.dropSelf(tree.asBlock());
            this.dropSelf(tree.getSaplingBlock());
            this.dropSelf(tree.getWood());
            this.dropSelf(tree.getStrippedLog());
            this.dropSelf(tree.getStrippedWood());
            this.dropSelf(tree.getLog());
            this.add(tree.getLeaves(), block -> this.createLeavesDrops(block, tree.getSaplingBlock(), NORMAL_LEAVES_SAPLING_CHANCES));
        }
        this.add(Content.SALT_ORE_BLOCK,
                block -> this.createSilkTouchDispatchTable(block,
                        this.applyExplosionCondition(block,
                                LootItem.lootTableItem(Content.SALT)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE), 2)))));
    }
}
