package net.more.things.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class MixinGameRenderer {

	@Redirect(at=@At(value="INVOKE", target="net/minecraft/util/math/MathHelper.sin(F)F"),
			method="getNightVisionStrength(Lnet/minecraft/entity/LivingEntity;F)F")
	private static float flash(float f, LivingEntity entity) {
		float time = (f/((float)Math.PI*0.2f));
		if (time < 0) time = 0;
		float a = (time/200f);
		a = a*a;
		return (a-0.7f)/0.3f;
	}
	
}
