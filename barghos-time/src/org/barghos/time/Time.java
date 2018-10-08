package org.barghos.time;

public class Time
{
	private byte hour = 0;
	private byte minute = 0;
	private byte second = 0;
	private short millisecond = 0;
	private short microsecond = 0;
	private short nanosecond = 0;
	
	public static final Time INVALID = new Time() { public boolean isValid(){ return false;}};
	
	public Time()
	{
		this(0, 0, 0, 0, 0, 0);
	}
	
	public Time(int hour, int minute, int second)
	{
		this(hour, minute, second, 0, 0, 0);
	}
	
	public Time(int hour, int minute, int second, int millisecond)
	{
		this(hour, minute, second, millisecond, 0, 0);
	}
	
	public Time(int hour, int minute, int second, int millisecond, int microsecond)
	{
		this(hour, minute, second, millisecond, microsecond, 0);
	}
	
	public Time(int hour, int minute, int second, int millisecond, int microsecond, int nanosecond)
	{
		set(hour, minute, second, millisecond, microsecond, nanosecond);
	}
	
	public Time set(int hour, int minute, int second)
	{
		return set(hour, minute, second, 0, 0, 0);
	}
	
	public Time set(int hour, int minute, int second, int millisecond)
	{
		return set(hour, minute, second, millisecond, 0, 0);
	}
	
	public Time set(int hour, int minute, int second, int millisecond, int microsecond)
	{
		return set(hour, minute, second, millisecond, nanosecond, 0);
	}
	
	public Time set(int hour, int minute, int second, int millisecond, int microsecond, int nanosecond)
	{
		this.hour = (byte)hour;
		this.minute = (byte)minute;
		this.second = (byte)second;
		this.millisecond = (short)millisecond;
		this.microsecond = (short)microsecond;
		this.nanosecond = (short)nanosecond;
		
		return this;
	}
	
	public Time setAndDistribute(int hours, int minutes, int seconds, int milliseconds, int microseconds, int nanoseconds)
	{
		this.nanosecond = (short)(nanoseconds % 1000);
		this.microsecond = (short)(((nanoseconds - this.nanosecond) / 1000 + microsecond) % 1000);
		this.millisecond = (short)(((microseconds - this.microsecond) / 1000 + millisecond) % 1000);
		this.second = (byte)(seconds % 60);
		this.minute = (byte)(((seconds - this.second) / 60 + minutes) % 60);
		this.hour = (byte)(((minutes - this.minute) / 60 + hours) % 24);
		
		return this;
	}
	
	public Time setAndDistributeNanoseconds(long nanosecond)
	{
		this.nanosecond = (short)(nanosecond % 1000);
		nanosecond -= this.nanosecond;
		this.microsecond = (short)(nanosecond % (1000000));
		nanosecond -= this.microsecond * 1000;
		this.millisecond = (short)(nanosecond % (1000000000));
		nanosecond -= this.millisecond * 1000000;
		this.second = (byte)(nanosecond % (1000000000000L));
		nanosecond -= this.second * 1000000000;
		this.minute = (byte)(nanosecond % (1000000000000000L));
		nanosecond -= this.minute * 1000000000000L;
		this.hour = (byte)nanosecond;
		
		return this;
	}
	
	public Time setHour(int hour) { this.hour = (byte)hour; return this; }
	public Time setMinute(int minute) { this.minute = (byte)minute; return this; }
	public Time setSecond(int second) { this.second = (byte)second; return this; }
	public Time setMillisecond(int millisecond) { this.millisecond = (short)millisecond; return this; }
	public Time setMicrosecond(int microsecond) { this.microsecond = (short)microsecond; return this; }
	public Time setNanosecond(int nanosecond) { this.nanosecond = (short)nanosecond; return this; }
	
	public int getHour() { return this.hour; }
	public int getMinute() { return this.minute; }
	public int getSecond() { return this.second; }
	public int getMillisecond() { return this.millisecond; }
	public int getMicrosecond() { return this.microsecond; }
	public int getNanosecond() { return this.nanosecond; }
	
	public boolean isValid()
	{
		if(this.hour < 0 || this.hour > 23) return false;
		if(this.minute < 0 || this.minute > 59) return false;
		if(this.second < 0 || this.second > 59) return false;
		if(this.millisecond < 0 || this.millisecond > 1000) return false;
		if(this.microsecond < 0 || this.microsecond > 1000) return false;
		if(this.nanosecond < 0 || this.nanosecond > 1000) return false;
		
		return true;
	}
}
