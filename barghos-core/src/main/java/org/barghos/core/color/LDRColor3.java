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

import org.barghos.core.tuple.tuple3.Tup3fR;

/**
 * This class is a simple implementation of an LDRColor3.
 */
public class LDRColor3 implements LDRColor3R
{
	/**
	 * The red component safed in unitspace.
	 */
	private float r = 0.0f;
	
	/**
	 * The green component safed in unitspace.
	 */
	private float g = 0.0f;
	
	/**
	 * The blue component safed in unitspace.
	 */
	private float b = 0.0f;
	
	
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0 what is equal to black color.
	 */
	public LDRColor3() { }
	
	/**
	 * This constructor sets the components to t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that the components are set to.
	 */
	public LDRColor3(Tup3fR t) { set(t); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 */
	public LDRColor3(float scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 */
	public LDRColor3(int scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 */
	public LDRColor3(float r, float g, float b) { set(r, g, b); }
	
	/**
	 * This constructor sets the components to r, g and b.
	 * r, g and b are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 */
	public LDRColor3(int r, int g, int b) { set(r, g, b); }
	
	
	
	public LDRColor3 setX(float x) { return setUnityR(x); }
	public LDRColor3 setY(float y) { return setUnityG(y); }
	public LDRColor3 setZ(float z) { return setUnityB(z); }
	
	public LDRColor3 setUnityR(float r) { this.r = clamp(r); return this; }
	public LDRColor3 setUnityG(float g) { this.g = clamp(g); return this; }
	public LDRColor3 setUnityB(float b) { this.b = clamp(b); return this; }
	
	public LDRColor3 setR(int r) { return setUnityR(r / 255.0f); }
	public LDRColor3 setG(int g) { return setUnityG(g / 255.0f); }
	public LDRColor3 setB(int b) { return setUnityB(b / 255.0f); }
	
	public LDRColor3 set(Tup3fR t) { return set(t.getX(), t.getY(), t.getZ()); }
	public LDRColor3 set(float scalar) { return set(scalar, scalar, scalar); }
	public LDRColor3 set(int scalar) { return set(scalar, scalar, scalar); }
	public LDRColor3 set(float r, float g, float b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	public LDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	
	public float getUnityR() { return this.r; }
	public float getUnityG() { return this.g; }
	public float getUnityB() { return this.b; }
	
	public int getR() { return Math.round(this.r * 255); }
	public int getG() { return Math.round(this.g * 255); }
	public int getB() { return Math.round(this.b * 255); }

	private float clamp(double value)
	{
		return (float)(value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value);
	}
	
}
