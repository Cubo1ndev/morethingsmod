package net.more.things.item.DrinkableItems;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class DrinkableItemWithEffect extends DrinkableItem {
    protected final List<StatusEffectInstance> statusEffects;

    public DrinkableItemWithEffect(Settings settings, Item rI) {
        super(settings, rI);
        this.returnItem = rI;
        statusEffects = new ArrayList<>();
    }

    @Override
    public void runDrinkAction(ItemStack stack, World world, LivingEntity user, ServerPlayerEntity playerEntity) {
        for (StatusEffectInstance statusEffectInstance : statusEffects) {
            if (statusEffectInstance.getEffectType().isInstant()) {
                statusEffectInstance.getEffectType().applyInstantEffect(playerEntity, playerEntity, user, statusEffectInstance.getAmplifier(), 1.0D);
            } else {
                user.addStatusEffect(new StatusEffectInstance(statusEffectInstance));
            }
        }
    }
}
