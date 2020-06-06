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
