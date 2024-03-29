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

import org.barghos.core.tuple3.api.Tup3fR;

/**
 * This class is a readonly implementation of an HDRColor3.
 */
public abstract class PHDRColor3 implements HDRColor3R
{
	private PHDRColor3() { }
	
	/**
	 * This generate a readonly PHDRColor3 with the components set to t.
	 * The values of t are interpreted as in unitspace(0.0 - 1.0) but can exceed these limits.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PHDRColor3 with the given components.
	 */
	public static PHDRColor3 gen(Tup3fR t) { return gen(t.getX(), t.getY(), t.getZ()); }
	
	/**
	 * This generate a readonly PHDRColor3 with the components set to scalar.
	 * The scalar is interpreted as in unitspace(0.0 - 1.0) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PHDRColor3 with the given components.
	 */
	public static PHDRColor3 gen(double scalar) { return gen(scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PHDRColor3 with the components set to r, g and b.
	 * r, g and b are interpreted as in unitspace(0.0 - 1.0) but can exceed these limits.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 * @return A new readonly PHDRColor3 with the given components.
	 */
	public static PHDRColor3 gen(double r, double g, double b)
	{
		return new PHDRColor3()
		{

			public float getUnityR() { return (float)r; }
			public float getUnityG() { return (float)g; }
			public float getUnityB() { return (float)b; }

			public int getR() { return (int)Math.round(r * 255); }
			public int getG() { return (int)Math.round(g * 255); }
			public int getB() { return (int)Math.round(b * 255); }
		};
	}
	
	/**
	 * This generate a readonly PHDRColor3 with the components set to scalar.
	 * The scalar is interpreted as in colorrange(0 - 255) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PHDRColor3 with the given components.
	 */
	public static PHDRColor3 gen(int scalar) { return gen(scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PHDRColor3 with the components set to r, g and b.
	 * r, g and b are interpreted as in colorspace(0 - 255) but can exceed these limits.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * @return A new readonly PHDRColor3 with the given components.
	 */
	public static PHDRColor3 gen(int r, int g, int b)
	{
		return new PHDRColor3()
		{

			public float getUnityR() { return r / 255.0f; }
			public float getUnityG() { return g / 255.0f; }
			public float getUnityB() { return b / 255.0f; }

			public int getR() { return r; }
			public int getG() { return g; }
			public int getB() { return b; }
		};
	}
}
