package net.jonxl04.roofedv.event;

import net.jonxl04.roofedv.RoofedVMod;

import net.jonxl04.roofedv.particle.ModParticle;
import net.jonxl04.roofedv.particle.custom.SlashParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;


@Mod.EventBusSubscriber(modid = RoofedVMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticle.SLASH_PARTICLE.get(),
                SlashParticle.Provider::new);
    }
}
