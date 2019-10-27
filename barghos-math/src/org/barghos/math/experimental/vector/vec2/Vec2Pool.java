package org.barghos.math.experimental.vector.vec2;

import org.barghos.core.Check;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple2.Tup2fR;


public class Vec2Pool
{
	private static final IPool<Vec2> pool = new DequePool<>(Vec2.class);
	
	private Vec2Pool() { }
	
	public static Vec2 get() { return pool.get().set(0.0f); }
	public static Vec2 get(Tup2fR v) { assert(v != null); return pool.get().set(v); }
	public static Vec2 get(float scalar) { return pool.get().set(scalar); }
	public static Vec2 get(float x, float y) { return pool.get().set(x, y); }
	
	public static void ensure(int count) { assert(count >= 0); pool.ensure(count); }
	
	public static void store(Vec2... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
