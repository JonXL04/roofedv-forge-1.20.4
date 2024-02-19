package net.jonxl04.roofedv.item;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.entity.ModEntities;
import net.jonxl04.roofedv.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
    public static final RegistryObject<Item> MERCHITE_FRAGMENT = ITEMS.register("merchite_fragment",
            () -> new FuelItem(new Item.Properties(),800));

    public static final RegistryObject<Item> MECHASTEEL_INGOT = ITEMS.register("mechasteel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MECHANICAL_SCRAP = ITEMS.register("mechanical_scrap",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SCRAP_PLATE = ITEMS.register("scrap_plate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MECHASTEEL_PLATE = ITEMS.register("mechasteel_plate",
            () -> new Item(new Item.Properties()));

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

    public static final RegistryObject<Item> SHIFTING_SABERBLADE = ITEMS.register("shifting_saberblade",
            () -> new ShiftingSwordItem(ModToolTiers.MECHASTEEL, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> QUANTUM_SABERBLADE = ITEMS.register("quantum_saberblade",
            () -> new QuantumSwordItem(ModToolTiers.MECHASTEEL, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> LEACHING_SABERBLADE = ITEMS.register("leaching_saberblade",
            () -> new LeachingSwordItem(ModToolTiers.MECHASTEEL, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> SLASHING_SABERBLADE = ITEMS.register("slashing_saberblade",
            () -> new SlashingSwordItem(ModToolTiers.MECHASTEEL, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> RADIANT_SABERBLADE = ITEMS.register("radiant_saberblade",
            () -> new RadiantSwordItem(ModToolTiers.MECHASTEEL, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> LIGHTNING_SABERBLADE = ITEMS.register("lightning_saberblade",
            () -> new LightningSwordItem(ModToolTiers.MECHASTEEL, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> MECHASTEEL_SWORD = ITEMS.register("mechasteel_sword",
            () -> new SwordItem(ModToolTiers.MECHASTEEL, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> MECHASTEEL_PICKAXE = ITEMS.register("mechasteel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MECHASTEEL, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> MECHASTEEL_SHOVEL = ITEMS.register("mechasteel_shovel",
            () -> new ShovelItem(ModToolTiers.MECHASTEEL, 1.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> MECHASTEEL_AXE = ITEMS.register("mechasteel_axe",
            () -> new AxeItem(ModToolTiers.MECHASTEEL, 5.5f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> MECHASTEEL_HOE = ITEMS.register("mechasteel_hoe",
            () -> new HoeItem(ModToolTiers.MECHASTEEL, -4, 0f, new Item.Properties()));

    public static final RegistryObject<Item> SCRAP_HELMET = ITEMS.register("scrap_helmet",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_CHESTPLATE = ITEMS.register("scrap_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_LEGGINGS = ITEMS.register("scrap_leggings",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_BOOTS = ITEMS.register("scrap_boots",
            () -> new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.BOOTS, new Item.Properties()));

    /*public static final RegistryObject<Item> RAW_THERATILLO_MEAT = ITEMS.register("raw_theratillo_meat",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_THERATILLO_MEAT)));*/

    public static final RegistryObject<Item> SPECTATOR_SPAWN_EGG = ITEMS.register("spectator_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPECTATOR, 0x5e5e5e, 0x57eeff, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
