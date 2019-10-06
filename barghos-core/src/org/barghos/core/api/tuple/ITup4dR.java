package org.barghos.core.api.tuple;

/**
 * This interface grants access to all reading methods of an 4-dimensional double tuple.
 */
public interface ITup4dR extends ITupdR, ITup4R
{
	default double getUniX() { return getX(); }
	default double getUniY() { return getY(); }
	default double getUniZ() { return getZ(); }
	default double getUniW() { return getW(); }
	
	default double getUni(int index) { return get(index); }
	
	/**
	 * Returns the x component.
	 * @return The x component.
	 */
	double getX();
	
	/**
	 * Returns the y component.
	 * @return The y component.
	 */
	double getY();
	
	/**
	 * Returns the z component.
	 * @return The z component.
	 */
	double getZ();
	
	/**
	 * Returns the a component.
	 * @return The a component.
	 */
	double getW();
	
	/**
	 * Returns the component on the given index (0 - 3).
	 * @return The component on the index or Double.NaN.
	 */
	default double get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			case 3: return getW();
			default: return Double.NaN;
		}
	}
}
