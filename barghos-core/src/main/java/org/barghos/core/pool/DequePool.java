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

package org.barghos.core.pool;

import java.lang.reflect.Constructor;

import java.util.ArrayDeque;
import java.util.Deque;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.pool.api.IPool;

/**
 * This class can store instances of a type T for later reuse.
 */
public class DequePool<T> implements IPool<T>
{
	private final Deque<T> store = new ArrayDeque<T>();
	
	private int size;
	
	private Class<? extends T> clazz;
	
	/**
	 * Creates a new Pool of the given type.
	 * The class of the type is required for creating new instances if the pool is empty.
	 * <br><br><b><u>Important:</u></b> The class needs a default constructor for being instanced by the pool.
	 * @param clazz The class of the used type.
	 */
	public DequePool(Class<? extends T> clazz)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(clazz == null) throw new ArgumentNullException("clazz");
		}
		
		this.clazz = clazz;
	}
	
	/**
	 * Creates a new Pool of the given type with the given amount of initial entries.
	 * The class of the type is required for creating new instances if the pool is empty.
	 * <br><br><b><u>Important:</u></b> The class needs a default constructor for being instanced by the pool.
	 * @param clazz The class of the used type.
	 * @param size The number of initial entries to pregenerate
	 */
	public DequePool(Class<? extends T> clazz, int size)
	{
		this(clazz);
	
		ensure(size);
	}

	public T get()
	{
		if(this.size > 0)
		{
			this.size--;
			return this.store.pop();
		}
		
		return getNew();
	}
	
	public int store(@SuppressWarnings("unchecked") T... t)
	{
		int count = 0;
		
		if(t.length > 0)
		{
			for(int i = 0; i < t.length; i++)
			{
				if(t[i] != null)
				{
					this.store.push(t[i]);
					this.size++;
					count++;
				}
			}
		}
		
		return count;
	}

	public T getNew()
	{
		try
		{
			Constructor<? extends T> c = this.clazz.getConstructor();
			
			return c.newInstance();
		}
		catch (Exception e)
		{
			throw new Error(e);
		}
	}

	public void ensure(int count)
	{
		if(count < 0) throw new IllegalArgumentException();
		if(count == 0) return;
		if(count <= this.size) return;
		
		int neededInstances = count - this.size;

		this.size += neededInstances;

		for(int i = 0; i < neededInstances; i++)
		{
			this.store.push(getNew());
		}
	}

	/**
	 * Returns the current instance count in the pool.
	 * @return the current instance count.
	 */
	public int size()
	{
		return this.size;
	}
	
	public String toString()
	{
		return "dequepool(size=" + this.size + ")";
	}
}
