package org.barghos.math.vector.vec3;

import org.barghos.core.Check;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple3.Tup3fR;


public class Vec3Pool
{
	private static final IPool<Vec3> pool = new DequePool<>(Vec3.class);
	
	private Vec3Pool() { }
	
	public static Vec3 get() { return pool.get().set(0.0f); }
	public static Vec3 get(Tup3fR v) { assert(v != null); return pool.get().set(v); }
	public static Vec3 get(float scalar) { return pool.get().set(scalar); }
	public static Vec3 get(float x, float y, float z) { return pool.get().set(x, y, z); }
	
	public static void ensure(int count) { assert(count >= 0); pool.ensure(count); }
	
	public static void store(Vec3... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
