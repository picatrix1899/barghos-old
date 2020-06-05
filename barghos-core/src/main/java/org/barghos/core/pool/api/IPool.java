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
	int store(@SuppressWarnings("unchecked") T... instance);
	
	/**
	 * Returns the current instance count in the pool.
	 * @return the current instance count.
	 */
	int size();
}
