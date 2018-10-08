package org.barghos.core.api.color;

import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.api.tuple.ITup4fW;

/**
 * This interface grants access to all writing methods of an RGBA-Color.
 */
public interface IColor4W extends ITup4fW
{
	/**
	 * Set the red component to x.
	 * x is interpreted as in unitspace (0.0 - 1.0).
	 * @param x The red component.
	 * @return The current color or its abstraction.
	 */
	default IColor4W setX(double x) { return setUnityR(x); }
	
	/**
	 * Set the green component to y.
	 * y is interpreted as in unitspace (0.0 - 1.0).
	 * @param y The green component.
	 * @return The current color or its abstraction.
	 */
	default IColor4W setY(double y) { return setUnityG(y); }
	
	/**
	 * Set the blue component to z.
	 * z is interpreted as in unitspace (0.0 - 1.0).
	 * @param z The blue component.
	 * @return The current color or its abstraction.
	 */
	default IColor4W setZ(double z) { return setUnityB(z); }
	
	/**
	 * Set the alpha component to w.
	 * w is interpreted as in unitspace (0.0 - 1.0).
	 * @param w The alpha component.
	 * @return The current color or its abstraction.
	 */
	default IColor4W setW(double w) { return setUnityA(w); }
	
	/**
	 * Sets the rgba components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0).
	 * @param t A tuple that contains the rgba values in unitspace.
	 * @return The current color or its abstraction.
	 */
	IColor4W set(ITup4R t);
	
	/**
	 * Sets the rgba components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0).
	 * @param scalar A scalar in unitspace.
	 * @return The current color or its abstraction.
	 */
	IColor4W set(double scalar);
	
	/**
	 * Sets the rgba components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255).
	 * @param scalar A scalar in colorrange.
	 * @return The current color or its abstraction.
	 */
	IColor4W set(int scalar);
	
	/**
	 * Sets the rgba components to r, g, b and a.
	 * r, g, b and a are interpreted as in unitspace (0.0 - 1.0).
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	IColor4W set(double r, double g, double b, double a);
	
	/**
	 * Sets the rgba components to r, g, b and a.
	 * r, g, b and a are interpreted as in colorrange (0 - 255).
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	IColor4W set(int r, int g, int b, int a);

	/**
	 * Set the red component to r.
	 * r is interpreted as in unitspace (0.0 - 1.0).
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setUnityR(double r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in unitspace (0.0 - 1.0).
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setUnityG(double g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in unitspace (0.0 - 1.0).
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setUnityB(double b);
	
	/**
	 * Set the alpha component to a.
	 * a is interpreted as in unitspace (0.0 - 1.0).
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setUnityA(double a);
	
	/**
	 * Set the red component to r.
	 * r is interpreted as in colorrange (0 - 255).
	 * @param r The red component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setR(int r);
	
	/**
	 * Set the green component to g.
	 * g is interpreted as in colorrange (0 - 255).
	 * @param g The green component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setG(int g);
	
	/**
	 * Set the blue component to b.
	 * b is interpreted as in colorrange (0 - 255).
	 * @param b The blue component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setB(int b);
	
	/**
	 * Set the alpha component to a.
	 * a is interpreted as in colorrange (0 - 255).
	 * @param a The alpha component.
	 * @return The current color or its abstraction.
	 */
	IColor4W setA(int a);
}
