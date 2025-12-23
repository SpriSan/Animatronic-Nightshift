package doxylamine.animatronicnightshift.entities;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnimatronicNightshift.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LayersRegister {
        public static final ModelLayerLocation FREDDY_LAYER =
                new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "freddy"), "main");
            
        public static final ModelLayerLocation BONNIE_LAYER =
                new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "bonnie"), "main");
            
        public static final ModelLayerLocation CHICA_LAYER =
                new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "chica"), "main");

        public static final ModelLayerLocation GOLDEN_FREDDY_LAYER =
                new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "golden_freddy"), "main");

    public static final ModelLayerLocation SPRINGTRAP_LAYER =
            new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "springtrap"), "main");

    public static final ModelLayerLocation TOY_FREDDY_LAYER =
            new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "toy_freddy"), "main");

    public static final ModelLayerLocation FOXY_LAYER =
            new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "foxy"), "main");

    public static final ModelLayerLocation CAMERA_LAYER =
            new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "camera"), "main");

    public static final ModelLayerLocation FREDDY_MASK_LAYER =
            new ModelLayerLocation(new ResourceLocation(AnimatronicNightshift.MODID, "freddy_mask"), "main");
}