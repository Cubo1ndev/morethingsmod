package net.more.things.block.fermenter;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Recipe;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.MathHelper;
import net.more.things.api.ImplementedInventory;
import net.more.things.block.MoreThingsBlocks;
import net.more.things.recipes.fermenter.FermenterRecipe;
import net.more.things.screen.fermenter.FermenterScreenHandler;

public class FermenterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, Tickable, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory;
    private int burnTime;
    private int fuelTime;
    private int fermenterTime;
    private int fermenterTimeTotal;
    protected final PropertyDelegate propertyDelegate;

    public FermenterBlockEntity() {
       super(MoreThingsBlocks.FERMENTER_BLOCK_ENTITY);
       this.inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);
       this.propertyDelegate = new PropertyDelegate() {
          public int get(int index) {
             switch(index) {
             case 0:
                return FermenterBlockEntity.this.burnTime;
             case 1:
                return FermenterBlockEntity.this.fuelTime;
             case 2:
                return FermenterBlockEntity.this.fermenterTime;
             case 3:
                return FermenterBlockEntity.this.fermenterTimeTotal;
             default:
                return 0;
             }
          }
 
          public void set(int index, int value) {
             switch(index) {
             case 0:
                FermenterBlockEntity.this.burnTime = value;
                break;
             case 1:
                FermenterBlockEntity.this.fuelTime = value;
                break;
             case 2:
                FermenterBlockEntity.this.fermenterTime = value;
                break;
             case 3:
                FermenterBlockEntity.this.fermenterTimeTotal = value;
             }
 
          }
 
          public int size() {
             return 6;
          }
       };
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new FermenterScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
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
      boolean bl = this.isBurning();
      boolean bl2 = false;
        if (this.isBurning()) {
           --this.burnTime;
        }

        if (!this.world.isClient) {
            ItemStack itemStack = (ItemStack)this.inventory.get(4);
            if (!this.isBurning() && (itemStack.isEmpty() || ((((ItemStack)this.inventory.get(0)).isEmpty() || ((ItemStack)this.inventory.get(1)).isEmpty() || ((ItemStack)this.inventory.get(2)).isEmpty())))) {
                if (!this.isBurning() && this.fermenterTime > 0) {
                   this.fermenterTime = MathHelper.clamp(this.fermenterTime - 2, 0, this.fermenterTimeTotal);
                }
            } else {
                Recipe<?> recipe = world.getRecipeManager().getFirstMatch(FermenterRecipe.Type.INSTANCE, this, this.world).orElse((FermenterRecipe)null);
                if (!this.isBurning() && this.canAcceptRecipeOutput(recipe)) {
                    this.burnTime = this.getFuelTime(itemStack); // DICKKKKKKKKKKKKKKKKK!! fuck your mom 😁
                    this.fuelTime = this.burnTime;
                    if (this.isBurning()) {
                        if (!itemStack.isEmpty()) {
                           Item item = itemStack.getItem();
                           itemStack.decrement(1);
                           if (itemStack.isEmpty()) {
                              Item item2 = item.getRecipeRemainder();
                              this.inventory.set(4, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                           }
                        }
                    }
                }

                if (this.isBurning() && this.canAcceptRecipeOutput(recipe)) {
                   ++this.fermenterTime; 
                   if (this.fermenterTime == this.fermenterTimeTotal) {
                      this.fermenterTime = 0;
                      this.fermenterTimeTotal = this.getFermentTime();
                      this.craftRecipe(recipe);
                   }
                } else {
                   this.fermenterTime = 0;
                }
            }
            if (bl != this.isBurning()) {
               bl2 = true;
               this.world.setBlockState(this.pos, (BlockState)this.world.getBlockState(this.pos).with(FermenterBlock.LIT, this.isBurning()), 3);
            }
        }

        if (bl2) {
           this.markDirty();
        }
    }

    private void craftRecipe(@Nullable Recipe<?> recipe) {
       if (recipe != null && this.canAcceptRecipeOutput(recipe)) {
          ItemStack itemStack = (ItemStack)this.inventory.get(0);
          ItemStack itemStack2 = (ItemStack)this.inventory.get(1);
          ItemStack itemStack3 = (ItemStack)this.inventory.get(2);
          ItemStack itemStack4 = (ItemStack)this.inventory.get(3);
          ItemStack itemStack5 = recipe.getOutput();
          ItemStack itemStack6 = (ItemStack)this.inventory.get(5);
          if (itemStack6.isEmpty()) {
            this.inventory.set(5, itemStack5.copy());
          } else if (itemStack6.getItem() == itemStack5.getItem()) {
            itemStack6.increment(1);
          }
 
          itemStack.decrement(1);
          itemStack2.decrement(1);
          itemStack3.decrement(1);
          itemStack4.decrement(1);
       }
    }

    protected boolean canAcceptRecipeOutput(@Nullable Recipe<?> recipe) {
       if ((!((ItemStack)this.inventory.get(0)).isEmpty() && !((ItemStack)this.inventory.get(1)).isEmpty() && !((ItemStack)this.inventory.get(2)).isEmpty()) && recipe != null) {
          ItemStack itemStack = recipe.getOutput(); 
          if (itemStack.isEmpty()) {
             return false;
          } else {
             ItemStack itemStack2 = (ItemStack)this.inventory.get(5);
             if (itemStack2.isEmpty()) {
                return true;
             } else if (!itemStack2.isItemEqualIgnoreDamage(itemStack)) {
                return false;
             } else if (itemStack2.getCount() < this.getMaxCountPerStack() && itemStack2.getCount() < itemStack2.getMaxCount()) {
                return true;
             } else {
                return itemStack2.getCount() < itemStack.getMaxCount();
             }
          }
       } else {
          return false;
       }
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, this.inventory);
        this.burnTime = tag.getShort("BurnTime");
        this.fermenterTime = tag.getShort("FermenterTime");
        this.fermenterTimeTotal = tag.getShort("FermenterTimeTotal");
        this.fuelTime = this.getFuelTime((ItemStack)this.inventory.get(4));
    }
    //fermenterTime
    @Override
    public CompoundTag toTag(CompoundTag tag) {
         super.toTag(tag);
         tag.putShort("BurnTime", (short)this.burnTime);
         tag.putShort("FermenterTime", (short)this.fermenterTime);
         tag.putShort("FermenterTimeTotal", (short)this.fermenterTimeTotal);
         Inventories.toTag(tag, this.inventory);
 
         return tag;
   }

   public void setStack(int slot, ItemStack stack) {
      ItemStack itemStack = (ItemStack)this.inventory.get(slot);
      boolean bl = !stack.isEmpty() && stack.isItemEqualIgnoreDamage(itemStack) && ItemStack.areTagsEqual(stack, itemStack);
      this.inventory.set(slot, stack);
      if (stack.getCount() > this.getMaxCountPerStack()) {
         stack.setCount(this.getMaxCountPerStack());
      }

      if (slot == 0 && !bl) {
         this.fermenterTimeTotal = this.getFermentTime();
         this.fermenterTime = 0;
         this.markDirty();
      }

   }

   protected int getFermentTime() {
      return (Integer)this.world.getRecipeManager().getFirstMatch(FermenterRecipe.Type.INSTANCE, this, this.world).map(FermenterRecipe::getFermentTime).orElse(200);
   }

   protected int getFuelTime(ItemStack fuel) {
      if (fuel.isEmpty()) {
         return 0;
      } else {
         Item item = fuel.getItem();
         return (Integer)AbstractFurnaceBlockEntity.createFuelTimeMap().getOrDefault(item, 0);
      }
   }
    private boolean isBurning() {
      return this.burnTime > 0;
   }
 }