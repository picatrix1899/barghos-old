package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup2dR;
import org.barghos.core.api.tuple.ITup2fR;

/**
 * This class is a readonly implementation of a 2-dimensional double tuple.
 */
public abstract class PTup2d implements ITup2dR
{
	/**
	 * This generate a readonly PTup2d with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup2d with the given components.
	 */
	public static PTup2d gen(ITup2dR t) { return gen(t.getX(), t.getY()); }
	
	/**
	 * This generate a readonly PTup2d with the components set to t.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PTup2d with the given components.
	 */
	public static PTup2d gen(ITup2fR t) { return gen(t.getX(), t.getY()); }
	
	/**
	 * This generate a readonly PTup2d with the components set to scalar.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PTup2d with the given components.
	 */
	public static PTup2d gen(double scalar) { return gen(scalar, scalar); }
	
	/**
	 * This generate a readonly PTup2d with the components set to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @return A new readonly PTup2d with the given components.
	 */
	public static PTup2d gen(double x, double y)
	{
		return new PTup2d()
		{

			public double getX() { return x; }
			public double getY() { return y; }

			public int getDimensions() { return 2; }
			
		};
	}
	
}
