package animatronicnightshift.gui;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;

import animatronicnightshift.entities.EntityAnimatronic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class JumpscareScreen extends Screen{

    private final EntityAnimatronic animatronic;
    private int ticks;
    private boolean animationStarted = false;

    public JumpscareScreen(EntityAnimatronic animatronic) {
        super(Component.literal("Jumpscare"));
        this.animatronic = animatronic;
    }

    @Override
    protected void init() {
        super.init();

        animatronic.jumpscareAnimationState.start(animatronic.tickCount);

    }

    @Override
    public void tick() {
        super.tick();


        if (!animationStarted) {
            animatronic.jumpscareAnimationState.start(animatronic.tickCount);
            animationStarted = true;
        }


        animatronic.tick();


        ticks++;
        if (ticks >= 80 || !Minecraft.getInstance().player.isAlive() || !animatronic.isAlive()) {
            Minecraft.getInstance().setScreen(null);
        }
    }

    public static void drawEntityOnScreen(GuiGraphics gfx, int x, int y, int scale, LivingEntity entity) {

        float f = (float)Math.atan((double)(40.0F));
        float f1 = (float)Math.atan((double)(40.0F));

        PoseStack pose = gfx.pose();

        pose.pushPose();
        pose.translate(x, y, 50.0D);
        pose.scale(scale, scale, scale);
        pose.mulPose(new Quaternionf().rotateZ((float)Math.PI));

        Quaternionf qx = new Quaternionf().rotateX(f1 * 00.0F * (float)(Math.PI / 180.0));
        pose.mulPose(qx);

        float oldBody = entity.yBodyRot;
        float oldYRot = entity.getYRot();
        float oldXRot = entity.getXRot();

        entity.yBodyRot = 0F;
        entity.setYRot(180.0F + f * 40.0F);
        entity.setXRot(-f1 * 20.0F);

        EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        qx.conjugate();
        dispatcher.overrideCameraOrientation(qx);
        dispatcher.setRenderShadow(false);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        dispatcher.render(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, pose, buffer, 15728880);

        buffer.endBatch();
        dispatcher.setRenderShadow(true);

        entity.yBodyRot = oldBody;
        entity.setYRot(oldYRot);
        entity.setXRot(oldXRot);

        pose.popPose();
    }
    



    @Override
    public void render(GuiGraphics gfx, int mouseX, int mouseY, float partialTicks) {

            // Dessiner ton mob
            drawEntityOnScreen(
                    gfx,
                    this.width / 2,
                    this.height / 2 + 750,
                    350,
                    animatronic
            );

        super.render(gfx, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false; 
    }
        
}
