package dev.cammiescorner.fromtheearth.core.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity
{
	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) { super(entityType, world); }

	@Unique
	public boolean canFallThrough(BlockState state)
	{
		return state.isAir() || state.isIn(BlockTags.FIRE) || state.getMaterial().isLiquid() || state.getMaterial().isReplaceable();
	}

	@Unique
	public void collapseBlocks(BlockPos pos)
	{
		world.spawnEntity(new FallingBlockEntity(world, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, world.getBlockState(pos)));
	}

	@Inject(method = "tick", at = @At("HEAD"))
	public void tick(CallbackInfo info)
	{
		if(getPos().y < world.getSeaLevel() && age % 20 == 0)
		{
			int x = random.nextInt(33) - 16, y = random.nextInt(33) - 16, z = random.nextInt(33) - 16;
			BlockPos pos = getBlockPos().add(x, y, z);

			for(int i = 0; i < 2; i++)
				if(canFallThrough(world.getBlockState(pos.down())) && pos.getY() >= 0 && world.isAir(pos.down()) && world.getBlockState(pos).getBlock() == Blocks.COBBLESTONE)
					collapseBlocks(pos);
		}
	}
}
