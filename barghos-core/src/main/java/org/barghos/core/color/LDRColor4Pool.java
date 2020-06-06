/*
MIT License

Copyright (c) 2019 picatrix1899

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package org.barghos.core.color;

import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple4.Tup4fR;
import org.barghos.core.util.Check;
import org.barghos.core.pool.DequePool;

/**
 * This pool contains instances of the type LDRColor4.
 */
public class LDRColor4Pool
{
	private static final IPool<LDRColor4> pool = new DequePool<>(LDRColor4.class);

	/**
	 * Returns an instance of LDRColor4 from the pool and resets it.
	 * @return A stored instance.
	 */
	public static LDRColor4 get() { return pool.get().set(0.0f); }
	
	/**
	 * Returns an instance of LDRColor4 from the pool and sets its components to the values of t.
	 * the values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that contains the rgba values in unitspace.
	 * @return A stored instance.
	 */
	public static LDRColor4 get(Tup4fR t) { assert(t != null); return pool.get().set(t); }
	
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
	public static void store(LDRColor4... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
