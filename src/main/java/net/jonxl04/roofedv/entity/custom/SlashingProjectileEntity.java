package net.jonxl04.roofedv.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;

public class SlashingProjectileEntity extends Projectile {
    public SlashingProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }






    @Override
    protected void defineSynchedData() {

    }
}
