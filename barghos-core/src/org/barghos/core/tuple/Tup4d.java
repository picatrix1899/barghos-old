package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.api.tuple.ITup4dR;
import org.barghos.core.api.tuple.ITup4dW;
/**
 * This class is a simple implementation of a 4-dimensional double tuple.
 */
public class Tup4d extends Tupd implements ITup4dR, ITup4dW
{
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0.
	 */
	public Tup4d() { super(4); }
	
	/**
	 * This constructor sets the components to t.
	 * @param t A tuple that the components are set to.
	 */
	public Tup4d(ITup4R t) { super(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	
	/**
	 * This constructor sets the components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public Tup4d(double scalar) { super(scalar, scalar, scalar, scalar); }
	
	/**
	 * This constructor sets the components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param w The w component.
	 */
	public Tup4d(double x, double y, double z, double w) { super(x, y, z, w); }

	public Tup4d setX(double x) { this.v[0] = x; return this; }
	public Tup4d setY(double y) { this.v[1] = y; return this; }
	public Tup4d setZ(double z) { this.v[2] = z; return this; }
	public Tup4d setW(double w) { this.v[3] = w; return this; }
	
	public Tup4d set(ITup4R t) { return set(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	public Tup4d set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	public Tup4d set(double x, double y, double z, double w) { return setX(x).setY(y).setZ(z).setW(w); }

	public Tup4d set(int index, double value) { super.set(index, value); return this; }
	
	public double getX() { return this.v[0]; }
	public double getY() { return this.v[1]; }
	public double getZ() { return this.v[2]; }
	public double getW() { return this.v[3]; }

}
