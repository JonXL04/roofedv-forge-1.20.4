package net.jonxl04.roofedv.effect;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class QuantumEntanglementEffect extends MobEffect {
    protected QuantumEntanglementEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    int stacks = 0;
    boolean last = false;
    float previousHurtTime = 0;

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.getLastHurtByMobTimestamp()!=previousHurtTime) {
            stacks = stacks + 1;
        }
        if(last) {
            if(stacks>pAmplifier+5)
                stacks = pAmplifier+5;
            pLivingEntity.hurt(pLivingEntity.damageSources().magic(),stacks * (2+pAmplifier));
            pLivingEntity.sendSystemMessage(Component.literal(stacks + " stacks, dealing " + (stacks * (2+pAmplifier))));
            stacks = 1;
        }
        previousHurtTime = pLivingEntity.getLastHurtByMobTimestamp();
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        if(pDuration <= 1)
            last = true;
        else
            last = false;
        return true;
    }
}
