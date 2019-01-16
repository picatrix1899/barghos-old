package org.barghos.core.event;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncEvent<Args extends EventArgs>
{
	ExecutorService executors;
	
	public AsyncEvent()
	{
		this.executors = Executors.newCachedThreadPool();
	}
	
	private HashMap<Integer,EventHandler<Args>> handlers = new HashMap<Integer,EventHandler<Args>>();
	
	private int index = 0;
	
	public int addHandler(EventHandler<Args> handler)
	{
		int index = this.index;
		
		handlers.put(index, handler);
		
		this.index++;
		
		return index;
	}
	
	public void removeHandler(int index)
	{
		this.handlers.remove(index);
	}
	
	public void clearHandlers()
	{
		this.handlers.clear();
	}
	
	public void fire(Args args)
	{
		for(EventHandler<Args> handler : handlers.values())
		{
			executors.execute(() -> handler.raise(args)); 
		}
	}
}
