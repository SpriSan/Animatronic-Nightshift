package animatronicnightshift.entities;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.FreddyFazbear.FreddyFazbear;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class EntitiesRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AnimatronicNightshift.MODID);


    public static final RegistryObject<EntityType<FreddyFazbear>> FREDDY =
            ENTITY_TYPES.register("freddy", () -> EntityType.Builder.of(FreddyFazbear::new, MobCategory.MONSTER)
                    .sized(0.8f, 2f)
                    .build("freddy"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}