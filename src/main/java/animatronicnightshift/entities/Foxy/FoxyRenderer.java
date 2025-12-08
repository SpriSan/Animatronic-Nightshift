package animatronicnightshift.entities.Foxy;

import com.mojang.blaze3d.vertex.PoseStack;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FoxyRenderer extends MobRenderer<Foxy, ModelFoxy<Foxy>> {
    public FoxyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelFoxy<>(pContext.bakeLayer(LayersRegister.FOXY_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Foxy pEntity) {
        return new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/foxy.png");
    }

    @Override
    public void render(Foxy pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.8f; // Valeur de scale, 2.0 = deux fois plus grand
        pMatrixStack.scale(scale, scale, scale); // Applique le scale

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        pMatrixStack.popPose(); // Restaure l'état
    }
}