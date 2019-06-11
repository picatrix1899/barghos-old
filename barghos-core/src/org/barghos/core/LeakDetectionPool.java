package org.barghos.core;

public class LeakDetectionPool<T> extends Pool<T>
{

	int out = 0;
	int in = 0;
	
	public LeakDetectionPool(Class<T> clazz)
	{
		super(clazz);
	}

	public T get()
	{
		out++;
		return super.get();
	}
	
	public void store(T... t)
	{
		in += t.length;
		super.store(t);
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
}
