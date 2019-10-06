package org.barghos.core.testcolor;

import org.barghos.core.testcolor.api.ILDRColor3R;
import org.barghos.core.testcolor.api.ILDRColor3W;
import org.barghos.core.tuple.tuple3.api.ITup3R;

/**
 * This class is a simple implementation of an LDRColor3.
 */
public class LDRColor3 implements ILDRColor3R, ILDRColor3W
{
	
	/**
	 * White Color constant.
	 */
	public static final ILDRColor3R WHITE = PLDRColor3.gen(255, 255, 255);
	
	/**
	 * Black Color constant.
	 */
	public static final ILDRColor3R BLACK = PLDRColor3.gen(000, 000, 000);
	
	/**
	 * Red Color constant.
	 */
	public static final ILDRColor3R RED = PLDRColor3.gen(255, 000, 000);
	
	/**
	 * Green Color constant.
	 */
	public static final ILDRColor3R GREEN = PLDRColor3.gen(000, 255, 000);
	
	/**
	 * Blue Color constant.
	 */
	public static final ILDRColor3R BLUE = PLDRColor3.gen(000, 000, 255);
	
	/** 
	 * Yellow Color constant.
	 */
	public static final ILDRColor3R YELLOW = PLDRColor3.gen(255, 255, 000);
	
	/**
	 * Purple Color constant.
	 */
	public static final ILDRColor3R PURPLE = PLDRColor3.gen(128, 0, 128);
	
	/** 
	 * Gold Color constant.
	 */
	public static final ILDRColor3R GOLD = PLDRColor3.gen(255, 215, 0);
	
	/**
	 * Orange Color constant.
	 */
	public static final ILDRColor3R ORANGE = PLDRColor3.gen(255, 140, 0);
	
	/** 
	 * Grey Color constant.
	 */
	public static final ILDRColor3R GREY = PLDRColor3.gen(128, 128, 128);
	
	
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
	public LDRColor3(ITup3R t) { set(t); }
	
	/**
	 * This constructor sets the components to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 */
	public LDRColor3(double scalar) { set(scalar); }
	
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
	public LDRColor3(double r, double g, double b) { set(r, g, b); }
	
	/**
	 * This constructor sets the components to r, g and b.
	 * r, g and b are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 */
	public LDRColor3(int r, int g, int b) { set(r, g, b); }
	
	
	
	public LDRColor3 setX(double x) { ILDRColor3W.super.setX(x); return this; }
	public LDRColor3 setY(double y) { ILDRColor3W.super.setY(y); return this; }
	public LDRColor3 setZ(double z) { ILDRColor3W.super.setZ(z); return this; }
	
	public LDRColor3 setUnityR(double r) { this.r = clamp(r); return this; }
	public LDRColor3 setUnityG(double g) { this.g = clamp(g); return this; }
	public LDRColor3 setUnityB(double b) { this.b = clamp(b); return this; }
	
	public LDRColor3 setR(int r) { return setUnityR(r / 255.0f); }
	public LDRColor3 setG(int g) { return setUnityG(g / 255.0f); }
	public LDRColor3 setB(int b) { return setUnityB(b / 255.0f); }
	
	public LDRColor3 set(ITup3R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public LDRColor3 set(double scalar) { return set(scalar, scalar, scalar); }
	public LDRColor3 set(int scalar) { return set(scalar, scalar, scalar); }
	public LDRColor3 set(double r, double g, double b) { return setUnityR(r).setUnityG(g).setUnityB(b); }
	public LDRColor3 set(int r, int g, int b) { return setR(r).setG(g).setB(b); }
	
	
	public float getUnityR() { return this.r; }
	public float getUnityG() { return this.g; }
	public float getUnityB() { return this.b; }
	
	public int getR() { return Math.round(this.r * 255); }
	public int getG() { return Math.round(this.g * 255); }
	public int getB() { return Math.round(this.b * 255); }
	
	public int getDimensions() { return 3; }

	
	private float clamp(double value)
	{
		return (float)(value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value);
	}
	
}
