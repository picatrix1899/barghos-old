package org.barghos.math.matrix;

import org.barghos.core.tuple.tuple3.Tup3f;
import org.barghos.core.tuple.tuple3.Tup3fPool;
import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.math.vector.vec3.Vec3;

public class Mat3f
{
	public final float[][] m = new float[3][3];
	
	public Mat3f() {  }
	public Mat3f(Mat3f m) { assert(m != null); set(m); }
	
	public Mat3f set(Mat3f m)
	{
		assert(m != null);
		Tup3f t = Tup3fPool.get();
		setRow(0, m.getRow(0, t));
		setRow(1, m.getRow(1, t));
		setRow(2, m.getRow(2, t));
		Tup3fPool.store(t);
		return this;
	}
	
	public Mat3f identity()
	{
		this.m[0][0] = 1.0f; this.m[0][1] = 0.0f;
		this.m[1][0] = 0.0f; this.m[1][1] = 1.0f;
		return this;
	}

	public Mat3f zero()
	{
		this.m[0][0] = 0.0f; this.m[0][1] = 0.0f;
		this.m[1][0] = 0.0f; this.m[1][1] = 0.0f;
		return this;
	}
	
	public Mat3f setRow(int index, Tup3fR t)
	{
		assert(t != null);
		this.m[index][0] = t.getX();
		this.m[index][1] = t.getY();
		this.m[index][2] = t.getZ();
		return this;
	}
	
	public Mat3f setColumn(int index, Tup3fR t)
	{
		assert(t != null);
		this.m[0][index] = t.getX();
		this.m[1][index] = t.getY();
		this.m[2][index] = t.getZ();
		return this;
	}

	public Tup3f getRow(int index) { return new Tup3f(this.m[index][0], this.m[index][1], this.m[index][2]); }
	public Tup3f getColumn(int index) { return new Tup3f(this.m[0][index], this.m[1][index], this.m[2][index]); }
	
	public Tup3f getRow(int index, Tup3f res)
	{
		res = res != null ? res : new Tup3f();
		return res.set(this.m[index][0], this.m[index][1], this.m[index][2]);
	}
	
	public Tup3f getColumn(int index, Tup3f res)
	{
		res = res != null ? res : new Tup3f();
		return res.set(this.m[0][index], this.m[1][index], this.m[2][index]);
	}
	
	public Vec3 getRow(int index, Vec3 res)
	{
		res = res != null ? res : new Vec3();
		return res.set(this.m[index][0], this.m[index][1], this.m[index][2]);
	}
	public Vec3 getColumn(int index, Vec3 res)
	{
		res = res != null ? res : new Vec3();
		return res.set(this.m[0][index], this.m[1][index], this.m[2][index]);
	}

	public static float determinant(Mat3f m)
	{
		assert(m != null);
		return MatUtils.det3x3( m.m[0][0], m.m[0][1], m.m[0][2],
								m.m[1][0], m.m[1][1], m.m[1][2],
								m.m[2][0], m.m[2][1], m.m[2][2]);
	}
	
	public static Mat3f swap(Mat3f m, Mat3f res)
	{
		assert(m != null);
		res = res != null ? res : new Mat3f();
		
		Tup3f r0 = m.getRow(0);
		Tup3f r1 = m.getRow(1);

		return res.setColumn(0, r0).setColumn(1, r1);
	}
}
