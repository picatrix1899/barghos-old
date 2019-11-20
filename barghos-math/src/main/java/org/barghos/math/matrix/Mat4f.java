package org.barghos.math.matrix;

import org.barghos.core.tuple.tuple2.Tup2fR;
import org.barghos.core.tuple.tuple3.Tup3f;
import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.core.tuple.tuple4.Tup4f;
import org.barghos.core.tuple.tuple4.Tup4fPool;
import org.barghos.core.tuple.tuple4.Tup4fR;
import org.barghos.math.Maths;
import org.barghos.math.point.Point3;
import org.barghos.math.vector.Quat;
import org.barghos.math.vector.vec3.Vec3;
import org.barghos.math.vector.vec4.Vec4;


public class Mat4f
{	
	public static final Mat4f IDENTITY = Mat4f.identity();
	
	public final float[][] m = new float[4][4];
	
	public Mat4f() {  }
	public Mat4f(Mat4f m) { assert(m != null); set(m); }
	
	public Mat4f set(Mat4f m)
	{
		assert(m != null);
	
		int r = 0, c;
		for(; r < 4; r++)
		{
			c = 0;
			for(; c < 4; c++)
			{
				this.m[r][c] = m.m[r][c];
			}
		}

		return this;
	}
	
	public Mat4f initIdentity()
	{
		setRow(0, 1.0f, 0.0f, 0.0f, 0.0f);
		setRow(1, 0.0f, 1.0f, 0.0f, 0.0f);
		setRow(2, 0.0f, 0.0f, 1.0f, 0.0f);
		setRow(3, 0.0f, 0.0f, 0.0f, 1.0f);
		
		return this;
	}

	public Mat4f initZero()
	{
		setRow(0, 0.0f, 0.0f, 0.0f, 0.0f);
		setRow(1, 0.0f, 0.0f, 0.0f, 0.0f);
		setRow(2, 0.0f, 0.0f, 0.0f, 0.0f);
		setRow(3, 0.0f, 0.0f, 0.0f, 0.0f);
		return this;
	}
	
	public Mat4f initScaling(Tup3fR t)
	{
		assert(t != null);
		return initScaling(t.getX(), t.getY(), t.getZ());
	}
	
	public Mat4f initScaling(float x, float y, float z)
	{
		setRow(0, x,	0.0f,	0.0f, 	0.0f);
		setRow(1, 0.0f,	y,		0.0f, 	0.0f);
		setRow(2, 0.0f,	0.0f,	z, 		0.0f);
		setRow(3, 0.0f,	0.0f,	0.0f, 	1.0f);
		return this;
	}
	
	public Mat4f initTranslation(Tup3fR t)
	{
		assert(t != null);
		return initTranslation(t.getX(), t.getY(), t.getZ());
	}
	
	public Mat4f initTranslation(float x, float y, float z)
	{
		setRow(0, 1.0f, 0.0f, 0.0f, x	);
		setRow(1, 0.0f, 1.0f, 0.0f, y	);
		setRow(2, 0.0f, 0.0f, 1.0f, z	);
		setRow(3, 0.0f, 0.0f, 0.0f, 1.0f);
		
		return this;
	}
	
	public Mat4f initPerspective(Tup2fR t, float fov, float near, float far)
	{
		assert(t != null);
		return initPerspective(t.getX(), t.getY(), fov, near, far);
	}
	
	public Mat4f initPerspective(float width, float height, float fovY, float near, float far)
	{
		float y_scale = 1.0f / (float)Math.tan(fovY * 0.5 * Maths.DEG_TO_RAD);
		float x_scale = y_scale / (width / height);

		setRow(0, x_scale,	0f,			0f,								0f								);
		setRow(1, 0f,		y_scale,	0f,								0f								);
		setRow(2, 0f,		0f,			-(far + near) / (far - near),	-2f * near * far / (far - near)	);
		setRow(3, 0f,		0f,			-1f,							0f								);
		
		return this;
	}
	
	public Mat4f initPerspective(float fovX, float fovY, float near, float far)
	{
		float y_scale = 1.0f / (float)Math.tan(fovY * 0.5 * Maths.DEG_TO_RAD);
		float x_scale = 1.0f / (float)Math.tan(fovX * 0.5 * Maths.DEG_TO_RAD);

		setRow(0, x_scale,	0f,			0f,								0f								);
		setRow(1, 0f,		y_scale,	0,								0f								);
		setRow(2, 0f,		0f,			-(far + near) / (far - near),	-2f * near * far / (far - near)	);
		setRow(3, 0f,		0f,			-1f,							0f								);
		
		return this;
	}
	
	public Mat4f initPerspective(float left, float right, float bottom, float top, float near, float far)
	{
		setRow(0, 2f * near / (right - left),		0f,									0f,									0f	);
		setRow(1, 0f,								2f * near / (top - bottom),			0f,									0f	);
		setRow(2, (right + left) / (right - left),	(top + bottom) / (top - bottom),	-(far + near) / (far - near),		-1f	);
		setRow(3, 0f,								0f,									-2f * far * near / (far - near),	0f	);
		
		return this;
	}
	
	public Mat4f initOrtho(Tup2fR t, float near, float far)
	{
		assert(t != null);
		return initOrtho(t.getX(), t.getY(), near, far);
	}
	
	public Mat4f initOrtho(float width, float height, float near, float far)
	{
		setRow(0, 2.0f / width,	0f,				0f,						0f);
		setRow(1, 0f,			2.0f / height,	0f,						0f);
		setRow(2, 0f,			0f, 			-2.0f / (far - near),	0f);
		setRow(3, 0f,			0f,				0f,						1f);
		
		return this;
	}
	
	public Mat4f initOrtho(float left, float right, float bottom, float top, float near, float far)
	{
		setRow(0, 2.0f / (right - left),				0f,									0f,								0f);
		setRow(1, 0f,									2.0f / (top - bottom),				0f,								0f);
		setRow(2, 0f,									0f, 								-2.0f / (far - near),			0f);
		setRow(3, -(right + left) / (right - left),		-(top + bottom) / (top - bottom),	-(far + near) / (far - near), 	1f);
		 
		return this;
	}
	
	public Mat4f initRotation(Quat q)
	{
		assert(q != null);
		this.m[0][0] = 1.0f - 2.0f	*	(q.getY() * q.getY() + q.getZ() * q.getZ());
		this.m[0][1] = 2.0f			*	(q.getX() * q.getY() - q.getW() * q.getZ());
		this.m[0][2] = 2.0f			*	(q.getX() * q.getZ() + q.getW() * q.getY());
		this.m[0][3] = 0.0f;
		
		this.m[1][0] = 2.0f			*	(q.getX() * q.getY() + q.getW() * q.getZ());
		this.m[1][1] = 1.0f - 2.0f	*	(q.getX() * q.getX() + q.getZ() * q.getZ());
		this.m[1][2] = 2.0f			*	(q.getY() * q.getZ() - q.getW() * q.getX());
		this.m[1][3] = 0.0f;
		
		this.m[2][0] = 2.0f			*	(q.getX() * q.getZ() - q.getW() * q.getY());
		this.m[2][1] = 2.0f			*	(q.getY() * q.getZ() + q.getW() * q.getX());
		this.m[2][2] = 1.0f - 2.0f	*	(q.getX() * q.getX() + q.getY() * q.getY());
		this.m[2][3] = 0.0f;
		
		setRow(3, 0.0f, 0.0f, 0.0f, 1.0f);

		return this;
	}
	
	public Mat4f initModelMatrix(Tup3fR pos, Quat rot, Tup3fR scale)
	{
		assert(pos != null);
		assert(rot != null);
		if(scale == null) scale = new Tup3f(1.0f);
		
		initIdentity();
		
		rotate(rot);
		translate(pos);
		scale(scale);

		return this;
	}
	
	public Mat4f initViewMatrix(Tup3fR pos, Quat rot)
	{
		assert(pos != null);
		assert(rot != null);
		initIdentity();
		
		translate(-pos.getX(), -pos.getY(), -pos.getZ());
		rotate(rot.conjugate(null));
		
		return this;
	}
	
	public Mat4f setRow(int index, Tup4fR t)
	{
		assert(t != null);
		return setRow(index, t.getX(), t.getY(), t.getZ(), t.getW());
	}
	
	public Mat4f setRow(int index, float x, float y, float z, float w)
	{
		this.m[index][0] = x;
		this.m[index][1] = y;
		this.m[index][2] = z;
		this.m[index][3] = w;
		return this;
	}
	
	public Mat4f setColumn(int index, Tup4fR t) { assert(t != null); return setColumn(index, t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	public Mat4f setColumn(int index, float x, float y, float z, float w)
	{
		this.m[0][index] = x;
		this.m[1][index] = y;
		this.m[2][index] = z;
		this.m[3][index] = w;
		return this;
	}

	public Tup4f getRow(int index) { return new Tup4f(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]); }
	public Tup4f getColumn(int index) { return new Tup4f(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]); }
	
	public Tup4f getRow(int index, Tup4f res)
	{
		if(res == null) res = new Tup4f();
		return res.set(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]);
	}
	
	public Tup4f getColumn(int index, Tup4f res)
	{
		if(res == null) res = new Tup4f();
		return res.set(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]);
	}
	
	public Vec4 getRow(int index, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]);
	}
	public Vec4 getColumn(int index, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]);
	}
	
	public float determinant()
	{
		return MatUtils.det4x4(	this.m[0][0], this.m[0][1], this.m[0][2], this.m[0][3],
								this.m[1][0], this.m[1][1], this.m[1][2], this.m[1][3],
								this.m[2][0], this.m[2][1], this.m[2][2], this.m[2][3],
								this.m[3][0], this.m[3][1], this.m[3][2], this.m[3][3]);
	}
	
	public Mat4f transpose()
	{
		Tup4f r0 = getRow(0, Tup4fPool.get());
		Tup4f r1 = getRow(1, Tup4fPool.get());
		Tup4f r2 = getRow(2, Tup4fPool.get());
		Tup4f r3 = getRow(3, Tup4fPool.get());
		
		setColumn(0, r0).setColumn(1, r1).setColumn(2, r2).setColumn(3, r3);
		
		Tup4fPool.store(r0, r1, r2, r3);
		
		return this;
	}
	
	public static Mat4f mul(Mat4f l, Mat4f r, Mat4f res)
	{
		assert(l != null);
		assert(r != null);
		
		if(res == null) res = new Mat4f();
		
		
		float[][] m_ = new float[4][4];
		
		int row = 0;
		for(; row < 4; row++)
		{
			m_[row][0] = l.m[row][0] * r.m[0][0] + l.m[row][1] * r.m[1][0] + l.m[row][2] * r.m[2][0] + l.m[row][3] * r.m[3][0];
			m_[row][1] = l.m[row][0] * r.m[0][1] + l.m[row][1] * r.m[1][1] + l.m[row][2] * r.m[2][1] + l.m[row][3] * r.m[3][1];
			m_[row][2] = l.m[row][0] * r.m[0][2] + l.m[row][1] * r.m[1][2] + l.m[row][2] * r.m[2][2] + l.m[row][3] * r.m[3][2];
			m_[row][3] = l.m[row][0] * r.m[0][3] + l.m[row][1] * r.m[1][3] + l.m[row][2] * r.m[2][3] + l.m[row][3] * r.m[3][3];
		}
		
		row = 0;
		int c;
		for(; row < 4; row++)
		{
			c = 0;
			for(; c < 4; c++)
			{
				res.m[row][c] = m_[row][c];
			}
		}
		
		return res;
	}
	
	public Mat4f mul(Mat4f m2, Mat4f res)
	{
		assert(m2 != null);
		return Mat4f.mul(this, m2, res);
	}
	
	public static Vec3 transform(Mat4f l, Tup3fR r, Vec3 res)
	{
		assert(l != null);
		assert(r != null);
		
		if(res == null) res = new Vec3();
		
		float x_ = l.m[0][0] * r.getX() + l.m[0][1] * r.getY() + l.m[0][2] * r.getZ() + l.m[0][3] * 1.0f;
		float y_ = l.m[1][0] * r.getX() + l.m[1][1] * r.getY() + l.m[1][2] * r.getZ() + l.m[1][3] * 1.0f;
		float z_ = l.m[2][0] * r.getX() + l.m[2][1] * r.getY() + l.m[2][2] * r.getZ() + l.m[2][3] * 1.0f;

		res.set(x_, y_, z_);

		return res;
	}
	
	public Vec3 transform(Tup3fR r, Vec3 res)
	{
		assert(r != null);
		return Mat4f.transform(this, r, res);
	}
	
	public static Point3 transform(Mat4f l, Tup3fR r, Point3 res)
	{
		assert(l != null);
		assert(r != null);
		
		if(res == null) res = new Point3();
		
		float x_ = l.m[0][0] * r.getX() + l.m[0][1] * r.getY() + l.m[0][2] * r.getZ() + l.m[0][3] * 1.0f;
		float y_ = l.m[1][0] * r.getX() + l.m[1][1] * r.getY() + l.m[1][2] * r.getZ() + l.m[1][3] * 1.0f;
		float z_ = l.m[2][0] * r.getX() + l.m[2][1] * r.getY() + l.m[2][2] * r.getZ() + l.m[2][3] * 1.0f;

		res.set(x_, y_, z_);

		return res;
	}
	
	public Point3 transform(Tup3fR r, Point3 res)
	{
		return Mat4f.transform(this, r, res);
	}
	
	public static Mat4f identity() { return new Mat4f().initIdentity(); }
	public static Mat4f zero() { return new Mat4f().initZero(); }
	public static Mat4f scaling(Tup3fR t) { assert(t != null); return scaling(t.getX(), t.getY(), t.getZ()); }
	public static Mat4f scaling(float x, float y, float z) { return new Mat4f().initScaling(x, y,z); }
	public static Mat4f translation(Tup3fR t) { assert(t != null); return translation(t.getX(),t.getY(), t.getZ()); }
	public static Mat4f translation(float x, float y, float z) { return new Mat4f().initTranslation(x, y, z); }
	public static Mat4f perspective(Tup2fR t, float fovY, float near, float far) { assert(t != null); return perspective(t.getX(), t.getY(), fovY, near, far); }
	public static Mat4f perspective(float width, float height, float fov, float near, float far) { return new Mat4f().initPerspective(width, height, fov, near, far); }
	public static Mat4f perspective(float fovX, float fovY, float near, float far) { return new Mat4f().initPerspective(fovX, fovY, near, far); }
	public static Mat4f perspective(float left, float right, float bottom, float top, float near, float far) { return new Mat4f().initPerspective(left, right, bottom, top, near, far); }
	public static Mat4f ortho(Tup2fR t, float near, float far) { assert(t != null); return ortho(t.getX(), t.getY(), near, far); }
	public static Mat4f ortho(float width, float height, float near, float far) { return new Mat4f().initOrtho(width, height, near, far); }
	public static Mat4f ortho(float left, float right, float bottom, float top, float near, float far) { return new Mat4f().initOrtho(left, right, bottom, top, near, far); }
	public static Mat4f rotation(Quat q) { return new Mat4f().initRotation(q); }
	public static Mat4f modelMatrix(Tup3fR pos, Quat rot, Tup3fR scale) { assert(pos != null); return new Mat4f().initModelMatrix(pos, rot, scale); }
	public static Mat4f viewMatrix(Tup3fR pos, Quat rot) { assert(pos != null); assert(rot != null); return new Mat4f().initViewMatrix(pos, rot); } 
	
	public Mat4f scale(Tup3fR t) { assert(t != null); return Mat4f.mul(Mat4f.scaling(t), this, this); }
	public Mat4f scale(float x, float y, float z) { return Mat4f.mul(Mat4f.scaling(x, y, z), this, this); }
	public Mat4f translate(Tup3fR t) { assert(t != null); return Mat4f.mul(Mat4f.translation(t), this, this); }
	public Mat4f translate(float x, float y, float z) { return Mat4f.mul(Mat4f.translation(x, y, z), this, this); }
	public Mat4f rotate(Quat q) { assert(q != null); return Mat4f.mul(Mat4f.rotation(q), this, this); }
	
	public float[] toArrayColumnMajor()
	{
		float[] out = new float[4 * 4];

		int i = 0;
		for(; i < 4; i++)
		{
			out[i * 4 + 0] = this.m[0][i];
			out[i * 4 + 1] = this.m[1][i];
			out[i * 4 + 2] = this.m[2][i];
			out[i * 4 + 3] = this.m[3][i];
		}

		return out;		
	}
	
	public float[] toArrayRowMajor()
	{
		float[] out = new float[4 * 4];

		int i = 0;
		for(; i < 4; i++)
		{
			out[i * 4 + 0] = this.m[i][0];
			out[i * 4 + 1] = this.m[i][1];
			out[i * 4 + 2] = this.m[i][2];
			out[i * 4 + 3] = this.m[i][3];
		}

		return out;		
	}
	
	public boolean isZeroMatrix()
	{
		return  this.m[0][0] == 0 && this.m[0][1] == 0 && this.m[0][2] == 0 && this.m[0][3] == 0 &&
				this.m[1][0] == 0 && this.m[1][1] == 0 && this.m[1][2] == 0 && this.m[1][3] == 0 &&
				this.m[2][0] == 0 && this.m[2][1] == 0 && this.m[2][2] == 0 && this.m[2][3] == 0 &&
				this.m[3][0] == 0 && this.m[3][1] == 0 && this.m[3][2] == 0 && this.m[3][3] == 0;
	}
	
	public boolean isIdentityMatrix()
	{
		return  this.m[0][0] == 1 && this.m[0][1] == 0 && this.m[0][2] == 0 && this.m[0][3] == 0 &&
				this.m[1][0] == 0 && this.m[1][1] == 1 && this.m[1][2] == 0 && this.m[1][3] == 0 &&
				this.m[2][0] == 0 && this.m[2][1] == 0 && this.m[2][2] == 1 && this.m[2][3] == 0 &&
				this.m[3][0] == 0 && this.m[3][1] == 0 && this.m[3][2] == 0 && this.m[3][3] == 1;
	}
	
	public String toString()
	{
		return 	"mat4f(" + this.m[0][0] + ", " + this.m[0][1] + ", " + this.m[0][2] + ", " + this.m[0][3] + "\n"
			  + "      " + this.m[1][0] + ", " + this.m[1][1] + ", " + this.m[1][2] + ", " + this.m[1][3] + "\n"
			  + "      " + this.m[2][0] + ", " + this.m[2][1] + ", " + this.m[2][2] + ", " + this.m[2][3] + "\n"
			  + "      " + this.m[3][0] + ", " + this.m[3][1] + ", " + this.m[3][2] + ", " + this.m[3][3] + ")";
	}
}
