package animatronicnightshift.screens;

import animatronicnightshift.AnimatronicNightshift;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
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
        }

        RenderSystem.disableBlend();

        // Rendre les widgets (boutons)
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void tick() {
        super.tick();

        if (!animationFinished) {

                currentFrame+=2;

                if (currentFrame >= CAMERA_FRAME_COUNT) {
                    currentFrame = CAMERA_FRAME_COUNT - 1;
                    animationFinished = true;

            }

        } else {
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
        int y = this.height - buttonHeight - 5;

        this.addRenderableWidget(Button.builder(
                Component.literal("\\\\\\\\\\\\\\\\////////"),
                button -> {
                    if (this.minecraft != null) {
                        this.minecraft.setScreen(null);
                    }
                }
        ).bounds(x, y, buttonWidth, buttonHeight).build());
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}