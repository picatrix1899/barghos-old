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

package org.barghos.core.tuple4;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple4.api.Tup4fR;
import org.barghos.core.tuple4.api.Tup4fW;

/**
 * @author picatrix1899
 *
 */
public class Tup4fHelper
{
	
	public static Tup4f min(Tup4fR a, Tup4fR b)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		
		return min(a.getX(), a.getY(), a.getZ(), a.getW(), b.getX(), b.getY(), b.getZ(), b.getW());
	}
	
	public static Tup4f min(Tup4fR a, float b)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return min(a.getX(), a.getY(), a.getZ(), a.getW(), b, b, b, b);
	}
	
	public static Tup4f min(Tup4fR a, float bX, float bY, float bZ, float bW)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return min(a.getX(), a.getY(), a.getZ(), a.getW(), bX, bY, bZ, bW);
	}
	
	public static Tup4f min(float a, Tup4fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return min(a, a, a, a, b.getX(), b.getY(), b.getZ(), b.getW());
	}
	
	public static Tup4f min(float aX, float aY, float aZ, float aW, Tup4fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return min(aX, aY, aZ, aW, b.getX(), b.getY(), b.getZ(), b.getW());
	}
	
	public static Tup4f min(float aX, float aY, float aZ, float aW, float bX, float bY, float bZ, float bW)
	{
		return new Tup4f(Math.min(aX, bX), Math.min(aY, bY), Math.min(aZ, bZ), Math.min(aW, bW));
	}
	
	public static <T extends Tup4fW> T min(Tup4fR a, Tup4fR b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), a.getZ(), a.getW(), b.getX(), b.getY(), b.getZ(), b.getW(), res);
	}
	
	public static <T extends Tup4fW> T min(Tup4fR a, float b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), a.getZ(), a.getW(), b, b, b, b, res);
	}
	
	public static <T extends Tup4fW> T min(Tup4fR a, float bX, float bY, float bZ, float bW, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), a.getZ(), a.getW(), bX, bY, bZ, bW, res);
	}
	
	public static <T extends Tup4fW> T min(float a, Tup4fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a, a, a, a, b.getX(), b.getY(), b.getZ(), b.getW(), res);
	}
	
	public static <T extends Tup4fW> T min(float aX, float aY, float aZ, float aW, Tup4fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(aX, aY, aZ, aW, b.getX(), b.getY(), b.getZ(), b.getW(), res);
	}
	
	public static <T extends Tup4fW> T min(float aX, float aY, float aZ, float aW, float bX, float bY, float bZ, float bW, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		res.set(Math.min(aX, bX), Math.min(aY, bY), Math.min(aZ, bZ), Math.min(aW, bW));
		return res;
	}
	
	public static Tup4f max(Tup4fR a, Tup4fR b)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		
		return max(a.getX(), a.getY(), a.getZ(), a.getW(), b.getX(), b.getY(), b.getZ(), b.getW());
	}
	
	public static Tup4f max(Tup4fR a, float b)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return max(a.getX(), a.getY(), a.getZ(), a.getW(), b, b, b, b);
	}
	
	public static Tup4f max(Tup4fR a, float bX, float bY, float bZ, float bW)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return max(a.getX(), a.getY(), a.getZ(), a.getW(), bX, bY, bZ, bW);
	}
	
	public static Tup4f max(float a, Tup4fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return max(a, a, a, a, b.getX(), b.getY(), b.getZ(), b.getW());
	}
	
	public static Tup4f max(float aX, float aY, float aZ, float aW, Tup4fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return max(aX, aY, aZ, aW, b.getX(), b.getY(), b.getZ(), b.getW());
	}
	
	public static Tup4f max(float aX, float aY, float aZ, float aW, float bX, float bY, float bZ, float bW)
	{
		return new Tup4f(Math.max(aX, bX), Math.max(aY, bY), Math.max(aZ, bZ), Math.max(aW, bW));
	}
	
	public static <T extends Tup4fW> T max(Tup4fR a, Tup4fR b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), a.getZ(), a.getW(), b.getX(), b.getY(), b.getZ(), b.getW(), res);
	}
	
	public static <T extends Tup4fW> T max(Tup4fR a, float b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), a.getZ(), a.getW(), b, b, b, b, res);
	}
	
	public static <T extends Tup4fW> T max(Tup4fR a, float bX, float bY, float bZ, float bW, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), a.getZ(), a.getW(), bX, bY, bZ, bW, res);
	}
	
	public static <T extends Tup4fW> T max(float a, Tup4fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a, a, a, a, b.getX(), b.getY(), b.getZ(), b.getW(), res);
	}
	
	public static <T extends Tup4fW> T max(float aX, float aY, float aZ, float aW, Tup4fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(aX, aY, aZ, aW, b.getX(), b.getY(), b.getZ(), b.getW(), res);
	}
	
	public static <T extends Tup4fW> T max(float aX, float aY, float aZ, float aW, float bX, float bY, float bZ, float bW, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.max(aX, bX), Math.max(aY, bY), Math.max(aZ, bZ), Math.max(aW, bW));
		return res;
	}
	
	public static Tup4f abs(Tup4fR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		
		return abs(t.getX(), t.getY(), t.getZ(), t.getW());
	}
	
	public static Tup4f abs(float x, float y, float z, float w)
	{
		return new Tup4f(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
	}
	
	public static <T extends Tup4fW> T abs(Tup4fR t, T res)
	{
		if(t == null) throw new ArgumentNullException("t");
		if(res == null) throw new ArgumentNullException("res");
		
		return abs(t.getX(), t.getY(), t.getZ(), t.getW(), res);
	}
	
	public static <T extends Tup4fW> T abs(float x, float y, float z, float w, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
		return res;
	}
	
	public static Tup4f sign(Tup4fR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		
		return sign(t.getX(), t.getY(), t.getZ(), t.getW());
	}
	
	public static Tup4f sign(float x, float y, float z, float w)
	{
		return new Tup4f(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1, z >= 0.0 ? 1 : -1, w >= 0.0 ? 1 : -1);
	}
	
	public static <T extends Tup4fW> T sign(Tup4fR t, T res)
	{
		if(t == null) throw new ArgumentNullException("t");
		if(res == null) throw new ArgumentNullException("res");
		
		return sign(t.getX(), t.getY(), t.getZ(), t.getW(), res);
	}
	
	public static <T extends Tup4fW> T sign(float x, float y, float z, float w, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1, z >= 0.0 ? 1 : -1, w >= 0.0 ? 1 : -1);
		return res;
	}
}
