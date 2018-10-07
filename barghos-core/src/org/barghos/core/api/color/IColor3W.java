package org.barghos.core.api.color;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.api.tuple.ITup3fW;

/**
 * This interface grants access to all writing methods of an RGB-Color.
 */
public interface IColor3W extends ITup3fW
{
	/**
	 * Set the red component to x.
	 * x is interpreted as in unitspace (0.0 - 1.0).
	 * @param x The red component.
	 * @return The current color or its abstraction.
	 */
	default IColor3W setX(double x) { return setUnityR(x); }
	
	/**
	 * Set the green component to y.
	 * y is interpreted as in unitspace (0.0 - 1.0).
	 * @param y The green component.
	 * @return The current color or its abstraction.
	 */
	default IColor3W setY(double y) { return setUnityG(y); }
	
	/**
	 * Set the blue component to z.
	 * z is interpreted as in unitspace (0.0 - 1.0).
	 * @param z The blue component.
	 * @return The current color or its abstraction.
	 */
	default IColor3W setZ(double z) { return setUnityB(z); }
	
	/**
	 * Sets the rgb components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0).
	 * @param t A tuple that contains the rgb values in unitspace.
	 * @return The current color or its abstraction.
	 */
	IColor3W set(ITup3R t);
	
	/**
	 * Sets the rgb components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0).
	 * @param scalar A scalar in unitspace.
	 * @return The current color or its abstraction.
	 */
	IColor3W set(double scalar);
	
	/**
	 * Sets the rgb components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255).
	 * @param scalar A scalar in colorrange.
	 * @return The current color or its abstraction.
	 */
	IColor3W set(int scalar);
	
	/**
	 * Sets the rgb components to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0).
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IColor3W set(double r, double g, double b);
	
	/**
	 * Sets the rgb components to r, g and b.
	 * r, g and b are interpreted as in colorrange (0 - 255).
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IColor3W set(int r, int g, int b);

	/**
	 * Set the red component to r.
	 * r is interpreted as in unitspace (0.0 - 1.0).
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	IColor3W setUnityR(double r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in unitspace (0.0 - 1.0).
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	IColor3W setUnityG(double g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in unitspace (0.0 - 1.0).
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IColor3W setUnityB(double b);
	
	/**
	 * Set the red component to r.
	 * r is interpreted as in colorrange (0 - 255).
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	IColor3W setR(int r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in colorrange (0 - 255).
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	IColor3W setG(int g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in colorrange (0 - 255).
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IColor3W setB(int b);
}
