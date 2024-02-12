package net.jonxl04.roofedv.datagen;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.item.ModItems;
import net.jonxl04.roofedv.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, RoofedVMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("spectator_loot", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/spectator")).build()}, ModItems.SCRAP_SHARDS.get()));
    }
}
