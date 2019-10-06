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
import org.barghos.core.tuple.tuple2.api.Tup2;

/**
 * This pool contains instances of the type Tup2d.
 */
public class Tup2dPool
{
	private static final IPool<Tup2> pool = new DequePool<>(Tup2d.class);
	
	/**
	 * Returns an instance of Tup2d from the pool and resets it.
	 * @return A stored instance.
	 */
	public static Tup2 get() { return pool.get().set(0.0); }
	
	/**
	 * Returns an instance of Tup2d from the pool and sets its components to the values of t.
	 * @param t A tuple that is used as initial values of the returned tuple.
	 * @return A stored instance.
	 */
	public static Tup2 get(ITup2R t) { assert(t != null); return pool.get().set(t); }
	
	/**
	 * Returns an instance of Tup2d from the pool and sets its components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public static Tup2 get(double scalar) { return pool.get().set(scalar); }
	
	/**
	 * Returns an instance of Tup2d from the pool and sets its components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 */
	public static Tup2 get(double x, double y) { return pool.get().set(x, y); }
	
	/**
	 * Ensures a certain amount of instances to be present in the pool at any time.
	 * A call to this method will eventually cause the pool to create instances to fullfill the ensured amount.
	 * @param count The amount of instances present in the pool at any time.
	 */
	public static void ensure(int count) { assert(count >= 0); pool.ensure(count); }
	
	/**
	 * Stores Tup2d instances in the pool for later reuse.
	 * @param elements The instances to store.
	 */
	public static void store(Tup2... instances) { assert(Check.notNull(instances)); pool.store(instances); }
}
