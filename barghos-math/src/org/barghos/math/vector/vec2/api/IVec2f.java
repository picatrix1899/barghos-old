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

package org.barghos.math.vector.vec2.api;

import org.barghos.core.tuple.tuple2.api.ITup2R;
import org.barghos.core.tuple.tuple2.api.ITup2f;

/**
 * @author picatrix1899
 *
 */
public interface IVec2f extends IVec2fR, Vec2, ITup2f
{
	@Override
	IVec2f setX(double x);
	
	@Override
	IVec2f setY(double y);
	
	
	@Override
	default IVec2f set(ITup2R t) { Vec2.super.set(t); return this; }
	
	@Override
	default IVec2f set(double scalar) { Vec2.super.set(scalar); return this; }
	
	@Override
	default IVec2f set(double x, double y) { Vec2.super.set(x, y); return this; }
	
	/**
	 * {@inheritDoc}
	 * @throws IndexOutOfBoundsException Thrown when the given index is smaller than 0 or greater than 1.
	 */
	@Override
	default IVec2f set(int index, double value) { Vec2.super.set(index, value); return this; }
	
	default IVec2f add(ITup2R t) { Vec2.super.add(t); return this; }
	default IVec2f add(double scalar) { Vec2.super.add(scalar); return this; }
	default IVec2f add(double x, double y) { Vec2.super.add(x, y); return this; }
	
	default IVec2f sub(ITup2R t) { Vec2.super.sub(t); return this; }
	default IVec2f sub(double scalar) { Vec2.super.sub(scalar); return this; }
	default IVec2f sub(double x, double y) { Vec2.super.sub(x, y); return this; }
	
	default IVec2f mul(ITup2R t) { Vec2.super.mul(t); return this; }
	default IVec2f mul(double scalar) { Vec2.super.mul(scalar); return this; }
	default IVec2f mul(double x, double y) { Vec2.super.mul(x, y); return this; }
	
	default IVec2f div(ITup2R t) { Vec2.super.div(t); return this; }
	default IVec2f div(double scalar) { Vec2.super.div(scalar); return this; }
	default IVec2f div(double x, double y) { Vec2.super.div(x, y); return this; }


	default IVec2f normal() { Vec2.super.normal(); return this; }
	
	default IVec2f normalSafe() { Vec2.super.normalSafe(); return this; }
	default IVec2f normalSafe(double tolerance) { Vec2.super.normalSafe(tolerance); return this; }
	
	default IVec2f invert() { Vec2.super.invert(); return this; }
	
	default IVec2f snapToGrid(ITup2R grid) { Vec2.super.snapToGrid(grid); return this; }
	default IVec2f snapToGrid(double gx, double gy) { Vec2.super.snapToGrid(gx, gy); return this; }
	
	default IVec2f abs() { Vec2.super.abs(); return this; }
	
	default IVec2f min(ITup2R t) { Vec2.super.min(t); return this; }
	default IVec2f min(double scalar) { Vec2.super.min(scalar); return this; }
	default IVec2f min(double x, double y) { Vec2.super.min(x, y); return this; }
	
	default IVec2f max(ITup2R t) { Vec2.super.max(t); return this; }
	default IVec2f max(double scalar) { Vec2.super.max(scalar); return this; }
	default IVec2f max(double x, double y) { Vec2.super.max(x, y); return this; }
}
