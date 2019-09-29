package org.barghos.math.vector;

import org.barghos.core.tuple.tuple3.api.ITup3fR;
import org.barghos.math.api.vector.IVec3fR;

public abstract class PVec3f implements IVec3fR
{
	
	public static PVec3f gen(ITup3fR t) { return gen(t.getX(), t.getY(), t.getZ()); }
	public static PVec3f gen(double scalar) { return gen(scalar, scalar, scalar); }
	public static PVec3f gen(double x, double y, double z)
	{
		return new PVec3f()
		{
			public float getX() { return (float)x; }
			public float getY() { return (float)y; }
			public float getZ() { return (float)z; }

			public int getDimensions() { return 3; }
			
			public float get(int index)
			{
				switch(index)
				{
					case 0: return getX();
					case 1: return getY();
					case 2: return getZ();
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
					default: throw new IllegalStateException();
				}
			}
		};
	}
	
}
