package net.more.things.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import net.more.things.MoreThingsMain;
import net.more.things.entities.rainbow_sheep.RainbowSheepEntity;

public class MoreThingsEntityTypes {
    public static EntityType<RainbowSheepEntity> RAINBOW_SHEEP_REGISTRY_PROPS;
    public static EntityType<RainbowSheepEntity> RAINBOW_SHEEP_REGISTRY_OBJECT;

    public static void registerEntityTypes() {
        RAINBOW_SHEEP_REGISTRY_PROPS = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RainbowSheepEntity::new).dimensions(sheepDimensions()).trackRangeBlocks(64).trackedUpdateRate(3).build();
        RAINBOW_SHEEP_REGISTRY_OBJECT = Registry.register(Registry.ENTITY_TYPE, MoreThingsMain.id("rainbow_sheep"), RAINBOW_SHEEP_REGISTRY_PROPS);
    }

    private static EntityDimensions sheepDimensions() {
        return EntityDimensions.fixed(EntityType.SHEEP.getWidth(), EntityType.SHEEP.getHeight());
    }

}


