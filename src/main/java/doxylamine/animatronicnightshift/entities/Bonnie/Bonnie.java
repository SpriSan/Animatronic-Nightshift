package doxylamine.animatronicnightshift.entities.Bonnie;

import doxylamine.animatronicnightshift.entities.EntityAnimatronic;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Bonnie extends EntityAnimatronic {

    public Bonnie(EntityType<? extends Bonnie> type, Level level) { super(type, level); }

    protected SoundEvent getAmbientSound() {
        return SoundsRegister.BREATH.get();
    }
    
}
