package dev.cammiescorner.fromtheearth.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class CollapsingBlock extends FallingBlock
{
	public CollapsingBlock(Settings settings)
	{
		super(settings);
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom)
	{
		if(world.isAir(pos.down()) && world.getBlockState(pos).getBlock() == Blocks.COBBLESTONE && world.isPlayerInRange(pos.getX(), pos.getY(), pos.getZ(), 16))
		{
			world.getBlockTickScheduler().schedule(pos, this, this.getFallDelay());
		}

		return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
	}
}
