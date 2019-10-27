package org.barghos.core.testcolor;

import org.barghos.core.tuple.tuple4.Tup4fR;

/**
 * This class is a readonly implementation of an HDRColor4.
 */
public abstract class PHDRColor4 implements HDRColor4R
{
	private PHDRColor4() { }
	
	/**
	 * This generate a readonly PHDRColor4 with the components set to t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PHDRColor4 with the given components.
	 */
	public static PHDRColor4 gen(Tup4fR t) { return gen(t.getX(), t.getY(), t.getZ(), t.getW()); }
	
	/**
	 * This generate a readonly PHDRColor4 with the components set to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PHDRColor4 with the given components.
	 */
	public static PHDRColor4 gen(double scalar) { return gen(scalar, scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PHDRColor4 with the components set to r, g, b and a.
	 * r, g, b and are interpreted as in unitspace (0.0 - 1.0) but can exceed these limits.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 * @param a The alpha component in unitspace.
	 * @return A new readonly PHDRColor4 with the given components.
	 */
	public static PHDRColor4 gen(double r, double g, double b, double a)
	{
		return new PHDRColor4()
		{

			public float getUnityR() { return (float)r; }
			public float getUnityG() { return (float)g; }
			public float getUnityB() { return (float)b; }
			public float getUnityA() { return (float)a; }

			public int getR() { return (int)Math.round(r * 255); }
			public int getG() { return (int)Math.round(g * 255); }
			public int getB() { return (int)Math.round(b * 255); }
			public int getA() { return (int)Math.round(a * 255); }
		};
	}
	
	/**
	 * This generate a readonly PHDRColor4 with the components set to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) but can exceed these limits.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PHDRColor4 with the given components.
	 */
	public static PHDRColor4 gen(int scalar) { return gen(scalar, scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PHDRColor4 with the components set to r, g, b and a.
	 * r, g, b and a are interpreted as in colorspace (0 - 255) but can exceed these limits.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * @param a The alpha component in colorspace.
	 * @return A new readonly PHDRColor4 with the given components.
	 */
	public static PHDRColor4 gen(int r, int g, int b, int a)
	{
		return new PHDRColor4()
		{

			public float getUnityR() { return r / 255.0f; }
			public float getUnityG() { return g / 255.0f; }
			public float getUnityB() { return b / 255.0f; }
			public float getUnityA() { return a / 255.0f; }
			
			public int getR() { return r; }
			public int getG() { return g; }
			public int getB() { return b; }
			public int getA() { return a; }
		};
	}
}
