package animatronicnightshift.items.freddymask;

import animatronicnightshift.event.FreddyMaskRenderer;
import animatronicnightshift.utils.SoundsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemFreddyMask extends Item {

    public ItemFreddyMask(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand);

        if (level.isClientSide) {
            // Activer l'overlay côté client
            FreddyMaskRenderer.showOverlay = true;
        }

        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(
                        SoundsRegister.MASK_PUT.get(),
                        1.0F,
                        1.0F
                )
        );

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, net.minecraft.world.entity.LivingEntity entity, int timeLeft) {

        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(
                        SoundsRegister.MASK_REMOVE.get(),
                        1.0F,
                        1.0F
                )
        );

    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public static boolean isFreddyMask(ItemStack stack) {
        return stack.getItem() instanceof ItemFreddyMask;
    }

    public static boolean isPlayerUsingMask(Player player) {
        if (player == null) return false;

        return player.isUsingItem() && isFreddyMask(player.getUseItem());
    }
}