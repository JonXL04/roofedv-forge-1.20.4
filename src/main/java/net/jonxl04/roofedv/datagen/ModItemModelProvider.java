package net.jonxl04.roofedv.datagen;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RoofedVMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SCRAP_INGOT);
        simpleItem(ModItems.SCRAP_SHARDS);
        simpleItem(ModItems.MERCHITE);
        simpleItem(ModItems.MERCHITE_SHARD);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RoofedVMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
