package org.barghos.math.point;

import org.barghos.math.api.point.IPoint3fR;
import org.barghos.core.tuple.tuple3.api.ITup3R;
import org.barghos.math.api.point.IPoint3W;

public class Point3f implements IPoint3fR, IPoint3W
{

	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	
	
	public Point3f() { set(0); }
	public Point3f(ITup3R t) { set(t); }
	public Point3f(double scalar) { set(scalar); }
	public Point3f(double x, double y, double z) { set(x, y, z); }
	
	
	
	public Point3f setX(double x) { this.x = (float)x; return this; }
	public Point3f setY(double y) { this.y = (float)y; return this; }
	public Point3f setZ(double z) { this.z = (float)z; return this; }
	
	public Point3f set(ITup3R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public Point3f set(double scalar) { return set(scalar, scalar, scalar); }
	public Point3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }


	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }

	public double getUniX() { return this.x; }
	public double getUniY() { return this.y; }
	public double getUniZ() { return this.z; }

	
	public int getDimensions() { return 3; }
	
	public String toString()
	{
		return "point3f(" + this.x + "f, " + this.y +"f, " + this.z + "f)";
	}

	public Point3f set(int index, double value)
	{
		switch(index)
		{
			case 0: return setX(value);
			case 1: return setY(value);
			case 2: return setZ(value);
			default: throw new IllegalStateException();
		}
	}
	
	public float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			default: throw new IllegalStateException();
		}
	}
	
	public double getUni(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			default: throw new IllegalStateException();
		}
	}
}
