package org.barghos.math.vector.vec3;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple3.Tup3fR;


public final class Vec3Pool
{
	private static IPool<Vec3> pool = new DequePool<>(Vec3.class);
	
	private Vec3Pool() { }
	
	public static Vec3 get() { return pool.get().set(0.0f, 0.0f, 0.0f); }
	public static Vec3 get(Tup3fR v) { if(v == null) throw new ArgumentNullException("v"); return pool.get().set(v); }
	public static Vec3 get(float x, float y, float z) { return pool.get().set(x, y, z); }
	
	public static void ensure(int count) { if(count < 0) throw new IllegalArgumentException(); pool.ensure(count); }
	
	public static void store(Vec3... instances) { pool.store(instances); }
	
	public static void setInternalPool(IPool<Vec3> pool) { if(pool == null) throw new ArgumentNullException("pool"); Vec3Pool.pool = pool; }
	public static IPool<Vec3> getInternalPool() { return pool; }
}
