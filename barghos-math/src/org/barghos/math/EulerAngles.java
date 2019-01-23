package org.barghos.math;


public class EulerAngles
{
	private double pitch = 0;
	private double yaw = 0;
	private double roll = 0;
	
	public EulerAngles()
	{
		this.pitch = 0;
		this.yaw = 0;
		this.roll = 0;
	}
	
	public EulerAngles(double pitch, double yaw, double roll)
	{
		this.pitch = pitch;
		this.yaw = yaw;
		this.roll = roll;
	}
	
	public EulerAngles set(double pitch, double yaw, double roll) { return setPitch(pitch).setYaw(yaw).setRoll(roll); }
	
	public EulerAngles setPitch(double pitch) { this.pitch = pitch; return this; }
	
	public EulerAngles setYaw(double yaw) { this.yaw = yaw; return this; }
	
	public EulerAngles setRoll(double roll) { this.roll = roll; return this; }

	public double getPitch() { return this.pitch; }
	
	public double getYaw() { return this.yaw; }

	public double getRoll() { return this.roll; }

}
