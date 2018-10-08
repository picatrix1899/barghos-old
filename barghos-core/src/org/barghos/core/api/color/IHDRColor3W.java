package org.barghos.core.api.color;

import org.barghos.core.api.tuple.ITup3R;

/**
 * This interface allows for selective writing of only HDR-RGB-Colors.
 */
public interface IHDRColor3W extends IColor3W
{
	/**
	 * Set the red component to x.
	 * x is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param x The red component.
	 * @return The current color or its abstraction.
	 */
	default IHDRColor3W setX(double x) { IColor3W.super.setX(x); return this; }
	
	/**
	 * Set the green component to y.
	 * y is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param y The green component.
	 * @return The current color or its abstraction.
	 */
	default IHDRColor3W setY(double y) { IColor3W.super.setY(y); return this; }
	
	/**
	 * Set the blue component to z.
	 * z is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param z The blue component.
	 * @return The current color or its abstraction.
	 */
	default IHDRColor3W setZ(double z) { IColor3W.super.setZ(z); return this; }
	
	/**
	 * Sets the rgb components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param t A tuple that contains the rgb values in unitspace.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W set(ITup3R t);
	
	/**
	 * Sets the rgb components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param scalar A scalar in unitspace.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W set(double scalar);
	
	/**
	 * Sets the rgb components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param scalar A scalar in colorrange.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W set(int scalar);
	
	/**
	 * Sets the rgb components to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W set(double r, double g, double b);
	
	/**
	 * Sets the rgb components to r, g and b.
	 * r, g and b are interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W set(int r, int g, int b);
	
	/**
	 * Set the red component to r.
	 * r is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W setUnityR(double r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W setUnityG(double g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W setUnityB(double b);
	
	/**
	 * Set the red component to r.
	 * r is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W setR(int r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W setG(int g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IHDRColor3W setB(int b);
}
