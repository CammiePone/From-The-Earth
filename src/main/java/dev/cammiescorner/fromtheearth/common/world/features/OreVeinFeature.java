package dev.cammiescorner.fromtheearth.common.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Random;

public class OreVeinFeature extends Feature<OreFeatureConfig>
{
	public OreVeinFeature(Codec<OreFeatureConfig> configCodec)
	{
		super(configCodec);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, OreFeatureConfig config)
	{
		return false;
	}

	public void placeSurfaceSamples(WorldAccess world, OreFeatureConfig oreFeatureConfig, Random random, int x, int z)
	{
		BlockState state = oreFeatureConfig.state;
		int size = oreFeatureConfig.size;
		int y = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, x, z);
		BlockPos pos = new BlockPos(x, y, z);

		if(state.getBlock() == Blocks.DIAMOND_ORE && world.getBlockState(pos.down()).getMaterial().isSolid())
		{
			world.setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState(), 3);
		}
	}

	public void placeUndergroundOres(WorldAccess world, OreFeatureConfig oreFeatureConfig, Random random, int x, int y, int z)
	{

	}
}
