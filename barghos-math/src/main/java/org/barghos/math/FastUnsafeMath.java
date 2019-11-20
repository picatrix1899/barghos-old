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

package org.barghos.math;


/**
 * @author picatrix1899
 *
 */
public class FastUnsafeMath implements UnsafeMath
{

	private static FastUnsafeMath instance;
	
	public static FastUnsafeMath getInstance()
	{
		if(instance == null) instance = new FastUnsafeMath();
		return instance;
	}
	
	private FastUnsafeMath() { }
	
	public double sin(double r)
	{
		return Math.sin(r);
	}

	public double cos(double r)
	{
		return Math.cos(r);
	}

	public double sqrt(double n)
	{
		if(Math.abs(1.0 - n) < 2.107342e-08)
		{
			return (1 + n) * 0.5;
		}
		else
		{
			return Math.sqrt(n);
		}
	}

}
