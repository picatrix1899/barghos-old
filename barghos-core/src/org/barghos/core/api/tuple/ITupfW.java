package org.barghos.core.api.tuple;

/**
 * This interface grants access to all writing methods of an n-dimensional float tuple.
 */
public interface ITupfW
{
	/**
	 * Sets the component in the tuple on the given index.
	 * @param index The index of the component.
	 * @param value The new value of the component.
	 * @return The current tuple or its abstraction.
	 */
	ITupfW set(int index, double value);
}
