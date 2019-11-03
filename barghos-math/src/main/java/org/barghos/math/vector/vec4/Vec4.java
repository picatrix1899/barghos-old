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

package org.barghos.math.vector.vec4;

import org.barghos.core.tuple.tuple4.Tup4fR;
import org.barghos.math.Maths;

/**
 * @author picatrix1899
 *
 */
public class Vec4 implements Vec4R
{
	protected float x;
	protected float y;
	protected float z;
	protected float w;
	
	public Vec4() { set(0.0f); }
	
	public Vec4(Tup4fR t) { assert(t != null); set(t); }
	
	public Vec4(float scalar) { set(scalar); }
	
	public Vec4(float x, float y, float z, float w) { set(x, y, z, w); }
	
	public float getX() { return this.x; }
	
	public float getY() { return this.y; }
	
	public float getZ() { return this.z; }
	
	public float getW() { return this.w; }
	
	public Vec4 setX(float x) { this.x = x; return this; }
	
	public Vec4 setY(float y) { this.y = y; return this; }
	
	public Vec4 setZ(float z) { this.z = z; return this; }
	
	public Vec4 setW(float w) { this.w = w; return this; }
	
	public Vec4 set(Tup4fR t) { assert(t != null); return set(t.getX(), t.getY(), t.getZ(), t.getW()); }

	public Vec4 set(float scalar) { return set(scalar, scalar, scalar, scalar); }

	public Vec4 set(float x, float y, float z, float w) { return setX(x).setY(y).setZ(z).setW(w); }
	
	public Vec4 add(Tup4fR t) { assert(t != null); return add(t, this); }
	public Vec4 add(float scalar) { return add(scalar, this); }
	public Vec4 add(float x, float y, float z, float w) { return add(x, y, z, w, this); }
	public Vec4 add(Tup4fR t, Vec4 res) { assert(t != null); return add(t.getX(), t.getY(), t.getZ(), t.getW(), res); }
	public Vec4 add(float scalar, Vec4 res) { return add(scalar, scalar, scalar, scalar, res); }
	public Vec4 add(float x, float y, float z, float w, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(this.x + x, this.y + y, this.z + z, this.w + w);
	}
	
	public Vec4 sub(Tup4fR t) { assert(t != null); return sub(t, this); }
	public Vec4 sub(float scalar) { return sub(scalar, this); }
	public Vec4 sub(float x, float y, float z, float w) { return sub(x, y, z, w, this); }
	public Vec4 sub(Tup4fR t, Vec4 res) { assert(t != null); return sub(t.getX(), t.getY(), t.getZ(), t.getW(), res); }
	public Vec4 sub(float scalar, Vec4 res) { return sub(scalar, scalar, scalar, scalar, res); }
	public Vec4 sub(float x, float y, float z, float w, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(this.x - x, this.y - y, this.z - z, this.w - w);
	}
	
	public Vec4 mul(Tup4fR t) { assert(t != null); return mul(t, this); }
	public Vec4 mul(float scalar) { return mul(scalar, this); }
	public Vec4 mul(float x, float y, float z, float w) { return mul(x, y, z, w, this); }
	public Vec4 mul(Tup4fR t, Vec4 res) { assert(t != null); return mul(t.getX(), t.getY(), t.getZ(), t.getW(), res); }
	public Vec4 mul(float scalar, Vec4 res) { return mul(scalar, scalar, scalar, scalar, res); }
	public Vec4 mul(float x, float y, float z, float w, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(this.x * x, this.y * y, this.z * z, this.w * w);
	}
	
	public Vec4 div(Tup4fR t) { assert(t != null); return div(t, this); }
	public Vec4 div(float scalar) { return div(scalar, this); }
	public Vec4 div(float x, float y, float z, float w) { return div(x, y, z, w, this); }
	public Vec4 div(Tup4fR t, Vec4 res) { assert(t != null); return div(t.getX(), t.getY(), t.getZ(), t.getW(), res); }
	public Vec4 div(float scalar, Vec4 res) { return div(scalar, scalar, scalar, scalar, res); }
	public Vec4 div(float x, float y, float z, float w, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(this.x / x, this.y / y, this.z / z, this.w / w);
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
		return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
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
	
	public Vec4 normal() { return normal(this); }
	public Vec4 normal(Vec4 res)
	{
		if(res == null) res = new Vec4();
		return mul(reciprocalLength(), res);
	}
	
	public Vec4 normalSafe() { return normalSafe(this); }
	public Vec4 normalSafe(float tolerance) { return normalSafe(tolerance, this); }
	public Vec4 normalSafe(Vec4 res) { return normalSafe(0.0f, res); }
	public Vec4 normalSafe(float tolerance, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return mul(reciprocalLengthSafe(tolerance), res);
	}
	
	public Vec4 invert() { return invert(this); }
	public Vec4 invert(Vec4 res)
	{
		if(res == null) res = new Vec4();
		return mul(-1, res);
	}
	
	public double dot(Tup4fR t) { assert(t != null); return dot(t.getX(), t.getY(), t.getZ(), t.getW()); }
	public double dot(float x, float y, float z, float w)
	{
		return this.x * x + this.y * y + this.z * z + this.w * w;
	}
	
	public Vec4 snapToGrid(Tup4fR grid) { assert(grid != null); return snapToGrid(grid, this); }
	public Vec4 snapToGrid(float gx, float gy, float gz, float gw) { return snapToGrid(gx, gy, gz, gw, this); }
	public Vec4 snapToGrid(Tup4fR grid, Vec4 res) { assert(grid != null); return snapToGrid(grid.getX(), grid.getY(), grid.getZ(), grid.getW(), res); }
	public Vec4 snapToGrid(float gx, float gy, float gz, float gw, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy), Maths.gridSnap(this.z, gz), Maths.gridSnap(this.w, gw));
	}
	
	public Vec4 abs() { return abs(this); }
	public Vec4 abs(Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z), Math.abs(this.w));
	}
	
	public Vec4 min(Tup4fR t) { assert(t != null); return min(t, this); }
	public Vec4 min(float scalar) { return min(scalar, this); }
	public Vec4 min(float x, float y, float z, float w) { return min(x, y, z, w,  this); }
	public Vec4 min(Tup4fR t, Vec4 res) { assert(t != null); return min(t.getX(), t.getY(), t.getZ(), t.getW(), res); }
	public Vec4 min(float scalar, Vec4 res) { return min(scalar, scalar, scalar, scalar, res); }
	public Vec4 min(float x, float y, float z, float w, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z), Math.min(this.w, w));
	}
	
	public Vec4 max(Tup4fR t) { assert(t != null); return max(t, this); }
	public Vec4 max(float scalar) { return max(scalar, this); }
	public Vec4 max(float x, float y, float z, float w) { return max(x, y, z, w, this); }
	public Vec4 max(Tup4fR t, Vec4 res) { assert(t != null); return max(t.getX(), t.getY(), t.getZ(), t.getW(), res); }
	public Vec4 max(float scalar, Vec4 res) { return max(scalar, scalar, scalar, scalar, res); }
	public Vec4 max(float x, float y, float z, float w, Vec4 res)
	{
		if(res == null) res = new Vec4();
		return res.set(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z), Math.max(this.w, w));
	}

	public boolean isZero(float tolerance)
	{
		return  (Math.abs(this.x) > tolerance) &&
				(Math.abs(this.y) > tolerance) &&
				(Math.abs(this.z) > tolerance) &&
				(Math.abs(this.w) > tolerance);
	}
	
	public boolean isFinite()
	{
		return Float.isFinite(this.x) && Float.isFinite(this.y) && Float.isFinite(this.z) && Float.isFinite(this.w);
	}
	
	public String toString()
	{
		return "vec4(" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof Vec4)) return false;
		Vec4 v = (Vec4)obj;
		
		if(this.x != v.x) return false;
		if(this.y != v.y) return false;
		if(this.z != v.z) return false;
		if(this.w != v.w) return false;
		
		return true;
	}
}
