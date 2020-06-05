package org.barghos.math.point;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.math.vector.vec3.Vec3;

public class Point3 extends Vec3
{
	public Point3() { super(); }
	public Point3(Tup3fR t) { super(t); }
	public Point3(float x, float y, float z) { super(x, y, z); }
	

	public Point3 setX(float x) { super.setX(x); return this; }
	public Point3 setY(float y) { super.setY(y); return this; }
	public Point3 setZ(float z) { super.setZ(z); return this; }
	
	public Point3 set(Tup3fR t) { if(t == null) throw new ArgumentNullException("t"); return set(t.getX(), t.getY(), t.getZ()); }
	public Point3 set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }

	public String toString()
	{
		return "point3(" + this.x + "f, " + this.y +"f, " + this.z + "f)";
	}

}
