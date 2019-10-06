package org.barghos.math.vector.vec3;

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.math.vector.vec3.api.IVec3fR;

public abstract class PVec3f implements IVec3fR
{
	
	public static PVec3f gen(ITup3R t) { return gen(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public static PVec3f gen(double scalar) { return gen(scalar, scalar, scalar); }
	public static PVec3f gen(double x, double y, double z)
	{
		return new PVec3f()
		{
			public float getX() { return (float)x; }
			public float getY() { return (float)y; }
			public float getZ() { return (float)z; }
		};
	}
	
}
