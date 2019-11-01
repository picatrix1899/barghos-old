package org.barghos.core.pool.api;

/**
 * This interface provides access to the stored instances of a type in a pool.
 */
public interface IPool<T>
{
	/**
	 * Returns a stored instance and removes it from the pool.
	 * @return A stored instance.
	 */
	T get();
	
	/**
	 * Returns always a new instance.
	 * @return A new instance.
	 */
	T getNew();
	
	/**
	 * Ensures that the given amount of instances is present in the pool.
	 * @param count
	 */
	void ensure(int count);
	
	/**
	 * Stores one or more instances in the pool.
	 * @param t instances of the type of the pool.
	 */
	void store(@SuppressWarnings("unchecked") T... instance);
	
	/**
	 * Returns the current instance count in the pool.
	 * @return the current instance count.
	 */
	int size();
}
