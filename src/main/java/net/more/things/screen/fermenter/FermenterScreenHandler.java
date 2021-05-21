package net.more.things.screen.fermenter;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
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

public class FermenterScreenHandler extends SyncedGuiDescription {
   private final Inventory inventory;
   protected final World world;
   private final Slot bottleSlot;
   private final Slot outputSlot;
   PropertyDelegate propertyDelegate;

   public FermenterScreenHandler(int syncId, PlayerInventory playerInventory) {
      this(syncId, playerInventory, new SimpleInventory(6), new ArrayPropertyDelegate(4));
   }

   public FermenterScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
      super(MoreThingsMain.FERMENTER_SCREEN_HANDLER, syncId, playerInventory);
      checkSize(inventory, 5);
      this.inventory = inventory;
      this.propertyDelegate = propertyDelegate;
      inventory.onOpen(playerInventory.player);
      this.addProperties(propertyDelegate);
      this.world = playerInventory.player.world;

      this.addSlot(new Slot(inventory, 0, 10, 18));
      this.addSlot(new Slot(inventory, 1, 30, 18));
      this.addSlot(new Slot(inventory, 2, 50, 18));
      this.addSlot(new FermenterFuelSlot(this, inventory, 4, 30, 54));
      this.bottleSlot = this.addSlot(new FermenterBottleSlot(this, inventory, 3, 92, 56));
      this.outputSlot =  this.addSlot(new FermenterOutputSlot(playerInventory.player, inventory, 5, 134, 53));

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
         /*ItemStack originalStack = slot.getStack();
         newStack = originalStack.copy();

         if (index == 5) {
            if (!this.insertItem(originalStack, 5, 39, true)) {
               return ItemStack.EMPTY;
            }

            slot.onStackChanged(originalStack, newStack);
         } else if (index != 4 && index != 3 && index != 2 && index != 1 && index != 0) {
            if (this.isFuel(originalStack)) {
               if (!this.insertItem(originalStack, 4, 5, false)) {
                  return ItemStack.EMPTY;
               }
            } else if (index >= 0 && index < 4) {
               if (!this.insertItem(originalStack, 0, 4, false)) {
                  return ItemStack.EMPTY;
               }
            } else if (index >= 5 && index < 30) {
               if (!this.insertItem(originalStack, 30, 42, false)) {
                  return ItemStack.EMPTY;
               }
            } else if (index >= 30 && index < 42 && !this.insertItem(originalStack, 6, 42, false)) {
               return ItemStack.EMPTY;
            }
         } else if (!this.insertItem(originalStack, 6, 42, false)) {
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

         slot.onTakeItem(player, originalStack);*/
      }

      return newStack;
   }

   protected boolean isFuel(ItemStack itemStack) {
      return AbstractFurnaceBlockEntity.canUseAsFuel(itemStack);
   }

   @Environment(EnvType.CLIENT)
   public Slot getBottleSlot() {
      return this.bottleSlot;
   }

   @Environment(EnvType.CLIENT)
   public Slot getOutputSlot() {
      return this.outputSlot;
   }

   @Environment(EnvType.CLIENT)
   public int getDel0() {
      return this.propertyDelegate.get(0);
   }

   @Environment(EnvType.CLIENT)
   public int getDel1() {
      return this.propertyDelegate.get(1);
   }

   @Environment(EnvType.CLIENT)
   public int getDel2() {
      return this.propertyDelegate.get(2);
   }

   @Environment(EnvType.CLIENT)
   public int getDel3() {
      return this.propertyDelegate.get(3);
   }
}
