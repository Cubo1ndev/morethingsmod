package net.more.things.entities;

public class MoreThingsEntitySpawn {

    public static void registerEntitySpawn() {
        //manageAnimalEntities();
    }

    /*private static void manageAnimalEntities() {
        registerAnimalEntitySpawn(MoreThingsEntityTypesInit.RAINBOW_SHEEP_REGISTRY_OBJECT, config.rainbowSheep);
    }

    /*private static <T extends AnimalEntity> void registerAnimalEntitySpawn(EntityType<T> entity, String[] spawnBiomes, ModConfig.EntityConfig config) {
        if (config.spawn) {
            BiomeSpawnHelper.setCreatureSpawnBiomes(entity, spawnBiomes, config.weight, config.groupMin, config.groupMax);
            SpawnRestrictionAccessor.callRegister(entity, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        }
    }

    private static <T extends AnimalEntity> void registerAnimalEntitySpawn(EntityType<T> entity, ModConfig.EntityConfig entityConfig) {
        registerAnimalEntitySpawn(entity, entityConfig.spawnBiomes.toArray(new String[0]), entityConfig);
    }*/
}
