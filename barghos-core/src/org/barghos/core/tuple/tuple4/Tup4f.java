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

package org.barghos.core.tuple.tuple4;

import org.barghos.core.tuple.tuple4.api.ITup4R;
import org.barghos.core.tuple.tuple4.api.ITup4f;
import org.barghos.core.tuple.tuplen.Tupf;

/**
 * @author picatrix1899
 *
 * This class represents a 4-dimensional float tuple.
 */
public class Tup4f extends Tupf implements ITup4f
{
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup4f()
	{
		super(4);
	}
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup4f(ITup4R t)
	{
		super(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW());
	}
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup4f(double x, double y, double z, double w)
	{
		super(x, y, z, w);
	}
	
	@Override
	public double getUniX() { return this.v[0]; }

	@Override
	public double getUniY() { return this.v[1]; }

	@Override
	public double getUniZ() { return this.v[2]; }
	
	@Override
	public double getUniW() { return this.v[3]; }

	
	@Override
	public float getX() { return this.v[0]; }

	@Override
	public float getY() { return this.v[1]; }

	@Override
	public float getZ() { return this.v[2]; }
	
	@Override
	public float getW() { return this.v[3]; }
	
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
	 */
	@Override
	public double getUni(int index)
	{
		if(index < 0 || index > 3) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: 3");

		return this.v[index];
	}

	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
	 */
	@Override
	public float get(int index)
	{
		if(index < 0 || index > 3) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: 3");

		return this.v[index];
	}

	
	@Override
	public Tup4f setX(double x) { this.v[0] = (float)x; return this; }

	@Override
	public Tup4f setY(double y) { this.v[1] = (float)y; return this; }

	@Override
	public Tup4f setZ(double z) { this.v[2] = (float)z; return this; }
	
	@Override
	public Tup4f setW(double w) { this.v[3] = (float)w; return this; }
	
	
	@Override
	public Tup4f set(ITup4R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }

	@Override
	public Tup4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }

	@Override
	public Tup4f set(double x, double y, double z, double w)
	{
		this.v[0] = (float)x;
		this.v[1] = (float)y;
		this.v[2] = (float)z;
		return this;
	}

	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
	 */
	@Override
	public Tup4f set(int index, double value)
	{
		if(index < 0 || index > 3) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: 3");
		
		this.v[index] = (float)value;
		return this;
	}
}
