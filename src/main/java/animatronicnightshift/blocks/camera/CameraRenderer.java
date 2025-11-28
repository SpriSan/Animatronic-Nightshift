package animatronicnightshift.blocks.camera;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class CameraRenderer implements BlockEntityRenderer<CameraBlockEntity> {

    private final ModelCamera model;

    public CameraRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new ModelCamera(ctx.bakeLayer(LayersRegister.CAMERA_LAYER));
    }

    @Override
    public void render(CameraBlockEntity be, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {

        be.tickAnimation();

        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);

        Direction dir = be.getBlockState().getValue(Camera.FACING);
        poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot()));

        poseStack.scale(1f, -1f, -1f);


        float angle = (float) Math.sin(be.animationTick / 10f) * 0.74f; // rotation en radian
        model.bone2.yRot = angle;

        model.renderToBuffer(
            poseStack,
            buffer.getBuffer(RenderType.entityCutout(ModelCamera.getTextureLocation())),
            light, overlay, 1,1,1,1
        );

        poseStack.popPose();
    }


    
}
