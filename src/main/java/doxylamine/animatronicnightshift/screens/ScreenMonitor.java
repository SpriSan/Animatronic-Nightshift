package doxylamine.animatronicnightshift.screens;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import com.mojang.blaze3d.systems.RenderSystem;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ScreenMonitor extends Screen {

    private static final int CAMERA_FRAME_COUNT = 11;
    private static final int STATIC_FRAMES_COUNT = 8;
    private int currentFrame = 0;
    private int currentStaticFrame = 0;
    private int tickCounter = 0;
    private int staticTickCounter = 0;
    private boolean animationFinished = false;
    private boolean quit = false;

    private static final ResourceLocation[] FRAMES = new ResourceLocation[CAMERA_FRAME_COUNT];
    private static final ResourceLocation[] STATIC_FRAMES = new ResourceLocation[STATIC_FRAMES_COUNT];

    static {
        // Initialisation statique pour éviter de recréer les ResourceLocations à chaque instance
        for (int i = 0; i < CAMERA_FRAME_COUNT; i++) {
            FRAMES[i] = new ResourceLocation(AnimatronicNightshift.MODID, "textures/screen/monitor/" + i + ".png");
        }

        for (int i = 0; i < STATIC_FRAMES_COUNT; i++) {
            STATIC_FRAMES[i] = new ResourceLocation(AnimatronicNightshift.MODID, "textures/screen/static/" + i + ".png");
        }
    }

    public ScreenMonitor(Component title) {
        super(title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {

        int overlayWidth = this.width;
        int overlayHeight = this.height;

        int x = 0;
        int y = 0;

        RenderSystem.enableBlend();

        if (!animationFinished) {
            guiGraphics.blit(
                    FRAMES[currentFrame],
                    x, y,
                    0, 0,
                    overlayWidth, overlayHeight,
                    overlayWidth, overlayHeight
            );
        } else {
            guiGraphics.blit(
                    STATIC_FRAMES[currentStaticFrame],
                    x, y,
                    0, 0,
                    overlayWidth, overlayHeight,
                    overlayWidth, overlayHeight
            );

            // Overlay noir semi-transparent
            guiGraphics.fill(0, 0, this.width, this.height, 0x80000000);
            guiGraphics.drawString(this.font, Component.literal("not available yet"), 20, 20, 0xFFFFFF, false);

            float scale = 2.0f; // Taille du texte (1.0 = normal, 2.0 = double)

            guiGraphics.pose().pushPose();
            guiGraphics.pose().scale(scale, scale, 1.0f);

            guiGraphics.drawString(this.font, Component.literal("work in progress (─‿‿─)"), (int) (40 / scale), (int) (40 / scale), 0xFFFFFF, false);

            guiGraphics.pose().popPose();

            int margin = 5;
            int borderWidth = 2;
            int color = 0xFFFFFFFF;

            guiGraphics.fill(margin, margin, this.width - margin, margin + borderWidth, color);

            guiGraphics.fill(margin, this.height - margin - borderWidth, this.width - margin, this.height - margin, color);

            guiGraphics.fill(margin, margin, margin + borderWidth, this.height - margin, color);

            guiGraphics.fill(this.width - margin - borderWidth, margin, this.width - margin, this.height - margin, color);

            if (this.minecraft != null && this.minecraft.level != null) {
                long worldTime = this.minecraft.level.getDayTime();
                long timeOfDay = worldTime % 24000;

                // Convertir en heures (6:00 AM = 0 ticks, 18:00 = 12000 ticks)
                int totalMinutes = (int)((timeOfDay + 6000) % 24000) * 24 * 60 / 24000;
                int hours = totalMinutes / 60;

                // Format AM/PM
                String period = hours >= 12 ? "PM" : "AM";
                int displayHours = hours % 12;
                if (displayHours == 0) displayHours = 12;

                String minecraftTime = String.format("%d %s", displayHours, period);

                float timeScale = 1.5f; // Modifiez cette valeur pour changer la taille

                guiGraphics.pose().pushPose();
                guiGraphics.pose().scale(timeScale, timeScale, 1.0f);

                int timeX = (int)((this.width - margin - 40) / timeScale);
                int timeY = (int)((margin + 10) / timeScale);

                guiGraphics.drawString(this.font, Component.literal(minecraftTime), timeX, timeY, 0xFFFFFF, true);

                guiGraphics.pose().popPose();

            }
        }

        RenderSystem.disableBlend();

        // Rendre les widgets (boutons)
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void tick() {
        super.tick();

        if (quit) {
            // Réinitialiser l'état pour voir l'animation de fermeture
            animationFinished = false;

            // Animation de fermeture (retour en arrière)
            currentFrame -= 2;

            if (currentFrame <= 0) {
                // L'animation est terminée, on ferme l'écran
                if (this.minecraft != null) {
                    this.minecraft.setScreen(null);
                }
            }
        } else if (!animationFinished) {
            // Animation d'ouverture
            currentFrame += 2;

            if (currentFrame >= CAMERA_FRAME_COUNT) {
                currentFrame = CAMERA_FRAME_COUNT - 1;
                animationFinished = true;
            }
        } else {
            // Animation du static
            staticTickCounter++;

            if (staticTickCounter >= 1) {
                staticTickCounter = 0;
                currentStaticFrame++;

                if (currentStaticFrame >= STATIC_FRAMES_COUNT) {
                    currentStaticFrame = 0;
                }
            }
        }
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 180;
        int buttonHeight = 20;

        int x = (this.width - buttonWidth) / 2;
        int y = this.height - buttonHeight - 10;

        this.addRenderableWidget(Button.builder(
                Component.literal("\\\\\\\\\\\\\\\\////////"),
                button -> {
                    quit = true;

                    Minecraft.getInstance().getSoundManager().play(
                            SimpleSoundInstance.forUI(
                                    SoundsRegister.MONITOR.get(),
                                    1.0F,
                                    1.0F
                            )
                    );
                    button.visible = false;
                }

        ).bounds(x, y, buttonWidth, buttonHeight).build());
    }

    public void drawRect() {

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}