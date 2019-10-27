package org.barghos.math.vector.vec4;

import org.barghos.core.Check;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple4.Tup4fR;


public class Vec4Pool
{
	private static final IPool<Vec4> pool = new DequePool<>(Vec4.class);
	
	private Vec4Pool() { }
	
	public static Vec4 get() { return pool.get().set(0.0f); }
	public static Vec4 get(Tup4fR v) { assert(v != null); return pool.get().set(v); }
	public static Vec4 get(float scalar) { return pool.get().set(scalar); }
	public static Vec4 get(float x, float y, float z, float w) { return pool.get().set(x, y, z, w); }
	
	public static void ensure(int count) { assert(count >= 0); pool.ensure(count); }
	
	public static void store(Vec4... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
