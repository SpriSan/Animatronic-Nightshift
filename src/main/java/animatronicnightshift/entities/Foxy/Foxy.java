package animatronicnightshift.entities.Foxy;

import animatronicnightshift.entities.EntityAnimatronic;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Foxy extends EntityAnimatronic {

    double attackSpeed = 2D;

    public Foxy(EntityType<? extends EntityAnimatronic> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean isMaskVulnerable() {
        return false;
    }

}
