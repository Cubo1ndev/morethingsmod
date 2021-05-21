package net.more.things.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.more.things.MarihuanaFood;
import net.more.things.MoreThingsMain;
import net.more.things.item.DrinkableItems.VodkaItem;

public class MoreThingsItems {
	public static final Item RAW_IRON = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAW_GOLD = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item MARIHUANA = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item MARIHUANA_DUST = new Item(new Item.Settings().group(ItemGroup.MATERIALS).food(MarihuanaFood.MARIHUANA_DUST));
	public static final Item HIERRO_COIN = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item ORO_COIN = new Item(new Item.Settings().group(ItemGroup.MATERIALS).rarity(Rarity.UNCOMMON));
	public static final Item DIAMANTE_COIN = new Item(new Item.Settings().group(ItemGroup.MATERIALS).rarity(Rarity.RARE));
	public static final Item ESMERALDA_COIN = new Item(new Item.Settings().group(ItemGroup.MATERIALS).rarity(Rarity.EPIC));

	public static final Item RAWHIDE_COW = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAWHIDE_HORSE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAWHIDE_LLAMA = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAWHIDE_MOOSHROOM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAWHIDE_MULE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAWHIDE_PIG = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAWHIDE_POLARBEAR = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item RAWHIDE_WOLF = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static Item RAWHIDE_COW_ITEM, RAWHIDE_HORSE_ITEM, RAWHIDE_LLAMA_ITEM, RAWHIDE_MOOSHROOM_ITEM;
	public static Item RAWHIDE_MULE_ITEM, RAWHIDE_PIG_ITEM, RAWHIDE_POLARBEAR_ITEM, RAWHIDE_WOLF_ITEM;

	public static final Item NORMAL_BOTTLE = new Item(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1));
	public static final Item VODKA_BOTTLE_1 = new VodkaItem(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1), NORMAL_BOTTLE);
	public static final Item VODKA_BOTTLE_2 = new VodkaItem(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1), VODKA_BOTTLE_1);
	public static final Item VODKA_BOTTLE_3 = new VodkaItem(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1), VODKA_BOTTLE_2);
	public static final Item VODKA_BOTTLE_4 = new VodkaItem(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1), VODKA_BOTTLE_3);
	public static final Item SEMEN_BUCKET_ITEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1));
	public static Item SEMEN_BUCKET;
	public static Item PLUMAGAY_MUSIC_DISC;

	public static final Item MASCARILLA = new ArmorItem(MascarillaArmor.MASCARILLA, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));

    public static void registerItems() {
		SEMEN_BUCKET = Registry.register(Registry.ITEM, MoreThingsMain.id("semen_bucket"), SEMEN_BUCKET_ITEM);
		PLUMAGAY_MUSIC_DISC = Registry.register(Registry.ITEM, MoreThingsMain.id("music_disc_plumagay"), new PlumagayDisc());

		Registry.register(Registry.ITEM, MoreThingsMain.id("raw_iron"), RAW_IRON);
		Registry.register(Registry.ITEM, MoreThingsMain.id("raw_gold"), RAW_GOLD);

		Registry.register(Registry.ITEM, MoreThingsMain.id("marihuana_dust"), MARIHUANA_DUST);
		Registry.register(Registry.ITEM, MoreThingsMain.id("iron_coin"), HIERRO_COIN);
		Registry.register(Registry.ITEM, MoreThingsMain.id("gold_coin"), ORO_COIN);
		Registry.register(Registry.ITEM, MoreThingsMain.id("diamond_coin"), DIAMANTE_COIN);
		Registry.register(Registry.ITEM, MoreThingsMain.id("emerald_coin"), ESMERALDA_COIN);
		
		RAWHIDE_COW_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_cow"), RAWHIDE_COW);
		RAWHIDE_HORSE_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_horse"), RAWHIDE_HORSE);
		RAWHIDE_LLAMA_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_llama"), RAWHIDE_LLAMA);
		RAWHIDE_MOOSHROOM_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_mooshroom"), RAWHIDE_MOOSHROOM);
		RAWHIDE_MULE_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_mule"), RAWHIDE_MULE);
		RAWHIDE_PIG_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_pig"), RAWHIDE_PIG);
		RAWHIDE_POLARBEAR_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_polarbear"), RAWHIDE_POLARBEAR);
		RAWHIDE_WOLF_ITEM = Registry.register(Registry.ITEM, MoreThingsMain.id("rawhide_wolf"), RAWHIDE_WOLF);

		Registry.register(Registry.ITEM, MoreThingsMain.id("normal_bottle"), NORMAL_BOTTLE);
		Registry.register(Registry.ITEM, MoreThingsMain.id("vodka_bottle_quarter"), VODKA_BOTTLE_1);
		Registry.register(Registry.ITEM, MoreThingsMain.id("vodka_bottle_medium"), VODKA_BOTTLE_2);
		Registry.register(Registry.ITEM, MoreThingsMain.id("vodka_bottle_three_quarters"), VODKA_BOTTLE_3);
		Registry.register(Registry.ITEM, MoreThingsMain.id("vodka_bottle_all"), VODKA_BOTTLE_4);

		Registry.register(Registry.ITEM, MoreThingsMain.id("mascarilla"), MASCARILLA);
		MoreThingsMain.MARIHUANA = Registry.register(Registry.ITEM, MoreThingsMain.id("marihuana"), MARIHUANA);
    }
}
