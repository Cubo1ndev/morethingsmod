  
package net.more.things.item.DrinkableItems;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Formatting;

public class VodkaItem extends DrinkableItemWithEffect {

    public VodkaItem(Settings settings, Item rI) {
        super(settings, rI);
        this.returnItem = rI;
        statusEffects.add(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 2));
    }

    @Override
    public Formatting getFormatting() {
        return Formatting.WHITE;
    }
}