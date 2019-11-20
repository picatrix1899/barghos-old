package org.barghos.core.test.tuple.tuple2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.barghos.core.tuple.tuple2.PTup2f;
import org.barghos.core.tuple.tuple2.Tup2f;

class Tup2fTest
{

	@Test
	void ctorEmptyTest()
	{
		Tup2f t = new Tup2f();
		assertEquals(0.0f, t.getX());
		assertEquals(0.0f, t.getY());
	}

	@Test
	void ctorCloneTest()
	{
		Tup2f t = new Tup2f(new Tup2f(1.2f, 3.4f));
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
	}
	
	@Test
	void ctorScalarTest()
	{
		Tup2f t = new Tup2f(1.2f);
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
	}
	
	@Test
	void ctorComponentsTest()
	{
		Tup2f t = new Tup2f(1.2f, 3.4f);
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
	}
	
	@Test
	void setXTest()
	{
		Tup2f t = new Tup2f();
		Tup2f result = t.setX(1.2f);
		assertEquals(1.2f, t.getX());
		assertSame(t, result);
	}
	
	@Test
	void setYTest()
	{
		Tup2f t = new Tup2f();
		Tup2f result = t.setY(1.2f);
		assertEquals(1.2f, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setCloneTest()
	{
		Tup2f t = new Tup2f();
		Tup2f result = t.set(new Tup2f(1.2f, 3.4f));
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setScalarTest()
	{
		Tup2f t = new Tup2f();
		Tup2f result = t.set(1.2f);
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setComponentsTest()
	{
		Tup2f t = new Tup2f();
		Tup2f result = t.set(1.2f, 3.4f);
		assertEquals(1.2f, t.getX());
		assertEquals(3.4f, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void cloneTest()
	{
		Tup2f t = new Tup2f(1.2f, 3.4f);
		Tup2f result = t.clone();
		assertEquals(1.2f, result.getX());
		assertEquals(3.4f, result.getY());
		assertNotSame(t, result);
	}
	
	@Test
	void toStringTest()
	{
		Tup2f t = new Tup2f(1.2f, 3.4f);
		assertEquals("tup2f(x=1.2, y=3.4)", t.toString());
	}
	
	@Test
	void hashCodeTest()
	{
		Tup2f t = new Tup2f(1.2f, 3.4f);
		assertEquals(-202164479, t.hashCode());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void equalsTest()
	{
		Tup2f t = new Tup2f(1.2f, 3.4f);
		assertTrue(t.equals(t));
		assertFalse(t.equals(null));
		assertFalse(t.equals(0));
		assertFalse(t.equals(new Tup2f(3.4f, 5.6f)));
		assertFalse(t.equals(new Tup2f(1.2f, 5.6f)));
		
		assertTrue(t.equals(new Tup2f(1.2f, 3.4f)));
		assertTrue(t.equals(PTup2f.gen(1.2f, 3.4f)));
	}
}
