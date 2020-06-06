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
import org.junit.jupiter.api.Test;

import org.barghos.core.tuple.tuple2.PTup2d;
import org.barghos.core.tuple.tuple2.Tup2d;

class PTup2dTest
{

	@Test
	void genTupleTest()
	{
		PTup2d t = PTup2d.gen(new Tup2d(1.2, 3.4));
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
	}
	
	@Test
	void genScalarTest()
	{
		PTup2d t = PTup2d.gen(1.2);
		assertEquals(1.2, t.getX());
		assertEquals(1.2, t.getY());
	}

	@Test
	void genComponentsTest()
	{
		PTup2d t = PTup2d.gen(1.2, 3.4);
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
	}
	
	@Test
	void toStringTest()
	{
		PTup2d t = PTup2d.gen(1.2, 3.4);
		assertEquals("ptup2d(x=1.2, y=3.4)", t.toString());
	}
	
	@Test
	void hashCodeTest()
	{
		PTup2d t = PTup2d.gen(1.2, 3.4);
		assertEquals(-25689151, t.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		PTup2d t = PTup2d.gen(1.2, 3.4);
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(PTup2d.gen(3.4, 3.4)));
		assertFalse(t.equals(PTup2d.gen(1.2, 4.5)));
		
		assertTrue(t.equals(new Tup2d(1.2, 3.4)));
		assertTrue(t.equals(PTup2d.gen(1.2, 3.4)));	
	}
}
