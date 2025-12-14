package animatronicnightshift.event;

import animatronicnightshift.utils.SoundsRegister;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import org.joml.Quaternionf;
import com.mojang.blaze3d.vertex.PoseStack;
import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.EntityAnimatronic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
    private boolean damageDealt = false; // Nouveau flag
    private long lastTriggerTime = 0;

    private float partialTick = 0;
    private long startTime = 0;
    private static final long JUMPSCARE_DURATION_MS = 2000;
    private static final long COOLDOWN_MS = 5000;

    public boolean isActive() {
        return this.active;
    }

    public void trigger(EntityAnimatronic anim) {
        if (this.active) return;

        long now = System.currentTimeMillis();

        if (now - lastTriggerTime < COOLDOWN_MS) return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || player.isDeadOrDying()) return;

        this.source = anim;
        this.active = true;
        this.fake = null;
        this.damageDealt = false; // Reset le flag
        this.startTime = System.nanoTime();
        this.lastTriggerTime = now;

        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(
                        SoundsRegister.FNAF1_JUMPSCARE.get(),
                        1.0F,
                        1.0F
                )
        );


    }

    public void stop() {
        this.active = false;
        this.source = null;
        this.damageDealt = false;
        if (this.fake != null) {
            this.fake.discard();
            this.fake = null;
        }

        Minecraft.getInstance().getSoundManager().stop(
                SimpleSoundInstance.forUI(
                        SoundsRegister.FNAF1_JUMPSCARE.get(),
                        1.0F,
                        1.0F
                )
        );
    }

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        JumpscareOverlay self = get();

        if (!self.active || self.source == null) return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null || player.isDeadOrDying() || self.source.isRemoved()) {
            self.stop();
            return;
        }

        GuiGraphics gfx = event.getGuiGraphics();

        long now = System.nanoTime();
        long elapsedMs = (now - self.startTime) / 1_000_000;

        if (elapsedMs > JUMPSCARE_DURATION_MS) {
            self.stop();
            return;
        }

        if (self.fake == null) {
            self.fake = createFake(self.source);
            if (self.fake == null) {
                self.stop();
                return;
            }
        }

        double elapsedSeconds = elapsedMs / 1000.0;
        double ticks = elapsedSeconds * 20.0;

        int wholeTicks = (int) ticks;
        float partial = (float) (ticks - wholeTicks);

        self.fake.tickCount = wholeTicks;
        self.partialTick = partial;

        drawEntityOnScreen(
                gfx,
                mc.getWindow().getGuiScaledWidth() / 2,
                mc.getWindow().getGuiScaledHeight() / 2 + 840,
                400,
                self.fake,
                self.source,
                self.partialTick
        );
    }

    private static EntityAnimatronic createFake(EntityAnimatronic original) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return null;

        EntityAnimatronic f = (EntityAnimatronic) original.getType().create(mc.level);
        if (f == null) return null;

        f.jumpscareAnimationState.start(0);
        return f;
    }

    public static void drawEntityOnScreen(GuiGraphics gfx, int x, int y, int scale,
                                          LivingEntity fake, LivingEntity original, float partialTick) {
        PoseStack pose = gfx.pose();
        pose.pushPose();
        pose.translate(x, y, 105.0D);
        pose.scale(scale, scale, scale);
        pose.mulPose(new Quaternionf().rotateZ((float)Math.PI));

        EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        dispatcher.setRenderShadow(false);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        dispatcher.render(fake, 0.0D, 0.0D, 0.0D, 0.0F, partialTick, pose, buffer, 15728880);

        buffer.endBatch();
        dispatcher.setRenderShadow(true); // Restaurer l'état

        pose.popPose();
    }
}