package org.barghos.structs.api.dmap;

public interface IDMap3W<A,B,C>
{
	/**
	 * Sets all entries
	 * @param a : The new value A
	 * @param b : The new value B
	 * @param c : The new value C
	 * @return The current packet
	 */
	IDMap3W<A,B,C> set(A a, B b, C c);
	
	/**
	 * Sets both entry based on another IDMap3Base
	 * @param dmap : the dmap to copy the values from
	 * @return The current packet
	 */
	IDMap3W<A,B,C> set(IDMap3R<A,B,C> dmap);
	
	/**
	 * Sets entry A
	 * @param a : The new value
	 * @return The current packet
	 */
	IDMap3W<A,B,C> setA(A a);
	
	/**
	 * Sets entry B
	 * @param b : The new value
	 * @return The current packet
	 */
	IDMap3W<A,B,C> setB(B b);
	/**
	 * Sets entry C
	 * @param c : The new value
	 * @return The current packet
	 */
	IDMap3W<A,B,C> setC(C c);
}
