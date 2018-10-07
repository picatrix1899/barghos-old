package org.barghos.math;

import org.barghos.core.api.tuple.ITup2fR;
import org.barghos.math.vector.Vec2f;

public class DirectionAndLength2f
{
	public Vec2f direction = new Vec2f();
	public double length = 0.0;
	
	public DirectionAndLength2f(ITup2fR direction, double length)
	{
		this.direction.set(direction);
		this.length = length;
	}
}
