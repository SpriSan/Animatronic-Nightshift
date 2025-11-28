package animatronicnightshift.entities.Chica;

import com.mojang.blaze3d.vertex.PoseStack;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ChicaRenderer extends MobRenderer<Chica, ModelChica<Chica>> {
    public ChicaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelChica<>(pContext.bakeLayer(LayersRegister.CHICA_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Chica pEntity) {
        return new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/chica.png");
    }

    @Override
    public void render(Chica pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.8f; // Valeur de scale, 2.0 = deux fois plus grand
        pMatrixStack.scale(scale, scale, scale); // Applique le scale

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        pMatrixStack.popPose(); // Restaure l'état
    }
}