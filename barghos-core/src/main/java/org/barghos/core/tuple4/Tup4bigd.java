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

package org.barghos.core.tuple4;

import java.io.Serializable;
import java.math.BigDecimal;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple4.api.Tup4bigdR;
import org.barghos.core.tuple4.api.Tup4bigdW;

/**
 * This class represents a 4-dimensional big decimal tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup4bigd implements Tup4bigdR, Tup4bigdW, Serializable
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
	 * The z component.
	 */
	protected BigDecimal z;
	
	/**
	 * The w component.
	 */
	protected BigDecimal w;
	
	/**
	 * Creates a new instance with all components set to BigDecimal.ZERO.
	 * 
	 * @since 1.0
	 */
	public Tup4bigd()
	{
		set(BigDecimal.ZERO);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup4bigdR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup4bigdR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup4bigd(Tup4bigdR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(t.getX() == null) throw new ArgumentNullException("t.getX()");
			if(t.getY() == null) throw new ArgumentNullException("t.getY()");
			if(t.getZ() == null) throw new ArgumentNullException("t.getZ()");
			if(t.getW() == null) throw new ArgumentNullException("t.getW()");
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
	public Tup4bigd(BigDecimal value)
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
	 * @param z The initial z value of the tuple.
	 * @param w The initial w value of the tuple.
	 * 
	 * @since 1.0
	 */
	public Tup4bigd(BigDecimal x, BigDecimal y, BigDecimal z, BigDecimal w)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
			if(y == null) throw new ArgumentNullException("y");
			if(z == null) throw new ArgumentNullException("z");
			if(w == null) throw new ArgumentNullException("w");
		}
		
		set(x, y, z, w);
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
	public BigDecimal getZ()
	{
		return this.z;
	}
	
	@Override
	public BigDecimal getW()
	{
		return this.w;
	}
	
	@Override
	public Tup4bigd setX(BigDecimal x)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
		}
		
		this.x = x;
		
		return this;
	}

	@Override
	public Tup4bigd setY(BigDecimal y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(y == null) throw new ArgumentNullException("y");
		}
		
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup4bigd setZ(BigDecimal z)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(z == null) throw new ArgumentNullException("z");
		}
		
		this.z = z;
		
		return this;
	}
	
	@Override
	public Tup4bigd setW(BigDecimal w)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(w == null) throw new ArgumentNullException("w");
		}
		
		this.w = w;
		
		return this;
	}
	
	@Override
	public Tup4bigd set(Tup4bigdR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(t.getX() == null) throw new ArgumentNullException("t.getX()");
			if(t.getY() == null) throw new ArgumentNullException("t.getY()");
			if(t.getZ() == null) throw new ArgumentNullException("t.getZ()");
			if(t.getW() == null) throw new ArgumentNullException("t.getW()");
		}
		
		return set(t.getX(), t.getY(), t.getZ(), t.getW());
	}
	
	@Override
	public Tup4bigd set(BigDecimal value)
	{
		return set(value, value, value, value);
	}
	
	@Override
	public Tup4bigd set(BigDecimal x, BigDecimal y, BigDecimal z, BigDecimal w)
	{
		return setX(x).setY(y).setZ(z).setW(w);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + getX().hashCode();
		result = prime * result + getY().hashCode();
		result = prime * result + getZ().hashCode();
		result = prime * result + getW().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Tup4bigdR)) return false;
		
		Tup4bigdR other = (Tup4bigdR) obj;
		if(getX().compareTo(other.getX()) != 0) return false;
		if(getY().compareTo(other.getY()) != 0) return false;
		if(getZ().compareTo(other.getZ()) != 0) return false;
		if(getW().compareTo(other.getW()) != 0) return false;
		return true;
	}
	
	@Override
	public Tup4bigd clone()
	{
		return new Tup4bigd(this);
	}
	
	@Override
	public String toString()
	{
		return "tup4bigd(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ", w=" + getW() + ")";
	}
}
