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

package org.barghos.core.tuple3;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple3.api.Tup3fR;
import org.barghos.core.tuple3.api.Tup3fW;

/**
 * @author picatrix1899
 *
 */
public class Tup3fHelper
{
	
	public static Tup3f min(Tup3fR a, Tup3fR b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(b == null) throw new ArgumentNullException("b");
		}
		
		return min(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
	}
	
	public static Tup3f min(Tup3fR a, float b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
		}
		
		return min(a.getX(), a.getY(), a.getZ(), b, b, b);
	}
	
	public static Tup3f min(Tup3fR a, float bX, float bY, float bZ)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
		}
		
		return min(a.getX(), a.getY(), a.getZ(), bX, bY, bZ);
	}
	
	public static Tup3f min(float a, Tup3fR b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
		}
		
		return min(a, a, a, b.getX(), b.getY(), b.getZ());
	}
	
	public static Tup3f min(float aX, float aY, float aZ, Tup3fR b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
		}
		
		return min(aX, aY, aZ, b.getX(), b.getY(), b.getZ());
	}
	
	public static Tup3f min(float aX, float aY, float aZ, float bX, float bY, float bZ)
	{
		return new Tup3f(Math.min(aX, bX), Math.min(aY, bY), Math.min(aZ, bZ));
	}
	
	public static <T extends Tup3fW> T min(Tup3fR a, Tup3fR b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(b == null) throw new ArgumentNullException("b");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return min(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ(), res);
	}
	
	public static <T extends Tup3fW> T min(Tup3fR a, float b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return min(a.getX(), a.getY(), a.getZ(), b, b, b, res);
	}
	
	public static <T extends Tup3fW> T min(Tup3fR a, float bX, float bY, float bZ, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return min(a.getX(), a.getY(), a.getZ(), bX, bY, bZ, res);
	}
	
	public static <T extends Tup3fW> T min(float a, Tup3fR b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return min(a, a, a, b.getX(), b.getY(), b.getZ(), res);
	}
	
	public static <T extends Tup3fW> T min(float aX, float aY, float aZ, Tup3fR b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return min(aX, aY, aZ, b.getX(), b.getY(), b.getZ(), res);
	}
	
	public static <T extends Tup3fW> T min(float aX, float aY, float aZ, float bX, float bY, float bZ, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(res == null) throw new ArgumentNullException("res");
		}
		
		res.set(Math.min(aX, bX), Math.min(aY, bY), Math.min(aZ, bZ));
		return res;
	}
	
	public static Tup3f max(Tup3fR a, Tup3fR b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(b == null) throw new ArgumentNullException("b");
		}
		
		return max(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
	}
	
	public static Tup3f max(Tup3fR a, float b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
		}
		
		return max(a.getX(), a.getY(), a.getZ(), b, b, b);
	}
	
	public static Tup3f max(Tup3fR a, float bX, float bY, float bZ)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
		}
		
		return max(a.getX(), a.getY(), a.getZ(), bX, bY, bZ);
	}
	
	public static Tup3f max(float a, Tup3fR b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
		}
		
		return max(a, a, a, b.getX(), b.getY(), b.getZ());
	}
	
	public static Tup3f max(float aX, float aY, float aZ, Tup3fR b)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
		}
		
		return max(aX, aY, aZ, b.getX(), b.getY(), b.getZ());
	}
	
	public static Tup3f max(float aX, float aY, float aZ, float bX, float bY, float bZ)
	{
		return new Tup3f(Math.max(aX, bX), Math.max(aY, bY), Math.max(aZ, bZ));
	}
	
	public static <T extends Tup3fW> T max(Tup3fR a, Tup3fR b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(b == null) throw new ArgumentNullException("b");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return max(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ(), res);
	}
	
	public static <T extends Tup3fW> T max(Tup3fR a, float b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return max(a.getX(), a.getY(), a.getZ(), b, b, b, res);
	}
	
	public static <T extends Tup3fW> T max(Tup3fR a, float bX, float bY, float bZ, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(a == null) throw new ArgumentNullException("a");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return max(a.getX(), a.getY(), a.getZ(), bX, bY, bZ, res);
	}
	
	public static <T extends Tup3fW> T max(float a, Tup3fR b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return max(a, a, a, b.getX(), b.getY(), b.getZ(), res);
	}
	
	public static <T extends Tup3fW> T max(float aX, float aY, float aZ, Tup3fR b, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(b == null) throw new ArgumentNullException("b");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return max(aX, aY, aZ, b.getX(), b.getY(), b.getZ(), res);
	}
	
	public static <T extends Tup3fW> T max(float aX, float aY, float aZ, float bX, float bY, float bZ, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(res == null) throw new ArgumentNullException("res");
		}
		
		res.set(Math.max(aX, bX), Math.max(aY, bY), Math.max(aZ, bZ));
		return res;
	}
	
	public static Tup3f abs(Tup3fR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return abs(t.getX(), t.getY(), t.getZ());
	}
	
	public static Tup3f abs(float x, float y, float z)
	{
		return new Tup3f(Math.abs(x), Math.abs(y), Math.abs(z));
	}
	
	public static <T extends Tup3fW> T abs(Tup3fR t, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return abs(t.getX(), t.getY(), t.getZ(), res);
	}
	
	public static <T extends Tup3fW> T abs(float x, float y, float z, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(res == null) throw new ArgumentNullException("res");
		}
		
		res.set(Math.abs(x), Math.abs(y), Math.abs(z));
		return res;
	}
	
	public static Tup3f sign(Tup3fR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return sign(t.getX(), t.getY(), t.getZ());
	}
	
	public static Tup3f sign(float x, float y, float z)
	{
		return new Tup3f(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1, z >= 0.0 ? 1 : -1);
	}
	
	public static <T extends Tup3fW> T sign(Tup3fR t, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(res == null) throw new ArgumentNullException("res");
		}
		
		return sign(t.getX(), t.getY(), t.getZ(), res);
	}
	
	public static <T extends Tup3fW> T sign(float x, float y, float z, T res)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(res == null) throw new ArgumentNullException("res");
		}
		
		res.set(x >= 0.0 ? 1 : -1, y >= 0.0 ? 1 : -1, z >= 0.0 ? 1 : -1);
		return res;
	}
}
