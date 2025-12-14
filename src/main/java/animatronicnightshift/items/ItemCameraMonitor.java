package animatronicnightshift.items;

import animatronicnightshift.screens.ScreenMonitor;
import animatronicnightshift.utils.SoundsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.Level;

public class ItemCameraMonitor extends Item {

    public ItemCameraMonitor(Properties p_41383_) {
        super(p_41383_);
    }   
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, net.minecraft.world.entity.player.Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (world.isClientSide) {
            Minecraft.getInstance().setScreen(new ScreenMonitor(Component.literal("Camera Monitor")));
        }

        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(
                        SoundsRegister.MONITOR.get(),
                        1.0F,
                        1.0F
                )
        );


        return InteractionResultHolder.sidedSuccess(stack, world.isClientSide());
    }
}