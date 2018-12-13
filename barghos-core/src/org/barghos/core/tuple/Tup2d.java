package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup2R;
import org.barghos.core.api.tuple.ITup2dR;
import org.barghos.core.api.tuple.ITup2dW;

/**
 * This class is a simple implementation of a 2-dimensional double tuple.
 */
public class Tup2d extends Tupd implements ITup2dR, ITup2dW
{
	
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0.
	 */
	public Tup2d() { super(2); }
	
	/**
	 * This constructor sets the components to t.
	 * @param t A tuple that the components are set to.
	 */
	public Tup2d(ITup2R t) { super(t.getUniX(), t.getUniY()); }
	
	/**
	 * This constructor sets the components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public Tup2d(double scalar) { super(scalar, scalar); }
	
	/**
	 * This constructor sets the components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 */
	public Tup2d(double x, double y) { super(x, y); }
	
	public Tup2d setX(double x) { this.v[0] = x; return this; }
	public Tup2d setY(double y) { this.v[1] = y; return this; }
	
	public Tup2d set(ITup2R t) { return set(t.getUniX(), t.getUniY()); }
	public Tup2d set(double scalar) { return set(scalar, scalar); }
	public Tup2d set(double x, double y) { return setX(x).setY(y); }

	public Tup2d set(int index, double value) { super.set(index, value); return this; }
	
	public double getX() { return this.v[0]; }
	public double getY() { return this.v[1]; }

}