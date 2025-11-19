package animatronicnightshift.event;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.EntityAnimatronic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, value = Dist.CLIENT)
public class JumpscareOverlay {

    public static boolean isActive;
    public static EntityAnimatronic animatronic;
    public static int ticks;

    public static void setAnimatronic(EntityAnimatronic entity) {
         animatronic = entity;
         animatronic.jumpscareAnimationState.start(animatronic.tickCount);

    }

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        if (!isActive) return;

        GuiGraphics gfx = event.getGuiGraphics();
        Minecraft mc = Minecraft.getInstance();

        
        drawEntityOnScreen(
                gfx,
                mc.getWindow().getGuiScaledWidth() / 2,
                mc.getWindow().getGuiScaledHeight() / 2 + 640,
                300,
                animatronic
        );

    }

    public static void drawEntityOnScreen(GuiGraphics gfx, int x, int y, int scale, LivingEntity entity) {
        PoseStack pose = gfx.pose();
        pose.pushPose();

        pose.translate(x, y, 105.0D);
        pose.scale(scale, scale, scale);
        pose.mulPose(new Quaternionf().rotateZ((float)Math.PI)); 

        // Rotation fixe de l'entité
        entity.yBodyRot = 0F; 
        entity.setYRot(180.0F);
        entity.setXRot(0.0F);

        // Rendu
        EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        dispatcher.setRenderShadow(false);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        dispatcher.render(entity, 0.0D, 0.0D, 0.0D, 0.0F, entity.tickCount, pose, buffer, 15728880);

        buffer.endBatch();
        dispatcher.setRenderShadow(true);

        pose.popPose();
    
    }
    
    
}
