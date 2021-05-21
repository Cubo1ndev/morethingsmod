package net.more.things.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(SweetBerryBushBlock.class)
public class MixinSweetBerryBushBlock {
	
	@Inject(at=@At(value="INVOKE", target="net/minecraft/entity/Entity.damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"),
			method="onEntityCollision(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;)V", cancellable=true)
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
		if (entity instanceof LivingEntity
				&& !((LivingEntity)entity).getEquippedStack(EquipmentSlot.LEGS).isEmpty()
				&& !((LivingEntity)entity).getEquippedStack(EquipmentSlot.FEET).isEmpty()) {
			ci.cancel();
		}
	}
	

}
