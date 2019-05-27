package org.barghos.math.geometry;

import java.util.ArrayList;
import java.util.List;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;



public class ConvexTriangleMesh3f implements FiniteGeometricObject
{

	private List<Triangle3f> triangles = new ArrayList<>();
	
	public ConvexTriangleMesh3f(List<Triangle3f> triangles)
	{
		this.triangles.addAll(triangles);
	}

	public Point3f[] getPoints()
	{
		Point3f[] p = new Point3f[triangles.size() * 3];
		
		for(int i = 0; i < triangles.size(); i++)
		{
			p[i * 3] = triangles.get(i).getP1(new Point3f());
			p[i * 3 + 1] = triangles.get(i).getP2(new Point3f());
			p[i * 3 + 2] = triangles.get(i).getP3(new Point3f());
		}
		
		return p;
	}

	public OBB3f getOBBf(Mat4f t, Mat4f r)
	{
		PointSet3f set = getPointSet(null);

		Vec3f min = new Vec3f(set.getMinX(), set.getMinY(), set.getMinZ());
		Vec3f max = new Vec3f(set.getMaxX(), set.getMaxY(), set.getMaxZ());

		t.transform(min, min);
		t.transform(max, max);
		
		Vec3f halfExtend = max.sub(min, max).mul(0.5f, max);
		Point3f center = new Point3f(min.add(halfExtend, min));
		
		return new OBB3f(center, halfExtend, r);
	}

	public AABB3f getAABBf()
	{
		PointSet3f set = getPointSet(null);

		Vec3f min = new Vec3f(set.getMinX(), set.getMinY(), set.getMinZ());
		Vec3f max = new Vec3f(set.getMaxX(), set.getMaxY(), set.getMaxZ());
		
		Vec3f halfExtend = max.sub(min, max).mul(0.5f, max);
		Point3f center = new Point3f(min.add(halfExtend, min));
		
		return new AABB3f(center, halfExtend);
	}
	
	public ConvexTriangleMesh3f transform(Mat4f t, ConvexTriangleMesh3f res)
	{	
		List<Triangle3f> tr = new ArrayList<>();
		
		for(int i = 0; i < tr.size(); i++)
		{
			tr.add(tr.get(i).transform(t, null));
		}
		
		return new ConvexTriangleMesh3f(tr);
	}

}
