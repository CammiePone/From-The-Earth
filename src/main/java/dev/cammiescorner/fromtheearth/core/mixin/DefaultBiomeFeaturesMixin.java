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

	// TODO Stop trees from generating.
}
