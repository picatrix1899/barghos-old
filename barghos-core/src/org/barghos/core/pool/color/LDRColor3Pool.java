package org.barghos.core.pool.color;

import org.barghos.core.Check;
import org.barghos.core.Pool;
import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.color.LDRColor3;

/**
 * This pool contains instances of the type LDRColor3.
 */
public class LDRColor3Pool
{
	private static final Pool<LDRColor3> pool = new Pool<LDRColor3>(LDRColor3.class);

	/**
	 * Returns an instance of LDRColor3 from the pool and resets it.
	 * @return A stored instance.
	 */
	public static LDRColor3 get() { return pool.get().set(0.0); }
	
	/**
	 * Returns an instance of LDRColor3 from the pool and sets its components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that contains the rgb values in unitspace.
	 * @return A stored instance.
	 */
	public static LDRColor3 get(ITup3R t) { assert(t != null); return pool.get().set(t); }
	
	/**
	 * Returns an instance of LDRColor3 from the pool and sets its components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgb values are set to.
	 * @param scalar A scalar in unitspace.
	 * @return A stored instance.
	 */
	public static LDRColor3 get(float scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of LDRColor3 from the pool and sets its components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgb values are set to.
	 * @param scalar A scalar in colorrange.
	 * @return A stored instance.
	 */
	public static LDRColor3 get(int scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of LDRColor3 from the pool and sets its components to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return A stored instance.
	 */
	public static LDRColor3 get(float r, float g, float b) { return pool.get().set(r, g, b); }
	
	/**
	 * Returns an instance of LDRColor3 from the pool and sets its components to r, g and b.
	 * r, g and b are interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return A stored instance.
	 */
	public static LDRColor3 get(int r, int g, int b) { return pool.get().set(r, g, b); }
	
	/**
	 * Stores LDRColor3 instances in the pool for late reuse.
	 * @param elements The instances to store.
	 */
	public static void store(LDRColor3... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
