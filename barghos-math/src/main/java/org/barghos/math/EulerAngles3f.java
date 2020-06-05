package org.barghos.math;


public class EulerAngles3f
{
	private float pitch;
	private float yaw;
	private float roll;
	
	public EulerAngles3f()
	{
		set(0.0f, 0.0f, 0.0f);
	}
	
	public EulerAngles3f(EulerAngles3f e)
	{
		set(e);
	}
	
	public EulerAngles3f(float pitch, float yaw, float roll)
	{
		set(pitch, yaw, roll);
	}
	
	public EulerAngles3f set(float pitch, float yaw, float roll) { return setPitch(pitch).setYaw(yaw).setRoll(roll); }
	
	public EulerAngles3f set(EulerAngles3f e) { return set(e.getPitch(), e.getYaw(), e.getRoll()); }
	
	public EulerAngles3f setPitch(float pitch) { this.pitch = pitch; return this; }
	
	public EulerAngles3f setYaw(float yaw) { this.yaw = yaw; return this; }
	
	public EulerAngles3f setRoll(float roll) { this.roll = roll; return this; }

	public float getPitch() { return this.pitch; }
	
	public float getYaw() { return this.yaw; }

	public float getRoll() { return this.roll; }

	public String toString()
	{
		return "eulerAngles3f(pitch=" + this.pitch + "f, yaw=" + this.yaw + "f, roll=" + this.roll + "f)";
	}
}
