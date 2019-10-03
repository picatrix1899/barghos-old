package org.barghos.core.color.api;

import org.barghos.core.tuple.tuple4.api.ITup4fR;

/**
 * This interface grants access to all reading methods of an RGBA-Color.
 */
public interface IColor4R extends IColor3R, ITup4fR
{
	/**
	 * Returns the alpha component in unitspace (0 - 1).
	 * @return The alpha component.
	 */
	float getUnityA();
	
	/**
	 * Returns the alpha component in colorrange (0 - 255).
	 * @return The alpha component.
	 */
	int getA();
	
	/**
	 * Returns the component at the index (0 - 3) in unitspace (0 - 1).
	 * @return The component at the index.
	 */
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			case 3: return getW();
			default: throw new IllegalStateException();
		}
	}
	
	/**
	 * Returns the red component in unitspace (0 - 1).
	 * @return The red component.
	 */
	default float getX() { return getUnityR(); }
	
	/**
	 * Returns the green component in unitspace (0 - 1).
	 * @return The green component.
	 */
	default float getY() { return getUnityG(); }
	
	/**
	 * Returns the blue component in unitspace (0 - 1).
	 * @return The blue component.
	 */
	default float getZ() { return getUnityB(); }
	
	/**
	 * Returns the alpha component in unitspace (0 - 1).
	 * @return The alpha component.
	 */
	default float getW() { return getUnityA(); }

	/**
	 * Returns the component at the index (0 - 3) in unitspace (0 - 1).
	 * @return The component at the index.
	 */
	default double getUni(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
			case 3: return getW();
			default: throw new IllegalStateException();
		}
	}
	
	/**
	 * Returns the red component in unitspace (0 - 1).
	 * @return The red component.
	 */
	default double getUniX() { return getX(); }
	
	/**
	 * Returns the green component in unitspace (0 - 1).
	 * @return The green component.
	 */
	default double getUniY() { return getY(); }
	
	/**
	 * Returns the blue component in unitspace (0 - 1).
	 * @return The blue component.
	 */
	default double getUniZ() { return getZ(); }
	
	/**
	 * Returns the alpha component in unitspace (0 - 1).
	 * @return The alpha component.
	 */
	default double getUniW() { return getW(); }

	default int getDimensions()
	{
		return ITup4fR.super.getDimensions();
	}
}