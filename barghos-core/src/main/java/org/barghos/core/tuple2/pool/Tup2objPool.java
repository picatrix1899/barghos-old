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
import org.barghos.core.tuple2.Tup2obj;
import org.barghos.core.tuple2.api.Tup2objR;

/**
 * This specialized instance pool contains instances of the type {@link Tup2obj}.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public final class Tup2objPool
{
	/**
	 * This variable contains the internal pool that is backing this specialized pool..
	 */
	private static IPool<Tup2obj> pool = new DequePool<>(Tup2obj.class);
	
	/**
	 * This class contains only static methods and therefore it should not be possible to create
	 * instances from it.
	 */
	private Tup2objPool() { }
	
	/**
	 * Returns an instance of {@link Tup2obj} from the pool and resets it.
	 * 
	 * @return A stored instance.
	 * 
	 * @since 1.0
	 */
	public static Tup2obj get()
	{
		return pool.get().set(new Object());
	}
	
	/**
	 * Returns an instance of {@link Tup2obj} from the pool and sets its components to the values of t.
	 * 
	 * @param t A tuple that is used as initial values of the returned tuple.
	 * 
	 * @return A stored instance.
	 * 
	 * @since 1.0
	 */
	public static Tup2obj get(Tup2objR t)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(t == null) throw new ArgumentNullException("t");
			if(t.getX() == null) throw new ArgumentNullException("t.getX()");
			if(t.getY() == null) throw new ArgumentNullException("t.GetY()");
		}
		
		return pool.get().set(t);
	}
	
	/**
	 * Returns an instance of {@link Tup2obj} from the pool and sets its components to value.
	 * 
	 * @param value A value that the components are set to.
	 * 
	 * @return A stored instance.
	 * 
	 * @since 1.0
	 */
	public static Tup2obj get(Object value)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(value == null) throw new ArgumentNullException("value");
		}
		
		return pool.get().set(value);
	}
	
	/**
	 * Returns an instance of {@link Tup2obj} from the pool and sets its components to x and y.
	 * 
	 * @param x The x component.
	 * @param y The y component.
	 * 
	 * @return A stored instance.
	 * 
	 * @since 1.0
	 */
	public static Tup2obj get(Object x, Object y)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(x == null) throw new ArgumentNullException("x");
			if(y == null) throw new ArgumentNullException("y");
		}
		
		return pool.get().set(x, y);
	}
	
	/**
	 * Ensures a certain amount of instances to be present in the pool at any time.
	 * A call to this method will eventually cause the pool to create instances to fullfill the ensured amount.
	 * 
	 * @param count The amount of instances present in the pool at any time.
	 * 
	 * @since 1.0
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
	 * Stores {@link Tup2obj} instances in the pool for later reuse.
	 * 
	 * @param elements The instances to store.
	 * 
	 * @since 1.0
	 */
	public static void store(Tup2obj... instances)
	{
		pool.store(instances);
	}
	
	/** 
	 * Sets the internal used pool. This can be used for replacing the default pool
	 * by a more efficient pool or a debuggable pool.
	 * 
	 * @param pool The new pool instance the specialized {@link Tup2objPool} should use internal.
	 * 
	 * @since 1.0
	 */
	public static void setInternalPool(IPool<Tup2obj> pool)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(pool == null) throw new ArgumentNullException("pool");
		}
		
		Tup2objPool.pool = pool;
	}
	
	/**
	 * Returns the internal used pool instance.
	 * 
	 * @return The internal used pool instance of the specialized pool {@link Tup2objPool}.
	 * 
	 * @since 1.0
	 */
	public static IPool<Tup2obj> getInternalPool()
	{
		return pool;
	}
}
