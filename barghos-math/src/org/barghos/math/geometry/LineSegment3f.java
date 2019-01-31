package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3fR;

import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;

public class LineSegment3f
{
	public final Point3f p = new Point3f();
	public final Vec3f d = new Vec3f();
	
	public LineSegment3f() { }
	
	public LineSegment3f(ITup3fR p, ITup3fR d) { assert(p != null); assert(d != null); set(p, d); }
	public LineSegment3f(ITup3fR p, double dx, double dy, double dz) { assert(p != null); set(p, dx, dy, dz); }
	public LineSegment3f(double px, double py, double pz, ITup3fR d) { assert(d != null); set(px, py, pz, d); }
	public LineSegment3f(double px, double py, double pz, double dx, double dy, double dz) { set(px, py, pz, dx, dy, dz); }
	
	public LineSegment3f set(ITup3fR p, ITup3fR d) { assert(p != null); assert(d != null); return setP(p).setD(d); }
	public LineSegment3f set(ITup3fR p, double dx, double dy, double dz) { assert(p != null); return setP(p).setD(dx, dy, dz); }
	public LineSegment3f set(double px, double py, double pz, ITup3fR d) { assert(d != null); return setP(px, py, pz).setD(d); }
	public LineSegment3f set(double px, double py, double pz, double dx, double dy, double dz) { assert(d != null); return setP(px, py, pz).setD(dx, dy, dz); }
	
	public LineSegment3f setP(ITup3fR p) { assert(this.p != null); this.p.set(p); return this; }
	public LineSegment3f setP(double x, double y, double z) { this.p.set(x, y, z); return this; }
	
	public LineSegment3f setD(ITup3fR d) { assert(d != null); this.d.set(d); return this; }
	public LineSegment3f setD(double x, double y, double z) { this.d.set(x, y, z); return this; }
	
}
