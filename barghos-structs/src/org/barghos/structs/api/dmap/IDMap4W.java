package org.barghos.structs.api.dmap;

public interface IDMap4W<A,B,C,D>
{
	/**
	 * Sets all entries
	 * @param a : The new value A
	 * @param b : The new value B
	 * @param c : The new value C
	 * @param d : The new value D
	 * @return The current packet
	 */
	IDMap4W<A,B,C,D> set(A a, B b, C c, D d);
	
	/**
	 * Sets both entry based on another IDMap4Base
	 * @param dmap : the dmap to copy the values from
	 * @return The current packet
	 */
	IDMap4W<A,B,C,D> set(IDMap4R<A,B,C,D> dmap);
	
	/**
	 * Sets entry A
	 * @param a : The new value
	 * @return The current packet
	 */
	IDMap4W<A,B,C,D> setA(A a);
	
	/**
	 * Sets entry B
	 * @param b : The new value
	 * @return The current packet
	 */
	IDMap4W<A,B,C,D> setB(B b);
	
	/**
	 * Sets entry C
	 * @param c : The new value
	 * @return The current packet
	 */
	IDMap4W<A,B,C,D> setC(C c);
	
	/**
	 * Sets entry D
	 * @param d : The new value
	 * @return The current packet
	 */
	IDMap4W<A,B,C,D> setD(D d);
}
