package animatronicnightshift.blocks.camera;

import animatronicnightshift.blocks.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CameraBlockEntity extends BlockEntity {

    public float animationTick = 0f;

    public CameraBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegister.CAMERA_BLOCK_ENTITY.get(), pos, state);
    }

    public void tickAnimation() {
        // incrémente le tick (ex: 20 ticks/sec)
        animationTick += 0.02f; 
        if (animationTick > 62.8f) {
            animationTick = 0f;
        }
    }
}
