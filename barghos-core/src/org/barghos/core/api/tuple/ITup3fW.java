package org.barghos.core.api.tuple;

/**
 * This interface grants access to all writing methods of an 3-dimensional float tuple.
 */
public interface ITup3fW extends ITupfW
{
	
	/**
	 * Sets the x component to x.
	 * @param x The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup3fW setX(double x);
	
	/**
	 * Sets the y component to y.
	 * @param y The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup3fW setY(double y);
	
	/**
	 * Sets the z component to z.
	 * @param z The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup3fW setZ(double z);
	
	/**
	 * Sets the x, y and z component to t.
	 * @param t A tuple that values are set to x, y and z.
	 * @return The current tuple or its abstraction.
	 */
	ITup3fW set(ITup3R t);
	
	/**
	 * Sets the x, y and z component to scalar.
	 * The scalar is NOT scaling!
	 * @param scalar A value that is set to x, y and z.
	 * @return The current tuple or its abstraction.
	 */
	ITup3fW set(double scalar);
	
	/**
	 * Sets the x, y and z component to x, y and z.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @param z The new z component.
	 * @return The current tuple or its abstraction.
	 */
	ITup3fW set(double x, double y, double z);


	/**
	 * Sets the component on the given index (0 - 2) to value.
	 * @param index The index of the component.
	 * @param value The new value of the component.
	 * @return The current tuple or its abstraction.
	 */
	default ITup3fW set(int index, double value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
			case 2: setZ(value); break;
		}
		
		return this;
	}
}
