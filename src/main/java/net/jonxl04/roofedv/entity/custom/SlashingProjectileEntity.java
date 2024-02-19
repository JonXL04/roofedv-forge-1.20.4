package net.jonxl04.roofedv.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class SlashingProjectileEntity extends Projectile {
    public SlashingProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void onHitEntity(EntityHitResult pResult) {
        
    }





    @Override
    protected void defineSynchedData() {

    }
}
