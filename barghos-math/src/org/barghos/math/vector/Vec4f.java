package org.barghos.math.vector;

import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.api.tuple.ITup4fR;
import org.barghos.math.api.vector.IVec4fR;
import org.barghos.math.api.vector.IVec4W;

public class Vec4f implements IVec4fR, IVec4W
{
	
	public float x = 0.0f; 
	public float y = 0.0f;
	public float z = 0.0f;
	public float w = 0.0f;
	
	
	
	public Vec4f() { set(0); }
	public Vec4f(ITup4R t) { set(t); }
	public Vec4f(double scalar) { set(scalar); }
	public Vec4f(double x, double y, double z, double w) { set(x, y, z, w); }

	public Vec4f setX(double x) { this.x = (float)x; return this; }
	public Vec4f setY(double y) { this.y = (float)y; return this; }
	public Vec4f setZ(double z) { this.z = (float)z; return this; }
	public Vec4f setW(double w) { this.w = (float)w; return this; }
	
	public Vec4f set(ITup4R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	public Vec4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	public Vec4f set(double x, double y, double z, double w) { return setX(x).setY(y).setZ(z).setW(w); }
	
	public Vec4f set(int index, double value) { IVec4W.super.set(index, value); return this; }
	
	
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	public float getW() { return this.w; }

	public int getDimensions() { return 4; }
	
	/*
	#######################
	#  BASIC-ARITHMETICS  #
	#######################
	*/
	
	public static Vec4f add(ITup4fR v1, ITup4fR v2, Vec4f res)
	{
		return add(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), v2, res);
	}
	
	public static Vec4f add(ITup4fR v1, double scalar, Vec4f res)
	{
		return add(v1, scalar, scalar, scalar, scalar, res);
	}
	
	public static Vec4f add(ITup4fR v1, double x, double y, double z, double w, Vec4f res)
	{
		return add(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), x, y, z, w, res);
	}
	
	public static Vec4f add(double scalar, ITup4fR v2, Vec4f res)
	{
		return add(scalar, scalar, scalar, scalar, v2, res);
	}
	
	public static Vec4f add(double x, double y, double z, double w, ITup4fR v2, Vec4f res)
	{
		return add(x, y, z, w, v2.getX(), v2.getY(), v2.getZ(), v2.getW(), res);
	}
	
	public static Vec4f add(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		return res != null ? res.set(x1 + x2, y1 + y2, z1 + z2, w1 + w2) : new Vec4f(x1 + x2, y1 + y2, z1 + z2, w1 + w2);
	}
	

	public static Vec4f sub(ITup4fR v1, ITup4fR v2, Vec4f res)
	{
		return sub(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), v2, res);
	}
	
	public static Vec4f sub(ITup4fR v1, double scalar, Vec4f res)
	{
		return sub(v1, scalar, scalar, scalar, scalar, res);
	}
	
	public static Vec4f sub(double scalar, ITup4fR v2, Vec4f res)
	{
		return sub(scalar, scalar, scalar, scalar, v2, res);
	}
	
	public static Vec4f sub(ITup4fR v1, double x, double y, double z, double w, Vec4f res)
	{
		return sub(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), x, y, z, w, res);
	}
	
	public static Vec4f sub(double x, double y, double z, double w, ITup4fR v2, Vec4f res)
	{
		return sub(x, y, z, w, v2.getX(), v2.getY(), v2.getZ(), v2.getW(), res);
	}
	
	public static Vec4f sub(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		return res != null ? res.set(x1 - x2, y1 - y2, z1 - z2, w1 - w2) : new Vec4f(x1 - x2, y1 - y2, z1 - z2, w1 - w2);
	}
	
	
	public static Vec4f mul(ITup4fR v1, ITup4fR v2, Vec4f res)
	{
		return mul(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), v2, res);
	}
	
	public static Vec4f mul(ITup4fR v1, double scalar, Vec4f res)
	{
		return mul(v1, scalar, scalar, scalar, scalar, res);
	}
	
	public static Vec4f mul(double scalar, ITup4fR v2, Vec4f res)
	{
		return mul(scalar, scalar, scalar, scalar, v2, res);
	}
	
	public static Vec4f mul(ITup4fR v1, double x, double y, double z, double w, Vec4f res)
	{
		return mul(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), x, y, z, w, res);
	}
	
	public static Vec4f mul(double x, double y, double z, double w, ITup4fR v2, Vec4f res)
	{
		return mul(x, y, z, w, v2.getX(), v2.getY(), v2.getZ(), v2.getW(), res);
	}
	
	public static Vec4f mul(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		return res != null ? res.set(x1 * x2, y1 * y2, z1 * z2, w1 * w2) : new Vec4f(x1 * x2, y1 * y2, z1 * z2, w1 * w2);
	}
	
	
	public static Vec4f div(ITup4fR v1, ITup4fR v2, Vec4f res)
	{
		return div(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), v2, res);
	}
	
	public static Vec4f div(ITup4fR v1, double scalar, Vec4f res)
	{
		return div(v1, scalar, scalar, scalar, scalar, res);
	}
	
	public static Vec4f div(double scalar, ITup4fR v2, Vec4f res)
	{
		return div(scalar, scalar, scalar, scalar, v2, res);
	}
	
	public static Vec4f div(ITup4fR v1, double x, double y, double z, double w, Vec4f res)
	{
		return div(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), x, y, z, w, res);
	}
	
	public static Vec4f div(double x, double y, double z, double w, ITup4fR v2, Vec4f res)
	{
		return div(x, y, z, w, v2.getX(), v2.getY(), v2.getZ(), v2.getW(), res);
	}
	
	public static Vec4f div(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		return res != null ? res.set(x1 / x2, y1 / y2, z1 / z2, w1 / w2) : new Vec4f(x1 / x2, y1 / y2, z1 / z2, w1 / w2);
	}
	
	
	public static double dot(ITup4fR v1, ITup4fR v2)
	{
		return dot(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), v2);
	}
	
	public static double dot(ITup4fR v1, double x2, double y2, double z2, double w2)
	{
		return dot(v1.getX(), v1.getY(), v1.getZ(), v1.getW(), x2, y2, z2, w2);
	}
	
	public static double dot(double x1, double y1, double z1, double w1, ITup4fR v2)
	{
		return dot(x1, y1, z1, w1, v2.getX(), v2.getY(), v2.getZ(), v2.getW());
	}
	
	public static double dot(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2)
	{
		return x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2;
	}
	
	public static double inverseLength(ITup4fR v)
	{
		return inverseLength(v.getX(), v.getY(), v.getZ(), v.getW());
	}
	
	public static double inverseLength(double x, double y, double z, double w)
	{
		return 1.0d / length(x, y, z, w);
	}
	
	public static double length(ITup4fR v)
	{
		return length(v.getX(), v.getY(), v.getZ(), v.getW());
	}
	
	public static double length(double x, double y, double z, double w)
	{
		return Math.sqrt(squaredLength(x, y, z, w));
	}
	
	public static double squaredLength(ITup4fR v)
	{
		return squaredLength(v.getX(), v.getY(), v.getZ(), v.getW());
	}
	
	public static double squaredLength(double x, double y, double z, double w)
	{
		return x * x + y * y + z * z + w * w;
	}
	
	public static Vec4f normalize(ITup4fR v, Vec4f res)
	{
		return normalize(v.getX(), v.getY(), v.getZ(), v.getW(), res);
	}
	
	public static Vec4f normalize(double x, double y, double z, double w, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		float invLength = (float)inverseLength(x, y, z, w);
		return res.set(x * invLength, y * invLength, z * invLength, w * invLength);
	}
	
	public static Vec4f invert(ITup4fR v, Vec4f res)
	{
		return invert(v.getX(), v.getY(), v.getZ(), v.getW(), res);
	}
	
	public static Vec4f invert(double x, double y, double z, double w, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(-x, -y, -z, -w);
	}
}
