/*
MIT License

Copyright (c) 2019 picatrix1899

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

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
