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
import org.barghos.core.tuple.tuple4.api.ITup4d;

/**
 * @author picatrix1899
 *
 * This class represents a 4-dimensional double tuple.
 */
public class Tup4d implements ITup4d
{
	private double x;
	private double y;
	private double z;
	private double w;
	
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup4d()
	{
		set(0);
	}
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup4d(ITup4R t)
	{
		set(t);
	}
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup4d(double scalar)
	{
		set(scalar);
	}
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup4d(double x, double y, double z, double w)
	{
		set(x, y, z, w);
	}

	@Override
	public double getX() { return this.x; }

	@Override
	public double getY() { return this.y; }

	@Override
	public double getZ() { return this.z; }
	
	@Override
	public double getW() { return this.w; }

	@Override
	public Tup4d setX(double x) { this.x = x; return this; }

	@Override
	public Tup4d setY(double y) { this.y = y; return this; }

	@Override
	public Tup4d setZ(double z) { this.z = z; return this; }
	
	@Override
	public Tup4d setW(double w) { this.w = w; return this; }
}
