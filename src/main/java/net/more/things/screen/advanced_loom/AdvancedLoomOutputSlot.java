package net.more.things.screen.advanced_loom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class AdvancedLoomOutputSlot extends Slot {

   public AdvancedLoomOutputSlot(Inventory inventory, int index, int x, int y) {
      super(inventory, index, x, y);
   }

   public boolean canInsert(ItemStack stack) {
      return false;
   }

   public boolean canTakeItems(PlayerEntity playerEntity) {
      return false;
   }
}
