package org.barghos.math.geometry;

import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.vec3.Vec3;
import org.barghos.math.vector.vec3.Vec3Axis;
import org.barghos.math.vector.vec3.Vec3Pool;

public class OBB3f implements FiniteGeometricObject
{
	private Point3 center = new Point3();
	private Vec3 halfExtend = new Point3();
	private Mat4f rotation = Mat4f.identity();
	
	private Point3[] points = new Point3[8];
	private Mat4f modelSpace = Mat4f.identity();
	
	private boolean isPointsDirty = true;
	private boolean isModelSpaceDirty = true;
	
	public OBB3f() { }
	
	public OBB3f(OBB3f obb) { set(obb); }
	
	public OBB3f(Tup3fR center, Tup3fR halfExtend, Mat4f rotation) { set(center, halfExtend, rotation); }
	
	public OBB3f(float cX, float cY, float cZ, float heX, float heY, float heZ, Mat4f rotation) { set(cX, cY, cZ, heX, heY, heZ, rotation); }
	
	public OBB3f set(OBB3f obb) { return set(obb.getCenter(), obb.getHalfExtend(), obb.getRotation()); }
	
	public OBB3f set(Tup3fR center, Tup3fR halfExtend, Mat4f rotation) { return setCenter(center).setHalfExtend(halfExtend).setRotation(rotation); }
	
	public OBB3f set(float cX, float cY, float cZ, float heX, float heY, float heZ, Mat4f rotation) { return setCenter(cX, cY, cZ).setHalfExtend(heX, heY, heZ).setRotation(rotation); }
	
	public OBB3f setCenter(Tup3fR center) { return setCenter(center.getX(), center.getY(), center.getZ()); }
	
	public OBB3f setCenter(float x, float y, float z) { return setCenterX(x).setCenterY(y).setCenterZ(z); }
	
	public OBB3f setCenterX(float x) { this.center.setX(x); this.isPointsDirty = true; return this; }
	
	public OBB3f setCenterY(float y) { this.center.setY(y); this.isPointsDirty = true; return this; }
	
	public OBB3f setCenterZ(float z) { this.center.setZ(z); this.isPointsDirty = true; return this; }
	
	public OBB3f setHalfExtend(Tup3fR halfExtend) { return this.setHalfExtend(halfExtend.getX(), halfExtend.getY(), halfExtend.getZ()); }
	
	public OBB3f setHalfExtend(float x, float y, float z) { return setHalfExtendX(x).setHalfExtendY(y).setHalfExtendZ(z); }
	
	public OBB3f setHalfExtendX(float x) { this.halfExtend.setX(x); this.isPointsDirty = true; return this; }
	
	public OBB3f setHalfExtendY(float y) { this.halfExtend.setY(y); this.isPointsDirty = true; return this; }
	
	public OBB3f setHalfExtendZ(float z) { this.halfExtend.setZ(z); this.isPointsDirty = true; return this; }
	
	public OBB3f setRotation(Mat4f rotation) { this.rotation.set(rotation); this.isPointsDirty = true; this.isModelSpaceDirty = true; return this; }
	
	public Point3 getCenter()
	{
		return new Point3(this.center);
	}
	
	public Point3 getCenter(Point3 res)
	{
		if(res == null) res = new Point3();
		return res.set(this.center);
	}
	
	public Vec3 getCenter(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.center);
	}
	
	public Vec3 getHalfExtend()
	{
		return new Vec3(this.halfExtend);
	}
	
	public Vec3 getHalfExtend(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.halfExtend);
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
			Vec3 msX = Vec3Pool.get();
			Vec3 msY = Vec3Pool.get();
			Vec3 msZ = Vec3Pool.get();
			
			this.rotation.transform(Vec3Axis.AXIS_X, msX);
			this.rotation.transform(Vec3Axis.AXIS_Y, msY);
			this.rotation.transform(Vec3Axis.AXIS_Z, msZ);
			
			Mat4f m = Mat4f.identity();
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
			Vec3 msX = Vec3Pool.get();
			Vec3 msY = Vec3Pool.get();
			Vec3 msZ = Vec3Pool.get();
			
			this.rotation.transform(Vec3Axis.AXIS_X, msX);
			this.rotation.transform(Vec3Axis.AXIS_Y, msY);
			this.rotation.transform(Vec3Axis.AXIS_Z, msZ);
			
			Mat4f m = Mat4f.identity();
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
			Mat4f modelSpace = getModelSpaceMatrix();

			Mat4f objToWorld = new Mat4f(modelSpace).transpose();

			Vec3 v = Vec3Pool.get(this.halfExtend);

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
			
			this.points[0] = new Point3(this.center.add(t1, r));
			this.points[1] = new Point3(this.center.add(t2, r));
			this.points[2] = new Point3(this.center.add(t3, r));
			this.points[3] = new Point3(this.center.add(t4, r));
			
			this.points[4] = new Point3(this.center.sub(t1, r));
			this.points[5] = new Point3(this.center.sub(t2, r));
			this.points[6] = new Point3(this.center.sub(t3, r));
			this.points[7] = new Point3(this.center.sub(t4, r));
			
			Vec3Pool.store(v, t1, t2, t3, t4, r);
			
			this.isPointsDirty = false;
			
		}
		return this.points;
	}
	
	public OBB3f transform(Mat4f t, OBB3f res)
	{
		res = res != null ? res : new OBB3f();
		
		Vec3 min = Vec3Pool.get();
		Vec3 max = Vec3Pool.get();

		t.transform(this.center.sub(this.halfExtend, min), min);
		t.transform(this.center.add(this.halfExtend, max), max);
		
		Vec3 halfExtend = max.sub(min).mul(0.5f);
		Vec3 center = min.add(halfExtend);
		
		res.set(center, halfExtend, this.rotation);
		
		Vec3Pool.store(min, max);
		
		return res;
	}
	
	@Override
	public String toString()
	{
		return "oob3f(center=" + this.center + ", halfExtend=" + this.halfExtend + ")";
	}
}
