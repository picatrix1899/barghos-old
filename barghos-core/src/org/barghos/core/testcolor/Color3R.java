package org.barghos.core.testcolor;

import org.barghos.core.tuple.tuple3.Tup3fR;

/**
 * This interface grants access to all reading methods of an RGB-Color.
 */
public interface Color3R extends Tup3fR
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
}
