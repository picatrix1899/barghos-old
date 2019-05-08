package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;
import org.barghos.math.pool.Vec3fPool;
import org.barghos.math.vector.Vec3f;
import org.barghos.math.vector.Vec3fAxis;

public class OBBHalfExtend3f
{
	
	private float cX, cY, cZ  = 0.0f;
	private float heX, heY, heZ = 0.0f;
	private Mat4f rotation;
	
	private Point3f[] points = new Point3f[8];
	private Mat4f modelSpace;
	
	private boolean isPointsDirty = true;
	private boolean isModelSpaceDirty = true;
	
	public OBBHalfExtend3f(OBBHalfExtend3f obb)
	{
		
	}
	
	public OBBHalfExtend3f(ITup3fR center, ITup3fR halfExtend, Mat4f rotation)
	{
		setCenter(center).setHalfExtend(halfExtend).setRotation(rotation);
	}
	
	
	public OBBHalfExtend3f setCenter(ITup3R center)
	{
		return setCenter(center.getUniX(), center.getUniY(), center.getUniZ());
	}
	
	public OBBHalfExtend3f setCenter(double x, double y, double z)
	{
		return setCenterX(x).setCenterY(y).setCenterZ(z);
	}
	
	public OBBHalfExtend3f setCenterX(double x)
	{
		this.cX = (float)x; this.isPointsDirty = true; return this;
	}
	
	public OBBHalfExtend3f setCenterY(double y)
	{
		this.cY = (float)y; this.isPointsDirty = true; return this;
	}
	
	public OBBHalfExtend3f setCenterZ(double z)
	{
		this.cZ = (float)z; this.isPointsDirty = true; return this;
	}
	
	public OBBHalfExtend3f setHalfExtend(ITup3R halfExtend)
	{
		return this.setHalfExtend(halfExtend.getUniX(), halfExtend.getUniY(), halfExtend.getUniZ());
	}
	
	public OBBHalfExtend3f setHalfExtend(double x, double y, double z)
	{
		return setHalfExtendX(x).setHalfExtendY(y).setHalfExtendZ(z);
	}
	
	public OBBHalfExtend3f setHalfExtendX(double x)
	{
		this.heX = (float)x; this.isPointsDirty = true; return this;
	}
	
	public OBBHalfExtend3f setHalfExtendY(double y)
	{
		this.heY = (float)y; this.isPointsDirty = true; return this;
	}
	
	public OBBHalfExtend3f setHalfExtendZ(double z)
	{
		this.heZ = (float)z; this.isPointsDirty = true; return this;
	}
	
	public OBBHalfExtend3f setRotation(Mat4f rotation)
	{
		this.rotation = rotation; this.isPointsDirty = true; this.isModelSpaceDirty = true; return this;
	}
	
	public Point3f getCenter(Point3f res)
	{
		if(res == null) res = new Point3f();
		return res.set(this.cX, this.cY, this.cZ);
	}
	
	public Vec3f getHalfExtend(Vec3f res)
	{
		if(res == null) res = new Vec3f();
		return res.set(this.heX, this.heY, this.heZ);
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
			this.modelSpace = Mat4f.identity();
			
			Vec3f msX = Vec3fPool.get(Vec3fAxis.AXIS_X);
			Vec3f msY = Vec3fPool.get(Vec3fAxis.AXIS_Y);
			Vec3f msZ = Vec3fPool.get(Vec3fAxis.AXIS_Z);
			
			this.rotation.transform(msX, msX);
			this.rotation.transform(msY, msY);
			this.rotation.transform(msZ, msZ);
			
			this.modelSpace.setRow(0, msX.getUniX(), msX.getUniY(), msX.getUniZ(), 0);
			this.modelSpace.setRow(1, msY.getUniX(), msY.getUniY(), msY.getUniZ(), 0);
			this.modelSpace.setRow(2, msZ.getUniX(), msZ.getUniY(), msZ.getUniZ(), 0);
			
			Vec3fPool.store(msX, msY, msZ);
			
			this.isModelSpaceDirty = false;
		}

		
		return this.modelSpace;
	}
	
	public Point3f[] getPoints()
	{
		if(this.isPointsDirty)
		{
			Vec3f c = Vec3fPool.get(this.cX, this.cY, this.cZ);

			Mat4f modelSpace = getModelSpaceMatrix();
			
			Mat4f objToWorld = new Mat4f(modelSpace).transpose();
			
			Vec3f v = Vec3fPool.get(this.heX,this.heY, this.heZ);

			modelSpace.transform(v, v);
			
			Vec3f t1 = Vec3fPool.get(v);
			Vec3f t2 = Vec3fPool.get(-v.getUniX(), v.getUniY(), v.getUniZ());
			Vec3f t3 = Vec3fPool.get(-v.getUniX(), -v.getUniY(), v.getUniZ());
			Vec3f t4 = Vec3fPool.get(v.getUniX(), -v.getUniY(), v.getUniZ());

			this.points[0] = objToWorld.transform(c.add(t1, null), (Point3f)null);
			this.points[1] = objToWorld.transform(c.add(t2, null), (Point3f)null);
			this.points[2] = objToWorld.transform(c.add(t3, null), (Point3f)null);
			this.points[3] = objToWorld.transform(c.add(t4, null), (Point3f)null);
			
			this.points[4] = objToWorld.transform(c.sub(t1, null), (Point3f)null);
			this.points[5] = objToWorld.transform(c.sub(t2, null), (Point3f)null);
			this.points[6] = objToWorld.transform(c.sub(t3, null), (Point3f)null);
			this.points[7] = objToWorld.transform(c.sub(t4, null), (Point3f)null);
			
			Vec3fPool.store(c, v, t1, t2, t3, t4);
			
			this.isPointsDirty = false;
		}
		
		return this.points;
	}
}
