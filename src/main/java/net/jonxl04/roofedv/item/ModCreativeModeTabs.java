package net.jonxl04.roofedv.item;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RoofedVMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ROOFED_VOID_ITEMS_TAB = CREATIVE_MODE_TABS.register("roofedv_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCRAP_INGOT.get()))
                    .title(Component.translatable("creativetab.roofedv_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.SCRAP_ORE.get());
                        pOutput.accept(ModBlocks.MERCHITE_ORE.get());

                        pOutput.accept(ModBlocks.SCRAP_SAND.get());
                        pOutput.accept(ModBlocks.SCRAP_SANDSTONE.get());
                        pOutput.accept(ModBlocks.SCRAP_CUT_SANDSTONE.get());
                        pOutput.accept(ModBlocks.SCRAP_SMOOTH_SANDSTONE.get());
                        pOutput.accept(ModBlocks.SCRAP_SANDSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.SCRAP_SANDSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.SCRAP_SANDSTONE_WALL.get());

                        pOutput.accept(ModBlocks.SCRAP_BLOCK.get());
                        pOutput.accept(ModBlocks.CUT_SCRAP.get());
                        pOutput.accept(ModBlocks.SCRAP_PLATE_BLOCK.get());
                        pOutput.accept(ModItems.SCRAP_INGOT.get());
                        pOutput.accept(ModItems.SCRAP_SHARDS.get());
                        pOutput.accept(ModBlocks.MERCHITE_BLOCK.get());
                        pOutput.accept(ModBlocks.MERCHITE_CRYSTAL.get());
                        pOutput.accept(ModItems.MERCHITE.get());
                        pOutput.accept(ModItems.MERCHITE_FRAGMENT.get());
                        pOutput.accept(ModItems.MERCHITE_SHARD.get());
                        pOutput.accept(ModItems.MECHASTEEL_INGOT.get());
                        pOutput.accept(ModItems.MECHANICAL_SCRAP.get());
                        pOutput.accept(ModBlocks.MERCHITE_LAMP.get());

                        pOutput.accept(ModItems.SCRAP_SWORD.get());
                        pOutput.accept(ModItems.SCRAP_PICKAXE.get());
                        pOutput.accept(ModItems.SCRAP_SHOVEL.get());
                        pOutput.accept(ModItems.SCRAP_AXE.get());
                        pOutput.accept(ModItems.SCRAP_HOE.get());
                        pOutput.accept(ModItems.MECHASTEEL_SWORD.get());
                        pOutput.accept(ModItems.MECHASTEEL_PICKAXE.get());
                        pOutput.accept(ModItems.MECHASTEEL_SHOVEL.get());
                        pOutput.accept(ModItems.MECHASTEEL_AXE.get());
                        pOutput.accept(ModItems.MECHASTEEL_HOE.get());
                        pOutput.accept(ModItems.SHIFTING_SABERBLADE.get());
                        pOutput.accept(ModItems.SLASHING_SABERBLADE.get());
                        pOutput.accept(ModItems.QUANTUM_SABERBLADE.get());
                        pOutput.accept(ModItems.SCRAP_HELMET.get());
                        pOutput.accept(ModItems.SCRAP_CHESTPLATE.get());
                        pOutput.accept(ModItems.SCRAP_LEGGINGS.get());
                        pOutput.accept(ModItems.SCRAP_BOOTS.get());


                        pOutput.accept(ModItems.SPECTATOR_SPAWN_EGG.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
