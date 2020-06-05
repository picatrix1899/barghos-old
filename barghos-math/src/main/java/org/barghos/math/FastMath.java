package org.barghos.math;

public class FastMath
{

	public static double STEP = 0.00001;
	private static double[] sin_table;
	
	static
	{
		sin_table = new double[(int)(90 / STEP)];
		
		for(int d = 0; d < (int)(90 / STEP); d++)
		{
			sin_table[d] = Math.sin(d * STEP * Maths.DEG_TO_RAD);
		}
	}
	
	public static double sinDeg(double deg)
	{
		deg = deg % 360;
		deg = deg > 0 ? deg : 360 - deg;
		
		int phase = (int)(deg / 90);
		int sign = phase < 2 ? 1 : -1;
		boolean invert = phase == 1 || phase == 3;
		
		deg = deg % 90;
		
		deg = invert ? 90.0 - deg : deg;
		
		double recStep = 1 / STEP;
		
		double r = deg % STEP;
		
		
		if(r == 0)
		{
			return sign * sin_table[(int)(deg * recStep)];
		}
		else
		{
			int index1 = (int)((deg - r) * recStep);
			int index2 = index1 + 1;

			double val1 = sin_table[index1];
			double val2 = sin_table[index2];
			
			double rest = r * recStep;
			
			return sign * (val1 * (1 - rest) + val2 * rest);
		}
	}
}
