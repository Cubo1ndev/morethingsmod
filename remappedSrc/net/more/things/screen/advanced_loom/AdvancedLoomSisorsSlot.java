package net.more.things.screen.advanced_loom;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class AdvancedLoomSisorsSlot extends Slot {

   public AdvancedLoomSisorsSlot(AdvancedLoomScreenHandler handler, Inventory inventory, int index, int x, int y) {
      super(inventory, index, x, y);
   }

   public boolean canInsert(ItemStack stack) {
      if (stack.getItem() == Items.SHEARS) {
         return true;
      }
      return false;
   }
}
