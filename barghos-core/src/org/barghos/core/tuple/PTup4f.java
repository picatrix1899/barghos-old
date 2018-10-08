package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup4dR;
import org.barghos.core.api.tuple.ITup4fR;

/**
 * This class is a readonly implementation of a 4-dimensional float tuple.
 */
public abstract class PTup4f implements ITup4fR
{
	/**
	 * This generate a readonly PTup4f with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup4f with the given components.
	 */
	public static PTup4f gen(ITup4fR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	/**
	 * This generate a readonly PTup4f with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup4f with the given components.
	 */
	public static PTup4f gen(ITup4dR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	/**
	 * This generate a readonly PTup4f with the components set to scalar.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PTup4f with the given components.
	 */
	public static PTup4f gen(double scalar) { return gen(scalar, scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PTup2f with the components set to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param w The w component.
	 * @return A new readonly PTup2f with the given components.
	 */
	public static PTup4f gen(double x, double y, double z, double w)
	{
		return new PTup4f()
		{

			public float getX() { return (float)x; }
			public float getY() { return (float)y; }
			public float getZ() { return (float)z; }
			public float getW() { return (float)w; }
			
			
			public int getDimensions() { return 4; }
			
		};
	}
	
}
