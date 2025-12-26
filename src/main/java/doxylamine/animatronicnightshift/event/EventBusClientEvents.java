package doxylamine.animatronicnightshift.event;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import doxylamine.animatronicnightshift.blocks.camera.ModelCamera;
import doxylamine.animatronicnightshift.entities.Foxy.ModelFoxy;
import doxylamine.animatronicnightshift.entities.GoldenFreddy.ModelGoldenFreddy;
import doxylamine.animatronicnightshift.entities.LayersRegister;
import doxylamine.animatronicnightshift.entities.Bonnie.ModelBonnie;
import doxylamine.animatronicnightshift.entities.Chica.ModelChica;
import doxylamine.animatronicnightshift.entities.FreddyFazbear.ModelFreddyFazbear;
import doxylamine.animatronicnightshift.entities.Springtrap.ModelSpringtrap;
import doxylamine.animatronicnightshift.entities.ToyBonnie.ModelToyBonnie;
import doxylamine.animatronicnightshift.entities.ToyFreddy.ModelToyFreddy;
import doxylamine.animatronicnightshift.entities.WitheredFreddy.ModelWitheredFreddy;
import doxylamine.animatronicnightshift.items.freddymask.ModelFreddyMask;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LayersRegister.FREDDY_LAYER, ModelFreddyFazbear::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.BONNIE_LAYER, ModelBonnie::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.CHICA_LAYER, ModelChica::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.CAMERA_LAYER, ModelCamera::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.GOLDEN_FREDDY_LAYER, ModelGoldenFreddy::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.FOXY_LAYER, ModelFoxy::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.FREDDY_MASK_LAYER, ModelFreddyMask::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.TOY_FREDDY_LAYER, ModelToyFreddy::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.TOY_BONNIE_LAYER, ModelToyBonnie::createBodyLayer);
        event.registerLayerDefinition(LayersRegister.WITHERED_FREDDY_LAYER, ModelWitheredFreddy::createBodyLayer);


        event.registerLayerDefinition(LayersRegister.SPRINGTRAP_LAYER, ModelSpringtrap::createBodyLayer);


    }

}
