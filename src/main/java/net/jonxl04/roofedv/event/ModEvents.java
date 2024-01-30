package net.jonxl04.roofedv.event;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.entity.ModEntities;
import net.jonxl04.roofedv.entity.custom.SpectatorEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RoofedVMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SPECTATOR.get(), SpectatorEntity.setAttributes());
    }
}
