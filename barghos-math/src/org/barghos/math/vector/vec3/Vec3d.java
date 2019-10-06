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

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.math.Maths;
import org.barghos.math.vector.vec3.api.IVec3d;
import org.barghos.math.vector.vec3.api.Vec3;

/**
 * @author picatrix1899
 *
 */
public class Vec3d implements IVec3d
{
	private double x;
	private double y;
	private double z;
	
	public Vec3d() { set(0); }
	
	public Vec3d(ITup3R t) { assert(t != null); set(t); }
	
	public Vec3d(double scalar) { set(scalar); }
	
	public Vec3d(double x, double y, double z) { set(x, y, z); }
	
	public double getX() { return this.x; }
	
	public double getY() { return this.y; }
	
	public double getZ() { return this.z; }
	
	public IVec3d setX(double x) { this.x = x; return this; }
	
	public IVec3d setY(double y) { this.y = y; return this; }
	
	public IVec3d setZ(double z) { this.z = z; return this; }
	
	public Vec3 add(double x, double y, double z, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(this.x + x, this.y + y, this.z + z);
	}
	
	public Vec3 sub(double x, double y, double z, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(this.x - x, this.y - y, this.z - z);
	}
	
	public Vec3 mul(double x, double y, double z, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(this.x * x, this.y * y, this.z * z);
	}
	
	public Vec3 div(double x, double y, double z, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(this.x / x, this.y / y, this.z / z);
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
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	public double lengthSafe(double tolerance)
	{
		return isZero(tolerance) ? 0.0 : Maths.sqrt(squaredLength());
	}

	public double reciprocalLengthSafe(double tolerance)
	{
		return isZero(tolerance) ? 0.0 : 1.0 / length(); 
	}

	public Vec3 cross(double x, double y, double z, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
	}

	public Vec3 normal(Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return mul(reciprocalLength(), res);
	}


	public Vec3 normalSafe(double tolerance, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return mul(reciprocalLengthSafe(tolerance), res);
	}


	public double dot(double x, double y, double z)
	{
		return this.x * x + this.y * y + this.z * z;
	}

	public Vec3 snapToGrid(double gx, double gy, double gz, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(Maths.gridSnap(this.x, gx), Maths.gridSnap(this.y, gy), Maths.gridSnap(this.z, gz));
	}


	public Vec3 abs(Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
	}


	public Vec3 min(double x, double y, double z, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
	}


	public Vec3 max(double x, double y, double z, Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return res.set(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
	}


	public Vec3 invert(Vec3 res)
	{
		if(res == null) res = new Vec3d();
		return mul(-1, res);
	}
	
	public String toString()
	{
		return "vec3(" + this.x + ", " + this.y + ", " + this.z + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof Vec3d)) return false;
		Vec3d v = (Vec3d)obj;
		
		if(this.x != v.x) return false;
		if(this.y != v.y) return false;
		if(this.z != v.z) return false;
		
		return true;
	}
	
	public Vec3 getNewInstance()
	{
		return new Vec3d();
	}
}
