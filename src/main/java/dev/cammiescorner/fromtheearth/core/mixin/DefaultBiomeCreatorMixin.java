package dev.cammiescorner.fromtheearth.core.mixin;

import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DefaultBiomeCreator.class)
public class DefaultBiomeCreatorMixin
{
	@Redirect(method = "createGiantTreeTaiga", at = @At(value = "INVOKE", target = "net/minecraft/world/biome/GenerationSettings$Builder.feature(Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"))
	private static GenerationSettings.Builder createGiantTreeTaiga(GenerationSettings.Builder builder, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature)
	{
		return builder;
	}

	@Redirect(method = "createDarkForest", at = @At(value = "INVOKE", target = "net/minecraft/world/biome/GenerationSettings$Builder.feature(Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"))
	private static GenerationSettings.Builder createDarkForest(GenerationSettings.Builder builder, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature)
	{
		return builder;
	}
}
