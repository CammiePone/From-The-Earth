package dev.cammiescorner.fromtheearth.core.registry;

import dev.cammiescorner.fromtheearth.FromTheEarth;
import dev.cammiescorner.fromtheearth.api.FromTheEarthApi;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.LinkedHashMap;

public class ModBlocks
{
	//-----Block Map-----//
	public static final LinkedHashMap<Block, Identifier> BLOCKS = new LinkedHashMap<>();

	//-----Blocks-----//


	//-----Registry-----//
	public static void register()
	{
		BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
		BLOCKS.keySet().forEach(block -> Registry.register(Registry.ITEM, BLOCKS.get(block), getItem(block)));
	}

	private static BlockItem getItem(Block block)
	{
		return new BlockItem(block, new Item.Settings().group(FromTheEarthApi.ITEM_GROUP));
	}

	private static <T extends Block> T create(String name, T block)
	{
		BLOCKS.put(block, new Identifier(FromTheEarth.MOD_ID, name));
		return block;
	}

	//-----Predicates-----//
	public static boolean never(BlockState state, BlockView world, BlockPos pos)
	{
		return false;
	}

	public static boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type)
	{
		return false;
	}
}
