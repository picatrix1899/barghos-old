package org.barghos.math.vector.vec3;

import org.barghos.core.Check;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.math.vector.vec3.api.Vec3;


public class Vec3dPool
{
	private static final IPool<Vec3> pool = new DequePool<>(Vec3d.class);
	
	private Vec3dPool() { }
	
	public static Vec3 get() { return pool.get().set(0.0); }
	public static Vec3 get(ITup3R v) { assert(v != null); return pool.get().set(v); }
	public static Vec3 get(double scalar) { return pool.get().set(scalar); }
	public static Vec3 get(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void ensure(int count) { assert(count >= 0); pool.ensure(count); }
	
	public static void store(Vec3... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
