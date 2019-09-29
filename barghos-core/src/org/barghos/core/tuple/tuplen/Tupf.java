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

import org.barghos.core.tuple.tuplen.api.ITupf;

/**
 * This class represents a n-dimensional immutable float tuple.
 */
public class Tupf implements ITupf
{
	/**
	 * This array contains all values of the tuple.
	 */
	protected float[] v;
	
	
	/**
	 * This constructor initializes the tuple for the given amount of dimensions.
	 * @param dimensions The number of values the tuple should have.
	 */
	public Tupf(int dimensions)
	{
		this.v = new float[dimensions];
	}
	
	/**
	 * This constructor initializes the tuple with a copy of the given values.
	 * @param v The initial values.
	 */
	public Tupf(double... v)
	{
		this(v.length);
		for(int i = 0; i < v.length; i++)
			this.v[i] = (float)v[i];
	}
	
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than the tuples' size - 1.
	 */
	@Override
	public double getUni(int index)
	{
		if(index < 0 || index >= v.length) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: " + (v.length - 1));
		
		return this.v[index];
	}
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than the tuples' size - 1.
	 */
	@Override
	public float get(int index)
	{
		if(index < 0 || index >= v.length) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: " + (v.length - 1));
		
		return this.v[index];
	}
	
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than the tuples' size - 1.
	 */
	@Override
	public Tupf set(int index, double value)
	{
		if(index < 0 || index >= v.length) throw new IndexOutOfBoundsException("index: " + index + "; min: 0; max: " + (v.length - 1));
		
		this.v[index] = (float)value;
		return this;
	}


	@Override
	public int getDimensions() { return v.length; }
}
