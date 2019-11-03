package org.barghos.math.vector.vec3;

import org.barghos.core.tuple.tuple3.Tup3fR;

public abstract class PVec3 implements Vec3R
{
	
	public static PVec3 gen(Tup3fR t) { return gen(t.getX(), t.getY(), t.getZ()); }
	public static PVec3 gen(float scalar) { return gen(scalar, scalar, scalar); }
	public static PVec3 gen(float x, float y, float z)
	{
		return new PVec3()
		{
			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
		};
	}
	
}
