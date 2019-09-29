package org.barghos.math.geometry;

import org.barghos.core.tuple.tuple3.api.ITup3R;

public class Ray3f implements ITup3R, InfiniteGeometricObject
{
	public float x, y, z;

	public Ray3f() { }
	public Ray3f(Ray3f r) { assert(r != null); set(r); }
	public Ray3f(ITup3R t) { assert(t != null); set(t); }
	public Ray3f(double x, double y, double z) { set(x, y, z); }
	
	public Ray3f set(Ray3f r) { assert( r != null); return set(r.getX(), r.getY(), r.getZ()); }
	public Ray3f set(ITup3R t) { assert(t != null); return set(t.getUniX(), t.getUniY(),t.getUniZ()); }

	public Ray3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }
	
	public Ray3f setX(double x) { this.x = (float)x; return this; }
	public Ray3f setY(double y) { this.y = (float)y; return this; }
	public Ray3f setZ(double z) { this.z = (float)z; return this; }
	
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public double getZ() { return this.z; }
	
	@Override
	public double getUniX(){ return this.x; }
	
	@Override
	public double getUniY() { return this.y; }
	
	@Override
	public double getUniZ() { return this.z; }
	
	public double getUni(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			default: throw new IllegalStateException();
		}
	}
}
