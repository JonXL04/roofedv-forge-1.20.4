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
                        pOutput.accept(ModItems.SCRAP_INGOT.get());
                        pOutput.accept(ModItems.SCRAP_SHARDS.get());
                        pOutput.accept(ModItems.SCRAP_SWORD.get());
                        pOutput.accept(ModItems.MERCHITE.get());

                        pOutput.accept(ModBlocks.SCRAP_BLOCK.get());
                        pOutput.accept(ModBlocks.SCRAP_PLATE_BLOCK.get());
                        pOutput.accept(ModBlocks.SCRAP_ORE.get());
                        pOutput.accept(ModBlocks.MERCHITE_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
