package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup4dR;
import org.barghos.core.api.tuple.ITup4fR;

/**
 * This class is a readonly implementation of a 4-dimensional double tuple.
 */
public abstract class PTup4d implements ITup4dR
{
	/**
	 * This generate a readonly PTup4d with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup4d with the given components.
	 */
	public static PTup4d gen(ITup4dR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	/**
	 * This generate a readonly PTup4d with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup4d with the given components.
	 */
	public static PTup4d gen(ITup4fR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	/**
	 * This generate a readonly PTup4d with the components set to scalar.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PTup4d with the given components.
	 */
	public static PTup4d gen(double scalar) { return gen(scalar, scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PTup4d with the components set to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param w The w component.
	 * @return A new readonly PTup4d with the given components.
	 */
	public static PTup4d gen(double x, double y, double z, double w)
	{
		return new PTup4d()
		{

			public double getX() { return x; }
			public double getY() { return y; }
			public double getZ() { return z; }
			public double getW() { return w; }
			
			
			public int getDimensions() { return 4; }
			
		};
	}
	
}
