package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;
import org.barghos.math.pool.Vec3fPool;
import org.barghos.math.vector.Vec3f;
import org.barghos.math.vector.Vec3fAxis;

public class OBB3f implements FiniteGeometricObject
{
	
	private float cX, cY, cZ;
	private float heX, heY, heZ;
	private Mat4f rotation = Mat4f.identity();
	
	private Point3f[] points = new Point3f[8];
	private Mat4f modelSpace = Mat4f.identity();
	
	private boolean isPointsDirty = true;
	private boolean isModelSpaceDirty = true;
	
	public OBB3f() { }
	
	public OBB3f(OBB3f obb)
	{
		assert(obb != null);
		set(obb);
	}
	
	public OBB3f(ITup3R center, ITup3R halfExtend, Mat4f rotation)
	{
		assert(center != null);
		assert(halfExtend != null);
		assert(rotation != null);
		assert(!rotation.isZeroMatrix());
		set(center, halfExtend, rotation);
	}
	
	public OBB3f(double cX, double cY, double cZ, double heX, double heY, double heZ, Mat4f rotation)
	{
		assert(rotation != null);
		assert(!rotation.isZeroMatrix());
		set(cX, cY, cZ, heX, heY, heZ, rotation);
	}
	
	public OBB3f set(OBB3f obb)
	{
		assert(obb != null);
		return set(obb.getCenter(), obb.getHalfExtend(), obb.getRotation());
	}
	
	public OBB3f set(ITup3R center, ITup3R halfExtend, Mat4f rotation)
	{
		assert(center != null);
		assert(halfExtend != null);
		assert(rotation != null);
		assert(!rotation.isZeroMatrix());
		return setCenter(center).setHalfExtend(halfExtend).setRotation(rotation);
	}
	
	public OBB3f set(double cX, double cY, double cZ, double heX, double heY, double heZ, Mat4f rotation)
	{
		assert(rotation != null);
		assert(!rotation.isZeroMatrix());
		return setCenter(cX, cY, cZ).setHalfExtend(heX, heY, heZ).setRotation(rotation);
	}
	
	public OBB3f setCenter(ITup3R center)
	{
		assert(center != null);
		return setCenter(center.getUniX(), center.getUniY(), center.getUniZ());
	}
	
	public OBB3f setCenter(double x, double y, double z) { return setCenterX(x).setCenterY(y).setCenterZ(z); }
	
	public OBB3f setCenterX(double x) { this.cX = (float)x; this.isPointsDirty = true; return this; }
	
	public OBB3f setCenterY(double y) { this.cY = (float)y; this.isPointsDirty = true; return this; }
	
	public OBB3f setCenterZ(double z) { this.cZ = (float)z; this.isPointsDirty = true; return this; }
	
	public OBB3f setHalfExtend(ITup3R halfExtend)
	{
		assert(halfExtend != null);
		return this.setHalfExtend(halfExtend.getUniX(), halfExtend.getUniY(), halfExtend.getUniZ());
	}
	
	public OBB3f setHalfExtend(double x, double y, double z) { return setHalfExtendX(x).setHalfExtendY(y).setHalfExtendZ(z); }
	
	public OBB3f setHalfExtendX(double x) { this.heX = (float)x; this.isPointsDirty = true; return this; }
	
	public OBB3f setHalfExtendY(double y) { this.heY = (float)y; this.isPointsDirty = true; return this; }
	
	public OBB3f setHalfExtendZ(double z) { this.heZ = (float)z; this.isPointsDirty = true; return this; }
	
	public OBB3f setRotation(Mat4f rotation)
	{
		assert(rotation != null);
		assert(!rotation.isZeroMatrix());
		this.rotation.set(rotation); this.isPointsDirty = true; this.isModelSpaceDirty = true; return this;
	}
	
	public Point3f getCenter()
	{
		return new Point3f(this.cX, this.cY, this.cZ);
	}
	
	public Point3f getCenter(Point3f res)
	{
		if(res == null) res = new Point3f();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Vec3f getCenter(Vec3f res)
	{
		if(res == null) res = new Vec3f();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Vec3f getHalfExtend()
	{
		return new Vec3f(this.heX, this.heY, this.heZ);
	}
	
	public Vec3f getHalfExtend(Vec3f res)
	{
		if(res == null) res = new Vec3f();
		return res.set(this.heX, this.heY, this.heZ);
	}
	
	public Mat4f getRotation()
	{
		return new Mat4f(this.rotation);
	}
	
	public Mat4f getRotation(Mat4f res)
	{
		if(res == null) res = new Mat4f();
		return res.set(this.rotation);
	}
	
	public Mat4f getModelSpaceMatrix()
	{
		if(this.isModelSpaceDirty)
		{
			Mat4f m = Mat4f.identity();
			
			Vec3f msX = Vec3fPool.get();
			Vec3f msY = Vec3fPool.get();
			Vec3f msZ = Vec3fPool.get();
			
			this.rotation.transform(Vec3fAxis.AXIS_X, msX);
			this.rotation.transform(Vec3fAxis.AXIS_Y, msY);
			this.rotation.transform(Vec3fAxis.AXIS_Z, msZ);
			
			m.setRow(0, msX.getUniX(), msX.getUniY(), msX.getUniZ(), 0);
			m.setRow(1, msY.getUniX(), msY.getUniY(), msY.getUniZ(), 0);
			m.setRow(2, msZ.getUniX(), msZ.getUniY(), msZ.getUniZ(), 0);
			
			Vec3fPool.store(msX, msY, msZ);
			
			this.modelSpace.set(m);
			this.isModelSpaceDirty = false;
		}

		return new Mat4f(this.modelSpace);
	}
	
	public Mat4f getModelSpaceMatrix(Mat4f res)
	{
		res = res != null ? res : new Mat4f();
		if(this.isModelSpaceDirty)
		{
			Mat4f m = Mat4f.identity();
			
			Vec3f msX = Vec3fPool.get();
			Vec3f msY = Vec3fPool.get();
			Vec3f msZ = Vec3fPool.get();
			
			this.rotation.transform(Vec3fAxis.AXIS_X, msX);
			this.rotation.transform(Vec3fAxis.AXIS_Y, msY);
			this.rotation.transform(Vec3fAxis.AXIS_Z, msZ);
			
			m.setRow(0, msX.getUniX(), msX.getUniY(), msX.getUniZ(), 0);
			m.setRow(1, msY.getUniX(), msY.getUniY(), msY.getUniZ(), 0);
			m.setRow(2, msZ.getUniX(), msZ.getUniY(), msZ.getUniZ(), 0);
			
			Vec3fPool.store(msX, msY, msZ);
			
			this.modelSpace.set(m);
			this.isModelSpaceDirty = false;
		}

		return res.set(this.modelSpace);
	}
	
	@Override
	public Point3f[] getPoints()
	{
		if(this.isPointsDirty)
		{
			Vec3f c = Vec3fPool.get(this.cX, this.cY, this.cZ);

			Mat4f modelSpace = getModelSpaceMatrix();
			
			Mat4f objToWorld = new Mat4f(modelSpace).transpose();

			Vec3f v = Vec3fPool.get(this.heX, this.heY, this.heZ);

			modelSpace.transform(v, v);

			Vec3f t1 = Vec3fPool.get(v);
			Vec3f t2 = Vec3fPool.get(-v.getUniX(), v.getUniY(), v.getUniZ());
			Vec3f t3 = Vec3fPool.get(-v.getUniX(), -v.getUniY(), v.getUniZ());
			Vec3f t4 = Vec3fPool.get(v.getUniX(), -v.getUniY(), v.getUniZ());

			objToWorld.transform(t1, t1);
			objToWorld.transform(t2, t2);
			objToWorld.transform(t3, t3);
			objToWorld.transform(t4, t4);
			
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
	
	public OBB3f transform(Mat4f t, OBB3f res)
	{
		res = res != null ? res : new OBB3f();
		
		Vec3f min = Vec3f.sub(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, Vec3fPool.get());
		Vec3f max = Vec3f.add(this.cX, this.cY, this.cZ, this.heX, this.heY, this.heZ, Vec3fPool.get());
		
		t.transform(min, min);
		t.transform(max, max);
		
		Vec3f halfExtend = max.sub(min, max).mul(0.5, null);
		Vec3f center = min.add(halfExtend, null);
		
		Vec3fPool.store(min, max);
		
		return res.set(center, halfExtend, this.rotation);
	}
	
	@Override
	public String toString()
	{
		return "oob3f(center:point3f(" + this.cX +"f, " + this.cY + "f, " + this.cZ + "f), halfExtend:vec3f(" + this.heX + "f, " + this.heY + "f, " + this.heZ + "f))";
	}
}
