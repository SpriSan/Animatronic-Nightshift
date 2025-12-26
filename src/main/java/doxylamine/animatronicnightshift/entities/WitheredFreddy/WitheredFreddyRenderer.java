package doxylamine.animatronicnightshift.entities.WitheredFreddy;

import com.mojang.blaze3d.vertex.PoseStack;
import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.entities.Chica.Chica;
import doxylamine.animatronicnightshift.entities.Chica.ModelChica;
import doxylamine.animatronicnightshift.entities.GoldenFreddy.GoldenFreddy;
import doxylamine.animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class WitheredFreddyRenderer extends MobRenderer<WitheredFreddy, ModelWitheredFreddy<WitheredFreddy>> {
    public WitheredFreddyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelWitheredFreddy<>(pContext.bakeLayer(LayersRegister.WITHERED_FREDDY_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(WitheredFreddy pEntity) {
        return new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/witheredfreddy.png");
    }

    @Override
    public void render(WitheredFreddy pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.85f; // Valeur de scale, 2.0 = deux fois plus grand
        pMatrixStack.scale(scale, scale, scale); // Applique le scale

        if (pEntity.isCrawling()) {
            // Translate vers le haut (point de pivot)
            pMatrixStack.translate(0.0D, 0.7D, 0.0D);

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