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

package org.barghos.core.tuple.tuple3.api;

import org.barghos.core.tuple.tuplen.api.ITupW;

/**
 * @author picatrix1899
 *
 * This interface represents a writable version of a unspecialized 3-dimensional tuple.
 */
public interface ITup3W extends ITup3R, ITupW
{
	/**
	 * Sets the x value of the tuple.
	 * @param x The new x value.
	 * @return The current tuple.
	 */
	ITup3W setX(double x);
	
	/**
	 * Sets the y value of the tuple.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	ITup3W setY(double y);
	
	/**
	 * Sets the z value of the tuple.
	 * @param z The new z value.
	 * @return The current tuple.
	 */
	ITup3W setZ(double z);
	
	
	/**
	 * Adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return The current tuple.
	 */
	ITup3W set(ITup3R t);
	
	/**
	 * Sets the values to the given value.
	 * @param scalar The new value.
	 * @return The current tuple.
	 */
	ITup3W set(double scalar);
	
	/**
	 * Sets the values to the corresponding given values.
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @return The current tuple.
	 */
	ITup3W set(double x, double y, double z);
	
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 2.
	 */
	@Override
	ITup3W set(int index, double value);
}
