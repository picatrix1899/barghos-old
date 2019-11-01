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

/**
 * @author picatrix1899
 *
 * This class represents a 2-dimensional double tuple.
 */
public class Tup2d implements Tup2dR
{
	private double x;
	private double y;
	
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup2d()
	{
		set(0);
	}
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup2d(Tup2dR t)
	{
		set(t);
	}
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup2d(double scalar)
	{
		set(scalar);
	}
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup2d(double x, double y)
	{
		set(x, y);
	}

	public double getX() { return this.x; }

	public double getY() { return this.y; }

	/**
	 * Sets the x value of the tuple.
	 * @param x The new x value.
	 * @return The current tuple.
	 */
	public Tup2d setX(double x) { this.x = x; return this; }

	/**
	 * Sets the y value of the tuple.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	public Tup2d setY(double y) { this.y = y; return this; }
	
	/**
	 * Adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return The current tuple.
	 */
	public Tup2d set(Tup2dR t) { assert(t != null); return set(t.getX(), t.getY()); }
	
	/**
	 * Sets the values to the given value.
	 * @param scalar The new value.
	 * @return The current tuple.
	 */
	public Tup2d set(double scalar) { return set(scalar, scalar); }
	
	/**
	 * Sets the values to the corresponding given values.
	 * @param x The new x value.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	public Tup2d set(double x, double y) { return setX(x).setY(y); }

}
