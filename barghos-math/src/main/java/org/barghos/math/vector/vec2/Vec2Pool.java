package org.barghos.math.vector.vec2;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple2.Tup2fR;


public final class Vec2Pool
{
	private static IPool<Vec2> pool = new DequePool<>(Vec2.class);
	
	private Vec2Pool() { }
	
	public static Vec2 get() { return pool.get().set(0.0f, 0.0f); }
	public static Vec2 get(Tup2fR v) { if(v == null) throw new ArgumentNullException("v"); return pool.get().set(v); }
	public static Vec2 get(float x, float y) { return pool.get().set(x, y); }
	
	public static void ensure(int count) { if(count < 0) throw new IllegalArgumentException(); pool.ensure(count); }
	
	public static void store(Vec2... instances) { pool.store(instances); }
	
	public static void setInternalPool(IPool<Vec2> pool) { if(pool == null) throw new ArgumentNullException("pool"); Vec2Pool.pool = pool; }
	public static IPool<Vec2> getInternalPool() { return pool; }
}
