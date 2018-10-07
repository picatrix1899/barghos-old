package org.barghos.core.api.tuple;

/**
 * This interface grants access to all writing methods of an 2-dimensional float tuple.
 */
public interface ITup2fW extends ITupfW
{
	/**
	 * Sets the x component to x.
	 * @param x The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup2fW setX(double x);
	
	/**
	 * Sets the y component to y.
	 * @param y The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup2fW setY(double y);
	
	/**
	 * Sets the x and y component to t.
	 * @param t A tuple that values are set to x and y.
	 * @return The current tuple or its abstraction.
	 */
	ITup2fW set(ITup2R t);
	
	/**
	 * Sets the x and y component to scalar.
	 * The scalar is NOT scaling!
	 * @param scalar A value that is set to x and y.
	 * @return The current tuple or its abstraction.
	 */
	ITup2fW set(double scalar);
	/**
	 * Sets the x and y component to x and y.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @return The current tuple or its abstraction.
	 */
	ITup2fW set(double x, double y);

	/**
	 * Sets the component on the given index (0 - 1) to value.
	 * @param index The index of the component.
	 * @param value The new value of the component.
	 * @return The current tuple or its abstraction.
	 */
	default ITup2fW set(int index, double value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
		}
		
		return this;
	}
}
