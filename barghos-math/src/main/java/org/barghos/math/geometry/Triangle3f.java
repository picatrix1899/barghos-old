package org.barghos.math.geometry;

import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.math.Maths;
import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.vec3.Vec3;
import org.barghos.math.vector.vec3.Vec3Pool;

public class Triangle3f implements FiniteGeometricObject
{
	private Point3 p1 = new Point3();
	private Point3 p2 = new Point3();
	private Point3 p3 = new Point3();
	
	public Triangle3f() { }
	public Triangle3f(Triangle3f t)
	{
		assert(t != null);
		set(t);
	}
	
	public Triangle3f(Tup3fR p1, Tup3fR p2, Tup3fR p3)
	{
		assert(p1 != null);
		assert(p2 != null);
		assert(p3 != null);
		set(p1, p2, p3);
	}

	public Triangle3f(float x1, float y1, float z1, Tup3fR p2, Tup3fR p3)
	{
		assert(p2 != null);
		assert(p3 != null);
		set(x1, y1, z1, p2, p3);
	}
	
	public Triangle3f(Tup3fR p1, float x2, float y2, float z2, Tup3fR p3)
	{
		assert(p1 != null);
		assert(p3 != null);
		set(p1, x2, y2, z2, p3);
	}
	
	public Triangle3f(Tup3fR p1, Tup3fR p2, float x3, float y3, float z3)
	{
		assert(p1 != null);
		assert(p2 != null);
		set(p1, p2, x3, y3, z3);
	}
	
	public Triangle3f(float x1, float y1, float z1, float x2, float y2, float z2, Tup3fR p3)
	{
		assert(p3 != null);
		set(x1, y1, z1, x2, y2, z2, p3);
	}
	
	public Triangle3f(float x1, float y1, float z1, Tup3fR p2, float x3, float y3, float z3)
	{
		assert(p2 != null);
		set(x1, y1, z1, p2, x3, y3, z3);
	}
	
	public Triangle3f(Tup3fR p1, float x2, float y2, float z2, float x3, float y3, float z3)
	{
		assert(p1 != null);
		set(p1, x2, y2, z2, x3, y3, z3);
	}
	
	public Triangle3f(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3)
	{
		set(x1, y1, z1, x2, y2, z2, x3, y3, z3);
	}
	
	public Triangle3f set(Triangle3f t)
	{
		assert(t != null);
		return set(t.p1.getX(), t.p1.getY(), t.p1.getZ(), t.p2.getX(), t.p2.getY(), t.p2.getZ(),t.p3.getX(), t.p3.getY(), t.p3.getZ());
	}
	
	public Triangle3f set(Tup3fR p1, Tup3fR p2, Tup3fR p3)
	{
		assert(p1 != null);
		assert(p2 != null);
		assert(p3 != null);
		return set(p1.getX(), p1.getY(), p1.getZ(), p2.getX(), p2.getY(), p2.getZ(), p3.getX(), p3.getY(), p3.getZ());
	}
	
	public Triangle3f set(float x1, float y1, float z1, Tup3fR p2, Tup3fR p3)
	{
		assert(p2 != null);
		assert(p3 != null);
		return set(x1, y1, z1, p2.getX(), p2.getY(), p2.getZ(), p3.getX(), p3.getY(), p3.getZ());
	}
	
	public Triangle3f set(Tup3fR p1, float x2, float y2, float z2, Tup3fR p3)
	{
		assert(p1 != null);
		assert(p3 != null);
		return set(p1.getX(), p1.getY(), p1.getZ(), x2, y2, z2, p3.getX(), p3.getY(), p3.getZ());
	}
	
	public Triangle3f set(Tup3fR p1, Tup3fR p2, float x3, float y3, float z3)
	{
		assert(p1 != null);
		assert(p2 != null);
		return set(p1.getX(), p1.getY(), p1.getZ(), p2.getX(), p2.getY(), p2.getZ(), x3, y3, z3);
	}
	
	public Triangle3f set(float x1, float y1, float z1, float x2, float y2, float z2, Tup3fR p3)
	{
		assert(p3 != null);
		return set(x1, y1, z1, x2, y2, z2, p3.getX(), p3.getY(), p3.getZ());
	}
	
	public Triangle3f set(float x1, float y1, float z1, Tup3fR p2, float x3, float y3, float z3)
	{
		assert(p2 != null);
		return set(x1, y1, z1, p2.getX(), p2.getY(), p2.getZ(), x3, y3, z3);
	}
	
	public Triangle3f set(Tup3fR p1, float x2, float y2, float z2, float x3, float y3, float z3)
	{
		assert(p1 != null);
		return set(p1.getX(), p1.getY(), p1.getZ(), x2, y2, z2, x3, y3, z3);
	}
	
	public Triangle3f set(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3)
	{
		return setP1(x1, y1, z1).setP2(x2, y2, z2).setP3(x3, y3, z3);
	}
	
	public Triangle3f setP1(Tup3fR t)
	{
		assert(t != null);
		return setP1(t.getX(), t.getY(), t.getZ());
	}
	
	public Triangle3f setP1(float x, float y, float z)
	{
		this.p1.set(x, y, z); return this;
	}
	
	public Triangle3f setP1X(float x)
	{
		this.p1.setX(x); return this;
	}
	
	public Triangle3f setP1Y(float y)
	{
		this.p1.setY(y); return this;
	}
	
	public Triangle3f setP1Z(float z)
	{
		this.p1.setZ(z); return this;
	}
	
	public Triangle3f setP2(Tup3fR t)
	{
		assert(t != null);
		return setP2(t.getX(), t.getY(), t.getZ());
	}
	
	public Triangle3f setP2(float x, float y, float z)
	{
		this.p2.set(x, y, z); return this;
	}
	
	public Triangle3f setP2X(float x)
	{
		this.p2.setX(x); return this;
	}
	
	public Triangle3f setP2Y(float y)
	{
		this.p2.setY(y); return this;
	}
	
	public Triangle3f setP2Z(float z)
	{
		this.p2.setZ(z); return this;
	}
	
	public Triangle3f setP3(Tup3fR t)
	{
		assert(t != null);
		return setP3(t.getX(), t.getY(), t.getZ());
	}
	
	public Triangle3f setP3(float x, float y, float z)
	{
		this.p3.set(x, y, z); return this;
	}
	
	public Triangle3f setP3X(float x)
	{
		this.p3.setX(x); return this;
	}
	
	public Triangle3f setP3Y(float y)
	{
		this.p3.setY(y); return this;
	}
	
	public Triangle3f setP3Z(float z)
	{
		this.p3.setZ(z); return this;
	}
	
	public Point3 getP1(Point3 res)
	{
		res = res != null ? res : new Point3();
		return res.set(this.p1);
	}
	
	public Point3 getP2(Point3 res)
	{
		res = res != null ? res : new Point3();
		return res.set(this.p2);
	}
	
	public Point3 getP3(Point3 res)
	{
		res = res != null ? res : new Point3();
		return res.set(this.p3);
	}
	
	public float getP1X() { return this.p1.getX(); }
	
	public float getP1Y() { return this.p1.getY(); }
	
	public float getP1Z() { return this.p1.getZ(); }
	
	public float getP2X() { return this.p2.getX(); }
	
	public float getP2Y() { return this.p2.getY(); }
	
	public float getP2Z() { return this.p2.getZ(); }
	
	public float getP3X() { return this.p3.getX(); }
	
	public float getP3Y() { return this.p3.getY(); }
	
	public float getP3Z() { return this.p3.getZ(); }
	
	public Vec3 getSideP1P2(Vec3 res) { return this.p2.sub(this.p1, res); }
	
	public Vec3 getSideP2P1(Vec3 res) { return this.p1.sub(this.p2, res); }
	
	public Vec3 getSideP1P3(Vec3 res) { return this.p3.sub(this.p1, res); }
	
	public Vec3 getSideP3P1(Vec3 res) { return this.p1.sub(this.p3, res); }
	
	public Vec3 getSideP2P3(Vec3 res) { return this.p3.sub(this.p2, res); }
	
	public Vec3 getSideP3P2(Vec3 res) { return this.p2.sub(this.p3, res); }
	
	public Line3f getSideP1P2(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p1, this.p2);
	}
	
	public Line3f getSideP2P1(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p2, this.p1);
	}
	
	public Line3f getSideP1P3(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p1, this.p3);
	}
	
	public Line3f getSideP3P1(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p3, this.p1);
	}
	
	public Line3f getSideP2P3(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p2, this.p3);
	}
	
	public Line3f getSideP3P2(Line3f res)
	{
		res = res != null ? res : new Line3f();
		
		return res.set(this.p3, this.p2);
	}
	
	public float getSquaredLengthSideP1P2()
	{
		Vec3 v = Vec3Pool.get(this.p2);
		float sqlength = v.sub(this.p1).squaredLength();
		Vec3Pool.store(v);
		return sqlength;
	}
	
	public float getSquaredLengthSideP1P3()
	{
		Vec3 v = Vec3Pool.get(this.p3);
		float sqlength = v.sub(this.p1).squaredLength();
		Vec3Pool.store(v);
		return sqlength;
	}

	public float getSquaredLengthSideP2P3()
	{
		Vec3 v = Vec3Pool.get(this.p3);
		float sqlength = v.sub(this.p2).squaredLength();
		Vec3Pool.store(v);
		return sqlength;
	}

	public float getLengthSideP1P2()
	{
		return (float)Maths.sqrt(getSquaredLengthSideP1P2());
	}
	
	public float getLengthSideP1P3()
	{
		return (float)Maths.sqrt(getSquaredLengthSideP1P3());
	}
	
	public float getLengthSideP2P3()
	{
		return (float)Maths.sqrt(getSquaredLengthSideP2P3());
	}
	
	public float getArea()
	{
		float aq = getSquaredLengthSideP2P3();
		float bq = getSquaredLengthSideP1P3();
		float cq = getSquaredLengthSideP1P2();
	
		if(aq == 0 || bq == 0 || cq == 0) return 0.0f;
		
		if(aq == bq && bq == cq)
		{
			
			double a = Maths.sqrt(aq);
			
			return (float)(Maths.INV_SQRT3 * 0.25 * a * a);
		}
		else
		{
			double a = Maths.sqrt(aq);
			double b = Maths.sqrt(bq);
			double c = Maths.sqrt(cq);
			double s = (a + b + c) * 0.5;
			return (float)(Maths.sqrt(s * (s - a ) * (s - b) * (s - c)));
		}
	}
	@Override
	public Point3[] getPoints()
	{
		return new Point3[] {
			new Point3(this.p1),
			new Point3(this.p2),
			new Point3(this.p3)
		};
	}

	public Triangle3f transform(Mat4f t, Triangle3f res)
	{
		res = res != null ? res : new Triangle3f();
		
		Point3 p1 = getP1(null);
		Point3 p2 = getP2(null);
		Point3 p3 = getP3(null);

		t.transform(p1, p1);
		t.transform(p2, p2);
		t.transform(p3, p3);

		return res.set(p1,p2,p3);
	}
}
