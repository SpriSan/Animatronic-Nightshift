package animatronicnightshift.items;

import java.rmi.registry.Registry;

import animatronicnightshift.AnimatronicNightshift;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AnimatronicNightshift.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    
}
