package org.barghos.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.barghos.core.exception.ArgumentNullException;

public class ExecutorServices
{
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads)
	{
		if(maxThreads <= 0) throw new IllegalArgumentException();
		
		return new ThreadPoolExecutor(0, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads, ThreadFactory threadFactory)
	{
		if(maxThreads <= 0) throw new IllegalArgumentException();
		if(threadFactory == null) throw new ArgumentNullException("threadFactory");
		
		return new ThreadPoolExecutor(0, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads)
	{
		if(minThreads < 0) throw new IllegalArgumentException();
		if(maxThreads <= 0) throw new IllegalArgumentException();
		
		return new ThreadPoolExecutor(minThreads, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads, ThreadFactory threadFactory)
	{
		if(minThreads < 0) throw new IllegalArgumentException();
		if(maxThreads <= 0) throw new IllegalArgumentException();
		if(threadFactory == null) throw new ArgumentNullException("threadFactory");
		
		return new ThreadPoolExecutor(minThreads, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads, long timeout, TimeUnit unit)
	{
		if(maxThreads <= 0) throw new IllegalArgumentException();
		
		return new ThreadPoolExecutor(0, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads, long timeout, TimeUnit unit, ThreadFactory threadFactory)
	{
		if(maxThreads <= 0) throw new IllegalArgumentException();
		if(threadFactory == null) throw new ArgumentNullException("threadFactory");
		
		return new ThreadPoolExecutor(0, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads, long timeout, TimeUnit unit)
	{
		if(minThreads < 0) throw new IllegalArgumentException();
		if(maxThreads <= 0) throw new IllegalArgumentException();
		
		return new ThreadPoolExecutor(minThreads, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads, long timeout, TimeUnit unit, ThreadFactory threadFactory)
	{
		if(minThreads < 0) throw new IllegalArgumentException();
		if(maxThreads <= 0) throw new IllegalArgumentException();
		if(threadFactory == null) throw new ArgumentNullException("threadFactory");
		
		return new ThreadPoolExecutor(minThreads, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
}
