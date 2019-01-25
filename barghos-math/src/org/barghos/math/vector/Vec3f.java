package org.barghos.math.vector;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.math.api.vector.IVec3fR;
import org.barghos.math.api.vector.IVec3W;
import org.barghos.math.Maths;

/**
 * A mathematical vector with three components.
 */
public class Vec3f implements IVec3fR, IVec3W
{
	/** The x component. */
	public float x = 0.0f; 
	
	/** The y component. */
	public float y = 0.0f;
	
	/** The z component. */
	public float z = 0.0f;
	
	/**
	 * The default constructor. It sets all components to 0.
	 * It is commonly used in pools.
	 */
	public Vec3f() { set(0); }
	
	/**
	 * This contructor sets the components to the values of t.
	 * @param t A tuple that the components are set to.
	 */
	public Vec3f(ITup3R t) { assert(t != null); set(t); }
	
	/**
	 * This constructor sets both components to scalar.
	 * @param scalar A value that is set to all components.
	 */
	public Vec3f(double scalar) { set(scalar); }
	
	/**
	 * This constructor sets the components to x, y and z.
	 * @param x The new x component.
	 * @param y The new y component.
	 * @param z The new z component.
	 */
	public Vec3f(double x, double y, double z) { set(x, y, z); }


	
	
	public Vec3f setX(double x) { this.x = (float)x; return this; }
	public Vec3f setY(double y) { this.y = (float)y; return this; }
	public Vec3f setZ(double z) { this.z = (float)z; return this; }
	
	public Vec3f set(ITup3R t) { assert(t != null); return set(t.getUniX(), t.getUniY(), t.getUniZ()); }
	public Vec3f set(double scalar) { return set(scalar, scalar, scalar); }
	public Vec3f set(double x, double y, double z) { return setX(x).setY(y).setZ(z); }
	
	public Vec3f set(int index, double value) { IVec3W.super.set(index, value); return this; }

	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }

	public int getDimensions() { return 3; }
	
	
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
	 * <br>(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z)
	 * @param v1 The first tuple to add.
	 * @param v2 The second tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(ITup3R v1, ITup3R v2, Vec3f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.add(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}
	
	/**
	 * Adds a tuple to a scalar and saves the result in res.
	 * <br>(v1.x + scalar, v1.y + scalar, v1.z + scalar)
	 * @param v1 The tuple to add.
	 * @param scalar The scalar to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(ITup3R v1, double scalar, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.add(v1, scalar, scalar, scalar, res);
	}
	
	/**
	 * Adds a tuple to x, y and z and saves the result in res.
	 * <br>(v1.x + x, v1.y + y, v1.z + z)
	 * @param v1 The tuple to add.
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.add(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Adds a scalar to a tuple and saves the result in res.
	 * <br>(scalar + v2.x, scalar + v2.y, scalar + v2.z)
	 * @param scalar The scalar to add.
	 * @param v2 The tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(double scalar, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.add(scalar, scalar, scalar, v2, res);
	}
	
	/**
	 * Adds x, y and z to a tuple and saves the result in res.
	 * <br>(x + v2.x, y + v2.y, z + v2.z)
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param v2 The tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.add(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Adds x1, y1 and z1 to x2, y2 and z2 and saves the result in res.
	 * <br>(x1 + x2, y1 + y2, z1 + z2)
	 * @param x1 The first x value to add.
	 * @param y1 The first y value to add.
	 * @param z1 The first z value to add.
	 * @param x2 The second x value to add.
	 * @param y2 The second y value to add.
	 * @param z2 The second z value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(double x1, double y1, double z1, double x2, double y2, double z2, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(x1 + x2, y1 + y2, z1 + z2);
	}

	/**
	 * Subtracts one tuple from another and saves the result in res.
	 * <br>(v1.x - v2.x, v1.y - v2.y, v1. z - v2.z)
	 * @param v1 The first tuple to subtract from.
	 * @param v2 The second tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(ITup3R v1, ITup3R v2, Vec3f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.sub(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}
	
	/**
	 * Subtract from a tuple a scalar and saves the result in res.
	 * <br>(v1.x - scalar, v1.y - scalar, v1.z - scalar)
	 * @param v1 The tuple to subtract from.
	 * @param scalar The scalar to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(ITup3R v1, double scalar, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.sub(v1, scalar, scalar, scalar, res);
	}
	
	/**
	 * Subtracts from a tuple the values x, y and z and saves the result in res.
	 * <br>(v1.x - x, v1.y - y, v1.z - z)
	 * @param v1 The tuple to subtract from.
	 * @param x The x value to subtract.
	 * @param y The y value to subtract.
	 * @param z The z value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.sub(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Subtracts from a scalar the values of tuple and saves the result in res.
	 * <br>(scalar - v2.x, scalar - v2.y, scalar - v2.z)
	 * @param scalar The scalar to subtract from.
	 * @param v2 The tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(double scalar, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.sub(scalar, scalar, scalar, v2, res);
	}
	
	/**
	 * Subtracts from x, y and z the values of a tuple and saves the result in res.
	 * <br>(x - v2.x, y - v2.y, z - v2.z)
	 * @param x The x value to subtract from.
	 * @param y The y value to subtract from.
	 * @param z The z value to subtract from.
	 * @param v2 The tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.sub(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Subtracts from x1, y1 and z1 the values x2, y2 and z2 and saves the result in res.
	 * <br>(x1 - x2, y1 - y2, z1 - z2)
	 * @param x1 The first x value to subtract from.
	 * @param y1 The first y value to subtract from.
	 * @param z1 The first z value to subtract from.
	 * @param x2 The second x value to subtract.
	 * @param y2 The second y value to subtract.
	 * @param z2 The second z value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(double x1, double y1, double z1, double x2, double y2, double z2, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(x1 - x2, y1 - y2, z1 - z2);
	}

	/**
	 * Multiplies one tuple with another and saves the result in res.
	 * <br>(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z)
	 * @param v1 The first tuple to multiply.
	 * @param v2 The second tuple to mluitply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(ITup3R v1, ITup3R v2, Vec3f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.mul(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}

	/**
	 * Multiplies a tuple with a scalar and saves the result in res.
	 * <br>(v1.x * scalar, v1.y * scalar, v1.z * scalar)
	 * @param v1 The tuple to multiply.
	 * @param scalar The scalar to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(ITup3R v1, double scalar, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.mul(v1, scalar, scalar, scalar, res);
	}

	/**
	 * Multiplies a tuple with x, y and z and saves the result in res.
	 * <br>(v1.x * x, v1.y * y, v1.z * z)
	 * @param v1 The tuple to multiply.
	 * @param x The x value to multiply with.
	 * @param y The y value to multiply with.
	 * @param z The z value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.mul(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Multiplies a scalar with a tuple and saves the result in res.
	 * <br>(scalar * v2.x, scalar * v2.y, scalar * v2.z)
	 * @param scalar The scalar to mutliply.
	 * @param v2 The tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(double scalar, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.mul(scalar, scalar, scalar, v2, res);
	}

	/**
	 * Multiplies x, y and z with a tuple and saves the result in res.
	 * <br>(x * v2.x, y * v2.y, z * v2.z)
	 * @param x The x value to multiply.
	 * @param y The y value to mlutiply.
	 * @param z The z value to mlutiply.
	 * @param v2 The tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.mul(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Multiplies x1, y1 and z1 with x2, y2 and z2 and saves the result in res.
	 * <br>(x1 * x2, y1 * y2, z1 * z2)
	 * @param x1 The first x value to multiply.
	 * @param y1 The first y value to multiply.
	 * @param z1 The first z value to multiply.
	 * @param x2 The second x value to multiply with.
	 * @param y2 The second y value to multiply with.
	 * @param z2 The second z value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(double x1, double y1, double z1, double x2, double y2, double z2, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(x1 * x2, y1 * y2, z1 * z2);
	}
	
	/**
	 * Divides one tuple by another and saves the result in res.
	 * <br>(v1.x / v2.x, v1.y / v2.y, v1.z / v2.z)
	 * @param v1 The first tuple to divide.
	 * @param v2 The second tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(ITup3R v1, ITup3R v2, Vec3f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.div(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}
	
	/**
	 * Divides a tuple by a scalar and saves the result in res.
	 * <br>(v1.x / scalar, v1.y / scalar, v1.z / scalar)
	 * @param v1 The tuple to divide.
	 * @param scalar The scalar to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(ITup3R v1, double scalar, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.div(v1, scalar, scalar, scalar, res);
	}
	
	/**
	 * Divides a tuple by x, y and z and saves the result in res.
	 * <br>(v1.x / x, v1.y / y, v1.z / z)
	 * @param v1 The tuple to divide.
	 * @param x The x value to divide by.
	 * @param y The y value to divide by.
	 * @param z The z value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.div(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Divides a scalar bx a tuple and saves the result in res.
	 * <br>(scalar / v2.x, scalar / v2.y, scalar, / v2.z)
	 * @param scalar The scalar to divide.
	 * @param v2 The tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(double scalar, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.div(scalar, scalar, scalar, v2, res);
	}

	/**
	 * Divides x, y and z by a tuple and saves the result in res.
	 * <br>(x / v2.x, y / v2.y, z / v2.z)
	 * @param x The x value to divide.
	 * @param y The y value to divide.
	 * @param z The z value to divide.
	 * @param v2 The tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.div(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Divides x1, y1 and z1 by x2, y2 and z2 and saves the result in res.
	 * <br>(x1 / x2, y1 / y2, z1 / z2)
	 * @param x1 The first x value to divide.
	 * @param y1 The first y value to divide.
	 * @param z1 The first z value to divide.
	 * @param x2 The second x value to divide by.
	 * @param y2 The second y value to divide by.
	 * @param z2 The second z value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(double x1, double y1, double z1, double x2, double y2, double z2, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(x1 / x2, y1 / y2, z1 / z2);
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
	public static double dot(ITup3R v1, ITup3R v2)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.dot(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2);
	}

	/**
	 * Returns the dot product between a tuple and x2, y2 and z2.
	 * @param v1 The first tuple.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @param z2 The z component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(ITup3R v1, double x2, double y2, double z2)
	{
		assert(v1 != null);
		return Vec3f.dot(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x2, y2, z2);
	}

	/**
	 * Returns the dot product between x1, y1 and z1 and a second tuple.
	 * @param x1 The x component of the first vector.
	 * @param y1 The y component of the first vector.
	 * @param z1 The z component of the first vector.
	 * @param v2 The second tuple.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(double x1, double y1, double z1, ITup3R v2)
	{
		assert(v2 != null);
		return Vec3f.dot(x1, y1, z1, v2.getUniX(), v2.getUniY(), v2.getUniZ());
	}
	
	/**
	 * Returns the dot product between x1, y1 and z1 and x2, y2 and z2.
	 * @param x1 The x component of the first vector.
	 * @param y1 The y component of the first vector.
	 * @param z1 The z component of the first vector.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @param z2 The z component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public static double dot(double x1, double y1, double z1, double x2, double y2, double z2)
	{
		return x1 * x2 + y1 * y2 + z1 * z2;
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple.
	 * @param v The tuple that the length is from.
	 * @return The reciprocal of the length.
	 */
	public static double reciprocalLength(ITup3R v)
	{
		assert(v != null);
		return Vec3f.reciprocalLength(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x, y and z.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @return The reciprocal of the length.
	 */
	public static double reciprocalLength(double x, double y, double z)
	{
		return 1.0 / Vec3f.length(x, y, z);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(ITup3R v)
	{
		assert(v != null);
		return Vec3f.reciprocalLengthSafe(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x, y and z. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(double x, double y, double z)
	{
		return Vec3f.reciprocalLengthSafe(x, y, z, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length) of the tuple. This method is zero-safe.
	 * It uses givewn tolerance as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(ITup3R v, double tolerance)
	{
		assert(v != null);
		return Vec3f.reciprocalLengthSafe(v.getUniX(), v.getUniY(), v.getUniZ(), tolerance);
	}

	/**
	 * Returns the reciprocal of the length(1 / length) of x, y and z. This method is zero-safe.
	 * It uses given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public static double reciprocalLengthSafe(double x, double y, double z, double tolerance)
	{
		return Vec3f.isZero(x, y, z, tolerance) ? 0.0 : 1.0 / Vec3f.length(x, y, z); 
	}
	
	/**
	 * Returns the length of the tuple.
	 * @param v The tuple that the length is from.
	 * @return The length.
	 */
	public static double length(ITup3R v)
	{
		assert(v != null);
		return Vec3f.length(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the length of x, y and z.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @return The length.
	 */
	public static double length(double x, double y, double z)
	{
		return Math.sqrt(Vec3f.squaredLength(x, y, z));
	} 
	
	/**
	 * Returns the length of the tuple. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @return The length.
	 */
	public static double lengthSafe(ITup3R v)
	{
		assert(v != null);
		return Vec3f.lengthSafe(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the length of x, y and z. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @return The length.
	 */
	public static double lengthSafe(double x, double y, double z)
	{
		return Vec3f.lengthSafe(x, y, z, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns the length of the tuple. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param v The tuple that the length is from.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public static double lengthSafe(ITup3R v, double tolerance)
	{
		assert(v != null);
		return Vec3f.lengthSafe(v.getUniX(), v.getUniY(), v.getUniZ(), tolerance);
	}

	/**
	 * Returns the length of x, y and z. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public static double lengthSafe(double x, double y, double z, double tolerance)
	{
		return Vec3f.isZero(x, y, z, tolerance) ? 0.0 : Math.sqrt(Vec3f.squaredLength(x, y, z));
	}
	
	/**
	 * Returns the squared length of the tuple.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @param v The tuple that the length is from.
	 * @return The squared length.
	 */
	public static double squaredLength(ITup3R v)
	{
		assert(v != null);
		return Vec3f.squaredLength(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the squared length of x, y and z.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @return The squared length.
	 */
	public static double squaredLength(double x, double y, double z)
	{
		return x * x + y * y + z * z;
	}
	
	
	/**
	 * Returns the given tuple normalized.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f normal(ITup3R v, Vec3f res)
	{
		assert(v != null);
		return Vec3f.normal(v.getUniX(), v.getUniY(), v.getUniZ(), res);
	}

	/**
	 * Returns the given x, y and z normalized.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f normal(double x, double y, double z, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		double recLength = Vec3f.reciprocalLength(x, y, z);
		return res.set(x * recLength, y * recLength, z * recLength);
	}
	
	/**
	 * Returns the given tuple normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f normalSafe(ITup3R v, Vec3f res)
	{
		assert(v != null);
		return Vec3f.normalSafe(v.getUniX(), v.getUniY(), v.getUniZ(), res);
	}

	/**
	 * Returns the given x, y and z normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f normalSafe(double x, double y, double z, Vec3f res)
	{
		return Vec3f.normalSafe(x, y, z, Maths.SMALL_NUMBER, res);
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
	public static Vec3f normalSafe(ITup3R v, double tolerance, Vec3f res)
	{
		assert(v != null);
		return Vec3f.normalSafe(v.getUniX(), v.getUniY(), v.getUniZ(), tolerance, res);
	}

	/**
	 * Returns the given x, y and z normalized. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param tolerance The threshold around 0.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f normalSafe(double x, double y, double z, double tolerance, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		if(Vec3f.isZero(x, y, z, tolerance)) return res.set(Vec3fAxis.ZERO);
		double recLength = Vec3f.reciprocalLength(x, y, z);
		return res.set(x * recLength, y * recLength, z * recLength);
	}
	
	/**
	 * Returns the inverted vector of the tuple v.
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f invert(ITup3R v, Vec3f res)
	{
		assert(v != null);
		return Vec3f.invert(v.getUniX(), v.getUniY(), v.getUniZ(), res);
	}

	/**
	 * Returns the inverted vector of x, y and z.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f invert(double x, double y, double z, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(-x, -y, -z);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of the components of the tuple v(1 / v.x, 1 / v.y).
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f reciprocal(ITup3R v, Vec3f res)
	{
		assert(v != null);
		return Vec3f.reciprocal(v.getUniX(), v.getUniY(), v.getUniZ(), res);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of x, y and z(1 / x, 1 / y, 1 / z).
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f reciprocal(double x, double y, double z, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(1.0 / x, 1.0 / y, 1.0 / z);
	}
	
	/**
	 * Returns the cross product between the first and second tuple.
	 * @param v1 The first tuple.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f cross(ITup3R v1, ITup3R v2, Vec3f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.cross(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}
	
	/**
	 * Returns the cross product between the first tuple and x2, y2 and z2.
	 * @param v1 The first tuple.
	 * @param x2 The second x component.
	 * @param y2 The second y component.
	 * @param z2 The second z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f cross(ITup3R v1, double x2, double y2, double z2, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.cross(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x2, y2, z2, res);
	}
	
	/**
	 * Returns the cross product between x1, y1 and z1 and v2.
	 * @param x1 The first x component.
	 * @param y1 The first y component.
	 * @param z1 The first z component.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f cross(double x1, double y1, double z1, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.cross(x1, y1, z1, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Returns the cross product between x1, y1 and z1 and x2, y2 and z2.
	 * @param x1 The first x component.
	 * @param y1 The first y component.
	 * @param z1 The first z component.
	 * @param x2 The second x component.
	 * @param y2 The second y component.
	 * @param z2 The second z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f cross(double x1, double y1, double z1, double x2, double y2, double z2, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(y1 * z2 - z1 * y2, z1 * x2 - x1 * z2, x1 * y2 - y1 * x2);
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
	public static boolean isFinite(ITup3R v)
	{
		assert(v != null);
		return Vec3f.isFinite(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns if x, y and z are finite.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @return True if x, y and z are finite else (NaN/+Inf/-Inf) false.
	 */
	public static boolean isFinite(double x, double y, double z)
	{
		return Double.isFinite(x) && Double.isFinite(y) && Double.isFinite(z);
	}

	/**
	 * Returns if the components of v are zero.
	 * Therefore it uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param v The tuple to check.
	 * @return Are the components within threshold.
	 */
	public static boolean isZero(ITup3R v)
	{
		assert(v != null);
		return Vec3f.isZero(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns if x, y and z are zero.
	 * Therefore it uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @return Are x, y and z within threshold.
	 */
	public static boolean isZero(double x, double y, double z)
	{
		return Vec3f.isZero(x, y, z, Maths.SMALL_NUMBER);
	}
	
	/**
	 * Returns if the components of v are zero.
	 * Therefore it uses given tolerance as a threshold around zero.
	 * @param v The tuple to check.
	 * @param tolerance The threshold around 0.
	 * @return Are the components within threshold.
	 */
	public static boolean isZero(ITup3R v, double tolerance)
	{
		assert(v != null);
		return Vec3f.isZero(v.getUniX(), v.getUniY(), v.getUniZ(), tolerance);
	}

	/**
	 * Returns if x, y and z are zero.
	 * Therefore it uses given tolerance as a threshold around zero.
	 * @param x The x component of the vector.
	 * @param y The y component of the vector.
	 * @param z The z component of the vector.
	 * @param tolerance The threshold around 0.
	 * @return Are x, y and z within threshold.
	 */	
	public static boolean isZero(double x, double y, double z, double tolerance)
	{
		return Math.abs(x) <= tolerance && Math.abs(y) <= tolerance && Math.abs(z) <= tolerance;
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
	 * Returns a vector with absolute x, y and z component from the given tuple.
	 * @param v The tuple that components are used.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f abs(ITup3R v, Vec3f res)
	{
		assert(v != null);
		return Vec3f.abs(v.getUniX(), v.getUniY(), v.getUniZ(), res);
	}

	/**
	 * Returns a vector with absolute x, y and z component from the given x and y component.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f abs(double x, double y, double z, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(Math.abs(x), Math.abs(y), Math.abs(z));
	}
	
	/**
	 * Returns a vector with the minimal x, y and z value of two tuples.
	 * @param v1 The first tuple.
	 * @param v2 The secound tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f min(ITup3R v1, ITup3R v2, Vec3f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.min(v1, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}

	/**
	 * Returns a vector with the minimal x, y and z value of a tuple and a scalar.
	 * @param v1 The first tuple.
	 * @param scalar A single value used for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f min(ITup3R v1, double scalar, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.min(v1.getUniX(), v1.getUniY(), v1.getUniZ(), scalar, scalar, scalar, res);
	}
	
	/**
	 * Returns a vector with the minimal x, y and z value of a tuple and x and y.
	 * @param v1 The first tuple.
	 * @param x The second x component.
	 * @param y The second y component.
	 * @param z The second z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f min(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.min(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Returns a vector with the minimal x, y and z value of a scalar and a tuple.
	 * @param scalar A single value used for x and y.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f min(double scalar, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.min(scalar, scalar, scalar, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Returns a vector with the minimal x, y and z value of x, y and z and a tuple.
	 * @param x The first x component.
	 * @param y The first y component.
	 * @param z The first z component.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f min(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.min(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Returns a vector with its components set to the minimal x, y and z value of x1, y1 and z1 and x2, y2 and z2.
	 * @param x1 The first x component.
	 * @param y1 The first y component.
	 * @param z1 The first z component.
	 * @param x2 The second x component.
	 * @param y2 The second y component.
	 * @param z2 The second z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f min(double x1, double y1, double z1, double x2, double y2, double z2, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(Math.min(x1, x2), Math.min(y1, y2), Math.min(z1, z2));
	}
	
	/**
	 * Returns a vector with the maximal x, y and z value of two tuples.
	 * @param v1 The first tuple.
	 * @param v2 The secound tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f max(ITup3R v1, ITup3R v2, Vec3f res)
	{
		assert(v1 != null);
		assert(v2 != null);
		return Vec3f.max(v1, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}

	/**
	 * Returns a vector with the maximal x, y and z value of a tuple and a scalar.
	 * @param v1 The first tuple.
	 * @param scalar A single value used for x and y.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f max(ITup3R v1, double scalar, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.max(v1.getUniX(), v1.getUniY(), v1.getUniZ(), scalar, scalar, scalar, res);
	}

	/**
	 * Returns a vector with the maximal x, y and z value of a tuple and x, y and z.
	 * @param v1 The first tuple.
	 * @param x The second x component.
	 * @param y The second y component.
	 * @param z The second z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f max(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		assert(v1 != null);
		return Vec3f.max(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}

	/**
	 * Returns a vector with the maximal x, y and z value of a scalar and a tuple.
	 * @param scalar A single value used for x and y.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f max(double scalar, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.max(scalar, scalar, scalar, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}

	/**
	 * Returns a vector with the maximal x, y and z value of x, y and z and a tuple.
	 * @param x The first x component.
	 * @param y The first y component.
	 * @param z The first z component.
	 * @param v2 The second tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f max(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.max(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}

	/**
	 * Returns a vector with its components set to the maximal x, y and z value of x1, y1 and z1 and x2, y2 and z2.
	 * @param x1 The first x component.
	 * @param y1 The first y component.
	 * @param z1 The first z component.
	 * @param x2 The second x component.
	 * @param y2 The second y component.
	 * @param z2 The second z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f max(double x1, double y1, double z1, double x2, double y2, double z2, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(Math.max(x1, x2), Math.max(y1, y2), Math.max(z1, z2));
	}
	
	/**
	 * Returns the minimal component of a tuple.
	 * @param v The tuple that components are used.
	 * @return the minimal component.
	 */
	public static float getMinComponent(ITup3R v)
	{
		assert(v != null);
		return Vec3f.getMinComponent(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the minimal component of x, y and z.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @return the minimal component.
	 */
	public static float getMinComponent(double x, double y, double z)
	{
		return (float)Math.min(x, Math.min(y, z));
	}
	
	/**
	 * Returns the maximal component of a tuple.
	 * @param v The tuple that components are used.
	 * @return the maximal component.
	 */
	public static float getMaxComponent(ITup3R v)
	{
		assert(v != null);
		return Vec3f.getMaxComponent(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the maximal component of x, y and z.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @return the maximal component.
	 */
	public static float getMaxComponent(double x, double y, double z)
	{
		return (float)Math.max(x, Math.max(y, z));
	}

	/**
	 * Returns the minimal absolute component from a tuple.
	 * @param v The tuple.
	 * @return The minimal component.
	 */
	public static float getAbsMinComponent(ITup3R v)
	{
		assert(v != null);
		return Vec3f.getAbsMinComponent(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the minimal absolute component from x, y and z.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @return The minimal component.
	 */
	public static float getAbsMinComponent(double x, double y, double z)
	{
		return (float)Math.min(Math.abs(x), Math.min(Math.abs(y), Math.abs(z)));
	}
	
	/**
	 * Returns the maximal absolute component from a tuple.
	 * @param v The tuple.
	 * @return The maximal component.
	 */
	public static float getAbsMaxComponent(ITup3R v)
	{
		assert(v != null);
		return Vec3f.getAbsMaxComponent(v.getUniX(), v.getUniY(), v.getUniZ());
	}

	/**
	 * Returns the maximal absolute component from x, y and z.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @return The maximal component.
	 */
	public static float getAbsMaxComponent(double x, double y, double z)
	{
		return (float)Math.max(Math.abs(x), Math.max(Math.abs(y), Math.abs(z)));
	}
	
	/**
	 * Returns a vector with the signs of the components of the tuple.
	 * @param v The tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sign(ITup3R v, Vec3f res)
	{
		assert(v != null);
		return Vec3f.sign(v.getUniX(), v.getUniY(), v.getUniZ(), res);
	}
	
	/**
	 * Returns a vector with the signs of the components x, y and z.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sign(double x, double y, double z, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(Maths.selectByZero(x, 1.0, -1.0), Maths.selectByZero(y, 1.0, -1.0), Maths.selectByZero(z, 1.0, -1.0));
	}
	
	/**
	 * Returns a vector with the components from tuple v snapped to the gridspacing of grid.
	 * @param v The tuple.
	 * @param grid The gridspacing for x, y and z.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f gridSnap(ITup3R v, ITup3R grid, Vec3f res)
	{
		assert(v != null);
		assert(grid != null);
		return Vec3f.gridSnap(v.getUniX(), v.getUniY(), v.getUniZ(), grid, res);
	}
	
	/**
	 * Returns a vector with the components from tuple v snapped to the gridspacing of gridsize.
	 * @param v The tuple
	 * @param gridSize The gridspacing for x, y and z.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f gridSnap(ITup3R v, double gridSize, Vec3f res)
	{
		assert(v != null);
		return Vec3f.gridSnap(v.getUniX(), v.getUniY(), v.getUniZ(), gridSize, gridSize, gridSize, res);
	}
	
	/**
	 * Returns a vector with the components from tuple v snapped to the gridspacing of gx, gy, and gz.
	 * @param v The tuple
	 * @param gx The gridspacing for x.
	 * @param gy The gridspacing for y.
	 * @param gz The gridspacing for z.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f gridSnap(ITup3R v, double gx, double gy, double gz, Vec3f res)
	{
		assert(v != null);
		return Vec3f.gridSnap(v.getUniX(), v.getUniY(), v.getUniZ(), gx, gy, gz, res);
	}
	
	/**
	 * Returns a vector with the components x, y and z snapped to the gridspacing of gridsize.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param grid The gridspacing for x, y and z.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f gridSnap(double x, double y, double z, ITup3R grid, Vec3f res)
	{
		assert(grid != null);
		return Vec3f.gridSnap(x, y, z, grid.getUniX(), grid.getUniY(), grid.getUniZ(), res);
	}
	
	/**
	 * Returns a vector with the components x, y and z snapped to the gridspacing of gridsize.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param gridSize The gridspacing for x, y and z.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f gridSnap(double x, double y, double z, double gridSize, Vec3f res)
	{
		return Vec3f.gridSnap(x, y, z, gridSize, gridSize, gridSize, res);
	}
	
	/**
	 * Returns a vector with the components x, y and z snapped to the gridspacing of gx, gy and gz.
	 * @param x The x component.
	 * @param y The y component.
	 * @param z The z component.
	 * @param gx The gridspacing for x.
	 * @param gy The gridspacing for y.
	 * @param gz The gridspacing for z.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f gridSnap(double x, double y, double z, double gx, double gy, double gz, Vec3f res)
	{
		res = res != null ? res : new Vec3f();
		return res.set(Maths.gridSnap(x, gx), Maths.gridSnap(y, gy), Maths.gridSnap(z, gz));
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
	 * <br>(x + v2.x, y + v2.y, z + v2.z)
	 * @param v2 The second tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f add(ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.add(this, v2, res);
	}
	
	/**
	 * Adds a scalar to this and saves the result in res.
	 * <br>(x + scalar, y + scalar, z + scalar)
	 * @param scalar The scalar to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f add(double scalar, Vec3f res)
	{
		return Vec3f.add(this, scalar, scalar, scalar, res);
	}
	
	/**
	 * Adds x, y and z to this and saves the result in res.
	 * <br>(this.x + x, this.y + y, this.z + z)
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f add(double x, double y, double z, Vec3f res)
	{
		return Vec3f.add(this, x, y, z, res);
	}

	/**
	 * Subtracts one tuple from this and saves the result in res.
	 * <br>(x - v2.x, y - v2.y, z - v2.z)
	 * @param v2 The second tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f sub(ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.sub(this, v2, res);
	}
	
	/**
	 * Subtracts a scalar from this and saves the result in res.
	 * <br>(x - scalar, y - scalar, z - scalar)
	 * @param scalar The scalar to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f sub(double scalar, Vec3f res)
	{
		return Vec3f.sub(this, scalar, scalar, scalar, res);
	}
	
	/**
	 * Subtracts x, y and z from this and saves the result in res.
	 * <br>(this.x - x, this.y - y, this.z - z)
	 * @param x The x value to subtract.
	 * @param y The y value to subtract.
	 * @param z The z value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f sub(double x, double y, double z, Vec3f res)
	{
		return Vec3f.sub(this, x, y, z, res);
	}

	/**
	 * Multiplies this with a tuple and saves the result in res.
	 * <br>(x * v2.x, y * v2.y, z * v2.z)
	 * @param v2 The second tuple to mluitply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f mul(ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.mul(this, v2, res);
	}

	/**
	 * Multiplies this with a scalar and saves the result in res.
	 * <br>(x * scalar, y * scalar, z * scalar)
	 * @param scalar The scalar to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f mul(double scalar, Vec3f res)
	{
		return Vec3f.mul(this, scalar, scalar, scalar, res);
	}

	/**
	 * Multiplies this with x, y and z and saves the result in res.
	 * <br>(this.x * x, this.y * y, this.z * z)
	 * @param x The x value to multiply with.
	 * @param y The y value to multiply with.
	 * @param z The z value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f mul(double x, double y, double z, Vec3f res)
	{
		return Vec3f.mul(this, x, y, z, res);
	}

	
	/**
	 * Divides this by a tuple and saves the result in res.
	 * <br>(x / v2.x, y / v2.y, z / v2.z)
	 * @param v2 The second tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f div(ITup3R v2, Vec3f res)
	{
		assert(v2 != null);
		return Vec3f.div(this, v2, res);
	}
	
	/**
	 * Divides this by a scalar and saves the result in res.
	 * <br>(x / scalar, y / scalar, z / scalar)
	 * @param scalar The scalar to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f div(double scalar, Vec3f res)
	{
		return Vec3f.div(this, scalar, scalar, scalar, res);
	}
	
	/**
	 * Divides this by x, y and z and saves the result in res.
	 * <br>(this.x / x, this.y / y, this.z / z)
	 * @param x The x value to divide by.
	 * @param y The y value to divide by.
	 * @param z The z value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f div(double x, double y, double z, Vec3f res)
	{
		return Vec3f.div(this, x, y, z, res);
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
	public Vec3f normal(Vec3f res)
	{
		return Vec3f.normal(this, res);
	}
	
	/**
	 * Normalizes the vector.
	 * @return This vector normalized.
	 */
	public Vec3f normal()
	{
		return Vec3f.normal(this, this);
	}
	
	/**
	 * Returns a vector with the components set to this normalized. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets res the return to a zero vector.
	 * @param v The tuple to normalize.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f normalSafe(Vec3f res)
	{
		return Vec3f.normalSafe(this, res);
	}
	
	/**
	 * Normalizes the vector. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * If the length is zero this function sets this vector to zero.
	 * @return This vector normalized or set to zero.
	 */
	public Vec3f normalSafe()
	{
		return Vec3f.normalSafe(this, this);
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
	public Vec3f normalSafe(double tolerance, Vec3f res)
	{
		return Vec3f.normalSafe(this, tolerance, res);
	}
	
	/**
	 * Normalizes the vector. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * If the length is zero this function sets this vector to zero.
	 * @param tolerance The threshold around 0.
	 * @return This vector normalized or set to zero.
	 */
	public Vec3f normalSafe(double tolerance)
	{
		return Vec3f.normalSafe(this, tolerance, this);
	}
	
	/**
	 * Returns a vector with the components set to this inverted.
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f invert(Vec3f res)
	{
		return Vec3f.invert(this, res);
	}
	
	/**
	 * Negates the vector.
	 * @return This vector negated.
	 */
	public Vec3f invert()
	{
		return Vec3f.invert(this, this);
	}
	
	/**
	 * Returns a vector with the components set to the reciprocals of the components of this (1 / x, 1 / y, 1 / z).
	 * @param v The input tuple.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public Vec3f reciprocal(Vec3f res)
	{
		return Vec3f.reciprocal(this, res);
	}
	
	/**
	 * Sets all components to the reciprocals of the originial components(1 / x, 1 / y, 1 / z).
	 * @return This vector with the reciprocals of the original components.
	 */
	public Vec3f reciprocal()
	{
		return Vec3f.reciprocal(this, this);
	}
	
	/**
	 * Returns the dot product between this and a tuple.
	 * @param v2 The second float tuple.
	 * @return The dot product (cosine angle).
	 */
	public double dot(ITup3R v2)
	{
		assert(v2 != null);
		return Vec3f.dot(this, v2);
	}

	/**
	 * Returns the dot product between this and x2, y2 and z2.
	 * @param x2 The x component of the second vector.
	 * @param y2 The y component of the second vector.
	 * @param z2 The z component of the second vector.
	 * @return The dot product (cosine angle).
	 */
	public double dot(double x2, double y2, double z2)
	{
		return Vec3f.dot(this, x2, y2, z2);
	}

	
	/**
	 * Returns the reciprocal of the length(1 / length).
	 * @return The reciprocal of the length.
	 */
	public double reciprocalLength()
	{
		return Vec3f.reciprocalLength(this);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length). This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @return The reciprocal of the length or 0.
	 */
	public double reciprocalLengthSafe()
	{
		return Vec3f.reciprocalLengthSafe(this);
	}
	
	/**
	 * Returns the reciprocal of the length(1 / length). This method is zero-safe.
	 * It uses givewn tolerance as a threshold around zero.
	 * @param tolerance The threshold around 0.
	 * @return The reciprocal of the length or 0.
	 */
	public double reciprocalLengthSafe(double tolerance)
	{
		return Vec3f.reciprocalLengthSafe(this, tolerance);
	}
	
	/**
	 * Returns the length.
	 * @return The length.
	 */
	public double length()
	{
		return Vec3f.length(this);
	}
	
	/**
	 * Returns the length. This method is zero-safe.
	 * It uses Maths.SMALL_NUMBER as a threshold around zero.
	 * @return The length.
	 */
	public double lengthSafe()
	{
		return Vec3f.lengthSafe(this);
	}

	/**
	 * Returns the length. This method is zero-safe.
	 * It uses the given tolerance as a threshold around zero.
	 * @param tolerance The threshold around 0.
	 * @return The length.
	 */
	public double lengthSafe(double tolerance)
	{
		return Vec3f.lengthSafe(this, tolerance);
	}
	
	/**
	 * Returns the squared length.
	 * This function should be prefered to length for comparing two vectors
	 * as it doesn't require a squareroot.
	 * @return The squared length.
	 */
	public double squaredLength()
	{
		return Vec3f.squaredLength(this);
	}

	public String toString()
	{
		return "vec3f(" + this.x + ", " + this.y + ", " + this.z + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof Vec3f)) return false;
		Vec3f v = (Vec3f)obj;
		
		if(this.x != v.x) return false;
		if(this.y != v.y) return false;
		if(this.z != v.z) return false;
		
		return true;
	}
}
