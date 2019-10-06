package org.barghos.math.vector.vec3;

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.math.vector.vec3.api.IVec3dR;

public abstract class PVec3d implements IVec3dR
{
	
	public static PVec3d gen(ITup3R t) { return gen(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public static PVec3d gen(double scalar) { return gen(scalar, scalar, scalar); }
	public static PVec3d gen(double x, double y, double z)
	{
		return new PVec3d()
		{
			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
		};
	}
	
}
