package org.barghos.core.test.tuple.tuple3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.barghos.core.tuple.tuple3.Tup3d;

class Tup3dTest
{

	@Test
	void ctorEmptyTest()
	{
		Tup3d t = new Tup3d();
		assertEquals(0.0, t.getX());
		assertEquals(0.0, t.getY());
		assertEquals(0.0, t.getZ());
	}

	@Test
	void ctorCloneTest()
	{
		Tup3d t = new Tup3d(new Tup3d(1.2, 3.4, 5.6));
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertEquals(5.6, t.getZ());
	}
	
	@Test
	void ctorScalarTest()
	{
		Tup3d t = new Tup3d(1.2);
		assertEquals(1.2, t.getX());
		assertEquals(1.2, t.getY());
		assertEquals(1.2, t.getZ());
	}
	
	@Test
	void ctorComponentsTest()
	{
		Tup3d t = new Tup3d(1.2, 3.4, 5.6);
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertEquals(5.6, t.getZ());
	}
	
	@Test
	void setXTest()
	{
		Tup3d t = new Tup3d();
		Tup3d result = t.setX(1.2);
		assertEquals(1.2, t.getX());
		assertSame(t, result);
	}
	
	@Test
	void setYTest()
	{
		Tup3d t = new Tup3d();
		Tup3d result = t.setY(1.2);
		assertEquals(1.2, t.getY());
		assertSame(t, result);
	}
	
	@Test
	void setZTest()
	{
		Tup3d t = new Tup3d();
		Tup3d result = t.setZ(1.2);
		assertEquals(1.2, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void setCloneTest()
	{
		Tup3d t = new Tup3d();
		Tup3d result = t.set(new Tup3d(1.2, 3.4, 5.6));
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertEquals(5.6, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void setScalarTest()
	{
		Tup3d t = new Tup3d();
		Tup3d result = t.set(1.2);
		assertEquals(1.2, t.getX());
		assertEquals(1.2, t.getY());
		assertEquals(1.2, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void setComponentsTest()
	{
		Tup3d t = new Tup3d();
		Tup3d result = t.set(1.2, 3.4, 5.6);
		assertEquals(1.2, t.getX());
		assertEquals(3.4, t.getY());
		assertEquals(5.6, t.getZ());
		assertSame(t, result);
	}
	
	@Test
	void cloneTest()
	{
		Tup3d t = new Tup3d(1.2, 3.4, 5.6);
		Tup3d result = t.clone();
		assertEquals(1.2, result.getX());
		assertEquals(3.4, result.getY());
		assertEquals(5.6, result.getZ());
		assertNotSame(t, result);
	}
}
