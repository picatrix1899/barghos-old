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

package org.barghos.core;


/**
 * @author picatrix1899
 *
 */
public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		float r0 = 5.0f;
		float a0 = 0.0f;
		float b0 = 2.0f;
		
		float r1 = 5.0f;
		float a1 = 0.0f;
		float b1 = 10.0f;
		
		float x = 3.0f;
		float y = 6.0f;
		
		boolean result = false;
		double res = 0.0f;
		
		//fall I
		// result = (2*b1*y - p2(b1) - p2(r0) + p2(r1)) == x;

		//result = p2(x-a0) + p2((y-b0)) == p2(r0);
		//result = p2(x) - 2*a0*x + p2(a0) + p2(y) - 2*b0*y + p2(b0) == p2(r0);
		//result = p2(x) - p2(x) - 2*a0*x + 2*a1*x + p2(a0) - p2(a1) + p2(y) - p2(y) - 2*b0*y + 2*b1*y + p2(b0) - p2(b1) == p2(r0) - p2(r1);
		//result = - 2*a0*x + 2*a1*x + p2(a0) - p2(a1) - 2*b0*y + 2*b1*y + p2(b0) - p2(b1) == p2(r0) - p2(r1);
		//result = 2*x*(-a0+a1) + p2(a0) - p2(a1) - 2*b0*y + 2*b1*y + p2(b0) - p2(b1) == p2(r0) - p2(r1);
		//result = (2*a1*x + p2(a0) - p2(a1) - 2*b0*y + 2*b1*y + p2(b0) - p2(b1) - p2(r0) + p2(r1)) / -2 / a0 == x;

		//result = -2*a0*x + p2(a0) + p2(y) - 2*b0*y + p2(b0) - p2(r0) == -2*a1*x + p2(a1) + p2(y) - 2*b1*y + p2(b1) - p2(r1);
		
		
		//-> result = (p2(b0) - p2(r0) + p2(r1) - p2(b1)) / (2*(b0-b1)) ==  y;
		
		result = Math.sqrt(-(p2((p2(b0) - p2(r0) + p2(r1) - p2(b1)) / (2*(b0-b1))) - 2*b0*(p2(b0) - p2(r0) + p2(r1) - p2(b1)) / (2*(b0-b1)) + p2(b0) -p2(r0)))  == x;
		
		res = Math.sqrt(-(p2(a0) + p2(y) - 2*b0*y + p2(b0) -p2(r0)));
		System.out.println(result);
		System.out.println(res);
	}

	public static double p2(double in)
	{
		return Math.pow(in, 2);
	}
}
