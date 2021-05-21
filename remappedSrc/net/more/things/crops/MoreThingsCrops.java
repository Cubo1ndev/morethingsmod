package net.more.things.crops;

import net.more.things.MoreThingsMain;
import net.more.things.item.MoreThingsItems;

public class MoreThingsCrops {
    public static final Crop marihuana_plant = new Crop(MoreThingsMain.id("marihuana"))
            .setCropGrowthBoundingBoxes(CropBoundingBoxFactory.buildBoundingBoxes(12.0D, 4.0D, new float[]{9, 12, 15, 16, 20, 24, 31, 31}))
            .setItem(MoreThingsItems.MARIHUANA)
            .setSeperateSeed(true)
            .setTwoTall(true)
            .build();

    public static void registerCrops() {
        marihuana_plant.register();
    }
}
