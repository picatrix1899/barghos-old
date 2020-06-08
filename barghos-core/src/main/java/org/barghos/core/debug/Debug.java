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

package org.barghos.core.debug;

public class Debug
{
	public static boolean DEBUG_MODE = false;
	public static boolean PRINT_STACK_ELEMENT = false;
	
	public static void printCurrentStack()
	{
		if(DEBUG_MODE)
		{
			Thread.dumpStack();
		}
	}
	
	public static void print(boolean b)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(b);
		}
	}
	
	public static void print(char c)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(c);
		}
	}
	
	public static void print(char... c)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(c);
		}
	}
	
	public static void print(float f)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(f);
		}
	}
	
	public static void print(double d)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(d);
		}
	}
	
	public static void print(int i)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(i);
		}
	}
	
	public static void print(long l)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(l);
		}
	}
	
	public static void print(Object o)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(o);
		}
	}
	
	public static void print(String s)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.print(s);
		}
	}

	public static void println(boolean b)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(b);
		}
	}
	
	public static void println(char c)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(c);
		}
	}
	
	public static void println(char... c)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(c);
		}
	}
	
	public static void println(float f)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(f);
		}
	}
	
	public static void println(double d)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(d);
		}
	}
	
	public static void println(int i)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(i);
		}
	}
	
	public static void println(long l)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(l);
		}
	}
	
	public static void println(Object o)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(o);
		}
	}
	
	public static void println(String s)
	{
		if(DEBUG_MODE)
		{
			if(PRINT_STACK_ELEMENT) System.out.print(getCurrentStackElement() + ": ");
			System.out.println(s);
		}
	}
	
	private static String getCurrentStackElement()
	{
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		
		StackTraceElement element = elements[3];
		
		element.toString();
		
		return element.getClassName() + "." + element.getMethodName() + "(" + element.getFileName() +
				(element.getLineNumber() >= 0 ? ":" + element.getLineNumber() : "") + ")";
	}
}
