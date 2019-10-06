package org.barghos.core.testcolor;

import org.barghos.core.testcolor.api.IHDRColor3R;
import org.barghos.core.testcolor.api.IHDRColor3W;
import org.barghos.core.tuple.tuple3.api.ITup3R;

/**
 * This class is a simple implementation of an HDRColor3.
 */
public class HDRColor3 implements IHDRColor3R, IHDRColor3W
{
	
	/**
	 * White Color constant.
	 */
	public static final IHDRColor3R WHITE = PHDRColor3.gen(255, 255, 255);
	
	/**
	 * Black Color constant.
	 */
	public static final IHDRColor3R BLACK = PHDRColor3.gen(000, 000, 000);
	
	/**
	 * Red Color constant.
	 */
	public static final IHDRColor3R RED = PHDRColor3.gen(255, 000, 000);
	
	/**
	 * Green Color constant.
	 */
	public static final IHDRColor3R GREEN = PHDRColor3.gen(000, 255, 000);
	
	/**
	 * Blue Color constant.
	 */
	public static final IHDRColor3R BLUE = PHDRColor3.gen(000, 000, 255);
	
	/** 
	 * Yellow Color constant.
	 */
	public static final IHDRColor3R YELLOW = PHDRColor3.gen(255, 255, 000);
	
	/**
	 * Purple Color constant.
	 */
	public static final IHDRColor3R PURPLE = PHDRColor3.gen(128, 0, 128);
	
	/** 
	 * Gold Color constant.
	 */
	public static final IHDRColor3R GOLD = PHDRColor3.gen(255, 215, 0);
	
	/**
	 * Orange Color constant.
	 */
	public static final IHDRColor3R ORANGE = PHDRColor3.gen(255, 140, 0);
	
	/** 
	 * Grey Color constant.
	 */
	public static final IHDRColor3R GREY = PHDRColor3.gen(128, 128, 128);
	
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
	public HDRColor3(ITup3R t) { assert(t != null); set(t); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 */
	public HDRColor3(double scalar) { set(scalar); }
	
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
	public HDRColor3(double r, double g, double b) { set(r, g, b); }
	
	/**
	 * This constructor sets the components to r, g and b.
	 * r, g and b are interpreted as in colorspace (0 - 255) but can exceed these limits.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 */
	public HDRColor3(int r, int g, int b) { set(r, g, b); }
	
	
	
	public HDRColor3 setX(double x) { IHDRColor3W.super.setX(x); return this; }
	public HDRColor3 setY(double y) { IHDRColor3W.super.setY(y); return this; }
	public HDRColor3 setZ(double z) { IHDRColor3W.super.setZ(z); return this; }
	
	public HDRColor3 setUnityR(double r) { this.r = (float)r; return this; }
	public HDRColor3 setUnityG(double g) { this.g = (float)g; return this; }
	public HDRColor3 setUnityB(double b) { this.b = (float)b; return this; }
	
	public HDRColor3 setR(int r) { return setUnityR(r / 255.0); }
	public HDRColor3 setG(int g) { return setUnityG(g / 255.0); }
	public HDRColor3 setB(int b) { return setUnityB(b / 255.0); }
	
	public HDRColor3 set(ITup3R t) { assert(t != null); return set(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public HDRColor3 set(double scalar) { return set(scalar, scalar, scalar); }
	public HDRColor3 set(int scalar) { return set(scalar, scalar, scalar); }
	public HDRColor3 set(double r, double g, double b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	public HDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	
	
	public float getUnityR() { return this.r; }
	public float getUnityG() { return this.g; }
	public float getUnityB() { return this.b; }
	
	public int getR() { return Math.round(this.r * 255); }
	public int getG() { return Math.round(this.g * 255); }
	public int getB() { return Math.round(this.b * 255); }
	
	public int getDimensions() { return 3; }
	
}
