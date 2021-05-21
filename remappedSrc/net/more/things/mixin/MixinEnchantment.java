package net.more.things.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;

@Mixin(Enchantment.class)
public abstract class MixinEnchantment {

	@Inject(at=@At("HEAD"), method="isAcceptableItem(Lnet/minecraft/item/ItemStack;)Z", cancellable=true)
	public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> ci) {
		if ((Object)this == Enchantments.FIRE_PROTECTION && stack.getItem().isEnchantable(stack)) {
			ci.setReturnValue(true);
		}
	}
	
}
