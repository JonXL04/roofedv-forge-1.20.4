package net.jonxl04.roofedv.item.custom;

import net.jonxl04.roofedv.particle.ModParticle;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class ShiftingSwordItem extends SwordItem {
    public ShiftingSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier ,Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        Vec3 posDifference = new Vec3(
                pAttacker.getX()-pTarget.getX(),
                pAttacker.getY()-pTarget.getY(),
                pAttacker.getZ()-pTarget.getZ());

        Vec3 oldMov = pAttacker.getDeltaMovement();

        pAttacker.randomTeleport(
                pTarget.getX()-posDifference.x*2,
                pTarget.getY()-posDifference.y*2,
                pTarget.getZ()-posDifference.z*2,
                true);
        pAttacker.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(pTarget.getX(),pTarget.getY(), pTarget.getZ()));
        pAttacker.resetFallDistance();
        pAttacker.hurtMarked = true;
        pAttacker.setDeltaMovement(oldMov);
        pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,5));
        pAttacker.level().addParticle(ModParticle.SLASH_PARTICLE.get(),
                pTarget.getX(), pTarget.getY(), pTarget.getZ(),
                0.0D, 0.0D, 0.0D);
        pAttacker.level().playSound((Player)null, pAttacker.getX(), pAttacker.getY(), pAttacker.getZ(),
                SoundEvents.PLAYER_TELEPORT, SoundSource.NEUTRAL, 1F,
                0.8F / (pAttacker.level().getRandom().nextFloat() * 0.4F + 0.8F));
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.on_hit.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.shifting_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.EPIC;
    }
}
