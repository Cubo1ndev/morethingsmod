package net.more.things.block.advanced_loom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.more.things.api.ImplementedInventory;
import net.more.things.block.MoreThingsBlocks;
import net.more.things.screen.advanced_loom.AdvancedLoomScreenHandler;

public class AdvancedLoomBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, Tickable, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory;

    public AdvancedLoomBlockEntity() {
       super(MoreThingsBlocks.ADVANCEND_LOOM_BLOCK_ENTITY);
       this.inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
       return new AdvancedLoomScreenHandler(syncId, playerInventory, this, ScreenHandlerContext.EMPTY);
    }

    @Override
    public Text getDisplayName() {
       return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
       return inventory;
    }

    @Override
    public void tick() {
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
       super.fromTag(state, tag);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
         super.toTag(tag);
         return tag;
   }
 }