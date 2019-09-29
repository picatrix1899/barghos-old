package org.barghos.math.vector;

import org.barghos.core.tuple.tuple4.api.ITup4fR;
import org.barghos.math.api.vector.IVec4fR;

public abstract class PVec4f implements IVec4fR
{
	
	public static PVec4f gen(ITup4fR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	public static PVec4f gen(double scalar) { return gen(scalar, scalar, scalar, scalar); }
	public static PVec4f gen(double x, double y, double z, double w)
	{
		return new PVec4f()
		{

			public float getX() { return (float)x; }
			public float getY() { return (float)y; }
			public float getZ() { return (float)z; }
			public float getW() { return (float)w; }

			public int getDimensions() { return 4; }
			
			public float get(int index)
			{
				switch(index)
				{
					case 0: return getX();
					case 1: return getY();
					case 2: return getZ();
					case 3: return getW();
					default: throw new IllegalStateException();
				}
			}
			public double getUni(int index)
			{
				switch(index)
				{
					case 0: return getX();
					case 1: return getY();
					case 2: return getZ();
					case 3: return getW();
					default: throw new IllegalStateException();
				}
			}
		};
	}
	
}
