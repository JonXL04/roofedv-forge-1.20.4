package net.jonxl04.roofedv.util;

import net.jonxl04.roofedv.RoofedVMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_SCRAPS = tag("metal_scrap_blocks");

        private static TagKey<net.minecraft.world.level.block.Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(RoofedVMod.MOD_ID,name));
        }
    }

    public static class Items {
        public static final TagKey<Item> METAL_SCRAPS = tag("metal_scrap_items");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(RoofedVMod.MOD_ID,name));
        }
    }
}
