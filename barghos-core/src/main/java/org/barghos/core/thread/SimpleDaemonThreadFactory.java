package org.barghos.core.thread;

import java.util.concurrent.ThreadFactory;

public class SimpleDaemonThreadFactory implements ThreadFactory
{

	public Thread newThread(Runnable r)
	{
		return new DaemonThread(r);
	}

}
