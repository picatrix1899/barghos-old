package org.barghos.math.matrix;

import org.barghos.core.api.tuple.ITup2R;
import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.api.tuple.ITup4fW;
import org.barghos.core.tuple.Tup4f;
import org.barghos.math.Maths;
import org.barghos.math.point.Point3f;
import org.barghos.math.vector.Vec3f;
import org.barghos.math.vector.Vec4f;

public class Mat4f
{
	public final float[][] m = new float[4][4];
	
	public Mat4f() {  }
	public Mat4f(Mat4f m) { set(m); }
	
	public Mat4f set(Mat4f m)
	{
		Tup4f t = new Tup4f();
		setRow(0, m.getRow(0, t));
		setRow(1, m.getRow(1, t));
		setRow(2, m.getRow(2, t));
		setRow(3, m.getRow(3, t));
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
		return initScaling(t.getUniX(), t.getUniY(), t.getUniZ());
	}
	
	public Mat4f initScaling(double x, double y, double z)
	{
		setRow(0, x,	0.0f,	0.0f, 0.0f);
		setRow(1, 0.0f,	y,		0.0f, 0.0f);
		setRow(2, 0.0f,	0.0f,	1.0f, 0.0f);
		setRow(3, 0.0f,	0.0f,	0.0f, 1.0f);
		return this;
	}
	
	public Mat4f initTranslation(ITup3R t)
	{
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
		return initPerspective(t.getUniX(), t.getUniY(), fov, near, far);
	}
	
	public Mat4f initPerspective(double width, double height, double fovY, double near, double far)
	{
		float y_scale = (float)(1.0 / Math.tan(fovY * 0.5 * Maths.DEG_TO_RAD));
		float x_scale = (float)(y_scale / (width / height));

		setRow(0, x_scale,	0,			0,								0	);
		setRow(1, 0,		y_scale,	0,								0	);
		setRow(2, 0,		0,			-(far + near) / (far - near),	-1	);
		setRow(3, 0,		0,			-2 * near * far / (far - near),	0	);
		
		return this;
	}
	
	public Mat4f initPerspective(double fovX, double fovY, double near, double far)
	{
		float y_scale = (float)(1.0 / Math.tan(fovY * 0.5 * Maths.DEG_TO_RAD));
		float x_scale = (float)(1.0 / Math.tan(fovX * 0.5 * Maths.DEG_TO_RAD));

		setRow(0, x_scale,	0,			0,								0	);
		setRow(1, 0,		y_scale,	0,								0	);
		setRow(2, 0,		0,			-(far + near) / (far - near),	-1	);
		setRow(3, 0,		0,			-2 * near * far / (far - near),	0	);
		
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
	
	public Mat4f setRow(int index, ITup4R t)
	{
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
	
	public Mat4f setColumn(int index, ITup4R t)
	{
		return setColumn(index, t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW());
	}
	
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
	
	public void getRow(int index, ITup4fW t) { t.set(this.m[index][0], this.m[index][1], this.m[index][2], this.m[index][3]); }
	public void getColumn(int index, ITup4fW t) { t.set(this.m[0][index], this.m[1][index], this.m[2][index], this.m[3][index]); }
	
	
	public float determinant()
	{
		return MatUtils.det4x4(	this.m[0][0], this.m[0][1], this.m[0][2], this.m[0][3],
								this.m[1][0], this.m[1][1], this.m[1][2], this.m[1][3],
								this.m[2][0], this.m[2][1], this.m[2][2], this.m[2][3],
								this.m[3][0], this.m[3][1], this.m[3][2], this.m[3][3]);
	}
	
	public Mat4f transpose()
	{
		Tup4f r0 = getRow(0);
		Tup4f r1 = getRow(1);
		Tup4f r2 = getRow(2);
		Tup4f r3 = getRow(3);
		
		return setColumn(0, r0).setColumn(1, r1).setColumn(2, r2).setColumn(3, r3);
	}
	
	public Mat4f mul(Mat4f m2, Mat4f res)
	{
		res = res != null ? res : new Mat4f();
		
		float m0x_ = this.m[0][0] * m2.m[0][0] + this.m[0][1] * m2.m[1][0] + this.m[0][2] * m2.m[2][0] + this.m[0][3] * m2.m[3][0];
		float m0y_ = this.m[0][0] * m2.m[0][1] + this.m[0][1] * m2.m[1][1] + this.m[0][2] * m2.m[2][1] + this.m[0][3] * m2.m[3][1];
		float m0z_ = this.m[0][0] * m2.m[0][2] + this.m[0][1] * m2.m[1][2] + this.m[0][2] * m2.m[2][2] + this.m[0][3] * m2.m[3][2];
		float m0w_ = this.m[0][0] * m2.m[0][3] + this.m[0][1] * m2.m[1][3] + this.m[0][2] * m2.m[2][3] + this.m[0][3] * m2.m[3][3];
		
		float m1x_ = this.m[1][0] * m2.m[0][0] + this.m[1][1] * m2.m[1][0] + this.m[1][2] * m2.m[2][0] + this.m[1][3] * m2.m[3][0];
		float m1y_ = this.m[1][0] * m2.m[0][1] + this.m[1][1] * m2.m[1][1] + this.m[1][2] * m2.m[2][1] + this.m[1][3] * m2.m[3][1];
		float m1z_ = this.m[1][0] * m2.m[0][2] + this.m[1][1] * m2.m[1][2] + this.m[1][2] * m2.m[2][2] + this.m[1][3] * m2.m[3][2];
		float m1w_ = this.m[1][0] * m2.m[0][3] + this.m[1][1] * m2.m[1][3] + this.m[1][2] * m2.m[2][3] + this.m[1][3] * m2.m[3][3];
		
		float m2x_ = this.m[2][0] * m2.m[0][0] + this.m[2][1] * m2.m[1][0] + this.m[2][2] * m2.m[2][0] + this.m[2][3] * m2.m[3][0];
		float m2y_ = this.m[2][0] * m2.m[0][1] + this.m[2][1] * m2.m[1][1] + this.m[2][2] * m2.m[2][1] + this.m[2][3] * m2.m[3][1];
		float m2z_ = this.m[2][0] * m2.m[0][2] + this.m[2][1] * m2.m[1][2] + this.m[2][2] * m2.m[2][2] + this.m[2][3] * m2.m[3][2];
		float m2w_ = this.m[2][0] * m2.m[0][3] + this.m[2][1] * m2.m[1][3] + this.m[2][2] * m2.m[2][3] + this.m[2][3] * m2.m[3][3];
		
		float m3x_ = this.m[3][0] * m2.m[0][0] + this.m[3][1] * m2.m[1][0] + this.m[3][2] * m2.m[2][0] + this.m[3][3] * m2.m[3][0];
		float m3y_ = this.m[3][0] * m2.m[0][1] + this.m[3][1] * m2.m[1][1] + this.m[3][2] * m2.m[2][1] + this.m[3][3] * m2.m[3][1];
		float m3z_ = this.m[3][0] * m2.m[0][2] + this.m[3][1] * m2.m[1][2] + this.m[3][2] * m2.m[2][2] + this.m[3][3] * m2.m[3][2];
		float m3w_ = this.m[3][0] * m2.m[0][3] + this.m[3][1] * m2.m[1][3] + this.m[3][2] * m2.m[2][3] + this.m[3][3] * m2.m[3][3];
		
		res.setRow(0, m0x_, m0y_, m0z_, m0w_);
		res.setRow(1, m1x_, m1y_, m1z_, m1w_);
		res.setRow(2, m2x_, m2y_, m2z_, m2w_);
		res.setRow(3, m3x_, m3y_, m3z_, m3w_);
		
		return res;
	}
	
	public Vec3f transformVector(ITup3R t, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		
		float x_ = (float)(this.m[0][0] * t.getUniX() + this.m[0][1] * t.getUniY() + this.m[0][2] * t.getUniZ() + this.m[0][3] * 1.0);
		float y_ = (float)(this.m[1][0] * t.getUniX() + this.m[1][1] * t.getUniY() + this.m[1][2] * t.getUniZ() + this.m[1][3] * 1.0);
		float z_ = (float)(this.m[2][0] * t.getUniX() + this.m[2][1] * t.getUniY() + this.m[2][2] * t.getUniZ() + this.m[2][3] * 1.0);

		res.set(x_, y_, z_);

		return res;
	}
	
	public Point3f transformPoint(ITup3R t, Point3f res)
	{
		res = res != null ? res : new Point3f();
		
		float x_ = (float)(this.m[0][0] * t.getUniX() + this.m[0][1] * t.getUniY() + this.m[0][2] * t.getUniZ() + this.m[0][3] * 1.0);
		float y_ = (float)(this.m[1][0] * t.getUniX() + this.m[1][1] * t.getUniY() + this.m[1][2] * t.getUniZ() + this.m[1][3] * 1.0);
		float z_ = (float)(this.m[2][0] * t.getUniX() + this.m[2][1] * t.getUniY() + this.m[2][2] * t.getUniZ() + this.m[2][3] * 1.0);

		res.set(x_, y_, z_);

		return res;
	}
	
	public static Mat4f identity() { return new Mat4f().initIdentity(); }
	public static Mat4f zero() { return new Mat4f().initZero(); }
	public static Mat4f scale(ITup3R t) { return scale(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public static Mat4f scale(double x, double y, double z) { return new Mat4f().initScaling(x, y,z); }
	public static Mat4f translate(ITup3R t) { return translate(t.getUniX(),t.getUniY(), t.getUniZ()); }
	public static Mat4f translate(double x, double y, double z) { return new Mat4f().initTranslation(x, y, z); }
	public static Mat4f perspective(ITup2R t, double fovY, double near, double far) { return perspective(t.getUniX(), t.getUniY(), fovY, near, far); }
	public static Mat4f perspective(double width, double height, double fov, double near, double far) { return new Mat4f().initPerspective(width, height, fov, near, far); }
	public static Mat4f perspective(double fovX, double fovY, double near, double far) { return new Mat4f().initPerspective(fovX, fovY, near, far); }
	public static Mat4f perspective(double left, double right, double bottom, double top, double near, double far) { return new Mat4f().initPerspective(left, right, bottom, top, near, far); }
	public static Mat4f ortho(ITup2R t, double near, double far) { return ortho(t.getUniX(), t.getUniY(), near, far); }
	public static Mat4f ortho(double width, double height, double near, double far) { return new Mat4f().initOrtho(width, height, near, far); }
	public static Mat4f ortho(double left, double right, double bottom, double top, double near, double far) { return new Mat4f().initOrtho(left, right, bottom, top, near, far); }
}
