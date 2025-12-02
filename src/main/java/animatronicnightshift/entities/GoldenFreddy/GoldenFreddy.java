package animatronicnightshift.entities.GoldenFreddy;

import java.util.ArrayList;
import animatronicnightshift.event.ClientJumpscareData;
import animatronicnightshift.event.ClientJumpscareManager;
import animatronicnightshift.event.JumpscareOverlay;
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

public class GoldenFreddy extends Monster {


    public GoldenFreddy(EntityType<? extends GoldenFreddy> type, Level level) {
        super(type, level);
    }




    @Override
    public void tick() {
        super.tick();

        }




    @Override
    protected void registerGoals() {


    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ATTACK_DAMAGE, 17);
    }



    @Override
    public void aiStep() {
        super.aiStep();

    }
}
