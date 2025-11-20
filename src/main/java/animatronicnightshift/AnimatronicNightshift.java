package animatronicnightshift;

import com.mojang.logging.LogUtils;

import animatronicnightshift.entities.EntitiesRegister;
import animatronicnightshift.entities.Bonnie.BonnieRenderer;
import animatronicnightshift.entities.FreddyFazbear.FreddyFazbearRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
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
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EntitiesRegister.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(EntitiesRegister.FREDDY.get(), FreddyFazbearRenderer::new);
            EntityRenderers.register(EntitiesRegister.BONNIE.get(), BonnieRenderer::new);
      
        }
    }
}