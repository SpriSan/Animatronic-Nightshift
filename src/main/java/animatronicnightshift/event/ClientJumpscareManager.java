package animatronicnightshift.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientJumpscareManager {

    private static final ClientJumpscareData INSTANCE = new ClientJumpscareData();

    public static ClientJumpscareData get() {
        return INSTANCE;
    }
}
