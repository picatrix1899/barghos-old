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
