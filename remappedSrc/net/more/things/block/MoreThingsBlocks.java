package net.more.things.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import net.more.things.MoreThingsMain;
import net.more.things.block.advanced_jukebox.AdvancedJukeboxBlock;
import net.more.things.block.advanced_jukebox.AdvancedJukeboxBlockEntity;
import net.more.things.block.advanced_loom.AdvancedLoomBlock;
import net.more.things.block.advanced_loom.AdvancedLoomBlockEntity;
import net.more.things.block.fermenter.FermenterBlock;
import net.more.things.block.fermenter.FermenterBlockEntity;

public class MoreThingsBlocks {
	public static final Block PACKET_MARIHUANA = new Block(FabricBlockSettings.of(Material.LEAVES).strength(0F, 0F).sounds(BlockSoundGroup.GRASS).breakInstantly());
    public static final Item PACKET_MARIHUANA_ITEM = new BlockItem(PACKET_MARIHUANA, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final FermenterBlock FERMENTER = new FermenterBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).nonOpaque());
    public static final Item FERMENTER_ITEM = new BlockItem(FERMENTER, new Item.Settings().group(ItemGroup.DECORATIONS));

	public static final AdvancedJukeboxBlock ADVANCED_JUKEBOX = new AdvancedJukeboxBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 9.0F).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES).nonOpaque());
    public static final Item ADVANCED_JUKEBOX_ITEM = new BlockItem(ADVANCED_JUKEBOX, new Item.Settings().group(ItemGroup.DECORATIONS));
    
	public static final AdvancedLoomBlock ADVANCED_LOOM = new AdvancedLoomBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 9.0F).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES).nonOpaque());
    public static final Item ADVANCED_LOOM_ITEM = new BlockItem(ADVANCED_LOOM, new Item.Settings().group(ItemGroup.DECORATIONS));

	public static final Block PIGGY_BANK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.0F, 9.0F).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES));
    public static final Item PIGGY_BANK_ITEM = new BlockItem(PIGGY_BANK, new Item.Settings().group(ItemGroup.DECORATIONS));
    
    public static final LayerBlock SAND_LAYER = new LayerBlock(FabricBlockSettings.of(Material.AGGREGATE).sounds(BlockSoundGroup.SAND).hardness(0.5f).resistance(0.5f));
    public static final LayerBlock RED_SAND_LAYER = new LayerBlock(FabricBlockSettings.of(Material.AGGREGATE).sounds(BlockSoundGroup.SAND).hardness(0.5f).resistance(0.5f));
    public static final LayerBlock GRAVEL_LAYER = new LayerBlock(FabricBlockSettings.of(Material.AGGREGATE).sounds(BlockSoundGroup.GRAVEL).hardness(0.5f).resistance(0.5f));

    public static final Item SAND_LAYER_ITEM = new BlockItem(SAND_LAYER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RED_SAND_LAYER_ITEM = new BlockItem(RED_SAND_LAYER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item GRAVEL_LAYER_ITEM = new BlockItem(GRAVEL_LAYER, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Block COMPACT_COBBLESTONE_1 = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block COMPACT_COBBLESTONE_2 = new Block(FabricBlockSettings.of(Material.STONE).strength(6.0F, 18.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block COMPACT_COBBLESTONE_3 = new Block(FabricBlockSettings.of(Material.STONE).strength(12.0F, 36.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block COMPACT_COBBLESTONE_4 = new Block(FabricBlockSettings.of(Material.STONE).strength(24.0F, 72.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
    
    public static final Item COMPACT_COBBLESTONE_1_ITEM = new BlockItem(COMPACT_COBBLESTONE_1, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item COMPACT_COBBLESTONE_2_ITEM = new BlockItem(COMPACT_COBBLESTONE_2, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item COMPACT_COBBLESTONE_3_ITEM = new BlockItem(COMPACT_COBBLESTONE_3, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item COMPACT_COBBLESTONE_4_ITEM = new BlockItem(COMPACT_COBBLESTONE_4, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Block CARVED_DIORITE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block CARVED_GRANITE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block CARVED_STONE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block LONDON_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block MIXED_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block ROMAN_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block POLISHED_GLOWSTONE = new Block(FabricBlockSettings.of(Material.GLASS).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SMOOTH_GLOWSTONE = new Block(FabricBlockSettings.of(Material.GLASS).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SMOOTH_GLOWSTONE_CONTRAST = new Block(FabricBlockSettings.of(Material.GLASS).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SNOW_BRICKS = new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));

    public static final Item CARVED_DIORITE_ITEM = new BlockItem(CARVED_DIORITE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item CARVED_GRANITE_ITEM = new BlockItem(CARVED_GRANITE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item CARVED_STONE_ITEM = new BlockItem(CARVED_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item LONDON_BRICKS_ITEM = new BlockItem(LONDON_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item MIXED_BRICKS_ITEM = new BlockItem(MIXED_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item ROMAN_BRICKS_ITEM = new BlockItem(ROMAN_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item POLISHED_GLOWSTONE_ITEM = new BlockItem(POLISHED_GLOWSTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SMOOTH_GLOWSTONE_ITEM = new BlockItem(SMOOTH_GLOWSTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SMOOTH_GLOWSTONE_CONTRAST_ITEM = new BlockItem(SMOOTH_GLOWSTONE_CONTRAST, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SNOW_BRICKS_ITEM = new BlockItem(SNOW_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    
	public static final Block STONE_BIG_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block RANDOM_SQUARE_STONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SMALL_SQUARE_STONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SMALL_STONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SQUARE_STONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block BIG_SANDSTONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block RANDOM_SANDSTONE_SQUARES_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SANDSTONE_SQUARE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SMALL_SANDSTONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block SMALL_SANDSTONE_SQUARES_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));

    public static final Item STONE_BIG_BRICKS_ITEM = new BlockItem(STONE_BIG_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RANDOM_SQUARE_STONE_BRICKS_ITEM = new BlockItem(RANDOM_SQUARE_STONE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SMALL_SQUARE_STONE_BRICKS_ITEM = new BlockItem(SMALL_SQUARE_STONE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SMALL_STONE_BRICKS_ITEM = new BlockItem(SMALL_STONE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SQUARE_STONE_BRICKS_ITEM = new BlockItem(SQUARE_STONE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item BIG_SANDSTONE_BRICKS_ITEM = new BlockItem(BIG_SANDSTONE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RANDOM_SANDSTONE_SQUARES_BRICKS_ITEM = new BlockItem(RANDOM_SANDSTONE_SQUARES_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SANDSTONE_SQUARE_BRICKS_ITEM = new BlockItem(SANDSTONE_SQUARE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SMALL_SANDSTONE_BRICKS_ITEM = new BlockItem(SMALL_SANDSTONE_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item SMALL_SANDSTONE_SQUARES_BRICKS_ITEM = new BlockItem(SMALL_SANDSTONE_SQUARES_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static final Block LONDON_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 9.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
    public static final Item LONDON_BRICKS_SLAB_ITEM = new BlockItem(LONDON_BRICKS_SLAB, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	public static BlockEntityType<FermenterBlockEntity> FERMENTER_BLOCK_ENTITY;
	public static BlockEntityType<AdvancedLoomBlockEntity> ADVANCEND_LOOM_BLOCK_ENTITY;
	public static BlockEntityType<AdvancedJukeboxBlockEntity> ADVANCEND_JUKEBOX_BLOCK_ENTITY;
    public static Block FERMENTERBLOCK, ADVANCEDLOOM, ADVANCENDJUKEBOX, PIGGYBANKBLOCK;

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, MoreThingsMain.id("sand_layer"), SAND_LAYER);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("red_sand_layer"), RED_SAND_LAYER);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("gravel_layer"), GRAVEL_LAYER);

        Registry.register(Registry.ITEM, MoreThingsMain.id("sand_layer"), SAND_LAYER_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("red_sand_layer"), RED_SAND_LAYER_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("gravel_layer"), GRAVEL_LAYER_ITEM);

        Registry.register(Registry.BLOCK, MoreThingsMain.id("compact_cobblestone_1"), COMPACT_COBBLESTONE_1);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("compact_cobblestone_2"), COMPACT_COBBLESTONE_2);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("compact_cobblestone_3"), COMPACT_COBBLESTONE_3);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("compact_cobblestone_4"), COMPACT_COBBLESTONE_4);

        Registry.register(Registry.ITEM, MoreThingsMain.id("compact_cobblestone_1"), COMPACT_COBBLESTONE_1_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("compact_cobblestone_2"), COMPACT_COBBLESTONE_2_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("compact_cobblestone_3"), COMPACT_COBBLESTONE_3_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("compact_cobblestone_4"), COMPACT_COBBLESTONE_4_ITEM);

        Registry.register(Registry.BLOCK, MoreThingsMain.id("carved_diorite"), CARVED_DIORITE);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("carved_granite"), CARVED_GRANITE);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("carved_stone"), CARVED_STONE);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("london_bricks"), LONDON_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("mixed_bricks"), MIXED_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("roman_bricks"), ROMAN_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("polished_glowstone"), POLISHED_GLOWSTONE);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("smooth_glowstone"), SMOOTH_GLOWSTONE);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("smooth_glowstone_contrast"), SMOOTH_GLOWSTONE_CONTRAST);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("snow_brick"), SNOW_BRICKS);

        Registry.register(Registry.ITEM, MoreThingsMain.id("carved_diorite"), CARVED_DIORITE_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("carved_granite"), CARVED_GRANITE_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("carved_stone"), CARVED_STONE_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("london_bricks"), LONDON_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("mixed_bricks"), MIXED_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("roman_bricks"), ROMAN_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("polished_glowstone"), POLISHED_GLOWSTONE_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("smooth_glowstone"), SMOOTH_GLOWSTONE_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("smooth_glowstone_contrast"), SMOOTH_GLOWSTONE_CONTRAST_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("snow_brick"), SNOW_BRICKS_ITEM);

        Registry.register(Registry.BLOCK, MoreThingsMain.id("stone_big_bricks"), STONE_BIG_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("random_square_stone_bricks"), RANDOM_SQUARE_STONE_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("small_square_stone_bricks"), SMALL_SQUARE_STONE_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("small_stone_bricks"), SMALL_STONE_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("square_stone_bricks"), SQUARE_STONE_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("big_sandstone_bricks"), BIG_SANDSTONE_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("random_sandstone_squares_bricks"), RANDOM_SANDSTONE_SQUARES_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("sandstone_square_bricks"), SANDSTONE_SQUARE_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("small_sandstone_bricks"), SMALL_SANDSTONE_BRICKS);
        Registry.register(Registry.BLOCK, MoreThingsMain.id("small_sandstone_squares_bricks"), SMALL_SANDSTONE_SQUARES_BRICKS);

        Registry.register(Registry.ITEM, MoreThingsMain.id("stone_big_bricks"), STONE_BIG_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("random_square_stone_bricks"), RANDOM_SQUARE_STONE_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("small_square_stone_bricks"), SMALL_SQUARE_STONE_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("small_stone_bricks"), SMALL_STONE_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("square_stone_bricks"), SQUARE_STONE_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("big_sandstone_bricks"), BIG_SANDSTONE_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("random_sandstone_squares_bricks"), RANDOM_SANDSTONE_SQUARES_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("sandstone_square_bricks"), SANDSTONE_SQUARE_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("small_sandstone_bricks"), SMALL_SANDSTONE_BRICKS_ITEM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("small_sandstone_squares_bricks"), SMALL_SANDSTONE_SQUARES_BRICKS_ITEM);

        Registry.register(Registry.BLOCK, MoreThingsMain.id("london_bricks_slab"), LONDON_BRICKS_SLAB);
        Registry.register(Registry.ITEM, MoreThingsMain.id("london_bricks_slab"), LONDON_BRICKS_SLAB_ITEM);

        Registry.register(Registry.BLOCK, MoreThingsMain.id("packed_marihuana"), PACKET_MARIHUANA);
        Registry.register(Registry.ITEM, MoreThingsMain.id("packed_marihuana"), PACKET_MARIHUANA_ITEM);
        
        FERMENTERBLOCK = Registry.register(Registry.BLOCK, MoreThingsMain.id("fermenter"), FERMENTER);
        Registry.register(Registry.ITEM, MoreThingsMain.id("fermenter"), FERMENTER_ITEM);

        PIGGYBANKBLOCK = Registry.register(Registry.BLOCK, MoreThingsMain.id("piggy_bank"), PIGGY_BANK);
        Registry.register(Registry.ITEM, MoreThingsMain.id("piggy_bank"), PIGGY_BANK_ITEM);

        ADVANCEDLOOM = Registry.register(Registry.BLOCK, MoreThingsMain.id("advanced_loom"), ADVANCED_LOOM);
        Registry.register(Registry.ITEM, MoreThingsMain.id("advanced_loom"), ADVANCED_LOOM_ITEM);

        ADVANCENDJUKEBOX = Registry.register(Registry.BLOCK, MoreThingsMain.id("advanced_jukebox"), ADVANCED_JUKEBOX);
        Registry.register(Registry.ITEM, MoreThingsMain.id("advanced_jukebox"), ADVANCED_JUKEBOX_ITEM);
        
		FERMENTER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "morethings:fermenter", BlockEntityType.Builder.create(FermenterBlockEntity::new,FERMENTERBLOCK).build(null));
		ADVANCEND_LOOM_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "morethings:advanced_loom", BlockEntityType.Builder.create(AdvancedLoomBlockEntity::new,ADVANCEDLOOM).build(null));
		ADVANCEND_JUKEBOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "morethings:advanced_jukebox", BlockEntityType.Builder.create(AdvancedJukeboxBlockEntity::new,ADVANCENDJUKEBOX).build(null));
    }
}
