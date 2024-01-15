package net.jonxl04.roofedv.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModFoods {
    public static final FoodProperties RAW_THERATILLO_MEAT = new FoodProperties.Builder().meat().nutrition(4)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.POISON,80,1),0.6f).build();
}
