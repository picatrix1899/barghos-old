package org.barghos.math.pool;

import org.barghos.core.Pool;
import org.barghos.core.api.tuple.ITup3dR;
import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.math.vector.Vec3f;

public class Vec3fPool
{
	private static final Pool<Vec3f> pool = new Pool<Vec3f>(Vec3f.class);
	
	private Vec3fPool() { }
	
	public static Vec3f get() { return pool.get().set(0.0); }
	public static Vec3f get(ITup3fR v) { return pool.get().set(v); }
	public static Vec3f get(ITup3dR v) { return pool.get().set(v); }
	public static Vec3f get(double scalar) { return pool.get().set(scalar); }
	public static Vec3f get(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void store(Vec3f instance) { pool.store(instance); }
}
