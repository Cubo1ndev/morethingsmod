package net.more.things.recipes.advanced_loom;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AdvancedLoomRecipeSerializer implements RecipeSerializer<AdvancedLoomRecipe> {

   private AdvancedLoomRecipeSerializer() {}

   public static final AdvancedLoomRecipeSerializer INSTANCE = new AdvancedLoomRecipeSerializer();
   public static final Identifier ID = new Identifier("morethings:sew");

   public AdvancedLoomRecipe read(Identifier id, JsonObject json) {
      AdvancedLoomRecipeJsonFormat recipeJson = new Gson().fromJson(json, AdvancedLoomRecipeJsonFormat.class);

      if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.inputC == null || recipeJson.inputD == null || recipeJson.outputItemA == null || recipeJson.outputItemB == null || recipeJson.outputItemC == null || recipeJson.outputItemD == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
      }
      if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

      Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
      Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
      Ingredient inputC = Ingredient.fromJson(recipeJson.inputC); 
      Ingredient inputD = Ingredient.fromJson(recipeJson.inputD);
      
      Item outputItemA = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItemA)).orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItemA));
      ItemStack outputA = new ItemStack(outputItemA, recipeJson.outputAmount);
      
      Item outputItemB = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItemB)).orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItemB));
      ItemStack outputB = new ItemStack(outputItemB, recipeJson.outputAmount);
      
      Item outputItemC = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItemC)).orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItemC));
      ItemStack outputC = new ItemStack(outputItemC, recipeJson.outputAmount);
      
      Item outputItemD = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItemD)).orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItemD));
      ItemStack outputD = new ItemStack(outputItemD, recipeJson.outputAmount);
      
      return new AdvancedLoomRecipe(inputA, inputB, inputC, inputD, outputA, outputB, outputC, outputD, id);
   }

   public void write(PacketByteBuf packetData, AdvancedLoomRecipe recipe) {
      recipe.getInputA().write(packetData);
      recipe.getInputB().write(packetData);
      recipe.getInputC().write(packetData);
      recipe.getInputD().write(packetData);
      packetData.writeItemStack(recipe.getOutputA());
      packetData.writeItemStack(recipe.getOutputB());
      packetData.writeItemStack(recipe.getOutputC());
      packetData.writeItemStack(recipe.getOutputD());
   }

   public AdvancedLoomRecipe read(Identifier recipeId, PacketByteBuf packetData) {
      Ingredient inputA = Ingredient.fromPacket(packetData);
      Ingredient inputB = Ingredient.fromPacket(packetData);
      Ingredient inputC = Ingredient.fromPacket(packetData);
      Ingredient inputD = Ingredient.fromPacket(packetData);
      ItemStack outputA = packetData.readItemStack();
      ItemStack outputB = packetData.readItemStack();
      ItemStack outputC = packetData.readItemStack();
      ItemStack outputD = packetData.readItemStack();
      return new AdvancedLoomRecipe(inputA, inputB, inputC, inputD, outputA, outputB, outputC, outputD, recipeId);
   }
}