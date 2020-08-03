/*
MIT License

Copyright (c) 2020 picatrix1899

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

package org.barghos.core.tuple4.api;

/**
 * This interface grants writeonly access to any 4-dimensional object tuples.
 * It should be prefered by design before direct usage of the original instance in method parameters.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public interface Tup4oW<X,Y,Z,W>
{
	/**
	 * Sets the x value of the tuple.
	 * 
	 * @param x The new x value.
	 * 
	 * @return The current tuple.
	 * 
	 * @since 1.0
	 */
	Tup4oW<X,Y,Z,W> setX(X x);
	
	/**
	 * Sets the y value of the tuple.
	 * 
	 * @param y The new y value.
	 * 
	 * @return The current tuple.
	 * 
	 * @since 1.0
	 */
	Tup4oW<X,Y,Z,W> setY(Y y);
	
	/**
	 * Sets the z value of the tuple.
	 * 
	 * @param z The new z value.
	 * 
	 * @return The current tuple.
	 */
	Tup4oW<X,Y,Z,W> setZ(Z z);
	
	/**
	 * Sets the w value of the tuple.
	 * 
	 * @param w The new w value.
	 * 
	 * @return The current tuple.
	 */
	Tup4oW<X,Y,Z,W> setW(W w);
	
	/**
	 * Adopts the values from an existing instance of {@link Tup4oR}.
	 * 
	 * @param t An existing implementation of {@link Tup4oR} to adopt the values from.
	 * 
	 * @return The current tuple.
	 * 
	 * @since 1.0
	 */
	Tup4oW<X,Y,Z,W> set(Tup4oR<X,Y,Z,W> t);
	
	/**
	 * Sets the values to the corresponding paramters.
	 * 
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @param w The new w value.
	 * 
	 * @return The current tuple.
	 * 
	 * @since 1.0
	 */
	Tup4oW<X,Y,Z,W> set(X x, Y y, Z z, W w);
}
