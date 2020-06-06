package org.barghos.math.geometry;

import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.math.Maths;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.vec3.Vec3;
import org.barghos.math.vector.vec3.Vec3Pool;

public class Line3 implements FiniteGeometricObject3
{
	protected final Point3 p1 = new Point3();
	protected final Point3 p2 = new Point3();

	public Line3() { }
	
	public Line3(Line3 l)
	{
		set(l);
	}
	
	public Line3(Tup3fR p1, Tup3fR p2)
	{
		set(p1, p2);
	}
	
	public Line3(Tup3fR p1, float x2, float y2, float z2)
	{
		set(p1, x2, y2, z2);
	}
	
	public Line3(float x1, float y1, float z1, Tup3fR p2)
	{
		set(x1, y1, z1, p2);
	}
	public Line3(float x1, float y1, float z1, float x2, float y2, float z2)
	{
		set(x1, y1, z1, x2, y2, z2);
	}
	
	public Point3 getP1(Point3 res)
	{
		if(res == null) res = new Point3();
		return res.set(this.p1);
	}
	
	public Vec3 getP1(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.p1);
	}
	
	public Point3 getP2(Point3 res)
	{
		if(res == null) res = new Point3();
		return res.set(this.p2);
	}
	
	public Vec3 getP2(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.p2);
	}
	
	public float getX1()
	{
		return this.p1.getX();
	}
	
	public float getX2()
	{
		return this.p2.getX();
	}
	
	public float getY1()
	{
		return this.p1.getY();
	}
	
	public float getY2()
	{
		return this.p2.getY();
	}
	
	public float getZ1()
	{
		return this.p1.getZ();
	}
	
	public float getZ2()
	{
		return this.p2.getZ();
	}
	
	public Line3 set(Line3 l)
	{
		l.getP1(this.p1);
		l.getP2(this.p2);
		return this;
	}
	
	public Line3 set(Tup3fR p1, Tup3fR p2)
	{
		return setP1(p1).setP2(p2);
	}
	
	public Line3 set(Tup3fR p1, float x2, float y2, float z2)
	{
		return setP1(p1).setP2(x2, y2, z2);
	}
	
	public Line3 set(float x1, float y1, float z1, Tup3fR p2)
	{
		return setP1(x1, y1, z1).setP2(p2);
	}
	
	public Line3 set(float x1, float y1, float z1, float x2, float y2, float z2)
	{
		return setP1(x1, y1, z1).setP2(x2, y2, z2);
	}
	
	public Line3 setP1(Tup3fR p)
	{
		this.p1.set(p);
		return this;
	}
	
	public Line3 setP1(float x, float y, float z)
	{
		return this;
	}
	
	public Line3 setP2(Tup3fR p)
	{
		this.p2.set(p);
		return this;
	}
	
	public Line3 setP2(float x, float y, float z)
	{
		this.p2.set(x, y, z);
		return this;
	}
	
	public float squaredLength()
	{
		Vec3 v = this.p2.sub(this.p1, Vec3Pool.get());
		float sqlength = v.squaredLength();
		Vec3Pool.store(v);
		
		return sqlength;
	}
	
	public float length()
	{
		return (float)Maths.sqrt(squaredLength());
	}
	
	public Vec3 vector(Vec3 res)
	{
		if(res == null) res = new Vec3();
		
		return this.p2.sub(this.p1, res);
	}
	
	public Vec3 vector()
	{
		return this.p2.subN(this.p1);
	}

	@Override
	public Point3[] getPoints()
	{
		return new Point3[] {
			new Point3(p1),
			new Point3(p2)
		};
	}
	
	public String toString()
	{
		return "line3(p1=" + this.p1 + ", p2=" + this.p2 + ")";
	}
}
