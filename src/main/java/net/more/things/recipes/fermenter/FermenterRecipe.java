package net.more.things.recipes.fermenter;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.more.things.MoreThingsMain;

public class FermenterRecipe implements Recipe<Inventory> {
	protected final RecipeType<FermenterRecipe> type;
	protected final Identifier id;
	protected final Ingredient inputA;
	protected final Ingredient inputB;
	protected final Ingredient inputC;
	protected final Ingredient bottle;
	protected final Integer fermentTime;
	protected final ItemStack output;

	public FermenterRecipe(Ingredient ingredientA, Ingredient ingredientB, Ingredient ingredientC, Ingredient ingredientD, ItemStack output, Integer fermentTime, Identifier identifier) {
		this.type = MoreThingsMain.FERMENTER_RECIPE_TYPE;
		this.id = identifier;
		this.inputA = ingredientA;
		this.inputB = ingredientB;
		this.inputC = ingredientC;
      this.bottle = ingredientD;
      this.fermentTime = fermentTime;
		this.output = output;
   }

   public Ingredient getInputA() {
	   return this.inputA;
   }

   public Ingredient getInputB() {
	   return this.inputB;
   }

   public Ingredient getInputC() {
	   return this.inputC;
   }

   public Ingredient getBottle() {
	   return this.bottle;
   }

   @Override
   public boolean matches(Inventory inventory, World world) {
	   if (inventory.size() < 4) return false;
	   return inputA.test(inventory.getStack(0)) && inputB.test(inventory.getStack(1)) && inputC.test(inventory.getStack(2)) && bottle.test(inventory.getStack(3));
   }

   @Override
   public ItemStack craft(Inventory inventory) {
      return ItemStack.EMPTY;
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

   public int getFermentTime() {
      return this.fermentTime;
   }

   @Override
   public RecipeSerializer<?> getSerializer() {
	   return FermenterRecipeSerializer.INSTANCE;
   }

   public static class Type implements RecipeType<FermenterRecipe> {
	   private Type() {}
	   public static final Type INSTANCE = new Type();
	   public static final String ID = "four_slot_recipe";
   }

   @Override
   public RecipeType<?> getType() {
      return Type.INSTANCE;
   }
}