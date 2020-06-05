package org.barghos.math.vector.quat;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.pool.DequePool;

public final class QuatPool
{
	private static IPool<Quat> pool = new DequePool<>(Quat.class);
	
	private QuatPool() { }
	
	public static Quat get() { return pool.get().set(1.0f, 0.0f, 0.0f, 0.0f); }
	public static Quat get(Quat q) { if(q == null) throw new ArgumentNullException("q"); return pool.get().set(q); }
	public static Quat get(float x, float y, float z, float w) { return pool.get().set(x ,y ,z ,w); }
	
	public static void store(Quat... instances) { pool.store(instances); }
	
	public static void ensure(int count) { if(count < 0) throw new IllegalArgumentException(); pool.ensure(count); }
	
	public static void setInternalPool(IPool<Quat> pool) { if(pool == null) throw new ArgumentNullException("pool"); QuatPool.pool = pool; }
	public static IPool<Quat> getInternalPool() { return pool; }
}
