package org.barghos.core.color.api;

import org.barghos.core.OverrideCause;
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


	@Override
	default int getDimensions() { return ITup4fR.super.getDimensions(); }

	@Override
	@OverrideCause("Tup3fR and Tup4fR have both a default implementation of get(int index). Needed is the 4f-implmentation.")
	default float get(int index) { return ITup4fR.super.get(index); }

	@Override
	@OverrideCause("Tup3fR and Tup4fR have both a default implementation of isFinite(). Needed is the 4f-implementation.")
	default boolean isFinite() { return ITup4fR.super.isFinite(); }

	default double getUniX() { return ITup4fR.super.getUniX(); }

	default double getUniY() { return ITup4fR.super.getUniY(); }

	default double getUniZ() { return ITup4fR.super.getUniZ(); }

	default double getUni(int index) { return ITup4fR.super.getUni(index); }

	default boolean isZero(double tolerance) { return ITup4fR.super.isZero(tolerance); }
}
