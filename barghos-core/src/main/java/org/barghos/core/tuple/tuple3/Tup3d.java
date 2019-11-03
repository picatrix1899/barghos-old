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

/**
 * @author picatrix1899
 *
 * This class represents a 3-dimensional double tuple.
 */
public class Tup3d implements Tup3dR
{
	private double x;
	private double y;
	private double z;
	
	/**
	 * This constructor initializes the tuple with all values set to 0.
	 */
	public Tup3d() { set(0); }
	
	/**
	 * This constructor initializes the tuple with the values of the given tuple.
	 */
	public Tup3d(Tup3dR t) { set(t); }
	
	/**
	 * This constructor initializes the tuple values with scalar.
	 */
	public Tup3d(double scalar) { set(scalar); }
	
	/**
	 * This constructor initializes the tuple with the given values.
	 */
	public Tup3d(double x, double y, double z) { set(x, y, z); }
	
	@Override
	public double getX() { return this.x; }
	
	@Override
	public double getY() { return this.y; }

	@Override
	public double getZ() { return this.z; }
	
	/**
	 * Sets the x value of the tuple.
	 * @param x The new x value.
	 * @return The current tuple.
	 */
	public Tup3d setX(double x) { this.x = x; return this; }

	/**
	 * Sets the y value of the tuple.
	 * @param y The new y value.
	 * @return The current tuple.
	 */
	public Tup3d setY(double y) { this.y = y; return this; }
	
	/**
	 * Sets the z value of the tuple.
	 * @param z The new z value.
	 * @return The current tuple.
	 */
	public Tup3d setZ(double z) { this.z = z; return this; }
	
	/**
	 * Adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return The current tuple.
	 */
	public Tup3d set(Tup3dR t) { assert(t != null); return set(t.getX(), t.getY(), t.getZ()); }
	
	/**
	 * Sets the values to the given value.
	 * @param scalar The new value.
	 * @return The current tuple.
	 */
	public Tup3d set(double scalar) { return set(scalar, scalar, scalar); }
	
	/**
	 * Sets the values to the corresponding given values.
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 * @return The current tuple.
	 */
	public Tup3d set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	@Override
	public String toString()
	{
		return "tup3d(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup3dR)) return false;
		
		Tup3dR other = (Tup3dR) obj;
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.getX())) return false;
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.getY())) return false;
		if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.getZ())) return false;
		return true;
	}
	
	@Override
	public Tup3d clone() { return new Tup3d(this); }
}
