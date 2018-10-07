package org.barghos.math.api.vector;

import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.api.tuple.ITup4fW;

/**
 * This interface grants access to all writing methods of an 4-dimensional float vector.
 */
public interface IVec4W extends ITup4fW
{
	/**
	 * Sets the x component to x.
	 * @param x The new value.
	 * @return The current vector or its abstraction.
	 */
	IVec4W setX(double x);
	
	/**
	 * Sets the y component to y.
	 * @param y The new value.
	 * @return The current vector or its abstraction.
	 */
	IVec4W setY(double y);
	
	/**
	 * Sets the z component to z.
	 * @param z The new value.
	 * @return The current vector or its abstraction.
	 */
	IVec4W setZ(double z);
	
	/**
	 * Sets the w component to w.
	 * @param w The new value.
	 * @return The current vector or its abstraction.
	 */
	IVec4W setW(double w);
	
	/**
	 * Sets the x, y, z and w component to t.
	 * @param t A tuple that values are set to x, y, z and w.
	 * @return The current vector or its abstraction.
	 */
	IVec4W set(ITup4R t);
	
	/**
	 * Sets the x, y, z and w component to scalar.
	 * The scalar is NOT scaling!
	 * @param scalar A value that is set to x, y, z and w.
	 * @return The current vector or its abstraction.
	 */
	IVec4W set(double scalar);
	
	/**
	 * Sets the x, y, z and w component to x, y, z and w.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @param z The new z component.
	 * @param w The new w component.
	 * @return The current vector or its abstraction.
	 */
	IVec4W set(double x, double y, double z, double w);
}
