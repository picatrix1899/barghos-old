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
