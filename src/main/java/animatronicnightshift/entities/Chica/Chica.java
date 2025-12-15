package animatronicnightshift.entities.Chica;

import animatronicnightshift.entities.EntityAnimatronic;
import animatronicnightshift.utils.SoundsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Chica extends EntityAnimatronic {

    public Chica(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    protected SoundEvent getAmbientSound() {
        return SoundsRegister.BREATH.get();
    }
    
}
