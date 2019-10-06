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

/**
 * @author picatrix1899
 *
 * This class represents a 4-dimensional float tuple.
 */
public class Tup4f implements ITup4f
{
	private float x;
	private float y;
	private float z;
	private float w;
	
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup4f()
	{
		set(0);
	}
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup4f(ITup4R t)
	{
		set(t);
	}
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup4f(double scalar)
	{
		set(scalar);
	}
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup4f(double x, double y, double z, double w)
	{
		set(x, y, z, w);
	}

	@Override
	public float getX() { return this.x; }

	@Override
	public float getY() { return this.y; }

	@Override
	public float getZ() { return this.z; }
	
	@Override
	public float getW() { return this.w; }

	@Override
	public Tup4f setX(double x) { this.x = (float)x; return this; }

	@Override
	public Tup4f setY(double y) { this.y = (float)y; return this; }

	@Override
	public Tup4f setZ(double z) { this.z = (float)z; return this; }
	
	@Override
	public Tup4f setW(double w) { this.w = (float)w; return this; }
}
