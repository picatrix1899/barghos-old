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

package org.barghos.math.vector.vec3;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.core.tuple.tuple4.Tup4fR;
import org.barghos.core.util.Nullable;
import org.barghos.math.Maths;

/**
 * @author picatrix1899
 *
 * Represents a 3-dimensional mathematical vector in euclidean space.
 * This is a full featured version with common operations.
 */
public class Vec3 implements Vec3R
{
	protected float x;
	protected float y;
	protected float z;
	
	public Vec3() { set(0.0f, 0.0f, 0.0f); }
	
	public Vec3(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); set(t.getX(), t.getY(), t.getZ()); }
	
	public Vec3(float x, float y, float z) { set(x, y, z); }
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	
	public Vec3 setX(float x) { this.x = x; return this; }
	public Vec3 setY(float y) { this.y = y; return this; }
	public Vec3 setZ(float z) { this.z = z; return this; }
	
	public Vec3 set(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return set(t.getX(), t.getY(), t.getZ()); }
	public Vec3 set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }
	
	public Vec3 add(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return add(t.getX(), t.getY(), t.getZ()); }
	public Vec3 add(float scalar) { return add(scalar, scalar, scalar); }
	public Vec3 add(float x, float y, float z) { return set(this.x + x, this.y + y, this.z + z); }
	public Vec3 add(Tup3fR t, @Nullable Vec3 res) { if(t == null) throw new ArgumentNullException("t"); return add(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 add(float scalar, @Nullable Vec3 res) { return add(scalar, scalar, scalar, res); }
	public Vec3 add(float x, float y, float z, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(this.x + x, this.y + y, this.z + z); }
	
	public Vec3 sub(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return sub(t.getX(), t.getY(), t.getZ()); }
	public Vec3 sub(float scalar) { return sub(scalar, scalar, scalar); }
	public Vec3 sub(float x, float y, float z) { return set(this.x - x, this.y - y, this.z - z); }
	public Vec3 sub(Tup3fR t, @Nullable Vec3 res){ if(t == null) throw new ArgumentNullException("t"); return sub(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 sub(float scalar, @Nullable Vec3 res) { return sub(scalar, scalar, scalar, res); }
	public Vec3 sub(float x, float y, float z, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(this.x - x, this.y - y, this.z - z); }
	
	public Vec3 mul(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return mul(t.getX(), t.getY(), t.getZ()); }
	public Vec3 mul(float scalar) { return mul(scalar, scalar, scalar); }
	public Vec3 mul(float x, float y, float z) { return set(this.x * x, this.y * y, this.z * z); }
	public Vec3 mul(Tup3fR t, @Nullable Vec3 res) { if(t == null) throw new ArgumentNullException("t"); return mul(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 mul(float scalar, @Nullable Vec3 res) { return mul(scalar, scalar, scalar, res); }
	public Vec3 mul(float x, float y, float z, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(this.x * x, this.y * y, this.z * z); }
	
	public Vec3 div(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return div(t.getX(), t.getY(), t.getZ(), this); }
	public Vec3 div(float scalar) { return div(scalar, scalar, scalar); }
	public Vec3 div(float x, float y, float z) { return set(this.x / x, this.y / y, this.z / z); }
	public Vec3 div(Tup3fR t, @Nullable Vec3 res) { if(t == null) throw new ArgumentNullException("t"); return div(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 div(float scalar, @Nullable Vec3 res) { return div(scalar, scalar, scalar, res); }
	public Vec3 div(float x, float y, float z, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(this.x / x, this.y / y, this.z / z); }
	
	public float length() { return (float)Maths.sqrt(squaredLength()); }
	
	public float lengthSafe() { return isZero() ? 0.0f : length(); }
	public float lengthSafe(float tolerance) { return isZero(tolerance) ? 0.0f : length(); }
	
	public float reciprocalLength() { return 1.0f / length(); }

	public float reciprocalLengthSafe() { return isZero() ? 0.0f : reciprocalLength();  }
	public float reciprocalLengthSafe(float tolerance) { return isZero(tolerance) ? 0.0f : reciprocalLength(); }

	public float squaredLength() { return this.x * this.x + this.y * this.y + this.z * this.z; }

	public Vec3 normal() { return div(length()); }
	public Vec3 normal(@Nullable Vec3 res) { return div(length(), res); }
	
	public Vec3 normalSafe() { return isZero() ? set(0.0f, 0.0f, 0.0f) : normal(); }
	public Vec3 normalSafe(float tolerance) { if(tolerance < 0) throw new IllegalArgumentException(); return isZero(tolerance) ? set(0.0f, 0.0f, 0.0f) : normal(); }
	public Vec3 normalSafe(@Nullable Vec3 res) { if(res == null) res = new Vec3(); return isZero() ? res.set(0.0f, 0.0f, 0.0f) : normal(res); }
	public Vec3 normalSafe(float tolerance, @Nullable Vec3 res) { if(tolerance < 0) throw new IllegalArgumentException(); if(res == null) res = new Vec3(); return isZero(tolerance) ? res.set(0.0f, 0.0f, 0.0f) : normal(res); }
	
	public Vec3 invert() { return set(-this.x, -this.y, -this.z); }
	public Vec3 invert(@Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(-this.x, -this.y, -this.z); }
	
	public float dot(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return dot(t.getX(), t.getY(), t.getZ()); }
	public float dot(float x, float y, float z) { return this.x * x + this.y * y + this.z * z; }
	
	public float dot(Tup4fR t) { if(t == null) throw new ArgumentNullException("t"); return dot(t.getX(), t.getY(), t.getZ(), t.getW()); }
	public float dot(float x, float y, float z, float w) { return this.x * x + this.y * y + this.z * z; }
	
	public Vec3 cross(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return cross(t.getX(), t.getY(), t.getZ()); }
	public Vec3 cross(float x, float y, float z) { return set(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x); }
	public Vec3 cross(Tup3fR t, @Nullable Vec3 res) { if(t == null) throw new ArgumentNullException("t"); return cross(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 cross(float x, float y, float z, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x); }
	
	public Vec3 snapToGrid(Tup3fR grid) { if(grid == null) throw new ArgumentNullException("grid"); return snapToGrid(grid.getX(), grid.getY(), grid.getZ()); }
	public Vec3 snapToGrid(float gx, float gy, float gz) { return set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy), Maths.gridSnap(this.z, gz)); }
	public Vec3 snapToGrid(Tup3fR grid, @Nullable Vec3 res) { if(grid == null) throw new ArgumentNullException("grid"); return snapToGrid(grid.getX(), grid.getY(), grid.getZ(), res); }
	public Vec3 snapToGrid(float gx, float gy, float gz, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy), Maths.gridSnap(this.z, gz)); }
	
	public Vec3 abs() { return abs(this); }
	public Vec3 abs(@Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z)); }
	
	public Vec3 min(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return min(t.getX(), t.getY(), t.getZ()); }
	public Vec3 min(float scalar) { return min(scalar, scalar, scalar); }
	public Vec3 min(float x, float y, float z) { return set(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z)); }
	public Vec3 min(Tup3fR t, @Nullable Vec3 res) { if(t == null) throw new ArgumentNullException("t"); return min(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 min(float scalar, @Nullable Vec3 res) { return min(scalar, scalar, scalar, res); }
	public Vec3 min(float x, float y, float z, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z)); }
	
	public Vec3 max(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return max(t.getX(), t.getY(), t.getZ()); }
	public Vec3 max(float scalar) { return max(scalar, scalar, scalar); }
	public Vec3 max(float x, float y, float z) { return set(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z)); }
	public Vec3 max(Tup3fR t, @Nullable Vec3 res) { if(t == null) throw new ArgumentNullException("t"); return max(t.getX(), t.getY(), t.getZ(), res); }
	public Vec3 max(float scalar, @Nullable Vec3 res) { return max(scalar, scalar, scalar, res); }
	public Vec3 max(float x, float y, float z, @Nullable Vec3 res) { if(res == null) res = new Vec3(); return res.set(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z)); }

	public boolean isZero() { return this.x == 0.0f && this.y == 0.0f && this.z == 0.0f; }
	public boolean isZero(float tolerance) { return (Math.abs(this.x) <= tolerance) && (Math.abs(this.y) <= tolerance) && (Math.abs(this.z) <= tolerance); }
	
	public boolean isFinite() { return Float.isFinite(this.x) && Float.isFinite(this.y) && Float.isFinite(this.z); }
	
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
