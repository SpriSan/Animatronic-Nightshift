package animatronicnightshift.event;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.LayersRegister;
import animatronicnightshift.entities.Bonnie.ModelBonnie;
import animatronicnightshift.entities.Chica.ModelChica;
import animatronicnightshift.entities.FreddyFazbear.ModelFreddyFazbear;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LayersRegister.FREDDY_LAYER, ModelFreddyFazbear::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.BONNIE_LAYER, ModelBonnie::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.CHICA_LAYER, ModelChica::createBodyLayer);

    }
}
