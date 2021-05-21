package net.more.things.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.more.things.entities.rainbow_sheep.RainbowSheepRenderer;

@Environment(EnvType.CLIENT)
public class MoreThingsEntityRenderer {

    public static void registerEntityRenderer() {
        EntityRendererRegistry.INSTANCE.register(MoreThingsEntityTypes.RAINBOW_SHEEP_REGISTRY_OBJECT, (dispatcher, context) -> {
            return new RainbowSheepRenderer(dispatcher);
        });
    }
}
