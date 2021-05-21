package net.more.things.screen.fermenter;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class FermenterFuelSlot extends Slot {
   private final FermenterScreenHandler handler;

   public FermenterFuelSlot(FermenterScreenHandler handler, Inventory inventory, int index, int x, int y) {
      super(inventory, index, x, y);
      this.handler = handler;
   }

   public boolean canInsert(ItemStack stack) {
      return this.handler.isFuel(stack) || isBucket(stack);
   }

   public int getMaxItemCount(ItemStack stack) {
      return isBucket(stack) ? 1 : super.getMaxItemCount(stack);
   }

   public static boolean isBucket(ItemStack stack) {
      return stack.getItem() == Items.BUCKET;
   }
}
