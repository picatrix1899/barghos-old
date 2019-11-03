package org.barghos.structs.api.dmap;

public interface IDMap2W<A,B>
{
	/**
	 * Sets both entry
	 * @param a : The new value A
	 * @param b : The new value B
	 * @return The current packet
	 */
	IDMap2W<A,B> set(A a, B b);
	
	/**
	 * Sets both entry based on another IDMap2Base
	 * @param dmap : the dmap to copy the values from
	 * @return The current packet
	 */
	IDMap2W<A,B> set(IDMap2R<A,B> dmap);
	
	/**
	 * Sets entry A
	 * @param a : The new value
	 * @return The current packet
	 */
	IDMap2W<A,B> setA(A a);
	/**
	 * Sets entry B
	 * @param b : The new value
	 * @return The current packet
	 */
	IDMap2W<A,B> setB(B b);
}
