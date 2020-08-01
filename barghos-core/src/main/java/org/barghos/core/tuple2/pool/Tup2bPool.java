/*
MIT License

Copyright (c) 2020 picatrix1899

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

package org.barghos.core.tuple2.pool;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.pool.DequePool;
import org.barghos.core.pool.api.IPool;
import org.barghos.core.tuple2.Tup2b;
import org.barghos.core.tuple2.api.Tup2bR;

/**
 * This specialized instance pool contains instances of the type {@link Tup2b}.
 */
public final class Tup2bPool
{
	
	private static IPool<Tup2b> pool = new DequePool<>(Tup2b.class);
	
	private Tup2bPool() { }
	
	/**
	 * Returns an instance of {@link Tup2b} from the pool and resets it.
	 * @return A stored instance.
	 */
	public static Tup2b get()
	{
		return pool.get().set((byte)0);
	}
	
	/**
	 * Returns an instance of {@link Tup2b} from the pool and sets its components to the values of t.
	 * @param t A tuple that is used as initial values of the returned tuple.
	 * @return A stored instance.
	 */
	public static Tup2b get(Tup2bR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
		}
		
		return pool.get().set(t);
	}
	
	/**
	 * Returns an instance of {@link Tup2b} from the pool and sets its components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public static Tup2b get(byte scalar)
	{
		return pool.get().set(scalar);
	}
	
	/**
	 * Returns an instance of {@link Tup2b} from the pool and sets its components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 */
	public static Tup2b get(byte x, byte y)
	{
		return pool.get().set(x, y);
	}
	
	/**
	 * Ensures a certain amount of instances to be present in the pool at any time.
	 * A call to this method will eventually cause the pool to create instances to fullfill the ensured amount.
	 * @param count The amount of instances present in the pool at any time.
	 */
	public static void ensure(int count)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(count < 0) throw new IllegalArgumentException();
		}
		
		pool.ensure(count);
	}
	
	/**
	 * Stores {@link Tup2b} instances in the pool for later reuse.
	 * @param elements The instances to store.
	 */
	public static void store(Tup2b... instances)
	{
		pool.store(instances);
	}
	
	/** 
	 * Sets the internal used pool. This can be used for replacing the default pool
	 * by a more efficient pool or a debuggable pool.
	 * @param pool The new pool instance the specialized {@link Tup2bPool} should use internal. 
	 */
	public static void setInternalPool(IPool<Tup2b> pool)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(pool == null) throw new ArgumentNullException("pool");
		}
		
		Tup2bPool.pool = pool;
		}
	
	/**
	 * Returns the internal used pool instance.
	 * @return The internal used pool instance of the specialized pool {@link Tup2bPool}.
	 */
	public static IPool<Tup2b> getInternalPool()
	{
		return pool;
	}
	
}
