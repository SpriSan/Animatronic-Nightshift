package doxylamine.animatronicnightshift.event;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.items.freddymask.ItemFreddyMask;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, value = Dist.CLIENT)

public class ClientEventsHandler {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();

            if (mc.player != null) {
                ItemStack heldItem = mc.player.getMainHandItem();

                // Vérifier si le joueur tient l'item et que le clic droit est maintenu
                boolean isHoldingOverlayItem = heldItem.getItem() instanceof ItemFreddyMask;
                boolean isRightClickPressed = mc.options.keyUse.isDown();

                FreddyMaskRenderer.showOverlay = isHoldingOverlayItem && isRightClickPressed;
            }
        }
    }
}