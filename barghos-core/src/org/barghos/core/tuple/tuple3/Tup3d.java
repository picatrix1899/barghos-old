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

package org.barghos.core.tuple.tuple3;

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.core.tuple.tuple3.api.ITup3d;
import org.barghos.core.tuple.tuplen.Tupd;

/**
 * @author picatrix1899
 *
 * This class represents a 3-dimensional double tuple.
 */
public class Tup3d extends Tupd implements ITup3d
{
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup3d()
	{
		super(3);
	}
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup3d(ITup3R t)
	{
		super(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup3d(double scalar)
	{
		super(scalar, scalar, scalar);
	}
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup3d(double x, double y, double z)
	{
		super(x, y, z);
	}

	@Override
	public double getX() { return this.v[0]; }

	@Override
	public double getY() { return this.v[1]; }

	@Override
	public double getZ() { return this.v[2]; }

	
	@Override
	public Tup3d setX(double x) { this.v[0] = (float)x; return this; }

	@Override
	public Tup3d setY(double y) { this.v[1] = (float)y; return this; }

	@Override
	public Tup3d setZ(double z) { this.v[2] = (float)z; return this; }

	
	@Override
	public Tup3d set(ITup3R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ()); }

	@Override
	public Tup3d set(double scalar) { return set(scalar, scalar, scalar); }

	@Override
	public Tup3d set(double x, double y, double z)
	{
		this.v[0] = (float)x;
		this.v[1] = (float)y;
		this.v[2] = (float)z;
		return this;
	}

	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 2.
	 */
	@Override
	public Tup3d set(int index, double value) { ITup3d.super.set(index, value); return this; }
}
