package net.more.things;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.more.things.block.MoreThingsBlocks;
import net.more.things.block.advanced_jukebox.AdvancedJukeboxBlockEntityRenderer;
import net.more.things.crops.MoreThingsCrops;
import net.more.things.entities.MoreThingsEntityRenderer;
import net.more.things.screen.advanced_jukebox.AdvancedJukeboxScreen;
import net.more.things.screen.advanced_loom.AdvancedLoomScreen;
import net.more.things.screen.fermenter.FermenterScreen;

@Environment(EnvType.CLIENT)
public class MoreThignsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		MoreThingsEntityRenderer.registerEntityRenderer();

        ScreenRegistry.register(MoreThingsMain.FERMENTER_SCREEN_HANDLER, FermenterScreen::new);
        ScreenRegistry.register(MoreThingsMain.ADVANCED_LOOM_SCREEN_HANDLER, AdvancedLoomScreen::new);
        ScreenRegistry.register(MoreThingsMain.ADVANCED_JUKEBOX_SCREEN_HANDLER, AdvancedJukeboxScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(MoreThingsCrops.marihuana_plant.getBlock(), RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(MoreThingsBlocks.FERMENTER, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(MoreThingsBlocks.PIGGY_BANK, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(MoreThingsBlocks.ADVANCED_JUKEBOX, RenderLayer.getTranslucent());
		BlockEntityRendererRegistry.INSTANCE.register(MoreThingsBlocks.ADVANCEND_JUKEBOX_BLOCK_ENTITY,AdvancedJukeboxBlockEntityRenderer::new);
	}
}