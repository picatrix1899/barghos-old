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

import org.barghos.core.exception.ArgumentNullException;

/**
 * @author picatrix1899
 *
 * This class represents a 4-dimensional float tuple.
 */
public class Tup4f implements Tup4fR, Tup4fW
{
	protected float x;
	protected float y;
	protected float z;
	protected float w;
	
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup4f() { set(0); }
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup4f(Tup4fR t) { if(t == null) throw new ArgumentNullException("t"); set(t); }
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup4f(float scalar) { set(scalar); }
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup4f(float x, float y, float z, float w) { set(x, y, z, w); }

	public float getX() { return this.x; }

	public float getY() { return this.y; }

	public float getZ() { return this.z; }
	
	public float getW() { return this.w; }

	 /* Sets the x value of the tuple.
	 * @param x The new x value.
	 * @return The current tuple.
	 */
	public Tup4f setX(float x) { this.x = x; return this; }

	/**
	 * Sets the y value of the tuple.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	public Tup4f setY(float y) { this.y = y; return this; }

	/**
	 * Sets the z value of the tuple.
	 * @param z The new z value.
	 * @return The current tuple.
	 */
	public Tup4f setZ(float z) { this.z = z; return this; }
	
	/**
	 * Sets the w value of the tuple.
	 * @param w The new w value.
	 * @return The current tuple.
	 */
	public Tup4f setW(float w) { this.w = w; return this; }
	
	/**
	 * Adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return The current tuple.
	 */
	public Tup4f set(Tup4fR t) { if(t == null) throw new ArgumentNullException("t"); return set(t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	/**
	 * Sets the values to the given value.
	 * @param scalar The new value.
	 * @return The current tuple.
	 */
	public Tup4f set(float scalar) { return set(scalar, scalar, scalar, scalar); }
	
	/**
	 * Sets the values to the corresponding given values.
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @param w The new w value.
	 * @return The current tuple.
	 */
	public Tup4f set(float x, float y, float z, float w) { return setX(x).setY(y).setZ(z).setW(w); }
}
