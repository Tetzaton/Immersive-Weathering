package com.ordana.immersive_weathering.integration.fabric;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import com.ordana.immersive_weathering.configs.ClientConfigs;
import com.ordana.immersive_weathering.configs.CommonConfigs;
import com.ordana.immersive_weathering.reg.ModBlocks;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.mehvahdjukaar.moonlight.api.cloth_config.ClothConfigListScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TextComponent;

public class ModMenuCompat implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ModConfigScreen::new;
    }

    private static class ModConfigScreen extends ClothConfigListScreen {

        public ModConfigScreen(Screen parent) {
            super(ImmersiveWeathering.MOD_ID, ModBlocks.IVY.get().asItem().getDefaultInstance(),
                    new TextComponent("\u00A76Immersive Weathering Configs"),
                    ImmersiveWeathering.res("block/cracked_bricks"),
                    parent, ClientConfigs.CLIENT_SPEC, CommonConfigs.SERVER_SPEC);
        }

        @Override
        protected void addExtraButtons() {

            int y = this.height - 27;
            int centerX = this.width / 2;

            this.addRenderableWidget(new Button(centerX - 45, y, 90, 20, CommonComponents.GUI_BACK, (button) -> this.minecraft.setScreen(this.parent)));

            //TODO: link buttons

        }

    }
}