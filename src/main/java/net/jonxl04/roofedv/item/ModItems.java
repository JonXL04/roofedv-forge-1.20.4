package net.jonxl04.roofedv.item;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.item.custom.FuelItem;
import net.jonxl04.roofedv.item.custom.ModToolTiers;
import net.minecraft.world.item.*;
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
            () -> new SwordItem(ModToolTiers.SCRAP, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_PICKAXE = ITEMS.register("scrap_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SCRAP, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_SHOVEL = ITEMS.register("scrap_shovel",
            () -> new ShovelItem(ModToolTiers.SCRAP, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_AXE = ITEMS.register("scrap_axe",
            () -> new AxeItem(ModToolTiers.SCRAP, 6.2f, -3.05f, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_HOE = ITEMS.register("scrap_hoe",
            () -> new HoeItem(ModToolTiers.SCRAP, -2, -1.5f, new Item.Properties()));

    public static final RegistryObject<Item> SCRAP_HELMET = ITEMS.register("scrap_helmet",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_CHESTPLATE = ITEMS.register("scrap_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_LEGGINGS = ITEMS.register("scrap_leggings",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_BOOTS = ITEMS.register("scrap_boots",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> RAW_THERATILLO_MEAT = ITEMS.register("raw_theratillo_meat",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_THERATILLO_MEAT)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
