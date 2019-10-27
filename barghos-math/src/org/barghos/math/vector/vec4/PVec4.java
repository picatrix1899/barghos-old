package org.barghos.math.vector.vec4;

import org.barghos.core.tuple.tuple4.Tup4fR;

public abstract class PVec4 implements Vec4R
{
	
	public static PVec4 gen(Tup4fR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	public static PVec4 gen(float scalar) { return gen(scalar, scalar, scalar, scalar); }
	public static PVec4 gen(float x, float y, float z, float w)
	{
		return new PVec4()
		{
			public float getX() { return x; }
			public float getY() { return y; }
			public float getZ() { return z; }
			public float getW() { return w; }
		};
	}
	
}
