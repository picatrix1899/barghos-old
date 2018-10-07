package org.barghos.math.vector;

import org.barghos.core.api.tuple.ITup2fR;

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

			public int getDimensions() { return 2; }
		};
	}
	
}
