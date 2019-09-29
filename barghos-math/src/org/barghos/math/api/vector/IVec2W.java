package org.barghos.math.api.vector;

import org.barghos.core.tuple.tuple2.api.ITup2R;
import org.barghos.core.tuple.tuple2.api.ITup2fW;

/**
 * This interface grants access to all writing methods of an 2-dimensional float vector.
 */
public interface IVec2W extends ITup2fW
{
	/**
	 * Sets the x component to x.
	 * @param x The new value.
	 * @return The current vector or its abstraction.
	 */
	IVec2W setX(double x);
	
	/**
	 * Sets the y component to y.
	 * @param y The new value.
	 * @return The current vector or its abstraction.
	 */
	IVec2W setY(double y);
	
	/**
	 * Sets the x, y and z component to t.
	 * @param t A tuple that values are set to x and y.
	 * @return The current vector or its abstraction.
	 */
	IVec2W set(ITup2R t);
	
	/**
	 * Sets the x and y component to scalar.
	 * The scalar is NOT scaling!
	 * @param scalar A value that is set to x and y.
	 * @return The current vector or its abstraction.
	 */
	IVec2W set(double scalar);
	
	/**
	 * Sets the x and y component to x and y.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @return The current vector or its abstraction.
	 */
	IVec2W set(double x, double y);
	
	default IVec2W set(int index, double value)
	{
		switch(index)
		{
			case 0: return setX(value);
			case 1: return setY(value);
			default: throw new IllegalStateException();
		}
	}
}
