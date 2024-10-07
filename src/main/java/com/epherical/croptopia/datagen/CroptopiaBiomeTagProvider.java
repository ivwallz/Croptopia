package com.epherical.croptopia.datagen;

import com.epherical.croptopia.common.Tags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static com.epherical.croptopia.CroptopiaMod.MODID;
import static net.minecraft.world.level.biome.Biomes.*;


public class CroptopiaBiomeTagProvider extends TagsProvider<Biome> {


    public CroptopiaBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
                                     @Nullable ExistingFileHelper existingFileHelper) {
        super(output, Registries.BIOME, provider, MODID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(Tags.HAS_ARTICHOKE)
                .add(SWAMP)
                .addOptional(key("byg:cypress_swamplands"))
                .addOptional(key("byg:white_mangrove_marshes"))
                .addOptional(key("terralith:mirage_isles"))
                .addOptional(key("terralith:orchid_swamp"))
                .addOptional(key("biomesoplenty:marsh"))
                .addOptional(key("biomesoplenty:bayou"))
                .addOptional(key("biomesoplenty:bog"));
        tag(Tags.HAS_ASPARAGUS)
                .add(SWAMP)
                .addOptional(key("terralith:mirage_isles"))
                .addOptional(key("terralith:orchid_swamp"))
                .addOptional(key("biomesoplenty:marsh"))
                .addOptional(key("biomesoplenty:bayou"))
                .addOptional(key("biomesoplenty:bog"));
        tag(Tags.HAS_BARLEY)
                .add(PLAINS, SUNFLOWER_PLAINS, OLD_GROWTH_PINE_TAIGA, OLD_GROWTH_SPRUCE_TAIGA, TAIGA, SNOWY_TAIGA)
                .addOptional(key("terralith:blooming_plateau"))
                .addOptional(key("terralith:blooming_valley"))
                .addOptional(key("terralith:highlands"))
                .addOptional(key("terralith:steppe"))
                .addOptional(key("terralith:valley_clearing"))
                .addOptional(key("biomesoplenty:bog"))
                .addOptional(key("biomesoplenty:coniferous_forest"))
                .addOptional(key("biomesoplenty:field"));
        tag(Tags.HAS_BASIL)
                .add(JUNGLE, SPARSE_JUNGLE, BAMBOO_JUNGLE)
                .addOptional(key("terralith:jungle_mountains"))
                .addOptional(key("terralith:rocky_jungle"))
                .addOptional(key("terralith:tropical_jungle"))
                .addOptional(key("biomesoplenty:floodplain"))
                .addOptional(key("biomesoplenty:fungal_jungle"))
                .addOptional(key("biomesoplenty:rainforest"))
                .addOptional(key("biomesoplenty:rocky_rainforest"));
        tag(Tags.HAS_BELLPEPPER)
                .add(PLAINS, SUNFLOWER_PLAINS)
                .addOptional(key("terralith:blooming_plateau"))
                .addOptional(key("terralith:blooming_valley"))
                .addOptional(key("terralith:highlands"))
                .addOptional(key("terralith:steppe"))
                .addOptional(key("terralith:valley_clearing"))
                .addOptional(key("biomesoplenty:bog"))
                .addOptional(key("biomesoplenty:coniferous_forest"))
                .addOptional(key("biomesoplenty:field"))
                .addOptional(key("biomesoplenty:fir_cleaning"));
        tag(Tags.HAS_BLACKBEAN)
                .add(FOREST, FLOWER_FOREST, BIRCH_FOREST, DARK_FOREST, OLD_GROWTH_BIRCH_FOREST, GROVE)
                .addOptional(key("terralith:birch_taiga"))
                .addOptional(key("terralith:cloud_forest"))
                .addOptional(key("terralith:lavender_forest"))
                .addOptional(key("terralith:lavender_valley"))
                .addOptional(key("terralith:moonlight_grove"))
                .addOptional(key("terralith:moonlight_valley"))
                .addOptional(key("terralith:temperate_highlands"))
                .addOptional(key("biomesoplenty:bog"))
                .addOptional(key("biomesoplenty:coniferous_forest"))
                .addOptional(key("biomesoplenty:field"))
                .addOptional(key("biomesoplenty:fir_cleaning"))
                .addOptional(key("biomesoplenty:maple_woods"))
                .addOptional(key("biomesoplenty:tundra"))
                .addOptional(key("biomesoplenty:bamboo_grove"))
                .addOptional(key("biomesoplenty:cherry_blossom_grove"))
                .addOptional(key("biomesoplenty:mediterranean_forest"))
                .addOptional(key("biomesoplenty:mystic_grove"))
                .addOptional(key("biomesoplenty:orchard"))
                .addOptional(key("biomesoplenty:pumpkin_patch"))
                .addOptional(key("biomesoplenty:redwood_forest"))
                .addOptional(key("biomesoplenty:seasonal_forest"))
                .addOptional(key("biomesoplenty:seasonal_orchard"))
                .addOptional(key("biomesoplenty:woodland"));
        tag(Tags.HAS_BLACKBERRY)
                .add(FOREST, FLOWER_FOREST, BIRCH_FOREST, DARK_FOREST, OLD_GROWTH_BIRCH_FOREST, OLD_GROWTH_PINE_TAIGA,
                        OLD_GROWTH_SPRUCE_TAIGA, TAIGA, SNOWY_TAIGA, GROVE)
                .addOptional(key("byg:aspen_forest"))
                .addOptional(key("byg:black_forest"))
                .addOptional(key("byg:borealis_grove"))
                .addOptional(key("byg:cherry_blossom_forest"))
                .addOptional(key("byg:cika_woods"))
                .addOptional(key("byg:coniferous_forest"))
                .addOptional(key("byg:ebony_woods"))
                .addOptional(key("byg:forgotten_forest"))
                .addOptional(key("byg:maple_taiga"))
                .addOptional(key("byg:red_oak_forest"))
                .addOptional(key("byg:autumnal_forest"))
                .addOptional(key("byg:autumnal_taiga"))
                .addOptional(key("byg:redwood_thicket"))
                .addOptional(key("byg:frosted_taiga"))
                .addOptional(key("byg:frosted_coniferous_forest"))
                .addOptional(key("byg:fragment_forest"))
                .addOptional(key("byg:twilight_meadow"))
                .addOptional(key("byg:weeping_witch_forest"))
                .addOptional(key("byg:temperate_rainforest"))
                .addOptional(key("byg:zelkova_forest"))
                .addOptional(key("terralith:alpine_grove"))
                .addOptional(key("terralith:alpine_highlands"))
                .addOptional(key("terralith:birch_taiga"))
                .addOptional(key("terralith:cloud_forest"))
                .addOptional(key("terralith:forested_highlands"))
                .addOptional(key("terralith:lavender_forest"))
                .addOptional(key("terralith:lavender_valley"))
                .addOptional(key("terralith:lush_valley"))
                .addOptional(key("terralith:moonlight_grove"))
                .addOptional(key("terralith:moonlight_valley"))
                .addOptional(key("terralith:siberian_grove"))
                .addOptional(key("terralith:siberian_taiga"))
                .addOptional(key("terralith:snowy_maple_forest"))
                .addOptional(key("terralith:snowy_shield"))
                .addOptional(key("terralith:temperate_highlands"))
                .addOptional(key("terralith:yosemite_lowlands"))
                .addOptional(key("biomesoplenty:bamboo_grove"))
                .addOptional(key("biomesoplenty:cherry_blossom_grove"))
                .addOptional(key("biomesoplenty:mediterranean_forest"))
                .addOptional(key("biomesoplenty:mystic_grove"))
                .addOptional(key("biomesoplenty:orchard"))
                .addOptional(key("biomesoplenty:pumpkin_patch"))
                .addOptional(key("biomesoplenty:redwood_forest"))
                .addOptional(key("biomesoplenty:seasonal_forest"))
                .addOptional(key("biomesoplenty:seasonal_orchard"))
                .addOptional(key("biomesoplenty:woodland"))
                .addOptional(key("biomesoplenty:bog"))
                .addOptional(key("biomesoplenty:coniferous_forest"))
                .addOptional(key("biomesoplenty:field"))
                .addOptional(key("biomesoplenty:fir_cleaning"))
                .addOptional(key("biomesoplenty:maple_woods"))
                .addOptional(key("biomesoplenty:tundra"));



    }

    private static ResourceLocation key(String name) {
        return ResourceLocation.parse(name);
    }


    private static ResourceLocation bygID(String name) {
        return ResourceLocation.fromNamespaceAndPath("byg", name);
    }

    private static ResourceLocation bopID(String name) {
        return ResourceLocation.fromNamespaceAndPath("biomesoplenty", name);
    }
}
