package org.barghos.time;

public class TimeSpan
{
	public long hour = 0;
	public long minute = 0;
	public long second = 0;
	
	public static final TimeSpan INVALID = new TimeSpan() { public boolean isValid(){ return false;}};
	
	public TimeSpan()
	{
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}
	
	public TimeSpan(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public TimeSpan set(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
		return this;
	}
	
	public boolean isValid()
	{
		return true;
	}
}
