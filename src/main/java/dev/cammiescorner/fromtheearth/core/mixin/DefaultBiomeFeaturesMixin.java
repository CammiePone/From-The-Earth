package dev.cammiescorner.fromtheearth.core.mixin;

import dev.cammiescorner.fromtheearth.FromTheEarth;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin
{
	@Inject(method = "addDefaultOres", at = @At("HEAD"), cancellable = true)
	private static void addDefaultOres(GenerationSettings.Builder builder, CallbackInfo info)
	{
		FromTheEarth.LOGGER.info("Replacing all ore generation!");
		info.cancel();
	}

	@Inject(method = "addExtraGoldOre", at = @At("HEAD"), cancellable = true)
	private static void addExtraGoldOre(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addEmeraldOre", at = @At("HEAD"), cancellable = true)
	private static void addEmeraldOre(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	// Might not need this one, haven't tested yet
	/*@Inject(method = "addBambooJungleTrees", at = @At("HEAD"), cancellable = true)
	private static void addBambooJungleTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}*/

	@Inject(method = "addTaigaTrees", at = @At("HEAD"), cancellable = true)
	private static void addTaigaTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addWaterBiomeOakTrees", at = @At("HEAD"), cancellable = true)
	private static void addWaterBiomeOakTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addBirchTrees", at = @At("HEAD"), cancellable = true)
	private static void addBirchTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addForestTrees", at = @At("HEAD"), cancellable = true)
	private static void addForestTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addTallBirchTrees", at = @At("HEAD"), cancellable = true)
	private static void addTallBirchTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addSavannaTrees", at = @At("HEAD"), cancellable = true)
	private static void addSavannahTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addExtraSavannaTrees", at = @At("HEAD"), cancellable = true)
	private static void addExtraSavannahTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addMountainTrees", at = @At("HEAD"), cancellable = true)
	private static void addMountainTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addExtraMountainTrees", at = @At("HEAD"), cancellable = true)
	private static void addExtraMountainTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addJungleTrees", at = @At("HEAD"), cancellable = true)
	private static void addJungleTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addJungleEdgeTrees", at = @At("HEAD"), cancellable = true)
	private static void addJungleEdgeTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addBadlandsPlateauTrees", at = @At("HEAD"), cancellable = true)
	private static void addBadlandsPlateauTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}

	@Inject(method = "addSnowySpruceTrees", at = @At("HEAD"), cancellable = true)
	private static void addSnowySpruceTrees(GenerationSettings.Builder build, CallbackInfo info)
	{
		info.cancel();
	}
}
