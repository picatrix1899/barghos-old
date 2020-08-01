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

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple4.api.Tup4iR;
import org.barghos.core.tuple4.api.Tup4iW;

/**
 * This class represents a 4-dimensional int tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 * 
 * @see Tup4iR
 * @see Tup4iW
 * @see PTup4i
 * @see Tup4iHelper
 * @see Tup4iPool
 */
public class Tup4i implements Tup4iR, Tup4iW
{
	/**
	 * The x component.
	 */
	protected int x;

	/**
	 * The y component.
	 */
	protected int y;
	
	/**
	 * The z component.
	 */
	protected int z;
	
	/**
	 * The w component.
	 */
	protected int w;
	
	/**
	 * Creates a new instance with all components set to 0;
	 */
	public Tup4i()
	{
		set(0);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup4iR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup4iR} to adopt the values from.
	 * 
	 * @throws ArgumentNullException Thrown if the parameter t is null;
	 */
	public Tup4i(Tup4iR t)
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
	 */
	public Tup4i(int value)
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
	 */
	public Tup4i(int x, int y, int z, int w)
	{
		set(x, y, z, w);
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
	public int getZ()
	{
		return this.z;
	}
	
	@Override
	public int getW()
	{
		return this.w;
	}
	
	@Override
	public Tup4i setX(int x)
	{
		this.x = x;
		return this;
	}

	@Override
	public Tup4i setY(int y)
	{
		this.y = y;
		return this;
	}
	
	@Override
	public Tup4i setZ(int z)
	{
		this.z = z;
		return this;
	}
	
	@Override
	public Tup4i setW(int w)
	{
		this.w = w;
		return this;
	}
	
	@Override
	public Tup4i set(Tup4iR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return set(t.getX(), t.getY(), t.getZ(), t.getW());
	}
	
	@Override
	public Tup4i set(int value)
	{
		return set(value, value, value, value);
	}
	
	@Override
	public Tup4i set(int x, int y, int z, int w)
	{
		return setX(x).setY(y).setZ(z).setW(w);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + getX();
		result = prime * result + getY();
		result = prime * result + getZ();
		result = prime * result + getW();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup4iR)) return false;
		
		Tup4iR other = (Tup4iR) obj;
		if(getX() != other.getX()) return false;
		if(getY() != other.getY()) return false;
		if(getZ() != other.getZ()) return false;
		if(getW() != other.getW()) return false;
		return true;
	}
	
	@Override
	public Tup4i clone()
	{
		return new Tup4i(this);
	}
	
	@Override
	public String toString()
	{
		return "tup4i(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ", w=" + getW() + ")";
	}
}
