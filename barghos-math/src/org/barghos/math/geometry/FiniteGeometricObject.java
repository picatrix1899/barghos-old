package org.barghos.math.geometry;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;

public interface FiniteGeometricObject
{
	Point3f[] getPoints();
	
	default Point3f[] getTransformedPoints(Mat4f t)
	{
		Point3f[] p = getPoints();
		
		for(int i = 0; i < p.length; i++)
		{
			t.transform(p[i], p[i]);
		}
		
		return p;
	}
	
	default PointSet3f getPointSet()
	{
		PointSet3f res = new PointSet3f();
		
		return res.set(getPoints());
	}
	
	default PointSet3f getPointSet(PointSet3f res)
	{
		res = res != null ? res : new PointSet3f();

		return res.set(getPoints());
	}
	
	default PointSet3f getTransformedPointSet(Mat4f t)
	{
		PointSet3f res = new PointSet3f();
		
		PointSet3f s = getPointSet(null);
		
		s.transform(t, s);
		
		return res.set(s);
	}
	
	default PointSet3f getTransformedPointSet(Mat4f t, PointSet3f res)
	{
		res = res != null ? res : new PointSet3f();
		
		PointSet3f s = getPointSet(null);
		
		s.transform(t, s);
		
		return res.set(s);
	}

}