package doxylamine.animatronicnightshift.entities.ToyFreddy;

import doxylamine.animatronicnightshift.entities.EntityAnimatronic;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ToyFreddy extends EntityAnimatronic {
    public ToyFreddy(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    public SoundEvent getJumpscareSound() {
        return SoundsRegister.FNAF2_JUMPSCARE.get();
    }
}
