package org.barghos.core.test.tuple.tuple3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.barghos.core.tuple.tuple3.PTup3d;
import org.barghos.core.tuple.tuple3.Tup3d;

class PTup3dTest
{

	@Test
	void genTupleTest()
	{
		PTup3d t = PTup3d.gen(new Tup3d(1.2, 3.4, 5.6));
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertEquals(5.6, t.getZ());
	}
	
	@Test
	void genScalarTest()
	{
		PTup3d t = PTup3d.gen(1.2);
		assertEquals(1.2, t.getX());
		assertEquals(1.2, t.getY());
		assertEquals(1.2, t.getZ());
	}

	@Test
	void genComponentsTest()
	{
		PTup3d t = PTup3d.gen(1.2, 3.4, 5.6);
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertEquals(5.6, t.getZ());
	}
	
	@Test
	void toStringTest()
	{
		PTup3d t = PTup3d.gen(1.2, 3.4, 5.6);
		assertEquals("ptup3d(x=1.2, y=3.4, z=5.6)", t.toString());
	}
	
	@Test
	void hashCodeTest()
	{
		PTup3d t = PTup3d.gen(1.2, 3.4, 5.6);
		assertEquals(-151489441, t.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		PTup3d t = PTup3d.gen(1.2, 3.4, 5.6);
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(PTup3d.gen(3.4, 3.4, 5.6)));
		assertFalse(t.equals(PTup3d.gen(1.2, 5.6, 5.6)));
		assertFalse(t.equals(PTup3d.gen(1.2, 3.4, 7.8)));
		
		assertTrue(t.equals(new Tup3d(1.2, 3.4, 5.6)));
		assertTrue(t.equals(PTup3d.gen(1.2, 3.4, 5.6)));
	}
}
