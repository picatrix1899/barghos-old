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

package org.barghos.core.test.tuple.tuple2;

import static org.junit.jupiter.api.Assertions.*;

import org.barghos.core.tuple2.PTup2d;
import org.barghos.core.tuple2.Tup2d;
import org.junit.jupiter.api.Test;

class Tup2dTest
{
	@Test
	void ctorEmptyTest()
	{
		Tup2d t = new Tup2d();
		assertEquals(0.0, t.getX());
		assertEquals(0.0, t.getY());
	}

	@Test
	void ctorCloneTest()
	{
		Tup2d t = new Tup2d(new Tup2d(1.2, 3.4));
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
	}
	
	@Test
	void ctorScalarTest()
	{
		Tup2d t = new Tup2d(1.2);
		assertEquals(1.2, t.getX());
		assertEquals(1.2, t.getY());
	}
	
	@Test
	void ctorComponentsTest()
	{
		Tup2d t = new Tup2d(1.2, 3.4);
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
	}
	
	@Test
	void setXTest()
	{
		Tup2d t = new Tup2d();
		Tup2d result = t.setX(1.2);
		assertEquals(1.2, t.getX());
		assertSame(t, result);
	}
	
	@Test
	void setYTest()
	{
		Tup2d t = new Tup2d();
		Tup2d result = t.setY(1.2);
		assertEquals(1.2, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setCloneTest()
	{
		Tup2d t = new Tup2d();
		Tup2d result = t.set(new Tup2d(1.2, 3.4));
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setScalarTest()
	{
		Tup2d t = new Tup2d();
		Tup2d result = t.set(1.2);
		assertEquals(1.2, t.getX());
		assertEquals(1.2, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setComponentsTest()
	{
		Tup2d t = new Tup2d();
		Tup2d result = t.set(1.2, 3.4);
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void cloneTest()
	{
		Tup2d t = new Tup2d(1.2, 3.4);
		Tup2d result = t.clone();
		assertEquals(1.2, result.getX());
		assertEquals(3.4, result.getY());
		assertNotSame(t, result);
	}
	
	@Test
	void toStringTest()
	{
		Tup2d t = new Tup2d(1.2, 3.4);
		assertEquals("tup2d(x=1.2, y=3.4)", t.toString());
	}
	
	@Test
	void hashCodeTest()
	{
		Tup2d t = new Tup2d(1.2, 3.4);
		assertEquals(-25689151, t.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		Tup2d t = new Tup2d(1.2, 3.4);
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(new Tup2d(3.4, 5.6)));
		assertFalse(t.equals(new Tup2d(1.2, 5.6)));
		
		assertTrue(t.equals(new Tup2d(1.2, 3.4)));
		assertTrue(t.equals(PTup2d.gen(1.2, 3.4)));	
	}
}
