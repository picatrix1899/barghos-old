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

package org.barghos.core.tuple.tuple2;

import org.barghos.core.Check;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple.tuple2.api.ITup2R;

/**
 * This pool contains instances of the type Tup2f.
 */
public class Tup2fPool
{
	
	
	private static final IPool<Tup2f> pool = new DequePool<Tup2f>(Tup2f.class);
	
	/**
	 * Returns an instance of Tup4f from the pool and resets it.
	 * @return A stored instance.
	 */
	public static Tup2f get() { return pool.get().set(0.0); }
	
	/**
	 * Returns an instance of Tup4f from the pool and sets its components to the values of t.
	 * @param t A tuple that is used as initial values of the returned tuple.
	 * @return A stored instance.
	 */
	public static Tup2f get(ITup2R t) { assert(t != null); return pool.get().set(t); }
	
	/**
	 * Returns an instance of Tup4f from the pool and sets its components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public static Tup2f get(double scalar) { return pool.get().set(scalar, scalar); }
	
	/**
	 * Returns an instance of Tup4f from the pool and sets its components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 */
	public static Tup2f get(double x, double y) { return pool.get().set(x, y); }
	
	/**
	 * Stores Tup4f instances in the pool for late reuse.
	 * @param elements The instances to store.
	 */
	public static void store(Tup2f... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
