package animatronicnightshift;

import animatronicnightshift.entities.Foxy.FoxyRenderer;
import animatronicnightshift.entities.GoldenFreddy.GoldenFreddyRenderer;
import animatronicnightshift.event.FreddyMaskRenderer;
import animatronicnightshift.items.freddymask.ItemFreddyMask;
import animatronicnightshift.utils.CreativeTabs;
import animatronicnightshift.utils.SoundsRegister;
import com.mojang.logging.LogUtils;

import animatronicnightshift.blocks.BlockEntityRegister;
import animatronicnightshift.blocks.BlocksRegister;
import animatronicnightshift.blocks.camera.CameraRenderer;
import animatronicnightshift.entities.EntitiesRegister;
import animatronicnightshift.entities.Bonnie.BonnieRenderer;
import animatronicnightshift.entities.Chica.ChicaRenderer;
import animatronicnightshift.entities.FreddyFazbear.FreddyFazbearRenderer;
import animatronicnightshift.items.ItemsRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AnimatronicNightshift.MODID)
public class AnimatronicNightshift
{
    public static final String MODID = "animatronicnightshift";
    private static final Logger LOGGER = LogUtils.getLogger();


    public AnimatronicNightshift()
    {
        @SuppressWarnings("removal") IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EntitiesRegister.register(modEventBus);
        BlocksRegister.register(modEventBus);
        ItemsRegister.register(modEventBus);
        BlockEntityRegister.BLOCK_ENTITIES.register(modEventBus);
        CreativeTabs.CREATIVE_TABS.register(modEventBus);
        SoundsRegister.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void init(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BlocksRegister.CUPCAKE.get(), RenderType.cutout());
        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            EntityRenderers.register(EntitiesRegister.FREDDY.get(), FreddyFazbearRenderer::new);
            EntityRenderers.register(EntitiesRegister.BONNIE.get(), BonnieRenderer::new);
            EntityRenderers.register(EntitiesRegister.CHICA.get(), ChicaRenderer::new);
            EntityRenderers.register(EntitiesRegister.GOLDEN_FREDDY.get(), GoldenFreddyRenderer::new);
            EntityRenderers.register(EntitiesRegister.FOXY.get(), FoxyRenderer::new);


            event.registerBlockEntityRenderer(
                    BlockEntityRegister.CAMERA_BLOCK_ENTITY.get(),
                    CameraRenderer::new
            );
        }
    }
}