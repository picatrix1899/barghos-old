package org.barghos.math.geometry;

import org.barghos.math.matrix.Mat4;
import org.barghos.math.point.Point3;

public interface FiniteGeometricObject3
{
	Point3[] getPoints();
	
	default Point3[] getTransformedPoints(Mat4 t)
	{
		Point3[] p = getPoints();
		
		int i = 0;
		for(; i < p.length; i++)
			t.transform(p[i], p[i]);
		
		return p;
	}
	
	default PointSet3 getPointSet()
	{
		return new PointSet3(getPoints());
	}
	
	default PointSet3 getPointSet(PointSet3 res)
	{
		res = res != null ? res : new PointSet3();

		return res.set(getPoints());
	}
	
	default PointSet3 getTransformedPointSet(Mat4 t)
	{
		PointSet3 s = getPointSet();

		return s.transform(t, null);
	}
	
	default PointSet3 getTransformedPointSet(Mat4 t, PointSet3 res)
	{
		res = res != null ? res : new PointSet3();
		
		getPointSet(res);
		
		res.transform(t, res);
		
		return res;
	}

}
