package org.barghos.math.vector;

import org.barghos.core.tuple.tuple2.api.ITup2fR;
import org.barghos.math.api.vector.IVec2fR;

public abstract class PVec2f implements IVec2fR
{
	
	public static PVec2f gen(ITup2fR t) { return gen(t.getX(), t.getY()); }
	public static PVec2f gen(double scalar) { return gen(scalar, scalar); }
	public static PVec2f gen(double x, double y)
	{
		return new PVec2f()
		{
			public float getX() { return (float)x; }
			public float getY() { return (float)y; }

			public double getUniX() { return (float)x; }
			public double getUniY() { return (float)y; }
			
			public int getDimensions() { return 2; }
			
			public float get(int index)
			{
				switch(index)
				{
					case 0: return getX();
					case 1: return getY();
					default: throw new IllegalStateException();
				}
			}
			public double getUni(int index)
			{
				switch(index)
				{
					case 0: return getX();
					case 1: return getY();
					default: throw new IllegalStateException();
				}
			}
		};
	}
	
}
