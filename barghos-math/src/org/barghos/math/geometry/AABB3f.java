package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;
import org.barghos.math.vector.Vec3fPool;

public class AABB3f implements FiniteGeometricObject
{
	private float cX, cY, cZ;
	private float heX, heY, heZ;
	private boolean isPointsDirty;
	private Point3f[] points = new Point3f[8];
	
	public AABB3f() { }
	public AABB3f(ITup3R center, ITup3R halfExtend)
	{
		assert(center != null);
		assert(halfExtend != null);
		set(center, halfExtend);
	}
	
	public AABB3f(double cX, double cY, double cZ, double heX, double heY, double heZ)
	{
		set(cX, cY, cZ, heX, heY, heZ);
	}
	
	public AABB3f set(ITup3R center, ITup3R halfExtend)
	{
		assert(center != null);
		assert(halfExtend != null);
		return setCenter(center).setHalfExtend(halfExtend);
	}
	
	public AABB3f set(double cX, double cY, double cZ, double heX, double heY, double heZ)
	{
		return setCenter(cX, cY, cZ).setHalfExtend(heX, heY, heZ);
	}
	
	public AABB3f setHalfExtend(ITup3R t)
	{
		assert(t != null);
		return setHalfExtend(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public AABB3f setHalfExtend(double x, double y, double z) { return setHalfExtendX(x).setHalfExtendY(y).setHalfExtendZ(z); }
	
	public AABB3f setHalfExtendX(double x) { this.heX = (float)x; this.isPointsDirty = true; return this; }
	
	public AABB3f setHalfExtendY(double y) { this.heY = (float)y; this.isPointsDirty = true; return this; }
	
	public AABB3f setHalfExtendZ(double z) { this.heZ = (float)z; this.isPointsDirty = true; return this; }
	
	
	public AABB3f setCenter(ITup3R t)
	{
		assert(t != null);
		return setCenter(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public AABB3f setCenter(double x, double y, double z) { return setCenterX(x).setCenterY(y).setCenterZ(z); }
	
	public AABB3f setCenterX(double x) { this.cX = (float)x; this.isPointsDirty = true; return this; }
	
	public AABB3f setCenterY(double y) { this.cY = (float)y; this.isPointsDirty = true; return this; }
	
	public AABB3f setCenterZ(double z) { this.cZ = (float)z; this.isPointsDirty = true; return this; }
	
	public Point3f getCenter(Point3f res)
	{
		res = res != null ? res : new Point3f();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Point3f getCenter()
	{
		return new Point3f(this.cX, this.cY, this.cZ);
	}
	
	public Vec3f getCenter(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Vec3f getHalfExtend()
	{
		return new Vec3f(this.heX, this.heY, this.heZ);
	}
	
	public Vec3f getHalfExtend(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(this.heX, this.heY, this.heZ);
	}
	
	public Point3f getMin()
	{
		return new Point3f(this.cX - this.heX, this.cY - this.heY, this.cZ - this.heZ);
	}
	
	public Point3f getMax()
	{
		return new Point3f(this.cX + this.heX, this.cY + this.heY, this.cZ + this.heZ);
	}
	
	@Override
	public Point3f[] getPoints()
	{
		if(this.isPointsDirty)
		{
			Vec3f c = Vec3fPool.get(this.cX, this.cY, this.cZ);

			Vec3f v = Vec3fPool.get(this.heX, this.heY, this.heZ);

			Vec3f t1 = Vec3fPool.get(v);
			Vec3f t2 = Vec3fPool.get(-v.getUniX(), v.getUniY(), v.getUniZ());
			Vec3f t3 = Vec3fPool.get(-v.getUniX(), -v.getUniY(), v.getUniZ());
			Vec3f t4 = Vec3fPool.get(v.getUniX(), -v.getUniY(), v.getUniZ());

			Vec3f r = Vec3fPool.get();
			
			this.points[0] = new Point3f(c.add(t1, r));
			this.points[1] = new Point3f(c.add(t2, r));
			this.points[2] = new Point3f(c.add(t3, r));
			this.points[3] = new Point3f(c.add(t4, r));
			
			this.points[4] = new Point3f(c.sub(t1, r));
			this.points[5] = new Point3f(c.sub(t2, r));
			this.points[6] = new Point3f(c.sub(t3, r));
			this.points[7] = new Point3f(c.sub(t4, r));
			
			Vec3fPool.store(c, v, t1, t2, t3, t4, r);
			
			this.isPointsDirty = false;
			
		}
		return this.points;
	}

	public AABB3f transform(Mat4f t, AABB3f res)
	{
		assert(t != null);
		assert(!t.isZeroMatrix());
		res = res != null ? res : new AABB3f();
		
		Vec3f min = Vec3f.sub(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, Vec3fPool.get());
		Vec3f max = Vec3f.add(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, Vec3fPool.get());
		
		t.transform(min, min);
		t.transform(max, max);
		
		Vec3f halfExtend = max.sub(min, max).mul(0.5, null);
		Vec3f center = min.add(halfExtend, null);
		
		Vec3fPool.store(min, max);
		
		return res.set(center, halfExtend);
	}
	
	public OBB3f getOBB()
	{
		return new OBB3f(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, Mat4f.identity());
	}
	
	public OBB3f getOBB(OBB3f res)
	{
		res = res != null ? res : new OBB3f();
		return res.set(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, Mat4f.identity());
	}
	
	public OBB3f getOBB(Mat4f rotation)
	{
		assert(rotation != null);
		assert(!rotation.isZeroMatrix());
		return new OBB3f(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, rotation);
	}

	public OBB3f getOBB(Mat4f rotation, OBB3f res)
	{
		assert(rotation != null);
		assert(!rotation.isZeroMatrix());
		res = res != null ? res : new OBB3f();
		return res.set(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, rotation);
	}
	
	public String toString()
	{
		return "aabb3f(center: " + new Vec3f(this.cX, this.cY, this.cZ) + ", halfExtend: " + new Vec3f(this.heX, this.heY, this.heZ) + ")";
	}
}