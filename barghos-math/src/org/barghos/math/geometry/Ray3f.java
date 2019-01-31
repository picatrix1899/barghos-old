package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.math.vector.Vec3f;

public class Ray3f
{
	public final Vec3f d = new Vec3f();
	
	public Ray3f() { }
	public Ray3f(ITup3R t) { assert(t != null); set(t); }
	public Ray3f(Ray3f r) { assert(r != null); set(r); }
	public Ray3f(double x, double y, double z) { set(x, y, z); }
	
	public Ray3f set(ITup3R t) { assert(t != null); this.d.set(t); return this; }
	public Ray3f set(Ray3f r) { this.d.set(r.d); return this; }
	public Ray3f set(double x, double y, double z) { this.d.set(x, y, z); return this; }
	
	public Ray3f setX(double x) { this.d.setX(x); return this; }
	public Ray3f setY(double y) { this.d.setY(y); return this; }
	public Ray3f setZ(double z)  { this.d.setZ(z); return this; }
	
	public double getX() { return this.d.getX(); }
	public double getY() { return this.d.getY(); }
	public double getZ() { return this.d.getZ(); }
}
