package org.barghos.math.experimental.point;

import org.barghos.math.experimental.vector.vec2.Vec2;
import org.barghos.math.experimental.vector.vec2.Vec2R;

public class Point2 extends Vec2
{
	public Point2() { super(); }
	public Point2(Vec2R t) { super(t); }
	public Point2(float scalar) { super(scalar); }
	public Point2(float x, float y) { super(x, y); }
	
	public Point2 setX(float x) { super.setX(x); return this; }
	public Point2 setY(float y) { super.setY(y); return this; }
	
	public Point2 set(Vec2R t) { return set(t.getX(), t.getY()); }
	public Point2 set(float scalar) { return set(scalar, scalar); }
	public Point2 set(float x, float y) { return setX(x).setY(y); }
}
