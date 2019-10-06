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

package org.barghos.core.tuple.tuple2.api;

import org.barghos.core.tuple.tuplen.api.ITupd;

/**
 * @author picatrix1899
 *
 * This interface represents a 2-dimensional double tuple.
 */
public interface ITup2d extends ITup2dR, Tup2, ITupd
{
	/**
	 * Sets the x value of the tuple.
	 * @param x The new x value.
	 * @return The current tuple.
	 */
	ITup2d setX(double x);
	
	/**
	 * Sets the y value of the tuple.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	ITup2d setY(double y);
	
	
	/**
	 * Adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return The current tuple.
	 */
	default ITup2d set(ITup2R t) { Tup2.super.set(t); return this; }
	
	/**
	 * Sets the values to the given value.
	 * @param scalar The new value.
	 * @return The current tuple.
	 */
	default ITup2d set(double scalar) { Tup2.super.set(scalar); return this; }
	
	/**
	 * Sets the values to the corresponding given values.
	 * @param x The new x value.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	default ITup2d set(double x, double y) { Tup2.super.set(x, y); return this; }
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 1.
	 */
	@Override
	default ITup2d set(int index, double value) { Tup2.super.set(index, value); return this; }
}
