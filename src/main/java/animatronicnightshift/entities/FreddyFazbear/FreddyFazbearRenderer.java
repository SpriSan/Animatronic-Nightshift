package animatronicnightshift.entities.FreddyFazbear;

import com.mojang.blaze3d.vertex.PoseStack;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class FreddyFazbearRenderer extends MobRenderer<FreddyFazbear, ModelFreddyFazbear<FreddyFazbear>> {
    public FreddyFazbearRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelFreddyFazbear<>(pContext.bakeLayer(LayersRegister.FREDDY_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(FreddyFazbear entity) {
        Level level = entity.level();
        if (level != null) {
            long time = level.getDayTime() % 24000L;
            boolean isNight = time >= 13000 && time <= 23000;

            if (isNight) {
                return new ResourceLocation(AnimatronicNightshift.MODID,
                        "textures/entity/freddyfazbear.png");
            }
        }

        return new ResourceLocation(AnimatronicNightshift.MODID,
                "textures/entity/freddyfazbear.png");
    }


    @Override
    public void render(FreddyFazbear pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.8f; // Valeur de scale
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