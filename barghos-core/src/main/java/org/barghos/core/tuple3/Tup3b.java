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

package org.barghos.core.tuple3;

import java.io.Serializable;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple3.api.Tup3bR;
import org.barghos.core.tuple3.api.Tup3bW;

/**
 * This class represents a 3-dimensional byte tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup3b implements Tup3bR, Tup3bW, Serializable
{
	/**
	 * The class version for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The x component.
	 */
	protected byte x;

	/**
	 * The y component.
	 */
	protected byte y;
	
	/**
	 * The z component.
	 */
	protected byte z;
	
	/**
	 * Creates a new instance with all components set to 0.
	 * 
	 * @since 1.0
	 */
	public Tup3b()
	{
		set((byte)0);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup3bR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup3bR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup3b(Tup3bR t)
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
	public Tup3b(byte value)
	{
		set(value);
	}
	
	/**
	 * Creates a new instance with the values set to the corresponding parameters.
	 * 
	 * @param x The initial x value of the tuple.
	 * @param y The initial y value of the tuple.
	 * @param z The initial z value of the tuple.
	 * 
	 * @since 1.0
	 */
	public Tup3b(byte x, byte y, byte z)
	{
		set(x, y, z);
	}
	
	@Override
	public byte getX()
	{
		return this.x;
	}
	
	@Override
	public byte getY()
	{
		return this.y;
	}

	@Override
	public byte getZ()
	{
		return this.z;
	}
	
	@Override
	public Tup3b setX(byte x)
	{
		this.x = x;
		
		return this;
	}

	@Override
	public Tup3b setY(byte y)
	{
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup3b setZ(byte z)
	{
		this.z = z;
		
		return this;
	}
	
	@Override
	public Tup3b set(Tup3bR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return set(t.getX(), t.getY(), t.getZ());
	}
	
	@Override
	public Tup3b set(byte value)
	{
		return set(value, value, value);
	}
	
	@Override
	public Tup3b set(byte x, byte y, byte z)
	{
		return setX(x).setY(y).setZ(z);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + getX();
		result = prime * result + getY();
		result = prime * result + getZ();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Tup3bR)) return false;
		
		Tup3bR other = (Tup3bR) obj;
		if(getX() != other.getX()) return false;
		if(getY() != other.getY()) return false;
		if(getZ() != other.getZ()) return false;
		return true;
	}
	
	@Override
	public Tup3b clone()
	{
		return new Tup3b(this);
	}
	
	@Override
	public String toString()
	{
		return "tup3b(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ")";
	}
}
