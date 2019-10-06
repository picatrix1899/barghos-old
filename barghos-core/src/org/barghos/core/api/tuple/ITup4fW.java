package org.barghos.core.api.tuple;

/**
 * This interface grants access to all writing methods of an 4-dimensional float tuple.
 */
public interface ITup4fW extends ITupfW
{
	
	/**
	 * Sets the x component to x.
	 * @param x The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup4fW setX(double x);
	
	/**
	 * Sets the y component to y.
	 * @param y The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup4fW setY(double y);
	
	/**
	 * Sets the z component to z.
	 * @param z The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup4fW setZ(double z);
	
	/**
	 * Sets the w component to w.
	 * @param w The new value.
	 * @return The current tuple or its abstraction.
	 */
	ITup4fW setW(double w);
	
	/**
	 * Sets the x, y, z and w component to t.
	 * @param t A tuple that values are set to x, y, z and w.
	 * @return The current tuple or its abstraction.
	 */
	ITup4fW set(ITup4R t);
	
	/**
	 * Sets the x, y, z and w component to scalar.
	 * The scalar is NOT scaling!
	 * @param scalar A value that is set to x, y, z and w.
	 * @return The current tuple or its abstraction.
	 */
	ITup4fW set(double scalar);
	
	/**
	 * Sets the x, y, z and w component to x, y, z and w.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @param z The new z component.
	 * @param w The new w component.
	 * @return The current tuple or its abstraction.
	 */
	ITup4fW set(double x, double y, double z, double w);
	
	/**
	 * Sets the component on the given index (0 - 3) to value.
	 * @param index The index of the component.
	 * @param value The new value of the component.
	 * @return The current tuple or its abstraction.
	 */
	default ITup4fW set(int index, double value)
	{
		switch(index)
		{
			case 0: setX(value); break;
			case 1: setY(value); break;
			case 2: setZ(value); break;
			case 3: setW(value); break;
		}
		
		return this;
	}
}
