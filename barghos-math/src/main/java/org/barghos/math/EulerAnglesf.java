package org.barghos.math;


public class EulerAnglesf
{
	private float pitch = 0;
	private float yaw = 0;
	private float roll = 0;
	
	public EulerAnglesf()
	{
		this.pitch = 0;
		this.yaw = 0;
		this.roll = 0;
	}
	
	public EulerAnglesf(float pitch, float yaw, float roll)
	{
		this.pitch = pitch;
		this.yaw = yaw;
		this.roll = roll;
	}
	
	public EulerAnglesf set(float pitch, float yaw, float roll) { return setPitch(pitch).setYaw(yaw).setRoll(roll); }
	
	public EulerAnglesf setPitch(float pitch) { this.pitch = pitch; return this; }
	
	public EulerAnglesf setYaw(float yaw) { this.yaw = yaw; return this; }
	
	public EulerAnglesf setRoll(float roll) { this.roll = roll; return this; }

	public float getPitch() { return this.pitch; }
	
	public float getYaw() { return this.yaw; }

	public float getRoll() { return this.roll; }

}
