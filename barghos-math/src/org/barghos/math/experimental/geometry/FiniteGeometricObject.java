package org.barghos.math.experimental.geometry;

import org.barghos.math.experimental.matrix.Mat4f;
import org.barghos.math.experimental.point.Point3;

public interface FiniteGeometricObject
{
	Point3[] getPoints();
	
	default Point3[] getTransformedPoints(Mat4f t)
	{
		Point3[] p = getPoints();
		
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
