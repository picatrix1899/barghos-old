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

package org.barghos.math.api.vector.api;

import org.barghos.core.tuple.tuple2.api.ITup2R;
import org.barghos.math.Maths;

/**
 * @author picatrix1899
 *
 */
public class Vec2f implements IVec2f
{
	private float x = 0.0f;
	private float y = 0.0f;
	
	public Vec2f() { set(0); }
	
	public Vec2f(ITup2R t)
	{
		assert(t != null);
		set(t);
	}
	
	public Vec2f(double scalar) { set(scalar); }
	
	public Vec2f(double x, double y) { set(x, y); }
	
	@Override
	public float getX() { return this.x; }

	@Override
	public float getY() { return this.y; }

	@Override
	public Vec2 setX(double x) { this.x = (float)x; return this; }

	@Override
	public Vec2 setY(double y) { this.y = (float)y; return this; }

	@Override
	public Vec2f set(ITup2R t)
	{
		assert(t != null);
		return set(t.getUniX(), t.getUniY());
	}

	@Override
	public Vec2f set(double scalar) { return set(scalar, scalar); }

	@Override
	public Vec2f set(double x, double y) { return setX(x).setY(y); }

	
	
	@Override
	public Vec2 add(ITup2R t, Vec2 res) { assert(t != null); return add(t.getUniX(), t.getUniY(), res); }

	@Override
	public Vec2 add(double scalar, Vec2 res) { return add(scalar, scalar, res); }

	@Override
	public Vec2 add(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2f();
		return res.set(this.x + x, this.y + y);
	}

	@Override
	public Vec2 sub(ITup2R t, Vec2 res) { assert(t != null); return sub(t.getUniX(), t.getUniY(), res); }

	@Override
	public Vec2 sub(double scalar, Vec2 res) { return sub(scalar, scalar, res); }

	@Override
	public Vec2 sub(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2f();
		return res.set(this.x - x, this.y - y);
	}

	@Override
	public Vec2 mul(ITup2R t, Vec2 res) { assert(t != null); return mul(t.getUniX(), t.getUniY(), res); }

	@Override
	public Vec2 mul(double scalar, Vec2 res) { return mul(scalar, scalar, res); }

	@Override
	public Vec2 mul(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2f();
		return res.set(this.x * x, this.y * y);
	}

	@Override
	public Vec2 div(ITup2R t, Vec2 res) { assert(t != null); return div(t.getUniX(), t.getUniY(), res); }

	@Override
	public Vec2 div(double scalar, Vec2 res) { return div(scalar, scalar, res); }

	@Override
	public Vec2 div(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2f();
		return res.set(this.x / x, this.y / y);
	}

	@Override
	public double length() { return Maths.sqrt(squaredLength()); }

	@Override
	public double reciprocalLength() { return 1.0 / length(); }

	@Override
	public double squaredLength() { return this.x * this.x + this.y * this.y; }

	@Override
	public double lengthSafe() { return lengthSafe(0.0); }

	@Override
	public double lengthSafe(double tolerance)
	{
		if(isZero(tolerance)) return 0;
		return length();
	}

	@Override
	public double reciprocalLengthSafe(){ return reciprocalLengthSafe(0.0); }

	@Override
	public double reciprocalLengthSafe(double tolerance)
	{
		if(isZero(tolerance)) return 0;
		return reciprocalLength();
	}

	@Override
	public Vec2 normal(Vec2 res) { return mul(reciprocalLength(), res); }

	@Override
	public Vec2 normalSafe(Vec2 res) { return normalSafe(0.0, res); }

	@Override
	public Vec2 normalSafe(double tolerance, Vec2 res)
	{
		if(res == null) res = new Vec2f();
		if(isZero(tolerance)) return res.set(0.0);
		return mul(reciprocalLengthSafe(tolerance), res);
	}

	@Override
	public double dot(ITup2R t)
	{
		return this.x * t.getUniX() + this.y * t.getUniY();
	}

	@Override
	public double dot(double x, double y)
	{
		return this.x * x + this.y * y;
	}

	@Override
	public boolean isFinite()
	{
		return Float.isFinite(this.x) && Float.isFinite(this.y);
	}


	@Override
	public boolean isZero() { return isZero(0.0); }
	
	@Override
	public boolean isZero(double tolerance)
	{
		if(tolerance == 0.0) return this.x == 0.0 && this.y == 0.0;
		return Math.abs(x) <= tolerance && Math.abs(y) <= tolerance;
	}

	@Override
	public Vec2 snapToGrid(ITup2R grid, Vec2 res)
	{
		return snapToGrid(grid.getUniX(), grid.getUniY(), res);
	}

	@Override
	public Vec2 snapToGrid(double gx, double gy, Vec2 res)
	{
		if(res == null) res = new Vec2f();
		return res.set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy));
	}

}
