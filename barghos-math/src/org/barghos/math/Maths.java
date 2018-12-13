package org.barghos.math;

/**
 * This class contains mathematical methods and precalculated constants.
 */
public class Maths
{
	/** The number PI with 11 digits after point. */
	public static final double PI = 3.14159265359d;
	
	/** This is the precalculated Half-PI (PI / 2). It's used in some trigonomic calculations. */
	public static final double HALF_PI = 1.570796326795d;
	
	/**
	 * This value is a precalculated scalar for conversation from degrees to radians.
	 * Just multiply it with an angle messured in degree and you get the angle in radians.
	 */
	public static final double DEG_TO_RAD = 0.017453292519944444d;
	/**
	 * This value is a precalculated scalar for conversation from radians to degrees.
	 * Just multiply it with an angle messured in radians and you get the angle in degrees.
	 */
	public static final double RAD_TO_DEG = 57.29577951307855d;
	
	/**
	 * This is a precalculated inversed square-root of the number 2 (1 / sqrt(2)).
	 * It's commonly used for precalculated diagonal normal vectors i.e. vec3(1,1,0).
	 */
	public static final double INV_SQRT2 = 0.7071067811865475d;

	/**
	 * This is a precalculated inversed square-root of the number 3 (1 / sqrt(3)).
	 * It's commonly used for precalculated diagonal normal vectors i.e. vec3(1,1,1).
	 */
	public static final double INV_SQRT3 = 0.5773502691896258d;
	
	/** A very small number used for determining if a floating point number is technically zero. */
	public static final double SMALL_NUMBER = 1.e-8f;
	
	/**
	 * A very small number used for determining if two floating point numbers
	 * are close enough together to count as equal.
	 */
	public static final double KINDA_SMALL_NUMBER = 1.e-4f;
	
	/**
	 * Checks if the value is zero with given tolerance.
	 * @param value the value to check for 0.
	 * @param tolerance The threshold around 0.
	 * @return is the value 0.
	 */
	public static boolean isZero(double value, double tolerance)
	{
		return Math.abs(value) <= tolerance;
	}
	
	/**
	 * Checks if the value is zero with tolerance of SMALL_NUMBER(1.e-8f).
	 * @param value the value to check for 0.
	 * @return is the value 0.
	 */
	public static boolean isZero(double value)
	{
		return isZero(value, Maths.SMALL_NUMBER);
	}
	
	public static boolean isExcatNaN(double value)
	{
		return Double.isNaN(value);
	}
	
	public static boolean isNaN(double value)
	{
		return !Double.isFinite(value);
	}
	
	public static boolean isExactZero(double value)
	{
		return value == 0.0;
	}
	
	public static double roundFromZero(double value)
	{
		return value > 0 ? Math.ceil(value) : value < 0 ? Math.floor(value) : 0;
	}
	
	public static double roundToZero(double value)
	{
		return value > 0 ? Math.floor(value) : value < 0 ? Math.ceil(value) : 0;
	}
	
	public static double roundToPosInf(double value)
	{
		return Math.ceil(value);
	}
	
	public static double roundToNegInf(double value)
	{
		return Math.floor(value);
	}
	
	public static byte clamp(byte value, byte min, byte max)
	{
		return value < min ? min : value > max ? max : value;
	}
	
	public static char clamp(char value, char min, char max)
	{
		return value < min ? min : value > max ? max : value;
	}
	
	public static long clamp(long value, long min, long max)
	{
		return value < min ? min : value > max ? max : value;
	}
	
	public static float clamp(float value, float min, float max)
	{
		return value < min ? min : value > max ? max : value;
	}
	
	public static int clamp(int value, int min, int max)
	{
		return value < min ? min : value > max ? max : value;
	}
	
	public static double clamp(double value, double min, double max)
	{
		return value < min ? min : value > max ? max : value;
	}

	public static byte clampMin(byte value, byte min)
	{
		return value < min ? min : value;
	}
	
	public static char clampMin(char value, char min)
	{
		return value < min ? min : value;
	}
	
	public static long clampMin(long value, long min)
	{
		return value < min ? min : value;
	}
	
	public static float clampMin(float value, float min)
	{
		return value < min ? min : value;
	}
	
	public static int clampMin(int value, int min)
	{
		return value < min ? min : value;
	}
	
	public static double clampMin(double value, double min)
	{
		return value < min ? min : value;
	}

	public static byte clampMax(byte value, byte max)
	{
		return value > max ? max : value;
	}
	
	public static char clampMax(char value, char max)
	{
		return value > max ? max : value;
	}
	
	public static long clampMax(long value, long max)
	{
		return value > max ? max : value;
	}
	
	public static float clampMax(float value, float max)
	{
		return value > max ? max : value;
	}
	
	public static int clampMax(int value, int max)
	{
		return value > max ? max : value;
	}
	
	public static double clampMax(double value, double max)
	{
		return value > max ? max : value;
	}
	
	public static byte selectByZero(byte comparand, byte valueGEZ, byte valueLZ)
	{
		return comparand >= 0 ? valueGEZ : valueLZ;
	}
	
	public static char selectByZero(char comparand, char valueGEZ, char valueLZ)
	{
		return comparand >= 0 ? valueGEZ : valueLZ;
	}
	
	public static long selectByZero(long comparand, long valueGEZ, long valueLZ)
	{
		return comparand >= 0 ? valueGEZ : valueLZ;
	}
	
	public static int selectByZero(int comparand, int valueGEZ, int valueLZ)
	{
		return comparand >= 0 ? valueGEZ : valueLZ;
	}
	
	public static float selectByZero(float comparand, float valueGEZ, float valueLZ)
	{
		return comparand >= 0.0f ? valueGEZ : valueLZ;
	}
	
	public static double selectByZero(double comparand, double valueGEZ, double valueLZ)
	{
		return comparand >= 0.0f ? valueGEZ : valueLZ;
	}
	
	public static boolean isMultipleOfTwo(int value)
	{
		return (value & value - 1) == 0;
	}
	
	public static double gridSnap(double value, double gridSize)
	{
		return Math.floor((value + 0.5 * gridSize) / gridSize) * gridSize;
	}
	
	
	public static float gridSnap(float value, float gridSize)
	{
		return (float) (Math.floor((value + 0.5f * gridSize) / gridSize) * gridSize);
	}
	
	public static double reciprocal(double value)
	{
		return 1.0 / value;
	}
	
	public static double reciprocalSafe(double value)
	{
		return isZero(value) ? 0.0 : 1.0 / value;
	}
	
	public static double reciprocalSafe(double value, double tolerance)
	{
		return isZero(value, tolerance) ? 0.0 : 1.0 / value;
	}
}