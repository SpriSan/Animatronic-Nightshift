package doxylamine.animatronicnightshift.entities.Chica;

import doxylamine.animatronicnightshift.entities.EntityAnimatronic;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Chica extends EntityAnimatronic {

    public Chica(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    @Override
    protected void setupAnimationStates() {
        if (!this.level().isDay()) {
            idleAnimationState.stop();
            return;
        }

        if (idleAnimationTimeout <= 0) {
            idleAnimationTimeout = 77;
            idleAnimationState.start(this.tickCount);
        } else {
            idleAnimationTimeout--;
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundsRegister.BREATH.get();
    }
    
}
