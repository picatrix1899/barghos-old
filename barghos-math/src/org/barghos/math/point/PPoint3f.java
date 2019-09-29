package org.barghos.math.point;

import org.barghos.core.tuple.tuple3.api.ITup3fR;
import org.barghos.math.api.point.IPoint3fR;


public abstract class PPoint3f implements IPoint3fR
{

	public static PPoint3f gen(ITup3fR t) { return gen(t.getX(), t.getY(), t.getZ()); }
	public static PPoint3f gen(float scalar) { return gen(scalar, scalar, scalar); }
	public static PPoint3f gen(float x, float y, float z)
	{
		return new PPoint3f()
		{

			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }

			public double getUniX() { return x; }
			public double getUniY() { return y; }
			public double getUniZ() { return z; }
			
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
