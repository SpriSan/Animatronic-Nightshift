package animatronicnightshift.items;

import java.rmi.registry.Registry;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.EntitiesRegister;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemsRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AnimatronicNightshift.MODID);

    public static final RegistryObject<Item> MONITOR = ITEMS.register("monitor",
                () -> new ItemCameraMonitor(new Item.Properties()));

        public static final RegistryObject<SpawnEggItem> FREDDY_FAZBEAR_SPAWN_EGG = ITEMS.register("freddy_fazbear_spawn_egg",
                () -> new ForgeSpawnEggItem(EntitiesRegister.FREDDY, 0x63340B, 0x48280C, new Item.Properties()));

        public static final RegistryObject<SpawnEggItem> BONNIE_SPAWN_EGG = ITEMS.register("bonnie_spawn_egg",
                () -> new ForgeSpawnEggItem(EntitiesRegister.BONNIE, 0x2A273C, 0x3F3A57, new Item.Properties()));

        public static final RegistryObject<SpawnEggItem> CHICA_SPAWN_EGG = ITEMS.register("chica_spawn_egg",
                () -> new ForgeSpawnEggItem(EntitiesRegister.CHICA, 0x89851B, 0x767321, new Item.Properties()));

        public static final RegistryObject<SpawnEggItem> FOXY_SPAWN_EGG = ITEMS.register("foxy_spawn_egg",
                () -> new ForgeSpawnEggItem(EntitiesRegister.FOXY, 0x89851B, 0x767321, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(FREDDY_FAZBEAR_SPAWN_EGG.get());
            event.accept(BONNIE_SPAWN_EGG.get());
            event.accept(CHICA_SPAWN_EGG.get());
        }
    }


}
