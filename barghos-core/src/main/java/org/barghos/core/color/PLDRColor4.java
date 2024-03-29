/*
MIT License

Copyright (c) 2019 picatrix1899

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package org.barghos.core.color;

import org.barghos.core.tuple4.api.Tup4fR;

/**
 * This class is a readonly implementation of an LDRColor4.
 */
public abstract class PLDRColor4 implements LDRColor4R
{
	private PLDRColor4() { }
	
	/**
	 * This generate a readonly PLDRColor4 with the components set to t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PLDRColor4 with the given components.
	 */
	public static PLDRColor4 gen(Tup4fR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	/**
	 * This generate a readonly PLDRColor4 with the components set to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PLDRColor4 with the given components.
	 */
	public static PLDRColor4 gen(float scalar) { return gen(scalar, scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PLDRColor4 with the components set to r, g, b and a.
	 * r, g, b and are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 * @param a The alpha component in unitspace.
	 * @return A new readonly PLDRColor4 with the given components.
	 */
	public static PLDRColor4 gen(float r, float g, float b, float a)
	{
		return new PLDRColor4()
		{

			public float getUnityR() { return clampF(r); }
			public float getUnityG() { return clampF(g); }
			public float getUnityB() { return clampF(b); }
			public float getUnityA() { return clampF(a); }

			public int getR() { return clampI(Math.round(r * 255)); }
			public int getG() { return clampI(Math.round(g * 255)); }
			public int getB() { return clampI(Math.round(b * 255)); }
			public int getA() { return clampI(Math.round(a * 255)); }

			private float clampF(float value)
			{
				return value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value;
			}
			
			private int clampI(int value)
			{
				return value > 255 ? 255 : value < 0 ? 0 : value;
			}
			
		};
	}
	
	/**
	 * This generate a readonly PLDRColor4 with the components set to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PLDRColor4 with the given components.
	 */
	public static PLDRColor4 gen(int scalar) { return gen(scalar, scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PLDRColor4 with the components set to r, g, b and a.
	 * r, g, b and a are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * @param a The alpha component in colorspace.
	 * @return A new readonly PLDRColor4 with the given components.
	 */
	public static PLDRColor4 gen(int r, int g, int b, int a)
	{
		return new PLDRColor4()
		{

			public float getUnityR() { return clampF(r / 255.0f); }
			public float getUnityG() { return clampF(g / 255.0f); }
			public float getUnityB() { return clampF(b / 255.0f); }
			public float getUnityA() { return clampF(a / 255.0f); }
			
			public int getR() { return clampI(r); }
			public int getG() { return clampI(g); }
			public int getB() { return clampI(b); }
			public int getA() { return clampI(a); }

			private float clampF(float value)
			{
				return value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value;
			}
			
			private int clampI(int value)
			{
				return value > 255 ? 255 : value < 0 ? 0 : value;
			}
			
		};
	}
}
