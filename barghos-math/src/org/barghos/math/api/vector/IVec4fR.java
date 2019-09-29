package org.barghos.math.api.vector;

import org.barghos.core.tuple.tuple4.api.ITup4fR;

/**
 * This interface grants access to all reading methods of an 4-dimensional float vector.
 */
public interface IVec4fR extends ITup4fR
{
	default double getUniX() { return getX(); }
	default double getUniY() { return getY(); }
	default double getUniZ() { return getZ(); }
	default double getUniW() { return getW(); }
	
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			case 3: return getW();
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
			case 3: return getW();
			default: throw new IllegalStateException();
		}
	}
}
