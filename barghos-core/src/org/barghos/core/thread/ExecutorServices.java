package org.barghos.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServices
{
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads)
	{
		return new ThreadPoolExecutor(0, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads, ThreadFactory threadFactory)
	{
		return new ThreadPoolExecutor(0, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads)
	{
		return new ThreadPoolExecutor(minThreads, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads, ThreadFactory threadFactory)
	{
		return new ThreadPoolExecutor(minThreads, maxThreads,
				60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads, long timeout, TimeUnit unit)
	{
		return new ThreadPoolExecutor(0, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int maxThreads, long timeout, TimeUnit unit, ThreadFactory threadFactory)
	{
		return new ThreadPoolExecutor(0, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads, long timeout, TimeUnit unit)
	{
		return new ThreadPoolExecutor(minThreads, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>());
	}
	
	public static ExecutorService newLimitedCachedThreadPool(int minThreads, int maxThreads, long timeout, TimeUnit unit, ThreadFactory threadFactory)
	{
		return new ThreadPoolExecutor(minThreads, maxThreads,
				timeout, unit,
                new SynchronousQueue<Runnable>(),
                threadFactory);
	}
}
