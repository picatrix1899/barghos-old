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
 * This class is a simple implementation of an HDRColor3.
 */
public class HDRColor3 implements HDRColor3R
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
	public HDRColor3() { }
	
	/**
	 * This constructor sets the components to t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits
	 * @param t A tuple that the components are set to.
	 */
	public HDRColor3(Tup3fR t) { assert(t != null); set(t); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 */
	public HDRColor3(float scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 */
	public HDRColor3(int scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 */
	public HDRColor3(float r, float g, float b) { set(r, g, b); }
	
	/**
	 * This constructor sets the components to r, g and b.
	 * r, g and b are interpreted as in colorspace (0 - 255) but can exceed these limits.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 */
	public HDRColor3(int r, int g, int b) { set(r, g, b); }
	
	
	
	public HDRColor3 setX(float x) { return setUnityR(x); }
	public HDRColor3 setY(float y) { return setUnityG(y); }
	public HDRColor3 setZ(float z) { return setUnityB(z); }
	
	public HDRColor3 setUnityR(float r) { this.r = r; return this; }
	public HDRColor3 setUnityG(float g) { this.g = g; return this; }
	public HDRColor3 setUnityB(float b) { this.b = b; return this; }
	
	public HDRColor3 setR(int r) { return setUnityR(r / 255.0f); }
	public HDRColor3 setG(int g) { return setUnityG(g / 255.0f); }
	public HDRColor3 setB(int b) { return setUnityB(b / 255.0f); }
	
	public HDRColor3 set(Tup3fR t) { assert(t != null); return set(t.getX(), t.getY(), t.getZ()); }
	public HDRColor3 set(float scalar) { return set(scalar, scalar, scalar); }
	public HDRColor3 set(int scalar) { return set(scalar, scalar, scalar); }
	public HDRColor3 set(float r, float g, float b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	public HDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	
	public float getUnityR() { return this.r; }
	public float getUnityG() { return this.g; }
	public float getUnityB() { return this.b; }
	
	public int getR() { return Math.round(this.r * 255); }
	public int getG() { return Math.round(this.g * 255); }
	public int getB() { return Math.round(this.b * 255); }
}
