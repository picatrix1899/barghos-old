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

import org.barghos.core.tuple.tuple4.Tup4fR;

/**
 * This class is a simple implementation of an HDRColor4.
 */
public class HDRColor4 implements HDRColor4R
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
	 * The alpha component safed in unitspace.
	 */
	private float a = 0.0f;
	
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0 what is equal to black color.
	 */
	public HDRColor4() { }
	
	/**
	 * This constructor sets the components to t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param t A tuple that the components are set to.
	 */
	public HDRColor4(Tup4fR t) { set(t); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 */
	public HDRColor4(float scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 */
	public HDRColor4(int scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to r, g, b and a.
	 * r, g, b and are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 * @param a The alpha component in unitspace.
	 */
	public HDRColor4(float r, float g, float b, float a) { set(r, g, b, a); }
	
	/**
	 * This constructor sets the components to r, g, b and a.
	 * r, g, b and a are interpreted as in colorspace (0 - 255) but can exceed these limits.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * @param a The alpha component in colorspace.
	 */
	public HDRColor4(int r, int g, int b, int a) { set(r, g, b, a); }
	
	
	public HDRColor4 setX(float x) { return setUnityR(x); }
	public HDRColor4 setY(float y) { return setUnityG(y); }
	public HDRColor4 setZ(float z) { return setUnityB(z); }
	public HDRColor4 setW(float w) { return setUnityA(w); }
	
	public HDRColor4 setUnityR(float r) { this.r = r; return this; }
	public HDRColor4 setUnityG(float g) { this.g = g; return this; }
	public HDRColor4 setUnityB(float b) { this.b = b; return this; }
	public HDRColor4 setUnityA(float a) { this.a = a; return this; }
	
	public HDRColor4 setR(int r) { return setUnityR(r / 255.0f); }
	public HDRColor4 setG(int g) { return setUnityG(g / 255.0f); }
	public HDRColor4 setB(int b) { return setUnityB(b / 255.0f); }
	public HDRColor4 setA(int a) { return setUnityA(a / 255.0f); }
	
	public HDRColor4 set(Tup4fR t) { return set(t.getX(), t.getY(), t.getZ(), t.getW()); }
	public HDRColor4 set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	public HDRColor4 set(int scalar) { return set(scalar, scalar, scalar, scalar); }
	public HDRColor4 set(float r, float g, float b, float a) { return setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	public HDRColor4 set(int r, int g, int b, int a) { return setR(r).setG(g).setB(b).setA(a); }
	
	public float getUnityR() { return this.r; }
	public float getUnityG() { return this.g; }
	public float getUnityB() { return this.b; }
	public float getUnityA() { return this.a; }
	
	public int getR() { return Math.round(this.r * 255); }
	public int getG() { return Math.round(this.g * 255); }
	public int getB() { return Math.round(this.b * 255); }
	public int getA() { return Math.round(this.a * 255); }
}
