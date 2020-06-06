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

package org.barghos.core.future;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.barghos.core.thread.DaemonThread;

public class ManagedFuturePool<T>
{
	private ExecutorService threadPool;
	private CompletionService<T> compService;
	
	private Set<Future<T>> activeFutures = new HashSet<>();
	private int pendingFutures = 0;
	
	private Thread routine;
	private boolean isRunning = false;
	
	private ManagedFuturePoolFinishCallback<T> finishCallback;
	
	public ManagedFuturePool(ExecutorService executorService)
	{
		this.threadPool = executorService;
		this.compService = new ExecutorCompletionService<T>(this.threadPool);
		this.routine = new DaemonThread(() -> run());
	}
	
	public ManagedFuturePool(ExecutorService executorService, ManagedFuturePoolFinishCallback<T> finishCallback)
	{
		this.threadPool = executorService;
		this.compService = new ExecutorCompletionService<T>(this.threadPool);
		this.routine = new DaemonThread(() -> run());
		this.finishCallback = finishCallback;
	}
	
	public ManagedFuturePool(ExecutorService executorService, String threadname)
	{
		this(executorService);
		
		this.routine.setName(threadname);
	}
	
	public ManagedFuturePool(ExecutorService executorService, String threadname, ManagedFuturePoolFinishCallback<T> finishCallback)
	{
		this(executorService, finishCallback);
		
		this.routine.setName(threadname);
	}

	
	public void start()
	{
		this.isRunning = true;
		this.routine.start();
	}
	
	public void stop()
	{
		cancel();
		
		this.threadPool.shutdownNow();
		this.isRunning = false;
	}
	
	public int pendingFutures()
	{
		return this.pendingFutures;
	}
	
	public void run()
	{
		while(this.isRunning)
		{
			try
			{
				Future<T> f = this.compService.take();
				
				if(!f.isCancelled() && f.isDone() && this.finishCallback != null)
				{
					this.finishCallback.onFinished(f.get());
				}
					
				this.activeFutures.remove(f);
				this.pendingFutures--;
				
			} catch (InterruptedException | ExecutionException e) { }
		}
	}
	
	public void cancel()
	{
		for(Future<T> f : this.activeFutures)
		{
			f.cancel(true);
		}
	}
	
	public void setFinishCallback(ManagedFuturePoolFinishCallback<T> finishCallback)
	{
		this.finishCallback = finishCallback;
	}
	
	public void submit(Callable<T> task)
	{
		Future<T> f = this.compService.submit(task);
		this.activeFutures.add(f);
		this.pendingFutures++;
	}
	
	public void submit(Runnable task, T result)
	{
		Future<T> f = this.compService.submit(task, result);
		this.activeFutures.add(f);
		this.pendingFutures++;
	}
	
	public static interface ManagedFuturePoolFinishCallback<T>
	{
		void onFinished(T value);
	}
}
