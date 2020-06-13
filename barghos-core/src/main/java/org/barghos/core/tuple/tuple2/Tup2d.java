/*
MIT License

Copyright (c) 2019-2020 picatrix1899

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
 * This class represents a 2-dimensional double tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 * 
 * @see Tup2dR
 * @see Tup2dW
 * @see PTup2d
 * @see Tup2dHelper
 * @see Tup2dPool
 */
public class Tup2d implements Tup2dR, Tup2dW
{
	/**
	 * The x component.
	 */
	protected double x;

	/**
	 * The y component.
	 */
	protected double y;
	
	/**
	 * Creates a new instance with all components set to 0;
	 */
	public Tup2d()
	{
		set(0.0);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup2dR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup2dR} to adopt the values from.
	 * 
	 * @throws ArgumentNullException Thrown if the parameter t is null;
	 */
	public Tup2d(Tup2dR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		set(t);
	}
	
	/**
	 * Creates a new instance with all values set to a single value.
	 * 
	 * @param value The value used as the initial value for all values of the tuple.
	 */
	public Tup2d(double value)
	{
		set(value);
	}
	
	/**
	 * Creates a new instance with the values set to the corresponding parameters.
	 * 
	 * @param x The initial x value of the tuple.
	 * @param y The initial y value of the tuple.
	 */
	public Tup2d(double x, double y)
	{
		set(x, y);
	}
	
	@Override
	public double getX()
	{
		return this.x;
	}
	
	@Override
	public double getY()
	{
		return this.y;
	}

	/**
	 * Sets the x value of the tuple.
	 * 
	 * @param x The new x value.
	 * 
	 * @return The current tuple.
	 */
	public Tup2d setX(double x)
	{
		this.x = x;
		return this;
	}

	/**
	 * Sets the y value of the tuple.
	 * 
	 * @param y The new y value.
	 * 
	 * @return The current tuple.
	 */
	public Tup2d setY(double y)
	{
		this.y = y;
		return this;
	}
	
	/**
	 * Adopts the values from an existing instance of {@link Tup2dR}.
	 * 
	 * @param t An existing implementation of {@link Tup2dR} to adopt the values from.
	 * 
	 * @return The current tuple.
	 * 
	 * @throws ArgumentNullException Thrown if the parameter t is null;
	 */
	public Tup2d set(Tup2dR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		return set(t.getX(), t.getY());
	}
	
	/**
	 * Sets all values to a single value.
	 * 
	 * <p>
	 * This is usually used for resetting the tuple back to 0 again, by calling <code>set(0)</code>.
	 * </p>
	 * 
	 * @param value The value used for all values of the tuple.
	 * 
	 * @return The current tuple.
	 */
	public Tup2d set(double value)
	{
		return set(value, value);
	}
	
	/**
	 * Sets the values to the corresponding paramters.
	 * 
	 * @param x The new x value.
	 * @param y The new y value.
	 * 
	 * @return The current tuple.
	 */
	public Tup2d set(double x, double y)
	{
		return setX(x).setY(y);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp = Double.doubleToLongBits(getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup2dR)) return false;
		
		Tup2dR other = (Tup2dR) obj;
		if(getX() != other.getX()) return false;
		if(getY() != other.getY()) return false;
		return true;
	}
	
	@Override
	public Tup2d clone()
	{
		return new Tup2d(this);
	}
	
	@Override
	public String toString()
	{
		return "tup2d(x=" + getX() + ", y=" + getY() + ")";
	}
}
