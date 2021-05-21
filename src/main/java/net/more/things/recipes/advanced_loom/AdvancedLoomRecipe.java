package net.more.things.recipes.advanced_loom;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.more.things.MoreThingsMain;

public class AdvancedLoomRecipe implements Recipe<Inventory> {
	protected final RecipeType<AdvancedLoomRecipe> type;
	protected final Identifier id;
	protected final Ingredient inputA;
	protected final Ingredient inputB;
	protected final Ingredient inputC;
	protected final Ingredient inputD;
	protected final ItemStack outputA;
	protected final ItemStack outputB;
	protected final ItemStack outputC;
	protected final ItemStack outputD;

	public AdvancedLoomRecipe(Ingredient ingredientA, Ingredient ingredientB, Ingredient ingredientC, Ingredient ingredientD, ItemStack outputA, ItemStack outputB, ItemStack outputC, ItemStack outputD, Identifier identifier) {
		this.type = MoreThingsMain.SEW_RECIPE_TYPE;
		this.id = identifier;
		this.inputA = ingredientA;
		this.inputB = ingredientB;
		this.inputC = ingredientC;
      this.inputD = ingredientD;
		this.outputA = outputA;
		this.outputB = outputB;
		this.outputC = outputC;
		this.outputD = outputD;
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

   public Ingredient getInputD() {
	   return this.getInputD();
   }

   public ItemStack getOutputA() {
		return this.outputA;
   }

   public ItemStack getOutputB() {
		return this.outputB;
   }

   public ItemStack getOutputC() {
		return this.outputC;
   }

   public ItemStack getOutputD() {
		return this.outputD;
   }

   @Override
   public boolean matches(Inventory inventory, World world) {
	   if (inventory.size() < 4) return false;
	   return inputA.test(inventory.getStack(0)) && inputB.test(inventory.getStack(1)) && inputC.test(inventory.getStack(2)) && inputD.test(inventory.getStack(3));
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
		return this.outputA;
   }

   @Override
   public Identifier getId() {
		return this.id;
   }

   @Override
   public RecipeSerializer<?> getSerializer() {
	   return AdvancedLoomRecipeSerializer.INSTANCE;
   }

   public static class Type implements RecipeType<AdvancedLoomRecipe> {
	   private Type() {}
	   public static final Type INSTANCE = new Type();
	   public static final String ID = "five_slot_recipe";
   }

   @Override
   public RecipeType<?> getType() {
      return Type.INSTANCE;
   }
}