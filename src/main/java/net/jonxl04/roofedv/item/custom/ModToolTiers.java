package net.jonxl04.roofedv.item.custom;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SCRAP = TierSortingRegistry.registerTier(
            new ForgeTier(2, 180, 5.5f, 1.8f, 16,
                    BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.SCRAP_INGOT.get())),
            new ResourceLocation(RoofedVMod.MOD_ID, "scrap"), List.of(Tiers.STONE),List.of(Tiers.DIAMOND)
    );
    public static final Tier MECHASTEEL = TierSortingRegistry.registerTier(
            new ForgeTier(4, 4062, 8.5F, 4.0F, 18,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(ModItems.MECHASTEEL_INGOT.get())),
            new ResourceLocation(RoofedVMod.MOD_ID, "mechasteel"), List.of(Tiers.DIAMOND),List.of(Tiers.NETHERITE)
    );
}
