package org.barghos.core.api.tuple;

/**
 * This interface grants access to all reading methods of an 3-dimensional double tuple.
 */
public interface ITup3dR extends ITupdR, ITup3R
{

	default double getUniX() { return getX(); }
	default double getUniY() { return getY(); }
	default double getUniZ() { return getZ(); }
	
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
	 * Returns the component on the given index (0 - 2).
	 * @return The component on the index or Double.NaN.
	 */
	default double get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			default: return Double.NaN;
		}
	}
}
