package doxylamine.animatronicnightshift.entities.GoldenFreddy;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
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
