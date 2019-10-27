package org.barghos.math.geometry;

import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.vec3.Vec3;
import org.barghos.math.vector.vec3.Vec3Axis;
import org.barghos.math.vector.vec3.Vec3Pool;

public class OBB3f implements FiniteGeometricObject
{
	
	private float cX, cY, cZ;
	private float heX, heY, heZ;
	private Mat4f rotation = Mat4f.identity();
	
	private Point3[] points = new Point3[8];
	private Mat4f modelSpace = Mat4f.identity();
	
	private boolean isPointsDirty = true;
	private boolean isModelSpaceDirty = true;
	
	public OBB3f() { }
	
	public OBB3f(OBB3f obb)
	{
		assert(obb != null);
		set(obb);
	}
	
	public OBB3f(Tup3fR center, Tup3fR halfExtend, Mat4f rotation)
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
	
	public OBB3f set(Tup3fR center, Tup3fR halfExtend, Mat4f rotation)
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
	
	public OBB3f setCenter(Tup3fR center)
	{
		assert(center != null);
		return setCenter(center.getX(), center.getY(), center.getZ());
	}
	
	public OBB3f setCenter(double x, double y, double z) { return setCenterX(x).setCenterY(y).setCenterZ(z); }
	
	public OBB3f setCenterX(double x) { this.cX = (float)x; this.isPointsDirty = true; return this; }
	
	public OBB3f setCenterY(double y) { this.cY = (float)y; this.isPointsDirty = true; return this; }
	
	public OBB3f setCenterZ(double z) { this.cZ = (float)z; this.isPointsDirty = true; return this; }
	
	public OBB3f setHalfExtend(Tup3fR halfExtend)
	{
		assert(halfExtend != null);
		return this.setHalfExtend(halfExtend.getX(), halfExtend.getY(), halfExtend.getZ());
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
	
	public Point3 getCenter()
	{
		return new Point3(this.cX, this.cY, this.cZ);
	}
	
	public Point3 getCenter(Point3 res)
	{
		if(res == null) res = new Point3();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Vec3 getCenter(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Vec3 getHalfExtend()
	{
		return new Vec3(this.heX, this.heY, this.heZ);
	}
	
	public Vec3 getHalfExtend(Vec3 res)
	{
		if(res == null) res = new Vec3();
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
			
			Vec3 msX = Vec3Pool.get();
			Vec3 msY = Vec3Pool.get();
			Vec3 msZ = Vec3Pool.get();
			
			this.rotation.transform(Vec3Axis.AXIS_X, msX);
			this.rotation.transform(Vec3Axis.AXIS_Y, msY);
			this.rotation.transform(Vec3Axis.AXIS_Z, msZ);
			
			m.setRow(0, msX.getX(), msX.getY(), msX.getZ(), 0);
			m.setRow(1, msY.getX(), msY.getY(), msY.getZ(), 0);
			m.setRow(2, msZ.getX(), msZ.getY(), msZ.getZ(), 0);
			
			Vec3Pool.store(msX, msY, msZ);
			
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
			
			Vec3 msX = Vec3Pool.get();
			Vec3 msY = Vec3Pool.get();
			Vec3 msZ = Vec3Pool.get();
			
			this.rotation.transform(Vec3Axis.AXIS_X, msX);
			this.rotation.transform(Vec3Axis.AXIS_Y, msY);
			this.rotation.transform(Vec3Axis.AXIS_Z, msZ);
			
			m.setRow(0, msX.getX(), msX.getY(), msX.getZ(), 0);
			m.setRow(1, msY.getX(), msY.getY(), msY.getZ(), 0);
			m.setRow(2, msZ.getX(), msZ.getY(), msZ.getZ(), 0);
			
			Vec3Pool.store(msX, msY, msZ);
			
			this.modelSpace.set(m);
			this.isModelSpaceDirty = false;
		}

		return res.set(this.modelSpace);
	}
	
	@Override
	public Point3[] getPoints()
	{
		if(this.isPointsDirty)
		{
			Vec3 c = Vec3Pool.get(this.cX, this.cY, this.cZ);

			Mat4f modelSpace = getModelSpaceMatrix();
			
			Mat4f objToWorld = new Mat4f(modelSpace).transpose();

			Vec3 v = Vec3Pool.get(this.heX, this.heY, this.heZ);

			modelSpace.transform(v, v);

			Vec3 t1 = Vec3Pool.get(v);
			Vec3 t2 = Vec3Pool.get(-v.getX(), v.getY(), v.getZ());
			Vec3 t3 = Vec3Pool.get(-v.getX(), -v.getY(), v.getZ());
			Vec3 t4 = Vec3Pool.get(v.getX(), -v.getY(), v.getZ());

			objToWorld.transform(t1, t1);
			objToWorld.transform(t2, t2);
			objToWorld.transform(t3, t3);
			objToWorld.transform(t4, t4);
			
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
	
	public OBB3f transform(Mat4f t, OBB3f res)
	{
		res = res != null ? res : new OBB3f();
		
		Vec3 min = new Vec3(this.cX, this.cY, this.cZ).sub(this.heX, this.heY, this.heZ, Vec3Pool.get());
		Vec3 max = new Vec3(this.cX, this.cY, this.cZ).add(this.heX, this.heY, this.heZ, Vec3Pool.get());
		
		t.transform(min, min);
		t.transform(max, max);
		
		Vec3 halfExtend = max.sub(min, max).mul(0.5f, null);
		Vec3 center = min.add(halfExtend, null);
		
		Vec3Pool.store(min, max);
		
		return res.set(center, halfExtend, this.rotation);
	}
	
	@Override
	public String toString()
	{
		return "oob3f(center:point3f(" + this.cX +"f, " + this.cY + "f, " + this.cZ + "f), halfExtend:vec3f(" + this.heX + "f, " + this.heY + "f, " + this.heZ + "f))";
	}
}
