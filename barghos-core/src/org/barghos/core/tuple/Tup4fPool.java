package org.barghos.core.tuple;

import org.barghos.core.Check;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.pool.DequePool;

/**
 * This pool contains instances of the type Tup4f.
 */
public class Tup4fPool
{
	
	
	private static final IPool<Tup4f> pool = new DequePool<>(Tup4f.class);
	
	/**
	 * Returns an instance of Tup4f from the pool and resets it.
	 * @return A stored instance.
	 */
	public static Tup4f get() { return pool.get().set(0.0); }
	
	/**
	 * Returns an instance of Tup4f from the pool and sets its components to the values of t.
	 * @param t A tuple that is used as initial values of the returned tuple.
	 * @return A stored instance.
	 */
	public static Tup4f get(ITup4R t) { assert(t != null); return pool.get().set(t); }
	
	/**
	 * Returns an instance of Tup4f from the pool and sets its components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public static Tup4f get(double scalar) { return pool.get().set(scalar, scalar, scalar, scalar); }
	
	/**
	 * Returns an instance of Tup4f from the pool and sets its components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param w The w component.
	 */
	public static Tup4f get(double x, double y, double z, double w) { return pool.get().set(x, y, z, w); }
	
	/**
	 * Stores Tup4f instances in the pool for late reuse.
	 * @param elements The instances to store.
	 */
	public static void store(Tup4f... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
