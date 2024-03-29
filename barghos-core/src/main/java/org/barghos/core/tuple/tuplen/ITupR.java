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

/**
 * @author picatrix1899
 *
 * This interface represents a readonly version of a unspecialized n-dimensional immutable tuple.
 */
public interface ITupR
{
	/**
	 * Returns the value from the tuple at the given index.
	 * This is a generalized fuction and is as such available in all derivations of tuples.
	 * @param index The index of the value to return.
	 * @return The value from the tuple at the given index.
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than the tuples' size - 1.
	 */
	double getUni(int index);
	
	
	/**
	 * Returns the dimension or value count of the tuple.
	 * This is often used together with the {@link #getUni(int)} function.
	 * @return The dimension or value count of the tuple.
	 */
	int getDimensions();
	
	/**
	 * Returns true if all values of the tuple are finite values.
	 * @return True if all values of the tuple are finite values.
	 */
	boolean isFinite();
	
	/**
	 * Checks if all values of the tuple are zero.
	 * @return Are all values zero.
	 */
	default boolean isZero() { return isZero(0.0); }
	
	/**
	 * Checks if all values of the tuple are within a tolerance around zero.
	 * @param tolerance The threshold around 0.
	 * @return Are all values within the tolerance around zero.
	 */
	boolean isZero(double tolerance);
	

}
