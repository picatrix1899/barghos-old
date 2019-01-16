package org.barghos.core.pool.color;

import org.barghos.core.Pool;
import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.color.LDRColor4;

/**
 * This pool contains instances of the type LDRColor4.
 */
public class LDRColor4Pool
{
	private static final Pool<LDRColor4> pool = new Pool<LDRColor4>(LDRColor4.class);

	/**
	 * Returns an instance of LDRColor4 from the pool and resets it.
	 * @return A stored instance.
	 */
	public static LDRColor4 get() { return pool.get().set(0.0); }
	
	/**
	 * Returns an instance of LDRColor4 from the pool and sets its components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that contains the rgba values in unitspace.
	 * @return A stored instance.
	 */
	public static LDRColor4 get(ITup4R t) { return pool.get().set(t); }
	
	/**
	 * Returns an instance of LDRColor4 from the pool and sets its components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgba values are set to.
	 * @param scalar A scalar in unitspace.
	 * @return A stored instance.
	 */
	public static LDRColor4 get(float scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of LDRColor4 from the pool and sets its components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgba values are set to.
	 * @param scalar A scalar in colorrange.
	 * @return A stored instance.
	 */
	public static LDRColor4 get(int scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of LDRColor4 from the pool and sets its components to r, g, b and a.
	 * r, g, b and a are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The blue component.
	 * @return A stored instance.
	 */
	public static LDRColor4 get(float r, float g, float b, float a) { return pool.get().set(r, g, b, a); }
	
	/**
	 * Returns an instance of LDRColor4 from the pool and sets its components to r, g, b and a.
	 * r, g, b and a are interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @param a The blue component.
	 * @return A stored instance.
	 */
	public static LDRColor4 get(int r, int g, int b, int a) { return pool.get().set(r, g, b, a); }
	
	/**
	 * Stores LDRColor4 instances in the pool for late reuse.
	 * @param elements The instances to store.
	 */
	public static void store(LDRColor4 elements) { pool.store(elements); }
}
