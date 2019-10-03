package org.barghos.core.color.api;

import org.barghos.core.tuple.tuple3.api.ITup3fR;

/**
 * This interface grants access to all reading methods of an RGB-Color.
 */
public interface IColor3R extends ITup3fR
{
	/**
	 * Returns the red component in unitspace (0 - 1).
	 * @return The red component.
	 */
	float getUnityR();
	
	/**
	 * Returns the green component in unitspace (0 - 1).
	 * @return The green component.
	 */
	float getUnityG();
	
	/**
	 * Returns the blue component in unitspace (0 - 1).
	 * @return The blue component.
	 */
	float getUnityB();

	/**
	 * Returns the red component in colorrange (0 - 255).
	 * @return The red component.
	 */
	int getR();
	
	/**
	 * Returns the green component in colorrange (0 - 255).
	 * @return The green component.
	 */
	int getG();
	
	/**
	 * Returns the blue component in colorrange (0 - 255).
	 * @return The blue component.
	 */
	int getB();
	
	/**
	 * Returns the component at the index (0 - 2) in unitspace (0 - 1).
	 * @return The component at the index.
	 */
	default float get(int index)
	{
		switch(index)
		{
			case 0: return getX();
			case 1: return getY();
			case 2: return getZ();
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
}