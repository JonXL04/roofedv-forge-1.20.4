package net.jonxl04.roofedv.item.custom;

import com.mojang.blaze3d.shaders.Effect;
import net.jonxl04.roofedv.effect.ModEffects;
import net.jonxl04.roofedv.effect.QuantumEntanglementEffect;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class QuantumSwordItem extends SwordItem {
    public QuantumSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier , Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        pTarget.addEffect(new MobEffectInstance(ModEffects.QUANTUM_ENTANGLEMENT.get(),100));

        pAttacker.level().playSound((Player)null, pAttacker.getX(), pAttacker.getY(), pAttacker.getZ(),
                SoundEvents.BEACON_DEACTIVATE, SoundSource.NEUTRAL, 1F,
                3F / (pAttacker.level().getRandom().nextFloat() * 0.4F + 0.8F));
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.on_hit.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.quantum_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.EPIC;
    }
}
