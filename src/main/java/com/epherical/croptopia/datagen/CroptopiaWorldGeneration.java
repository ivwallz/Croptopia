package com.epherical.croptopia.datagen;

import com.epherical.croptopia.common.generator.ConfiguredFeatureKeys;
import com.epherical.croptopia.common.generator.PlacedFeatureKeys;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class CroptopiaWorldGeneration {


    public CroptopiaWorldGeneration() {

    }


    public void addConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        for (TreeCrop treeCrop : TreeCrop.TREE_CROPS)
            context.register(treeCrop.getConfiguredFeatureKey(), treeCrop.getTreeConfig());
        for (Tree tree : Tree.copy())
            context.register(tree.getConfiguredFeatureKey(), tree.getTreeGen());
        context.register(ConfiguredFeatureKeys.DISK_SALT_KEY, WorldGenFeatures.DISK_SALT);
        context.register(ConfiguredFeatureKeys.RANDOM_CROP_KEY, WorldGenFeatures.RANDOM_CROP);
    }

    public void addPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> lookup = context.lookup(Registries.CONFIGURED_FEATURE);
        for (TreeCrop treeCrop : TreeCrop.TREE_CROPS)
            context.register(treeCrop.getPlacedFeatureKey(), new PlacedFeature(lookup.getOrThrow(treeCrop.getConfiguredFeatureKey()), WorldGenFeatures.datagenModifierLists.get(treeCrop.getPlacedFeatureKey())));
        for (Tree tree : Tree.copy())
            context.register(tree.getPlacedFeatureKey(), new PlacedFeature(lookup.getOrThrow(tree.getConfiguredFeatureKey()), WorldGenFeatures.datagenModifierLists.get(tree.getPlacedFeatureKey())));
        context.register(PlacedFeatureKeys.DISK_SALT_PLACED_KEY, new PlacedFeature(lookup.getOrThrow(ConfiguredFeatureKeys.DISK_SALT_KEY), WorldGenFeatures.datagenModifierLists.get(PlacedFeatureKeys.DISK_SALT_PLACED_KEY)));
        context.register(PlacedFeatureKeys.RANDOM_CROP_KEY, new PlacedFeature(lookup.getOrThrow(ConfiguredFeatureKeys.RANDOM_CROP_KEY), WorldGenFeatures.datagenModifierLists.get(PlacedFeatureKeys.RANDOM_CROP_KEY)));
    }
}
