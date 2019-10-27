package org.barghos.core.color;

import org.barghos.core.tuple.tuple4.Tup4fR;

/**
 * This interface grants access to all reading methods of an RGBA-Color.
 */
public interface Color4R extends Color3R, Tup4fR
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
}
