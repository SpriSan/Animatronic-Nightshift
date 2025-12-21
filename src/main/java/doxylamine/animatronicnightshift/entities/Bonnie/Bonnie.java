package doxylamine.animatronicnightshift.entities.Bonnie;

import doxylamine.animatronicnightshift.entities.EntityAnimatronic;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class Bonnie extends EntityAnimatronic {

    public Bonnie(EntityType<? extends Bonnie> type, Level level) { super(type, level); }

    @Override
    protected void setupAnimationStates() {
        if (!this.level().isDay()) {
            idleAnimationState.stop();
            return;
        }

        if (idleAnimationTimeout <= 0) {
            idleAnimationTimeout = 87;
            idleAnimationState.start(this.tickCount);
        } else {
            idleAnimationTimeout--;
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundsRegister.BREATH.get();
    }

    public SoundEvent getJumpscareSound() {
        return SoundsRegister.FNAF1_JUMPSCARE.get();
    }
    
}
