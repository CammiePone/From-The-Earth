package dev.cammiescorner.fromtheearth.core.util.math;

/**
 * MIT License
 *
 * Copyright (c) 2021 simondevyoutube
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class NoiseGenerator
{
	private int octaves;
	private int exponentiation;
	private float scale;
	private float persistence;
	private float lacunarity;
	private float height;
	private OpenSimplex noise;

	public NoiseGenerator(long seed, int octaves, float scale, float persistence, float lacunarity, int exponentiation, float height)
	{
		this.octaves = octaves;
		this.exponentiation = exponentiation;
		this.scale = scale;
		this.persistence = persistence;
		this.lacunarity = lacunarity;
		this.height = height;
		noise = new OpenSimplex(seed);
	}

	public float get(float x, float y, float z)
	{
		final double G = Math.pow(2.0F, (-this.persistence));
		final float xs = x / this.scale;
		final float ys = y / this.scale;
		final float zs = z / this.scale;
		final OpenSimplex noiseFunction = this.noise;

		float amplitude = 1.0F;
		float frequency = 1.0F;
		float normalisation = 0.0F;
		float total = 0.0F;

		for(int i = 0; i < this.octaves; i++)
		{
			double noiseValue = noiseFunction.eval(xs * frequency, ys * frequency, zs * frequency);

			total += noiseValue * amplitude;
			normalisation += amplitude;
			amplitude *= G;
			frequency *= this.lacunarity;
		}

		total /= normalisation;

		return (float) (Math.pow(total * 0.5F + 0.5F, this.exponentiation) * this.height);
	}
}
