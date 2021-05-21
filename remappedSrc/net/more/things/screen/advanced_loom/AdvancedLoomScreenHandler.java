package net.more.things.screen.advanced_loom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.more.things.MoreThingsMain;

public class AdvancedLoomScreenHandler extends ScreenHandler {
   private final ScreenHandlerContext context;
   private final Inventory inventory;
   protected final World world;
   private final Slot sissors;
   private final Slot headSlot;
   private final Slot chestSlot;
   private final Slot legginsSlot;
   private final Slot bootsSlot;

   public AdvancedLoomScreenHandler(int syncId, PlayerInventory playerInventory) {
      this(syncId, playerInventory, new SimpleInventory(9), ScreenHandlerContext.EMPTY);
   }

   public AdvancedLoomScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
         ScreenHandlerContext context) {
      super(MoreThingsMain.ADVANCED_LOOM_SCREEN_HANDLER, syncId);
      checkSize(inventory, 9);
      this.inventory = inventory;
      this.context = context;
      inventory.onOpen(playerInventory.player);
      this.world = playerInventory.player.world;

      this.addSlot(new Slot(inventory, 0, 13, 25));
      this.addSlot(new Slot(inventory, 1, 33, 25));
      this.addSlot(new Slot(inventory, 2, 13, 44));
      this.addSlot(new Slot(inventory, 3, 33, 44));

      // Sisors Slot
      this.sissors = this.addSlot(new AdvancedLoomSisorsSlot(this, inventory, 4, 73, 35));

      // Armor Slot
      this.headSlot = this.addSlot(new AdvancedLoomOutputSlot(inventory, 5, 119, 24));
      this.chestSlot = this.addSlot(new AdvancedLoomOutputSlot(inventory, 6, 119, 43));
      this.legginsSlot = this.addSlot(new AdvancedLoomOutputSlot(inventory, 7, 143, 24));
      this.bootsSlot = this.addSlot(new AdvancedLoomOutputSlot(inventory, 8, 143, 43));

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

   public void close(PlayerEntity player) {
      super.close(player);
      this.context.run((world, blockPos) -> {
         this.dropInventory(player, world, inventory);
      });
   }

   @Override
   public ItemStack transferSlot(PlayerEntity player, int index) {
      ItemStack newStack = ItemStack.EMPTY;
      Slot slot = this.slots.get(index);
      if (slot != null && slot.hasStack()) {
         ItemStack originalStack = slot.getStack();
         newStack = originalStack.copy();
         if (index == 4) {
            if (!this.insertItem(originalStack, 5, 39, true)) {
               return ItemStack.EMPTY;
            }

            slot.onStackChanged(originalStack, newStack);
            /*
             * } else if (index != 3 && index != 2 && index != 1 && index != 0) { if
             * (this.isSmeltable(originalStack)) { if (!this.insertItem(originalStack, 0, 3,
             * false)) { return ItemStack.EMPTY; } } else if (this.isFuel(originalStack)) {
             * if (!this.insertItem(originalStack, 3, 4, false)) { return ItemStack.EMPTY; }
             * } else if (index >= 5 && index < 30) { if (!this.insertItem(originalStack,
             * 30, 39, false)) { return ItemStack.EMPTY; } } else if (index >= 30 && index <
             * 39 && !this.insertItem(originalStack, 5, 30, false)) { return
             * ItemStack.EMPTY; }
             */
         } else if (!this.insertItem(originalStack, 5, 39, false)) {
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

   @Environment(EnvType.CLIENT)
   public Slot getSissorsSlot() {
      return this.sissors;
   }

   @Environment(EnvType.CLIENT)
   public Slot getHeadSlot() {
      return this.headSlot;
   }

   @Environment(EnvType.CLIENT)
   public Slot getChestSlot() {
      return this.chestSlot;
   }

   @Environment(EnvType.CLIENT)
   public Slot getLegginsSlot() {
      return this.legginsSlot;
   }

   @Environment(EnvType.CLIENT)
   public Slot getBootsSlot() {
      return this.bootsSlot;
   }

   protected boolean isWool(ItemStack itemStack) {
      return false;
      // return
      // this.world.getRecipeManager().getFirstMatch(FermenterRecipe.Type.INSTANCE,
      // new SimpleInventory(new ItemStack[]{itemStack}), this.world).isPresent();
   }
}
