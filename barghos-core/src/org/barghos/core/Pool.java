package org.barghos.core;

import java.lang.reflect.Constructor;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This class can store instances of a type T for later reuse.
 */
public class Pool<T>
{
	private final Deque<T> store = new ArrayDeque<T>();
	
	private Class<T> clazz;
	
	/**
	 * Creates a new Pool of the given type.
	 * The class of the type is required for creating new instances if the pool is empty.
	 * <br><br><b><u>Important:</u></b> The class needs a default constructor for being instanced by the pool.
	 * @param clazz The class of the used type.
	 */
	public Pool(Class<T> clazz)
	{
		this.clazz = clazz;
	}
	
	/**
	 * Creates a new Pool of the given type with the given amount of initial entries.
	 * The class of the type is required for creating new instances if the pool is empty.
	 * <br><br><b><u>Important:</u></b> The class needs a default constructor for being instanced by the pool.
	 * @param clazz The class of the used type.
	 * @param size The number of initial entries to pregenerate
	 */
	public Pool(Class<T> clazz, int size)
	{
		this.clazz = clazz;
		
		try
		{
			for(int i = 0; i < size; i++)
				this.store.add(newInstance());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a new instance of the type of the pool.
	 * @return The new instance.
	 */
	private T newInstance()
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
	
	/**
	 * Returns the count of elements in the pool.
	 * @return The size
	 */
	public int size() { return this.store.size(); }
	
	/**
	 * Returns a stored instance and removes it from the pool.
	 * @return A stored instance.
	 */
	public T get()
	{
		if(this.store.size() > 0) return this.store.pop();
		
		try
		{
			return this.clazz.newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Stores one or more instances in the pool.
	 * @param t instances of the type of the pool.
	 */
	public void store(@SuppressWarnings("unchecked") T... t)
	{
		for(T element : t)
			this.store.push(element);
	}
	
}
