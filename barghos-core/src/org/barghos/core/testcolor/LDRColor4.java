package org.barghos.core.testcolor;

import org.barghos.core.tuple.tuple4.Tup4fR;

/**
 * This class is a simple implementation of an LDRColor4.
 */
public class LDRColor4 implements LDRColor4R
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
	public LDRColor4() { }
	
	/**
	 * This constructor sets the components to t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that the components are set to.
	 */
	public LDRColor4(Tup4fR t) { set(t); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 */
	public LDRColor4(float scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 */
	public LDRColor4(int scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to r, g, b and a.
	 * r, g, b and are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 * @param a The alpha component in unitspace.
	 */
	public LDRColor4(float r, float g, float b, float a) { set(r, g, b, a); }
	
	/**
	 * This constructor sets the components to r, g, b and a.
	 * r, g, b and a are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * @param a The alpha component in colorspace.
	 */
	public LDRColor4(int r, int g, int b, int a) { set(r, g, b, a); }
	
	
	public LDRColor4 setX(float x) { return setUnityR(x); }
	public LDRColor4 setY(float y) { return setUnityG(y); }
	public LDRColor4 setZ(float z) { return setUnityB(z); }
	public LDRColor4 setW(float w) { return setUnityA(w); }
	
	public LDRColor4 setUnityR(float r) { this.r = clamp(r); return this; }
	public LDRColor4 setUnityG(float g) { this.g = clamp(g); return this; }
	public LDRColor4 setUnityB(float b) { this.b = clamp(b); return this; }
	public LDRColor4 setUnityA(float a) { this.a = clamp(a); return this; }
	
	public LDRColor4 setR(int r) { return setUnityR(r / 255.0f); }
	public LDRColor4 setG(int g) { return setUnityG(g / 255.0f); }
	public LDRColor4 setB(int b) { return setUnityB(b / 255.0f); }
	public LDRColor4 setA(int a) { return setUnityA(a / 255.0f); }
	
	public LDRColor4 set(Tup4fR t) { return set(t.getX(), t.getY(), t.getZ(), t.getW()); }
	public LDRColor4 set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	public LDRColor4 set(int scalar) { return set(scalar, scalar, scalar, scalar); }
	public LDRColor4 set(float r, float g, float b, float a) { return setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	public LDRColor4 set(int r, int g, int b, int a) { return setR(r).setG(g).setB(b).setA(a); }
	
	public float getUnityR() { return this.r; }
	public float getUnityG() { return this.g; }
	public float getUnityB() { return this.b; }
	public float getUnityA() { return this.a; }
	
	public int getR() { return Math.round(this.r * 255); }
	public int getG() { return Math.round(this.g * 255); }
	public int getB() { return Math.round(this.b * 255); }
	public int getA() { return Math.round(this.a * 255); }

	private float clamp(double value)
	{
		return (float)(value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value);
	}
	
}
