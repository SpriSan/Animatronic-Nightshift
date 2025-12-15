package doxylamine.animatronicnightshift.event;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.entities.LayersRegister;
import doxylamine.animatronicnightshift.items.ItemsRegister;
import doxylamine.animatronicnightshift.items.freddymask.ModelFreddyMask;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class FreddyMaskHandler {

    // Texture du modèle - à créer dans assets/modid/textures/entity/custom_model.png
    private static final ResourceLocation TEXTURE = new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/freddyfazbear.png");
    private static ModelFreddyMask model;

    @SubscribeEvent
    public static void onRenderPlayer(RenderPlayerEvent.Post event) {
        Player player = event.getEntity();

        // Vérifie si le joueur utilise l'item (clic droit maintenu)
        if (!player.isUsingItem() || !player.getUseItem().is(ItemsRegister.FREDDY_MASK.get())) {
            return;
        }

        // Initialise le modèle si nécessaire
        if (model == null) {
            model = new ModelFreddyMask(Minecraft.getInstance().getEntityModels().bakeLayer(LayersRegister.FREDDY_MASK_LAYER));
        }

        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource buffer = event.getMultiBufferSource();
        int packedLight = event.getPackedLight();

        poseStack.pushPose();

        poseStack.translate(0, 1.5, 0);


        poseStack.mulPose(Axis.YP.rotationDegrees(-player.yHeadRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(player.getXRot()));


        poseStack.translate(0, 0.95, 0);


        poseStack.mulPose(Axis.XP.rotationDegrees(180));


        poseStack.scale(1.05F, 1.05F, 1.05F);

        var vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();
    }
}