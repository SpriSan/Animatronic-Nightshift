package doxylamine.animatronicnightshift.entities.GoldenFreddy;

import com.mojang.blaze3d.vertex.PoseStack;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GoldenFreddyRenderer extends MobRenderer<GoldenFreddy, ModelGoldenFreddy<GoldenFreddy>> {
    public GoldenFreddyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelGoldenFreddy<>(pContext.bakeLayer(LayersRegister.GOLDEN_FREDDY_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenFreddy pEntity) {
        return new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/goldenfreddy.png");
    }

    @Override
    public void render(GoldenFreddy pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.8f; // Valeur de scale, 2.0 = deux fois plus grand
        pMatrixStack.scale(scale, scale, scale); // Applique le scale

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        pMatrixStack.popPose(); // Restaure l'état
    }
}