package org.barghos.math.experimental.vector.vec2;

import org.barghos.core.tuple.tuple2.Tup2fR;

public abstract class PVec2 implements Vec2R
{
	
	public static PVec2 gen(Tup2fR t) { return gen(t.getX(), t.getY()); }
	public static PVec2 gen(float scalar) { return gen(scalar, scalar); }
	public static PVec2 gen(float x, float y)
	{
		return new PVec2()
		{
			public float getX() { return x; }
			public float getY() { return y; }
		};
	}
	
}
