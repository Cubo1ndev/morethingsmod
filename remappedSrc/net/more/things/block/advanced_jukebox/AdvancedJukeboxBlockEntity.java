package net.more.things.block.advanced_jukebox;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.more.things.api.ImplementedInventory;
import net.more.things.block.MoreThingsBlocks;
import net.more.things.screen.advanced_jukebox.AdvancedJukeboxScreenHandler;
import org.jetbrains.annotations.Nullable;

public class AdvancedJukeboxBlockEntity extends BlockEntity
      implements NamedScreenHandlerFactory, Tickable, ImplementedInventory {
   private DefaultedList<ItemStack> inventory;
   private int discTime;
   private int discTotalTime;
   private ItemStack lastDisc;
   protected final PropertyDelegate propertyDelegate;

   public AdvancedJukeboxBlockEntity() {
      super(MoreThingsBlocks.ADVANCEND_JUKEBOX_BLOCK_ENTITY);
      this.inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
      this.propertyDelegate = new PropertyDelegate() {
         public int get(int index) {
            switch (index) {
               case 0:
                  return AdvancedJukeboxBlockEntity.this.discTime;
               case 1:
                  return AdvancedJukeboxBlockEntity.this.discTotalTime;
               default:
                  return 0;
            }
         }

         public void set(int index, int value) {
            switch (index) {
               case 0:
                  AdvancedJukeboxBlockEntity.this.discTime = value;
                  break;
               case 1:
                  AdvancedJukeboxBlockEntity.this.discTotalTime = value;
            }

         }

         public int size() {
            return 1;
         }
      };
   }

   @Override
   public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
      return new AdvancedJukeboxScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
   }

   @Override
   public Text getDisplayName() {
      return new TranslatableText(getCachedState().getBlock().getTranslationKey());
   }

   @Override
   public DefaultedList<ItemStack> getItems() {
      return inventory;
   }

   public void stopSounds() {
      this.lastDisc = null;
      if (!world.isClient) {
         world.syncWorldEvent(1010, pos, 0);
      }
   }

   @Override
   public void tick() {
      ItemStack itemStack = (ItemStack) this.inventory.get(0);
      
      //if (!world.isClient) System.out.println(itemStack.getItem());

      if (itemStack.getItem() == Items.AIR || (this.lastDisc != null &&  itemStack.getItem() != this.lastDisc.getItem())) {
         stopSounds();
      } else if (this.lastDisc != itemStack && itemStack.getItem() != null && itemStack.getItem() instanceof MusicDiscItem) {
         if (this.discTotalTime == 0) {
            //this.discTotalTime = ((MusicDiscItem) itemStack.getItem()).getSound();
            this.lastDisc = itemStack;
            if (!world.isClient) {
               this.stopSounds();
               world.syncWorldEvent((PlayerEntity) null, 1010, pos, Item.getRawId(itemStack.getItem()));
            }
         }
      }
   }

   public ItemStack getDiscs() {
      ItemStack itemStack = this.inventory.get(0);
      return itemStack;
   }

   @Override
   public void fromTag(BlockState state, CompoundTag tag) {
      super.fromTag(state, tag);

      Inventories.fromTag(tag, this.inventory);
      this.discTime = tag.getShort("DiscTime");
      this.discTotalTime = tag.getShort("DiscTotalTime");
   }

   @Override
   public CompoundTag toTag(CompoundTag tag) {
      super.toTag(tag);
      tag.putShort("DiscTime", (short) this.discTime);
      tag.putShort("DiscTotalTime", (short) this.discTotalTime);
      Inventories.toTag(tag, this.inventory);
      return tag;
   }
}