package net.jonxl04.roofedv.datagen;

import com.mojang.datafixers.optics.Forget;
import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.block.ModBlocks;
import net.jonxl04.roofedv.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RoofedVMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SCRAP_INGOT, "generated");
        simpleItem(ModItems.SCRAP_SHARDS,"generated");
        simpleItem(ModItems.SCRAP_SWORD,"handheld");
        simpleItem(ModItems.SCRAP_PICKAXE,"handheld");
        simpleItem(ModItems.SCRAP_SHOVEL,"handheld");
        simpleItem(ModItems.SCRAP_AXE,"handheld");
        simpleItem(ModItems.SCRAP_HOE,"handheld");
        simpleItem(ModItems.MERCHITE,"generated");
        simpleItem(ModItems.MERCHITE_SHARD,"generated");

        simplerBlockItem(ModBlocks.SCRAP_SANDSTONE_STAIRS);
        simplerBlockItem(ModBlocks.SCRAP_SANDSTONE_SLAB);
        wallItem(ModBlocks.SCRAP_SANDSTONE_WALL, ModBlocks.SCRAP_SANDSTONE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String type) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/" + type)).texture("layer0",
                new ResourceLocation(RoofedVMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private void simplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(RoofedVMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RoofedVMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(RoofedVMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
