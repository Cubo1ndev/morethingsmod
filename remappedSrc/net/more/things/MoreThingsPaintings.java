package net.more.things;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.registry.Registry;

public class MoreThingsPaintings {

    public static PaintingMotive MEN_WITHOUT_CLOTHES_WITH_SISSORS, MAN_WITHOUT_CLOTHES;
    public static PaintingMotive COCODRILE, MOUNTAIN, PILLAGER, WANDERER, CREEPER, OCEAN;

    public static PaintingMotive AXOLOTLS, BADLANDS, BONSAI, CACTI, CHERRY_TREE, FOX, GLOW_SQUID;
    public static PaintingMotive HALLOWEEN_PUMPKIN, MOUNTAINS, PANDA, PUFFER_LIFE, SAKURA;
    public static PaintingMotive SUNSET_FOREST, WITHER_ROSE;
    
    public static PaintingMotive ABSTRACT_BLUE, ABSTRACT_RAINBOW, ABSTRACT_RED, ABSTRACT_SUNSET; 
    public static PaintingMotive COLORFUL_SQUARES, FRUITS, GHOST, REST, SKY, SNAKE_BLOCK; 
    public static PaintingMotive SNOW_LANDSCAPE, SOMETHING_IN_THE_WATER, SYNTH_CITY, WATERFALL;

    public static PaintingMotive PLUMA_GAY_PAINTING;

    public static void registerPaintings() {
        OCEAN = Registry.register(Registry.PAINTING_MOTIVE, "morethings:ocean", new PaintingMotive(32, 32));
        CREEPER = Registry.register(Registry.PAINTING_MOTIVE, "morethings:creeper", new PaintingMotive(16, 16));
        PILLAGER = Registry.register(Registry.PAINTING_MOTIVE, "morethings:pillager", new PaintingMotive(16, 16));
        WANDERER = Registry.register(Registry.PAINTING_MOTIVE, "morethings:wanderer", new PaintingMotive(32, 64));
        MOUNTAIN = Registry.register(Registry.PAINTING_MOTIVE, "morethings:mountain", new PaintingMotive(16, 16));
        COCODRILE = Registry.register(Registry.PAINTING_MOTIVE, "morethings:cocodrile", new PaintingMotive(16, 16));
        MAN_WITHOUT_CLOTHES = Registry.register(Registry.PAINTING_MOTIVE, "morethings:man_without_clothes", new PaintingMotive(32, 48));
        MEN_WITHOUT_CLOTHES_WITH_SISSORS = Registry.register(Registry.PAINTING_MOTIVE, "morethings:men_without_clothes_with_sissors", new PaintingMotive(64, 48));

        AXOLOTLS = Registry.register(Registry.PAINTING_MOTIVE, "morethings:axolotls", new PaintingMotive(64, 32));
        BADLANDS = Registry.register(Registry.PAINTING_MOTIVE, "morethings:badlands", new PaintingMotive(32, 16));
        BONSAI = Registry.register(Registry.PAINTING_MOTIVE, "morethings:bonsai", new PaintingMotive(16, 16));
        CACTI = Registry.register(Registry.PAINTING_MOTIVE, "morethings:cacti", new PaintingMotive(16, 32));
        CHERRY_TREE = Registry.register(Registry.PAINTING_MOTIVE, "morethings:cherry_tree", new PaintingMotive(32, 32));
        FOX = Registry.register(Registry.PAINTING_MOTIVE, "morethings:fox", new PaintingMotive(32, 16));
        GLOW_SQUID = Registry.register(Registry.PAINTING_MOTIVE, "morethings:glow_squid", new PaintingMotive(32, 32));
        HALLOWEEN_PUMPKIN = Registry.register(Registry.PAINTING_MOTIVE, "morethings:halloween_pumpkin", new PaintingMotive(32, 16));
        MOUNTAINS = Registry.register(Registry.PAINTING_MOTIVE, "morethings:mountains", new PaintingMotive(32, 16));
        PANDA = Registry.register(Registry.PAINTING_MOTIVE, "morethings:panda", new PaintingMotive(32, 32));
        PUFFER_LIFE = Registry.register(Registry.PAINTING_MOTIVE, "morethings:puffer_life", new PaintingMotive(16, 32));
        SAKURA = Registry.register(Registry.PAINTING_MOTIVE, "morethings:sakura", new PaintingMotive(32, 16));
        SUNSET_FOREST = Registry.register(Registry.PAINTING_MOTIVE, "morethings:sunset_forest", new PaintingMotive(48, 32));
        WITHER_ROSE = Registry.register(Registry.PAINTING_MOTIVE, "morethings:wither_rose", new PaintingMotive(48, 48));

        ABSTRACT_BLUE = Registry.register(Registry.PAINTING_MOTIVE, "morethings:abstract_blue", new PaintingMotive(16, 16));
        ABSTRACT_RAINBOW = Registry.register(Registry.PAINTING_MOTIVE, "morethings:abstract_rainbow", new PaintingMotive(16, 16));
        ABSTRACT_RED = Registry.register(Registry.PAINTING_MOTIVE, "morethings:abstract_red", new PaintingMotive(16, 16));
        ABSTRACT_SUNSET = Registry.register(Registry.PAINTING_MOTIVE, "morethings:abstract_sunset", new PaintingMotive(16, 16));
        COLORFUL_SQUARES = Registry.register(Registry.PAINTING_MOTIVE, "morethings:colorful_squares", new PaintingMotive(32, 16));
        FRUITS = Registry.register(Registry.PAINTING_MOTIVE, "morethings:fruits", new PaintingMotive(32, 16));
        GHOST = Registry.register(Registry.PAINTING_MOTIVE, "morethings:ghost", new PaintingMotive(16, 32));
        REST = Registry.register(Registry.PAINTING_MOTIVE, "morethings:rest", new PaintingMotive(32, 16));
        SKY = Registry.register(Registry.PAINTING_MOTIVE, "morethings:sky", new PaintingMotive(32, 32));
        SNAKE_BLOCK = Registry.register(Registry.PAINTING_MOTIVE, "morethings:snake_block", new PaintingMotive(32, 32));
        SNOW_LANDSCAPE = Registry.register(Registry.PAINTING_MOTIVE, "morethings:snow_landscape", new PaintingMotive(32, 16));
        SOMETHING_IN_THE_WATER = Registry.register(Registry.PAINTING_MOTIVE, "morethings:something_in_the_water", new PaintingMotive(48, 32));
        SYNTH_CITY = Registry.register(Registry.PAINTING_MOTIVE, "morethings:synth_city", new PaintingMotive(16, 16));
        WATERFALL = Registry.register(Registry.PAINTING_MOTIVE, "morethings:waterfall", new PaintingMotive(32, 16));

        PLUMA_GAY_PAINTING = Registry.register(Registry.PAINTING_MOTIVE, "morethings:pluma_gay_painting", new PaintingMotive(64, 48));
    }
}
