package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.core.api.tuple.ITup3fW;

/**
 * This class is a simple implementation of a 3-dimensional float tuple.
 */
public class Tup3f extends Tupf implements ITup3fR, ITup3fW
{
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0.
	 */
	public Tup3f() { super(3); }
	
	/**
	 * This constructor sets the components to t.
	 * @param t A tuple that the components are set to.
	 */
	public Tup3f(ITup3R t) { super(t.getUniX(), t.getUniY(), t.getUniZ()); }
	
	/**
	 * This constructor sets the components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public Tup3f(double scalar) { super(scalar, scalar, scalar); }
	
	/**
	 * This constructor sets the components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 */
	public Tup3f(double x, double y, double z) { super(x, y, z); }

	public Tup3f setX(double x) { this.v[0] = (float)x; return this; }
	public Tup3f setY(double y) { this.v[1] = (float)y; return this; }
	public Tup3f setZ(double z) { this.v[2] = (float)z; return this; }
	
	public Tup3f set(ITup3R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public Tup3f set(double scalar) { return set(scalar, scalar, scalar); }
	public Tup3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	public Tup3f set(int index, double value) { super.set(index, value); return this; }
	
	public float getX() { return this.v[0]; }
	public float getY() { return this.v[1]; }
	public float getZ() { return this.v[2]; }

}
