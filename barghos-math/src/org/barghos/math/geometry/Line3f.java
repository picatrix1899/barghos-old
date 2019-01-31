package org.barghos.math.geometry;

import org.barghos.core.api.tuple.ITup3R;

import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;

public class Line3f
{
	public final Point3f p1 = new Point3f();
	public final Point3f p2 = new Point3f();
	
	public Line3f() { }
	
	public Line3f(Line3f l)
	{
		assert(l != null);
		set(l);
	}
	
	public Line3f(ITup3R p1, ITup3R p2)
	{
		assert(p1 != null);
		assert(p2 != null);
		set(p1, p2);
	}
	
	public Line3f(ITup3R p1, double x2, double y2, double z2)
	{
		assert(p1 != null);
		set(p1, x2, y2, z2);
	}
	
	public Line3f(double x1, double y1, double z1, ITup3R p2)
	{
		assert(p2 != null);
		set(x1, y1, z1, p2);
	}
	public Line3f(double x1, double y1, double z1, double x2, double y2, double z2)
	{
		set(x1, y1, z1, x2, y2, z2);
	}
	
	public Point3f getP1(Point3f res)
	{
		res = res != null ? res : new Point3f();
		return res.set(this.p1);
	}
	
	public Vec3f getP1(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(this.p1);
	}
	
	public Point3f getP2(Point3f res)
	{
		res = res != null ? res : new Point3f();
		return res.set(this.p2);
	}
	
	public Vec3f getP2(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(this.p2);
	}
	
	public float getX1()
	{
		return this.p1.x;
	}
	
	public float getX2()
	{
		return this.p2.x;
	}
	
	public float getY1()
	{
		return this.p1.y;
	}
	
	public float getY2()
	{
		return this.p2.y;
	}
	
	public float getZ1()
	{
		return this.p1.z;
	}
	
	public float getZ2()
	{
		return this.p2.z;
	}
	
	public Line3f set(Line3f l)
	{
		assert(l != null);
		return setP1(l.p1).setP2(l.p2);
	}
	
	public Line3f set(ITup3R p1, ITup3R p2)
	{
		assert(p1 != null);
		assert(p2 != null);
		return setP1(p1).setP2(p2);
	}
	
	public Line3f set(ITup3R p1, double x2, double y2, double z2)
	{
		assert(p1 != null);
		return setP1(p1).setP2(x2, y2, z2);
	}
	
	public Line3f set(double x1, double y1, double z1, ITup3R p2)
	{
		assert(p2 != null);
		return setP1(x1, y1, z1).setP2(p2);
	}
	
	public Line3f set(double x1, double y1, double z1, double x2, double y2, double z2)
	{
		return setP1(x1,y1,z1).setP2(x2, y2, z2);
	}
	
	public Line3f setP1(ITup3R p)
	{
		assert(p != null);
		this.p1.set(p);
		return this;
	}
	
	public Line3f setP1(double x, double y, double z)
	{
		this.p1.set(x, y, z);
		return this;
	}
	
	public Line3f setP2(ITup3R p)
	{
		assert(p != null);
		this.p2.set(p);
		return this;
	}
	
	public Line3f setP2(double x, double y, double z)
	{
		this.p2.set(x, y, z);
		return this;
	}
	
	public double squaredLength()
	{
		float x = this.p2.x - this.p1.x;
		float y = this.p2.y - this.p1.y;
		float z = this.p2.z - this.p1.z;
		
		return x * x + y * y + z * z;
	}
	
	public double length()
	{
		return Math.sqrt(squaredLength());
	}
	
	public Vec3f vector(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		
		return Vec3f.sub(p2, p1, res);
	}
	
	public Vec3f vector()
	{
		return Vec3f.sub(p2, p1, new Vec3f());
	}
}
