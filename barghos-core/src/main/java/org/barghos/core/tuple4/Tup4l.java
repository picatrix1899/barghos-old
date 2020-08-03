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
import org.barghos.core.tuple4.api.Tup4lR;
import org.barghos.core.tuple4.api.Tup4lW;

/**
 * This class represents a 4-dimensional long tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup4l implements Tup4lR, Tup4lW, Serializable
{
	/**
	 * The class version for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The x component.
	 */
	protected long x;

	/**
	 * The y component.
	 */
	protected long y;
	
	/**
	 * The z component.
	 */
	protected long z;
	
	/**
	 * The w component.
	 */
	protected long w;
	
	/**
	 * Creates a new instance with all components set to 0.
	 * 
	 * @since 1.0
	 */
	public Tup4l()
	{
		set(0);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup4iR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup4iR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup4l(Tup4lR t)
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
	public Tup4l(long value)
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
	public Tup4l(long x, long y, long z, long w)
	{
		set(x, y, z, w);
	}
	
	@Override
	public long getX()
	{
		return this.x;
	}
	
	@Override
	public long getY()
	{
		return this.y;
	}

	@Override
	public long getZ()
	{
		return this.z;
	}
	
	@Override
	public long getW()
	{
		return this.w;
	}
	
	@Override
	public Tup4l setX(long x)
	{
		this.x = x;
		
		return this;
	}

	@Override
	public Tup4l setY(long y)
	{
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup4l setZ(long z)
	{
		this.z = z;
		
		return this;
	}
	
	@Override
	public Tup4l setW(long w)
	{
		this.w = w;
		
		return this;
	}
	
	@Override
	public Tup4l set(Tup4lR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return set(t.getX(), t.getY(), t.getZ(), t.getW());
	}
	
	@Override
	public Tup4l set(long value)
	{
		return set(value, value, value, value);
	}
	
	@Override
	public Tup4l set(long x, long y, long z, long w)
	{
		return setX(x).setY(y).setZ(z).setW(w);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getX() ^ (getX() >>> 32));
		result = prime * result + (int) (getY() ^ (getY() >>> 32));
		result = prime * result + (int) (getZ() ^ (getZ() >>> 32));
		result = prime * result + (int) (getW() ^ (getW() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Tup4lR)) return false;
		
		Tup4lR other = (Tup4lR) obj;
		if(getX() != other.getX()) return false;
		if(getY() != other.getY()) return false;
		if(getZ() != other.getZ()) return false;
		if(getW() != other.getW()) return false;
		return true;
	}
	
	@Override
	public Tup4l clone()
	{
		return new Tup4l(this);
	}
	
	@Override
	public String toString()
	{
		return "tup4l(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ", w=" + getW() + ")";
	}
}
