package net.jonxl04.roofedv.entity;

import net.jonxl04.roofedv.RoofedVMod;
import net.jonxl04.roofedv.entity.custom.SpectatorEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RoofedVMod.MOD_ID);

    public static final RegistryObject<EntityType<SpectatorEntity>> SPECTATOR =
            ENTITY_TYPES.register("spectator",
                    () -> EntityType.Builder.of(SpectatorEntity::new, MobCategory.MONSTER)
                            .sized(0.5f,0.5f)
                            .build(new ResourceLocation(RoofedVMod.MOD_ID, "spectator").toString()));

    /*public static final RegistryObject<EntityType<SlashingProjectileEntity>> SLASHING_PROJECTILE =
            ENTITY_TYPES.register("slashing_projectile",
                    () -> EntityType.Builder.<SlashingProjectileEntity>of(SlashingProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f,0.5f)
                            .build("slashing_projectile"));*/

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}