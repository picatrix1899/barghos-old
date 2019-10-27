package org.barghos.math.vector;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.math.Maths;
import org.barghos.math.api.vector.IQuatR;
import org.barghos.math.matrix.Mat4f;

/** A 3-Dimensional Quaternion */
public class Quat implements IQuatR
{
	/** The w component. */
	public double w;
	/** The x component. */
	public double x;
	/** The y component. */
	public double y;
	/** The z component. */
	public double z;

	/**
	 * The default constructor. It sets x,y and z to 0 and w to 1.
	 * It is commonly used in pools.
	 */
	public Quat()
	{
		this(1.0, 0.0, 0.0, 0.0);
	}
	
	/**
	 * This constructor sets the components to x, y, z and w.
	 * @param w The new w component.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @param z The new z component.
	 */
	public Quat(double w, double x, double y, double z)
	{
		set(w, x, y, z);
	}
	
	/**
	 * This contructor sets the components to the values of q.
	 * @param q A Quaternion that the components are set to.
	 */
	public Quat(Quat q)
	{
		assert(q != null);
		set(q);
	}
	
	/**
	 * This constructor sets
	 * @param rot
	 */
	public Quat(Mat4f rot)
	{
		assert(rot != null);
		set(rot);
	}

	public static Quat getFromAxis(ITup3R axis, double angle) { assert(axis != null); return getFromAxis(axis.getUniX(), axis.getUniY(), axis.getUniZ(), angle); }
	
	public static Quat getFromAxis(double ax, double ay, double az, double angle)
	{
		double halfAngle = angle * 0.5 * Maths.DEG_TO_RAD;
		double sinHalfAngle = Math.sin(halfAngle);
		double cosHalfAngle = Math.cos(halfAngle);
		
		double rX = ax * sinHalfAngle;
		double rY = ay * sinHalfAngle;
		double rZ = az * sinHalfAngle;
		double rW = cosHalfAngle;
		
		return new Quat(rW, rX, rY, rZ).normal();
	}
	
	public static Quat getFromVectors(Vec3f v1, Vec3f v2)
	{
		assert(v1 != null);
		assert(v2 != null);
		
		Vec3f a = v1.normal(Vec3fPool.get());
		Vec3f b = v2.normal(Vec3fPool.get());

		Vec3f axis = Vec3f.cross(a, b, Vec3fPool.get());
		axis.normal(axis);
		
		double angle = 1.0 + Vec3f.dot(a, b);

		Quat out = new Quat(angle, axis.getX(), axis.getY(), axis.getZ()).normal();
		
		Vec3fPool.store(a, b, axis);
		
		return out;
	}
	
	public double getW() { return this.w; }
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	public double getZ() { return this.z; }

	public double getUniW() { return getW(); }
	
	public double getUniX() { return getX(); }
	
	public double getUniY() { return getY(); }
	
	public double getUniZ() { return getZ(); }
	
	public Quat rotate(ITup3R axis, double angle)
	{
		assert(axis != null);
		return rotate(angle, axis.getUniX(), axis.getUniY(), axis.getUniZ());
	}
	
	public Quat rotate(double ax, double ay, double az, double angle)
	{
		return getFromAxis(angle, ax, ay, az).mul(this, this);
	}
	
	public Quat rotate(Quat q)
	{
		assert(q != null);
		return q.mul(this, this);
	}
	
	public Quat set(Quat q) { assert(q != null); return set(q.getW(), q.getX(), q.getY(), q.getZ()); }
	
	//From Ken Shoemake's "Quaternion Calculus and Fast Animation" article
	public Quat set(Mat4f rot) 
	{
		assert(rot != null);
		double trace = rot.m[0][0] + rot.m[1][1] + rot.m[2][2];

		if(trace > 0)
		{
			double s = 0.5 / Maths.sqrt(trace + 1.0);
			this.w = 0.25 / s;
			
			
			this.x = (rot.m[1][2] - rot.m[2][1]) * s;
			this.y = (rot.m[2][0] - rot.m[0][2]) * s;
			this.z = (rot.m[0][1] - rot.m[1][0]) * s;
		}
		else
		{
			if(rot.m[0][0] > rot.m[1][1] && rot.m[0][0] > rot.m[2][2])
			{
				double s = 2.0 * Maths.sqrt(1.0 + rot.m[0][0] - rot.m[1][1] - rot.m[2][2]);
				this.w = (rot.m[1][2] - rot.m[2][1]) / s;
				this.x = 0.25 * s;
				this.y = (rot.m[1][0] + rot.m[0][1]) / s;
				this.z = (rot.m[2][0] + rot.m[0][2]) / s;
			}
			else if(rot.m[1][1] > rot.m[2][2])
			{
				double s = 2.0 * Maths.sqrt(1.0 + rot.m[1][1] - rot.m[0][0] - rot.m[2][2]);
				this.w = (rot.m[2][0] - rot.m[0][2]) / s;
				this.x = (rot.m[1][0] + rot.m[0][1]) / s;
				this.y = 0.25 * s;
				this.z = (rot.m[2][1] + rot.m[1][2]) / s;
			}
			else
			{
				double s = 2.0 * Maths.sqrt(1.0 + rot.m[2][2] - rot.m[0][0] - rot.m[1][1]);
				this.w = (rot.m[0][1] - rot.m[1][0] ) / s;
				this.x = (rot.m[2][0] + rot.m[0][2] ) / s;
				this.y = (rot.m[1][2] + rot.m[2][1] ) / s;
				this.z = 0.25 * s;
			}
		}

		normal(this);
		
		return this;
	}
	
	public Quat set(double w, double x, double y, double z) { return setW(w).setX(x).setY(y).setZ(z); }
	
	public Quat setW(double w) { this.w = w; return this; }
	
	public Quat setX(double x) { this.x = x; return this; }
	
	public Quat setY(double y) { this.y = y; return this; }
	
	public Quat setZ(double z) { this.z = z; return this; }

	public Quat conjugate()
	{
		return conjugate(this);
	}
	
	public Quat conjugate(Quat res)
	{
		res = res != null ? res : new Quat();
		
		res.set(this.w, -this.x, -this.y, -this.z);

		return res;
	}
	
	public Quat inverse()
	{
		return inverse(this);
	}
	
	public Quat inverse(Quat res)
	{
		res = res != null ? res : new Quat();
		
		double l = reciprocalLength();
		
		res.set(this.w * l, -this.x * l, -this.y * l, -this.z * l);
		
		return res;
	}
	
	public Quat mul(Quat q)
	{
		assert(q != null);
		mul(q, this);
		
		return this;
	}
	
	public Quat mul(Quat q, Quat res)
	{
		assert(q != null);
		if(res == null) res = new Quat();
		
		double w_ = this.w * q.getW() - this.x * q.getX() - this.y * q.getY() - this.z * q.getZ(); // w * w' - v * v'
		double x_ = this.w * q.getX() + q.getW() * this.x + this.y * q.getZ() - this.z * q.getY(); // s * v'.x + s' * v.x + (V x V').x
		double y_ = this.w * q.getY() + q.getW() * this.y + this.z * q.getX() - this.x * q.getZ(); // s * v'.y + s' * v.y + (V x V').y
		double z_ = this.w * q.getZ() + q.getW() * this.z + this.x * q.getY() - this.y * q.getX(); // s * v'.z + s' * v.z + (V x V').z

		res.set(w_, x_, y_, z_).normal();

		return res;
	}
	
	public Quat mul(ITup3R v)
	{
		assert(v != null);
		mul(v, this);
		
		return this;
	}
	
	public Quat mul(ITup3R v, Quat res)
	{
		assert(v != null);
		if(res == null) res = new Quat();
		
		double w_ = -this.x * v.getUniX() - this.y * v.getUniY() - this.z * v.getUniZ(); // - v * v'
		double x_ =  this.w * v.getUniX() + this.y * v.getUniZ() - this.z * v.getUniY(); // s * v'.x ...
		double y_ =  this.w * v.getUniY() + this.z * v.getUniX() - this.x * v.getUniZ(); // s * v'.y ...
		double z_ =  this.w * v.getUniZ() + this.x * v.getUniY() - this.y * v.getUniX(); // s * v*.z ...

		res.set(w_, x_, y_, z_).normal();

		return res;
	}
	
	public Vec3f transform(ITup3R v, Vec3f res)
	{
		assert(v != null);
		if(res == null) res = new Vec3f();
		
		Quat r = mul(v, QuatPool.get());
		Quat c = conjugate(QuatPool.get());
		
		r.mul(c, r);
		
		res.set(r.getX(),r.getY(), r.getZ());
		
		QuatPool.store(r, c);
		
		return res;
	}
	
	public double length() { return Maths.sqrt(squaredLength()); }
	public double squaredLength() { return this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z; }
	public double reciprocalLength() { return 1.0 / length(); }
	
	public Quat normal()
	{
		return normal(this);
	}
	
	public Quat normal(Quat res)
	{
		if(res == null) res = new Quat();
		
		double l = reciprocalLength();
		
		res.set(this.w * l, this.x * l, this.y * l, this.z * l);

		return res;
	}

	public double dot(Quat q)
	{
		return this.w * q.w + this.x * q.x + this.y * q.y + this.z * q.z;
	}
	
	@Override
	public int getDimensions()
	{
		return 4;
	}

	
	public String toString()
	{
		return "quat(" + this.w + "d " + this.x + "d " + this.y + "d " + this.z + "d)";
	}
}
