package org.barghos.core.pool;

public class LeakDetectionPool<T> extends DequePool<T>
{
	int out = 0;
	int in = 0;
	
	public LeakDetectionPool(Class<T> clazz)
	{
		super(clazz);
	}

	public LeakDetectionPool(Class<T> clazz, int size)
	{
		super(clazz, size);
	}
	
	public T get()
	{
		out++;
		return super.get();
	}
	
	public int store(@SuppressWarnings("unchecked") T... t)
	{
		int count = super.store(t);
		in += count;
		return count;
	}
	
	public void startSession()
	{
		in = 0;
		out = 0;
	}
	
	public void stopSession()
	{
		
	}
	
	public int leakedEntities()
	{
		return out - in;
	}
	
	public String toString()
	{
		return "dequepool(size=" + size() + ", leaks=" + leakedEntities() + ")";
	}
}
