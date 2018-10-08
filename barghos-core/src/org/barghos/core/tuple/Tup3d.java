package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.core.api.tuple.ITup3dR;
import org.barghos.core.api.tuple.ITup3dW;

/**
 * This class is a simple implementation of a 3-dimensional double tuple.
 */
public class Tup3d extends Tupd implements ITup3dR, ITup3dW
{
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0.
	 */
	public Tup3d() { super(3); }
	
	/**
	 * This constructor sets the components to t.
	 * @param t A tuple that the components are set to.
	 */
	public Tup3d(ITup3R t) { super(t.getUniX(), t.getUniY(), t.getUniZ()); }
	
	/**
	 * This constructor sets the components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public Tup3d(double scalar) { super(scalar, scalar, scalar); }
	
	/**
	 * This constructor sets the components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 */
	public Tup3d(double x, double y, double z) { super(x, y, z); }

	public Tup3d setX(double x) { this.v[0] = x; return this; }
	public Tup3d setY(double y) { this.v[1] = y; return this; }
	public Tup3d setZ(double z) { this.v[2] = z; return this; }
	
	public Tup3d set(ITup3R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public Tup3d set(double scalar) { return set(scalar, scalar, scalar); }
	public Tup3d set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }

	public Tup3d set(int index, double value) { super.set(index, value); return this; }
	
	public double getX() { return this.v[0]; }
	public double getY() { return this.v[1]; }
	public double getZ() { return this.v[2]; }

}
