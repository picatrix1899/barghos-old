package org.barghos.math.geometry;

import java.util.ArrayList;
import java.util.List;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.vec3.Vec3;

public class ConvexTriangleMesh3f implements FiniteGeometricObject
{

	private List<Triangle3f> triangles = new ArrayList<>();
	
	public ConvexTriangleMesh3f()
	{
		
	}
	
	public ConvexTriangleMesh3f(ConvexTriangleMesh3f mesh)
	{
		set(mesh.triangles);
	}
	
	public ConvexTriangleMesh3f(List<Triangle3f> triangles)
	{
		set(triangles);
	}

	public boolean isValid()
	{
		return !this.triangles.isEmpty();
	}
	
	public ConvexTriangleMesh3f set(List<Triangle3f> triangles)
	{
		assert(triangles != null);
		assert(triangles.size() > 0);
		this.triangles.clear();
		
		for(int i = 0; i < triangles.size(); i++)
			this.triangles.add(new Triangle3f(triangles.get(i)));
		
		return this;
	}
	
	public Point3[] getPoints()
	{
		Point3[] p = new Point3[triangles.size() * 3];
		
		for(int i = 0; i < triangles.size(); i++)
		{
			p[i * 3] = triangles.get(i).getP1(null);
			p[i * 3 + 1] = triangles.get(i).getP2(null);
			p[i * 3 + 2] = triangles.get(i).getP3(null);
		}
		
		return p;
	}
	
	public List<Triangle3f> getTriangles()
	{
		return new ArrayList<>(this.triangles);
	}
	
	public OBB3f getOBBf(Mat4f t, Mat4f r)
	{
		PointSet3f set = getPointSet(null);

		Vec3 min = new Vec3(set.getMinX(), set.getMinY(), set.getMinZ());
		Vec3 max = new Vec3(set.getMaxX(), set.getMaxY(), set.getMaxZ());

		t.transform(min, min);
		t.transform(max, max);
		
		Vec3 halfExtend = max.sub(min, max).mul(0.5f, max);
		Point3 center = new Point3(min.add(halfExtend, min));
		
		return new OBB3f(center, halfExtend, r);
	}

	public AABB3f getAABBf()
	{
		PointSet3f set = getPointSet(null);

		Vec3 min = new Vec3(set.getMinX(), set.getMinY(), set.getMinZ());
		Vec3 max = new Vec3(set.getMaxX(), set.getMaxY(), set.getMaxZ());
		
		Vec3 halfExtend = max.sub(min, max).mul(0.5f, max);
		Point3 center = new Point3(min.add(halfExtend, min));
		
		return new AABB3f(center, halfExtend);
	}
	
	public ConvexTriangleMesh3f transform(Mat4f t, ConvexTriangleMesh3f res)
	{	
		res = res != null ? res : new ConvexTriangleMesh3f();
		List<Triangle3f> tr = new ArrayList<>();
		
		for(int i = 0; i < this.triangles.size(); i++)
		{
			tr.add(this.triangles.get(i).transform(t, null));
		}
		
		return res.set(tr);
	}

}
