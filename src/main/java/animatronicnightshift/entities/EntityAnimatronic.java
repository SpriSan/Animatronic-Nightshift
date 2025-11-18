package animatronicnightshift.entities;

import java.util.ArrayList;

import animatronicnightshift.gui.JumpscareScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class EntityAnimatronic extends Monster {

    private boolean goalsEnabled = true;

    // todo : effet de lenteur lors du jumpscare + cécité

    public EntityAnimatronic(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState jumpscareAnimationState = new AnimationState();


    private boolean isNightTime() {
        long time = this.level().getDayTime() % 24000L;
        return time >= 13000L && time <= 23000L; // nuit vanilla
        }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {

            boolean night = isNightTime();

            if (!night) {
                setupAnimationStates();
            } else {
                idleAnimationState.stop();
                idleAnimationTimeout = 0;
            }
        }

                boolean night = isNightTime();
        if (night && !goalsEnabled) {
            enableGoals();
        } else if (!night && goalsEnabled) {
            disableGoals();
        }

        if (level().isClientSide() && isNightTime()) {
            Player player = Minecraft.getInstance().player;
            if (player != null && this.distanceToSqr(player) < 2.1D && !player.isCreative()) {
                Minecraft.getInstance().setScreen(new JumpscareScreen(this));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 999, 30));
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 999, 2));
            }
        }

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
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes() // Use Monster instead of Animal
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.27D)
                .add(Attributes.ATTACK_DAMAGE, 9); 
    }

    private void clearGoals() {
        // Copie de la liste pour éviter ConcurrentModificationException
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

        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));


       this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
       this.targetSelector.addGoal(1,
       new net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal<>(this, Player.class, true));
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
