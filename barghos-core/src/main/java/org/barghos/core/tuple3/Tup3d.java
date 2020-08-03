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
import org.barghos.core.tuple3.api.Tup3dR;
import org.barghos.core.tuple3.api.Tup3dW;

/**
 * This class represents a 3-dimensional double tuple.
 * A tuple unlike a vector contains data that is not necessarly in any relation to each other,
 * where the data of a vector describes the same logical structure.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public class Tup3d implements Tup3dR, Tup3dW, Serializable
{
	/**
	 * The class version for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The x component.
	 */
	protected double x;

	/**
	 * The y component.
	 */
	protected double y;
	
	/**
	 * The z component.
	 */
	protected double z;
	
	/**
	 * Creates a new instance with all components set to 0.
	 * 
	 * @since 1.0
	 */
	public Tup3d()
	{
		set(0.0f);
	}
	
	/**
	 * Creates a new instance from an existing instance of {@link Tup3dR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup3dR} to adopt the values from.
	 * 
	 * @since 1.0
	 */
	public Tup3d(Tup3dR t)
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
	public Tup3d(double value)
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
	public Tup3d(double x, double y, double z)
	{
		set(x, y, z);
	}
	
	@Override
	public double getX()
	{
		return this.x;
	}
	
	@Override
	public double getY()
	{
		return this.y;
	}

	@Override
	public double getZ()
	{
		return this.z;
	}
	
	@Override
	public Tup3d setX(double x)
	{
		this.x = x;
		
		return this;
	}

	@Override
	public Tup3d setY(double y)
	{
		this.y = y;
		
		return this;
	}
	
	@Override
	public Tup3d setZ(double z)
	{
		this.z = z;
		
		return this;
	}
	
	@Override
	public Tup3d set(Tup3dR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return set(t.getX(), t.getY(), t.getZ());
	}
	
	@Override
	public Tup3d set(double value)
	{
		return set(value, value, value);
	}
	
	@Override
	public Tup3d set(double x, double y, double z)
	{
		return setX(x).setY(y).setZ(z);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp = Double.doubleToLongBits(getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getZ());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Tup3dR)) return false;
		
		Tup3dR other = (Tup3dR) obj;
		if(Double.doubleToLongBits(getX()) != Double.doubleToLongBits(other.getX())) return false;
		if(Double.doubleToLongBits(getY()) != Double.doubleToLongBits(other.getY())) return false;
		if(Double.doubleToLongBits(getZ()) != Double.doubleToLongBits(other.getZ())) return false;
		return true;
	}
	
	@Override
	public Tup3d clone()
	{
		return new Tup3d(this);
	}
	
	@Override
	public String toString()
	{
		return "tup3d(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ")";
	}
}
