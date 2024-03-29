package net.jonxl04.roofedv;

import com.mojang.logging.LogUtils;
import net.jonxl04.roofedv.block.ModBlocks;
import net.jonxl04.roofedv.effect.ModEffects;
import net.jonxl04.roofedv.entity.ModEntities;
import net.jonxl04.roofedv.entity.client.SpectatorRenderer;
import net.jonxl04.roofedv.item.ModCreativeModeTabs;
import net.jonxl04.roofedv.item.ModItems;
import net.jonxl04.roofedv.loot.ModLootModifiers;
import net.jonxl04.roofedv.particle.ModParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RoofedVMod.MOD_ID)
public class RoofedVMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "roofedv";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public RoofedVMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        ModEffects.register(modEventBus);
        ModParticle.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    /*    if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }*/
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.SPECTATOR.get(), SpectatorRenderer::new);
        }
    }
}
