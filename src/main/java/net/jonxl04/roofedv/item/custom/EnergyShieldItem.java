package net.jonxl04.roofedv.item.custom;

import net.minecraft.core.particles.ParticleTypes;
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

public class EnergyShieldItem extends ShieldItem {
    public EnergyShieldItem(Properties pProperties, Float pMultiplier) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        int charge = 0;
        if(!pLevel.isClientSide()) {
            List <LivingEntity> area = getEntitiesInProximity(pPlayer, 4.5f, pLevel);
            //pPlayer.getCooldowns().addCooldown(this, 100);
            for(int i = 0; i < 20; ++i) {
                pLevel.addParticle(ParticleTypes.LARGE_SMOKE,
                        pPlayer.getRandomX(4.5D), pPlayer.getRandomY(), pPlayer.getRandomZ(4.5D),
                        0.0D, 0.0D, 0.0D);
            }
            while(!area.isEmpty()) {
                if (area.get(0) == pPlayer) {
                    area.remove(0);
                }
                else {
                    float distance = area.get(0).distanceTo(pPlayer) + 1;
                    area.get(0).hurt(pPlayer.damageSources().magic(), charge / distance);
                    area.get(0).addDeltaMovement(((
                            area.get(0).position().subtract(pPlayer.position())).normalize())
                            .add(0, 1, 0)
                            .multiply((3*charge) / (1.5*distance),
                                      (2*charge) / (1.5*distance),
                                      (3*charge) / (1.5*distance))
                    );
                    //pPlayer.sendSystemMessage(Component.literal("Targeted " + area.get(0).getType()));
                    area.remove(0);
                }
            }

            pPlayer.level().playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                    SoundEvents.ALLAY_HURT, SoundSource.NEUTRAL, 1F,
                    2.5F / (pPlayer.level().getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.on_use.tooltip"));
        pTooltipComponents.add(Component.translatable("tooltip.roofedv.radiant_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.EPIC;
    }

    public final List<LivingEntity> getEntitiesInProximity(LivingEntity entity, double radius, Level level) {
        Vec3 center = new Vec3(entity.position().x, entity.position().y, entity.position().z);
        List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, new AABB(center.subtract(new Vec3(radius,radius,radius)), center.add(new Vec3(radius, radius, radius))));
        return targets;
    }
}
