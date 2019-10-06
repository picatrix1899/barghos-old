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
import org.barghos.core.tuple.tuple3.api.ITup3d;

/**
 * @author picatrix1899
 *
 */
public interface IVec3d extends IVec3dR, Vec3, ITup3d
{
	@Override
	IVec3d setX(double x);
	
	@Override
	IVec3d setY(double y);
	
	@Override
	IVec3d setZ(double z);
	
	
	@Override
	default IVec3d set(ITup3R t) { Vec3.super.set(t); return this; }
	
	@Override
	default IVec3d set(double scalar) { Vec3.super.set(scalar); return this; }
	
	@Override
	default IVec3d set(double x, double y, double z) { Vec3.super.set(x, y, z); return this; }
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 1.
	 */
	@Override
	default IVec3d set(int index, double value) { Vec3.super.set(index, value); return this; }
	
	default IVec3d add(ITup3R t) { Vec3.super.add(t); return this; }
	default IVec3d add(double scalar) { Vec3.super.add(scalar); return this; }
	default IVec3d add(double x, double y, double z) { Vec3.super.add(x, y, z); return this; }
	
	default IVec3d sub(ITup3R t) { Vec3.super.sub(t); return this; }
	default IVec3d sub(double scalar) { Vec3.super.sub(scalar); return this; }
	default IVec3d sub(double x, double y, double z) { Vec3.super.sub(x, y, z); return this; }
	
	default IVec3d mul(ITup3R t) { Vec3.super.mul(t); return this; }
	default IVec3d mul(double scalar) { Vec3.super.mul(scalar); return this; }
	default IVec3d mul(double x, double y, double z) { Vec3.super.mul(x, y, z); return this; }
	
	default IVec3d div(ITup3R t) { Vec3.super.div(t); return this; }
	default IVec3d div(double scalar) { Vec3.super.div(scalar); return this; }
	default IVec3d div(double x, double y, double z) { Vec3.super.div(x, y, z); return this; }

	default IVec3d cross(ITup3R t) { assert(t != null); cross(t, this); return this; }
	default IVec3d cross(double x, double y, double z) { cross(x, y, z, this); return this; }
	
	default IVec3d normal() { Vec3.super.normal(); return this; }
	
	default IVec3d normalSafe() { Vec3.super.normalSafe(); return this; }
	default IVec3d normalSafe(double tolerance) { Vec3.super.normalSafe(tolerance); return this; }
	
	default IVec3d invert() { Vec3.super.invert(); return this; }
	
	default IVec3d snapToGrid(ITup3R grid) { Vec3.super.snapToGrid(grid); return this; }
	default IVec3d snapToGrid(double gx, double gy, double gz) { Vec3.super.snapToGrid(gx, gy, gz); return this; }
	
	default IVec3d abs() { Vec3.super.abs(); return this; }
	
	default IVec3d min(ITup3R t) { Vec3.super.min(t); return this; }
	default IVec3d min(double scalar) { Vec3.super.min(scalar); return this; }
	default IVec3d min(double x, double y, double z) { Vec3.super.min(x, y, z); return this; }
	
	default IVec3d max(ITup3R t) { Vec3.super.max(t); return this; }
	default IVec3d max(double scalar) { Vec3.super.max(scalar); return this; }
	default IVec3d max(double x, double y, double z) { Vec3.super.max(x, y, z); return this; }
}
