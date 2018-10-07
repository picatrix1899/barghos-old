package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup3dR;
import org.barghos.core.api.tuple.ITup3fR;

/**
 * This class is a readonly implementation of a 3-dimensional float tuple.
 */
public abstract class PTup3f implements ITup3fR
{
	/**
	 * This generate a readonly PTup3f with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup3f with the given components.
	 */
	public static PTup3f gen(ITup3fR t) { return gen(t.getX(), t.getY(), t.getZ()); }
	
	/**
	 * This generate a readonly PTup3f with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup3f with the given components.
	 */
	public static PTup3f gen(ITup3dR t) { return gen(t.getX(), t.getY(), t.getZ()); }
	
	/**
	 * This generate a readonly PTup3f with the components set to scalar.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PTup3f with the given components.
	 */
	public static PTup3f gen(double scalar) { return gen(scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PTup3f with the components set to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @return A new readonly PTup3f with the given components.
	 */
	public static PTup3f gen(double x, double y, double z)
	{
		return new PTup3f()
		{

			public float getX() { return (float)x; }
			public float getY() { return (float)y; }
			public float getZ() { return (float)z; }

			public int getDimensions() { return 3; }
			
		};
	}
	
}
