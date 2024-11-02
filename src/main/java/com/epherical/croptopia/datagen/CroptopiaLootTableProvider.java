package com.epherical.croptopia.datagen;

import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static com.epherical.croptopia.CroptopiaMod.MODID;
import static com.epherical.croptopia.CroptopiaMod.createIdentifier;

public class CroptopiaLootTableProvider extends BlockLootSubProvider {


    public static final ResourceKey<LootTable> TUNA_LOOT = ResourceKey.create(Registries.LOOT_TABLE, createIdentifier("chests/tuna_loot"));


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
                                                    .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registries.holderOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))))));
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


    public record ChestLoot(HolderLookup.Provider reg) implements LootTableSubProvider {

        @Override
        public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
            output.accept(TUNA_LOOT,
                    LootTable.lootTable()
                            .withPool(
                                    LootPool.lootPool()
                                            .setRolls(UniformGenerator.between(0, 2))
                                            .add(LootItem.lootTableItem(Content.TUNA_SANDWICH).setWeight(10))
                                            .add(EmptyLootItem.emptyItem().setWeight(90))
                            ));
        }
    }

    public static class GlobalLootProvider extends GlobalLootModifierProvider {

        public GlobalLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries, MODID);
        }

        @Override
        protected void start() {
            add(
                    "add_tuna_to_dungeon",
                    new AddTableLootModifier(
                            new LootItemCondition[]{
                                    LootTableIdCondition.builder(BuiltInLootTables.SIMPLE_DUNGEON.location()).build()
                            }, TUNA_LOOT)
            );

        }
    }
}
