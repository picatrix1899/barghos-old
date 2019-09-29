/*
MIT License

Copyright (c) 2019 picatrix1899

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

package org.barghos.core.tuple.tuple4;

import org.barghos.core.tuple.tuple4.api.ITup4R;
import org.barghos.core.tuple.tuple4.api.ITup4fR;

/**
 * This class is a readonly implementation of a 4-dimensional float tuple.
 */
public abstract class PTup4f implements ITup4fR
{
	/**
	 * Generates a readonly {@link PTup4f} that adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return A new readonly {@link PTup4f} with the adopted values.
	 */
	public static PTup4f gen(ITup4R t) { return gen(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	
	/**
	 * This generate a readonly {@link PTup4f} with the values set to scalar.
	 * @param scalar The value.
	 * @return A new readonly {@link PTup4f} with the values set to the given value.
	 */
	public static PTup4f gen(double scalar) { return gen(scalar, scalar, scalar, scalar); }

	/**
	 * This generate a readonly {@link PTup4f} with the values set to the corresponding given values.
	 * @param x The x value.
	 * @param y The y value.
	 * @param z The z value.
	 * @return A new readonly {@link PTup4f} with the values set to the corresponding given values.
	 */
	public static PTup4f gen(double x, double y, double z, double w)
	{
		return new PTup4f()
		{
			@Override
			public float getX() { return (float)x; }
			
			@Override
			public float getY() { return (float)y; }
			
			@Override
			public float getZ() { return (float)z; }
			
			@Override
			public float getW() { return (float)w; }


			@Override
			public double getUniX() { return x; }
			
			@Override
			public double getUniY() { return y; }
			
			@Override
			public double getUniZ() { return z; }
			
			@Override
			public double getUniW() { return w; }
			
			
			/**
			 * {@inheritDoc}
			 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
			 */
			@Override
			public double getUni(int index)
			{
				if(index < 0 || index > 3) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: 3");
				
				switch(index)
				{
					case 0: return x;
					case 1: return y;
					case 2: return z;
					case 3: return w;
					default: throw new IllegalStateException();
				}
			}
			
			/**
			 * {@inheritDoc}
			 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
			 */
			@Override
			public float get(int index)
			{
				if(index < 0 || index > 3) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: 3");
				
				switch(index)
				{
					case 0: return (float)x;
					case 1: return (float)y;
					case 2: return (float)z;
					case 3: return (float)w;
					default: throw new IllegalStateException();
				}
			}
		};
	}
}
