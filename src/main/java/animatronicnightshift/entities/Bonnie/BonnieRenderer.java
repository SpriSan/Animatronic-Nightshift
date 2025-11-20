package animatronicnightshift.entities.Bonnie;

import com.mojang.blaze3d.vertex.PoseStack;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.LayersRegister;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BonnieRenderer extends MobRenderer<Bonnie, ModelBonnie<Bonnie>> {
    public BonnieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ModelBonnie<>(pContext.bakeLayer(LayersRegister.BONNIE_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Bonnie pEntity) {
        return new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/bonnie.png");
    }

    @Override
    public void render(Bonnie pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.8f; // Valeur de scale, 2.0 = deux fois plus grand
        pMatrixStack.scale(scale, scale, scale); // Applique le scale

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        pMatrixStack.popPose(); // Restaure l'état
    }
}