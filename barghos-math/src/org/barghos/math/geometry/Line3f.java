package org.barghos.math.geometry;

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.math.Maths;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;

public class Line3f implements FiniteGeometricObject
{
	public float p1x, p1y, p1z = 0.0f;
	public float p2x, p2y, p2z = 0.0f;
	
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
		return res.set(this.p1x, this.p1y, this.p1z);
	}
	
	public Vec3f getP1(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(this.p1x, this.p1y, this.p1z);
	}
	
	public Point3f getP2(Point3f res)
	{
		res = res != null ? res : new Point3f();
		return res.set(this.p2x, this.p2y, this.p2z);
	}
	
	public Vec3f getP2(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(this.p2x, this.p2y, this.p2z);
	}
	
	public float getX1()
	{
		return this.p1x;
	}
	
	public float getX2()
	{
		return this.p2x;
	}
	
	public float getY1()
	{
		return this.p1y;
	}
	
	public float getY2()
	{
		return this.p2y;
	}
	
	public float getZ1()
	{
		return this.p1z;
	}
	
	public float getZ2()
	{
		return this.p2z;
	}
	
	public Line3f set(Line3f l)
	{
		assert(l != null);
		return setP1(l.p1x, l.p1y, l.p1z).setP2(l.p2x, l.p2y, l.p2z);
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
		return setP1(x1, y1, z1).setP2(x2, y2, z2);
	}
	
	public Line3f setP1(ITup3R p)
	{
		assert(p != null);
		this.p1x = (float)p.getUniX();
		this.p1y = (float)p.getUniY();
		this.p1z = (float)p.getUniZ();
		return this;
	}
	
	public Line3f setP1(double x, double y, double z)
	{
		this.p1x = (float)x;
		this.p1y = (float)y;
		this.p1z = (float)z;
		return this;
	}
	
	public Line3f setP2(ITup3R p)
	{
		assert(p != null);
		this.p2x = (float)p.getUniX();
		this.p2y = (float)p.getUniY();
		this.p2z = (float)p.getUniZ();
		return this;
	}
	
	public Line3f setP2(double x, double y, double z)
	{
		this.p2x = (float)x;
		this.p2y = (float)y;
		this.p2z = (float)z;
		return this;
	}
	
	public double squaredLength()
	{
		float x = this.p2x - this.p1x;
		float y = this.p2y - this.p1y;
		float z = this.p2z - this.p1z;
		
		return x * x + y * y + z * z;
	}
	
	public double length()
	{
		return Maths.sqrt(squaredLength());
	}
	
	public Vec3f vector(Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		
		return Vec3f.sub(p2x, p2y, p2z, p1x, p1y, p1z, res);
	}
	
	public Vec3f vector()
	{
		return Vec3f.sub(p2x, p2y, p2z, p1x, p1y, p1z, new Vec3f());
	}

	@Override
	public Point3f[] getPoints()
	{
		return new Point3f[] {
			new Point3f(p1x, p1y, p1z),
			new Point3f(p2x, p2y, p2z)
		};
	}
}
