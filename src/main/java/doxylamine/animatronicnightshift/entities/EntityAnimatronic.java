package doxylamine.animatronicnightshift.entities;

import java.util.ArrayList;

import doxylamine.animatronicnightshift.event.JumpscareOverlay;
import doxylamine.animatronicnightshift.items.freddymask.ItemFreddyMask;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class EntityAnimatronic extends Monster {

    private boolean goalsEnabled = false; // Changé à false par défaut
    private boolean isCrawling = false;
    private boolean initializedGoals = false; // Nouveau flag pour vérifier l'initialisation

    public EntityAnimatronic(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public final AnimationState jumpscareAnimationState = new AnimationState();
    public final AnimationState crawlingAnimationState = new AnimationState();

    double attackSpeed = 1.2D;

    protected boolean isNightTime() {
        long time = this.level().getDayTime() % 24000L;
        return time >= 15000L && time <= 23000L;
    }

    @Override
    public boolean canStandOnFluid(FluidState fluidState) {
        return false;
    }

    public boolean isMaskVulnerable() {
        return true;
    }

    private boolean shouldCrawl() {
        if (!isNightTime()) return false;

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

        boolean night = isNightTime();

        // Initialisation au premier tick
        if (!initializedGoals) {
            initializedGoals = true;
            if (night) {
                enableGoals();
            } else {
                disableGoals();
            }
        }

        // Gestion normale après initialisation
        if (night && !goalsEnabled) {
            enableGoals();
        } else if (!night && goalsEnabled) {
            disableGoals();
        }


        boolean shouldCrawlNow = shouldCrawl();
        if (shouldCrawlNow != isCrawling) {
            setCrawling(shouldCrawlNow);
        }


        if (this.level().isClientSide()) {
            handleClientAnimations(night);
        }

        if (this.level().isClientSide()) {

            Player player = Minecraft.getInstance().player;
            if (player == null || player.isDeadOrDying()) {
                JumpscareOverlay.get().stop();
                return;
            }

            JumpscareOverlay overlay = JumpscareOverlay.get();

            if (this.distanceTo(player) < 1.2F && !player.isCreative() && night && !overlay.isActive() && !ItemFreddyMask.isPlayerUsingMask(player)) {

                overlay.trigger(this);
            }

        } else {

            Player nearestPlayer = this.level().getNearestPlayer(this, 1.2D);

            if (nearestPlayer != null && !nearestPlayer.isDeadOrDying() &&
                    !nearestPlayer.isCreative() && night && !ItemFreddyMask.isPlayerUsingMask(nearestPlayer) && isMaskVulnerable()) {


                nearestPlayer.addEffect(new MobEffectInstance(
                        MobEffects.MOVEMENT_SLOWDOWN,
                        40,
                        5,
                        false,
                        false,
                        true
                ));

                nearestPlayer.addEffect(new MobEffectInstance(
                        MobEffects.BLINDNESS,
                        40,
                        0,
                        false,
                        false,
                        true
                ));


                if (this.tickCount % 40 == 0) {
                    nearestPlayer.hurt(this.damageSources().mobAttack(this), 17.0F);
                }
            }
        }
    }

    private void handleClientAnimations(boolean night) {

        if (isCrawling) {
            if (!crawlingAnimationState.isStarted()) {
                crawlingAnimationState.start(this.tickCount);
            }
            idleAnimationState.stop();
            idleAnimationTimeout = 0;
        } else {
            crawlingAnimationState.stop();

            if (night) {
                idleAnimationState.stop();
                idleAnimationTimeout = 0;
            } else {
                setupAnimationStates();
            }
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
        if (!this.level().isDay()) {
            idleAnimationState.stop();
            return;
        }

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
    protected void registerGoals() {

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 35D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ATTACK_DAMAGE, 17);
    }

    private void clearGoals() {
        new ArrayList<>(this.goalSelector.getAvailableGoals()).forEach(wrappedGoal ->
                this.goalSelector.removeGoal(wrappedGoal.getGoal())
        );

        new ArrayList<>(this.targetSelector.getAvailableGoals()).forEach(wrappedGoal ->
                this.targetSelector.removeGoal(wrappedGoal.getGoal())
        );
    }

    private void disableGoals() {
        clearGoals();
        this.goalsEnabled = false;
        this.getNavigation().stop();
        this.setDeltaMovement(0, this.getDeltaMovement().y, 0);
    }

    private void enableGoals() {
        this.goalsEnabled = true;
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new AnimatronicAttackGoal(this, attackSpeed, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (!isNightTime()) {
            return null;
        }
        return super.getAmbientSound();
    }

    @Override
    public int getAmbientSoundInterval() {
        if (!isNightTime()) {
            return Integer.MAX_VALUE;
        }

        return 200;
    }

    @Override
    public void playAmbientSound() {
        if (!isNightTime()) {
            return;
        }
        super.playAmbientSound();
    }

    @Override
    public void aiStep() {
        super.aiStep();

        boolean night = isNightTime();
        if (night && !goalsEnabled) {
            enableGoals();
        } else if (!night && goalsEnabled) {
            disableGoals();
        }
    }

    public SoundEvent getJumpscareSound() {
        return null;
    }
}