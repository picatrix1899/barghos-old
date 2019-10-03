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
import org.barghos.core.tuple.tuple2.api.Tup2;

/**
 * @author picatrix1899
 *
 */
public interface Vec2 extends IVec2W, Tup2
{
	@Override
	Vec2 setX(double x);

	@Override
	Vec2 setY(double y);

	@Override
	Vec2 set(ITup2R t);

	@Override
	Vec2 set(double scalar);

	@Override
	Vec2 set(double x, double y);

	
	Vec2 add(ITup2R t, Vec2 res);
	Vec2 add(double scalar, Vec2 res);
	Vec2 add(double x, double y, Vec2 res);
	
	Vec2 sub(ITup2R t, Vec2 res);
	Vec2 sub(double scalar, Vec2 res);
	Vec2 sub(double x, double y, Vec2 res);
	
	Vec2 mul(ITup2R t, Vec2 res);
	Vec2 mul(double scalar, Vec2 res);
	Vec2 mul(double x, double y, Vec2 res);
	
	Vec2 div(ITup2R t, Vec2 res);
	Vec2 div(double scalar, Vec2 res);
	Vec2 div(double x, double y, Vec2 res);
	

	double length();
	double reciprocalLength();
	double squaredLength();
	
	double lengthSafe();
	double lengthSafe(double tolerance);
	
	double reciprocalLengthSafe();
	double reciprocalLengthSafe(double tolerance);
	
	Vec2 normal(Vec2 res);
	
	Vec2 normalSafe(Vec2 res);
	Vec2 normalSafe(double tolerance, Vec2 res);
	
	double dot(ITup2R t);
	double dot(double x, double y);
	
	boolean isFinite();
	boolean isZero();
	boolean iszero(double tolerance);
	
	Vec2 snapToGrid(ITup2R grid, Vec2 res);
	Vec2 snapToGrid(double gx, double gy, Vec2 res);
}
