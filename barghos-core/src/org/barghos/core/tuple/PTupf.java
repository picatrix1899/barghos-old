package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITupfR;

/**
 * This class is a readonly implementation of a n-dimensional float tuple.
 */
public abstract class PTupf implements ITupfR
{

	/**
	 * This generate a readonly PTupf with the components set to values.
	 * @param values An array that the components are set to.
	 * @return A new readonly PTupf with the given components.
	 */
	public static PTupf gen(double... values)
	{
		float[] v = new float[values.length];
		
		for(int i = 0; i < values.length; i++)
			v[i] = (float)values[i];
		
		return new PTupf()
		{
			
			public float get(int index) { return v[index]; }
			

			
			public int getDimensions() { return v.length; }

		};
	}
	
}
