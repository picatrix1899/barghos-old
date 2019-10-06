package org.barghos.core.api.tuple;

/**
 * This interface grants access to all reading methods of an 2-dimensional float tuple.
 */
public interface ITup2fR extends ITupfR, ITup2R
{
	default double getUniX() { return getX(); }
	default double getUniY() { return getY(); }
	
	default double getUni(int index) { return get(index); }
	
	/**
	 * Returns the x component.
	 * @return The x component.
	 */
	float getX();
	
	/**
	 * Returns the y component.
	 * @return The y component.
	 */
	float getY();
	
	/**
	 * Returns the component on the given index (0 - 1).
	 * @return The component on the index or Float.NaN.
	 */
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			default: return Float.NaN;
		}
	}
}
