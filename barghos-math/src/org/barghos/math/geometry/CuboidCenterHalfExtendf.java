package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.math.api.point.IPoint3fR;
import org.barghos.math.api.vector.IVec3fR;
import org.barghos.math.point.Point3f;
import org.barghos.math.pool.Vec3fPool;
import org.barghos.math.vector.Vec3f;

public class CuboidCenterHalfExtendf
{
	public final Point3f center = new Point3f();
	public final Vec3f halfExtend = new Vec3f(); 
	
	public CuboidCenterHalfExtendf() { }
	public CuboidCenterHalfExtendf(IPoint3fR center, IVec3fR halfExtend) { assert(center != null); assert(halfExtend != null); set(center, halfExtend); }
	public CuboidCenterHalfExtendf(IPoint3fR center, double hex, double hey, double hez) { assert(center != null); set(center, hex, hey, hez); }
	public CuboidCenterHalfExtendf(double cx, double cy, double cz, IVec3fR halfExtend) { assert(halfExtend != null); set(cx, cy, cz, halfExtend); }
	public CuboidCenterHalfExtendf(double cx, double cy, double cz, double hex, double hey, double hez) { set(cx, cy, cz, hex, hey, hez); }
	
	public CuboidCenterHalfExtendf set(IPoint3fR center, IVec3fR halfExtend) { assert(center != null); assert(halfExtend != null); return setCenter(center).setHalfExtend(halfExtend); }
	public CuboidCenterHalfExtendf set(IPoint3fR center, double hex, double hey, double hez) { assert(center != null); return setCenter(center).setHalfExtend(hex, hey, hez); }
	public CuboidCenterHalfExtendf set(double cx, double cy, double cz, IVec3fR halfExtend) { assert(halfExtend != null); return setCenter(cx, cy, cz).setHalfExtend(halfExtend); };
	public CuboidCenterHalfExtendf set(double cx, double cy, double cz, double hex, double hey, double hez) { return setCenter(cx, cy, cz).setHalfExtend(hex, hey, hez); }
	
	public CuboidCenterHalfExtendf setCenter(ITup3fR center) { assert(center != null); assert(center != null); this.center.set(center); return this; }
	public CuboidCenterHalfExtendf setCenter(double x, double y, double z) { this.center.set(x, y, z); return this; }
	
	public CuboidCenterHalfExtendf setHalfExtend(ITup3fR halfExtend) { assert(halfExtend != null); assert(halfExtend != null); this.halfExtend.set(halfExtend); return this; }
	public CuboidCenterHalfExtendf setHalfExtend(double x, double y, double z) { this.halfExtend.set(x, y, z); return this; }
	
	public float getCenterX() { return this.center.getX(); }
	public float getCenterY() { return this.center.getY(); }
	public float getCenterZ() { return this.center.getZ(); }
	
	public float getHalfExtendX() { return this.halfExtend.getX(); }
	public float getHalfExtendY() { return this.halfExtend.getY(); }
	public float getHalfExtendZ() { return this.halfExtend.getZ(); }
	
	public Point3f getCenter(Point3f res)
	{
		res = res != null ? res : new Point3f();
		res.set(this.center);
		return res;
	}
	
	public Point3f getCenter()
	{
		return new Point3f(this.center);
	}
	
	public Vec3f getHalfExtend(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		res.set(this.halfExtend);
		return res;
	}
	
	public Vec3f getHalfExtend()
	{
		return new Vec3f(this.halfExtend);
	}
	
	public Point3f getMin(Point3f res)
	{
		res = res != null ? res : new Point3f();
		Vec3f t = Vec3fPool.get();
		res.set(Vec3f.sub(this.center, this.halfExtend, t));
		Vec3fPool.store(t);
		return res;
	}
	
	public Point3f getMin()
	{
		Point3f res = new Point3f();
		Vec3f t = Vec3fPool.get();
		res.set(Vec3f.sub(this.center, this.halfExtend, t));
		Vec3fPool.store(t);
		return res;
	}
	
	public Point3f getMax(Point3f res)
	{
		res = res != null ? res : new Point3f();
		Vec3f t = Vec3fPool.get();
		res.set(Vec3f.add(this.center, this.halfExtend, t));
		Vec3fPool.store(t);
		return res;
	}
	
	public Point3f getMax()
	{
		Point3f res = new Point3f();
		Vec3f t = Vec3fPool.get();
		res.set(Vec3f.add(this.center, this.halfExtend, t));
		Vec3fPool.store(t);
		return res;
	}
}
