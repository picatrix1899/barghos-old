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
 * 
 * @author picatrix1899
 */
public class Tup2iHelper
{
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a or b is null.
	 */
	public static Tup2i min(Tup2iR a, Tup2iR b)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		
		return min(a.getX(), a.getY(), b.getX(), b.getY());
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if parameter a is null.
	 */
	public static Tup2i min(Tup2iR a, int b)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return min(a.getX(), a.getY(), b, b);
	}
	
	/**
	 * 
	 * @param a
	 * @param bX
	 * @param bY
	 * @return
	 * @throws ArgumentNullException Thrown if parameter a is null.
	 */
	public static Tup2i min(Tup2iR a, int bX, int bY)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return min(a.getX(), a.getY(), bX, bY);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if parameter b is null.
	 */
	public static Tup2i min(int a, Tup2iR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return min(a, a, b.getX(), b.getY());
	}
	
	/**
	 * 
	 * @param aX
	 * @param aY
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if parameter b is null.
	 */
	public static Tup2i min(int aX, int aY, Tup2iR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return min(aX, aY, b.getX(), b.getY());
	}
	
	public static Tup2i min(int aX, int aY, int bX, int bY)
	{
		return new Tup2i(Math.min(aX, bX), Math.min(aY, bY));
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a, b or res is null.
	 */
	public static <T extends Tup2iW> T min(Tup2iR a, Tup2iR b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), b.getX(), b.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a or res is null.
	 */
	public static <T extends Tup2iW> T min(Tup2iR a, int b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), b, b, res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param bX
	 * @param bY
	 * @param bZ
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a or res is null.
	 */
	public static <T extends Tup2iW> T min(Tup2iR a, int bX, int bY, int bZ, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a.getX(), a.getY(), bX, bY, res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter b or res is null.
	 */
	public static <T extends Tup2iW> T min(int a, Tup2iR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(a, a, b.getX(), b.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param aX
	 * @param aY
	 * @param aZ
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter b or res is null.
	 */
	public static <T extends Tup2iW> T min(int aX, int aY, int aZ, Tup2iR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return min(aX, aY, b.getX(), b.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param aX
	 * @param aY
	 * @param bX
	 * @param bY
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if parameter res is null.
	 */
	public static <T extends Tup2iW> T min(int aX, int aY, int bX, int bY, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.min(aX, bX), Math.min(aY, bY));
		return res;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a, b is null.
	 */
	public static Tup2i max(Tup2iR a, Tup2iR b)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		
		return max(a.getX(), a.getY(), b.getX(), b.getY());
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if parameter a is null.
	 */
	public static Tup2i max(Tup2iR a, int b)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return max(a.getX(), a.getY(), b, b);
	}
	
	/**
	 * 
	 * @param a
	 * @param bX
	 * @param bY
	 * @param bZ
	 * @return
	 * @throws ArgumentNullException Thrown if parameter a is null.
	 */
	public static Tup2i max(Tup2iR a, int bX, int bY, int bZ)
	{
		if(a == null) throw new ArgumentNullException("a");
		
		return max(a.getX(), a.getY(), bX, bY);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if parameter b is null.
	 */
	public static Tup2i max(int a, Tup2iR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return max(a, a, b.getX(), b.getY());
	}
	
	/**
	 * 
	 * @param aX
	 * @param aY
	 * @param aZ
	 * @param b
	 * @return
	 * @throws ArgumentNullException Thrown if parameter b is null.
	 */
	public static Tup2i max(int aX, int aY, int aZ, Tup2iR b)
	{
		if(b == null) throw new ArgumentNullException("b");
		
		return max(aX, aY, b.getX(), b.getY());
	}
	
	public static Tup2i max(int aX, int aY, int bX, int bY)
	{
		return new Tup2i(Math.max(aX, bX), Math.max(aY, bY));
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a, b or res is null.
	 */
	public static <T extends Tup2iW> T max(Tup2iR a, Tup2iR b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), b.getX(), b.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a or res is null.
	 */
	public static <T extends Tup2iW> T max(Tup2iR a, int b, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), b, b, res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param bX
	 * @param bY
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter a or res is null.
	 */
	public static <T extends Tup2iW> T max(Tup2iR a, int bX, int bY, T res)
	{
		if(a == null) throw new ArgumentNullException("a");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a.getX(), a.getY(), bX, bY, res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter b or res is null.
	 */
	public static <T extends Tup2iW> T max(int a, Tup2iR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(a, a, b.getX(), b.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param aX
	 * @param aY
	 * @param b
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter b or res is null.
	 */
	public static <T extends Tup2iW> T max(int aX, int aY, Tup2iR b, T res)
	{
		if(b == null) throw new ArgumentNullException("b");
		if(res == null) throw new ArgumentNullException("res");
		
		return max(aX, aY, b.getX(), b.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param aX
	 * @param aY
	 * @param bX
	 * @param bY
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if parameter res is null.
	 */
	public static <T extends Tup2iW> T max(int aX, int aY, int bX, int bY, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.max(aX, bX), Math.max(aY, bY));
		return res;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws ArgumentNullException Thrown if parameter t is null.
	 */
	public static Tup2i abs(Tup2iR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		
		return abs(t.getX(), t.getY());
	}
	
	public static Tup2i abs(int x, int y)
	{
		return new Tup2i(Math.abs(x), Math.abs(y));
	}
	
	/**
	 * 
	 * @param <T>
	 * @param t
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter r or res is null.
	 */
	public static <T extends Tup2iW> T abs(Tup2iR t, T res)
	{
		if(t == null) throw new ArgumentNullException("t");
		if(res == null) throw new ArgumentNullException("res");
		
		return abs(t.getX(), t.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param x
	 * @param y
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if parameter res is null.
	 */
	public static <T extends Tup2iW> T abs(int x, int y, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(Math.abs(x), Math.abs(y));
		return res;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws ArgumentNullException Thrown if parameter t is null.
	 */
	public static Tup2i sign(Tup2iR t)
	{
		if(t == null) throw new ArgumentNullException("t");
		
		return sign(t.getX(), t.getY());
	}
	
	public static Tup2i sign(int x, int y)
	{
		return new Tup2i(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param t
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if either parameter t or res is null.
	 */
	public static <T extends Tup2iW> T sign(Tup2iR t, T res)
	{
		if(t == null) throw new ArgumentNullException("t");
		if(res == null) throw new ArgumentNullException("res");
		
		return sign(t.getX(), t.getY(), res);
	}
	
	/**
	 * 
	 * @param <T>
	 * @param x
	 * @param y
	 * @param res
	 * @return
	 * @throws ArgumentNullException Thrown if parameter res is null.
	 */
	public static <T extends Tup2iW> T sign(int x, int y, T res)
	{
		if(res == null) throw new ArgumentNullException("res");
		
		res.set(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1);
		return res;
	}
}
