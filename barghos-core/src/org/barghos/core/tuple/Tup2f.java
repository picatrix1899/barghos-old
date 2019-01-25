package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup2R;
import org.barghos.core.api.tuple.ITup2fR;
import org.barghos.core.api.tuple.ITup2fW;

/**
 * This class is a simple implementation of a 2-dimensional float tuple.
 */
public class Tup2f extends Tupf implements ITup2fR, ITup2fW
{
	
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0.
	 */
	public Tup2f() { super(2); }
	
	/**
	 * This constructor sets the components to t.
	 * @param t A tuple that the components are set to.
	 */
	public Tup2f(ITup2R t) { super(2); assert(t != null); set(t.getUniX(), t.getUniY()); }
	
	/**
	 * This constructor sets the components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public Tup2f(double scalar) { super(scalar, scalar); }
	
	/**
	 * This constructor sets the components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 */
	public Tup2f(double x, double y) { super(x, y); }
	
	public Tup2f setX(double x) { this.v[0] = (float)x; return this; }
	public Tup2f setY(double y) { this.v[1] = (float)y; return this; }
	
	public Tup2f set(ITup2R t) { assert(t != null); return set(t.getUniX(), t.getUniY()); }
	public Tup2f set(double scalar) { return set(scalar, scalar); }
	public Tup2f set(double x, double y) { return setX(x).setY(y); }

	public Tup2f set(int index, double value) { super.set(index, value); return this; }
	
	public float getX() { return this.v[0]; }
	public float getY() { return this.v[1]; }

}
