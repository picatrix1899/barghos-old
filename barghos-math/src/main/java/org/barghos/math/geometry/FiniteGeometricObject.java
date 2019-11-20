package org.barghos.math.geometry;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3;

public interface FiniteGeometricObject
{
	Point3[] getPoints();
	
	default Point3[] getTransformedPoints(Mat4f t)
	{
		Point3[] p = getPoints();
		
		int i = 0;
		for(; i < p.length; i++)
			t.transform(p[i], p[i]);
		
		return p;
	}
	
	default PointSet3f getPointSet()
	{
		return new PointSet3f(getPoints());
	}
	
	default PointSet3f getPointSet(PointSet3f res)
	{
		res = res != null ? res : new PointSet3f();

		return res.set(getPoints());
	}
	
	default PointSet3f getTransformedPointSet(Mat4f t)
	{
		PointSet3f res = new PointSet3f();
		
		PointSet3f s = getPointSet();
		
		s.transform(t, s);
		
		return res.set(s);
	}
	
	default PointSet3f getTransformedPointSet(Mat4f t, PointSet3f res)
	{
		res = res != null ? res : new PointSet3f();
		
		getPointSet(res);
		
		res.transform(t, res);
		
		return res;
	}

}
