package org.barghos.math.experimental.point;

import org.barghos.math.experimental.vector.vec3.Vec3;
import org.barghos.math.experimental.vector.vec3.Vec3R;

public class Point3 extends Vec3
{
	public Point3() { super(); }
	public Point3(Vec3R t) { super(t); }
	public Point3(float scalar) { super(scalar); }
	public Point3(float x, float y, float z) { super(x, y, z); }
	

	public Point3 setX(float x) { super.setX(x); return this; }
	public Point3 setY(float y) { super.setY(y); return this; }
	public Point3 setZ(float z) { super.setZ(z); return this; }
	
	public Point3 set(Vec3R t) { return set(t.getX(), t.getY(), t.getZ()); }
	public Point3 set(float scalar) { return set(scalar, scalar, scalar); }
	public Point3 set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }

	public String toString()
	{
		return "point3f(" + this.x + "f, " + this.y +"f, " + this.z + "f)";
	}

}
