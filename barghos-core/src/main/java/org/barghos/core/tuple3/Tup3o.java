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

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple3.api.Tup3oR;
import org.barghos.core.tuple3.api.Tup3oW;

/**
 * This class represents a 3-dimensional object tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup3o<X,Y,Z> implements Tup3oR<X,Y,Z>, Tup3oW<X,Y,Z>
{
	/**
	 * The x component.
	 */
	protected X x;

	/**
	 * The y component.
	 */
	protected Y y;
	
	/**
	 * The z component.
	 */
	protected Z z;
	
	/**
	 * Creates a new instance with all components set to null.
	 * 
	 * @since 1.0
	 */
	public Tup3o() { }
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup3oR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup3oR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup3o(Tup3oR<X,Y,Z> t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(t.getX() == null) throw new ArgumentNullException("t.getX()");
			if(t.getY() == null) throw new ArgumentNullException("t.getY()");
			if(t.getZ() == null) throw new ArgumentNullException("t.getZ()");
		}
		
		set(t);
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
	public Tup3o(X x, Y y, Z z)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
			if(y == null) throw new ArgumentNullException("y");
			if(z == null) throw new ArgumentNullException("z");
		}
		
		set(x, y, z);
	}
	
	@Override
	public X getX()
	{
		return this.x;
	}
	
	@Override
	public Y getY()
	{
		return this.y;
	}

	@Override
	public Z getZ()
	{
		return this.z;
	}
	
	@Override
	public Tup3o<X,Y,Z> setX(X x)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
		}
		
		this.x = x;
		
		return this;
	}

	@Override
	public Tup3o<X,Y,Z> setY(Y y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(y == null) throw new ArgumentNullException("y");
		}
		
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup3o<X,Y,Z> setZ(Z z)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(z == null) throw new ArgumentNullException("z");
		}
		
		this.z = z;
		
		return this;
	}
	
	@Override
	public Tup3o<X,Y,Z> set(Tup3oR<X,Y,Z> t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(t.getX() == null) throw new ArgumentNullException("t.getX()");
			if(t.getY() == null) throw new ArgumentNullException("t.getY()");
			if(t.getZ() == null) throw new ArgumentNullException("t.getZ()");
		}
		
		return set(t.getX(), t.getY(), t.getZ());
	}
	
	@Override
	public Tup3o<X,Y,Z> set(X x, Y y, Z z)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
			if(y == null) throw new ArgumentNullException("y");
			if(z == null) throw new ArgumentNullException("z");
		}
		
		return setX(x).setY(y).setZ(z);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + getX().hashCode();
		result = prime * result + getY().hashCode();
		result = prime * result + getZ().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup3oR)) return false;
		
		@SuppressWarnings("unchecked")
		Tup3oR<X,Y,Z> other = (Tup3oR<X,Y,Z>) obj;
		if(!getX().equals(other.getX())) return false;
		if(!getY().equals(other.getY())) return false;
		if(!getZ().equals(other.getZ())) return false;
		return true;
	}
	
	@Override
	public Tup3o<X,Y,Z> clone()
	{
		return new Tup3o<X,Y,Z>(this);
	}
	
	@Override
	public String toString()
	{
		return "tup3o(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ")";
	}
}
