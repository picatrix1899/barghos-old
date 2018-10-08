package org.barghos.core.color;

import org.barghos.core.api.color.ILDRColor3R;
import org.barghos.core.api.tuple.ITup3fR;

/**
 * This class is a readonly implementation of an LDRColor3.
 */
public abstract class PLDRColor3 implements ILDRColor3R
{
	private PLDRColor3() { }
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to t.
	 * The values of t are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param t A tuple that the components are set to.
	 * @return A new readonly PLDRColor3 with the given components.
	 */
	public static PLDRColor3 gen(ITup3fR t) { return gen(t.getX(), t.getY(), t.getZ()); }
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to scalar.
	 * The scalar is interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PLDRColor3 with the given components.
	 */
	public static PLDRColor3 gen(float scalar) { return gen(scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to r, g and b.
	 * r, g and b are interpreted as in unitspace (0.0 - 1.0) and are clamped to these limit.
	 * @param r The red component in unitspace.
	 * @param g The green component in unitspace.
	 * @param b The blue component in unitspace.
	 * @return A new readonly PLDRColor3 with the given components.
	 */
	public static PLDRColor3 gen(float r, float g, float b)
	{
		return new PLDRColor3()
		{

			public float getUnityR() { return clampF(r); }
			public float getUnityG() { return clampF(g); }
			public float getUnityB() { return clampF(b); }

			public int getR() { return clampI(Math.round(r * 255)); }
			public int getG() { return clampI(Math.round(g * 255)); }
			public int getB() { return clampI(Math.round(b * 255)); }
			
			public int getDimensions() { return 3; }
			
			private float clampF(float value)
			{
				return value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value;
			}
			
			private int clampI(int value)
			{
				return value > 255 ? 255 : value < 0 ? 0 : value;
			}
			
		};
	}
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to scalar.
	 * The scalar is interpreted as in colorrange (0 - 255) and are clamped to these limit.
	 * @param scalar A value that the components are set to.
	 * @return A new readonly PLDRColor3 with the given components.
	 */
	public static PLDRColor3 gen(int scalar) { return gen(scalar, scalar, scalar); }
	
	/**
	 * This generate a readonly PLDRColor3 with the components set to r, g and b.
	 * r, g and b are interpreted as in colorspace (0 - 255) and are clamped to these limit.
	 * @param r The red component in colorspace.
	 * @param g The green component in colorspace.
	 * @param b The blue component in colorspace.
	 * @return A new readonly PLDRColor3 with the given components.
	 */
	public static PLDRColor3 gen(int r, int g, int b)
	{
		return new PLDRColor3()
		{

			public float getUnityR() { return clampF(r / 255.0f); }
			public float getUnityG() { return clampF(g / 255.0f); }
			public float getUnityB() { return clampF(b / 255.0f); }

			public int getR() { return clampI(r); }
			public int getG() { return clampI(g); }
			public int getB() { return clampI(b); }
			
			public int getDimensions() { return 3; }
			
			private float clampF(float value)
			{
				return value > 1.0f ? 1.0f : value < 0.0f ? 0.0f : value;
			}
			
			private int clampI(int value)
			{
				return value > 255 ? 255 : value < 0 ? 0 : value;
			}
			
		};
	}
}
