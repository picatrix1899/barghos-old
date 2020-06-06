/*
MIT License

Copyright (c) 2019 picatrix1899

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

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
