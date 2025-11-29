package animatronicnightshift.screens;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ScreenMonitor extends Screen {

    public ScreenMonitor(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        int buttonWidth = 180;
        int buttonHeight = 20;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height - buttonHeight - 5; 

        this.addRenderableWidget(Button.builder(
                Component.literal("\\\\\\\\\\\\\\\\////////"), 
                button -> {
                    if (this.minecraft.player != null) {

                        this.minecraft.setScreen(null);
                    }
                })
                .bounds(x, y, buttonWidth, buttonHeight)
                .build()
        );
    }

    public boolean isPauseScreen() {
        return false;
   }
}