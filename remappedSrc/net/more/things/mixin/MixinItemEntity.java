package net.more.things.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;

@Mixin(ItemEntity.class)
public abstract class MixinItemEntity {

	@Shadow
	public abstract ItemStack getStack();
	
	@Inject(at=@At("HEAD"), method="isFireImmune()Z", cancellable=true)
	public void isFireImmune(CallbackInfoReturnable<Boolean> cir) {
		if (EnchantmentHelper.getLevel(Enchantments.FIRE_PROTECTION, getStack()) > 0) {
			cir.setReturnValue(true);
		}
	}
	
}
