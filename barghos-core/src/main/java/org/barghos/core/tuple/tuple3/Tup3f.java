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

import org.barghos.core.exception.ArgumentNullException;

/**
 * @author picatrix1899
 *
 * This class represents a 3-dimensional float tuple.
 */
public class Tup3f implements Tup3fR
{
	protected float x;
	protected float y;
	protected float z;
	
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup3f() { set(0.0f); }
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup3f(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); set(t); }
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup3f(float scalar) { set(scalar); }
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup3f(float x, float y, float z) { set(x, y, z); }

	@Override
	public float getX() { return this.x; }
	
	@Override
	public float getY() { return this.y; }
	
	@Override
	public float getZ() { return this.z; }

	/**
	 * Sets the x value of the tuple.
	 * @param x The new x value.
	 * @return The current tuple.
	 */
	public Tup3f setX(float x) { this.x = x; return this; }

	/**
	 * Sets the y value of the tuple.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	public Tup3f setY(float y) { this.y = y; return this; }
	
	/**
	 * Sets the z value of the tuple.
	 * @param z The new z value.
	 * @return The current tuple.
	 */
	public Tup3f setZ(float z) { this.z = z; return this; }
	
	/**
	 * Adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return The current tuple.
	 */
	public Tup3f set(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return set(t.getX(), t.getY(), t.getZ()); }
	
	/**
	 * Sets the values to the given value.
	 * @param scalar The new value.
	 * @return The current tuple.
	 */
	public Tup3f set(float scalar) { return set(scalar, scalar, scalar); }
	
	/**
	 * Sets the values to the corresponding given values.
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @return The current tuple.
	 */
	public Tup3f set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	
	@Override
	public String toString()
	{
		return "tup3f(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(this.x);
		result = prime * result + Float.floatToIntBits(this.y);
		result = prime * result + Float.floatToIntBits(this.z);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup3fR)) return false;
		
		Tup3fR other = (Tup3fR) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.getX())) return false;
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.getY())) return false;
		if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.getZ())) return false;
		return true;
	}
	
	@Override
	public Tup3f clone() { return new Tup3f(this); }
}
