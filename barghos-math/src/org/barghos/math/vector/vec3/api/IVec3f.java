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
import org.barghos.core.tuple.tuple3.api.ITup3f;

/**
 * @author picatrix1899
 *
 */
public interface IVec3f extends IVec3fR, Vec3, ITup3f
{
	@Override
	IVec3f setX(double x);
	
	@Override
	IVec3f setY(double y);
	
	@Override
	IVec3f setZ(double z);
	
	
	@Override
	default IVec3f set(ITup3R t) { Vec3.super.set(t); return this; }
	
	@Override
	default IVec3f set(double scalar) { Vec3.super.set(scalar); return this; }
	
	@Override
	default IVec3f set(double x, double y, double z) { Vec3.super.set(x, y, z); return this; }
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 1.
	 */
	@Override
	default IVec3f set(int index, double value) { Vec3.super.set(index, value); return this; }
	
	default IVec3f add(ITup3R t) { Vec3.super.add(t); return this; }
	default IVec3f add(double scalar) { Vec3.super.add(scalar); return this; }
	default IVec3f add(double x, double y, double z) { Vec3.super.add(x, y, z); return this; }
	
	default IVec3f sub(ITup3R t) { Vec3.super.sub(t); return this; }
	default IVec3f sub(double scalar) { Vec3.super.sub(scalar); return this; }
	default IVec3f sub(double x, double y, double z) { Vec3.super.sub(x, y, z); return this; }
	
	default IVec3f mul(ITup3R t) { Vec3.super.mul(t); return this; }
	default IVec3f mul(double scalar) { Vec3.super.mul(scalar); return this; }
	default IVec3f mul(double x, double y, double z) { Vec3.super.mul(x, y, z); return this; }
	
	default IVec3f div(ITup3R t) { Vec3.super.div(t); return this; }
	default IVec3f div(double scalar) { Vec3.super.div(scalar); return this; }
	default IVec3f div(double x, double y, double z) { Vec3.super.div(x, y, z); return this; }

	default IVec3f cross(ITup3R t) { assert(t != null); cross(t, this); return this; }
	default IVec3f cross(double x, double y, double z) { cross(x, y, z, this); return this; }
	
	default IVec3f normal() { Vec3.super.normal(); return this; }
	
	default IVec3f normalSafe() { Vec3.super.normalSafe(); return this; }
	default IVec3f normalSafe(double tolerance) { Vec3.super.normalSafe(tolerance); return this; }
	
	default IVec3f invert() { Vec3.super.invert(); return this; }
	
	default IVec3f snapToGrid(ITup3R grid) { Vec3.super.snapToGrid(grid); return this; }
	default IVec3f snapToGrid(double gx, double gy, double gz) { Vec3.super.snapToGrid(gx, gy, gz); return this; }
	
	default IVec3f abs() { Vec3.super.abs(); return this; }
	
	default IVec3f min(ITup3R t) { Vec3.super.min(t); return this; }
	default IVec3f min(double scalar) { Vec3.super.min(scalar); return this; }
	default IVec3f min(double x, double y, double z) { Vec3.super.min(x, y, z); return this; }
	
	default IVec3f max(ITup3R t) { Vec3.super.max(t); return this; }
	default IVec3f max(double scalar) { Vec3.super.max(scalar); return this; }
	default IVec3f max(double x, double y, double z) { Vec3.super.max(x, y, z); return this; }
}
