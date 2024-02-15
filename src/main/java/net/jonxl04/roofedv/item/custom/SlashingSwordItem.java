package net.jonxl04.roofedv.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SlashingSwordItem extends SwordItem {
    public SlashingSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier , Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if(!pLevel.isClientSide()) {
            pPlayer.getCooldowns().addCooldown(this, 20);
            SmallFireball slash = new SmallFireball(pPlayer.level(),pPlayer,
                    pPlayer.getLookAngle().x,
                    pPlayer.getLookAngle().y,
                    pPlayer.getLookAngle().z);
            //slash.setItem(itemstack);
            slash.setPos(slash.getX(), pPlayer.getEyeY(), slash.getZ());
            slash.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(slash);

            itemstack.hurtAndBreak(1, pPlayer, (p_41288_) -> {
                p_41288_.broadcastBreakEvent(pHand);
            });

            pPlayer.level().playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                    SoundEvents.TRIDENT_THROW, SoundSource.NEUTRAL, 1F,
                    2F / (pPlayer.level().getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.on_use.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.slashing_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.EPIC;
    }
}