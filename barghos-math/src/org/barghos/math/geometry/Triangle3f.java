package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.math.Maths;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;

public class Triangle3f implements FiniteGeometricObject
{
	public float p1x, p1y, p1z;
	public float p2x, p2y, p2z;
	public float p3x, p3y, p3z;
	
	public Triangle3f() { }
	public Triangle3f(Triangle3f t)
	{
		assert(t != null);
		set(t);
	}
	
	public Triangle3f(ITup3R p1, ITup3R p2, ITup3R p3)
	{
		assert(p1 != null);
		assert(p2 != null);
		assert(p3 != null);
		set(p1, p2, p3);
	}

	public Triangle3f(double x1, double y1, double z1, ITup3R p2, ITup3R p3)
	{
		assert(p2 != null);
		assert(p3 != null);
		set(x1, y1, z1, p2, p3);
	}
	
	public Triangle3f(ITup3R p1, double x2, double y2, double z2, ITup3R p3)
	{
		assert(p1 != null);
		assert(p3 != null);
		set(p1, x2, y2, z2, p3);
	}
	
	public Triangle3f(ITup3R p1, ITup3R p2, double x3, double y3, double z3)
	{
		assert(p1 != null);
		assert(p2 != null);
		set(p1, p2, x3, y3, z3);
	}
	
	public Triangle3f(double x1, double y1, double z1, double x2, double y2, double z2, ITup3R p3)
	{
		assert(p3 != null);
		set(x1, y1, z1, x2, y2, z2, p3);
	}
	
	public Triangle3f(double x1, double y1, double z1, ITup3R p2, double x3, double y3, double z3)
	{
		assert(p2 != null);
		set(x1, y1, z1, p2, x3, y3, z3);
	}
	
	public Triangle3f(ITup3R p1, double x2, double y2, double z2, double x3, double y3, double z3)
	{
		assert(p1 != null);
		set(p1, x2, y2, z2, x3, y3, z3);
	}
	
	public Triangle3f(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3)
	{
		set(x1, y1, z1, x2, y2, z2, x3, y3, z3);
	}
	
	public Triangle3f set(Triangle3f t)
	{
		assert(t != null);
		return set(t.p1x, t.p1y, t.p1z, t.p2x, t.p2y, t.p2z,t.p3x, t.p3y, t.p3z);
	}
	
	public Triangle3f set(ITup3R p1, ITup3R p2, ITup3R p3)
	{
		assert(p1 != null);
		assert(p2 != null);
		assert(p3 != null);
		return set(p1.getUniX(), p1.getUniY(), p1.getUniZ(), p2.getUniX(), p2.getUniY(), p2.getUniZ(), p3.getUniX(), p3.getUniY(), p3.getUniZ());
	}
	
	public Triangle3f set(double x1, double y1, double z1, ITup3R p2, ITup3R p3)
	{
		assert(p2 != null);
		assert(p3 != null);
		return set(x1, y1, z1, p2.getUniX(), p2.getUniY(), p2.getUniZ(), p3.getUniX(), p3.getUniY(), p3.getUniZ());
	}
	
	public Triangle3f set(ITup3R p1, double x2, double y2, double z2, ITup3R p3)
	{
		assert(p1 != null);
		assert(p3 != null);
		return set(p1.getUniX(), p1.getUniY(), p1.getUniZ(), x2, y2, z2, p3.getUniX(), p3.getUniY(), p3.getUniZ());
	}
	
	public Triangle3f set(ITup3R p1, ITup3R p2, double x3, double y3, double z3)
	{
		assert(p1 != null);
		assert(p2 != null);
		return set(p1.getUniX(), p1.getUniY(), p1.getUniZ(), p2.getUniX(), p2.getUniY(), p2.getUniZ(), x3, y3, z3);
	}
	
	public Triangle3f set(double x1, double y1, double z1, double x2, double y2, double z2, ITup3R p3)
	{
		assert(p3 != null);
		return set(x1, y1, z1, x2, y2, z2, p3.getUniX(), p3.getUniY(), p3.getUniZ());
	}
	
	public Triangle3f set(double x1, double y1, double z1, ITup3R p2, double x3, double y3, double z3)
	{
		assert(p2 != null);
		return set(x1, y1, z1, p2.getUniX(), p2.getUniY(), p2.getUniZ(), x3, y3, z3);
	}
	
	public Triangle3f set(ITup3R p1, double x2, double y2, double z2, double x3, double y3, double z3)
	{
		assert(p1 != null);
		return set(p1.getUniX(), p1.getUniY(), p1.getUniZ(), x2, y2, z2, x3, y3, z3);
	}
	
	public Triangle3f set(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3)
	{
		return setP1(x1, y1, z1).setP2(x2, y2, z2).setP3(x3, y3, z3);
	}
	
	public Triangle3f setP1(ITup3R t)
	{
		assert(t != null);
		return setP1(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public Triangle3f setP1(double x, double y, double z)
	{
		return this.setP1X(x).setP1Y(y).setP1Z(z);
	}
	
	public Triangle3f setP1X(double x)
	{
		this.p1x = (float)x; return this;
	}
	
	public Triangle3f setP1Y(double y)
	{
		this.p1y = (float)y; return this;
	}
	
	public Triangle3f setP1Z(double z)
	{
		this.p1z = (float)z; return this;
	}
	
	public Triangle3f setP2(ITup3R t)
	{
		assert(t != null);
		return setP2(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public Triangle3f setP2(double x, double y, double z)
	{
		return this.setP2X(x).setP2Y(y).setP2Z(z);
	}
	
	public Triangle3f setP2X(double x)
	{
		this.p2x = (float)x; return this;
	}
	
	public Triangle3f setP2Y(double y)
	{
		this.p2y = (float)y; return this;
	}
	
	public Triangle3f setP2Z(double z)
	{
		this.p2z = (float)z; return this;
	}
	
	public Triangle3f setP3(ITup3R t)
	{
		assert(t != null);
		return setP3(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public Triangle3f setP3(double x, double y, double z)
	{
		return this.setP3X(x).setP3Y(y).setP3Z(z);
	}
	
	public Triangle3f setP3X(double x)
	{
		this.p3x = (float)x; return this;
	}
	
	public Triangle3f setP3Y(double y)
	{
		this.p3y = (float)y; return this;
	}
	
	public Triangle3f setP3Z(double z)
	{
		this.p3z = (float)z; return this;
	}
	
	public Point3f getP1(Point3f res)
	{
		res = res != null ? res : new Point3f();
		return res.set(this.p1x, this.p1y, this.p1z);
	}
	
	public Point3f getP2(Point3f res)
	{
		res = res != null ? res : new Point3f();
		return res.set(this.p2x, this.p2y, this.p2z);
	}
	
	public Point3f getP3(Point3f res)
	{
		res = res != null ? res : new Point3f();
		return res.set(this.p3x, this.p3y, this.p3z);
	}
	
	public float getP1X() { return this.p1x; }
	
	public float getP1Y() { return this.p1y; }
	
	public float getP1Z() { return this.p1z; }
	
	public float getP2X() { return this.p2x; }
	
	public float getP2Y() { return this.p2y; }
	
	public float getP2Z() { return this.p2z; }
	
	public float getP3X() { return this.p3x; }
	
	public float getP3Y() { return this.p3y; }
	
	public float getP3Z() { return this.p3z; }
	
	public Vec3f getSideP1P2(Vec3f res) { return Vec3f.sub(this.p2x, this.p2y, this.p2z, this.p1x, this.p1y, this.p1z, res); }
	
	public Vec3f getSideP2P1(Vec3f res) { return Vec3f.sub(this.p1x, this.p1y, this.p1z, this.p2x, this.p2y, this.p2z, res); }
	
	public Vec3f getSideP1P3(Vec3f res) { return Vec3f.sub(this.p3x, this.p3y, this.p3z, this.p1x, this.p1y, this.p1z, res); }
	
	public Vec3f getSideP3P1(Vec3f res) { return Vec3f.sub(this.p1x, this.p1y, this.p1z, this.p3x, this.p3y, this.p3z, res); }
	
	public Vec3f getSideP2P3(Vec3f res) { return Vec3f.sub(this.p3x, this.p3y, this.p3z, this.p2x, this.p2y, this.p2z, res); }
	
	public Vec3f getSideP3P2(Vec3f res) { return Vec3f.sub(this.p2x, this.p2y, this.p2z, this.p3x, this.p3y, this.p3z, res); }
	
	public Line3f getSideP1P2(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p1x, this.p1y, this.p1z, this.p2x, this.p2y, this.p2z);
	}
	
	public Line3f getSideP2P1(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p2x, this.p2y, this.p2z, this.p1x, this.p1y, this.p1z);
	}
	
	public Line3f getSideP1P3(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p1x, this.p1y, this.p1z, this.p3x, this.p3y, this.p3z);
	}
	
	public Line3f getSideP3P1(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p3x, this.p3y, this.p3z, this.p1x, this.p1y, this.p1z);
	}
	
	public Line3f getSideP2P3(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p2x, this.p2y, this.p2z, this.p3x, this.p3y, this.p3z);
	}
	
	public Line3f getSideP3P2(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p3x, this.p3y, this.p3z, this.p2x, this.p2y, this.p2z);
	}
	
	public double getSquaredLengthSideP1P2()
	{
		double x = this.p2x - this.p1x;
		double y = this.p2y - this.p1y;
		double z = this.p2z - this.p1z;
		return x * x + y * y + z * z;
	}
	
	public double getSquaredLengthSideP1P3()
	{
		double x = this.p3x - this.p1x;
		double y = this.p3y - this.p1y;
		double z = this.p3z - this.p1z;
		return x * x + y * y + z * z;
	}

	public double getSquaredLengthSideP2P3()
	{
		double x = this.p3x - this.p2x;
		double y = this.p3y - this.p2y;
		double z = this.p3z - this.p2z;
		return x * x + y * y + z * z;
	}

	public double getLengthSideP1P2()
	{
		return Math.sqrt(getSquaredLengthSideP1P2());
	}
	
	public double getLengthSideP1P3()
	{
		return Math.sqrt(getSquaredLengthSideP1P3());
	}
	
	public double getLengthSideP2P3()
	{
		return Math.sqrt(getSquaredLengthSideP2P3());
	}
	
	public double getArea()
	{
		double aq = getSquaredLengthSideP2P3();
		double bq = getSquaredLengthSideP1P3();
		double cq = getSquaredLengthSideP1P2();
	
		if(aq == 0 || bq == 0 || cq == 0) return 0.0;
		
		if(aq == bq && bq == cq)
		{
			
			double a = Math.sqrt(aq);
			
			return Maths.INV_SQRT3 * 0.25 * a * a;
		}
		else
		{
			double a = Math.sqrt(aq);
			double b = Math.sqrt(bq);
			double c = Math.sqrt(cq);
			double s = (a + b + c) * 0.5;
			return Math.sqrt(s * (s - a ) * (s - b) * (s - c));
		}
	}
	@Override
	public Point3f[] getPoints()
	{
		return new Point3f[] {
			new Point3f(this.p1x, this.p1y, this.p1z),
			new Point3f(this.p2x, this.p2y, this.p2z),
			new Point3f(this.p3x, this.p3y, this.p3z)
		};
	}

	public Triangle3f transform(Mat4f t, Triangle3f res)
	{
		res = res != null ? res : new Triangle3f();
		
		Point3f p1 = getP1(null);
		Point3f p2 = getP2(null);
		Point3f p3 = getP3(null);

		t.transform(p1, p1);
		t.transform(p2, p2);
		t.transform(p3, p3);

		return res.set(p1,p2,p3);
	}
}
