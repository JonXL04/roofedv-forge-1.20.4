package net.jonxl04.roofedv.entity.custom;

import net.jonxl04.roofedv.entity.ModEntities;
import net.jonxl04.roofedv.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class SlashingProjectileEntity extends ThrowableItemProjectile {
    public SlashingProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SlashingProjectileEntity(Level pLevel) {
        super(ModEntities.SLASHING_PROJECTILE.get(), pLevel);
    }

    public SlashingProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SLASHING_PROJECTILE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SLASHING_SABERBLADE.get();
    }



    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
    }
}
