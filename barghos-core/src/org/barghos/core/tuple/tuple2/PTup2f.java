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

package org.barghos.core.tuple.tuple2;

import org.barghos.core.tuple.tuple2.api.ITup2R;
import org.barghos.core.tuple.tuple2.api.ITup2fR;

/**
 * This class is a readonly implementation of a 2-dimensional float tuple.
 */
public abstract class PTup2f implements ITup2fR
{
	/**
	 * Generates a readonly {@link PTup2f} that adopts the values from the given tuple.
	 * @param t The tuple that values will be adopted from.
	 * @return A new readonly {@link PTup2f} with the adopted values.
	 */
	public static PTup2f gen(ITup2R t) { return gen(t.getUniX(), t.getUniY()); }
	
	/**
	 * This generate a readonly {@link PTup2f} with the values set to scalar.
	 * @param scalar The value.
	 * @return A new readonly {@link PTup2f} with the values set to the given value.
	 */
	public static PTup2f gen(double scalar) { return gen(scalar, scalar); }

	/**
	 * This generate a readonly {@link PTup2f} with the values set to the corresponding given values.
	 * @param x The x value.
	 * @param y The y value.
	 * @return A new readonly {@link PTup2f} with the values set to the corresponding given values.
	 */
	public static PTup2f gen(double x, double y)
	{
		return new PTup2f()
		{
			@Override
			public float getX() { return (float)x; }
			
			@Override
			public float getY() { return (float)y; }
		};
	}
}
