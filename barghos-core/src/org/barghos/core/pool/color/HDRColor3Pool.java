package org.barghos.core.pool.color;

import org.barghos.core.Pool;
import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.color.HDRColor3;

/**
 * This pool contains instances of the type HDRColor3.
 */
public class HDRColor3Pool
{
	private static final Pool<HDRColor3> pool = new Pool<HDRColor3>(HDRColor3.class);

	/**
	 * Returns an instance of HDRColor3 from the pool and resets it.
	 * @return A stored instance.
	 */
	public static HDRColor3 get() { return pool.get().set(0.0); }
	
	/**
	 * Returns an instance of HDRColor3 from the pool and sets its components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param t A tuple that contains the rgb values in unitspace.
	 * @return A stored instance.
	 */
	public static HDRColor3 get(ITup3R t) { return pool.get().set(t); }
	
	/**
	 * Returns an instance of HDRColor3 from the pool and sets its components to scalar.
	 * scalar is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgb values are set to.
	 * @param scalar A scalar in unitspace.
	 * @return A stored instance.
	 */
	public static HDRColor3 get(double scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of HDRColor3 from the pool and sets its components to scalar.
	 * scalar is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * It is not actually "scaling" the rgb values!
	 * It is just a value that the rgb values are set to.
	 * @param scalar A scalar in colorrange.
	 * @return A stored instance.
	 */
	public static HDRColor3 get(int scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of HDRColor3 from the pool and sets its components to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return A stored instance.
	 */
	public static HDRColor3 get(float r, float g, float b) { return pool.get().set(r, g, b); }
	
	/**
	 * Returns an instance of HDRColor3 from the pool and sets its components to r, g and b.
	 * r, g and b are interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param r The red component.
	 * @param g The green component.
	 * @param b The blue component.
	 * @return A stored instance.
	 */
	public static HDRColor3 get(int r, int g, int b) { return pool.get().set(r, g, b); }
	
	/**
	 * Stores a HDRColor3 instance in the pool for late reuse.
	 * @param element The instance to store.
	 */
	public static void store(HDRColor3 element) { pool.store(element); }
}
