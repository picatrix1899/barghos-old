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

package org.barghos.core.tuple.tuple4.api;

import org.barghos.core.tuple.tuplen.api.ITupR;

/**
 * @author picatrix1899
 *
 * This interface represents a readonly version of a unspecialized 4-dimensional tuple.
 */
public interface ITup4R extends ITupR
{
	/**
	 * Returns the x value from the tuple.
	 * This is a generalized fuction and is as such available in all derivations of 4-dimensional tuples.
	 * @return The x value from the tuple.
	 */
	double getUniX();
	
	/**
	 * Returns the y value from the tuple.
	 * This is a generalized fuction and is as such available in all derivations of 4-dimensional tuples.
	 * @return The y value from the tuple.
	 */
	double getUniY();
	
	/**
	 * Returns the z value from the tuple.
	 * This is a generalized fuction and is as such available in all derivations of 4-dimensional tuples.
	 * @return The z value from the tuple.
	 */
	double getUniZ();
	
	/**
	 * Returns the w value from the tuple.
	 * This is a generalized fuction and is as such available in all derivations of 4-dimensional tuples.
	 * @return The w value from the tuple.
	 */
	double getUniW();
	
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
	 */
	@Override
	double getUni(int index);
	
	@Override
	default int getDimensions() { return 4; }
}