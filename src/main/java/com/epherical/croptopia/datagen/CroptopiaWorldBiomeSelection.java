package com.epherical.croptopia.datagen;

import com.epherical.croptopia.common.generator.PlacedFeatureKeys;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.stream.Stream;

import static com.epherical.croptopia.CroptopiaMod.MODID;

public class CroptopiaWorldBiomeSelection {


    public static final ResourceKey<BiomeModifier> ADD_ALMOND_TREE_TO_BIOMES = createKey("add_apple_to_biome");


    public CroptopiaWorldBiomeSelection(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        new BiomeModification(context, biomes, placedFeatures, PlacedFeatureKeys.ALMOND_TREE_PLACED_KEY, ADD_ALMOND_TREE_TO_BIOMES,
                Biomes.DARK_FOREST, bygID("weeping_witch_forest"), bygID("dacite_ridges"), bygID("ebony_woods"), bygID("maple_taiga"),
                bygID("twilight_meadow"));


    }


    public static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }


    private static ResourceKey<Biome> bygID(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("byg", name));
    }


    public static class BiomeModification {


        public BiomeModification(BootstrapContext<BiomeModifier> modifier,
                                 HolderGetter<Biome> biomeGetter, HolderGetter<PlacedFeature> feature,
                                 ResourceKey<PlacedFeature> featureKey, ResourceKey<BiomeModifier> biomeModifier, ResourceKey<Biome>... biomeTag) {
            modifier.register(biomeModifier,
                    new BiomeModifiers.AddFeaturesBiomeModifier(
                            HolderSet.direct(Stream.of(biomeTag).map(biomeGetter::getOrThrow).toList()),
                            HolderSet.direct(feature.getOrThrow(featureKey)),
                            GenerationStep.Decoration.VEGETAL_DECORATION
                    ));

        }

    }
}
