package doxylamine.animatronicnightshift.entities.WitheredFreddy;

import doxylamine.animatronicnightshift.entities.EntityAnimatronic;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class WitheredFreddy extends EntityAnimatronic {
    public WitheredFreddy(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    public SoundEvent getJumpscareSound() {
        return SoundsRegister.FNAF2_JUMPSCARE.get();
    }
}
