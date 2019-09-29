package org.barghos.math.api.vector;

import org.barghos.core.tuple.tuple2.api.ITup2fR;

/**
 * This interface grants access to all reading methods of an 2-dimensional float vector.
 */
public interface IVec2fR extends ITup2fR
{
	default double getUniX() { return getX(); }
	default double getUniY() { return getY(); }
	
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			default: throw new IllegalStateException();
		}
	}
	default double getUni(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			default: throw new IllegalStateException();
		}
	}
}
