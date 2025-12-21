package doxylamine.animatronicnightshift.event;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.entities.EntitiesRegister;
import doxylamine.animatronicnightshift.entities.Bonnie.Bonnie;
import doxylamine.animatronicnightshift.entities.Chica.Chica;
import doxylamine.animatronicnightshift.entities.Foxy.Foxy;
import doxylamine.animatronicnightshift.entities.FreddyFazbear.FreddyFazbear;
import doxylamine.animatronicnightshift.entities.GoldenFreddy.GoldenFreddy;
import doxylamine.animatronicnightshift.entities.ToyFreddy.ToyFreddy;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntitiesRegister.FREDDY.get(), FreddyFazbear.createAttributes().build());;
        event.put(EntitiesRegister.BONNIE.get(), Bonnie.createAttributes().build());;
        event.put(EntitiesRegister.CHICA.get(), Chica.createAttributes().build());;
        event.put(EntitiesRegister.GOLDEN_FREDDY.get(), GoldenFreddy.createAttributes().build());;
        event.put(EntitiesRegister.FOXY.get(), Foxy.createAttributes().build());;
        event.put(EntitiesRegister.TOY_FREDDY.get(), ToyFreddy.createAttributes().build());;

    }
}
