package org.barghos.math.point;

import org.barghos.core.api.tuple.ITup3fR;

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

			
			
			public int getDimensions() { return 3; }
			
		};
	}
	
}
