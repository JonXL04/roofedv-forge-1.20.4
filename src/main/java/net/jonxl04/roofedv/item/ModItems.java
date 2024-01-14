package net.jonxl04.roofedv.item;

import net.jonxl04.roofedv.RoofedVMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RoofedVMod.MOD_ID);

    public static final RegistryObject<Item> SCRAP_INGOT = ITEMS.register("scrap_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SCRAP_SHARDS = ITEMS.register("scrap_shards",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SCRAP_SWORD = ITEMS.register("scrap_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MERCHITE = ITEMS.register("merchite",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
