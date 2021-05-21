package net.more.things.block.drying_rack;

import java.util.Optional;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.more.things.block.MoreThingsBlocks;
import net.more.things.recipes.drying_rack.DryingRackRecipe;

public class DryingRackBlockEntity extends BlockEntity implements Tickable, BlockEntityClientSerializable{
   private ItemStack itemOn;
   private int time;
   private int totalTime;

   public DryingRackBlockEntity() {
      super(MoreThingsBlocks.DRYINGRACK_BLOCK_ENTITY);
      this.itemOn = ItemStack.EMPTY;
      this.time = 0;
      this.totalTime = 0;
   }

   @Override
   public void tick() {
      ItemStack itemStack = itemOn;
      if (!itemStack.isEmpty()) {
         ++this.time;
         if (this.time >= this.totalTime) {
            Inventory inventory = new SimpleInventory(new ItemStack[] { itemStack });
            ItemStack itemStack2 = (ItemStack) this.world.getRecipeManager()
                  .getFirstMatch(DryingRackRecipe.Type.INSTANCE, inventory, this.world).map((campfireCookingRecipe) -> {
                     return campfireCookingRecipe.craft(inventory);
                  }).orElse(itemStack);
            this.itemOn = itemStack2;
            this.time = 0;
            this.totalTime = 0;
            this.updateListeners();
         }
      }
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
      this.time = tag.getShort("Time");
      this.totalTime = tag.getShort("TotalTime");
   }

   @Override
   public CompoundTag toTag(CompoundTag tag) {
      this.saveInitialChunkData(tag);
      tag.putShort("Time", (short) this.time);
      tag.putShort("TotalTime", (short) this.totalTime);
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

   public Optional<DryingRackRecipe> getRecipeFor(ItemStack item) {
      DefaultedList<ItemStack> inv = DefaultedList.ofSize(1, this.itemOn);
      return inv.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.world.getRecipeManager().getFirstMatch(DryingRackRecipe.Type.INSTANCE, new SimpleInventory(new ItemStack[]{item}), this.world);
   }

   public boolean addItem(ItemStack item, int integer) {
      if (this.itemOn.isEmpty()) {
         this.totalTime = integer;
         this.time = 0;
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
      this.time = tag.getShort("Time");
      this.totalTime = tag.getShort("TotalTime");
   }

   @Override
   public CompoundTag toClientTag(CompoundTag tag) {
      this.saveInitialChunkData(tag);
      tag.putShort("Time", (short) this.time);
      tag.putShort("TotalTime", (short) this.totalTime);
      return tag;
   }
}