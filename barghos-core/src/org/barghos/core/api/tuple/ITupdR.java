package org.barghos.core.api.tuple;

/**
 * This interface grants access to all reading methods of an n-dimensional double tuple.
 */
public interface ITupdR extends ITupR
{

	default double getUni(int index) { return get(index); }
	
	/**
	 * Returns the component in the tuple on the given index.
	 * @param index The index of the component.
	 * @return The component on the index or Double.NaN.
	 */
	double get(int index);
}
