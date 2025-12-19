package doxylamine.animatronicnightshift.utils;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.blocks.BlocksRegister;
import doxylamine.animatronicnightshift.items.ItemsRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AnimatronicNightshift.MODID);

    //comment j'appelle le creative tab même ???
    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_TABS.register("animatronic_nightshift",
        () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(ItemsRegister.FREDDY_MASK.get()))
                .title(Component.translatable("creativetab.animatronicnightshift.tab"))
                .displayItems((parameters, output) -> {
                    // Ajoute tous tes items ici
                    output.accept(ItemsRegister.FREDDY_FAZBEAR_SPAWN_EGG.get());
                    output.accept(ItemsRegister.BONNIE_SPAWN_EGG.get());
                    output.accept(ItemsRegister.CHICA_SPAWN_EGG.get());
                    output.accept(ItemsRegister.GOLDEN_FREDDY_SPAWN_EGG.get());
                    output.accept(ItemsRegister.FOXY_SPAWN_EGG.get());
                    output.accept(ItemsRegister.MONITOR.get());
                    output.accept(BlocksRegister.FLOOR_TILES.get());
                    output.accept(BlocksRegister.WALL_TILES.get());
                    output.accept(BlocksRegister.CAMERA.get());
                    output.accept(BlocksRegister.CUPCAKE.get());
                    output.accept(ItemsRegister.FREDDY_MASK.get());
                })
                .build());

}
