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

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple2.api.Tup2sR;

/**
 * Represents a persistent 2-dimensional short tuple.
 * This is a readonly version of a 2-dimensional tuple with extended protection against modification.
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
public abstract class PTup2s implements	Tup2sR
{
	private PTup2s() { }
	
	/**
	 * Generates a new readonly {@link PTup2s} from an existing instance of {@link Tup2sR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup2sR} to adopt the values from.
	 * 
	 * @return A new readonly {@link PTup2s}.
	 * 
	 * @since 1.0
	 */
	public static PTup2s gen(Tup2sR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return gen(t.getX(), t.getY());
	}
	
	/**
	 * Generates a new readonly {@link PTup2s} with all values set to a single value.
	 * 
	 * @param value The value used for all values of the tuple.
	 * 
	 * @return A new readonly {@link PTup2s}.
	 * 
	 * @since 1.0
	 */
	public static PTup2s gen(short value)
	{
		return gen(value, value);
	}

	/**
	 * Generates a new readonly {@link PTup2s} with the values set to the corresponding parameters.
	 * 
	 * @param x The x value.
	 * @param y The y value.
	 * 
	 * @return A new readonly {@link PTup2s}.
	 * 
	 * @since 1.0
	 */
	public static PTup2s gen(short x, short y)
	{
		return new PTup2s()
		{
			@Override
			public short getX() { return x; }
			
			@Override
			public short getY() { return y; }
		};
	}
	
	@Override
	public String toString()
	{
		return "ptup2s(x=" + getX() + ", y=" + getY() + ")";
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
		if (!(obj instanceof Tup2sR)) return false;
		
		Tup2sR other = (Tup2sR) obj;
		if (getX() != other.getX()) return false;
		if (getY() != other.getY()) return false;
		
		return true;
	}
}
