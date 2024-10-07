package com.epherical.croptopia.datagen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.epherical.croptopia.CroptopiaMod.MODID;
import static com.epherical.croptopia.common.Tags.*;
import static com.epherical.croptopia.common.generator.PlacedFeatureKeys.*;

public class CroptopiaWorldBiomeSelection {
    public static final ResourceKey<BiomeModifier> ADD_ALMOND_TREE_TO_BIOMES = createKey("add_almond_to_biome");
    public static final ResourceKey<BiomeModifier> ADD_APPLE_TREE_TO_BIOMES = createKey("add_apple_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_APRICOT_TREE_TO_BIOMES = createKey("add_apricot_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_AVOCADO_TREE_TO_BIOMES = createKey("add_avocado_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BANANA_TREE_TO_BIOMES = createKey("add_banana_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CASHEW_TREE_TO_BIOMES = createKey("add_cashew_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CHERRY_TREE_TO_BIOMES = createKey("add_cherry_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_COCONUT_TREE_TO_BIOMES = createKey("add_coconut_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_DATE_TREE_TO_BIOMES = createKey("add_date_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_DRAGONFRUIT_TREE_TO_BIOMES = createKey("add_dragonfruit_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_FIG_TREE_TO_BIOMES = createKey("add_fig_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_GRAPEFRUIT_TREE_TO_BIOMES = createKey("add_grapefruit_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_KUMQUAT_TREE_TO_BIOMES = createKey("add_kumquat_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_LEMON_TREE_TO_BIOMES = createKey("add_lemon_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_LIME_TREE_TO_BIOMES = createKey("add_lime_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_MANGO_TREE_TO_BIOMES = createKey("add_mango_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_NECTARINE_TREE_TO_BIOMES = createKey("add_nectarine_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_NUTMEG_TREE_TO_BIOMES = createKey("add_nutmeg_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE_TREE_TO_BIOMES = createKey("add_orange_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PEACH_TREE_TO_BIOMES = createKey("add_peach_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PEAR_TREE_TO_BIOMES = createKey("add_pear_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PECAN_TREE_TO_BIOMES = createKey("add_pecan_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PERSIMMON_TREE_TO_BIOMES = createKey("add_persimmon_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PLUM_TREE_TO_BIOMES = createKey("add_plum_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_STARFRUIT_TREE_TO_BIOMES = createKey("add_starfruit_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_WALNUT_TREE_TO_BIOMES = createKey("add_walnut_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CINNAMON_TREE_TO_BIOMES = createKey("add_cinnamon_tree_to_biomes");


    public CroptopiaWorldBiomeSelection(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        new BiomeMod(context, biomes, placedFeatures, ALMOND_TREE_PLACED_KEY, ADD_ALMOND_TREE_TO_BIOMES, HAS_ALMOND);
        new BiomeMod(context, biomes, placedFeatures, APPLE_TREE_PLACED_KEY, ADD_APPLE_TREE_TO_BIOMES, HAS_APPLE);
        new BiomeMod(context, biomes, placedFeatures, APRICOT_TREE_PLACED_KEY, ADD_APRICOT_TREE_TO_BIOMES, HAS_APRICOT);
        new BiomeMod(context, biomes, placedFeatures, AVOCADO_TREE_PLACED_KEY, ADD_AVOCADO_TREE_TO_BIOMES, HAS_AVOCADO);
        new BiomeMod(context, biomes, placedFeatures, BANANA_TREE_PLACED_KEY, ADD_BANANA_TREE_TO_BIOMES, HAS_BANANA);
        new BiomeMod(context, biomes, placedFeatures, CASHEW_TREE_PLACED_KEY, ADD_CASHEW_TREE_TO_BIOMES, HAS_CASHEW);
        new BiomeMod(context, biomes, placedFeatures, CHERRY_TREE_PLACED_KEY, ADD_CHERRY_TREE_TO_BIOMES, HAS_CHERRY);
        new BiomeMod(context, biomes, placedFeatures, COCONUT_TREE_PLACED_KEY, ADD_COCONUT_TREE_TO_BIOMES, HAS_COCONUT);
        new BiomeMod(context, biomes, placedFeatures, DATE_TREE_PLACED_KEY, ADD_DATE_TREE_TO_BIOMES, HAS_DATE);
        new BiomeMod(context, biomes, placedFeatures, DRAGONFRUIT_TREE_PLACED_KEY, ADD_DRAGONFRUIT_TREE_TO_BIOMES, HAS_DRAGONFRUIT);
        new BiomeMod(context, biomes, placedFeatures, FIG_TREE_PLACED_KEY, ADD_FIG_TREE_TO_BIOMES, HAS_FIG);
        new BiomeMod(context, biomes, placedFeatures, GRAPEFRUIT_TREE_PLACED_KEY, ADD_GRAPEFRUIT_TREE_TO_BIOMES, HAS_GRAPEFRUIT);
        new BiomeMod(context, biomes, placedFeatures, KUMQUAT_TREE_PLACED_KEY, ADD_KUMQUAT_TREE_TO_BIOMES, HAS_KUMQUAT);
        new BiomeMod(context, biomes, placedFeatures, LEMON_TREE_PLACED_KEY, ADD_LEMON_TREE_TO_BIOMES, HAS_LEMON);
        new BiomeMod(context, biomes, placedFeatures, LIME_TREE_PLACED_KEY, ADD_LIME_TREE_TO_BIOMES, HAS_LIME);
        new BiomeMod(context, biomes, placedFeatures, MANGO_TREE_PLACED_KEY, ADD_MANGO_TREE_TO_BIOMES, HAS_MANGO);
        new BiomeMod(context, biomes, placedFeatures, NECTARINE_TREE_PLACED_KEY, ADD_NECTARINE_TREE_TO_BIOMES, HAS_NECTARINE);
        new BiomeMod(context, biomes, placedFeatures, NUTMEG_TREE_PLACED_KEY, ADD_NUTMEG_TREE_TO_BIOMES, HAS_NUTMEG);
        new BiomeMod(context, biomes, placedFeatures, ORANGE_TREE_PLACED_KEY, ADD_ORANGE_TREE_TO_BIOMES, HAS_ORANGE);
        new BiomeMod(context, biomes, placedFeatures, PEACH_TREE_PLACED_KEY, ADD_PEACH_TREE_TO_BIOMES, HAS_PEACH);
        new BiomeMod(context, biomes, placedFeatures, PEAR_TREE_PLACED_KEY, ADD_PEAR_TREE_TO_BIOMES, HAS_PEAR);
        new BiomeMod(context, biomes, placedFeatures, PECAN_TREE_PLACED_KEY, ADD_PECAN_TREE_TO_BIOMES, HAS_PECAN);
        new BiomeMod(context, biomes, placedFeatures, PERSIMMON_TREE_PLACED_KEY, ADD_PERSIMMON_TREE_TO_BIOMES, HAS_PERSIMMON);
        new BiomeMod(context, biomes, placedFeatures, PLUM_TREE_PLACED_KEY, ADD_PLUM_TREE_TO_BIOMES, HAS_PLUM);
        new BiomeMod(context, biomes, placedFeatures, STARFRUIT_TREE_PLACED_KEY, ADD_STARFRUIT_TREE_TO_BIOMES, HAS_STARFRUIT);
        new BiomeMod(context, biomes, placedFeatures, WALNUT_TREE_PLACED_KEY, ADD_WALNUT_TREE_TO_BIOMES, HAS_WALNUT);
        new BiomeMod(context, biomes, placedFeatures, CINNAMON_TREE_PLACED_KEY, ADD_CINNAMON_TREE_TO_BIOMES, HAS_CINNAMON);




    }


    public static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }

    public static class BiomeMod {
        public BiomeMod(BootstrapContext<BiomeModifier> modifier,
                        HolderGetter<Biome> biomeGetter, HolderGetter<PlacedFeature> feature,
                        ResourceKey<PlacedFeature> featureKey, ResourceKey<BiomeModifier> biomeModifier, TagKey<Biome> biomes) {
            modifier.register(biomeModifier,
                    new BiomeModifiers.AddFeaturesBiomeModifier(
                            biomeGetter.getOrThrow(biomes),
                            //HolderSet.direct(Stream.of(biomeTag).map(biomeGetter::getOrThrow).toList()),
                            HolderSet.direct(feature.getOrThrow(featureKey)),
                            GenerationStep.Decoration.VEGETAL_DECORATION
                    ));

        }

    }
}
