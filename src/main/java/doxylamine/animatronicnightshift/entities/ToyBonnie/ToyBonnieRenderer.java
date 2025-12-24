package doxylamine.animatronicnightshift.entities.ToyBonnie;

import com.mojang.blaze3d.vertex.PoseStack;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ToyBonnieRenderer extends MobRenderer<ToyBonnie, ModelToyBonnie<ToyBonnie>> {
    public ToyBonnieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelToyBonnie<>(pContext.bakeLayer(LayersRegister.TOY_BONNIE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ToyBonnie pEntity) {
        return new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/toybonnie.png");
    }

    @Override
    public void render(ToyBonnie pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.8f; // Valeur de scale, 2.0 = deux fois plus grand
        pMatrixStack.scale(scale, scale, scale); // Applique le scale

        if (pEntity.isCrawling()) {
            // Translate vers le haut (point de pivot)
            pMatrixStack.translate(0.0D, 0.6D, 0.0D);

            // IMPORTANT: D'abord appliquer la rotation Y (direction de l'entité)
            pMatrixStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(-pEntityYaw));

            // Ensuite rotation de 90° sur l'axe X (penche l'entité horizontalement)
            pMatrixStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(80.0F));

            // Re-appliquer le yaw pour garder l'orientation
            pMatrixStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(pEntityYaw));

            // Translate pour ajuster au sol
            pMatrixStack.translate(0.0D, -1D, 0D);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        pMatrixStack.popPose(); // Restaure l'état
    }
}