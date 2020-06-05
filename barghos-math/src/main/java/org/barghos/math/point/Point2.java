package org.barghos.math.point;

import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple.tuple2.Tup2fR;
import org.barghos.math.vector.vec2.Vec2;

public class Point2 extends Vec2
{
	public Point2() { super(); }
	public Point2(Tup2fR t) { super(t); }
	public Point2(float x, float y) { super(x, y); }
	
	public Point2 setX(float x) { super.setX(x); return this; }
	public Point2 setY(float y) { super.setY(y); return this; }
	
	public Point2 set(Tup2fR t) { if(t == null) throw new ArgumentNullException("t"); return set(t.getX(), t.getY()); }
	public Point2 set(float x, float y) { return setX(x).setY(y); }
	
	public String toString()
	{
		return "point2f(" + this.x + "f, " + this.y + "f)";
	}
}
