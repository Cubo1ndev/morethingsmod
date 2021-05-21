package net.more.things.recipes.drying_rack;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.more.things.MoreThingsMain;

public class DryingRackRecipe implements Recipe<Inventory> {
	protected final RecipeType<DryingRackRecipe> type;
	protected final Identifier id;
	protected final Ingredient input;
	protected final Integer time;
	protected final ItemStack output;

	public DryingRackRecipe(Ingredient ingredient, ItemStack output, Integer time, Identifier identifier) {
		this.type = MoreThingsMain.DRY_RECIPE_TYPE;
		this.id = identifier;
		this.input = ingredient;
      this.time = time;
		this.output = output;
   }

   public Ingredient getInput() {
	   return this.input;
   }

   @Override
   public boolean matches(Inventory inventory, World world) {
	   if (inventory.size() < 1) return false;
	   return input.test(inventory.getStack(0));
   }

   @Override
   public ItemStack craft(Inventory inventory) {
      return this.output.copy();
   }
   
   @Override
   public boolean fits(int var1, int var2) {
	   return false;
   }

   @Override
   public ItemStack getOutput() {
		return this.output;
   }

   @Override
   public Identifier getId() {
		return this.id;
   }

   public int getTime() {
      return this.time;
   }

   @Override
   public RecipeSerializer<?> getSerializer() {
	   return DryingRackRecipeSerializer.INSTANCE;
   }

   public static class Type implements RecipeType<DryingRackRecipe> {
	   private Type() {}
	   public static final Type INSTANCE = new Type();
	   public static final String ID = "one_slot_recipe";
   }

   @Override
   public RecipeType<?> getType() {
      return Type.INSTANCE;
   }
}