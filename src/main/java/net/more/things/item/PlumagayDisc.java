package net.more.things.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Rarity;
import net.more.things.sounds.MoreThingsSounds;

public class PlumagayDisc extends MusicDiscItem {
	public PlumagayDisc() {
		super(0, MoreThingsSounds.PLUMAGAY_SOUND, new FabricItemSettings().group(ItemGroup.MISC).maxCount(1).rarity(Rarity.RARE));
	}
}
