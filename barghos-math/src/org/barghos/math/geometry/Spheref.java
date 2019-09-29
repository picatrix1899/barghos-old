package org.barghos.math.geometry;

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.math.point.Point3f;

public class Spheref implements InfiniteGeometricObject
{
	public final Point3f center = new Point3f();
	public float radius;

	public Spheref() { }
	public Spheref(ITup3R center, double radius) { assert(center != null); }
	public Spheref(Spheref sphere) { assert(sphere != null); }
	public Spheref(double cx, double cy, double cz, double radius) {  }
	
	public float getCenterX() { return this.center.getX(); }
	public float getCenterY() { return this.center.getY(); }
	public float getCenterZ() { return this.center.getZ(); }
	public float getRadius() { return this.radius; }
	public Point3f getCenter(Point3f res)
	{
		res = res != null ? res : new Point3f();
		res.set(this.center);
		return res;
	}

	public Spheref set(Spheref s) { return set(s.center, s.radius); }
	public Spheref set(ITup3R center, double radius) { return setCenter(center).setRadius(radius); }
	public Spheref set(double cx, double cy, double cz, double radius) { return setCenter(cx, cy, cz).setRadius(radius); }
	public Spheref setCenter(ITup3R t) { this.center.set(t); return this; }
	public Spheref setCenter(double x, double y, double z) { this.center.set(x, y, z); return this; }
	public Spheref setCenterX(double x) { this.center.setX(x); return this; }
	public Spheref setCenterY(double y) { this.center.setY(y); return this; }
	public Spheref setCenterZ(double z) { this.center.setZ(z); return this; }
	public Spheref setRadius(double r) { this.radius = (float)r; return this; }

}
