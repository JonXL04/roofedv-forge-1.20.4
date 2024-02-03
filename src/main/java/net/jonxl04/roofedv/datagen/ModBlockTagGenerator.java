package net.jonxl04.roofedv.datagen;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.block.ModBlocks;
import net.jonxl04.roofedv.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RoofedVMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SCRAP_BLOCK.get(),
                        ModBlocks.SCRAP_ORE.get(),
                        ModBlocks.CUT_SCRAP.get(),
                        ModBlocks.SCRAP_PLATE_BLOCK.get(),
                        ModBlocks.SCRAP_CUT_SANDSTONE.get(),
                        ModBlocks.SCRAP_SANDSTONE.get(),
                        ModBlocks.SCRAP_SMOOTH_SANDSTONE.get(),
                        ModBlocks.MERCHITE_BLOCK.get(),
                        ModBlocks.MERCHITE_ORE.get(),
                        ModBlocks.MERCHITE_CRYSTAL.get(),
                        ModBlocks.MERCHITE_LAMP.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SCRAP_SAND.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SCRAP_BLOCK.get(),
                        ModBlocks.CUT_SCRAP.get(),
                        ModBlocks.SCRAP_ORE.get(),
                        ModBlocks.SCRAP_PLATE_BLOCK.get(),
                        ModBlocks.MERCHITE_BLOCK.get(),
                        ModBlocks.MERCHITE_ORE.get(),
                        ModBlocks.MERCHITE_LAMP.get(),
                        ModBlocks.MERCHITE_CRYSTAL.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SCRAP_SANDSTONE_WALL.get()
                );

        this.tag(ModTags.Blocks.METAL_SCRAPS)
                .add(ModBlocks.SCRAP_BLOCK.get(),
                        ModBlocks.SCRAP_PLATE_BLOCK.get(),
                        ModBlocks.CUT_SCRAP.get(),
                        ModBlocks.SCRAP_SAND.get(),
                        ModBlocks.SCRAP_CUT_SANDSTONE.get(),
                        ModBlocks.SCRAP_SANDSTONE.get(),
                        ModBlocks.SCRAP_SMOOTH_SANDSTONE.get(),
                        ModBlocks.SCRAP_ORE.get()
                );
    }
}
