package animatronicnightshift.entities;

import animatronicnightshift.AnimatronicNightshift;
import animatronicnightshift.entities.FreddyFazbear.ModelFreddyFazbear;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LayersRegister {
        public static final ModelLayerLocation FREDDY_LAYER =
                new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "freddy"), "main");
            
        public static final ModelLayerLocation BONNIE_LAYER =
                new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "bonnie"), "main");
            
        public static final ModelLayerLocation CHICA_LAYER =
                new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "chica"), "main");
            
}