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

package org.barghos.math.vector.vec3.api;

import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.core.tuple.tuple3.api.Tup3;

/**
 * @author picatrix1899
 *
 */
public interface Vec3 extends IVec3R, Tup3
{
	@Override
	Vec3 setX(double x);

	@Override
	Vec3 setY(double y);

	@Override
	Vec3 setZ(double z);
	
	@Override
	default Vec3 set(ITup3R t) { Tup3.super.set(t); return this; }

	@Override
	default Vec3 set(double scalar) { Tup3.super.set(scalar); return this; }

	@Override
	default Vec3 set(double x, double y, double z) { Tup3.super.set(x, y, z); return this; }

	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 1.
	 */
	@Override
	default Vec3 set(int index, double value) { Tup3.super.set(index, value); return this; }
	
	default Vec3 add(ITup3R t) { assert(t != null); return add(t, this); }
	default Vec3 add(double scalar) { return add(scalar, this); }
	default Vec3 add(double x, double y, double z) { return add(x, y, z, this); }
	default Vec3 add(ITup3R t, Vec3 res) { assert(t != null); return add(t.getUniX(), t.getUniY(), t.getUniZ(), res); }
	default Vec3 add(double scalar, Vec3 res) { return add(scalar, scalar, scalar, res); }
	Vec3 add(double x, double y, double z, Vec3 res);
	
	default Vec3 sub(ITup3R t) { assert(t != null); return sub(t, this); }
	default Vec3 sub(double scalar) { return sub(scalar, this); }
	default Vec3 sub(double x, double y, double z) { return sub(x, y, z, this); }
	default Vec3 sub(ITup3R t, Vec3 res) { assert(t != null); return sub(t.getUniX(), t.getUniY(), t.getUniZ(), res); }
	default Vec3 sub(double scalar, Vec3 res) { return sub(scalar, scalar, scalar, res); }
	Vec3 sub(double x, double y, double z, Vec3 res);
	
	default Vec3 mul(ITup3R t) { assert(t != null); return mul(t, this); }
	default Vec3 mul(double scalar) { return mul(scalar, this); }
	default Vec3 mul(double x, double y, double z) { return mul(x, y, z, this); }
	default Vec3 mul(ITup3R t, Vec3 res) { assert(t != null); return mul(t.getUniX(), t.getUniY(), t.getUniZ(), res); }
	default Vec3 mul(double scalar, Vec3 res) { return mul(scalar, scalar, scalar, res); }
	Vec3 mul(double x, double y, double z, Vec3 res);
	
	default Vec3 div(ITup3R t) { assert(t != null); return div(t, this); }
	default Vec3 div(double scalar) { return div(scalar, this); }
	default Vec3 div(double x, double y, double z) { return div(x, y, z, this); }
	default Vec3 div(ITup3R t, Vec3 res) { assert(t != null); return div(t.getUniX(), t.getUniY(), t.getUniZ(), res); }
	default Vec3 div(double scalar, Vec3 res) { return div(scalar, scalar, scalar, res); }
	Vec3 div(double x, double y, double z, Vec3 res);
	
	double length();
	double reciprocalLength();
	double squaredLength();
	
	default double lengthSafe() { return lengthSafe(0.0); }
	double lengthSafe(double tolerance);
	
	default double reciprocalLengthSafe() { return reciprocalLengthSafe(0.0); }
	
	/**
	 * Returns the reciprocal of the length (1 / length). This method is zero-safe.
	 * It uses given tolerance as a threshold around zero.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	double reciprocalLengthSafe(double tolerance);
	
	default Vec3 normal() { return normal(this); }
	Vec3 normal(Vec3 res);
	
	default Vec3 normalSafe() { return normalSafe(this); }
	default Vec3 normalSafe(double tolerance) { return normalSafe(tolerance, this); }
	default Vec3 normalSafe(Vec3 res) { return normalSafe(0.0, res); }
	Vec3 normalSafe(double tolerance, Vec3 res);
	
	default Vec3 invert() { return invert(this); }
	Vec3 invert(Vec3 res);
	
	default double dot(ITup3R t) { assert(t != null); return dot(t.getUniX(), t.getUniY(), t.getUniZ()); }
	double dot(double x, double y, double z);
	
	default Vec3 cross(ITup3R t) { assert(t != null); return cross(t, this); }
	default Vec3 cross(double x, double y, double z) { return cross(x, y, z, this); }
	default Vec3 cross(ITup3R t, Vec3 res) { assert(t != null); return cross(t.getUniX(), t.getUniY(), t.getUniZ(), res); }
	Vec3 cross(double x, double y, double z, Vec3 res);
	
	default Vec3 snapToGrid(ITup3R grid) { assert(grid != null); return snapToGrid(grid, this); }
	default Vec3 snapToGrid(double gx, double gy, double gz) { return snapToGrid(gx, gy, gz, this); }
	default Vec3 snapToGrid(ITup3R grid, Vec3 res) { assert(grid != null); return snapToGrid(grid.getUniX(), grid.getUniY(), grid.getUniZ(), res); }
	Vec3 snapToGrid(double gx, double gy, double gz, Vec3 res);
	
	default Vec3 abs() { return abs(this); }
	Vec3 abs(Vec3 res);
	
	default Vec3 min(ITup3R t) { assert(t != null); return min(t, this); }
	default Vec3 min(double scalar) { return min(scalar, this); }
	default Vec3 min(double x, double y, double z) { return min(x, y, z, this); }
	default Vec3 min(ITup3R t, Vec3 res) { assert(t != null); return min(t.getUniX(), t.getUniY(), t.getUniZ(), res); }
	default Vec3 min(double scalar, Vec3 res) { return min(scalar, scalar, scalar, res); }
	Vec3 min(double x, double y, double z, Vec3 res);
	
	default Vec3 max(ITup3R t) { assert(t != null); return max(t, this); }
	default Vec3 max(double scalar) { return max(scalar, this); }
	default Vec3 max(double x, double y, double z) { return max(x, y, z, this); }
	default Vec3 max(ITup3R t, Vec3 res) { assert(t != null); return max(t.getUniX(), t.getUniY(), t.getUniZ(), res); }
	default Vec3 max(double scalar, Vec3 res) { return max(scalar, scalar, scalar, res); }
	Vec3 max(double x, double y, double z, Vec3 res);
	
	Vec3 getNewInstance();
}
