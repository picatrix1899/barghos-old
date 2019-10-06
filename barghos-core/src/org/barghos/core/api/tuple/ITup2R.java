package org.barghos.core.api.tuple;

/**
 * This interface grants access to all reading methods of an 2-dimensional tuple.
 * It is used for crossbreeding between the different tuple types e.g. float tuple and double tuple.
 */
public interface ITup2R
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
}
