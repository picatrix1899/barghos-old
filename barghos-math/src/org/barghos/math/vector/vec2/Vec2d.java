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

import org.barghos.core.tuple.tuple2.api.ITup2R;
import org.barghos.math.Maths;
import org.barghos.math.vector.vec2.api.IVec2d;
import org.barghos.math.vector.vec2.api.Vec2;

/**
 * @author picatrix1899
 *
 */
public class Vec2d implements IVec2d
{
	private double x;
	private double y;
	
	public Vec2d() { set(0); }
	
	public Vec2d(ITup2R t) { assert(t != null); set(t); }
	
	public Vec2d(double scalar) { set(scalar); }
	
	public Vec2d(double x, double y) { set(x, y); }
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	public IVec2d setX(double x) { this.x = x; return this; }
	
	public IVec2d setY(double y) { this.y = y; return this; }
	
	public Vec2 add(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(this.x + x, this.y + y);
	}
	
	public Vec2 sub(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(this.x - x, this.y - y);
	}
	
	public Vec2 mul(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(this.x * x, this.y * y);
	}
	
	public Vec2 div(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(this.x / x, this.y / y);
	}

	public double length()
	{
		return Maths.sqrt(squaredLength());
	}


	public double reciprocalLength()
	{
		return 1.0 / length();
	}


	public double squaredLength()
	{
		return this.x * this.x + this.y * this.y;
	}

	public double lengthSafe(double tolerance)
	{
		return isZero(tolerance) ? 0.0 : Maths.sqrt(squaredLength());
	}

	public double reciprocalLengthSafe(double tolerance)
	{
		return isZero(tolerance) ? 0.0 : 1.0 / length(); 
	}


	public Vec2 normal(Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return mul(reciprocalLength(), res);
	}


	public Vec2 normalSafe(double tolerance, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return mul(reciprocalLengthSafe(tolerance), res);
	}


	public double dot(double x, double y)
	{
		return this.x * x + this.y * y;
	}

	public Vec2 snapToGrid(double gx, double gy, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy));
	}


	public Vec2 abs(Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(Math.abs(this.x), Math.abs(this.y));
	}


	public Vec2 min(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(Math.min(this.x, x), Math.min(this.y, y));
	}


	public Vec2 max(double x, double y, Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return res.set(Math.max(this.x, x), Math.max(this.y, y));
	}


	public Vec2 invert(Vec2 res)
	{
		if(res == null) res = new Vec2d();
		return mul(-1, res);
	}
	
	public String toString()
	{
		return "vec2(" + this.x + ", " + this.y + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof Vec2d)) return false;
		Vec2d v = (Vec2d)obj;
		
		if(this.x != v.x) return false;
		if(this.y != v.y) return false;
		
		return true;
	}
	
	public Vec2 getNewInstance() { return new Vec2d(); }
}
