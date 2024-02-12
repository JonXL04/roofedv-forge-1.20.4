package net.jonxl04.roofedv.item.custom;

import net.jonxl04.roofedv.effect.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LeachingSwordItem extends SwordItem {
    public LeachingSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier , Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        pAttacker.heal(2*(0.625f-pAttacker.swingTime)/0.625f);

        pAttacker.level().playSound((Player)null, pAttacker.getX(), pAttacker.getY(), pAttacker.getZ(),
                SoundEvents.PLAYER_TELEPORT, SoundSource.NEUTRAL, 1F,
                0.8F / (pAttacker.level().getRandom().nextFloat() * 0.4F + 0.8F));
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.on_hit.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.leaching_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.EPIC;
    }
}
