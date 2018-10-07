package org.barghos.core.api.color;

import org.barghos.core.api.tuple.ITup3R;

/**
 * This interface allows for selective writing of only LDR-RGB-Colors.
 */
public interface ILDRColor3W extends IColor3W
{
	/**
	 * Set the red component to x.
	 * x is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param x The red component.
	 * @return The current color or its abstraction.
	 */
	default ILDRColor3W setX(double x) { IColor3W.super.setX(x); return this; }
	
	/**
	 * Set the green component to y.
	 * y is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param y The green component.
	 * @return The current color or its abstraction.
	 */
	default ILDRColor3W setY(double y) { IColor3W.super.setY(y); return this; }
	
	/**
	 * Set the blue component to z.
	 * z is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param z The blue component.
	 * @return The current color or its abstraction.
	 */
	default ILDRColor3W setZ(double z) { IColor3W.super.setZ(z); return this; }
	
	/**
	 * Sets the rgb components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that contains the rgb values in unitspace.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W set(ITup3R t);
	
	/**
	 * Sets the rgb components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A scalar in unitspace.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W set(double scalar);
	
	/**
	 * Sets the rgb components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param scalar A scalar in colorrange.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W set(int scalar);
	
	/**
	 * Sets the rgb components to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W set(double r, double g, double b);
	
	/**
	 * Sets the rgb components to r, g and b.
	 * r, g and b are interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W set(int r, int g, int b);
	
	/**
	 * Set the red component to r.
	 * r is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W setUnityR(double r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W setUnityG(double g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W setUnityB(double b);
	
	/**
	 * Set the red component to r.
	 * r is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W setR(int r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W setG(int g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	ILDRColor3W setB(int b);
}
