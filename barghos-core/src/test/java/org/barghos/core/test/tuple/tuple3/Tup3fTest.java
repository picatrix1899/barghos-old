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

package org.barghos.core.test.tuple.tuple3;

import static org.junit.jupiter.api.Assertions.*;

import org.barghos.core.tuple3.PTup3f;
import org.barghos.core.tuple3.Tup3f;
import org.junit.jupiter.api.Test;

class Tup3fTest
{

	@Test
	void ctorEmptyTest()
	{
		Tup3f t = new Tup3f();
		assertEquals(0.0f, t.getX());
		assertEquals(0.0f, t.getY());
		assertEquals(0.0f, t.getZ());
	}

	@Test
	void ctorCloneTest()
	{
		Tup3f t = new Tup3f(new Tup3f(1.2f, 3.4f, 5.6f));
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertEquals(5.6f, t.getZ());
	}
	
	@Test
	void ctorScalarTest()
	{
		Tup3f t = new Tup3f(1.2f);
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
		assertEquals(1.2f, t.getZ());
	}
	
	@Test
	void ctorComponentsTest()
	{
		Tup3f t = new Tup3f(1.2f, 3.4f, 5.6f);
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertEquals(5.6f, t.getZ());
	}
	
	@Test
	void setXTest()
	{
		Tup3f t = new Tup3f();
		Tup3f result = t.setX(1.2f);
		assertEquals(1.2f, t.getX());
		assertSame(t, result);
	}
	
	@Test
	void setYTest()
	{
		Tup3f t = new Tup3f();
		Tup3f result = t.setY(1.2f);
		assertEquals(1.2f, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setZTest()
	{
		Tup3f t = new Tup3f();
		Tup3f result = t.setZ(1.2f);
		assertEquals(1.2f, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void setCloneTest()
	{
		Tup3f t = new Tup3f();
		Tup3f result = t.set(new Tup3f(1.2f, 3.4f, 5.6f));
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertEquals(5.6f, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void setScalarTest()
	{
		Tup3f t = new Tup3f();
		Tup3f result = t.set(1.2f);
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
		assertEquals(1.2f, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void setComponentsTest()
	{
		Tup3f t = new Tup3f();
		Tup3f result = t.set(1.2f, 3.4f, 5.6f);
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertEquals(5.6f, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void cloneTest()
	{
		Tup3f t = new Tup3f(1.2f, 3.4f, 5.6f);
		Tup3f result = t.clone();
		assertEquals(1.2f, result.getX());
		assertEquals(3.4f, result.getY());
		assertEquals(5.6f, result.getZ());
		assertNotSame(t, result);
	}
	
	@Test
	void toStringTest()
	{
		Tup3f t = new Tup3f(1.2f, 3.4f, 5.6f);
		assertEquals("tup3f(x=1.2, y=3.4, z=5.6)", t.toString());
	}
	
	@Test
	void hashCodeTest()
	{
		Tup3f t = new Tup3f(1.2f, 3.4f, 5.6f);
		assertEquals(-886645678, t.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		Tup3f t = new Tup3f(1.2f, 3.4f, 5.6f);
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(new Tup3f(3.4f, 5.6f, 7.8f)));
		assertFalse(t.equals(new Tup3f(1.2f, 5.6f, 7.8f)));
		assertFalse(t.equals(new Tup3f(1.2f, 3.4f, 7.8f)));
		
		assertTrue(t.equals(new Tup3f(1.2f, 3.4f, 5.6f)));
		assertTrue(t.equals(PTup3f.gen(1.2f, 3.4f, 5.6f)));
	}
}
