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

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;

/**
 * This pool contains instances of the type Tup2f.
 */
public final class Tup2fPool
{
	private static IPool<Tup2f> pool = new DequePool<>(Tup2f.class);
	
	private Tup2fPool() { }
	
	/**
	 * Returns an instance of Tup2f from the pool and resets it.
	 * @return A stored instance.
	 */
	public static Tup2f get() { return pool.get().set(0.0f); }
	
	/**
	 * Returns an instance of Tup2f from the pool and sets its components to the values of t.
	 * @param t A tuple that is used as initial values of the returned tuple.
	 * @return A stored instance.
	 */
	public static Tup2f get(Tup2fR t) { if(t == null) throw new ArgumentNullException("t"); return pool.get().set(t); }
	
	/**
	 * Returns an instance of Tup2f from the pool and sets its components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public static Tup2f get(float scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of Tup2f from the pool and sets its components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 */
	public static Tup2f get(float x, float y) { return pool.get().set(x, y); }
	
	/**
	 * Ensures a certain amount of instances to be present in the pool at any time.
	 * A call to this method will eventually cause the pool to create instances to fullfill the ensured amount.
	 * @param count The amount of instances present in the pool at any time.
	 */
	public static void ensure(int count) { if(count < 0) throw new IllegalArgumentException(); pool.ensure(count); }
	
	/**
	 * Stores Tup2f instances in the pool for later reuse.
	 * @param elements The instances to store.
	 */
	public static void store(Tup2f... instances) { pool.store(instances); }
	
	public static void setInternalPool(IPool<Tup2f> pool) { if(pool == null) throw new ArgumentNullException("pool"); Tup2fPool.pool = pool; }
	public static IPool<Tup2f> getInternalPool() { return pool; }
}
