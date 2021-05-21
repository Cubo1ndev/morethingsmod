package net.more.things.recipes.drying_rack;

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

public class DryingRackRecipeSerializer implements RecipeSerializer<DryingRackRecipe> {
   private final int time = 0;

   private DryingRackRecipeSerializer() {}

   public static final DryingRackRecipeSerializer INSTANCE = new DryingRackRecipeSerializer();
   public static final Identifier ID = new Identifier("morethings:dry");

   public DryingRackRecipe read(Identifier id, JsonObject json) {
      DryingRackRecipeJsonFormat recipeJson = new Gson().fromJson(json, DryingRackRecipeJsonFormat.class);

      if (recipeJson.input == null && recipeJson.output == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
      }
      if (recipeJson.time == 0) recipeJson.time = 200;

      Ingredient input = Ingredient.fromJson(recipeJson.input);
      Integer time = JsonHelper.getInt(json, "time", this.time);
      
      Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.output)).orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.output));
      ItemStack output = new ItemStack(outputItem, 1);
      
      return new DryingRackRecipe(input, output, time, id);
   }

   public void write(PacketByteBuf packetData, DryingRackRecipe recipe) {
      recipe.getInput().write(packetData);
      packetData.writeInt(recipe.getTime());
      packetData.writeItemStack(recipe.getOutput());
   }

   public DryingRackRecipe read(Identifier recipeId, PacketByteBuf packetData) {
      Ingredient input = Ingredient.fromPacket(packetData);
      int time = packetData.readVarInt();
      ItemStack output = packetData.readItemStack();
      return new DryingRackRecipe(input, output, time, recipeId);
   }
}