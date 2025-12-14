package animatronicnightshift.entities;

import java.util.ArrayList;
import animatronicnightshift.event.ClientJumpscareData;
import animatronicnightshift.event.ClientJumpscareManager;
import animatronicnightshift.event.JumpscareOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class EntityAnimatronic extends Monster {

    private boolean goalsEnabled = true;
    private boolean isCrawling = false;

    public EntityAnimatronic(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState jumpscareAnimationState = new AnimationState();
    public final AnimationState crawlingAnimationState = new AnimationState();

    double attackSpeed = 1.2D;

    private boolean isNightTime() {
        long time = this.level().getDayTime() % 24000L;
        return time >= 13000L && time <= 23000L;
    }

    // Vérifie si l'animatronic doit ramper
    private boolean shouldCrawl() {
        if (!isNightTime()) return false;

        // Position actuelle et direction du mouvement
        BlockPos pos = this.blockPosition();
        Vec3 motion = this.getDeltaMovement();

        // Vérifie l'espace au-dessus de la tête (1 bloc au-dessus)
        BlockPos aboveHead = pos.above(1);
        boolean hasBlockAbove = !this.level().isEmptyBlock(aboveHead);

        // Vérifie également en avant si l'entité se déplace
        if (motion.horizontalDistanceSqr() > 0.001) {
            Vec3 lookVec = this.getLookAngle();
            BlockPos frontPos = pos.offset((int)Math.signum(lookVec.x), 0, (int)Math.signum(lookVec.z));
            BlockPos frontAbove = frontPos.above(1);

            boolean hasFrontBlockAbove = !this.level().isEmptyBlock(frontAbove);
            boolean hasFrontSpace = this.level().isEmptyBlock(frontPos);

            // Doit ramper si : bloc au-dessus OU (bloc devant en haut ET espace devant)
            if (hasFrontBlockAbove && hasFrontSpace) {
                return true;
            }
        }

        return hasBlockAbove;
    }

    @Override
    public void tick() {
        super.tick();

        if (isNightTime()) enableGoals();

        // Gestion du rampement
        boolean shouldCrawlNow = shouldCrawl();
        if (shouldCrawlNow != isCrawling) {
            setCrawling(shouldCrawlNow);
        }

        if (this.level().isClientSide()) {
            boolean night = isNightTime();

            if (!night) {
                setupAnimationStates();
            } else {
                idleAnimationState.stop();
                idleAnimationTimeout = 0;
            }

            // Animation de rampement
            if (isCrawling) {
                if (!crawlingAnimationState.isStarted()) {
                    crawlingAnimationState.start(this.tickCount);
                }
            } else {
                crawlingAnimationState.stop();
            }
        }

        boolean night = isNightTime();
        if (night && !goalsEnabled) {
            enableGoals();
        } else if (!night && goalsEnabled) {
            disableGoals();
        }

        if (!level().isClientSide()) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        if (this.distanceTo(player) < 1.8F && !player.isDeadOrDying() && !player.isCreative() && isNightTime()) {
            JumpscareOverlay.get().trigger(this);
        } else {
            JumpscareOverlay.get().stop();
        }
    }

    private void setCrawling(boolean crawling) {
        this.isCrawling = crawling;
        if (crawling) {
            this.setPose(Pose.SWIMMING); // Utilise la pose de nage pour réduire la hitbox
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
        // Hitbox réduite en rampant (similaire à un joueur qui rampe)
        if (pose == Pose.SWIMMING || isCrawling) {
            return EntityDimensions.scalable(0.6F, 0.6F);
        }
        return super.getDimensions(pose);
    }

    private void setupAnimationStates() {
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
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new AnimatronicAttackGoal(this, attackSpeed, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
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
    public void aiStep() {
        super.aiStep();

        boolean night = isNightTime();
        if (night && !goalsEnabled) {
            enableGoals();
        } else if (!night && goalsEnabled) {
            disableGoals();
        }
    }
}