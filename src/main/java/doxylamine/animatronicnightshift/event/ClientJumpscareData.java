package doxylamine.animatronicnightshift.event;

import doxylamine.animatronicnightshift.entities.EntityAnimatronic;

public class ClientJumpscareData {
    public boolean active = false;
    public EntityAnimatronic animatronic = null;
    public EntityAnimatronic fake = null;

    public void reset() {
        active = false;
        animatronic = null;
        fake = null;
    }
}