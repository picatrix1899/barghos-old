package org.barghos.math.vector;

import org.barghos.core.Check;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.pool.DequePool;

public class QuatPool
{
	private static final IPool<Quat> pool = new DequePool<>(Quat.class);
	
	private QuatPool() { }
	
	public static Quat get() { return pool.get().set(1.0f, 0.0f, 0.0f, 0.0f); }
	public static Quat get(Quat q) { assert(q != null); return pool.get().set(q); }
	public static Quat get(float x, float y, float z, float w) { return pool.get().set(x ,y ,z ,w); }
	
	public static void store(Quat... instances) { assert(Check.notNull(instances)); pool.store(instances); }
	
	public static void ensure(int count) { assert(count > 0); pool.ensure(count); }
}
