package org.barghos.math.pool;

import org.barghos.core.Pool;
import org.barghos.core.api.tuple.ITup2dR;
import org.barghos.core.api.tuple.ITup2fR;
import org.barghos.math.vector.Vec2f;


public class Vec2fPool
{
	private static final Pool<Vec2f> pool = new Pool<Vec2f>(Vec2f.class);
	
	private Vec2fPool() { }
	
	public static Vec2f get() { return pool.get().set(0.0); }
	public static Vec2f get(ITup2fR v) { return pool.get().set(v); }
	public static Vec2f get(ITup2dR v) { return pool.get().set(v); }
	public static Vec2f get(double scalar) { return pool.get().set(scalar); }
	public static Vec2f get(double x, double y) { return pool.get().set(x, y); }
	
	public static void store(Vec2f instance) { pool.store(instance); }
}
