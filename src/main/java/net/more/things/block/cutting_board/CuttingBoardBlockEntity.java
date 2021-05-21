package net.more.things.block.cutting_board;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;
import net.more.things.block.MoreThingsBlocks;

public class CuttingBoardBlockEntity extends BlockEntity implements BlockEntityClientSerializable{
   private ItemStack itemOn;

   public CuttingBoardBlockEntity() {
      super(MoreThingsBlocks.CUTTING_BOARD_BLOCK_ENTITY);
      this.itemOn = ItemStack.EMPTY;
   }

   public ItemStack getItem() {
      return this.itemOn;
   }

   @Override
   public void fromTag(BlockState state, CompoundTag tag) {
      super.fromTag(state, tag);
      DefaultedList<ItemStack> inv = DefaultedList.ofSize(1, ItemStack.EMPTY);
      Inventories.fromTag(tag, inv);
      this.itemOn = inv.get(0);
   }

   @Override
   public CompoundTag toTag(CompoundTag tag) {
      this.saveInitialChunkData(tag);
      return tag;
   }

   private CompoundTag saveInitialChunkData(CompoundTag tag) {
      super.toTag(tag);
      DefaultedList<ItemStack> inv = DefaultedList.ofSize(1, this.itemOn);
      Inventories.toTag(tag, inv, true);
      return tag;
   }

   public CompoundTag toInitialChunkDataTag() {
      return this.saveInitialChunkData(new CompoundTag());
   }

   public boolean addItem(ItemStack item) {
      if (this.itemOn.isEmpty()) {
         this.itemOn = item;
         this.updateListeners();
         return true;
      }
      return false;
   }

   private void updateListeners() {
      this.markDirty();
      this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
   }

   @Override
   public void fromClientTag(CompoundTag tag) {
      DefaultedList<ItemStack> inv = DefaultedList.ofSize(1, ItemStack.EMPTY);
      Inventories.fromTag(tag, inv);
      this.itemOn = inv.get(0);
   }

   @Override
   public CompoundTag toClientTag(CompoundTag tag) {
      this.saveInitialChunkData(tag);
      return tag;
   }
}