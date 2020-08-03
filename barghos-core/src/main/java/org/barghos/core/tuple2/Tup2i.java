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
import org.barghos.core.tuple2.api.Tup2iR;
import org.barghos.core.tuple2.api.Tup2iW;

/**
 * This class represents a 2-dimensional integer tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup2i implements Tup2iR, Tup2iW, Serializable
{
	/**
	 * The class version for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The x component.
	 */
	protected int x;

	/**
	 * The y component.
	 */
	protected int y;
	
	/**
	 * Creates a new instance with all components set to 0.
	 * 
	 * @since 1.0
	 */
	public Tup2i()
	{
		set(0);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup2iR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup2iR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup2i(Tup2iR t)
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
	public Tup2i(int value)
	{
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
	public Tup2i(int x, int y)
	{
		set(x, y);
	}
	
	@Override
	public int getX()
	{
		return this.x;
	}
	
	@Override
	public int getY()
	{
		return this.y;
	}

	@Override
	public Tup2i setX(int x)
	{
		this.x = x;
		
		return this;
	}

	@Override
	public Tup2i setY(int y)
	{
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup2i set(Tup2iR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return set(t.getX(), t.getY());
	}
	
	@Override
	public Tup2i set(int value)
	{
		return set(value, value);
	}
	
	@Override
	public Tup2i set(int x, int y)
	{
		return setX(x).setY(y);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + getX();
		result = prime * result + getY();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup2iR)) return false;
		
		Tup2iR other = (Tup2iR) obj;
		if(getX() != other.getX()) return false;
		if(getY() != other.getY()) return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "tup2i(x=" + getX() + ", y=" + getY() + ")";
	}
	
	@Override
	public Tup2i clone()
	{
		return new Tup2i(this);
	}
}
