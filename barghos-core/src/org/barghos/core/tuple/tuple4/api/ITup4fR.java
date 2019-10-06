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

import org.barghos.core.OverrideCause;
import org.barghos.core.tuple.tuplen.api.ITupfR;

/**
 * @author picatrix1899
 *
 * This interface represents a readonly version of a 4-dimensional float tuple.
 */
public interface ITup4fR extends ITup4R, ITupfR
{
	/**
	 * Returns the x value from the tuple.
	 * @return The x value from the tuple.
	 */
	float getX();
	
	/**
	 * Returns the y value from the tuple.
	 * @return The y value from the tuple.
	 */
	float getY();
	
	/**
	 * Returns the z value from the tuple.
	 * @return The z value from the tuple.
	 */
	float getZ();
	
	/**
	 * Returns the w value from the tuple.
	 * @return The w value from the tuple.
	 */
	float getW();
	
	@Override
	default double getUniX() { return getX(); }
	
	@Override
	default double getUniY() { return getY(); }
	
	@Override
	default double getUniZ() { return getZ(); }
	
	@Override
	default double getUniW() { return getW(); }
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 3.
	 */
	@Override
	default float get(int index)
	{
		if(index < 0 || index > 3) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: 3");

		switch(index)
		{
			case 0: getX();
			case 1: getY();
			case 2: getZ();
			case 3: getW();
			default: throw new IllegalStateException();
		}
	}
	
	@Override
	default boolean isFinite()
	{
		return Float.isFinite(getX()) && Float.isFinite(getY()) && Float.isFinite(getZ()) && Float.isFinite(getW());
	}
	
	@Override
	@OverrideCause("ITup4R and ITupfR both have default implementations of getUni(int index).")
	default double getUni(int index) { return ITup4R.super.getUni(index); }

	default boolean isZero(double tolerance) { return ITup4R.super.isZero(tolerance); }
}
