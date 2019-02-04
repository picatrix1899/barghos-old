package org.barghos.math.api.point;

import org.barghos.core.api.tuple.ITup2R;
import org.barghos.core.api.tuple.ITup2fW;

/**
 * This interface grants access to all writing methods of an 2-dimensional float point.
 */
public interface IPoint2W extends ITup2fW
{
	/**
	 * Sets the x component to x.
	 * @param x The new value.
	 * @return The current point or its abstraction.
	 */
	IPoint2W setX(double x);
	
	/**
	 * Sets the y component to y.
	 * @param y The new value.
	 * @return The current point or its abstraction.
	 */
	IPoint2W setY(double y);
	
	/**
	 * Sets the x and y component to t.
	 * @param t A tuple that values are set to x and y.
	 * @return The current point or its abstraction.
	 */
	IPoint2W set(ITup2R t);
	
	/**
	 * Sets the x and y component to scalar.
	 * The scalar is NOT scaling!
	 * @param scalar A value that is set to x and y.
	 * @return The current point or its abstraction.
	 */
	IPoint2W set(double scalar);
	
	/**
	 * Sets the x and y component to x and y.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @return The current point or its abstraction.
	 */
	IPoint2W set(double x, double y);
}
