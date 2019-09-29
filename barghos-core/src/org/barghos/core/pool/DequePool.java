package org.barghos.core.pool;

import java.lang.reflect.Constructor;

import java.util.ArrayDeque;
import java.util.Deque;

import org.barghos.core.pool.api.IPool;

/**
 * This class can store instances of a type T for later reuse.
 */
public class DequePool<T> implements IPool<T>
{
	private final Deque<T> store = new ArrayDeque<T>();
	
	private int size;
	
	private Class<T> clazz;
	
	/**
	 * Creates a new Pool of the given type.
	 * The class of the type is required for creating new instances if the pool is empty.
	 * <br><br><b><u>Important:</u></b> The class needs a default constructor for being instanced by the pool.
	 * @param clazz The class of the used type.
	 */
	public DequePool(Class<T> clazz)
	{
		assert(clazz != null);
		this.clazz = clazz;
	}
	
	/**
	 * Creates a new Pool of the given type with the given amount of initial entries.
	 * The class of the type is required for creating new instances if the pool is empty.
	 * <br><br><b><u>Important:</u></b> The class needs a default constructor for being instanced by the pool.
	 * @param clazz The class of the used type.
	 * @param size The number of initial entries to pregenerate
	 */
	public DequePool(Class<T> clazz, int size)
	{
		assert(clazz != null);
		assert(size > 0);
		this.clazz = clazz;
		
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
	
	public void store(@SuppressWarnings("unchecked") T... t)
	{
		assert(t != null);
		
		if(t.length > 0)
		{
			int i = 0;
			for(; i < t.length; i++)
			{
				this.store.push(t[i]);
				this.size++;
			}
		}
	}

	public T getNew()
	{
		try
		{
			Constructor<T> c = this.clazz.getConstructor();
			
			return c.newInstance();
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new Error();
		}
	}

	public void ensure(int count)
	{
		if(count <= this.size) return;
		
		int neededInstances = count - this.size;

		if(neededInstances > 0)
		{
			this.size += neededInstances;
			
			int i = 0;
			for(; i < neededInstances; i++)
			{
				this.store.push(getNew());
			}
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
	
}
