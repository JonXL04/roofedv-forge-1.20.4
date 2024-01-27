package net.jonxl04.roofedv.datagen;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RoofedVMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SCRAP_BLOCK);
        blockWithItem(ModBlocks.SCRAP_PLATE_BLOCK);
        blockWithItem(ModBlocks.SCRAP_ORE);
        blockWithItem(ModBlocks.SCRAP_SAND);
        //blockWithItem(ModBlocks.SCRAP_SANDSTONE);
        //blockWithItem(ModBlocks.SCRAP_SMOOTH_SANDSTONE);
        //blockWithItem(ModBlocks.SCRAP_CUT_SANDSTONE);
        blockWithItem(ModBlocks.MERCHITE_BLOCK);
        blockWithItem(ModBlocks.MERCHITE_ORE);

        stairsBlock(((StairBlock) ModBlocks.SCRAP_SANDSTONE_STAIRS.get()), blockTexture(ModBlocks.SCRAP_SANDSTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.SCRAP_SANDSTONE_SLAB.get()), blockTexture(ModBlocks.SCRAP_SANDSTONE.get()), blockTexture(ModBlocks.SCRAP_SANDSTONE.get()));
        wallBlock(((WallBlock) ModBlocks.SCRAP_SANDSTONE_WALL.get()), blockTexture(ModBlocks.SCRAP_SANDSTONE.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
