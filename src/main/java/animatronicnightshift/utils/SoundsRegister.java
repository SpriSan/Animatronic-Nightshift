package animatronicnightshift.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SoundsRegister {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, "animatronicnightshift");

    public static final RegistryObject<SoundEvent> FNAF1_JUMPSCARE = SOUND_EVENTS.register("jumpscare1",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "jumpscare1")));

    public static final RegistryObject<SoundEvent> MASK_PUT = SOUND_EVENTS.register("mask_put",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "mask_put")));

    public static final RegistryObject<SoundEvent> MASK_REMOVE = SOUND_EVENTS.register("mask_remove",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "mask_remove")));

    public static final RegistryObject<SoundEvent> MONITOR = SOUND_EVENTS.register("monitor",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "monitor")));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}