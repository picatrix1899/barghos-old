package org.barghos.core.test.tuple.tuple2;

import static org.junit.jupiter.api.Assertions.*;

import org.barghos.core.tuple.tuple2.Tup2d;
import org.junit.jupiter.api.Test;

/**
 * Provides component tests for the class {@link Tup2d}.
 * 
 * @author picatrix1899
 */
class Tup2dTest
{
	
	/**
	 * Ensures, that the returned value from the function {@link Tup2d.getX()} is correct.
	 */
	@Test
	void getXTest()
	{
		Tup2d t = new Tup2d(1.2f, 2.4f);

		assertEquals(1.2f, t.getX());
	}

	/**
	 * Ensures, that the returned value from the function {@link Tup2d.getY()} is correct.
	 */
	@Test
	void getYTest()
	{
		Tup2d t = new Tup2d(1.2f, 2.4f);

		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2d()} initializes the components with 0.
	 */
	@Test
	void CTOREmptyTest()
	{
		Tup2d t = new Tup2d();
		
		assertEquals(0.0f, t.getX());
		assertEquals(0.0f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2d(float scalar)} initializes the components with scalar.
	 */
	@Test
	void CTORScalarTest()
	{
		Tup2d t = new Tup2d(1.2f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2d(float x, float y)} initializes the components with their corresponding values.
	 */
	@Test
	void CTORComponentsTest()
	{
		Tup2d t = new Tup2d(1.2f, 2.4f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2d(Tup2dR t)} adopts the components from t correctly.
	 */
	@Test
	void CTORCloneTest()
	{
		Tup2d t = new Tup2d(new Tup2d(1.2f, 2.4f));
		
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the function {@link Tup2d.setX(float x)} sets the x component correctly.
	 */
	@Test
	void setXTest()
	{
		Tup2d t = new Tup2d();

		t.setX(1.2f);
		
		assertEquals(1.2f, t.getX());
	}
	
	/**
	 * Ensures, that the function {@link Tup2d.setY(float y)} sets the y component correctly.
	 */
	@Test
	void setYTest()
	{
		Tup2d t = new Tup2d();

		t.setY(2.4f);
		
		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the function {@link Tup2d.setX(float x)} returns the current instance.
	 */
	@Test
	void setXReturnTest()
	{
		Tup2d t = new Tup2d();

		Tup2d t2 = t.setX(1.2f);
		
		assertSame(t, t2);
	}
	
	/**
	 * Ensures, that the function {@link Tup2d.setY(float y)} returns the current instance.
	 */
	@Test
	void setYReturnTest()
	{
		Tup2d t = new Tup2d();

		Tup2d t2 = t.setY(1.2f);
		
		assertSame(t, t2);
	}
	
	@Test
	void setCloneTest()
	{
		Tup2d t = new Tup2d();

		t.set(new Tup2d(1.2f, 2.4f));
		
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	@Test
	void setCloneAssertionsTest()
	{
		Tup2d t = new Tup2d();

		boolean exception = false;
		
		try
		{
			t.set((Tup2d)null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	@Test
	void setScalarTest()
	{
		Tup2d t = new Tup2d();

		t.set(1.2f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
	}
	
	@Test
	void setComponentsTest()
	{
		Tup2d t = new Tup2d();

		t.set(1.2f, 2.4f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	@Test
	void setCloneReturnTest()
	{
		Tup2d t = new Tup2d();

		Tup2d t2 = t.set(new Tup2d(1.2f, 2.4f));
		
		assertSame(t, t2);
	}
	
	@Test
	void setScalarReturnTest()
	{
		Tup2d t = new Tup2d();

		Tup2d t2 = t.set(1.2f);
		
		assertSame(t, t2);
	}
	
	@Test
	void setComponentsReturnTest()
	{
		Tup2d t = new Tup2d();

		Tup2d t2 = t.set(1.2f, 2.4f);
		
		assertSame(t, t2);
	}
}
