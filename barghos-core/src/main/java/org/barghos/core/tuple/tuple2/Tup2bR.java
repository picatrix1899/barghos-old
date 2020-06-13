/*
MIT License

Copyright (c) 2019-2020 picatrix1899

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

package org.barghos.core.tuple.tuple2;

/**
 * This interface grants readonly access to any 2-dimensional byte tuples.
 * It should be prefered by design before direct usage of the original instance in method parameters.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 * 
 * @see Tup2b
 * @see Tup2bW
 * @see PTup2b
 * @see Tup2bHelper
 * @see Tup2bPool
 */
public interface Tup2bR
{
	/**
	 * Returns the x value from the tuple.
	 * @return The x value from the tuple.
	 */
	byte getX();
	
	/**
	 * Returns the y value from the tuple.
	 * @return The y value from the tuple.
	 */
	byte getY();
}
