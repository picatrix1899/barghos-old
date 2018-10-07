package org.barghos.math.vector;

import org.barghos.core.api.tuple.ITup2R;
import org.barghos.core.api.tuple.ITup2fR;
import org.barghos.math.api.vector.IVec2fR;
import org.barghos.math.pool.Vec2fPool;
import org.barghos.math.DirectionAndLength2f;
import org.barghos.math.Maths;
import org.barghos.math.api.vector.IVec2W;

/**
 * 
 */
public class Vec2f implements IVec2fR, IVec2W
{
	/** The Zero Vector as constant. */
	public static final PVec2f ZERO = PVec2f.gen(0.0);
	
	/** The positive x-axis normal as constant. */
	public static final PVec2f AXIS_X = PVec2f.gen(1.0, 0.0);
	
	/** The positive y-axis normal as constant. */
	public static final PVec2f AXIS_Y = PVec2f.gen(0.0, 1.0);
	
	/** The negative x-axis normal as constant. */
	public static final PVec2f AXIS_NX = PVec2f.gen(-1.0, 0.0);
	
	/** The negative y-axis normal as constant.  */
	public static final PVec2f AXIS_NY = PVec2f.gen(0.0, -1.0);
	
	/** The diagonal axis normal of positive x and positive y as constant. */
	public static final PVec2f AXIS_XY = PVec2f.gen(Maths.INV_SQRT2, Maths.INV_SQRT2);
	/** The diagonal axis normal of negative x and positive y as constant. */
	public static final PVec2f AXIS_NXY = PVec2f.gen(-Maths.INV_SQRT2, Maths.INV_SQRT2);
	/** The diagonal axis normal of positive x and negative y as constant. */
	public static final PVec2f AXIS_XNY = PVec2f.gen(Maths.INV_SQRT2, -Maths.INV_SQRT2);
	
	/** The diagonal axis normal of negative x and negative y as constant. */
	public static final PVec2f AXIS_NXNY = PVec2f.gen(-Maths.INV_SQRT2, -Maths.INV_SQRT2);
	
	/** The x component. */
	public float x = 0.0f;
	
	/** The y component. */
	public float y = 0.0f;

	/**
	 * The default constructor. It sets all components to 0.
	 * It is commonly used in pools.
	 */
	public Vec2f() { set(0); }
	
	/**
	 * This contructor sets the components to the values of t.
	 * @param t A tuple that the components are set to.
	 */
	public Vec2f(ITup2R t) { set(t); }
	
	/**
	 * This constructor sets both components to scalar.
	 * @param scalar A value that is set to both components.
	 */
	public Vec2f(double scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to x and y.
	 * @param x The new x component.
	 * @param y The new y component.
	 */
	public Vec2f(double x, double y) { set(x, y); }

	public Vec2f setX(double x) { this.x = (float)x; return this; }
	public Vec2f setY(double y) { this.y = (float)y; return this; }
	
	public Vec2f set(ITup2R t) { return set(t.getUniX(), t.getUniY()); }
	public Vec2f set(double scalar) { return set(scalar, scalar); }
	public Vec2f set(double x, double y) { return setX(x).setY(y); }
	
	public Vec2f set(int index, double value) { IVec2W.super.set(index, value); return this; }

	public float getX() { return this.x; }
	public float getY() { return this.y; }

	public int getDimensions() { return 2; }
	
	/*
	 * ############################
	 * ############################
	 * ##                        ##
	 * ##  STATIC - ARITHMETICS  ##
	 * ##                        ##
	 * ############################
	 * ############################
	 */

	/**
	 * Adds one tuple to another and saves the result in res.
	 * <br>(v1.x + v2.x, v1.y + v2.y)
	 * @param v1 The first tuple to add.
	 * @param v2 The second tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f add(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return add(v1.getUniX(), v1.getUniY(), v2, res);
	}
	
	/**
	 * Adds a tuple to a scalar and saves the result in res.
	 * <br>(v1.x + scalar, v1.y + scalar)
	 * @param v1 The tuple to add.
	 * @param scalar The scalar to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f add(ITup2R v1, double scalar, Vec2f res)
	{
		return add(v1, scalar, scalar, res);
	}
	
	/**
	 * Adds a tuple to x and y and saves the result in res.
	 * <br>(v1.x + x, v1.y + y)
	 * @param v1 The tuple to add.
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f add(ITup2R v1, double x, double y, Vec2f res)
	{
		return add(v1.getUniX(), v1.getUniY(), x, y, res);
	}
	
	/**
	 * Adds a scalar to a tuple and saves the result in res.
	 * <br>(scalar + v2.x, scalar + v2.y)
	 * @param scalar The scalar to add.
	 * @param v2 The tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f add(double scalar, ITup2R v2, Vec2f res)
	{
		return add(scalar, scalar, v2, res);
	}
	
	/**
	 * Adds x and y to a tuple and saves the result in res.
	 * <br>(x + v2.x, y + v2.y)
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param v2 The tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f add(double x, double y, ITup2R v2, Vec2f res)
	{
		return add(x, y, v2.getUniX(), v2.getUniY(), res);
	}
	
	/**
	 * Adds x1 and y1 to x2 and y2 and saves the result in res.
	 * <br>(x1 + x2, y1 + y2)
	 * @param x1 The first x value to add.
	 * @param y1 The first y value to add.
	 * @param x2 The second x value to add.
	 * @param y2 The second y value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f add(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(x1 + x2, y1 + y2);
	}

	/**
	 * Subtracts one tuple from another and saves the result in res.
	 * <br>(v1.x - v2.x, v1.y - v2.y)
	 * @param v1 The first tuple to subtract from.
	 * @param v2 The second tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sub(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return sub(v1.getUniX(), v1.getUniY(), v2, res);
	}
	
	/**
	 * Subtract from a tuple a scalar and saves the result in res.
	 * <br>(v1.x - scalar, v1.y - scalar)
	 * @param v1 The tuple to subtract from.
	 * @param scalar The scalar to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sub(ITup2R v1, double scalar, Vec2f res)
	{
		return sub(v1, scalar, scalar, res);
	}
	
	/**
	 * Subtracts from a tuple the values x and y and saves the result in res.
	 * <br>(v1.x - x, v1.y - y)
	 * @param v1 The tuple to subtract from.
	 * @param x The x value to subtract.
	 * @param y The y value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sub(ITup2R v1, double x, double y, Vec2f res)
	{
		return sub(v1.getUniX(), v1.getUniY(), x, y, res);
	}
	
	/**
	 * Subtracts from a scalar the values of tuple and saves the result in res.
	 * <br>(scalar - v2.x, scalar - v2.y)
	 * @param scalar The scalar to subtract from.
	 * @param v2 The tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sub(double scalar, ITup2R v2, Vec2f res)
	{
		return sub(scalar, scalar, v2, res);
	}
	
	/**
	 * Subtracts from x and y the values of a tuple and saves the result in res.
	 * <br>(x - v2.x, y - v2.y)
	 * @param x The x value to subtract from.
	 * @param y The y value to subtract from.
	 * @param v2 The tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sub(double x, double y, ITup2R v2, Vec2f res)
	{
		return sub(x, y, v2.getUniX(), v2.getUniY(), res);
	}
	
	/**
	 * Subtracts from x1 and y1 the values x2 and y2 and saves the result in res.
	 * <br>(x1 - x2, y1 - y2)
	 * @param x1 The first x value to subtract from.
	 * @param y1 The first y value to subtract from.
	 * @param x2 The second x value to subtract.
	 * @param y2 The second y value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sub(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(x1 - x2, y1 - y2);
	}

	/**
	 * Multiplies one tuple with another and saves the result in res.
	 * <br>(v1.x * v2.x, v1.y * v2.y)
	 * @param v1 The first tuple to multiply.
	 * @param v2 The second tuple to mluitply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f mul(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return mul(v1.getUniX(), v1.getUniY(), v2, res);
	}

	/**
	 * Multiplies a tuple with a scalar and saves the result in res.
	 * <br>(v1.x * scalar, v1.y * scalar)
	 * @param v1 The tuple to multiply.
	 * @param scalar The scalar to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f mul(ITup2R v1, double scalar, Vec2f res)
	{
		return mul(v1, scalar, scalar, res);
	}

	/**
	 * Multiplies a tuple with x and y and saves the result in res.
	 * <br>(v1.x * x, v1.y * y)
	 * @param v1 The tuple to multiply.
	 * @param x The x value to multiply with.
	 * @param y The y value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f mul(ITup2R v1, double x, double y, Vec2f res)
	{
		return mul(v1.getUniX(), v1.getUniY(), x, y, res);
	}
	
	/**
	 * Multiplies a scalar with a tuple and saves the result in res.
	 * <br>(scalar * v2.x, scalar * v2.y)
	 * @param scalar The scalar to mutliply.
	 * @param v2 The tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f mul(double scalar, ITup2R v2, Vec2f res)
	{
		return mul(scalar, scalar, v2, res);
	}

	/**
	 * Multiplies x and y with a tuple and saves the result in res.
	 * <br>(x * v2.x, y * v2.y)
	 * @param x The x value to multiply.
	 * @param y The y value to mlutiply.
	 * @param v2 The tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f mul(double x, double y, ITup2R v2, Vec2f res)
	{
		return mul(x, y, v2.getUniX(), v2.getUniY(), res);
	}
	
	/**
	 * Multiplies x1 and y1 with x2 and y2 and saves the result in res.
	 * <br>(x1 * x2, y1 * y2)
	 * @param x1 The first x value to multiply.
	 * @param y1 The first y value to multiply.
	 * @param x2 The second x value to multiply with.
	 * @param y2 The second y value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f mul(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(x1 * x2, y1 * y2);
	}
	
	/**
	 * Divides one tuple by another and saves the result in res.
	 * <br>(v1.x / v2.x, v1.y / v2.y)
	 * @param v1 The first tuple to divide.
	 * @param v2 The second tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f div(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return div(v1.getUniX(), v1.getUniY(), v2, res);
	}
	
	/**
	 * Divides a tuple by a scalar and saves the result in res.
	 * <br>(v1.x / scalar, v1.y / scalar)
	 * @param v1 The tuple to divide.
	 * @param scalar The scalar to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f div(ITup2R v1, double scalar, Vec2f res)
	{
		return div(v1, scalar, scalar, res);
	}
	
	/**
	 * Divides a tuple by x and y and saves the result in res.
	 * <br>(v1.x / x, v1.y / y)
	 * @param v1 The tuple to divide.
	 * @param x The x value to divide by.
	 * @param y The y value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f div(ITup2R v1, double x, double y, Vec2f res)
	{
		return div(v1.getUniX(), v1.getUniY(), x, y, res);
	}
	
	/**
	 * Divides a scalar bx a tuple and saves the result in res.
	 * <br>(scalar / v2.x, scalar / v2.y)
	 * @param scalar The scalar to divide.
	 * @param v2 The tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f div(double scalar, ITup2R v2, Vec2f res)
	{
		return div(scalar, scalar, v2, res);
	}

	/**
	 * Divides x and y by a tuple and saves the result in res.
	 * <br>(x / v2.x, y / v2.y)
	 * @param x The x value to divide.
	 * @param y The y value to divide.
	 * @param v2 The tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f div(double x, double y, ITup2R v2, Vec2f res)
	{
		return div(x, y, v2.getUniX(), v2.getUniY(), res);
	}
	
	/**
	 * Divides x1 and y1 by x2 and y2 and saves the result in res.
	 * <br>(x1 / x2, y1 / y2)
	 * @param x1 The first x value to divide.
	 * @param y1 The first y value to divide.
	 * @param x2 The second x value to divide by.
	 * @param y2 The second y value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f div(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(x1 / x2, y1 / y2);
	}

	/*
	 * ########################################
	 * ########################################
	 * ##                                    ##
	 * ##  STATIC - BASIC VECTOR OPERATIONS  ##
	 * ##                                    ##
	 * ########################################
	 * ########################################
	 */
	
	/**
	 * Returns the dot product between two tuples.
	 * @param v1 The first float tuple.
	 * @param v2 The second float tuple.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(ITup2R v1, ITup2R v2)
	{
		return dot(v1.getUniX(), v1.getUniY(), v2);
	}

	/**
	 * Returns the dot product between a tuple and x2 and y2.
	 * @param v1 The first tuple.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(ITup2R v1, double x2, double y2)
	{
		return dot(v1.getUniX(), v1.getUniY(), x2, y2);
	}

	/**
	 * Returns the dot product between x1 and y1 and a second tuple.
	 * @param x1 The x component of the first vector.
	 * @param y1 The y component of the first vector.
	 * @param v2 The second tuple.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(double x1, double y1, ITup2R v2)
	{
		return dot(x1, y1, v2.getUniX(), v2.getUniY());
	}
	
	/**
	 * Returns the dot product between x1 and y1 and x2 and y2.
	 * @param x1 The x component of the first vector.
	 * @param y1 The y component of the first vector.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(double x1, double y1, double x2, double y2)
	{
		return x1 * x2 + y1 * y2;
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple.
	 * @param v The tuple that the length is from.
	 * @return The reciprocal of the length.
	 */
	public static double reciprocalLength(ITup2R v)
	{
		return reciprocalLength(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x and y.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @return The reciprocal of the length.
	 */
	public static double reciprocalLength(double x, double y)
	{
		return 1.0 / length(x, y);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(ITup2R v)
	{
		return reciprocalLengthSafe(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x and y. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(double x, double y)
	{
		return reciprocalLengthSafe(x, y, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple. This method is zero-safe.
	 * It uses givewn tolerance as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(ITup2R v, double tolerance)
	{
		return reciprocalLengthSafe(v.getUniX(), v.getUniY(), tolerance);
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x and y. This method is zero-safe.
	 * It uses given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(double x, double y, double tolerance)
	{
		return isZero(x, y, tolerance) ? 0.0 : 1.0 / length(x, y); 
	}
	
	/**
	 * Returns the length of the tuple.
	 * @param v The tuple that the length is from.
	 * @return The length.
	 */
	public static double length(ITup2R v)
	{
		return length(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the length of x and y.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @return The length.
	 */
	public static double length(double x, double y)
	{
		return Math.sqrt(squaredLength(x, y));
	} 
	
	/**
	 * Returns the length of the tuple. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @return The length.
	 */
	public static double lengthSafe(ITup2R v)
	{
		return lengthSafe(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the length of x and y. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @return The length.
	 */
	public static double lengthSafe(double x, double y)
	{
		return lengthSafe(x, y, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns the length of the tuple. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public static double lengthSafe(ITup2R v, double tolerance)
	{
		return lengthSafe(v.getUniX(), v.getUniY(), tolerance);
	}

	/**
	 * Returns the length of x and y. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public static double lengthSafe(double x, double y, double tolerance)
	{
		return isZero(x, y, tolerance) ? 0.0 : Math.sqrt(squaredLength(x, y));
	}
	
	/**
	 * Returns the squared length of the tuple.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @param v The tuple that the length is from.
	 * @return The squared length.
	 */
	public static double squaredLength(ITup2R v)
	{
		return squaredLength(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the squared length of x and y.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @return The squared length.
	 */
	public static double squaredLength(double x, double y)
	{
		return x * x + y * y;
	}
	
	
	/**
	 * Returns the given tuple normalized.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f normal(ITup2R v, Vec2f res)
	{
		return normal(v.getUniX(), v.getUniY(), res);
	}

	/**
	 * Returns the given x and y normalized.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f normal(double x, double y, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		double recLength = reciprocalLength(x, y);
		return res.set(x * recLength, y * recLength);
	}
	
	/**
	 * Returns the given tuple normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f normalSafe(ITup2R v, Vec2f res)
	{
		return normalSafe(v.getUniX(), v.getUniY(), res);
	}

	/**
	 * Returns the given x and y normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f normalSafe(double x, double y, Vec2f res)
	{
		return normalSafe(x, y, Maths.SMALL_NUMBER, res);
	}
	
	/**
	 * Returns the given tuple normalized. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param v The tuple to normalize.
	 * @param tolerance The threshold around 0.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f normalSafe(ITup2R v, double tolerance, Vec2f res)
	{
		return normalSafe(v.getUniX(), v.getUniY(), tolerance, res);
	}

	/**
	 * Returns the given x and y normalized. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param tolerance The threshold around 0.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f normalSafe(double x, double y, double tolerance, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		if(isZero(x, y, tolerance)) return res.set(Vec2f.ZERO);
		double recLength = reciprocalLength(x, y);
		return res.set(x * recLength, y * recLength);
	}
	
	/**
	 * Returns the inverted vector of the tuple v.
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f invert(ITup2R v, Vec2f res)
	{
		return invert(v.getUniX(), v.getUniY(), res);
	}

	/**
	 * Returns the inverted vector of x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f invert(double x, double y, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(-x, -y);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of the components of the tuple v(1 / v.x, 1 / v.y).
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f reciprocal(ITup2R v, Vec2f res)
	{
		return reciprocal(v.getUniX(), v.getUniY(), res);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of x and y(1 / x, 1 / y).
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f reciprocal(double x, double y, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(1.0 / x, 1.0 / y);
	}
	
	/**
	 * Returns a vector from tuple v rotated about angleDeg.
	 * @param v The input tuple.
	 * @param angleDeg The angle to rotate in degrees.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f rotate(ITup2R v, double angleDeg, Vec2f res)
	{
		return rotate(v.getUniX(), v.getUniY(), angleDeg, res);
	}
	
	/**
	 * Returns a vector from x and y rotated about angleDeg.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param angleDeg The angle to rotate in degrees.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f rotate(double x, double y, double angleDeg, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		double rad = angleDeg * Maths.DEG_TO_RAD;
		double sin = Math.sin(rad);
		double cos = Math.cos(rad);
		
		return res.set(cos * x - sin * y, sin * x + cos * y);
	}
	
	/*
	 * ##############################
	 * ##############################
	 * ##                          ##
	 * ##  STATIC - SANITY CHECKS  ##
	 * ##                          ##
	 * ##############################
	 * ##############################
	 */

	/**
	 * Returns if the components of the tuple v are finite.
	 * @param v The tuple to check.
	 * @return True if the the conponents are finite else (NaN/+Inf/-Inf) false.
	 */
	public static boolean isFinite(ITup2R v)
	{
		return isFinite(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns if x and y are finite.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @return True if x and y are finite else (NaN/+Inf/-Inf) false.
	 */
	public static boolean isFinite(double x, double y)
	{
		return Double.isFinite(x) && Double.isFinite(y);
	}

	/**
	 * Returns if the components of v are zero.
	 * Therefore it uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple to check.
	 * @return Are the components within threshold.
	 */
	public static boolean isZero(ITup2R v)
	{
		return isZero(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns if x and y are zero.
	 * Therefore it uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @return Are x and y within threshold.
	 */
	public static boolean isZero(double x, double y)
	{
		return isZero(x, y, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns if the components of v are zero.
	 * Therefore it uses given tolerance as a threshold around zero.
	 * @param v The tuple to check.
	 * @param tolerance The threshold around 0.
	 * @return Are the components within threshold.
	 */
	public static boolean isZero(ITup2R v, double tolerance)
	{
		return isZero(v.getUniX(), v.getUniY(), tolerance);
	}

	/**
	 * Returns if x and y are zero.
	 * Therefore it uses given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return Are x and y within threshold.
	 */	
	public static boolean isZero(double x, double y, double tolerance)
	{
		return Math.abs(x) <= tolerance && Math.abs(y) <= tolerance;
	}
	
	/*
	 * ####################################
	 * ####################################
	 * ##                                ##
	 * ##  STATIC - LIMITING & CLAMPING  ##
	 * ##                                ##
	 * ####################################
	 * ####################################
	 */
	
	/**
	 * Returns a vector with absolute x and y component from the given tuple.
	 * @param v The tuple that components are used.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f abs(ITup2R v, Vec2f res)
	{
		return abs(v.getUniX(), v.getUniY(), res);
	}

	/**
	 * Returns a vector with absolute x and y component from the given x and y component.
	 * @param x The x component.
	 * @param y The y component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f abs(double x, double y, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(Math.abs(x), Math.abs(y));
	}
	
	/**
	 * Returns a vector with the minimal x and y value of two tuples.
	 * @param v1 The first tuple.
	 * @param v2 The secound tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f min(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return min(v1, v2.getUniX(), v2.getUniY(), res);
	}

	/**
	 * Returns a vector with the minimal x and y value of a tuple and a scalar.
	 * @param v1 The first tuple.
	 * @param scalar A single value used for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f min(ITup2R v1, double scalar, Vec2f res)
	{
		return min(v1.getUniX(), v1.getUniY(), scalar, scalar, res);
	}
	
	/**
	 * Returns a vector with the minimal x and y value of a tuple and x and y.
	 * @param v1 The first tuple.
	 * @param x The second x component.
	 * @param y The second y component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f min(ITup2R v1, double x, double y, Vec2f res)
	{
		return min(v1.getUniX(), v1.getUniY(), x, y, res);
	}
	
	/**
	 * Returns a vector with the minimal x and y value of a scalar and a tuple.
	 * @param scalar A single value used for x and y.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f min(double scalar, ITup2R v2, Vec2f res)
	{
		return min(scalar, scalar, v2.getUniX(), v2.getUniY(), res);
	}
	
	/**
	 * Returns a vector with the minimal x and y value of x and y and a tuple.
	 * @param x The first x component.
	 * @param y The first y component.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f min(double x, double y, ITup2R v2, Vec2f res)
	{
		return min(x, y, v2.getUniX(), v2.getUniY(), res);
	}
	
	/**
	 * Returns a vector with its components set to the minimal x and y value of x1 and y1 and x2 and y2.
	 * @param x1 The first x component.
	 * @param y1 The first y component.
	 * @param x2 The second x component.
	 * @param y2 The second y component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f min(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(Math.min(x1, x2), Math.min(y1, y2));
	}
	
	/**
	 * Returns a vector with the maximal x and y value of two tuples.
	 * @param v1 The first tuple.
	 * @param v2 The secound tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f max(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return max(v1, v2.getUniX(), v2.getUniY(), res);
	}

	/**
	 * Returns a vector with the maximal x and y value of a tuple and a scalar.
	 * @param v1 The first tuple.
	 * @param scalar A single value used for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f max(ITup2R v1, double scalar, Vec2f res)
	{
		return max(v1.getUniX(), v1.getUniY(), scalar, scalar, res);
	}

	/**
	 * Returns a vector with the maximal x and y value of a tuple and x and y.
	 * @param v1 The first tuple.
	 * @param x The second x component.
	 * @param y The second y component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f max(ITup2R v1, double x, double y, Vec2f res)
	{
		return max(v1.getUniX(), v1.getUniY(), x, y, res);
	}

	/**
	 * Returns a vector with the maximal x and y value of a scalar and a tuple.
	 * @param scalar A single value used for x and y.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f max(double scalar, ITup2R v2, Vec2f res)
	{
		return max(scalar, scalar, v2.getUniX(), v2.getUniY(), res);
	}

	/**
	 * Returns a vector with the maximal x and y value of x and y and a tuple.
	 * @param x The first x component.
	 * @param y The first y component.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f max(double x, double y, ITup2R v2, Vec2f res)
	{
		return max(x, y, v2.getUniX(), v2.getUniY(), res);
	}

	/**
	 * Returns a vector with its components set to the maximal x and y value of x1 and y1 and x2 and y2.
	 * @param x1 The first x component.
	 * @param y1 The first y component.
	 * @param x2 The second x component.
	 * @param y2 The second y component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f max(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(Math.max(x1, x2), Math.max(y1, y2));
	}
	
	/**
	 * Returns the minimal component of a tuple.
	 * @param v The tuple that components are used.
	 * @return the minimal component.
	 */
	public static float getMinComponent(ITup2R v)
	{
		return getMinComponent(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the minimal component of x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @return the minimal component.
	 */
	public static float getMinComponent(double x, double y)
	{
		return (float)Math.min(x, y);
	}
	
	/**
	 * Returns the maximal component of a tuple.
	 * @param v The tuple that components are used.
	 * @return the maximal component.
	 */
	public static float getMaxComponent(ITup2R v)
	{
		return getMaxComponent(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the maximal component of x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @return the maximal component.
	 */
	public static float getMaxComponent(double x, double y)
	{
		return (float)Math.max(x, y);
	}

	/**
	 * Returns the minimal absolute component from a tuple.
	 * @param v The tuple.
	 * @return The minimal component.
	 */
	public static float getAbsMinComponent(ITup2R v)
	{
		return getAbsMinComponent(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the minimal absolute component from x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @return The minimal component.
	 */
	public static float getAbsMinComponent(double x, double y)
	{
		return (float)Math.min(Math.abs(x), Math.abs(y));
	}
	
	/**
	 * Returns the maximal absolute component from a tuple.
	 * @param v The tuple.
	 * @return The maximal component.
	 */
	public static float getAbsMaxComponent(ITup2R v)
	{
		return getAbsMaxComponent(v.getUniX(), v.getUniY());
	}

	/**
	 * Returns the maximal absolute component from x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @return The maximal component.
	 */
	public static float getAbsMaxComponent(double x, double y)
	{
		return (float)Math.max(Math.abs(x), Math.abs(y));
	}
	
	/**
	 * Returns a vector with the signs of the components of the tuple.
	 * @param v The tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sign(ITup2R v, Vec2f res)
	{
		return sign(v.getUniX(), v.getUniY(), res);
	}
	
	/**
	 * Returns a vector with the signs of the components x and y.
	 * @param x The x component.
	 * @param y The y component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f sign(double x, double y, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(Maths.selectByZero(x, 1.0, -1.0), Maths.selectByZero(y, 1.0, -1.0));
	}
	
	/**
	 * Returns a vector with the components from tuple v snapped to the gridspacing of grid.
	 * @param v The tuple.
	 * @param grid The gridspacing for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f gridSnap(ITup2R v, ITup2R grid, Vec2f res)
	{
		return gridSnap(v.getUniX(), v.getUniY(), grid, res);
	}
	
	/**
	 * Returns a vector with the components from tuple v snapped to the gridspacing of gridsize.
	 * @param v The tuple
	 * @param gridSize The gridspacing for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f gridSnap(ITup2R v, double gridSize, Vec2f res)
	{
		return gridSnap(v.getUniX(), v.getUniY(), gridSize, gridSize, res);
	}
	
	/**
	 * Returns a vector with the components from tuple v snapped to the gridspacing of gridsize.
	 * @param v The tuple
	 * @param gx The gridspacing for x.
	 * @param gy The gridspacing for y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f gridSnap(ITup2R v, double gx, double gy, Vec2f res)
	{
		return gridSnap(v.getUniX(), v.getUniY(), gx, gy, res);
	}
	
	/**
	 * Returns a vector with the components x and y snapped to the gridspacing of gridsize.
	 * @param x The x component.
	 * @param y The y component.
	 * @param grid The gridspacing for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f gridSnap(double x, double y, ITup2R grid, Vec2f res)
	{
		return gridSnap(x, y, grid.getUniX(), grid.getUniY(), res);
	}
	
	/**
	 * Returns a vector with the components x and y snapped to the gridspacing of gridsize.
	 * @param x The x component.
	 * @param y The y component.
	 * @param gridSize The gridspacing for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f gridSnap(double x, double y, double gridSize, Vec2f res)
	{
		return gridSnap(x, y, gridSize, gridSize, res);
	}
	
	/**
	 * Returns a vector with the components x and y snapped to the gridspacing of gridsize.
	 * @param x The x component.
	 * @param y The y component.
	 * @param gx The gridspacing for x.
	 * @param gy The gridspacing for y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec2f gridSnap(double x, double y, double gx, double gy, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(Maths.gridSnap(x, gx), Maths.gridSnap(y, gy));
	}
	
	/*
	 * ##########################################
	 * ##########################################
	 * ##                                      ##
	 * ##  STATIC - POINT TO POINT OPERATIONS  ##
	 * ##                                      ##
	 * ##########################################
	 * ##########################################
	 */
	
	public static DirectionAndLength2f toDirectionAndLength(ITup2R v)
	{
		return toDirectionAndLength(v.getUniX(), v.getUniY());
	}

	public static DirectionAndLength2f toDirectionAndLength(double x, double y)
	{
		return toDirectionAndLength(x, y, Maths.SMALL_NUMBER);
	}
	
	public static DirectionAndLength2f toDirectionAndLength(ITup2R v, double tolerance)
	{
		return toDirectionAndLength(v.getUniX(), v.getUniY(), tolerance);
	}
	
	public static DirectionAndLength2f toDirectionAndLength(double x, double y, double tolerance)
	{
		DirectionAndLength2f out = null;
		
		if (isZero(x, y, tolerance))
		{
			out = new DirectionAndLength2f(Vec2f.ZERO, 0.0);
		}
		else
		{
			Vec2f temp = Vec2fPool.get();
			out = new DirectionAndLength2f(normal(x, y, temp), length(x, y));
			Vec2fPool.store(temp);
		}

		return out;
	}

	public static Vec2f vectorTo(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return vectorTo(v1, v2.getUniX(), v2.getUniY(), res);
	}

	public static Vec2f vectorTo(ITup2R v1, double x, double y, Vec2f res)
	{
		return vectorTo(v1.getUniX(), v1.getUniY(), x, y, res);
	}

	public static Vec2f vectorTo(double x, double y, ITup2R v2, Vec2f res)
	{
		return vectorTo(x, y, v2.getUniX(), v2.getUniY(), res);
	}
	
	public static Vec2f vectorTo(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(x2 - x1, y2 - y1);
	}
	
	public static Vec2f vectorFrom(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return vectorFrom(v1, v2.getUniX(), v2.getUniY(), res);
	}

	public static Vec2f vectorFrom(ITup2R v1, double x, double y, Vec2f res)
	{
		return vectorFrom(v1.getUniX(), v1.getUniY(), x, y, res);
	}

	public static Vec2f vectorFrom(double x, double y, ITup2fR v2, Vec2f res)
	{
		return vectorFrom(x, y, v2.getUniX(), v2.getUniY(), res);
	}

	public static Vec2f vectorFrom(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		return res.set(x1 - x2, y1 - y2);
	}
	
	public static double distance(ITup2R v1, ITup2R v2)
	{
		return distance(v1, v2.getUniX(), v2.getUniY());
	}

	public static double distance(ITup2R v1, double x, double y)
	{
		return distance(v1.getUniX(), v1.getUniY(), x, y);
	}

	public static double distance(double x, double y, ITup2R v2)
	{
		return distance(x, y, v2.getUniX(), v2.getUniY());
	}

	public static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(distanceSquared(x1, y1, x2, y2));
	}
	
	public static double distanceSquared(ITup2R v1, ITup2R v2)
	{
		return distanceSquared(v1, v2.getUniX(), v2.getUniY());
	}

	public static double distanceSquared(ITup2R v1, double x, double y)
	{
		return distanceSquared(v1.getUniX(), v1.getUniY(), x, y);
	}

	public static double distanceSquared(double x, double y, ITup2R v2)
	{
		return distanceSquared(x, y, v2.getUniX(), v2.getUniY());
	}

	public static double distanceSquared(double x1, double y1, double x2, double y2)
	{
		double x = x2 - x1;
		double y = y2 - y1;
		return x * x + y * y;
	}
	
	public static Vec2f directionTo(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return directionTo(v1, v2.getUniX(), v2.getUniY(), res);
	}

	public static Vec2f directionTo(ITup2R v1, double x, double y, Vec2f res)
	{
		return directionTo(v1.getUniX(), v1.getUniY(), x, y, res);
	}

	public static Vec2f directionTo(double x, double y, ITup2R v2, Vec2f res)
	{
		return directionTo(x, y, v2.getUniX(), v2.getUniY(), res);
	}

	public static Vec2f directionTo(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		double x = x2 - x1;
		double y = y2 - y1;
		double recLength = reciprocalLength(x,y);
		return res.set(x * recLength, y * recLength);
	}
	
	public static Vec2f directionFrom(ITup2R v1, ITup2R v2, Vec2f res)
	{
		return directionFrom(v1, v2.getUniX(), v2.getUniY(), res);
	}
	public static Vec2f directionFrom(ITup2R v1, double x, double y, Vec2f res)
	{
		return directionFrom(v1.getUniX(), v1.getUniY(), x, y, res);
	}
	
	public static Vec2f directionFrom(double x, double y, ITup2R v2, Vec2f res)
	{
		return directionFrom(x, y, v2.getUniX(), v2.getUniY(), res);
	}
	
	public static Vec2f directionFrom(double x1, double y1, double x2, double y2, Vec2f res)
	{
		res = res != null ? res : new Vec2f();
		double x = x1 - x2;
		double y = y1 - y2;
		double recLength = reciprocalLength(x,y);
		return res.set(x * recLength, y * recLength);
	}
}
