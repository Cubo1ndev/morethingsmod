package net.more.things.screen.fermenter;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class FermenterBottleSlot extends Slot {

   public FermenterBottleSlot(FermenterScreenHandler handler, Inventory inventory, int index, int x, int y) {
      super(inventory, index, x, y);
   }

   public boolean canInsert(ItemStack stack) {
      
      return true;
   }

   public int getMaxItemCount(ItemStack stack) {
      return super.getMaxItemCount(stack);
   }
}
