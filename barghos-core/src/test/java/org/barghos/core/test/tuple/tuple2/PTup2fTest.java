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
