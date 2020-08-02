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

package org.barghos.core.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.List;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;

/**
 * Provides functions for creating and filling primitve nio buffers more easiely.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
abstract class BufferUtilsPrimitives
{
	/** 
	 * Contains the byte order used in creating buffers.
	 */
	public static ByteOrder BYTE_ORDER = ByteOrder.nativeOrder();
	
	/**
	 * Creates a Byte-Buffer with given size.
	 * 
	 * @param size The size of the buffer.
	 * 
	 * @return The new Byte-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer createByteBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size).order(BYTE_ORDER);
	}
	
	/**
	 * Creates a Short-Buffer with given size.
	 * 
	 * @param size The size of the buffer.
	 * 
	 * @return The new Short-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer createShortBuffer(int size)
	{
		return createByteBuffer(size << 1).asShortBuffer();
	}
	
	/**
	 * Creates a Int-Buffer with given size.
	 * 
	 * @param size The size of the buffer.
	 * 
	 * @return The new Int-Buffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer createIntBuffer(int size)
	{
		return createByteBuffer(size << 2).asIntBuffer();
	}
	
	/**
	 * Creates a Long-Buffer with given size.
	 * 
	 * @param size The size of the buffer.
	 * 
	 * @return The new Long-Buffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer createLongBuffer(int size)
	{
		return createByteBuffer(size << 3).asLongBuffer();
	}	
	
	/**
	 * Creates a Float-Buffer with given size.
	 * 
	 * @param size The size of the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer createFloatBuffer(int size)
	{
		return createByteBuffer(size << 2).asFloatBuffer();
	}		
	
	/**
	 * Creates a Double-Buffer with given size.
	 * 
	 * @param size The size of the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer createDoubleBuffer(int size)
	{
		return createByteBuffer(size << 3).asDoubleBuffer();
	}
	
		/**
	 * Creates a Byte-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Byte-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToByteBuffer(byte... v)
	{
		return createByteBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the ByteBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ByteBuffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToByteBuffer(ByteBuffer buffer, byte... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		return buffer.put(v);
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Byte-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToByteBuffer(List<Byte> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		ByteBuffer buffer = createByteBuffer(length);
		
		for(int i = 0; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
 	
	/**
	 * Copies the given elements to the ByteBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ByteBuffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToByteBuffer(ByteBuffer buffer, List<Byte> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Short-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToShortBuffer(short... v)
	{
		return createShortBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the ShortBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ShortBuffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToShortBuffer(ShortBuffer buffer, short... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		return buffer.put(v);
	}
	
	/**
	 * Creates a Short-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Short-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToShortBuffer(List<Short> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		ShortBuffer buffer = createShortBuffer(length);

		for(int i = 0; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ShortBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ShortBuffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToShortBuffer(ShortBuffer buffer, List<Short> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Int-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Int-Buffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToIntBuffer(int... v)
	{
		return createIntBuffer(v.length).put(v);
	}	
	
	/**
	 * Copies the given elements to the IntBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The IntBuffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToIntBuffer(IntBuffer buffer, int... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		return buffer.put(v);
	}	
	
	/**
	 * Creates a Int-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Int-Buffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToIntBuffer(List<Integer> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		IntBuffer buffer = createIntBuffer(length);

		for(int i = 0; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
 	
	/**
	 * Copies the given elements to the IntBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The IntBuffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToIntBuffer(IntBuffer buffer, List<Integer> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Long-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Long-Buffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToLongBuffer(long... v)
	{
		return createLongBuffer(v.length).put(v);
	}	
	
	/**
	 * Copies the given elements to the LongBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The LongBuffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToLongBuffer(LongBuffer buffer, long... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		return buffer.put(v);
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Long-Buffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToLongBuffer(List<Long> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		LongBuffer buffer = createLongBuffer(length);

		for(int i = 0; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the LongBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The LongBuffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToLongBuffer(LongBuffer buffer, List<Long> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFloatBuffer(float... v)
	{
		return createFloatBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the FloatBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFloatBuffer(FloatBuffer buffer, float... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		return buffer.put(v);
	}
	
	/**
	 * Creates a Float-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFloatBuffer(List<Float> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		FloatBuffer buffer = createFloatBuffer(length);

		for(int i = 0; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the FloatBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFloatBuffer(FloatBuffer buffer, List<Float> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToDoubleBuffer(double... v)
	{
		return createDoubleBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToDoubleBuffer(DoubleBuffer buffer, double... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		return buffer.put(v);
	}
	
	/**
	 * Creates a Double-Buffer from the given elements.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToDoubleBuffer(List<Double> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		DoubleBuffer buffer = createDoubleBuffer(length);

		for(int i = 0; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToDoubleBuffer(DoubleBuffer buffer, List<Double> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
		/**
	 * Creates a Byte-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Byte-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToFlippedByteBuffer(byte... v)
	{
		ByteBuffer buffer = copyToByteBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ByteBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ByteBuffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToFlippedByteBuffer(ByteBuffer buffer, byte... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		copyToByteBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Byte-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToFlippedByteBuffer(List<Byte> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		ByteBuffer buffer = copyToByteBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ByteBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ByteBuffer.
	 * 
	 * @since 1.0
	 */
	public static ByteBuffer copyToFlippedByteBuffer(ByteBuffer buffer, List<Byte> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToByteBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Short-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToFlippedShortBuffer(short... v)
	{
		ShortBuffer buffer = copyToShortBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ShortBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ShortBuffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToFlippedShortBuffer(ShortBuffer buffer, short... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		copyToShortBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Short-Buffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToFlippedShortBuffer(List<Short> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		ShortBuffer buffer = copyToShortBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ShortBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The ShortBuffer.
	 * 
	 * @since 1.0
	 */
	public static ShortBuffer copyToFlippedShortBuffer(ShortBuffer buffer, List<Short> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToShortBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Int-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Int-Buffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToFlippedIntBuffer(int... v)
	{
		IntBuffer buffer = copyToIntBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the IntBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The IntBuffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToFlippedIntBuffer(IntBuffer buffer, int... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		copyToIntBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Int-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Int-Buffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToFlippedIntBuffer(List<Integer> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		IntBuffer buffer = copyToIntBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the IntBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The IntBuffer.
	 * 
	 * @since 1.0
	 */
	public static IntBuffer copyToFlippedIntBuffer(IntBuffer buffer, List<Integer> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToIntBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Long-Buffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToFlippedLongBuffer(long... v)
	{
		LongBuffer buffer = copyToLongBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the LongBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The LongBuffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToFlippedLongBuffer(LongBuffer buffer, long... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		copyToLongBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Long-Buffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToFlippedLongBuffer(List<Long> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		LongBuffer buffer = copyToLongBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the LongBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The LongBuffer.
	 * 
	 * @since 1.0
	 */
	public static LongBuffer copyToFlippedLongBuffer(LongBuffer buffer, List<Long> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToLongBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Float-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(float... v)
	{
		FloatBuffer buffer = copyToFloatBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the FloatBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(FloatBuffer buffer, float... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		copyToFloatBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(List<Float> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		FloatBuffer buffer = copyToFloatBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the FloatBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(FloatBuffer buffer, List<Float> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToFloatBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(double... v)
	{
		DoubleBuffer buffer = copyToDoubleBuffer(v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(DoubleBuffer buffer, double... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
		}
		
		copyToDoubleBuffer(buffer, v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(List<Double> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		DoubleBuffer buffer = copyToDoubleBuffer(v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer and flips it so it can be read.
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(DoubleBuffer buffer, List<Double> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToDoubleBuffer(buffer, v);
		buffer.flip();

		return buffer;
	}
}
