package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITupdR;
import org.barghos.core.api.tuple.ITupdW;

/**
 * This class is a simple implementation of a n-dimensional float tuple.
 */
public class Tupd implements ITupdR, ITupdW
{
	/**
	 * This array contains all the elements of the tuple.
	 */
	public double[] v;
	
	/**
	 * This constructor initializes the tuple for the given count of dimensions.
	 * @param dimensions The number of elements the tuple should have.
	 */
	public Tupd(int dimensions)
	{
		this.v = new double[dimensions];
	}
	
	/**
	 * This constructor initializes the tuple with a copy of the given elements.
	 * @param v The initial elements.
	 */
	public Tupd(double... v)
	{
		this(v.length);
		for(int i = 0; i < v.length; i++)
			this.v[i] = v[i];
	}
	
	
	
	public Tupd set(int index, double value) { this.v[index] = value; return this; }

	
	
	public double get(int index) { return this.v[index]; }

	
	
	public int getDimensions() { return v.length; }

}
