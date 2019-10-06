package org.barghos.core.color;

import org.barghos.core.api.color.ILDRColor4R;
import org.barghos.core.api.color.ILDRColor4W;
import org.barghos.core.api.tuple.ITup4R;

/**
 * This class is a simple implementation of an LDRColor4.
 */
public class LDRColor4 implements ILDRColor4R, ILDRColor4W
{
	
	/**
	 * White Color constant.
	 */
	public static final ILDRColor4R WHITE = PLDRColor4.gen(255, 255, 255, 255);
	
	/**
	 * Black Color constant.
	 */
	public static final ILDRColor4R BLACK = PLDRColor4.gen(000, 000, 000, 255);
	
	/**
	 * Red Color constant.
	 */
	public static final ILDRColor4R RED = PLDRColor4.gen(255, 000, 000, 255);
	
	/**
	 * Green Color constant.
	 */
	public static final ILDRColor4R GREEN = PLDRColor4.gen(000, 255, 000, 255);
	
	/**
	 * Blue Color constant.
	 */
	public static final ILDRColor4R BLUE = PLDRColor4.gen(000, 000, 255, 255);
	
	/** 
	 * Yellow Color constant.
	 */
	public static final ILDRColor4R YELLOW = PLDRColor4.gen(255, 255, 000, 255);
	
	/**
	 * Purple Color constant.
	 */
	public static final ILDRColor4R PURPLE = PLDRColor4.gen(128, 0, 128, 255);
	
	/** 
	 * Gold Color constant.
	 */
	public static final ILDRColor4R GOLD = PLDRColor4.gen(255, 215, 0, 255);
	
	/**
	 * Orange Color constant.
	 */
	public static final ILDRColor4R ORANGE = PLDRColor4.gen(255, 140, 0, 255);
	
	/** 
	 * Grey Color constant.
	 */
	public static final ILDRColor4R GREY = PLDRColor4.gen(128, 128, 128, 255);
	
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
	public LDRColor4(ITup4R t) { set(t); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 */
	public LDRColor4(double scalar) { set(scalar); }
	
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
	public LDRColor4(double r, double g, double b, double a) { set(r, g, b, a); }
	
	/**
	 * This constructor sets the components to r, g, b and a.
	 * r, g, b and a are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * @param a The alpha component in colorspace.
	 */
	public LDRColor4(int r, int g, int b, int a) { set(r, g, b, a); }
	
	
	public LDRColor4 setX(double x) { ILDRColor4W.super.setX(x); return this; }
	public LDRColor4 setY(double y) { ILDRColor4W.super.setY(y); return this; }
	public LDRColor4 setZ(double z) { ILDRColor4W.super.setZ(z); return this; }
	public LDRColor4 setW(double w) { ILDRColor4W.super.setW(w); return this; }
	
	public LDRColor4 setUnityR(double r) { this.r = clamp(r); return this; }
	public LDRColor4 setUnityG(double g) { this.g = clamp(g); return this; }
	public LDRColor4 setUnityB(double b) { this.b = clamp(b); return this; }
	public LDRColor4 setUnityA(double a) { this.a = clamp(a); return this; }
	
	public LDRColor4 setR(int r) { return setUnityR(r / 255.0f); }
	public LDRColor4 setG(int g) { return setUnityG(g / 255.0f); }
	public LDRColor4 setB(int b) { return setUnityB(b / 255.0f); }
	public LDRColor4 setA(int a) { return setUnityA(a / 255.0f); }
	
	public LDRColor4 set(ITup4R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	public LDRColor4 set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	public LDRColor4 set(int scalar) { return set(scalar, scalar, scalar, scalar); }
	public LDRColor4 set(double r, double g, double b, double a) { return setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	public LDRColor4 set(int r, int g, int b, int a) { return setR(r).setG(g).setB(b).setA(a); }
	
	
	public float getUnityR() { return this.r; }
	public float getUnityG() { return this.g; }
	public float getUnityB() { return this.b; }
	public float getUnityA() { return this.a; }
	
	public int getR() { return Math.round(this.r * 255); }
	public int getG() { return Math.round(this.g * 255); }
	public int getB() { return Math.round(this.b * 255); }
	public int getA() { return Math.round(this.a * 255); }
	
	public int getDimensions() { return 4; }

	
	private float clamp(double value)
	{
		return (float)(value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value);
	}
	
}
