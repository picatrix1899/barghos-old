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

package org.barghos.core.tuple2;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple2.api.Tup2fR;
import org.barghos.core.tuple2.api.Tup2fW;
import org.barghos.core.tuple2.pool.Tup2fPool;

/**
 * This class represents a 2-dimensional float tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 * 
 * @see Tup2fR
 * @see Tup2fW
 * @see PTup2f
 * @see Tup2fHelper
 * @see Tup2fPool
 */
public class Tup2f implements Tup2fR, Tup2fW
{
	/**
	 * The x component.
	 */
	protected float x;

	/**
	 * The y component.
	 */
	protected float y;
	
	/**
	 * Creates a new instance with all components set to 0;
	 */
	public Tup2f()
	{
		set(0.0f);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup2fR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup2fR} to adopt the values from.
	 * 
	 * @throws ArgumentNullException Thrown if the parameter t is null;
	 */
	public Tup2f(Tup2fR t)
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
	public Tup2f(float value)
	{
		set(value);
	}
	
	/**
	 * Creates a new instance with the values set to the corresponding parameters.
	 * 
	 * @param x The initial x value of the tuple.
	 * @param y The initial y value of the tuple.
	 */
	public Tup2f(float x, float y)
	{
		set(x, y);
	}
	
	@Override
	public float getX()
	{
		return this.x;
	}
	
	@Override
	public float getY()
	{
		return this.y;
	}

	@Override
	public Tup2f setX(float x)
	{
		this.x = x;
		return this;
	}

	@Override
	public Tup2f setY(float y)
	{
		this.y = y;
		return this;
	}
	
	@Override
	public Tup2f set(Tup2fR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return set(t.getX(), t.getY());
	}
	
	@Override
	public Tup2f set(float value)
	{
		return set(value, value);
	}
	
	@Override
	public Tup2f set(float x, float y)
	{
		return setX(x).setY(y);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(getX());
		result = prime * result + Float.floatToIntBits(getY());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup2fR)) return false;
		
		Tup2fR other = (Tup2fR) obj;
		if(Float.floatToIntBits(getX()) != Float.floatToIntBits(other.getX())) return false;
		if(Float.floatToIntBits(getY()) != Float.floatToIntBits(other.getY())) return false;
		return true;
	}
	
	@Override
	public Tup2f clone()
	{
		return new Tup2f(this);
	}
	
	@Override
	public String toString()
	{
		return "tup2f(x=" + getX() + ", y=" + getY() + ")";
	}
}
