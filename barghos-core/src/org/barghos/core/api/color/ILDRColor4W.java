package org.barghos.core.api.color;

import org.barghos.core.api.tuple.ITup4R;

/**
 * This interface allows for selective writing of only LDR-RGBA-Colors.
 */
public interface ILDRColor4W extends IColor4W
{
	/**
	 * Set the red component to x.
	 * x is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param x The red component.
	 * @return The current color or its abstraction.
	 */
	default ILDRColor4W setX(double x) { IColor4W.super.setX(x); return this; }
	
	/**
	 * Set the green component to y.
	 * y is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param y The green component.
	 * @return The current color or its abstraction.
	 */
	default ILDRColor4W setY(double y) { IColor4W.super.setY(y); return this; }
	
	/**
	 * Set the blue component to z.
	 * z is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param z The blue component.
	 * @return The current color or its abstraction.
	 */
	default ILDRColor4W setZ(double z) { IColor4W.super.setZ(z); return this; }
	
	/**
	 * Set the alpha component to w.
	 * w is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param w The alpha component.
	 * @return The current color or its abstraction.
	 */
	default ILDRColor4W setW(double w) { IColor4W.super.setW(w); return this; }
	
	/**
	 * Sets the rgba components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that contains the rgba values in unitspace.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W set(ITup4R t);
	
	/**
	 * Sets the rgba components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A scalar in unitspace.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W set(double scalar);
	
	/**
	 * Sets the rgba components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param scalar A scalar in colorrange.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W set(int scalar);
	
	/**
	 * Sets the rgba components to r, g, b and a.
	 * r, g, b and a are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W set(double r, double g, double b, double a);
	
	/**
	 * Sets the rgba components to r, g, b and a.
	 * r, g, b and a are interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W set(int r, int g, int b, int a);

	/**
	 * Set the red component to r.
	 * r is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setUnityR(double r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setUnityG(double g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setUnityB(double b);
	
	/**
	 * Set the alpha component to a.
	 * a is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setUnityA(double a);
	
	/**
	 * Set the red component to r.
	 * r is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setR(int r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setG(int g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setB(int b);
	
	/**
	 * Set the alpha component to a.
	 * a is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor4W setA(int a);
}
