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

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple2.api.Tup2objR;
import org.barghos.core.tuple2.api.Tup2objW;

/**
 * This class represents a 2-dimensional string tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup2obj implements Tup2objR, Tup2objW, Serializable
{
	/**
	 * The class version for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The x component.
	 */
	protected Object x;

	/**
	 * The y component.
	 */
	protected Object y;
	
	/**
	 * Creates a new instance with all components set to new Object().
	 * 
	 * @since 1.0
	 */
	public Tup2obj() { set(new Object()); }
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup2objR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup2objR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup2obj(Tup2objR t)
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
	public Tup2obj(Object value)
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
	public Tup2obj(Object x, Object y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
			if(y == null) throw new ArgumentNullException("y");
		}
		
		set(x, y);
	}
	
	@Override
	public Object getX()
	{
		return this.x;
	}
	
	@Override
	public Object getY()
	{
		return this.y;
	}

	@Override
	public Tup2obj setX(Object x)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
		}
		
		this.x = x;
		
		return this;
	}

	@Override
	public Tup2obj setY(Object y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(y == null) throw new ArgumentNullException("y");
		}
		
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup2obj set(Tup2objR t)
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
	public Tup2obj set(Object value)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(value == null) throw new ArgumentNullException("value");
		}
		
		return set(value, value);
	}
	
	@Override
	public Tup2obj set(Object x, Object y)
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
		if(!(obj instanceof Tup2objR)) return false;
		
		Tup2objR other = (Tup2objR) obj;
		if(!getX().equals(other.getX())) return false;
		if(!getY().equals(other.getY())) return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "tup2obj(x=" + getX() + ", y=" + getY() + ")";
	}
	
	@Override
	public Tup2obj clone()
	{
		return new Tup2obj(this);
	}
}
