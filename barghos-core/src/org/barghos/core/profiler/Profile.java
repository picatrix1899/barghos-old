package org.barghos.core.profiler;

public class Profile
{
	private static long SECOND = 1000000000l;
	private static long MILLISECOND = 1000000l;
	private static long MICROSECOND = 1000l;
	private static long NANOSECOND = 1l;
	
	private double averageTime;
	private long startTime;
	private long offset = 1 * MILLISECOND;
	
	public void start()
	{
		this.startTime = System.nanoTime();
	}
	
	public void stop()
	{
		long delta = System.nanoTime() - this.startTime;
		
		if(averageTime == 0)
			averageTime = delta;
		
		if(delta < averageTime - offset || averageTime + offset < delta)
		{
			averageTime = (averageTime + delta) * 0.5;
		}
	}
	
	public double getAverageTime()
	{
		return this.averageTime;
	}
}
