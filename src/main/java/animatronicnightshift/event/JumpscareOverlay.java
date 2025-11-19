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
    private static EntityAnimatronic fake;

    public static void setAnimatronic(EntityAnimatronic entity) {
         animatronic = entity;
    }

@SubscribeEvent
public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
    if (!isActive || animatronic == null) return;

    GuiGraphics gfx = event.getGuiGraphics();
    Minecraft mc = Minecraft.getInstance();

    // Crée le fake seulement une fois
    if (fake == null) {
        fake = createFakeAnimatronic(animatronic);
    }

    drawEntityOnScreen(
            gfx,
            mc.getWindow().getGuiScaledWidth() / 2,
            mc.getWindow().getGuiScaledHeight() / 2 + 640,
            300,
            fake,
            animatronic
    );
}

    public static EntityAnimatronic createFakeAnimatronic(EntityAnimatronic original) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || original == null) return null;

        EntityAnimatronic fake = (EntityAnimatronic) original.getType().create(mc.level);
        if (fake == null) return null;

        fake.setPos(0, 0, 0);

        fake.jumpscareAnimationState.start(original.tickCount);

        return fake;
    }


    public static void drawEntityOnScreen(GuiGraphics gfx, int x, int y, int scale, LivingEntity fake, LivingEntity original) {
        PoseStack pose = gfx.pose();
        pose.pushPose();
        pose.translate(x, y, 105.0D);
        pose.scale(scale, scale, scale);
        pose.mulPose(new Quaternionf().rotateZ((float)Math.PI)); 


        // Rendu
        EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        dispatcher.setRenderShadow(false);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        dispatcher.render(fake, 0.0D, 0.0D, 0.0D, 0.0F, original.tickCount, pose, buffer, 15728880);


        buffer.endBatch();

        pose.popPose();
    }
    
    
}
