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

package org.barghos.math.vector.vec2;

import org.barghos.core.tuple.tuple2.Tup2fR;
import org.barghos.math.Maths;

/**
 * @author picatrix1899
 *
 */
public class Vec2 implements Vec2R
{
		protected float x;
		protected float y;
		
		public Vec2() { set(0.0f); }
		
		public Vec2(Tup2fR t) { assert(t != null); set(t); }
		
		public Vec2(float scalar) { set(scalar); }
		
		public Vec2(float x, float y) { set(x, y); }
		
		public float getX() { return this.x; }
		
		public float getY() { return this.y; }
		
		public Vec2 setX(float x) { this.x = x; return this; }
		
		public Vec2 setY(float y) { this.y = y; return this; }
		
		public Vec2 set(Tup2fR t) { assert(t != null); return set(t.getX(), t.getY()); }

		public Vec2 set(float scalar) { return set(scalar, scalar); }

		public Vec2 set(float x, float y) { return setX(x).setY(y); }
		
		public Vec2 add(Tup2fR t) { assert(t != null); return add(t, this); }
		public Vec2 add(float scalar) { return add(scalar, this); }
		public Vec2 add(float x, float y) { return add(x, y, this); }
		public Vec2 add(Tup2fR t, Vec2 res) { assert(t != null); return add(t.getX(), t.getY(), res); }
		public Vec2 add(float scalar, Vec2 res) { return add(scalar, scalar, res); }
		public Vec2 add(float x, float y, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(this.x + x, this.y + y);
		}
		
		public Vec2 sub(Tup2fR t) { assert(t != null); return sub(t, this); }
		public Vec2 sub(float scalar) { return sub(scalar, this); }
		public Vec2 sub(float x, float y) { return sub(x, y, this); }
		public Vec2 sub(Tup2fR t, Vec2 res) { assert(t != null); return sub(t.getX(), t.getY(), res); }
		public Vec2 sub(float scalar, Vec2 res) { return sub(scalar, scalar, res); }
		public Vec2 sub(float x, float y, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(this.x - x, this.y - y);
		}
		
		public Vec2 mul(Tup2fR t) { assert(t != null); return mul(t, this); }
		public Vec2 mul(float scalar) { return mul(scalar, this); }
		public Vec2 mul(float x, float y) { return mul(x, y, this); }
		public Vec2 mul(Tup2fR t, Vec2 res) { assert(t != null); return mul(t.getX(), t.getY(), res); }
		public Vec2 mul(float scalar, Vec2 res) { return mul(scalar, scalar, res); }
		public Vec2 mul(float x, float y, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(this.x * x, this.y * y);
		}
		
		public Vec2 div(Tup2fR t) { assert(t != null); return div(t, this); }
		public Vec2 div(float scalar) { return div(scalar, this); }
		public Vec2 div(float x, float y) { return div(x, y, this); }
		public Vec2 div(Tup2fR t, Vec2 res) { assert(t != null); return div(t.getX(), t.getY(), res); }
		public Vec2 div(float scalar, Vec2 res) { return div(scalar, scalar, res); }
		public Vec2 div(float x, float y, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(this.x / x, this.y / y);
		}

		public float length()
		{
			return (float)Maths.sqrt(squaredLength());
		}

		public float lengthSafe() { return lengthSafe(0.0f); }
		public float lengthSafe(float tolerance)
		{
			return isZero(tolerance) ? 0.0f : (float)Maths.sqrt(squaredLength());
		}

		public float reciprocalLength()
		{
			return 1.0f / length();

		}

		public float reciprocalLengthSafe() { return reciprocalLengthSafe(0.0f); }
		public float reciprocalLengthSafe(float tolerance)
		{
			return isZero(tolerance) ? 0.0f : 1.0f / length(); 
		}

		public float squaredLength()
		{
			return this.x * this.x + this.y * this.y;
		}

		public Vec2 normal() { return normal(this); }
		
		public Vec2 normal(Vec2 res)
		{
			if(res == null) res = new Vec2();
			return mul(reciprocalLength(), res);
		}

		public Vec2 normalSafe() { return normalSafe(this); }
		public Vec2 normalSafe(float tolerance) { return normalSafe(tolerance, this); }
		public Vec2 normalSafe(Vec2 res) { return normalSafe(0.0f, res); }
		
		public Vec2 normalSafe(float tolerance, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return mul(reciprocalLengthSafe(tolerance), res);
		}

		public float dot(Tup2fR t) { assert(t != null); return dot(t.getX(), t.getY()); }
		public float dot(float x, float y)
		{
			return this.x * x + this.y * y;
		}

		public Vec2 snapToGrid(Tup2fR grid) { assert(grid != null); return snapToGrid(grid, this); }
		public Vec2 snapToGrid(float gx, float gy) { return snapToGrid(gx, gy, this); }
		public Vec2 snapToGrid(Tup2fR grid, Vec2 res) { assert(grid != null); return snapToGrid(grid.getX(), grid.getY(), res); }
		
		public Vec2 snapToGrid(float gx, float gy, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy));
		}

		public Vec2 abs() { return abs(this); }
		
		public Vec2 abs(Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(Math.abs(this.x), Math.abs(this.y));
		}

		public Vec2 min(Tup2fR t) { assert(t != null); return min(t, this); }
		public Vec2 min(float scalar) { return min(scalar, this); }
		public Vec2 min(float x, float y) { return min(x, y, this); }
		public Vec2 min(Tup2fR t, Vec2 res) { assert(t != null); return min(t.getX(), t.getY(), res); }
		public Vec2 min(float scalar, Vec2 res) { return min(scalar, scalar, res); }
		
		public Vec2 min(float x, float y, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(Math.min(this.x, x), Math.min(this.y, y));
		}

		public Vec2 max(Tup2fR t) { assert(t != null); return max(t, this); }
		public Vec2 max(float scalar) { return max(scalar, this); }
		public Vec2 max(float x, float y) { return max(x, y, this); }
		public Vec2 max(Tup2fR t, Vec2 res) { assert(t != null); return max(t.getX(), t.getY(), res); }
		public Vec2 max(float scalar, Vec2 res) { return max(scalar, scalar, res); }

		public Vec2 max(float x, float y, Vec2 res)
		{
			if(res == null) res = new Vec2();
			return res.set(Math.max(this.x, x), Math.max(this.y, y));
		}

		public Vec2 invert() { return invert(this); }
		
		public Vec2 invert(Vec2 res)
		{
			if(res == null) res = new Vec2();
			return mul(-1, res);
		}
		
		public boolean isZero(float tolerance)
		{
			return (Math.abs(this.x) > tolerance) && (Math.abs(this.y) > tolerance);
		}
		
		public boolean isFinite()
		{
			return Float.isFinite(this.x) && Float.isFinite(this.y);
		}
		
		public String toString()
		{
			return "vec2(" + this.x + ", " + this.y + ")";
		}
		
		public boolean equals(Object obj)
		{
			if(obj == null) return false;
			if(!(obj instanceof Vec2)) return false;
			Vec2 v = (Vec2)obj;
			
			if(this.x != v.x) return false;
			if(this.y != v.y) return false;
			
			return true;
		}
}
