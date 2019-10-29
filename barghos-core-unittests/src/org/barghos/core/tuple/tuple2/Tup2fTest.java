package org.barghos.core.tuple.tuple2;

import static org.junit.jupiter.api.Assertions.*;

import org.barghos.core.BarghosCoreUnitTests;
import org.junit.jupiter.api.Test;

/**
 * Provides component tests for the class {@link Tup2f}.
 * 
 * @author picatrix1899
 */
class Tup2fTest
{
	/**
	 * Ensures, that the returned value from the function {@link Tup2f.getX()} is correct.
	 */
	@Test
	void getXTest()
	{
		Tup2f t = new Tup2f(1.2f, 2.4f);

		assertEquals(1.2f, t.getX());
	}

	/**
	 * Ensures, that the returned value from the function {@link Tup2f.getY()} is correct.
	 */
	@Test
	void getYTest()
	{
		Tup2f t = new Tup2f(1.2f, 2.4f);

		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2f()} initializes the components with 0.
	 */
	@Test
	void CTOREmptyTest()
	{
		Tup2f t = new Tup2f();
		
		assertEquals(0.0f, t.getX());
		assertEquals(0.0f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2f(float scalar)} initializes the components with scalar.
	 */
	@Test
	void CTORScalarTest()
	{
		Tup2f t = new Tup2f(1.2f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2f(float x, float y)} initializes the components with their corresponding values.
	 */
	@Test
	void CTORComponentsTest()
	{
		Tup2f t = new Tup2f(1.2f, 2.4f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the empty constructor {@link Tup2f(Tup2fR t)} adopts the components from t correctly.
	 */
	@Test
	void CTORCloneTest()
	{
		Tup2f t = new Tup2f(new Tup2f(1.2f, 2.4f));
		
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the function {@link Tup2f.setX(float x)} sets the x component correctly.
	 */
	@Test
	void setXTest()
	{
		Tup2f t = new Tup2f();

		t.setX(1.2f);
		
		assertEquals(1.2f, t.getX());
	}
	
	/**
	 * Ensures, that the function {@link Tup2f.setY(float y)} sets the y component correctly.
	 */
	@Test
	void setYTest()
	{
		Tup2f t = new Tup2f();

		t.setY(2.4f);
		
		assertEquals(2.4f, t.getY());
	}
	
	/**
	 * Ensures, that the function {@link Tup2f.setX(float x)} returns the current instance.
	 */
	@Test
	void setXReturnTest()
	{
		Tup2f t = new Tup2f();

		Tup2f t2 = t.setX(1.2f);
		
		assertSame(t, t2);
	}
	
	/**
	 * Ensures, that the function {@link Tup2f.setY(float y)} returns the current instance.
	 */
	@Test
	void setYReturnTest()
	{
		Tup2f t = new Tup2f();

		Tup2f t2 = t.setY(1.2f);
		
		assertSame(t, t2);
	}
	
	@Test
	void setCloneTest()
	{
		Tup2f t = new Tup2f();

		boolean exception = false;
		
		try
		{
			t.set(new Tup2f(1.2f, 2.4f));
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertFalse(exception);
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	@Test
	void setCloneAssertionsTest()
	{
		if(BarghosCoreUnitTests.ASSERTS_ENABLED)
		{
			Tup2f t = new Tup2f();

			boolean exception = false;
			
			try
			{
				t.set((Tup2f)null);
			}
			catch(AssertionError e)
			{
				exception = true;
			}
			
			assertTrue(exception);
		}
	}
	
	@Test
	void setScalarTest()
	{
		Tup2f t = new Tup2f();

		t.set(1.2f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(1.2f, t.getY());
	}
	
	@Test
	void setComponentsTest()
	{
		Tup2f t = new Tup2f();

		t.set(1.2f, 2.4f);
		
		assertEquals(1.2f, t.getX());
		assertEquals(2.4f, t.getY());
	}
	
	@Test
	void setCloneReturnTest()
	{
		Tup2f t = new Tup2f();

		Tup2f t2 = t.set(new Tup2f(1.2f, 2.4f));
		
		assertSame(t, t2);
	}
	
	@Test
	void setScalarReturnTest()
	{
		Tup2f t = new Tup2f();

		Tup2f t2 = t.set(1.2f);
		
		assertSame(t, t2);
	}
	
	@Test
	void setComponentsReturnTest()
	{
		Tup2f t = new Tup2f();

		Tup2f t2 = t.set(1.2f, 2.4f);
		
		assertSame(t, t2);
	}
}
