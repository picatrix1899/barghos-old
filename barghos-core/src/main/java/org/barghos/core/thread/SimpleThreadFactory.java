package org.barghos.core.thread;

import java.util.concurrent.ThreadFactory;

import org.barghos.core.exception.ArgumentNullException;

public class SimpleThreadFactory implements ThreadFactory
{

	public Thread newThread(Runnable r)
	{
		if(r == null) throw new ArgumentNullException("r");
		
		return new Thread(r);
	}
}
