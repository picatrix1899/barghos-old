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

import org.barghos.core.exception.ArgumentNullException;

/**
 * @author picatrix1899
 *
 * This class represents a 2-dimensional float tuple.
 */
public class Tup2f implements Tup2fR
{
	protected float x;
	protected float y;
	
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup2f() { set(0.0f); }
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup2f(Tup2fR t) { if(t == null) throw new ArgumentNullException("t"); set(t); }
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup2f(float scalar) { set(scalar); }
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup2f(float x, float y) { set(x, y); }

	@Override
	public float getX() { return this.x; }
	
	@Override
	public float getY() { return this.y; }

	/**
	 * Sets the x value of the tuple.
	 * @param x The new x value.
	 * @return The current tuple.
	 */
	public Tup2f setX(float x) { this.x = x; return this; }

	/**
	 * Sets the y value of the tuple.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	public Tup2f setY(float y) { this.y = y; return this; }
	
	/**
	 * Adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return The current tuple.
	 */
	public Tup2f set(Tup2fR t) { if(t == null) throw new ArgumentNullException("t"); return set(t.getX(), t.getY()); }
	
	/**
	 * Sets the values to the given value.
	 * @param scalar The new value.
	 * @return The current tuple.
	 */
	public Tup2f set(float scalar) { return set(scalar, scalar); }
	
	/**
	 * Sets the values to the corresponding given values.
	 * @param x The new x value.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	public Tup2f set(float x, float y) { return setX(x).setY(y); }
	
	@Override
	public String toString()
	{
		return "tup2f(x=" + this.x + ", y=" + this.y + ")";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(this.x);
		result = prime * result + Float.floatToIntBits(this.y);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup2fR)) return false;
		
		Tup2fR other = (Tup2fR) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.getX())) return false;
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.getY())) return false;
		return true;
	}
	
	@Override
	public Tup2f clone() { return new Tup2f(this); }
}
