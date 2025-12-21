package doxylamine.animatronicnightshift.entities.FreddyFazbear;

import doxylamine.animatronicnightshift.entities.EntityAnimatronic;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class FreddyFazbear extends EntityAnimatronic {

        public FreddyFazbear(EntityType<? extends FreddyFazbear> type, Level level) {
            super(type, level);
        }

        protected SoundEvent getAmbientSound() {
        return SoundsRegister.FREDDY_LAUGH.get();
    }

    public SoundEvent getJumpscareSound() {
        return SoundsRegister.FNAF1_JUMPSCARE.get();
    }
}
