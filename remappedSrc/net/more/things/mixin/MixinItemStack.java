package net.more.things.mixin;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class MixinItemStack {

	@Inject(at=@At("HEAD"), method="getRepairCost()I", cancellable=true)
	public void getRepairCost(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(0);
	}
	
}
