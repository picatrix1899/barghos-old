package org.barghos.math.matrix;

import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.core.api.tuple.ITup3fW;
import org.barghos.core.tuple.Tup3f;

public class Mat3f
{
	public final float[][] m = new float[3][3];
	
	public Mat3f() {  }
	public Mat3f(Mat3f m) { set(m); }
	
	public Mat3f set(Mat3f m)
	{
		this.m[0][0] = m.m[0][0]; this.m[0][1] = m.m[0][1];
		this.m[1][0] = m.m[1][0]; this.m[1][1] = m.m[1][1];
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
	
	public Mat3f setRow(int index, ITup3fR t)
	{
		this.m[index][0] = t.getX();
		this.m[index][1] = t.getY();
		this.m[index][2] = t.getZ();
		return this;
	}
	
	public Mat3f setColumn(int index, ITup3fR t)
	{
		this.m[0][index] = t.getX();
		this.m[1][index] = t.getY();
		this.m[2][index] = t.getZ();
		return this;
	}

	public Tup3f getRow(int index) { return new Tup3f(this.m[index][0], this.m[index][1], this.m[index][2]); }
	public Tup3f getColumn(int index) { return new Tup3f(this.m[0][index], this.m[1][index], this.m[2][index]); }
	
	public void getRow(int index, ITup3fW t) { t.set(this.m[index][0], this.m[index][1], this.m[index][2]); }
	public void getColumn(int index, ITup3fW t) { t.set(this.m[0][index], this.m[1][index], this.m[2][index]); }
	
	public static float determinant(Mat3f m)
	{
		return MatUtils.det3x3( m.m[0][0], m.m[0][1], m.m[0][2],
								m.m[1][0], m.m[1][1], m.m[1][2],
								m.m[2][0], m.m[2][1], m.m[2][2]);
	}
	
	public static Mat3f swap(Mat3f m, Mat3f res)
	{
		res = res != null ? res : new Mat3f();
		
		Tup3f r0 = m.getRow(0);
		Tup3f r1 = m.getRow(1);

		return res.setColumn(0, r0).setColumn(1, r1);
	}
}
