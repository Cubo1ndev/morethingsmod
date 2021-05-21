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
import net.more.things.item.MoreThingsItems;
import net.more.things.recipes.advanced_loom.AdvancedLoomRecipe;
import net.more.things.recipes.advanced_loom.AdvancedLoomRecipeSerializer;
import net.more.things.recipes.drying_rack.DryingRackRecipe;
import net.more.things.recipes.drying_rack.DryingRackRecipeSerializer;
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

	public final static RecipeType<AdvancedLoomRecipe> SEW_RECIPE_TYPE = new RecipeType<AdvancedLoomRecipe>() {
		public String toString() {
			return new Identifier("morethings", "sew").toString();
		}
	};

	public final static RecipeType<DryingRackRecipe> DRY_RECIPE_TYPE = new RecipeType<DryingRackRecipe>() {
		public String toString() {
			return new Identifier("morethings", "dry").toString();
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

		Registry.register(Registry.RECIPE_SERIALIZER, FermenterRecipeSerializer.ID, FermenterRecipeSerializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier("morethings", FermenterRecipe.Type.ID), FermenterRecipe.Type.INSTANCE);

		Registry.register(Registry.RECIPE_SERIALIZER, AdvancedLoomRecipeSerializer.ID, AdvancedLoomRecipeSerializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier("morethings", AdvancedLoomRecipe.Type.ID), AdvancedLoomRecipe.Type.INSTANCE);

		Registry.register(Registry.RECIPE_SERIALIZER, DryingRackRecipeSerializer.ID, DryingRackRecipeSerializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier("morethings", DryingRackRecipe.Type.ID), DryingRackRecipe.Type.INSTANCE);
	}

	public static Identifier id(String name){
		return new Identifier(MOD_ID, name);
	}
}
