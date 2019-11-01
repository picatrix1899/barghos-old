package org.barghos.core.thread;

public class DaemonThread extends Thread
{

    public DaemonThread()
    {
        super();
        setDaemon(true);
    }

    public DaemonThread(Runnable target)
    {
        super(target);
        setDaemon(true);
    }


    public DaemonThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setDaemon(true);
    }


    public DaemonThread(String name)
    {
        super(name);
        setDaemon(true);
    }


    public DaemonThread(ThreadGroup group, String name)
    {
        super(group, name);
        setDaemon(true);
    }


    public DaemonThread(Runnable target, String name)
    {
    	super(target, name);
    	setDaemon(true);
    }

    public DaemonThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setDaemon(true);
    }

    public DaemonThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setDaemon(true);
    }
}
