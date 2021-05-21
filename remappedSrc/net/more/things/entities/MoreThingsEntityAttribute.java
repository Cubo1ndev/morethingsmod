package net.more.things.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.more.things.entities.base.BaseSheepEntity;

public class MoreThingsEntityAttribute {
    public static void registerEntityAttribute() {
        registerBaseOneColorSheepAttributes(MoreThingsEntityTypes.RAINBOW_SHEEP_REGISTRY_OBJECT);
    }

    private static void registerBaseOneColorSheepAttributes(EntityType<? extends LivingEntity> entityType) {
        FabricDefaultAttributeRegistry.register(entityType, BaseSheepEntity.createSheepAttributes());
    }
}
