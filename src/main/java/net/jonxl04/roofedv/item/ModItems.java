package net.jonxl04.roofedv.item;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.item.custom.FuelItem;
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

    public static final RegistryObject<Item> MERCHITE = ITEMS.register("merchite",
            () -> new FuelItem(new Item.Properties(),1800));

    public static final RegistryObject<Item> MERCHITE_SHARD = ITEMS.register("merchite_shard",
            () -> new FuelItem(new Item.Properties(),200));

    public static final RegistryObject<Item> SCRAP_SWORD = ITEMS.register("scrap_sword",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_THERATILLO_MEAT = ITEMS.register("raw_theratillo_meat",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_THERATILLO_MEAT)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
