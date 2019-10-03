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

package org.barghos.core.tuple.tuple2;

import org.barghos.core.tuple.tuple2.api.ITup2R;
import org.barghos.core.tuple.tuple2.api.ITup2f;
import org.barghos.core.tuple.tuplen.Tupf;

/**
 * @author picatrix1899
 *
 * This class represents a 2-dimensional float tuple.
 */
public class Tup2f extends Tupf implements ITup2f
{
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup2f()
	{
		super(2);
	}
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup2f(ITup2R t)
	{
		super(t.getUniX(), t.getUniY());
	}
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup2f(double scalar)
	{
		super(scalar, scalar);
	}
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup2f(double x, double y)
	{
		super(x, y);
	}

	@Override
	public float getX() { return this.v[0]; }

	@Override
	public float getY() { return this.v[1]; }

	@Override
	public Tup2f setX(double x) { this.v[0] = (float)x; return this; }

	@Override
	public Tup2f setY(double y) { this.v[1] = (float)y; return this; }

	
	@Override
	public Tup2f set(ITup2R t) { return set(t.getUniX(), t.getUniY()); }

	@Override
	public Tup2f set(double scalar) { return set(scalar, scalar); }

	@Override
	public Tup2f set(double x, double y)
	{
		this.v[0] = (float)x;
		this.v[1] = (float)y;
		return this;
	}
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 1.
	 */
	@Override
	public Tup2f set(int index, double value) { ITup2f.super.set(index, value); return this; }
}
