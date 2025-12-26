package doxylamine.animatronicnightshift.entities;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.entities.Bonnie.Bonnie;
import doxylamine.animatronicnightshift.entities.Chica.Chica;
import doxylamine.animatronicnightshift.entities.Foxy.Foxy;
import doxylamine.animatronicnightshift.entities.FreddyFazbear.FreddyFazbear;
import doxylamine.animatronicnightshift.entities.GoldenFreddy.GoldenFreddy;
import doxylamine.animatronicnightshift.entities.Springtrap.Springtrap;
import doxylamine.animatronicnightshift.entities.ToyBonnie.ToyBonnie;
import doxylamine.animatronicnightshift.entities.ToyFreddy.ToyFreddy;
import doxylamine.animatronicnightshift.entities.WitheredFreddy.WitheredFreddy;
import doxylamine.animatronicnightshift.entities.WitheredFreddy.WitheredFreddyRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;

public class EntitiesRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AnimatronicNightshift.MODID);


    public static final RegistryObject<EntityType<FreddyFazbear>> FREDDY =
            ENTITY_TYPES.register("freddy", () -> EntityType.Builder.of(FreddyFazbear::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.5f)
                    .build("freddy"));

    public static final RegistryObject<EntityType<Bonnie>> BONNIE =
            ENTITY_TYPES.register("bonnie", () -> EntityType.Builder.of(Bonnie::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.5f)
                    .build("bonnie"));  

    public static final RegistryObject<EntityType<Chica>> CHICA =
            ENTITY_TYPES.register("chica", () -> EntityType.Builder.of(Chica::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.5f)
                    .build("chica"));

    public static final RegistryObject<EntityType<GoldenFreddy>> GOLDEN_FREDDY =
            ENTITY_TYPES.register("golden_freddy", () -> EntityType.Builder.of(GoldenFreddy::new, MobCategory.MONSTER)
                    .sized(0.8f, 1.4f)
                    .build("golden_freddy"));

    public static final RegistryObject<EntityType<Foxy>> FOXY =
            ENTITY_TYPES.register("foxy", () -> EntityType.Builder.of(Foxy::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.5f)
                    .build("foxy"));

    public static final RegistryObject<EntityType<ToyFreddy>> TOY_FREDDY =
            ENTITY_TYPES.register("toy_freddy", () -> EntityType.Builder.of(ToyFreddy::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.5f)
                    .build("toy_freddy"));

    public static final RegistryObject<EntityType<ToyBonnie>> TOY_BONNIE =
            ENTITY_TYPES.register("toy_bonnie", () -> EntityType.Builder.of(ToyBonnie::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.5f)
                    .build("toy_bonnie"));

    public static final RegistryObject<EntityType<Springtrap>> SPRINGTRAP =
            ENTITY_TYPES.register("springtrap", () -> EntityType.Builder.of(Springtrap::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.5f)
                    .build("springtrap"));

    public static final RegistryObject<EntityType<WitheredFreddy>> WITHERED_FREDDY =
            ENTITY_TYPES.register("withered_freddy", () -> EntityType.Builder.of(WitheredFreddy::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.8f)
                    .build("withered_freddy"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}