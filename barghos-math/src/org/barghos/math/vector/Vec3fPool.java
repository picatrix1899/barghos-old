package org.barghos.math.vector;

import org.barghos.core.Check;
import org.barghos.core.api.tuple.ITup3dR;
import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;

public class Vec3fPool
{
	public static final IPool<Vec3f> DEFAULT_POOL = new DequePool<Vec3f>(Vec3f.class);
	
	private static IPool<Vec3f> pool = DEFAULT_POOL;
	
	private Vec3fPool() { }
	
	public static Vec3f get() { return pool.get().set(0.0); }
	public static Vec3f get(ITup3fR v) { assert(v != null); return pool.get().set(v); }
	public static Vec3f get(ITup3dR v) { assert(v != null); return pool.get().set(v); }
	public static Vec3f get(double scalar) { return pool.get().set(scalar); }
	public static Vec3f get(double x, double y, double z) { return pool.get().set(x, y, z); }
	
	public static void store(Vec3f... instances) { assert(Check.notNull(instances)); pool.store(instances); }
	
	public static void ensure(int count) { assert(count > 0); pool.ensure(count); }
	public static int size() { return pool.size(); }
	
	public static IPool<Vec3f> getInnerPool() { return Vec3fPool.pool; }
	public static void setInnerPool(IPool<Vec3f> pool) { Vec3fPool.pool = pool; }
}
