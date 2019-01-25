package org.barghos.math.vector;

import org.barghos.core.api.tuple.ITup4R;
import org.barghos.math.api.vector.IVec4fR;
import org.barghos.math.Maths;
import org.barghos.math.api.vector.IVec4W;

/**
 * A mathematical vector with four components.
 */
public class Vec4f implements IVec4fR, IVec4W
{
	/** The x component. */
	public float x = 0.0f; 
	
	/** The y component. */
	public float y = 0.0f;
	
	/** The z component. */
	public float z = 0.0f;
	
	/** The w component. */
	public float w = 0.0f;
	
	
	
	/**
	 * The default constructor. It sets all components to 0.
	 * It is commonly used in pools.
	 */
	public Vec4f() { set(0); }
	
	/**
	 * This contructor sets the components to the values of t.
	 * @param t A tuple that the components are set to.
	 */
	public Vec4f(ITup4R t) { assert(t != null); set(t); }
	
	/**
	 * This constructor sets both components to scalar.
	 * @param scalar A value that is set to all components.
	 */
	public Vec4f(double scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to x, y, z and w.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @param z The new z component.
	 * @param w The new w component.
	 */
	public Vec4f(double x, double y, double z, double w) { set(x, y, z, w); }

	public Vec4f setX(double x) { this.x = (float)x; return this; }
	public Vec4f setY(double y) { this.y = (float)y; return this; }
	public Vec4f setZ(double z) { this.z = (float)z; return this; }
	public Vec4f setW(double w) { this.w = (float)w; return this; }
	
	public Vec4f set(ITup4R t) { assert(t != null); return set(t.getUniX(), t.getUniY(), t.getUniZ(), t.getUniW()); }
	public Vec4f set(double scalar) { return set(scalar, scalar, scalar, scalar); }
	public Vec4f set(double x, double y, double z, double w) { return setX(x).setY(y).setZ(z).setW(w); }
	
	public Vec4f set(int index, double value) { IVec4W.super.set(index, value); return this; }
	
	
	
	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }
	public float getW() { return this.w; }

	public int getDimensions() { return 4; }
	
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
	 * <br>(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z, v1.w + v2.w)
	 * @param v1 The first tuple to add.
	 * @param v2 The second tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f add(ITup4R v1, ITup4R v2, Vec4f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec4f.add(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), v2, res);
	}
	
	/**
	 * Adds a tuple to a scalar and saves the result in res.
	 * <br>(v1.x + scalar, v1.y + scalar, v1.z + scalar, v1.w + scalar)
	 * @param v1 The tuple to add.
	 * @param scalar The scalar to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f add(ITup4R v1, double scalar, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.add(v1, scalar, scalar, scalar, scalar, res);
	}
	
	/**
	 * Adds a tuple to x, y, z and w and saves the result in res.
	 * <br>(v1.x + x, v1.y + y, v1.z + z, v1.w + w)
	 * @param v1 The tuple to add.
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param w The w value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f add(ITup4R v1, double x, double y, double z, double w, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.add(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), x, y, z, w, res);
	}
	
	/**
	 * Adds a scalar to a tuple and saves the result in res.
	 * <br>(scalar + v2.x, scalar + v2.y, scalar + v2.z, scalar + v2.w)
	 * @param scalar The scalar to add.
	 * @param v2 The tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f add(double scalar, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.add(scalar, scalar, scalar, scalar, v2, res);
	}
	
	/**
	 * Adds x, y, z and w to a tuple and saves the result in res.
	 * <br>(x + v2.x, y + v2.y, z + v2.z, w + v2.w)
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param w The w value to add.
	 * @param v2 The tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f add(double x, double y, double z, double w, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.add(x, y, z, w, v2.getUniX(), v2.getUniY(), v2.getUniZ(), v2.getUniW(), res);
	}
	
	/**
	 * Adds x1, y1, z1 and w1 to x2, y2, z2 and w2 and saves the result in res.
	 * <br>(x1 + x2, y1 + y2, z1 + z2, w1 + w2)
	 * @param x1 The first x value to add.
	 * @param y1 The first y value to add.
	 * @param z1 The first z value to add.
	 * @param w1 The first w value to add.
	 * @param x2 The second x value to add.
	 * @param y2 The second y value to add.
	 * @param z2 The second z value to add.
	 * @param w2 The second z value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f add(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(x1 + x2, y1 + y2, z1 + z2, w1 + w2);
	}

	/**
	 * Subtracts one tuple from another and saves the result in res.
	 * <br>(v1.x - v2.x, v1.y - v2.y, v1. z - v2.z, v1.w - v2.w)
	 * @param v1 The first tuple to subtract from.
	 * @param v2 The second tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f sub(ITup4R v1, ITup4R v2, Vec4f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec4f.sub(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), v2, res);
	}
	
	/**
	 * Subtract from a tuple a scalar and saves the result in res.
	 * <br>(v1.x - scalar, v1.y - scalar, v1.z - scalar, v1.w - scalar)
	 * @param v1 The tuple to subtract from.
	 * @param scalar The scalar to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f sub(ITup4R v1, double scalar, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.sub(v1, scalar, scalar, scalar, scalar, res);
	}
	
	/**
	 * Subtracts from a tuple the values x, y, z and w and saves the result in res.
	 * <br>(v1.x - x, v1.y - y, v1.z - z, v1.w - w)
	 * @param v1 The tuple to subtract from.
	 * @param x The x value to subtract.
	 * @param y The y value to subtract.
	 * @param z The z value to subtract.
	 * @param w The w value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f sub(ITup4R v1, double x, double y, double z, double w, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.sub(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), x, y, z, w, res);
	}
	
	/**
	 * Subtracts from a scalar the values of tuple and saves the result in res.
	 * <br>(scalar - v2.x, scalar - v2.y, scalar - v2.z, scalar - v2.w)
	 * @param scalar The scalar to subtract from.
	 * @param v2 The tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f sub(double scalar, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.sub(scalar, scalar, scalar, scalar, v2, res);
	}
	
	/**
	 * Subtracts from x, y, z and w the values of a tuple and saves the result in res.
	 * <br>(x - v2.x, y - v2.y, z - v2.z, w - v2.w)
	 * @param x The x value to subtract from.
	 * @param y The y value to subtract from.
	 * @param z The z value to subtract from.
	 * @param w The w value to subtract from.
	 * @param v2 The tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f sub(double x, double y, double z, double w, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.sub(x, y, z, w, v2.getUniX(), v2.getUniY(), v2.getUniZ(), v2.getUniW(), res);
	}
	
	/**
	 * Subtracts from x1, y1, z1 and w1 the values x2, y2, z2 and w2 and saves the result in res.
	 * <br>(x1 - x2, y1 - y2, z1 - z2, w1 - w2)
	 * @param x1 The first x value to subtract from.
	 * @param y1 The first y value to subtract from.
	 * @param z1 The first z value to subtract from.
	 * @param w1 The first w value to subtract from.
	 * @param x2 The second x value to subtract.
	 * @param y2 The second y value to subtract.
	 * @param z2 The second z value to subtract.
	 * @param w2 The second w value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f sub(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(x1 - x2, y1 - y2, z1 - z2, w1 - w2);
	}

	/**
	 * Multiplies one tuple with another and saves the result in res.
	 * <br>(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z, v1.w * v2.w)
	 * @param v1 The first tuple to multiply.
	 * @param v2 The second tuple to mluitply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f mul(ITup4R v1, ITup4R v2, Vec4f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec4f.mul(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), v2, res);
	}

	/**
	 * Multiplies a tuple with a scalar and saves the result in res.
	 * <br>(v1.x * scalar, v1.y * scalar, v1.z * scalar, v1.w - scalar)
	 * @param v1 The tuple to multiply.
	 * @param scalar The scalar to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f mul(ITup4R v1, double scalar, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.mul(v1, scalar, scalar, scalar, scalar, res);
	}

	/**
	 * Multiplies a tuple with x, y, z and w and saves the result in res.
	 * <br>(v1.x * x, v1.y * y, v1.z * z, v1.w * w)
	 * @param v1 The tuple to multiply.
	 * @param x The x value to multiply with.
	 * @param y The y value to multiply with.
	 * @param z The z value to multiply with.
	 * @param w The w value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f mul(ITup4R v1, double x, double y, double z, double w, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.mul(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), x, y, z, w, res);
	}
	
	/**
	 * Multiplies a scalar with a tuple and saves the result in res.
	 * <br>(scalar * v2.x, scalar * v2.y, scalar * v2.z, scalar * v2.w)
	 * @param scalar The scalar to mutliply.
	 * @param v2 The tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f mul(double scalar, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.mul(scalar, scalar, scalar, scalar, v2, res);
	}

	/**
	 * Multiplies x, y, z and w with a tuple and saves the result in res.
	 * <br>(x * v2.x, y * v2.y, z * v2.z, w * v2.w)
	 * @param x The x value to multiply.
	 * @param y The y value to mlutiply.
	 * @param z The z value to mlutiply.
	 * @param w The w value to mlutiply.
	 * @param v2 The tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f mul(double x, double y, double z, double w, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.mul(x, y, z, w, v2.getUniX(), v2.getUniY(), v2.getUniZ(), v2.getUniW(), res);
	}
	
	/**
	 * Multiplies x1, y1, z1 and w1 with x2, y2, z2 and w2 and saves the result in res.
	 * <br>(x1 * x2, y1 * y2, z1 * z2, w1 * w2)
	 * @param x1 The first x value to multiply.
	 * @param y1 The first y value to multiply.
	 * @param z1 The first z value to multiply.
	 * @param w1 The first w value to multiply.
	 * @param x2 The second x value to multiply with.
	 * @param y2 The second y value to multiply with.
	 * @param z2 The second z value to multiply with.
	 * @param w2 The second w value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f mul(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(x1 * x2, y1 * y2, z1 * z2, w1 * w2);
	}
	
	/**
	 * Divides one tuple by another and saves the result in res.
	 * <br>(v1.x / v2.x, v1.y / v2.y, v1.z / v2.z, v1.w / v2.w)
	 * @param v1 The first tuple to divide.
	 * @param v2 The second tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f div(ITup4R v1, ITup4R v2, Vec4f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec4f.div(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), v2, res);
	}
	
	/**
	 * Divides a tuple by a scalar and saves the result in res.
	 * <br>(v1.x / scalar, v1.y / scalar, v1.z / scalar, v1.w / scalar)
	 * @param v1 The tuple to divide.
	 * @param scalar The scalar to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f div(ITup4R v1, double scalar, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.div(v1, scalar, scalar, scalar, scalar, res);
	}
	
	/**
	 * Divides a tuple by x, y, z and w and saves the result in res.
	 * <br>(v1.x / x, v1.y / y, v1.z / z, v1.w / w)
	 * @param v1 The tuple to divide.
	 * @param x The x value to divide by.
	 * @param y The y value to divide by.
	 * @param z The z value to divide by.
	 * @param w The w value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f div(ITup4R v1, double x, double y, double z, double w, Vec4f res)
	{
		assert(v1 != null);
		return Vec4f.div(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), x, y, z, w, res);
	}
	
	/**
	 * Divides a scalar bx a tuple and saves the result in res.
	 * <br>(scalar / v2.x, scalar / v2.y, scalar, / v2.z, scalar / v2.w)
	 * @param scalar The scalar to divide.
	 * @param v2 The tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f div(double scalar, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.div(scalar, scalar, scalar, scalar, v2, res);
	}

	/**
	 * Divides x, y, z and w by a tuple and saves the result in res.
	 * <br>(x / v2.x, y / v2.y, z / v2.z, w / v2.w)
	 * @param x The x value to divide.
	 * @param y The y value to divide.
	 * @param z The z value to divide.
	 * @param w The w value to divide.
	 * @param v2 The tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f div(double x, double y, double z, double w, ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.div(x, y, z, w, v2.getUniX(), v2.getUniY(), v2.getUniZ(), v2.getUniW(), res);
	}
	
	/**
	 * Divides x1, y1, z1 and w1 by x2, y2, z2 and w2 and saves the result in res.
	 * <br>(x1 / x2, y1 / y2, z1 / z2, w1 / w2)
	 * @param x1 The first x value to divide.
	 * @param y1 The first y value to divide.
	 * @param z1 The first z value to divide.
	 * @param w1 The first w value to divide.
	 * @param x2 The second x value to divide by.
	 * @param y2 The second y value to divide by.
	 * @param z2 The second z value to divide by.
	 * @param w2 The second w value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f div(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(x1 / x2, y1 / y2, z1 / z2, w1 / w2);
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
	public static double dot(ITup4R v1, ITup4R v2)
	{
		assert(v1 != null);
		assert(v2 != null);	
		return Vec4f.dot(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), v2);
	}

	/**
	 * Returns the dot product between a tuple and x2, y2, z2 and w.
	 * @param v1 The first tuple.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @param z2 The z component of the second vector.
	 * @param w2 The w component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(ITup4R v1, double x2, double y2, double z2, double w2)
	{
		assert(v1 != null);
		return Vec4f.dot(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v1.getUniW(), x2, y2, z2, w2);
	}

	/**
	 * Returns the dot product between x1, y1, z1 and w1 and a second tuple.
	 * @param x1 The x component of the first vector.
	 * @param y1 The y component of the first vector.
	 * @param z1 The z component of the first vector.
	 * @param w1 The w component of the first vector.
	 * @param v2 The second tuple.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(double x1, double y1, double z1, double w1, ITup4R v2)
	{
		assert(v2 != null);
		return Vec4f.dot(x1, y1, z1, w1, v2.getUniX(), v2.getUniY(), v2.getUniZ(), v2.getUniW());
	}
	
	/**
	 * Returns the dot product between x1, y1, z1 and w1 and x2, y2, z2 and w2.
	 * @param x1 The x component of the first vector.
	 * @param y1 The y component of the first vector.
	 * @param z1 The z component of the first vector.
	 * @param w1 The w component of the first vector.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @param z2 The z component of the second vector.
	 * @param w2 The w component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(double x1, double y1, double z1, double w1, double x2, double y2, double z2, double w2)
	{
		return x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2;
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple.
	 * @param v The tuple that the length is from.
	 * @return The reciprocal of the length.
	 */
	public static double reciprocalLength(ITup4R v)
	{
		assert(v != null);
		return Vec4f.reciprocalLength(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW());
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x, y and z.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @return The reciprocal of the length.
	 */
	public static double reciprocalLength(double x, double y, double z, double w)
	{
		return 1.0 / Vec4f.length(x, y, z, w);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(ITup4R v)
	{
		assert(v != null);
		return Vec4f.reciprocalLengthSafe(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW());
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x, y, z and w. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(double x, double y, double z, double w)
	{
		return Vec4f.reciprocalLengthSafe(x, y, z, w, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple. This method is zero-safe.
	 * It uses givewn tolerance as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(ITup4R v, double tolerance)
	{
		assert(v != null);
		return Vec4f.reciprocalLengthSafe(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), tolerance);
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x, y, z and w. This method is zero-safe.
	 * It uses given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(double x, double y, double z, double w, double tolerance)
	{
		return Vec4f.isZero(x, y, z, w, tolerance) ? 0.0 : 1.0 / Vec4f.length(x, y, z, w); 
	}
	
	/**
	 * Returns the length of the tuple.
	 * @param v The tuple that the length is from.
	 * @return The length.
	 */
	public static double length(ITup4R v)
	{
		return Vec4f.length(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW());
	}

	/**
	 * Returns the length of x, y, z and w.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @return The length.
	 */
	public static double length(double x, double y, double z, double w)
	{
		return Math.sqrt(Vec4f.squaredLength(x, y, z,w));
	} 
	
	/**
	 * Returns the length of the tuple. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @return The length.
	 */
	public static double lengthSafe(ITup4R v)
	{
		assert(v != null);
		return Vec4f.lengthSafe(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW());
	}

	/**
	 * Returns the length of x, y, z and w. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @return The length.
	 */
	public static double lengthSafe(double x, double y, double z, double w)
	{
		return Vec4f.lengthSafe(x, y, z, w, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns the length of the tuple. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public static double lengthSafe(ITup4R v, double tolerance)
	{
		assert(v != null);
		return Vec4f.lengthSafe(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), tolerance);
	}

	/**
	 * Returns the length of x, y, z and w. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public static double lengthSafe(double x, double y, double z, double w, double tolerance)
	{
		return Vec4f.isZero(x, y, z, w, tolerance) ? 0.0 : Math.sqrt(Vec4f.squaredLength(x, y, z, w));
	}
	
	/**
	 * Returns the squared length of the tuple.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @param v The tuple that the length is from.
	 * @return The squared length.
	 */
	public static double squaredLength(ITup4R v)
	{
		assert(v != null);
		return Vec4f.squaredLength(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW());
	}

	/**
	 * Returns the squared length of x, y, z and w.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param w The w component.
	 * @return The squared length.
	 */
	public static double squaredLength(double x, double y, double z, double w)
	{
		return x * x + y * y + z * z + w * w;
	}
	
	/**
	 * Returns the given tuple normalized.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f normal(ITup4R v, Vec4f res)
	{
		assert(v != null);
		return Vec4f.normal(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), res);
	}

	/**
	 * Returns the given x, y, z and w normalized.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f normal(double x, double y, double z, double w, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		double recLength = Vec4f.reciprocalLength(x, y, z, w);
		return res.set(x * recLength, y * recLength, z * recLength, w * recLength);
	}
	
	/**
	 * Returns the given tuple normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f normalSafe(ITup4R v, Vec4f res)
	{
		assert(v != null);
		return Vec4f.normalSafe(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), res);
	}

	/**
	 * Returns the given x, y, z and w normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f normalSafe(double x, double y, double z, double w, Vec4f res)
	{
		return Vec4f.normalSafe(x, y, z, w, Maths.SMALL_NUMBER, res);
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
	public static Vec4f normalSafe(ITup4R v, double tolerance, Vec4f res)
	{
		assert(v != null);
		return Vec4f.normalSafe(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), tolerance, res);
	}

	/**
	 * Returns the given x, y, z and w normalized. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @param tolerance The threshold around 0.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f normalSafe(double x, double y, double z, double w, double tolerance, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		if(isZero(x, y, z, w, tolerance)) return res.set(0);
		double recLength = Vec4f.reciprocalLength(x, y, z, w);
		return res.set(x * recLength, y * recLength, z * recLength, w * recLength);
	}
	
	/**
	 * Returns the inverted vector of the tuple v.
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f invert(ITup4R v, Vec4f res)
	{
		assert(v != null);
		return Vec4f.invert(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), res);
	}

	/**
	 * Returns the inverted vector of x, y, z and w.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param w The w component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f invert(double x, double y, double z, double w, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(-x, -y, -z, -w);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of the components of the tuple v(1 / v.x, 1 / v.y, 1 / v.z, 1 / v.w).
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f reciprocal(ITup4R v, Vec4f res)
	{
		assert(v != null);
		return Vec4f.reciprocal(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), res);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of x, y, z and w(1 / x, 1 / y, 1 / z, 1 / w).
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec4f reciprocal(double x, double y, double z, double w, Vec4f res)
	{
		res = res != null ? res : new Vec4f();
		return res.set(1.0 / x, 1.0 / y, 1.0 / z, 1.0 / w);
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
	public static boolean isFinite(ITup4R v)
	{
		assert(v != null);
		return Vec4f.isFinite(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW());
	}

	/**
	 * Returns if x, y, z and w are finite.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @return True if x, y, z and w are finite else (NaN/+Inf/-Inf) false.
	 */
	public static boolean isFinite(double x, double y, double z, double w)
	{
		return Double.isFinite(x) && Double.isFinite(y) && Double.isFinite(z) && Double.isFinite(w);
	}

	/**
	 * Returns if the components of v are zero.
	 * Therefore it uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple to check.
	 * @return Are the components within threshold.
	 */
	public static boolean isZero(ITup4R v)
	{
		assert(v != null);
		return Vec4f.isZero(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW());
	}

	/**
	 * Returns if x, y, z and w are zero.
	 * Therefore it uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @return Are x, y, z and w within threshold.
	 */
	public static boolean isZero(double x, double y, double z, double w)
	{
		return Vec4f.isZero(x, y, z, w, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns if the components of v are zero.
	 * Therefore it uses given tolerance as a threshold around zero.
	 * @param v The tuple to check.
	 * @param tolerance The threshold around 0.
	 * @return Are the components within threshold.
	 */
	public static boolean isZero(ITup4R v, double tolerance)
	{
		assert(v != null);
		return Vec4f.isZero(v.getUniX(), v.getUniY(), v.getUniZ(), v.getUniW(), tolerance);
	}

	/**
	 * Returns if x, y, z and w are zero.
	 * Therefore it uses given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param w The w component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return Are x, y, z and w within threshold.
	 */	
	public static boolean isZero(double x, double y, double z, double w, double tolerance)
	{
		return Math.abs(x) <= tolerance && Math.abs(y) <= tolerance && Math.abs(z) <= tolerance && Math.abs(w) <= tolerance;
	}
	
	/*
	 * ############################
	 * ############################
	 * ##                        ##
	 * ##  ARITHMETICS           ##
	 * ##                        ##
	 * ############################
	 * ############################
	 */

	/**
	 * Adds a tuple to this and saves the result in res.
	 * <br>(x + v2.x, y + v2.y, z + v2.z, w + v2.w)
	 * @param v2 The second tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f add(ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.add(this, v2, res);
	}
	
	/**
	 * Adds a scalar to this and saves the result in res.
	 * <br>(x + scalar, y + scalar, z + scalar, w + scalar)
	 * @param scalar The scalar to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f add(double scalar, Vec4f res)
	{
		return Vec4f.add(this, scalar, scalar, scalar, scalar, res);
	}
	
	/**
	 * Adds x, y, z and w to this and saves the result in res.
	 * <br>(this.x + x, this.y + y, this.z + z, this.w + w)
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param w The w value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f add(double x, double y, double z, double w, Vec4f res)
	{
		return Vec4f.add(this, x, y, z, w, res);
	}

	/**
	 * Subtracts one tuple from this and saves the result in res.
	 * <br>(x - v2.x, y - v2.y, z - v2.z, w - v2.w)
	 * @param v2 The second tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f sub(ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.sub(this, v2, res);
	}
	
	/**
	 * Subtracts a scalar from this and saves the result in res.
	 * <br>(x - scalar, y - scalar, z - scalar, w - scalar)
	 * @param scalar The scalar to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f sub(double scalar, Vec4f res)
	{
		return Vec4f.sub(this, scalar, scalar, scalar, scalar, res);
	}
	
	/**
	 * Subtracts x, y, z and w from this and saves the result in res.
	 * <br>(this.x - x, this.y - y, this.z - z, this.w - w)
	 * @param x The x value to subtract.
	 * @param y The y value to subtract.
	 * @param z The z value to subtract.
	 * @param w The w value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f sub(double x, double y, double z, double w, Vec4f res)
	{
		return Vec4f.sub(this, x, y, z, w, res);
	}

	/**
	 * Multiplies this with a tuple and saves the result in res.
	 * <br>(x * v2.x, y * v2.y, z * v2.z, w * v2.w)
	 * @param v2 The second tuple to mluitply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f mul(ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.mul(this, v2, res);
	}

	/**
	 * Multiplies this with a scalar and saves the result in res.
	 * <br>(x * scalar, y * scalar, z * scalar, w * scalar)
	 * @param scalar The scalar to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f mul(double scalar, Vec4f res)
	{
		return Vec4f.mul(this, scalar, scalar, scalar, scalar, res);
	}

	/**
	 * Multiplies this with x, y, z and w and saves the result in res.
	 * <br>(this.x * x, this.y * y, this.z * z, this.w * w)
	 * @param x The x value to multiply with.
	 * @param y The y value to multiply with.
	 * @param z The z value to multiply with.
	 * @param w The w value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f mul(double x, double y, double z, double w, Vec4f res)
	{
		return Vec4f.mul(this, x, y, z, w, res);
	}

	
	/**
	 * Divides this by a tuple and saves the result in res.
	 * <br>(x / v2.x, y / v2.y, z / v2.z, w / v2.w)
	 * @param v2 The second tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f div(ITup4R v2, Vec4f res)
	{
		assert(v2 != null);
		return Vec4f.div(this, v2, res);
	}
	
	/**
	 * Divides this by a scalar and saves the result in res.
	 * <br>(x / scalar, y / scalar, z / scalar, w / scalar)
	 * @param scalar The scalar to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f div(double scalar, Vec4f res)
	{
		return Vec4f.div(this, scalar, scalar, scalar, scalar, res);
	}
	
	/**
	 * Divides this by x, y, z and w and saves the result in res.
	 * <br>(this.x / x, this.y / y, this.z / z, this.w / w)
	 * @param x The x value to divide by.
	 * @param y The y value to divide by.
	 * @param z The z value to divide by.
	 * @param w The w value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f div(double x, double y, double z, double w, Vec4f res)
	{
		return Vec4f.div(this, x, y, z, w, res);
	}

	/*
	 * ########################################
	 * ########################################
	 * ##                                    ##
	 * ##  BASIC VECTOR OPERATIONS           ##
	 * ##                                    ##
	 * ########################################
	 * ########################################
	 */
	
	/**
	 * Returns a vector with the components set to this normalized.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f normal(Vec4f res)
	{
		return Vec4f.normal(this, res);
	}
	
	/**
	 * Normalizes the vector.
	 * @return This vector normalized.
	 */
	public Vec4f normal()
	{
		return Vec4f.normal(this, this);
	}
	
	/**
	 * Returns a vector with the components set to this normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f normalSafe(Vec4f res)
	{
		return Vec4f.normalSafe(this, res);
	}
	
	/**
	 * Normalizes the vector. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets this vector to zero.
	 * @return This vector normalized or set to zero.
	 */
	public Vec4f normalSafe()
	{
		return Vec4f.normalSafe(this, this);
	}
	
	/**
	 * Returns a vector with the components set to this normalized. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param v The tuple to normalize.
	 * @param tolerance The threshold around 0.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f normalSafe(double tolerance, Vec4f res)
	{
		return Vec4f.normalSafe(this, tolerance, res);
	}
	
	/**
	 * Normalizes the vector. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * If the length is zero this function sets this vector to zero.
	 * @param tolerance The threshold around 0.
	 * @return This vector normalized or set to zero.
	 */
	public Vec4f normalSafe(double tolerance)
	{
		return Vec4f.normalSafe(this, tolerance, this);
	}
	
	/**
	 * Returns a vector with the components set to this inverted.
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f invert(Vec4f res)
	{
		return Vec4f.invert(this, res);
	}
	
	/**
	 * Negates the vector.
	 * @return This vector negated.
	 */
	public Vec4f invert()
	{
		return Vec4f.invert(this, this);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of the components of this (1 / x, 1 / y, 1 / z, 1 / w).
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec4f reciprocal(Vec4f res)
	{
		return Vec4f.reciprocal(this, res);
	}
	
	/**
	 * Sets all components to the reciprocals of the originial components(1 / x, 1 / y, 1 / z, 1 / w).
	 * @return This vector with the reciprocals of the original components.
	 */
	public Vec4f reciprocal()
	{
		return Vec4f.reciprocal(this, this);
	}
	
	/**
	 * Returns the dot product between this and a tuple.
	 * @param v2 The second float tuple.
	 * @return The dot product (cosine angle).
	 */
	public double dot(ITup4R v2)
	{
		assert(v2 != null);
		return Vec4f.dot(this, v2);
	}

	/**
	 * Returns the dot product between this and x2, y2, z2 and w2.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @param z2 The z component of the second vector.
	 * @param w2 The w component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public double dot(double x2, double y2, double z2, double w2)
	{
		return Vec4f.dot(this, x2, y2, z2, w2);
	}

	
	/**
	 * Returns the reciprocal of the length(1 / length).
	 * @return The reciprocal of the length.
	 */
	public double reciprocalLength()
	{
		return Vec4f.reciprocalLength(this);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length). This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @return The reciprocal of the length or 0.
	 */
	public double reciprocalLengthSafe()
	{
		return Vec4f.reciprocalLengthSafe(this);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length). This method is zero-safe.
	 * It uses givewn tolerance as a threshold around zero.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public double reciprocalLengthSafe(double tolerance)
	{
		return Vec4f.reciprocalLengthSafe(this, tolerance);
	}
	
	/**
	 * Returns the length.
	 * @return The length.
	 */
	public double length()
	{
		return Vec4f.length(this);
	}
	
	/**
	 * Returns the length. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @return The length.
	 */
	public double lengthSafe()
	{
		return Vec4f.lengthSafe(this);
	}

	/**
	 * Returns the length. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public double lengthSafe(double tolerance)
	{
		return Vec4f.lengthSafe(this, tolerance);
	}
	
	/**
	 * Returns the squared length.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @return The squared length.
	 */
	public double squaredLength()
	{
		return Vec4f.squaredLength(this);
	}
	
	public String toString()
	{
		return "vec4(" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof Vec4f)) return false;
		Vec4f v = (Vec4f)obj;
		
		if(this.x != v.x) return false;
		if(this.y != v.y) return false;
		if(this.z != v.z) return false;
		if(this.w != v.w) return false;
		
		return true;
	}
}
