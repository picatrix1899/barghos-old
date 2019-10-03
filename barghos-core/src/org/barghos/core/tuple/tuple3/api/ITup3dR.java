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

package org.barghos.core.tuple.tuple3.api;

import org.barghos.core.tuple.tuplen.api.ITupdR;

/**
 * @author picatrix1899
 *
 * This interface represents a readonly version of a 3-dimensional double tuple.
 */
public interface ITup3dR extends ITup3R, ITupdR
{
	/**
	 * Returns the x value from the tuple.
	 * @return The x value from the tuple.
	 */
	double getX();
	
	/**
	 * Returns the y value from the tuple.
	 * @return The y value from the tuple.
	 */
	double getY();
	
	/**
	 * Returns the z value from the tuple.
	 * @return The z value from the tuple.
	 */
	double getZ();
	
	
	@Override
	default double getUniX() { return getX(); }
	
	@Override
	default double getUniY() { return getY(); }
	
	@Override
	default double getUniZ() { return getZ(); }
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 2.
	 */
	@Override
	default double get(int index)
	{
		if(index < 0 || index > 2) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: 2");

		switch(index)
		{
			case 0: getX();
			case 1: getY();
			case 2: getZ();
			default: throw new IllegalStateException();
		}
	}
}
