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
import org.barghos.core.tuple3.api.Tup3boR;

/**
 * Represents a persistent 3-dimensional boolean tuple.
 * This is a readonly version of a 3-dimensional tuple with extended protection against modification.
 * It can be used as a more flexible way to create constants.
 * 
 * <p>
 * This class should not be inherited, not direct by extending nor anonymous,
 * as this would render the protection mechanism used as useless.
 * To get an instance you call one of the static generator methods.
 * </p>
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public abstract class PTup3bo implements Tup3boR
{
	private PTup3bo() { }
	
	/**
	 * Generates a new readonly {@link PTup3bo} from an existing instance of {@link Tup3boR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup3boR} to adopt the values from.
	 * 
	 * @return A new readonly {@link PTup3bo}.
	 * 
	 * @since 1.0
	 */
	public static PTup3bo gen(Tup3boR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return gen(t.getX(), t.getY(), t.getZ());
	}
	
	/**
	 * Generates a new readonly {@link PTup3bo} with all values set to a single value.
	 * 
	 * @param value The value used for all values of the tuple.
	 * 
	 * @return A new readonly {@link PTup3bo}.
	 * 
	 * @since 1.0
	 */
	public static PTup3bo gen(boolean value)
	{
		return gen(value, value, value);
	}

	/**
	 * Generates a new readonly {@link PTup3bo} with the values set to the corresponding parameters.
	 * 
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * 
	 * @return A new readonly {@link PTup3bo}.
	 * 
	 * @since 1.0
	 */
	public static PTup3bo gen(boolean x, boolean y, boolean z)
	{
		return new PTup3bo()
		{
			@Override
			public boolean getX() { return x; }
			
			@Override
			public boolean getY() { return y; }
			
			@Override
			public boolean getZ() { return z; }
		};
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (getX() ? 1 : 0);
		result = prime * result + (getY() ? 1 : 0);
		result = prime * result + (getZ() ? 1 : 0);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Tup3boR)) return false;
		
		Tup3boR other = (Tup3boR) obj;
		if(getX() != other.getX()) return false;
		if(getY() != other.getY()) return false;
		if(getZ() != other.getZ()) return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "ptup3bo(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ")";
	}
}
