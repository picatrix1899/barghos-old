package org.barghos.math.matrix;

import org.barghos.core.api.tuple.ITup2R;
import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.api.tuple.ITup4fW;
import org.barghos.core.tuple.Tup3f;
import org.barghos.core.tuple.Tup4f;
import org.barghos.core.tuple.Tup4fPool;
import org.barghos.math.Maths;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Quat;
import org.barghos.math.vector.Vec3f;
import org.barghos.math.vector.Vec4f;

public class Mat4f
{	
	public final float[][] m = new float[4][4];
	
	public Mat4f() {  }
	public Mat4f(Mat4f m) { assert(m != null); set(m); }
	
	public Mat4f set(Mat4f m)
	{
		assert(m != null);
		Tup4f t = Tup4fPool.get();
		setRow(0, m.getRow(0, t));
		setRow(1, m.getRow(1, t));
		setRow(2, m.getRow(2, t));
		setRow(3, m.getRow(3, t));
		Tup4fPool.store(t);
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
	
	public Mat4f initScaling(ITup3R t)
	{
		assert(t != null);
		return initScaling(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public Mat4f initScaling(double x, double y, double z)
	{
		setRow(0, x,	0.0f,	0.0f, 	0.0f);
		setRow(1, 0.0f,	y,		0.0f, 	0.0f);
		setRow(2, 0.0f,	0.0f,	z, 		0.0f);
		setRow(3, 0.0f,	0.0f,	0.0f, 	1.0f);
		return this;
	}
	
	public Mat4f initTranslation(ITup3R t)
	{
		assert(t != null);
		return initTranslation(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public Mat4f initTranslation(double x, double y, double z)
	{
		setRow(0, 1.0f, 0.0f, 0.0f, x	);
		setRow(1, 0.0f, 1.0f, 0.0f, y	);
		setRow(2, 0.0f, 0.0f, 1.0f, z	);
		setRow(3, 0.0f, 0.0f, 0.0f, 1.0f);
		
		return this;
	}
	
	public Mat4f initPerspective(ITup2R t, double fov, double near, double far)
	{
		assert(t != null);
		return initPerspective(t.getUniX(), t.getUniY(), fov, near, far);
	}
	
	public Mat4f initPerspective(double width, double height, double fovY, double near, double far)
	{
		float y_scale = (float)(1.0 / Math.tan(fovY * 0.5 * Maths.DEG_TO_RAD));
		float x_scale = (float)(y_scale / (width / height));

		setRow(0, x_scale,	0,			0,								0								);
		setRow(1, 0,		y_scale,	0,								0								);
		setRow(2, 0,		0,			-(far + near) / (far - near),	-2 * near * far / (far - near)	);
		setRow(3, 0,		0,			-1,	0															);
		
		return this;
	}
	
	public Mat4f initPerspective(double fovX, double fovY, double near, double far)
	{
		float y_scale = (float)(1.0 / Math.tan(fovY * 0.5 * Maths.DEG_TO_RAD));
		float x_scale = (float)(1.0 / Math.tan(fovX * 0.5 * Maths.DEG_TO_RAD));

		setRow(0, x_scale,	0,			0,								0								);
		setRow(1, 0,		y_scale,	0,								0								);
		setRow(2, 0,		0,			-(far + near) / (far - near),	-2 * near * far / (far - near)	);
		setRow(3, 0,		0,			-1,	0															);
		
		return this;
	}
	
	public Mat4f initPerspective(double left, double right, double bottom, double top, double near, double far)
	{
		setRow(0, 2 * near / (right - left),		0,									0,								0	);
		setRow(1, 0,								2 * near / (top - bottom),			0,								0	);
		setRow(2, (right + left) / (right - left),	(top + bottom) / (top - bottom),	-(far + near) / (far - near),	-1	);
		setRow(3, 0,								0,									-2 * far * near / (far - near),	0	);
		
		return this;
	}
	
	public Mat4f initOrtho(ITup2R t, double near, double far)
	{
		assert(t != null);
		return initOrtho(t.getUniX(), t.getUniY(), near, far);
	}
	
	public Mat4f initOrtho(double width, double height, double near, double far)
	{
		setRow(0, 2.0 / width,	0,				0,						0);
		setRow(1, 0,			2.0 / height,	0,						0);
		setRow(2, 0,			0, 				-2.0 / (far - near),	0);
		setRow(3, 0,			0,				0,						1);
		
		return this;
	}
	
	public Mat4f initOrtho(double left, double right, double bottom, double top, double near, double far)
	{
		setRow(0, 2.0 / (right - left),				0,									0,								0);
		setRow(1, 0,								2.0 / (top - bottom),				0,								0);
		setRow(2, 0,								0, 									-2.0 / (far - near),			0);
		setRow(3, -(right + left) / (right - left),	-(top + bottom) / (top - bottom),	-(far + near) / (far - near), 	1);
		 
		return this;
	}
	
	public Mat4f initRotation(Quat q)
	{
		assert(q != null);
		this.m[0][0] = (float)(1.0 - 2.0	*	(q.getY() * q.getY() + q.getZ() * q.getZ()));
		this.m[0][1] = (float)(2.0			*	(q.getX() * q.getY() - q.getW() * q.getZ()));
		this.m[0][2] = (float)(2.0			*	(q.getX() * q.getZ() + q.getW() * q.getY()));
		this.m[0][3] = (float)(0.0);
		
		this.m[1][0] = (float)(2.0			*	(q.getX() * q.getY() + q.getW() * q.getZ()));
		this.m[1][1] = (float)(1.0 - 2.0	*	(q.getX() * q.getX() + q.getZ() * q.getZ()));
		this.m[1][2] = (float)(2.0			*	(q.getY() * q.getZ() - q.getW() * q.getX()));
		this.m[1][3] = (float)(0.0);
		
		this.m[2][0] = (float)(2.0			*	(q.getX() * q.getZ() - q.getW() * q.getY()));
		this.m[2][1] = (float)(2.0			*	(q.getY() * q.getZ() + q.getW() * q.getX()));
		this.m[2][2] = (float)(1.0 - 2.0	*	(q.getX() * q.getX() + q.getY() * q.getY()));
		this.m[2][3] = (float)(0.0);
		
		setRow(3, 0.0, 0.0, 0.0, 1.0);

		return this;
	}
	
	public Mat4f initModelMatrix(ITup3R pos, Quat rot, ITup3R scale)
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
	
	public Mat4f initViewMatrix(ITup3R pos, Quat rot)
	{
		assert(pos != null);
		assert(rot != null);
		initIdentity();
		
		translate(-pos.getUniX(), -pos.getUniY(), -pos.getUniZ());
		rotate(rot.conjugate(null));
		
		return this;
	}
	
	public Mat4f setRow(int index, ITup4R t)
	{
		assert(t != null);
		return setRow(index, t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW());
	}
	
	public Mat4f setRow(int index, double x, double y, double z, double w)
	{
		this.m[index][0] = (float)x;
		this.m[index][1] = (float)y;
		this.m[index][2] = (float)z;
		this.m[index][3] = (float)w;
		return this;
	}
	
	public Mat4f setColumn(int index, ITup4R t) { assert(t != null); return setColumn(index, t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	
	public Mat4f setColumn(int index, double x, double y, double z, double w)
	{
		this.m[0][index] = (float)x;
		this.m[1][index] = (float)y;
		this.m[2][index] = (float)z;
		this.m[3][index] = (float)w;
		return this;
	}

	public Tup4f getRow(int index) { return new Tup4f(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]); }
	public Tup4f getColumn(int index) { return new Tup4f(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]); }
	
	public Tup4f getRow(int index, Tup4f res)
	{
		res = res != null ? res : new Tup4f();
		return res.set(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]);
	}
	
	public Tup4f getColumn(int index, Tup4f res)
	{
		res = res != null ? res : new Tup4f();
		return res.set(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]);
	}
	
	public Vec4f getRow(int index, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]);
	}
	public Vec4f getColumn(int index, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]);
	}
	
	public void getRow(int index, ITup4fW t) { assert(t != null); t.set(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]); }
	public void getColumn(int index, ITup4fW t) { assert(t != null); t.set(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]); }
	
	
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
		res = res != null ? res : new Mat4f();
		
		float m0x_ = l.m[0][0] * r.m[0][0] + l.m[0][1] * r.m[1][0] + l.m[0][2] * r.m[2][0] + l.m[0][3] * r.m[3][0];
		float m0y_ = l.m[0][0] * r.m[0][1] + l.m[0][1] * r.m[1][1] + l.m[0][2] * r.m[2][1] + l.m[0][3] * r.m[3][1];
		float m0z_ = l.m[0][0] * r.m[0][2] + l.m[0][1] * r.m[1][2] + l.m[0][2] * r.m[2][2] + l.m[0][3] * r.m[3][2];
		float m0w_ = l.m[0][0] * r.m[0][3] + l.m[0][1] * r.m[1][3] + l.m[0][2] * r.m[2][3] + l.m[0][3] * r.m[3][3];
		
		float m1x_ = l.m[1][0] * r.m[0][0] + l.m[1][1] * r.m[1][0] + l.m[1][2] * r.m[2][0] + l.m[1][3] * r.m[3][0];
		float m1y_ = l.m[1][0] * r.m[0][1] + l.m[1][1] * r.m[1][1] + l.m[1][2] * r.m[2][1] + l.m[1][3] * r.m[3][1];
		float m1z_ = l.m[1][0] * r.m[0][2] + l.m[1][1] * r.m[1][2] + l.m[1][2] * r.m[2][2] + l.m[1][3] * r.m[3][2];
		float m1w_ = l.m[1][0] * r.m[0][3] + l.m[1][1] * r.m[1][3] + l.m[1][2] * r.m[2][3] + l.m[1][3] * r.m[3][3];
		
		float m2x_ = l.m[2][0] * r.m[0][0] + l.m[2][1] * r.m[1][0] + l.m[2][2] * r.m[2][0] + l.m[2][3] * r.m[3][0];
		float m2y_ = l.m[2][0] * r.m[0][1] + l.m[2][1] * r.m[1][1] + l.m[2][2] * r.m[2][1] + l.m[2][3] * r.m[3][1];
		float m2z_ = l.m[2][0] * r.m[0][2] + l.m[2][1] * r.m[1][2] + l.m[2][2] * r.m[2][2] + l.m[2][3] * r.m[3][2];
		float m2w_ = l.m[2][0] * r.m[0][3] + l.m[2][1] * r.m[1][3] + l.m[2][2] * r.m[2][3] + l.m[2][3] * r.m[3][3];
		
		float m3x_ = l.m[3][0] * r.m[0][0] + l.m[3][1] * r.m[1][0] + l.m[3][2] * r.m[2][0] + l.m[3][3] * r.m[3][0];
		float m3y_ = l.m[3][0] * r.m[0][1] + l.m[3][1] * r.m[1][1] + l.m[3][2] * r.m[2][1] + l.m[3][3] * r.m[3][1];
		float m3z_ = l.m[3][0] * r.m[0][2] + l.m[3][1] * r.m[1][2] + l.m[3][2] * r.m[2][2] + l.m[3][3] * r.m[3][2];
		float m3w_ = l.m[3][0] * r.m[0][3] + l.m[3][1] * r.m[1][3] + l.m[3][2] * r.m[2][3] + l.m[3][3] * r.m[3][3];
		
		res.setRow(0, m0x_, m0y_, m0z_, m0w_);
		res.setRow(1, m1x_, m1y_, m1z_, m1w_);
		res.setRow(2, m2x_, m2y_, m2z_, m2w_);
		res.setRow(3, m3x_, m3y_, m3z_, m3w_);
		
		return res;
	}
	
	public Mat4f mul(Mat4f m2, Mat4f res)
	{
		assert(m2 != null);
		return Mat4f.mul(this, m2, res);
	}
	
	public static Vec3f transform(Mat4f l, ITup3R r, Vec3f res)
	{
		assert(l != null);
		assert(r != null);
		res = res != null ? res : new Vec3f();
		
		float x_ = (float)(l.m[0][0] * r.getUniX() + l.m[0][1] * r.getUniY() + l.m[0][2] * r.getUniZ() + l.m[0][3] * 1.0);
		float y_ = (float)(l.m[1][0] * r.getUniX() + l.m[1][1] * r.getUniY() + l.m[1][2] * r.getUniZ() + l.m[1][3] * 1.0);
		float z_ = (float)(l.m[2][0] * r.getUniX() + l.m[2][1] * r.getUniY() + l.m[2][2] * r.getUniZ() + l.m[2][3] * 1.0);

		res.set(x_, y_, z_);

		return res;
	}
	
	public Vec3f transform(ITup3R r, Vec3f res)
	{
		assert(r != null);
		return Mat4f.transform(this, r, res);
	}
	
	public static Point3f transform(Mat4f l, ITup3R r, Point3f res)
	{
		assert(l != null);
		assert(r != null);
		res = res != null ? res : new Point3f();
		
		float x_ = (float)(l.m[0][0] * r.getUniX() + l.m[0][1] * r.getUniY() + l.m[0][2] * r.getUniZ() + l.m[0][3] * 1.0);
		float y_ = (float)(l.m[1][0] * r.getUniX() + l.m[1][1] * r.getUniY() + l.m[1][2] * r.getUniZ() + l.m[1][3] * 1.0);
		float z_ = (float)(l.m[2][0] * r.getUniX() + l.m[2][1] * r.getUniY() + l.m[2][2] * r.getUniZ() + l.m[2][3] * 1.0);

		res.set(x_, y_, z_);

		return res;
	}
	
	public Point3f transform(ITup3R r, Point3f res)
	{
		return Mat4f.transform(this, r, res);
	}
	
	public static Mat4f identity() { return new Mat4f().initIdentity(); }
	public static Mat4f zero() { return new Mat4f().initZero(); }
	public static Mat4f scaling(ITup3R t) { assert(t != null); return scaling(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public static Mat4f scaling(double x, double y, double z) { return new Mat4f().initScaling(x, y,z); }
	public static Mat4f translation(ITup3R t) { assert(t != null); return translation(t.getUniX(),t.getUniY(), t.getUniZ()); }
	public static Mat4f translation(double x, double y, double z) { return new Mat4f().initTranslation(x, y, z); }
	public static Mat4f perspective(ITup2R t, double fovY, double near, double far) { assert(t != null); return perspective(t.getUniX(), t.getUniY(), fovY, near, far); }
	public static Mat4f perspective(double width, double height, double fov, double near, double far) { return new Mat4f().initPerspective(width, height, fov, near, far); }
	public static Mat4f perspective(double fovX, double fovY, double near, double far) { return new Mat4f().initPerspective(fovX, fovY, near, far); }
	public static Mat4f perspective(double left, double right, double bottom, double top, double near, double far) { return new Mat4f().initPerspective(left, right, bottom, top, near, far); }
	public static Mat4f ortho(ITup2R t, double near, double far) { assert(t != null); return ortho(t.getUniX(), t.getUniY(), near, far); }
	public static Mat4f ortho(double width, double height, double near, double far) { return new Mat4f().initOrtho(width, height, near, far); }
	public static Mat4f ortho(double left, double right, double bottom, double top, double near, double far) { return new Mat4f().initOrtho(left, right, bottom, top, near, far); }
	public static Mat4f rotation(Quat q) { return new Mat4f().initRotation(q); }
	public static Mat4f modelMatrix(ITup3R pos, Quat rot, ITup3R scale) { assert(pos != null); return new Mat4f().initModelMatrix(pos, rot, scale); }
	public static Mat4f viewMatrix(ITup3R pos, Quat rot) { assert(pos != null); assert(rot != null); return new Mat4f().initViewMatrix(pos, rot); } 
	
	public Mat4f scale(ITup3R t) { assert(t != null); return Mat4f.mul(Mat4f.scaling(t), this, this); }
	public Mat4f scale(double x, double y, double z) { return Mat4f.mul(Mat4f.scaling(x, y, z), this, this); }
	public Mat4f translate(ITup3R t) { assert(t != null); return Mat4f.mul(Mat4f.translation(t), this, this); }
	public Mat4f translate(double x, double y, double z) { return Mat4f.mul(Mat4f.translation(x, y, z), this, this); }
	public Mat4f rotate(Quat q) { assert(q != null); return Mat4f.mul(Mat4f.rotation(q), this, this); }
	
	public float[] toArrayColumnMajor()
	{
		float[] out = new float[4 * 4];
		Tup4f t = Tup4fPool.get();
		
		for(int i = 0; i < 4; i++)
		{
			getColumn(i, t);
			
			out[i * 4 + 0] = t.getX();
			out[i * 4 + 1] = t.getY();
			out[i * 4 + 2] = t.getZ();
			out[i * 4 + 3] = t.getW();
		}

		Tup4fPool.store(t);
		
		return out;		
	}
	
	public float[] toArrayRowMajor()
	{
		float[] out = new float[4 * 4];
		Tup4f t = Tup4fPool.get();
		
		for(int i = 0; i < 4; i++)
		{
			getRow(i, t);
			
			out[i * 4 + 0] = t.getX();
			out[i * 4 + 1] = t.getY();
			out[i * 4 + 2] = t.getZ();
			out[i * 4 + 3] = t.getW();
		}

		Tup4fPool.store(t);
		
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
