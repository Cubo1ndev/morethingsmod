package net.more.things.recipes.fermenter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;

public class FermenterRecipeSerializer implements RecipeSerializer<FermenterRecipe> {
   private final int fermentTime = 0;

   private FermenterRecipeSerializer() {}

   public static final FermenterRecipeSerializer INSTANCE = new FermenterRecipeSerializer();
   public static final Identifier ID = new Identifier("morethings:fermenter");

   public FermenterRecipe read(Identifier id, JsonObject json) {
      FermenterRecipeJsonFormat recipeJson = new Gson().fromJson(json, FermenterRecipeJsonFormat.class);

      if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.inputC == null || recipeJson.bottle == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
      }
      if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

      Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
      Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
      Ingredient inputC = Ingredient.fromJson(recipeJson.inputC); 
      Ingredient bottle = Ingredient.fromJson(recipeJson.bottle); 
      Integer fermentTime = JsonHelper.getInt(json, "fermentTime", this.fermentTime);
      
      Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem)).orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
      ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);
      
      return new FermenterRecipe(inputA, inputB, inputC, bottle, output, fermentTime, id);
   }

   public void write(PacketByteBuf packetData, FermenterRecipe recipe) {
      recipe.getInputA().write(packetData);
      recipe.getInputB().write(packetData);
      recipe.getInputC().write(packetData);
      recipe.getBottle().write(packetData);
      packetData.writeInt(recipe.getFermentTime());
      packetData.writeItemStack(recipe.getOutput());
   }

   public FermenterRecipe read(Identifier recipeId, PacketByteBuf packetData) {
      Ingredient inputA = Ingredient.fromPacket(packetData);
      Ingredient inputB = Ingredient.fromPacket(packetData);
      Ingredient inputC = Ingredient.fromPacket(packetData);
      Ingredient bottle = Ingredient.fromPacket(packetData);
      int fermentTime = packetData.readVarInt();
      ItemStack output = packetData.readItemStack();
      return new FermenterRecipe(inputA, inputB, inputC, bottle, output, fermentTime, recipeId);
   }
}