package org.barghos.core.api.tuple;

/**
 * This interface grants access to all reading methods of an 3-dimensional tuple.
 * It is used for crossbreeding between the different tuple types e.g. float tuple and double tuple.
 */
public interface ITup3R
{
	/**
	 * Returns the x component regardless of the tuple type.
	 * @return The x component.
	 */
	double getUniX();
	
	/**
	 * Returns the y component regardless of the tuple type.
	 * @return The y component.
	 */
	double getUniY();
	
	/**
	 * Returns the z component regardless of the tuple type.
	 * @return The z component.
	 */
	double getUniZ();
}
