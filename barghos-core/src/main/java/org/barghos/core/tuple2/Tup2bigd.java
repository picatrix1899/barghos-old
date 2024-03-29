/*
MIT License

Copyright (c) 2020 picatrix1899

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

package org.barghos.core.tuple2;

import java.io.Serializable;
import java.math.BigDecimal;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple2.api.Tup2bigdR;
import org.barghos.core.tuple2.api.Tup2bigdW;

/**
 * This class represents a 2-dimensional big decimal tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup2bigd implements Tup2bigdR, Tup2bigdW, Serializable
{
	/**
	 * The class version for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The x component.
	 */
	protected BigDecimal x;

	/**
	 * The y component.
	 */
	protected BigDecimal y;
	
	/**
	 * Creates a new instance with all components set to {@link BigDecimal#ZERO}.
	 * 
	 * @since 1.0
	 */
	public Tup2bigd()
	{
		set(BigDecimal.ZERO);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup2bigdR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup2bigdR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup2bigd(Tup2bigdR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(t.getX() == null) throw new ArgumentNullException("t.getX()");
			if(t.getY() == null) throw new ArgumentNullException("t.getY()");
		}
		
		set(t);
	}
	
	/**
	 * Creates a new instance with all values set to a single value.
	 * 
	 * @param value The value used as the initial value for all values of the tuple.
	 * 
	 * @since 1.0
	 */
	public Tup2bigd(BigDecimal value)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(value == null) throw new ArgumentNullException("value");
		}
		
		set(value);
	}
	
	/**
	 * Creates a new instance with the values set to the corresponding parameters.
	 * 
	 * @param x The initial x value of the tuple.
	 * @param y The initial y value of the tuple.
	 * 
	 * @since 1.0
	 */
	public Tup2bigd(BigDecimal x, BigDecimal y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
			if(y == null) throw new ArgumentNullException("y");
		}
		
		set(x, y);
	}
	
	@Override
	public BigDecimal getX()
	{
		return this.x;
	}
	
	@Override
	public BigDecimal getY()
	{
		return this.y;
	}

	@Override
	public Tup2bigd setX(BigDecimal x)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
		}
		
		this.x = x;
		
		return this;
	}

	@Override
	public Tup2bigd setY(BigDecimal y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(y == null) throw new ArgumentNullException("y");
		}
		
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup2bigd set(Tup2bigdR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(t.getX() == null) throw new ArgumentNullException("t.getX()");
			if(t.getY() == null) throw new ArgumentNullException("t.getY()");
		}
		
		return set(t.getX(), t.getY());
	}
	
	@Override
	public Tup2bigd set(BigDecimal value)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(value == null) throw new ArgumentNullException("value");
		}
		
		return set(value, value);
	}
	
	@Override
	public Tup2bigd set(BigDecimal x, BigDecimal y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
			if(y == null) throw new ArgumentNullException("y");
		}
		
		return setX(x).setY(y);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + getX().hashCode();
		result = prime * result + getY().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Tup2bigdR)) return false;
		
		Tup2bigdR other = (Tup2bigdR) obj;
		if(getX().compareTo(other.getX()) != 0) return false;
		if(getY().compareTo(other.getY()) != 0) return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "tup2bigd(x=" + getX() + ", y=" + getY() + ")";
	}
	
	@Override
	public Tup2bigd clone()
	{
		return new Tup2bigd(this);
	}
}
