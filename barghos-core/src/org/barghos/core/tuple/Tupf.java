package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITupfR;
import org.barghos.core.api.tuple.ITupfW;

/**
 * This class is a simple implementation of a n-dimensional float tuple.
 */
public class Tupf implements ITupfR, ITupfW
{
	/**
	 * This array contains all the elements of the tuple.
	 */
	public float[] v;
	
	/**
	 * This constructor initializes the tuple for the given count of dimensions.
	 * @param dimensions The number of elements the tuple should have.
	 */
	public Tupf(int dimensions)
	{
		this.v = new float[dimensions];
	}
	
	/**
	 * This constructor initializes the tuple with a copy of the given elements.
	 * @param v The initial elements.
	 */
	public Tupf(double... v)
	{
		this(v.length);
		for(int i = 0; i < v.length; i++)
			this.v[i] = (float)v[i];
	}
	
	
	
	public Tupf set(int index, double value) { this.v[index] = (float)value; return this; }

	
	
	public float get(int index) { return this.v[index]; }

	
	
	public int getDimensions() { return v.length; }

}
