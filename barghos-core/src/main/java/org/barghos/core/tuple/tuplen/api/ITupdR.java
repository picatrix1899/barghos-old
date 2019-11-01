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

package org.barghos.core.tuple.tuplen.api;

/**
 * @author picatrix1899
 *
 * This interface represents a readonly version of a n-dimensional immutable double tuple.
 */
public interface ITupdR extends ITupR
{
	/**
	 * Returns the value from the tuple at the given index.
	 * @param index The index of the value to return.
	 * @return The value from the tuple at the given index.
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than the tuples' size - 1.
	 */
	double get(int index);
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than the tuples' size - 1.
	 */
	@Override
	default double getUni(int index)
	{
		if(index < 0 || index >= getDimensions()) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: " + (getDimensions() - 1));

		return get(index);
	}
	
	@Override
	default boolean isFinite()
	{
		for(int i = 0; i < getDimensions(); i++)
		{
			if(!Double.isFinite(get(i))) return false;
		}
		
		return true;
	}
	
	@Override
	default boolean isZero(double tolerance)
	{
		for(int i = 0; i < getDimensions(); i++)
		{
			if(Math.abs(get(i)) > tolerance) return false;
		}
		
		return true;
	}
}
