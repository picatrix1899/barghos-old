package org.barghos.core.test.tuple.tuple2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.barghos.core.tuple.tuple2.Tup2d;

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
}
