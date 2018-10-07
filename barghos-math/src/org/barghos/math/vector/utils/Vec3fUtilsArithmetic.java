package org.barghos.math.vector.utils;

import org.barghos.core.api.tuple.ITup3R;
import org.barghos.math.vector.Vec3f;

class Vec3fUtilsArithmetics
{
	/**
	 * Adds one tuple to another and saves the result in res.
	 * <br>(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z)
	 * @param v1 The first float tuple to add.
	 * @param v2 The second float tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(ITup3R v1, ITup3R v2, Vec3f res)
	{
		return add(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}
	
	/**
	 * Adds a tuple to a scalar and saves the result in res.
	 * <br>(v1.x + scalar, v1.y + scalar, v1.z + scalar)
	 * @param v1 The float tuple to add.
	 * @param scalar The scalar to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(ITup3R v1, double scalar, Vec3f res)
	{
		return add(v1, scalar, scalar, scalar, res);
	}
	
	/**
	 * Adds a tuple to x and y and saves the result in res.
	 * <br>(v1.x + x, v1.y + y, v1.z + z)
	 * @param v1 The float tuple to add.
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		return add(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Adds a scalar to a tuple and saves the result in res.
	 * <br>(scalar + v2.x, scalar + v2.y, scalar + v2.z)
	 * @param scalar The scalar to add.
	 * @param v2 The float tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(double scalar, ITup3R v2, Vec3f res)
	{
		return add(scalar, scalar, scalar, v2, res);
	}
	
	/**
	 * Adds x and y to a tuple and saves the result in res.
	 * <br>(x + v2.x, y + v2.y, z + v2.z)
	 * @param x The x value to add.
	 * @param y The y value to add.
	 * @param z The z value to add.
	 * @param v2 The float tuple to add.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f add(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		return add(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Adds x1 and y1 to x2 and y2 and saves the result in res.
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
	 * <br>(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z)
	 * @param v1 The first float tuple to subtract from.
	 * @param v2 The second float tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(ITup3R v1, ITup3R v2, Vec3f res)
	{
		return sub(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}
	
	/**
	 * Subtract from a tuple a scalar and saves the result in res.
	 * <br>(v1.x - scalar, v1.y - scalar, v1.z - scalar)
	 * @param v1 The double tuple to subtract from.
	 * @param scalar The scalar to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(ITup3R v1, double scalar, Vec3f res)
	{
		return sub(v1, scalar, scalar, scalar, res);
	}
	
	/**
	 * Subtracts from a tuple the values x and y and saves the result in res.
	 * <br>(v1.x - x, v1.y - y, v1.z - z)
	 * @param v1 The float tuple to subtract from.
	 * @param x The x value to subtract.
	 * @param y The y value to subtract.
	 * @param z The z value to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		return sub(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Subtracts from a scalar the values of tuple and saves the result in res.
	 * <br>(scalar - v2.x, scalar - v2.y, scalar - v2.z)
	 * @param scalar The scalar to subtract from.
	 * @param v2 The float tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(double scalar, ITup3R v2, Vec3f res)
	{
		return sub(scalar, scalar, scalar, v2, res);
	}
	
	/**
	 * Subtracts from x and y the values of a tuple and saves the result in res.
	 * <br>(x - v2.x, y - v2.y, z - v2.z)
	 * @param x The x value to subtract from.
	 * @param y The y value to subtract from.
	 * @param z The z value to subtract from.
	 * @param v2 The float tuple to subtract.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f sub(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		return sub(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Subtracts from x1 and y1 the values x2 and y2 and saves the result in res.
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
	 * @param v1 The first float tuple to multiply.
	 * @param v2 The second float tuple to mluitply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(ITup3R v1, ITup3R v2, Vec3f res)
	{
		return mul(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}

	/**
	 * Multiplies a tuple with a scalar and saves the result in res.
	 * <br>(v1.x * scalar, v1.y * scalar, v1.z * scalar)
	 * @param v1 The float tuple to multiply.
	 * @param scalar The scalar to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(ITup3R v1, double scalar, Vec3f res)
	{
		return mul(v1, scalar, scalar, scalar, res);
	}

	/**
	 * Multiplies a tuple with x and y and saves the result in res.
	 * <br>(v1.x * x, v1.y * y, v1.z * z)
	 * @param v1 The float tuple to multiply.
	 * @param x The x value to multiply with.
	 * @param y The y value to multiply with.
	 * @param z The z value to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		return mul(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Multiplies a scalar with a tuple and saves the result in res.
	 * <br>(scalar * v2.x, scalar * v2.y, scalar * v2.z)
	 * @param scalar The scalar to mutliply.
	 * @param v2 The float tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(double scalar, ITup3R v2, Vec3f res)
	{
		return mul(scalar, scalar, scalar, v2, res);
	}

	/**
	 * Multiplies x and y with a tuple and saves the result in res.
	 * <br>(x * v2.x, y * v2.y, z * v2.z)
	 * @param x The x value to multiply.
	 * @param y The y value to mlutiply.
	 * @param z The z value to mlutiply.
	 * @param v2 The float tuple to multiply with.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f mul(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		return mul(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Multiplies x1 and y1 with x2 and y2 and saves the result in res.
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
	 * @param v1 The first float tuple to divide.
	 * @param v2 The second float tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(ITup3R v1, ITup3R v2, Vec3f res)
	{
		return div(v1.getUniX(), v1.getUniY(), v1.getUniZ(), v2, res);
	}
	
	/**
	 * Divides a tuple by a scalar and saves the result in res.
	 * <br>(v1.x / scalar, v1.y / scalar, v1.z / scalar)
	 * @param v1 The float tuple to divide.
	 * @param scalar The scalar to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(ITup3R v1, double scalar, Vec3f res)
	{
		return div(v1, scalar, scalar, scalar, res);
	}
	
	/**
	 * Divides a tuple by x and y and saves the result in res.
	 * <br>(v1.x / x, v1.y / y, v1.z / z)
	 * @param v1 The float tuple to divide.
	 * @param x The x value to divide by.
	 * @param y The y value to divide by.
	 * @param z The z value to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(ITup3R v1, double x, double y, double z, Vec3f res)
	{
		return div(v1.getUniX(), v1.getUniY(), v1.getUniZ(), x, y, z, res);
	}
	
	/**
	 * Divides a scalar bx a tuple and saves the result in res.
	 * <br>(scalar / v2.x, scalar / v2.y, scalar / v2.z)
	 * @param scalar The scalar to divide.
	 * @param v2 The float tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(double scalar, ITup3R v2, Vec3f res)
	{
		return div(scalar, scalar, scalar, v2, res);
	}

	/**
	 * Divides x and y by a tuple and saves the result in res.
	 * <br>(x / v2.x, y / v2.y)
	 * @param x The x value to divide.
	 * @param y The y value to divide.
	 * @param v2 The float tuple to divide by.
	 * @param res The resulting vector. can be null.
	 * @return The resulting vector from res or a new vector if res is null.
	 */
	public static Vec3f div(double x, double y, double z, ITup3R v2, Vec3f res)
	{
		return div(x, y, z, v2.getUniX(), v2.getUniY(), v2.getUniZ(), res);
	}
	
	/**
	 * Divides x1 and y1 by x2 and y2 and saves the result in res.
	 * <br>(x1 / x2, y1 / y2)
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

}
