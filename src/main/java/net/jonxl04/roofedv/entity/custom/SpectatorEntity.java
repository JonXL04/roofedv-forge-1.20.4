package net.jonxl04.roofedv.entity.custom;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.EnumSet;

public class SpectatorEntity extends Monster implements GeoEntity, FlyingAnimal {
    private static final int ORBIT_RADIUS = 2;
    private static final int ORBIT_RADIUS_DANGER = 5;
    private boolean dangerDetected = false;
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SpectatorEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.xpReward = 2;
    }


    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.6f)
                .add(Attributes.FLYING_SPEED, 1.2f)
                .add(Attributes.FOLLOW_RANGE, 32.0f)
                .build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this,1.2,20.0F));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class,12.0F));
        this.goalSelector.addGoal(4, new SpectatorEntity.WanderAroundGoal(this));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,"controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    static class WanderAroundGoal extends Goal {
        private final SpectatorEntity spectator;

        public WanderAroundGoal(SpectatorEntity pSpectator) {
            this.spectator = pSpectator;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            MoveControl movecontrol = this.spectator.getMoveControl();
            if (!movecontrol.hasWanted()) {
                return true;
            } else {
                double d0 = movecontrol.getWantedX() - this.spectator.getX();
                double d1 = movecontrol.getWantedY() - this.spectator.getY();
                double d2 = movecontrol.getWantedZ() - this.spectator.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void start() {
            RandomSource randomsource = this.spectator.getRandom();
            double d0 = this.spectator.getX() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.spectator.getY() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.spectator.getZ() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.spectator.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
        }
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 0.25F;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public boolean isFlying() {
        return true;
    }
}
