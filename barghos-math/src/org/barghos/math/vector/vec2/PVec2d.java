package org.barghos.math.vector.vec2;

import org.barghos.core.tuple.tuple2.api.ITup2dR;
import org.barghos.math.vector.vec2.api.IVec2dR;

public abstract class PVec2d implements IVec2dR
{
	
	public static PVec2d gen(ITup2dR t) { return gen(t.getX(), t.getY()); }
	public static PVec2d gen(double scalar) { return gen(scalar, scalar); }
	public static PVec2d gen(double x, double y)
	{
		return new PVec2d()
		{
			public double getX() { return x; }
			public double getY() { return y; }
		};
	}
	
}
