package org.barghos.core.color;

import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple4.Tup4fR;
import org.barghos.core.util.Check;
import org.barghos.core.pool.DequePool;

/**
 * This pool contains instances of the type HDRColor4.
 */
public class HDRColor4Pool
{
	private static final IPool<HDRColor4> pool = new DequePool<>(HDRColor4.class);

	/**
	 * Returns an instance of HDRColor4 from the pool and resets it.
	 * @return A stored instance.
	 */
	public static HDRColor4 get() { return pool.get().set(0.0f); }
	
	/**
	 * Returns an instance of HDRColor4 from the pool and sets its components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param t A tuple that contains the rgba values in unitspace.
	 * @return A stored instance.
	 */
	public static HDRColor4 get(Tup4fR t) { assert(t != null); return pool.get().set(t); }
	
	/**
	 * Returns an instance of HDRColor4 from the pool and sets its components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgba values are set to.
	 * @param scalar A scalar in unitspace.
	 * @return A stored instance.
	 */
	public static HDRColor4 get(float scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of HDRColor4 from the pool and sets its components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgba values are set to.
	 * @param scalar A scalar in colorrange.
	 * @return A stored instance.
	 */
	public static HDRColor4 get(int scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of HDRColor4 from the pool and sets its components to r, g, b and a.
	 * r, g, b and a are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The blue component.
	 * @return A stored instance.
	 */
	public static HDRColor4 get(float r, float g, float b, float a) { return pool.get().set(r, g, b, a); }
	
	/**
	 * Returns an instance of HDRColor4 from the pool and sets its components to r, g, b and a.
	 * r, g, b and a are interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The blue component.
	 * @return A stored instance.
	 */
	public static HDRColor4 get(int r, int g, int b, int a) { return pool.get().set(r, g, b, a); }
	
	/**
	 * Stores HDRColor4 instances in the pool for late reuse.
	 * @param elements The instances to store.
	 */
	public static void store(HDRColor4... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
