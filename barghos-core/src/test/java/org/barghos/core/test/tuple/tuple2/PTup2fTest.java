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

import org.barghos.core.tuple.tuple2.PTup2f;
import org.barghos.core.tuple.tuple2.Tup2f;

class PTup2fTest
{

	@Test
	void genTupleTest()
	{
		PTup2f t = PTup2f.gen(new Tup2f(1.2f, 3.4f));
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
	}
	
	@Test
	void genScalarTest()
	{
		PTup2f t = PTup2f.gen(1.2f);
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
	}

	@Test
	void genComponentsTest()
	{
		PTup2f t = PTup2f.gen(1.2f, 3.4f);
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
	}
	
	@Test
	void toStringTest()
	{
		PTup2f t = PTup2f.gen(1.2f, 3.4f);
		assertEquals("ptup2f(x=1.2, y=3.4)", t.toString());
	}
	
	@Test
	void hashCodeTest()
	{
		PTup2f t = PTup2f.gen(1.2f, 3.4f);
		assertEquals(-202164479, t.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		PTup2f t = PTup2f.gen(1.2f, 3.4f);
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(PTup2f.gen(3.4f, 3.4f)));
		assertFalse(t.equals(PTup2f.gen(1.2f, 4.5f)));
		
		assertTrue(t.equals(new Tup2f(1.2f, 3.4f)));
		assertTrue(t.equals(PTup2f.gen(1.2f, 3.4f)));
	}
}
