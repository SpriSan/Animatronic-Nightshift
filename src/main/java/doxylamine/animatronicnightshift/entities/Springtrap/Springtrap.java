package doxylamine.animatronicnightshift.entities.Springtrap;

import java.util.ArrayList;

import doxylamine.animatronicnightshift.event.JumpscareOverlay;
import doxylamine.animatronicnightshift.items.freddymask.ItemFreddyMask;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class Springtrap extends Monster {

    private boolean isCrawling = false;

    public Springtrap(EntityType<? extends Springtrap> type, Level level) {
        super(type, level);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public final AnimationState jumpscareAnimationState = new AnimationState();
    public final AnimationState crawlingAnimationState = new AnimationState();

    double attackSpeed = 1.2D;

    @Override
    public boolean canStandOnFluid(FluidState fluidState) {
        return false;
    }

    private boolean shouldCrawl() {
        BlockPos pos = this.blockPosition();
        BlockPos currentHead = pos.above(1);
        boolean hasBlockAboveNow = !this.level().getBlockState(currentHead).isAir();

        if (hasBlockAboveNow) {
            return true;
        }

        if (this.getTarget() != null && this.getTarget().isAlive()) {
            Vec3 targetPos = this.getTarget().position();
            Vec3 currentPos = this.position();
            Vec3 direction = targetPos.subtract(currentPos).normalize();

            for (int distance = 1; distance <= 3; distance++) {
                BlockPos checkPos = pos.offset(
                        (int)Math.round(direction.x * distance),
                        0,
                        (int)Math.round(direction.z * distance)
                );

                boolean groundSolid = !this.level().getBlockState(checkPos.below()).isAir();
                boolean spaceOpen = this.level().getBlockState(checkPos).isAir();
                boolean lowCeiling = !this.level().getBlockState(checkPos.above()).isAir();

                if (groundSolid && spaceOpen && lowCeiling) {
                    return true;
                }

                if (!spaceOpen) {
                    break;
                }
            }
        }

        Vec3 movement = this.getDeltaMovement();
        if (movement.horizontalDistanceSqr() > 0.001) {
            Vec3 moveDirection = movement.normalize();

            for (int distance = 1; distance <= 2; distance++) {
                BlockPos checkPos = pos.offset(
                        (int)Math.round(moveDirection.x * distance),
                        0,
                        (int)Math.round(moveDirection.z * distance)
                );

                boolean groundSolid = !this.level().getBlockState(checkPos.below()).isAir();
                boolean spaceOpen = this.level().getBlockState(checkPos).isAir();
                boolean lowCeiling = !this.level().getBlockState(checkPos.above()).isAir();

                if (groundSolid && spaceOpen && lowCeiling) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void tick() {
        super.tick();

        boolean shouldCrawlNow = shouldCrawl();
        if (shouldCrawlNow != isCrawling) {
            setCrawling(shouldCrawlNow);
        }

        if (this.level().isClientSide()) {
            handleClientAnimations();
        }
    }

    private void handleClientAnimations() {
        if (isCrawling) {
            if (!crawlingAnimationState.isStarted()) {
                crawlingAnimationState.start(this.tickCount);
            }
            idleAnimationState.stop();
            idleAnimationTimeout = 0;
        } else {
            crawlingAnimationState.stop();
            setupAnimationStates();
        }
    }

    private void setCrawling(boolean crawling) {
        this.isCrawling = crawling;
        if (crawling) {
            this.setPose(Pose.SWIMMING);
        } else {
            this.setPose(Pose.STANDING);
        }
        this.refreshDimensions();
    }

    public boolean isCrawling() {
        return this.isCrawling;
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (pose == Pose.SWIMMING || isCrawling) {
            return EntityDimensions.scalable(0.6F, 0.6F);
        }
        return super.getDimensions(pose);
    }

    @Override
    public float maxUpStep() {
        return 0.6F;
    }

    @Override
    protected void pushEntities() {
        if (isCrawling) {
            return;
        }
        super.pushEntities();
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }

    protected void setupAnimationStates() {
        if (idleAnimationTimeout <= 0) {
            idleAnimationTimeout = 80;
            idleAnimationState.start(this.tickCount);
        } else {
            idleAnimationTimeout--;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = Math.min(pPartialTick * 6F, 1f);
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        return super.doHurtTarget(target);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, attackSpeed, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 35D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ATTACK_DAMAGE, 17);
    }

    @Nullable
    public SoundEvent getJumpscareSound() {
        return null;
    }
}