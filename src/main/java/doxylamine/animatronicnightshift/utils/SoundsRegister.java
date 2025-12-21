package doxylamine.animatronicnightshift.utils;

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

    public static final RegistryObject<SoundEvent> FNAF2_JUMPSCARE = SOUND_EVENTS.register("jumpscare2",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "jumpscare2")));

    public static final RegistryObject<SoundEvent> MASK_PUT = SOUND_EVENTS.register("mask_put",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "mask_put")));

    public static final RegistryObject<SoundEvent> MASK_REMOVE = SOUND_EVENTS.register("mask_remove",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "mask_remove")));

    public static final RegistryObject<SoundEvent> MONITOR = SOUND_EVENTS.register("monitor",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "monitor")));

    public static final RegistryObject<SoundEvent> FOXY_SING = SOUND_EVENTS.register("foxy_sing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "foxy_sing")));

    public static final RegistryObject<SoundEvent> BREATH = SOUND_EVENTS.register("breath",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "breath")));

    public static final RegistryObject<SoundEvent> FREDDY_LAUGH = SOUND_EVENTS.register("freddy_laugh",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("animatronicnightshift", "freddy_laugh")));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}