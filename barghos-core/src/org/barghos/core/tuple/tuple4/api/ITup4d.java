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

package org.barghos.core.tuple.tuple4.api;

import org.barghos.core.tuple.tuplen.api.ITupd;

/**
 * @author picatrix1899
 *
 * This interface represents a 4-dimensional double tuple.
 */
public interface ITup4d extends ITup4dR, Tup4, ITupd
{
	@Override
	ITup4d setX(double x);
	
	@Override
	ITup4d setY(double y);

	@Override
	ITup4d setZ(double z);
	
	@Override
	ITup4d setW(double w);
	
	
	@Override
	default ITup4d set(ITup4R t) { Tup4.super.set(t); return this; }
	
	@Override
	default ITup4d set(double scalar) { Tup4.super.set(scalar); return this; }
	
	@Override
	default ITup4d set(double x, double y, double z, double w) { Tup4.super.set(x, y, z, w); return this; }
	
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
	 */
	@Override
	default ITup4d set(int index, double value) { Tup4.super.set(index, value); return this; }
}
