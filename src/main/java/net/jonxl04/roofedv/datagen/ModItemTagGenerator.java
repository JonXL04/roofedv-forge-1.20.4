package net.jonxl04.roofedv.datagen;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.item.ModItems;
import net.jonxl04.roofedv.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, RoofedVMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SCRAP_HELMET.get(),
                        ModItems.SCRAP_CHESTPLATE.get(),
                        ModItems.SCRAP_LEGGINGS.get(),
                        ModItems.SCRAP_BOOTS.get());
        this.tag(ModTags.Items.PLATES)
                .add(ModItems.COPPER_PLATE.get(),
                        ModItems.IRON_PLATE.get(),
                        ModItems.SCRAP_PLATE.get(),
                        ModItems.MECHASTEEL_PLATE.get()
                );
    }
}
