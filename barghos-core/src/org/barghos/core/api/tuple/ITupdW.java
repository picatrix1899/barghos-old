package org.barghos.core.api.tuple;

/**
 * This interface grants access to all writing methods of an n-dimensional double tuple.
 */
public interface ITupdW
{
	/**
	 * Sets the component in the tuple on the given index.
	 * @param index The index of the component.
	 * @param value The new value of the component.
	 * @return The current tuple or its abstraction.
	 */
	ITupdW set(int index, double value);
}
