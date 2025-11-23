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
                        "textures/entity/freddyfazbear_night.png");
            }
        }

        return new ResourceLocation(AnimatronicNightshift.MODID,
                "textures/entity/freddyfazbear.png");
    }

    @Override
    public void render(FreddyFazbear pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose(); // Sauvegarde l'état actuel

        float scale = 0.8f; // Valeur de scale, 2.0 = deux fois plus grand
        pMatrixStack.scale(scale, scale, scale); // Applique le scale

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        pMatrixStack.popPose(); // Restaure l'état
    }
}