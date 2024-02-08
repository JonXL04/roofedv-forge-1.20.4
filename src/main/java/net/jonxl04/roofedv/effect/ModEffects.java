package net.jonxl04.roofedv.effect;

import net.jonxl04.roofedv.RoofedVMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RoofedVMod.MOD_ID);

    public static final RegistryObject<MobEffect> QUANTUM_ENTANGLEMENT = MOB_EFFECTS.register("quantum_entanglement",
            () -> new QuantumEntanglementEffect(MobEffectCategory.HARMFUL, 5327291));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
