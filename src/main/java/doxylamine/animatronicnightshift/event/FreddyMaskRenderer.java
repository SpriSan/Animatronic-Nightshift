package doxylamine.animatronicnightshift.event;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, value = Dist.CLIENT)
public class FreddyMaskRenderer {
    public static boolean showOverlay = false;
    private static boolean wasShowingOverlay = false;
    private static int animationTimer = 0;
    private static boolean isClosing = false;
    private static final int ANIMATION_DURATION = 15;
    private static ResourceLocation OVERLAY_TEXTURE = new ResourceLocation(AnimatronicNightshift.MODID, "textures/screen/mask.png");

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        if (event.getOverlay().id().toString().equals("minecraft:crosshair")) {
            Minecraft mc = Minecraft.getInstance();

            // Vérifier si on est en première personne
            boolean isFirstPerson = mc.options.getCameraType() == CameraType.FIRST_PERSON;

            if (!isFirstPerson) {
                // Réinitialiser l'état si on n'est pas en première personne
                if (isClosing) {
                    isClosing = false;
                }
                return;
            }

            // Détecter le début de l'affichage (clic pressé)
            if (showOverlay && !wasShowingOverlay) {
                animationTimer = 0;
                isClosing = false;
            }

            // Détecter la fin de l'affichage (clic relâché)
            if (!showOverlay && wasShowingOverlay) {
                isClosing = true;
                animationTimer = ANIMATION_DURATION; // Commencer l'animation de fermeture à la fin
            }

            wasShowingOverlay = showOverlay;

            // Afficher l'overlay si actif OU en train de se fermer
            if (showOverlay || isClosing) {
                renderOverlay(event.getGuiGraphics());

                if (showOverlay) {
                    // Animation d'ouverture (descente)
                    if (animationTimer < ANIMATION_DURATION) {
                        animationTimer++;
                    }
                } else if (isClosing) {
                    // Animation de fermeture (remontée)
                    if (animationTimer > 0) {
                        animationTimer--;
                    } else {
                        isClosing = false; // Fin de l'animation de fermeture
                    }
                }
            }
        }
    }

    private static void renderOverlay(GuiGraphics guiGraphics) {
        Minecraft mc = Minecraft.getInstance();
        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        // Dimensions de l'overlay
        int overlayWidth = screenWidth;
        int overlayHeight = screenHeight + 75;

        // Position finale (centrée)
        int finalX = (screenWidth - overlayWidth) / 2;
        int finalY = (screenHeight - overlayHeight) / 2;

        // Calcul de l'animation
        int x = finalX;
        int y = finalY;

        if (animationTimer < ANIMATION_DURATION) {
            // Progression de l'animation (0.0 à 1.0)
            float progress = (float) animationTimer / ANIMATION_DURATION;

            // Easing: démarrage rapide puis ralentissement (ease-out)
            float easedProgress = 1 - (1 - progress) * (1 - progress);

            // Distance de déplacement (l'image commence au-dessus de l'écran)
            int startOffsetY = -overlayHeight;

            // Interpolation de la position Y
            y = (int) (startOffsetY + (finalY - startOffsetY) * easedProgress);
        }

        // Activer le blending pour la transparence
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        // Dessiner la texture
        guiGraphics.blit(OVERLAY_TEXTURE, x, y, 0, 0, overlayWidth, overlayHeight, overlayWidth, overlayHeight);

        RenderSystem.disableBlend();
    }
}