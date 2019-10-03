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
	public Vec2f setX(double x) { this.x = (float)x; return this; }

	@Override
	public Vec2f setY(double y) { this.y = (float)y; return this; }

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

	public Vec2 mul(ITup2R t, Vec2 res) {  }

	public Vec2 mul(double scalar, Vec2 res)
	{
		return null;
	}

	public Vec2 mul(double x, double y, Vec2 res)
	{
		return null;
	}

	public Vec2 div(ITup2R t, Vec2 res)
	{
		return null;
	}

	public Vec2 div(double scalar, Vec2 res)
	{
		return null;
	}

	public Vec2 div(double x, double y, Vec2 res)
	{
		return null;
	}

	public double length()
	{
		return 0;
	}

	public double reciprocalLength()
	{
		return 0;
	}

	public double squaredLength()
	{
		return 0;
	}

	public double lengthSafe()
	{
		return 0;
	}

	public double lengthSafe(double tolerance)
	{
		return 0;
	}

	public double reciprocalLengthSafe()
	{
		return 0;
	}

	public double reciprocalLengthSafe(double tolerance)
	{
		return 0;
	}

	public Vec2 normal(Vec2 res)
	{
		return null;
	}

	public Vec2 normalSafe(Vec2 res)
	{
		return null;
	}

	public Vec2 normalSafe(double tolerance, Vec2 res)
	{
		return null;
	}

	public double dot(ITup2R t)
	{
		return 0;
	}

	public double dot(double x, double y)
	{
		return 0;
	}

	public boolean isFinite()
	{
		return false;
	}

	public boolean isZero()
	{
		return false;
	}

	public boolean iszero(double tolerance)
	{
		return false;
	}

	public Vec2 snapToGrid(ITup2R grid, Vec2 res)
	{
		return null;
	}

	public Vec2 snapToGrid(double gx, double gy, Vec2 res)
	{
		return null;
	}

}
