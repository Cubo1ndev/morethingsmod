package net.more.things.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;

@Mixin(ShulkerBulletEntity.class)
public abstract class MixinShulkerBulletEntity {

	@Inject(at=@At("HEAD"), method="tick()V", cancellable=true)
	public void tick(CallbackInfo ci) {
		Object self = this;
		if (!((Entity)self).world.isClient) {
			Entity owner = ((ProjectileEntity)self).getOwner();
			if (owner == null || !owner.isAlive()) {
				((Entity)self).remove();
				ci.cancel();
			}
		}
	}
	
}
