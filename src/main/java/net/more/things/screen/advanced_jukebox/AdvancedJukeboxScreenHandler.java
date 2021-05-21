package net.more.things.screen.advanced_jukebox;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.more.things.MoreThingsMain;

public class AdvancedJukeboxScreenHandler extends SyncedGuiDescription {
   private final Inventory inventory;
   protected final World world;
   PropertyDelegate propertyDelegate;

   public AdvancedJukeboxScreenHandler(int syncId, PlayerInventory playerInventory) {
      this(syncId, playerInventory, new SimpleInventory(1), new ArrayPropertyDelegate(2));
   }

   public AdvancedJukeboxScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
      super(MoreThingsMain.ADVANCED_JUKEBOX_SCREEN_HANDLER, syncId, playerInventory);
      checkSize(inventory, 1);
      this.inventory = inventory;
      this.propertyDelegate = propertyDelegate;
      inventory.onOpen(playerInventory.player);
      this.addProperties(propertyDelegate);
      this.world = playerInventory.player.world;

      this.addSlot(new Slot(inventory, 0, 22, 32));
      int m;
      int l;

      // The player inventory
      for (m = 0; m < 3; ++m) {
         for (l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
         }
      }
      // The player Hotbar
      for (m = 0; m < 9; ++m) {
         this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
      }

   }

   @Override
   public boolean canUse(PlayerEntity player) {
      return this.inventory.canPlayerUse(player);
   }

   @Override
   public ItemStack transferSlot(PlayerEntity player, int index) {
      ItemStack newStack = ItemStack.EMPTY;
      Slot slot = this.slots.get(index);
      if (slot != null && slot.hasStack()) {
         ItemStack originalStack = slot.getStack();
         newStack = originalStack.copy();
         if (index == 1) {
            if (!this.insertItem(originalStack, 0, 36, true)) {
               return ItemStack.EMPTY;
            }
            slot.onStackChanged(originalStack, newStack);
         } else if (index != 0) {
            /*if (originalStack.getItem().isIn(MoreThigns.MORE_MUSIC_DISCS)) {
               if (!this.insertItem(originalStack, 0, 1, false)) {
                  return ItemStack.EMPTY;
               }
            }*/
         } else if (!this.insertItem(originalStack, 0, 36, false)) {
            return ItemStack.EMPTY;
         }

         if (originalStack.isEmpty()) {
            slot.setStack(ItemStack.EMPTY);
         } else {
            slot.markDirty();
         }

         if (originalStack.getCount() == newStack.getCount()) {
            return ItemStack.EMPTY;
         }

         slot.onTakeItem(player, originalStack);
      }

      return newStack;
   }
}
