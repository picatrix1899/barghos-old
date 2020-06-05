package org.barghos.math.vector.vec4;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple4.Tup4fR;

public final class Vec4Pool
{
	private static IPool<Vec4> pool = new DequePool<>(Vec4.class);
	
	private Vec4Pool() { }
	
	public static Vec4 get() { return pool.get().set(0.0f, 0.0f, 0.0f, 0.0f); }
	public static Vec4 get(Tup4fR v) { if(v == null) throw new ArgumentNullException("v"); return pool.get().set(v); }
	public static Vec4 get(float x, float y, float z, float w) { return pool.get().set(x, y, z, w); }
	
	public static void ensure(int count) { if(count < 0) throw new IllegalArgumentException(); pool.ensure(count); }
	
	public static void store(Vec4... instances) { pool.store(instances); }
	
	public static void setInternalPool(IPool<Vec4> pool) { if(pool == null) throw new ArgumentNullException("pool"); Vec4Pool.pool = pool; }
	public static IPool<Vec4> getInternalPool() { return pool; }
}
