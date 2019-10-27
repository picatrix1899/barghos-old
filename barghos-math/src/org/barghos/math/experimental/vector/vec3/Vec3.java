/*
MIT License

Copyright (c) 2019 picatrix1899

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package org.barghos.math.experimental.vector.vec3;

import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.core.tuple.tuple4.Tup4fR;
import org.barghos.math.Maths;

/**
 * @author picatrix1899
 *
 */
public class Vec3 implements Vec3R
{
	protected float x;
	protected float y;
	protected float z;
	
	public Vec3() { set(0.0f); }
	
	public Vec3(Tup3fR t) { assert(t != null); set(t); }
	
	public Vec3(float scalar) { set(scalar); }
	
	public Vec3(float x, float y, float z) { set(x, y, z); }
	
	public float getX() { return this.x; }
	
	public float getY() { return this.y; }
	
	public float getZ() { return this.z; }
	
	public Vec3 setX(float x) { this.x = x; return this; }
	
	public Vec3 setY(float y) { this.y = y; return this; }
	
	public Vec3 setZ(float z) { this.z = z; return this; }
	
	public Vec3 set(Tup3fR t) { assert(t != null); return set(t.getX(), t.getY(), t.getZ()); }

	public Vec3 set(float scalar) { return set(scalar, scalar, scalar); }

	public Vec3 set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	
	public Vec3 add(Tup3fR t) { assert(t != null); return add(t, this); }
	public Vec3 add(float scalar) { return add(scalar, this); }
	public Vec3 add(float x, float y, float z) { return add(x, y, z, this); }
	public Vec3 add(Tup3fR t, Vec3 res) { assert(t != null); return add(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 add(float scalar, Vec3 res) { return add(scalar, scalar, scalar, res); }
	public Vec3 add(float x, float y, float z, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.x + x, this.y + y, this.z + z);
	}
	
	public Vec3 sub(Tup3fR t) { assert(t != null); return sub(t, this); }
	public Vec3 sub(float scalar) { return sub(scalar, this); }
	public Vec3 sub(float x, float y, float z) { return sub(x, y, z, this); }
	public Vec3 sub(Tup3fR t, Vec3 res) { assert(t != null); return sub(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 sub(float scalar, Vec3 res) { return sub(scalar, scalar, scalar, res); }
	public Vec3 sub(float x, float y, float z, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.x - x, this.y - y, this.z - z);
	}
	
	public Vec3 mul(Tup3fR t) { assert(t != null); return mul(t, this); }
	public Vec3 mul(float scalar) { return mul(scalar, this); }
	public Vec3 mul(float x, float y, float z) { return mul(x, y, z, this); }
	public Vec3 mul(Tup3fR t, Vec3 res) { assert(t != null); return mul(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 mul(float scalar, Vec3 res) { return mul(scalar, scalar, scalar, res); }
	public Vec3 mul(float x, float y, float z, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.x * x, this.y * y, this.z * z);
	}
	
	public Vec3 div(Tup3fR t) { assert(t != null); return div(t, this); }
	public Vec3 div(float scalar) { return div(scalar, this); }
	public Vec3 div(float x, float y, float z) { return div(x, y, z, this); }
	public Vec3 div(Tup3fR t, Vec3 res) { assert(t != null); return div(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 div(float scalar, Vec3 res) { return div(scalar, scalar, scalar, res); }
	public Vec3 div(float x, float y, float z, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.x / x, this.y / y, this.z / z);
	}
	
	public float length()
	{
		return (float)Maths.sqrt(squaredLength());
	}
	public float reciprocalLength()
	{
		return 1.0f / length();
	}


	public float squaredLength()
	{
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}
	
	public float lengthSafe() { return lengthSafe(0.0f); }
	public float lengthSafe(float tolerance)
	{
		return isZero(tolerance) ? 0.0f : (float)Maths.sqrt(squaredLength());
	}
	
	public float reciprocalLengthSafe() { return reciprocalLengthSafe(0.0f); }
	
	public float reciprocalLengthSafe(float tolerance)
	{
		return isZero(tolerance) ? 0.0f : 1.0f / length(); 
	}
	
	public Vec3 normal() { return normal(this); }
	public Vec3 normal(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return mul(reciprocalLength(), res);
	}
	
	public Vec3 normalSafe() { return normalSafe(this); }
	public Vec3 normalSafe(float tolerance) { return normalSafe(tolerance, this); }
	public Vec3 normalSafe(Vec3 res) { return normalSafe(0.0f, res); }
	public Vec3 normalSafe(float tolerance, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return mul(reciprocalLengthSafe(tolerance), res);
	}
	
	public Vec3 invert() { return invert(this); }
	public Vec3 invert(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return mul(-1, res);
	}
	
	public float dot(Tup3fR t) { assert(t != null); return dot(t.getX(), t.getY(), t.getZ()); }
	public float dot(float x, float y, float z)
	{
		return this.x * x + this.y * y + this.z * z;
	}
	
	public float dot(Tup4fR t) { assert(t != null); return dot(t.getX(), t.getY(), t.getZ(), t.getW()); }
	public float dot(float x, float y, float z, float w)
	{
		return this.x * x + this.y * y + this.z * z;
	}
	
	public Vec3 cross(Tup3fR t) { assert(t != null); return cross(t, this); }
	public Vec3 cross(float x, float y, float z) { return cross(x, y, z, this); }
	public Vec3 cross(Tup3fR t, Vec3 res) { assert(t != null); return cross(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 cross(float x, float y, float z, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
	}
	
	public Vec3 snapToGrid(Tup3fR grid) { assert(grid != null); return snapToGrid(grid, this); }
	public Vec3 snapToGrid(float gx, float gy, float gz) { return snapToGrid(gx, gy, gz, this); }
	public Vec3 snapToGrid(Tup3fR grid, Vec3 res) { assert(grid != null); return snapToGrid(grid.getX(), grid.getY(), grid.getZ(), res); }
	public Vec3 snapToGrid(float gx, float gy, float gz, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy), Maths.gridSnap(this.z, gz));
	}
	
	public Vec3 abs() { return abs(this); }
	public Vec3 abs(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
	}
	
	public Vec3 min(Tup3fR t) { assert(t != null); return min(t, this); }
	public Vec3 min(float scalar) { return min(scalar, this); }
	public Vec3 min(float x, float y, float z) { return min(x, y, z, this); }
	public Vec3 min(Tup3fR t, Vec3 res) { assert(t != null); return min(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 min(float scalar, Vec3 res) { return min(scalar, scalar, scalar, res); }
	public Vec3 min(float x, float y, float z, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
	}
	
	public Vec3 max(Tup3fR t) { assert(t != null); return max(t, this); }
	public Vec3 max(float scalar) { return max(scalar, this); }
	public Vec3 max(float x, float y, float z) { return max(x, y, z, this); }
	public Vec3 max(Tup3fR t, Vec3 res) { assert(t != null); return max(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 max(float scalar, Vec3 res) { return max(scalar, scalar, scalar, res); }
	public Vec3 max(float x, float y, float z, Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
	}

	public boolean isZero(float tolerance)
	{
		if(tolerance == 0.0f) return this.x == 0.0f && this.y == 0.0f && this.z == 0.0f;
		return (Math.abs(this.x) <= tolerance) && (Math.abs(this.y) <= tolerance) && (Math.abs(this.z) <= tolerance);
	}
	
	public boolean isFinite()
	{
		return Float.isFinite(this.x) && Float.isFinite(this.y) && Float.isFinite(this.z);
	}
	
	public String toString()
	{
		return "vec3(" + this.x + ", " + this.y + ", " + this.z + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof Vec3)) return false;
		Vec3 v = (Vec3)obj;
		
		if(this.x != v.x) return false;
		if(this.y != v.y) return false;
		if(this.z != v.z) return false;
		
		return true;
	}
}
