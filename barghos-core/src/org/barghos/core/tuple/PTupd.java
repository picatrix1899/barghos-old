package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITupdR;

/**
 * This class is a readonly implementation of a n-dimensional double tuple.
 */
public abstract class PTupd implements ITupdR
{

	/**
	 * This generate a readonly PTupd with the components set to values.
	 * @param values An array that the components are set to.
	 * @return A new readonly PTupf with the given components.
	 */
	public static PTupd gen(double... values)
	{
		double[] v = new double[values.length];
		
		for(int i = 0; i < values.length; i++)
			v[i] = values[i];
		
		return new PTupd()
		{
			
			public double get(int index) { return v[index]; }
			

			
			public int getDimensions() { return v.length; }

		};
	}
	
}
