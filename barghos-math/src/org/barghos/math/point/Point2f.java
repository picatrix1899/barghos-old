package org.barghos.math.point;

import org.barghos.core.api.tuple.ITup2R;
import org.barghos.math.api.point.IPoint2W;
import org.barghos.math.api.point.IPoint2fR;

public class Point2f implements IPoint2fR, IPoint2W
{

	public float x = 0.0f;
	public float y = 0.0f;
	
	
	
	public Point2f() { set(0); }
	public Point2f(ITup2R t) { assert(t != null); set(t); }
	public Point2f(double scalar) { set(scalar); }
	public Point2f(double x, double y) { set(x, y); }
	

	
	public Point2f setX(double x) { this.x = (float)x; return this; }
	public Point2f setY(double y) { this.y = (float)y; return this; }
	
	public Point2f set(ITup2R t) { return set(t.getUniX(), t.getUniY()); }
	public Point2f set(double scalar) { return set(scalar, scalar); }
	public Point2f set(double x, double y) { return setX(x).setY(y); }

	public Point2f set(int index, double value) { IPoint2W.super.set(index, value); return this; }
	
	
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	
	
	
	public int getDimensions() { return 2; }
}
