package org.barghos.math.api.point;

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.core.tuple.tuple3.api.ITup3fW;

/**
 * This interface grants access to all writing methods of an 3-dimensional float point.
 */
public interface IPoint3W extends ITup3fW
{
	/**
	 * Sets the x component to x.
	 * @param x The new value.
	 * @return The current point or its abstraction.
	 */
	IPoint3W setX(double x);
	
	/**
	 * Sets the y component to y.
	 * @param y The new value.
	 * @return The current point or its abstraction.
	 */
	IPoint3W setY(double y);
	
	/**
	 * Sets the z component to z.
	 * @param z The new value.
	 * @return The current point or its abstraction.
	 */
	IPoint3W setZ(double z);
	
	/**
	 * Sets the x, y and z component to t.
	 * @param t A tuple that values are set to x, y and z.
	 * @return The current point or its abstraction.
	 */
	IPoint3W set(ITup3R t);
	
	/**
	 * Sets the x, y and z component to scalar.
	 * The scalar is NOT scaling!
	 * @param scalar A value that is set to x, y and z.
	 * @return The current point or its abstraction.
	 */
	IPoint3W set(double scalar);
	
	/**
	 * Sets the x, y and z component to x, y and z.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @param z The new z component.
	 * @return The current point or its abstraction.
	 */
	IPoint3W set(double x, double y, double z);
}
