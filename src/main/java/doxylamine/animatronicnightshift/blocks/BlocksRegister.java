package doxylamine.animatronicnightshift.blocks;

import java.util.function.Supplier;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.blocks.camera.BlockCamera;
import doxylamine.animatronicnightshift.items.ItemsRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlocksRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AnimatronicNightshift.MODID);

    public static final RegistryObject<Block> FLOOR_TILES = registerBlock("floor_tiles", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> CAMERA =
            registerBlock("security_camera",
                    () -> new BlockCamera(BlockBehaviour.Properties.of().noOcclusion().noCollission()));

    public static final RegistryObject<Block> CUPCAKE =
            registerBlock("cupcake",
                    () -> new BlockCupcake(BlockBehaviour.Properties.of().noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemsRegister.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    
}
