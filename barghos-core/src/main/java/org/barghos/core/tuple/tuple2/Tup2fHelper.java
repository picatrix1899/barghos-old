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

package org.barghos.core.tuple.tuple2;

import org.barghos.core.exception.ArgumentNullException;

/**
 * @author picatrix1899
 *
 */
public class Tup2fHelper
{
	
	public static Tup2f min(Tup2fR a, Tup2fR b)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		
		return min(a.getX(), a.getY(), b.getX(), b.getY());
	}
	
	public static Tup2f min(Tup2fR a, float b)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return min(a.getX(), a.getY(), b, b);
	}
	
	public static Tup2f min(Tup2fR a, float bX, float bY)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return min(a.getX(), a.getY(), bX, bY);
	}
	
	public static Tup2f min(float a, Tup2fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return min(a, a, b.getX(), b.getY());
	}
	
	public static Tup2f min(float aX, float aY, Tup2fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return min(aX, aY, b.getX(), b.getY());
	}
	
	public static Tup2f min(float aX, float aY, float bX, float bY)
	{
		return new Tup2f(Math.min(aX, bX), Math.min(aY, bY));
	}
	
	public static <T extends Tup2fW> T min(Tup2fR a, Tup2fR b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), b.getX(), b.getY(), res);
	}
	
	public static <T extends Tup2fW> T min(Tup2fR a, float b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), b, b, res);
	}
	
	public static <T extends Tup2fW> T min(Tup2fR a, float bX, float bY, float bZ, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), bX, bY, res);
	}
	
	public static <T extends Tup2fW> T min(float a, Tup2fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a, a, b.getX(), b.getY(), res);
	}
	
	public static <T extends Tup2fW> T min(float aX, float aY, float aZ, Tup2fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(aX, aY, b.getX(), b.getY(), res);
	}
	
	public static <T extends Tup2fW> T min(float aX, float aY, float bX, float bY, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.min(aX, bX), Math.min(aY, bY));
		return res;
	}
	
	public static Tup2f max(Tup2fR a, Tup2fR b)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		
		return max(a.getX(), a.getY(), b.getX(), b.getY());
	}
	
	public static Tup2f max(Tup2fR a, float b)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return max(a.getX(), a.getY(), b, b);
	}
	
	public static Tup2f max(Tup2fR a, float bX, float bY, float bZ)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return max(a.getX(), a.getY(), bX, bY);
	}
	
	public static Tup2f max(float a, Tup2fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return max(a, a, b.getX(), b.getY());
	}
	
	public static Tup2f max(float aX, float aY, float aZ, Tup2fR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return max(aX, aY, b.getX(), b.getY());
	}
	
	public static Tup2f max(float aX, float aY, float bX, float bY)
	{
		return new Tup2f(Math.max(aX, bX), Math.max(aY, bY));
	}
	
	public static <T extends Tup2fW> T max(Tup2fR a, Tup2fR b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), b.getX(), b.getY(), res);
	}
	
	public static <T extends Tup2fW> T max(Tup2fR a, float b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), b, b, res);
	}
	
	public static <T extends Tup2fW> T max(Tup2fR a, float bX, float bY, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), bX, bY, res);
	}
	
	public static <T extends Tup2fW> T max(float a, Tup2fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a, a, b.getX(), b.getY(), res);
	}
	
	public static <T extends Tup2fW> T max(float aX, float aY, Tup2fR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(aX, aY, b.getX(), b.getY(), res);
	}
	
	public static <T extends Tup2fW> T max(float aX, float aY, float bX, float bY, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.max(aX, bX), Math.max(aY, bY));
		return res;
	}
	
	public static Tup2f abs(Tup2fR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		
		return abs(t.getX(), t.getY());
	}
	
	public static Tup2f abs(float x, float y)
	{
		return new Tup2f(Math.abs(x), Math.abs(y));
	}
	
	public static <T extends Tup2fW> T abs(Tup2fR t, T res)
	{
		if(t == null) throw new ArgumentNullException("t");
		if(res == null) throw new ArgumentNullException("res");
		
		return abs(t.getX(), t.getY(), res);
	}
	
	public static <T extends Tup2fW> T abs(float x, float y, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.abs(x), Math.abs(y));
		return res;
	}
	
	public static Tup2f sign(Tup2fR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		
		return sign(t.getX(), t.getY());
	}
	
	public static Tup2f sign(float x, float y)
	{
		return new Tup2f(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1);
	}
	
	public static <T extends Tup2fW> T sign(Tup2fR t, T res)
	{
		if(t == null) throw new ArgumentNullException("t");
		if(res == null) throw new ArgumentNullException("res");
		
		return sign(t.getX(), t.getY(), res);
	}
	
	public static <T extends Tup2fW> T sign(float x, float y, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1);
		return res;
	}
}
