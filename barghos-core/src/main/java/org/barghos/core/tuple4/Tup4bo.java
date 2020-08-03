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

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple4.api.Tup4boR;
import org.barghos.core.tuple4.api.Tup4boW;

/**
 * This class represents a 4-dimensional boolean tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup4bo implements Tup4boR, Tup4boW, Serializable
{
	/**
	 * The class version for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The x component.
	 */
	protected boolean x;

	/**
	 * The y component.
	 */
	protected boolean y;
	
	/**
	 * The z component.
	 */
	protected boolean z;
	
	/**
	 * The w component.
	 */
	protected boolean w;
	
	/**
	 * Creates a new instance with all components set to false.
	 * 
	 * @since 1.0
	 */
	public Tup4bo()
	{
		set(false);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup4boR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup4boR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup4bo(Tup4boR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
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
	public Tup4bo(boolean value)
	{
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
	public Tup4bo(boolean x, boolean y, boolean z, boolean w)
	{
		set(x, y, z, w);
	}
	
	@Override
	public boolean getX()
	{
		return this.x;
	}
	
	@Override
	public boolean getY()
	{
		return this.y;
	}

	@Override
	public boolean getZ()
	{
		return this.z;
	}
	
	@Override
	public boolean getW()
	{
		return this.w;
	}
	
	@Override
	public Tup4bo setX(boolean x)
	{
		this.x = x;
		
		return this;
	}

	@Override
	public Tup4bo setY(boolean y)
	{
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup4bo setZ(boolean z)
	{
		this.z = z;
		
		return this;
	}
	
	@Override
	public Tup4bo setW(boolean w)
	{
		this.w = w;
		
		return this;
	}
	
	@Override
	public Tup4bo set(Tup4boR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return set(t.getX(), t.getY(), t.getZ(), t.getW());
	}
	
	@Override
	public Tup4bo set(boolean value)
	{
		return set(value, value, value, value);
	}
	
	@Override
	public Tup4bo set(boolean x, boolean y, boolean z, boolean w)
	{
		return setX(x).setY(y).setZ(z).setW(w);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (getX() ? 1 : 0);
		result = prime * result + (getY() ? 1 : 0);
		result = prime * result + (getZ() ? 1 : 0);
		result = prime * result + (getW() ? 1 : 0);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Tup4boR)) return false;
		
		Tup4boR other = (Tup4boR) obj;
		if(getX() != other.getX()) return false;
		if(getY() != other.getY()) return false;
		if(getZ() != other.getZ()) return false;
		if(getW() != other.getW()) return false;
		return true;
	}
	
	@Override
	public Tup4bo clone()
	{
		return new Tup4bo(this);
	}
	
	@Override
	public String toString()
	{
		return "tup4bo(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ", w=" + getW() + ")";
	}
}
