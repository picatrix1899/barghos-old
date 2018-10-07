package org.barghos.core.api.tuple;

/**
 * This interface grants access to all reading methods of an n-dimensional tuple.
 * It is used for crossbreeding between the different tuple types e.g. float tuple and double tuple.
 */
public interface ITupR
{
	/**
	 * Returns the count of dimensions of the tuple.
	 * @return The count of dimensions.
	 */
	int getDimensions();
	
	/**
	 * Returns the component in the tuple on the given index regardless of the tuple type.
	 * @param index The index of the component.
	 * @return The component on the index or Float.NaN.
	 */
	double getUni(int index);
}
