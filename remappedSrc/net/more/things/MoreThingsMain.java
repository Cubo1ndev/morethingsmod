package net.more.things;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.Item;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.more.things.block.MoreThingsBlocks;
import net.more.things.crops.MoreThingsCrops;
import net.more.things.entities.MoreThingsEntityAttribute;
import net.more.things.entities.MoreThingsEntitySpawn;
import net.more.things.entities.MoreThingsEntityTypes;
import net.more.things.item.MoreThingsItems;
import net.more.things.recipes.fermenter.FermenterRecipe;
import net.more.things.recipes.fermenter.FermenterRecipeSerializer;
import net.more.things.screen.advanced_jukebox.AdvancedJukeboxScreenHandler;
import net.more.things.screen.advanced_loom.AdvancedLoomScreenHandler;
import net.more.things.screen.fermenter.FermenterScreenHandler;
import net.more.things.sounds.MoreThingsSounds;

public class MoreThingsMain implements ModInitializer {
	public static final String MOD_ID = "morethings";
	public static final String MOD_NAME = "MoreThings";

	public static Item MARIHUANA;
	public static final ScreenHandlerType<FermenterScreenHandler> FERMENTER_SCREEN_HANDLER;
	public static final ScreenHandlerType<AdvancedLoomScreenHandler> ADVANCED_LOOM_SCREEN_HANDLER;
	public static final ScreenHandlerType<AdvancedJukeboxScreenHandler> ADVANCED_JUKEBOX_SCREEN_HANDLER;

	static {
		FERMENTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("morethings","fermenter"), FermenterScreenHandler::new);
		ADVANCED_LOOM_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("morethings","advanced_loom"), AdvancedLoomScreenHandler::new);
		ADVANCED_JUKEBOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("morethings","advanced_jukebox"), AdvancedJukeboxScreenHandler::new);
	}

	public final static RecipeType<FermenterRecipe> FERMENTER_RECIPE_TYPE = new RecipeType<FermenterRecipe>() {
		public String toString() {
			return new Identifier("morethings", "ferment").toString();
		}
	};

	@Override
	public void onInitialize() {
		new Events();

		MoreThingsCrops.registerCrops();
		MoreThingsItems.registerItems();
		MoreThingsBlocks.registerBlocks();
		MoreThingsSounds.registerSounds();
		MoreThingsPaintings.registerPaintings();

		MoreThingsEntitySpawn.registerEntitySpawn();
		MoreThingsEntityTypes.registerEntityTypes();
		MoreThingsEntityAttribute.registerEntityAttribute();

		Registry.register(Registry.RECIPE_SERIALIZER, FermenterRecipeSerializer.ID, FermenterRecipeSerializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier("morethings", FermenterRecipe.Type.ID), FermenterRecipe.Type.INSTANCE);
	}

	public static Identifier id(String name){
		return new Identifier(MOD_ID, name);
	}
}
