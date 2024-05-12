package net.jonxl04.roofedv.item.custom;

import net.jonxl04.roofedv.particle.ModParticle;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class LightningSwordItem extends SwordItem {
    public LightningSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier , Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    int charges = 3;

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        boolean hit = false;
        if(!pLevel.isClientSide()) {
            Vec3 attackPos = pPlayer.position().add(pPlayer.getLookAngle().multiply(6,6,6));

            charges--;
            pPlayer.getCooldowns().addCooldown(this, 5);
            List<LivingEntity> area = getEntitiesInProximity(attackPos, 1.5f, pLevel);

            while (!area.isEmpty()) {
                if (area.get(0) == pPlayer) {
                    area.remove(0);
                } else {
                    hit = true;
                    float distance = area.get(0).distanceTo(pPlayer) + 1;
                    area.get(0).hurt(pPlayer.damageSources().magic(), 8);
                    area.get(0).addDeltaMovement(((
                            area.get(0).position().subtract(pPlayer.position())).normalize())
                            .add(0, 0.5, 0)
                            .multiply(1 / (distance),
                                      1 / (distance),
                                      1 / (distance))
                    );
                    //pPlayer.sendSystemMessage(Component.literal("Targeted " + area.get(0).getType()));
                    area.remove(0);
                }
            }
            if (hit) {
                itemstack.hurtAndBreak(1, pPlayer, (p_41288_) -> {
                    p_41288_.broadcastBreakEvent(pHand);
                });
                hit = false;
            }
            /*
            pPlayer.addDeltaMovement(new Vec3(
                    0,
                    -pPlayer.getDeltaMovement().y,
                    0));
            pPlayer.resetFallDistance();
            */

            pPlayer.level().playSound(null, attackPos.x, attackPos.y, attackPos.z,
                    SoundEvents.TRIDENT_THUNDER, SoundSource.NEUTRAL, 0.5F,
                    2.5F / (pPlayer.level().getRandom().nextFloat() * 0.4F + 0.8F));

            for (int i=5; i<0; i--){
            pLevel.addParticle(ModParticle.SLASH_PARTICLE.get(),
                    attackPos.x,
                    attackPos.y,
                    attackPos.z,
                    0, 0, 0);
            }

            if(charges<1) {
                charges = 3;
                pPlayer.getCooldowns().addCooldown(this, 100);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("§l§3" + charges + "/3⚡"));
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.on_use.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.lightning_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.EPIC;
    }

    public final List<LivingEntity> getEntitiesInProximity(Vec3 pos, double radius, Level level) {
        List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, new AABB(pos.subtract(new Vec3(radius,radius,radius)), pos.add(new Vec3(radius, radius, radius))));
        return targets;
    }
}
