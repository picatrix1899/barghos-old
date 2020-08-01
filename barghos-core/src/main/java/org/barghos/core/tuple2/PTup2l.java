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
import org.barghos.core.tuple2.api.Tup2bR;
import org.barghos.core.tuple2.api.Tup2bW;
import org.barghos.core.tuple2.api.Tup2lR;

/**
 * Represents a persistent 2-dimensional byte tuple.
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
 * 
 * @see PTup2l#gen(int)
 * @see PTup2l#gen(Tup2bR)
 * @see PTup2l#gen(byte, byte)
 * @see Tup2b
 * @see Tup2bR
 * @see Tup2bW
 */
public abstract class PTup2l implements	Tup2lR
{
	private PTup2l() { }
	
	/**
	 * Generates a new readonly {@link PTup2l} from an existing instance of {@link Tup2lR} and adopts the values.
	 * 
	 * @param t An existing implementation of {@link Tup2lR} to adopt the values from.
	 * 
	 * @return A new readonly {@link PTup2l}.
	 */
	public static PTup2l gen(Tup2lR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return gen(t.getX(), t.getY());
	}
	
	/**
	 * Generates a new readonly {@link PTup2l} with all values set to a single value.
	 * 
	 * @param value The value used for all values of the tuple.
	 * 
	 * @return A new readonly {@link PTup2l}.
	 */
	public static PTup2l gen(long value)
	{
		return gen(value, value);
	}

	/**
	 * Generates a new readonly {@link PTup2l} with the values set to the corresponding parameters.
	 * 
	 * @param x The x value.
	 * @param y The y value.
	 * 
	 * @return A new readonly {@link PTup2l}.
	 */
	public static PTup2l gen(long x, long y)
	{
		return new PTup2l()
		{
			@Override
			public long getX() { return x; }
			
			@Override
			public long getY() { return y; }
		};
	}
	
	@Override
	public String toString()
	{
		return "ptup2l(x=" + getX() + ", y=" + getY() + ")";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getX() ^ (getX() >>> 32));
		result = prime * result + (int) (getY() ^ (getY() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Tup2lR)) return false;
		
		Tup2lR other = (Tup2lR) obj;
		if (getX() != other.getX()) return false;
		if (getY() != other.getY()) return false;
		
		return true;
	}
}
