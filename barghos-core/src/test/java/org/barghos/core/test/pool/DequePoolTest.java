package org.barghos.core.test.pool;

import static org.junit.jupiter.api.Assertions.*;

import org.barghos.core.BufferUtils;
import org.barghos.core.pool.DequePool;
import org.barghos.core.tuple.tuple2.Tup2f;

import org.junit.jupiter.api.Test;


class DequePoolTest
{

	@Test
	void ctorTest()
	{
		DequePool<Tup2f> pool = new DequePool<>(Tup2f.class);
		
		assertEquals(0, pool.size());
	}
	
	@Test
	void ctorNoClassTest()
	{
		try
		{
			new DequePool<>(null);
		}
		catch(IllegalArgumentException e)
		{
			return;
		}
		
		fail();
	}
	
	@Test
	void ctorEnsuredTest()
	{
		DequePool<Tup2f> pool = new DequePool<>(Tup2f.class, 4);
		
		assertEquals(4, pool.size());
	}
	
	@Test
	void getNewTest()
	{
		DequePool<Tup2f> pool = new DequePool<>(Tup2f.class);

		Tup2f t = pool.getNew();
		
		assertEquals(0, pool.size());
		assertNotNull(t);
	}
	
	@Test
	void getNewNoStandardContructorTest()
	{
		DequePool<BufferUtils> pool = new DequePool<>(BufferUtils.class);
		
		try
		{
			pool.getNew();
		}
		catch(Error e)
		{
			return;
		}
		
		fail();
	}
	
	@Test
	void storeGetTest()
	{
		Tup2f t1 = new Tup2f();
		Tup2f t2 = new Tup2f();
		Tup2f t3 = new Tup2f();
		
		DequePool<Tup2f> pool = new DequePool<>(Tup2f.class);
		
		assertEquals(3, pool.store(t1, t2, t3));
		assertEquals(3, pool.size());
		assertSame(t3, pool.get());
		assertSame(t2, pool.get());
		assertSame(t1, pool.get());
		assertNotNull(pool.get());
		
		assertEquals(0, pool.store());
		assertEquals(0, pool.size());
		
		pool.store(t3);
		assertEquals(2, pool.store(t1, null, t2));
		assertEquals(3, pool.size());
		assertSame(t2, pool.get());
		assertSame(t1, pool.get());
		assertSame(t3, pool.get());
	}
	
	@Test
	void ensureTest()
	{
		Tup2f t1 = new Tup2f();
		Tup2f t2 = new Tup2f();
		
		DequePool<Tup2f> pool = new DequePool<>(Tup2f.class);
		pool.store(t1, t2);
		
		assertEquals(2, pool.size());
		
		pool.ensure(0);
		assertEquals(2, pool.size());
		
		pool.ensure(1);
		assertEquals(2, pool.size());

		pool.ensure(2);
		
		pool.ensure(4);
		assertEquals(4, pool.size());
		assertNotSame(t2, pool.get());
		assertNotSame(t2, pool.get());
		assertSame(t2, pool.get());
	}
	
	@Test
	void toStringTest()
	{
		DequePool<Tup2f> pool = new DequePool<>(Tup2f.class, 2);
		
		assertEquals("dequepool(size=2)", pool.toString());
	}
}
