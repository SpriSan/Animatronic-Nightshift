package doxylamine.animatronicnightshift.items.freddymask;

import doxylamine.animatronicnightshift.event.FreddyMaskRenderer;
import doxylamine.animatronicnightshift.utils.SoundsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFreddyMask extends Item {

    private static final SoundEvent MASK_PUT = SoundsRegister.MASK_PUT.get();
    private static final SoundEvent MASK_REMOVE= SoundsRegister.MASK_REMOVE.get();


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
                        MASK_PUT,
                        1.0F,
                        1.0F
                )
        );

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, net.minecraft.world.entity.LivingEntity entity, int timeLeft) {

        Minecraft.getInstance().getSoundManager().play(         //peut causer des crash
                SimpleSoundInstance.forUI(
                        MASK_REMOVE,
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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("§7Right-click to put on the mask"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

}