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


    private static final JumpscareOverlay INSTANCE = new JumpscareOverlay();
    public static JumpscareOverlay get() { return INSTANCE; }

    private EntityAnimatronic source;
    private EntityAnimatronic fake;
    private boolean active = false;

    public void trigger(EntityAnimatronic anim) {
        this.source = anim;
        this.active = true;
        this.fake = null; 
    }

    public void stop() {
        this.active = false;
        this.source = null;
        this.fake = null;
    }

    
    
    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        JumpscareOverlay self = get();

                if (!self.active || self.source == null) return;

                Minecraft mc = Minecraft.getInstance();
                GuiGraphics gfx = event.getGuiGraphics();

                // Créer un fake si besoin
                if (self.fake == null)
                    self.fake = createFake(self.source);

                if (self.fake == null) return;

                self.fake.tickCount += 1;

                drawEntityOnScreen(
                        gfx,
                        mc.getWindow().getGuiScaledWidth() / 2,
                        mc.getWindow().getGuiScaledHeight() / 2 + 640,
                        300,
                        self.fake,
                        self.source
                );
            }

        private static EntityAnimatronic createFake(EntityAnimatronic original) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return null;

            EntityAnimatronic f = (EntityAnimatronic) original.getType().create(mc.level);
            if (f == null) return null;

            f.jumpscareAnimationState.start(original.tickCount);
            return f;
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
        dispatcher.render(fake, 0.0D, 0.0D, 0.0D, 0.0F, fake.tickCount, pose, buffer, 15728880);


        buffer.endBatch();

        pose.popPose();
    }
    
    
}
