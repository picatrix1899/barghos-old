package org.barghos.math.api.vector;

import org.barghos.core.tuple.tuple3.api.ITup3fR;

/**
 * This interface grants access to all reading methods of an 3-dimensional float vector.
 */
public interface IVec3fR extends ITup3fR
{
	default double getUniX() { return getX(); }
	default double getUniY() { return getY(); }
	default double getUniZ() { return getZ(); }
	
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			default: throw new IllegalStateException();
		}
	}
	default double getUni(int index)
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
