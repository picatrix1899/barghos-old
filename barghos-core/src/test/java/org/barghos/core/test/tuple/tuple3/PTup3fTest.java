package org.barghos.core.test.tuple.tuple3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.barghos.core.tuple.tuple3.PTup3f;
import org.barghos.core.tuple.tuple3.Tup3f;

class PTup3fTest
{

	@Test
	void genTupleTest()
	{
		PTup3f t = PTup3f.gen(new Tup3f(1.2f, 3.4f, 5.6f));
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertEquals(5.6f, t.getZ());
	}
	
	@Test
	void genScalarTest()
	{
		PTup3f t = PTup3f.gen(1.2f);
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
		assertEquals(1.2f, t.getZ());
	}

	@Test
	void genComponentsTest()
	{
		PTup3f t = PTup3f.gen(1.2f, 3.4f, 5.6f);
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertEquals(5.6f, t.getZ());
	}
	
	@Test
	void toStringTest()
	{
		PTup3f t = PTup3f.gen(1.2f, 3.4f, 5.6f);
		assertEquals("ptup3f(x=1.2, y=3.4, z=5.6)", t.toString());
	}
	
	@Test
	void hashCodeTest()
	{
		PTup3f t = PTup3f.gen(1.2f, 3.4f, 5.6f);
		assertEquals(-886645678, t.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		PTup3f t = PTup3f.gen(1.2f, 3.4f, 5.6f);
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(PTup3f.gen(3.4f, 3.4f, 5.6f)));
		assertFalse(t.equals(PTup3f.gen(1.2f, 5.6f, 5.6f)));
		assertFalse(t.equals(PTup3f.gen(1.2f, 3.4f, 7.8f)));
		
		assertTrue(t.equals(new Tup3f(1.2f, 3.4f, 5.6f)));
		assertTrue(t.equals(PTup3f.gen(1.2f, 3.4f, 5.6f)));
	}
}
