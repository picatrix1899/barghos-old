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

package org.barghos.core.tuple.tuplen;

import org.barghos.core.tuple.tuplen.api.ITupdR;

/**
 * This class is a readonly implementation of a n-dimensional immutable double tuple.
 */
public abstract class PTupd implements ITupdR
{
	/**
	 * Generates a readonly {@link PTupd} that adopts the given values.
	 * @param values The values to adopt.
	 * @return A new readonly {@link PTupd} with the given values.
	 */
	public static PTupd gen(double... values)
	{
		double[] v = new double[values.length];
		
		for(int i = 0; i < values.length; i++)
			v[i] = values[i];
		
		return new PTupd()
		{
			/**
			 * {@inheritDoc}
			 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than the tuples' size - 1.
			 */
			@Override
			public double get(int index)
			{
				if(index < 0 || index > values.length) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: " + (values.length - 1));
				
				return v[index];
			}
			
			
			@Override
			public int getDimensions() { return v.length; }
		};
	}
}
