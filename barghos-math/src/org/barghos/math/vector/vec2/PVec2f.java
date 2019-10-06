package org.barghos.math.vector.vec2;

import org.barghos.core.tuple.tuple2.api.ITup2fR;
import org.barghos.math.vector.vec2.api.IVec2fR;

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
		};
	}
	
}
