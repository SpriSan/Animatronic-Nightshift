package animatronicnightshift.blocks;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.blocks.camera.CameraBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BlockEntityRegister {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AnimatronicNightshift.MODID);

    public static final RegistryObject<BlockEntityType<CameraBlockEntity>> CAMERA_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("camera_block_entity",
                    () -> BlockEntityType.Builder.of(
                            CameraBlockEntity::new,
                            BlocksRegister.CAMERA.get()
                    ).build(null)
            );
}
