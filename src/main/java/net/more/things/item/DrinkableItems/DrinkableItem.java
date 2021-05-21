package net.more.things.item.DrinkableItems;

import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.more.things.item.MoreThingsItems;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;

public abstract class DrinkableItem extends Item {
	public Item returnItem;

	public DrinkableItem(Settings settings, Item returnItem) {
		super(settings);
		this.returnItem = returnItem;
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof ServerPlayerEntity) {
			Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) user, stack);
		}

		if (user instanceof PlayerEntity && !((PlayerEntity) user).abilities.creativeMode) {
			stack.decrement(1);
		}

		if (!world.isClient) {
			runDrinkAction(stack, world, user, (ServerPlayerEntity) user);
		}

		return returnItem != null ? new ItemStack(returnItem) : new ItemStack(MoreThingsItems.NORMAL_BOTTLE);
	}

	public abstract void runDrinkAction(ItemStack stack, World world, LivingEntity user,
			ServerPlayerEntity playerEntity);

	public abstract Formatting getFormatting();

	@Override
	public Text getName(ItemStack stack) {
		return ((TranslatableText) super.getName(stack)).formatted(getFormatting());
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 32;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		return ItemUsage.consumeHeldItem(world, user, hand);
	}
}
