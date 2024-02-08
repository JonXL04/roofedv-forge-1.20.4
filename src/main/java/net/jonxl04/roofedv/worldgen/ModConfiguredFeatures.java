package net.jonxl04.roofedv.worldgen;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERVOID_MERCHITE_ORE_KEY = registerKey("merchite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERVOID_SCRAP_ORE_KEY = registerKey("scrap_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deeplateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        /*List<OreConfiguration.TargetBlockState> overworldMerchiteOres = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.MERCHITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deeplateReplaceables, ModBlocks.MERCHITE_ORE.get().defaultBlockState()));*/
        //register(context, OVERWORLD_MERCHITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMerchiteOres, 5));

        register(context, OVERVOID_MERCHITE_ORE_KEY, Feature.ORE, new OreConfiguration(deeplateReplaceables,
                ModBlocks.MERCHITE_ORE.get().defaultBlockState(), 5));
        register(context, OVERVOID_SCRAP_ORE_KEY, Feature.ORE, new OreConfiguration(deeplateReplaceables,
                ModBlocks.SCRAP_ORE.get().defaultBlockState(), 18));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(RoofedVMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
