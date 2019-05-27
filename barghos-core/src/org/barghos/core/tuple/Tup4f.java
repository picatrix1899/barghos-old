package org.barghos.core.tuple;

import org.barghos.core.api.tuple.ITup4R;
import org.barghos.core.api.tuple.ITup4fR;
import org.barghos.core.api.tuple.ITup4fW;

/**
 * This class is a simple implementation of a 4-dimensional float tuple.
 */
public class Tup4f extends Tupf implements ITup4fR, ITup4fW
{
	/**
	 * This is the default constructor.
	 * It is commonly used by a pool.
	 * It sets all components to 0.0.
	 */
	public Tup4f() { super(4); }
	
	/**
	 * This constructor sets the components to t.
	 * @param t A tuple that the components are set to.
	 */
	public Tup4f(ITup4R t) { super(4); assert(t != null); set(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	
	/**
	 * This constructor sets the components to scalar.
	 * @param scalar A value that the components are set to.
	 */
	public Tup4f(double scalar) { super(scalar, scalar, scalar, scalar); }
	
	/**
	 * This constructor sets the components to x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param w The w component.
	 */
	public Tup4f(double x, double y, double z, double w) { super(x, y, z, w); }

	public Tup4f setX(double x) { this.v[0] = (float)x; return this; }
	public Tup4f setY(double y) { this.v[1] = (float)y; return this; }
	public Tup4f setZ(double z) { this.v[2] = (float)z; return this; }
	public Tup4f setW(double w) { this.v[3] = (float)w; return this; }
	
	public Tup4f set(ITup4R t) { assert(t != null); return set(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	public Tup4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	public Tup4f set(double x, double y, double z, double w) { return setX(x).setY(y).setZ(z).setW(w); }

	public Tup4f set(int index, double value) { super.set(index, value); return this; }
	
	public float getX() { return this.v[0]; }
	public float getY() { return this.v[1]; }
	public float getZ() { return this.v[2]; }
	public float getW() { return this.v[3]; }
	
	public String toString()
	{
		return "tup4f(" + this.v[0] + "f, " + this.v[1] + "f, " + this.v[2] + "f, " + this.v[3] + "f)";
	}

}
