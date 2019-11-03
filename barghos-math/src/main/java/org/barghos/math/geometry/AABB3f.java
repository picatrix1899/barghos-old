package org.barghos.math.geometry;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.vec3.Vec3;
import org.barghos.math.vector.vec3.Vec3Pool;
import org.barghos.math.vector.vec3.Vec3R;

public class AABB3f implements FiniteGeometricObject
{
	private float cX, cY, cZ;
	private float heX, heY, heZ;
	private boolean isPointsDirty;
	private Point3[] points = new Point3[8];
	
	public AABB3f() { }
	public AABB3f(Vec3R center, Vec3R halfExtend)
	{
		assert(center != null);
		assert(halfExtend != null);
		set(center, halfExtend);
	}
	
	public AABB3f(double cX, double cY, double cZ, double heX, double heY, double heZ)
	{
		set(cX, cY, cZ, heX, heY, heZ);
	}
	
	public AABB3f set(Vec3R center, Vec3R halfExtend)
	{
		assert(center != null);
		assert(halfExtend != null);
		return setCenter(center).setHalfExtend(halfExtend);
	}
	
	public AABB3f set(double cX, double cY, double cZ, double heX, double heY, double heZ)
	{
		return setCenter(cX, cY, cZ).setHalfExtend(heX, heY, heZ);
	}
	
	public AABB3f setHalfExtend(Vec3R t)
	{
		assert(t != null);
		return setHalfExtend(t.getX(), t.getY(), t.getZ());
	}
	
	public AABB3f setHalfExtend(double x, double y, double z) { return setHalfExtendX(x).setHalfExtendY(y).setHalfExtendZ(z); }
	
	public AABB3f setHalfExtendX(double x) { this.heX = (float)x; this.isPointsDirty = true; return this; }
	
	public AABB3f setHalfExtendY(double y) { this.heY = (float)y; this.isPointsDirty = true; return this; }
	
	public AABB3f setHalfExtendZ(double z) { this.heZ = (float)z; this.isPointsDirty = true; return this; }
	
	
	public AABB3f setCenter(Vec3R t)
	{
		assert(t != null);
		return setCenter(t.getX(), t.getY(), t.getZ());
	}
	
	public AABB3f setCenter(double x, double y, double z) { return setCenterX(x).setCenterY(y).setCenterZ(z); }
	
	public AABB3f setCenterX(double x) { this.cX = (float)x; this.isPointsDirty = true; return this; }
	
	public AABB3f setCenterY(double y) { this.cY = (float)y; this.isPointsDirty = true; return this; }
	
	public AABB3f setCenterZ(double z) { this.cZ = (float)z; this.isPointsDirty = true; return this; }
	
	public Point3 getCenter(Point3 res)
	{
		res = res != null ? res : new Point3();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Point3 getCenter()
	{
		return new Point3(this.cX, this.cY, this.cZ);
	}
	
	public Vec3 getCenter(Vec3 res)
	{
		res = res != null ? res : new Vec3();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Vec3 getHalfExtend()
	{
		return new Vec3(this.heX, this.heY, this.heZ);
	}
	
	public Vec3 getHalfExtend(Vec3 res)
	{
		res = res != null ? res : new Vec3();
		return res.set(this.heX, this.heY, this.heZ);
	}
	
	public Point3 getMin()
	{
		return new Point3(this.cX - this.heX, this.cY - this.heY, this.cZ - this.heZ);
	}
	
	public Point3 getMax()
	{
		return new Point3(this.cX + this.heX, this.cY + this.heY, this.cZ + this.heZ);
	}
	
	public Point3[] getPoints()
	{
		if(this.isPointsDirty)
		{
			Vec3 c = Vec3Pool.get(this.cX, this.cY, this.cZ);

			Vec3 v = Vec3Pool.get(this.heX, this.heY, this.heZ);

			Vec3 t1 = Vec3Pool.get(v);
			Vec3 t2 = Vec3Pool.get(-v.getX(), v.getY(), v.getZ());
			Vec3 t3 = Vec3Pool.get(-v.getX(), -v.getY(), v.getZ());
			Vec3 t4 = Vec3Pool.get(v.getX(), -v.getY(), v.getZ());

			Vec3 r = Vec3Pool.get();
			
			this.points[0] = new Point3(c.add(t1, r));
			this.points[1] = new Point3(c.add(t2, r));
			this.points[2] = new Point3(c.add(t3, r));
			this.points[3] = new Point3(c.add(t4, r));
			
			this.points[4] = new Point3(c.sub(t1, r));
			this.points[5] = new Point3(c.sub(t2, r));
			this.points[6] = new Point3(c.sub(t3, r));
			this.points[7] = new Point3(c.sub(t4, r));
			
			Vec3Pool.store(c, v, t1, t2, t3, t4, r);
			
			this.isPointsDirty = false;
			
		}
		return this.points;
	}

	public AABB3f transform(Mat4f t, AABB3f res)
	{
		assert(t != null);
		assert(!t.isZeroMatrix());
		res = res != null ? res : new AABB3f();
		
		Vec3 c = Vec3Pool.get(this.cX, this.cY, this.cZ);
		Vec3 he = Vec3Pool.get(this.heX, this.heY, this.heZ);
		
		
		
		Vec3 min = c.sub(he, Vec3Pool.get());
		Vec3 max = c.add(he, Vec3Pool.get());
		
		t.transform(min, min);
		t.transform(max, max);
		
		Vec3 halfExtend = max.sub(min, max).mul(0.5f, null);
		Vec3 center = min.add(halfExtend, null);
		
		Vec3Pool.store(min, max, c, he);
		
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
		return "aabb3f(center: " + new Vec3(this.cX, this.cY, this.cZ) + ", halfExtend: " + new Vec3(this.heX, this.heY, this.heZ) + ")";
	}
}