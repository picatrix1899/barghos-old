package org.barghos.math.vector.vec2;

import org.barghos.core.Check;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple2.api.ITup2R;
import org.barghos.math.vector.vec2.api.Vec2;


public class Vec2dPool
{
	private static final IPool<Vec2> pool = new DequePool<>(Vec2d.class);
	
	private Vec2dPool() { }
	
	public static Vec2 get() { return pool.get().set(0.0); }
	public static Vec2 get(ITup2R v) { assert(v != null); return pool.get().set(v); }
	public static Vec2 get(double scalar) { return pool.get().set(scalar); }
	public static Vec2 get(double x, double y) { return pool.get().set(x, y); }
	
	public static void ensure(int count) { assert(count >= 0); pool.ensure(count); }
	
	public static void store(Vec2... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
