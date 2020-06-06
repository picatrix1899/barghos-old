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

import org.barghos.core.tuple.tuple2.Tup2dR;
import org.barghos.core.tuple.tuple2.Tup2fR;
import org.barghos.core.tuple.tuple3.Tup3dR;
import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.core.tuple.tuple4.Tup4dR;
import org.barghos.core.tuple.tuple4.Tup4fR;


/**
 * This class contains methods for creating different buffers more easiely.
 */
public class BufferUtils
{
	public static ByteOrder BYTE_ORDER = ByteOrder.nativeOrder();
	
	private BufferUtils() { }
	
	/**
	 * Creates a Byte-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer createByteBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size).order(BYTE_ORDER);
	}
	
	/**
	 * Creates a Short-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer createShortBuffer(int size)
	{
		return createByteBuffer(size << 1).asShortBuffer();
	}
	
	/**
	 * Creates a Int-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer createIntBuffer(int size)
	{
		return createByteBuffer(size << 2).asIntBuffer();
	}
	
	/**
	 * Creates a Long-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer createLongBuffer(int size)
	{
		return createByteBuffer(size << 3).asLongBuffer();
	}	
	
	/**
	 * Creates a Float-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer createFloatBuffer(int size)
	{
		return createByteBuffer(size << 2).asFloatBuffer();
	}		
	
	/**
	 * Creates a Double-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer createDoubleBuffer(int size)
	{
		return createByteBuffer(size << 3).asDoubleBuffer();
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer copyToByteBuffer(byte... v)
	{
		return createByteBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the ByteBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ByteBuffer.
	 */
	public static ByteBuffer copyToByteBuffer(ByteBuffer buffer, byte... v)
	{
		return buffer.put(v);
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer copyToByteBuffer(List<Byte> v)
	{
		int length = v.size();
		
		ByteBuffer buffer = createByteBuffer(length);
		
		int i = 0;
		for(; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
 	
	/**
	 * Copies the given elements to the ByteBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ByteBuffer.
	 */
	public static ByteBuffer copyToByteBuffer(ByteBuffer buffer, List<Byte> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer copyToShortBuffer(short... v)
	{
		return createShortBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the ShortBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ShortBuffer.
	 */
	public static ShortBuffer copyToShortBuffer(ShortBuffer buffer, short... v)
	{
		return buffer.put(v);
	}
	
	/**
	 * Creates a Short-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer copyToShortBuffer(List<Short> v)
	{
		int length = v.size();
		
		ShortBuffer buffer = createShortBuffer(length);
		
		int i = 0;
		for(; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ShortBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ShortBuffer.
	 */
	public static ShortBuffer copyToShortBuffer(ShortBuffer buffer, List<Short> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Int-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer copyToIntBuffer(int... v)
	{
		return createIntBuffer(v.length).put(v);
	}	
	
	/**
	 * Copies the given elements to the IntBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The IntBuffer.
	 */
	public static IntBuffer copyToIntBuffer(IntBuffer buffer, int... v)
	{
		return buffer.put(v);
	}	
	
	/**
	 * Creates a Int-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer copyToIntBuffer(List<Integer> v)
	{
		int length = v.size();
		
		IntBuffer buffer = createIntBuffer(length);
		
		int i = 0;
		for(; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
 	
	/**
	 * Copies the given elements to the IntBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The IntBuffer.
	 */
	public static IntBuffer copyToIntBuffer(IntBuffer buffer, List<Integer> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Long-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer copyToLongBuffer(long... v)
	{
		return createLongBuffer(v.length).put(v);
	}	
	
	/**
	 * Copies the given elements to the LongBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The LongBuffer.
	 */
	public static LongBuffer copyToLongBuffer(LongBuffer buffer, long... v)
	{
		return buffer.put(v);
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer copyToLongBuffer(List<Long> v)
	{
		int length = v.size();
		
		LongBuffer buffer = createLongBuffer(length);
		
		int i = 0;
		for(; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the LongBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The LongBuffer.
	 */
	public static LongBuffer copyToLongBuffer(LongBuffer buffer, List<Long> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFloatBuffer(float... v)
	{
		return createFloatBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the FloatBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFloatBuffer(FloatBuffer buffer, float... v)
	{
		return buffer.put(v);
	}
	
	/**
	 * Creates a Float-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFloatBuffer(List<Float> v)
	{
		int length = v.size();
		
		FloatBuffer buffer = createFloatBuffer(length);
		
		int i = 0;
		for(; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the FloatBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFloatBuffer(FloatBuffer buffer, List<Float> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToDoubleBuffer(double... v)
	{
		return createDoubleBuffer(v.length).put(v);
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToDoubleBuffer(DoubleBuffer buffer, double... v)
	{
		return buffer.put(v);
	}
	
	/**
	 * Creates a Double-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToDoubleBuffer(List<Double> v)
	{
		int length = v.size();
		
		DoubleBuffer buffer = createDoubleBuffer(length);
		
		int i = 0;
		for(; i < length; i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer.
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToDoubleBuffer(DoubleBuffer buffer, List<Double> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToTuple2FBuffer(Tup2fR... v)
	{
		int length = v.length;

		FloatBuffer buffer = createFloatBuffer(length * 2);

		int i = 0;
		for(; i < length; i++)
		{
			Tup2fR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
		}
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToTuple2FBuffer(FloatBuffer buffer, Tup2fR... v)
	{
		int i = 0;
		for(; i < v.length; i++)
		{
			Tup2fR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
		}
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToTuple2FBuffer(List<Tup2fR> v)
	{
		int length = v.size();

		FloatBuffer buffer = createFloatBuffer(length * 2);

		int i = 0;
		for(; i < length; i++)
		{
			Tup2fR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
		}
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToTuple2FBuffer(FloatBuffer buffer, List<Tup2fR> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
		{
			Tup2fR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
		}
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToTuple2DBuffer(Tup2dR... v)
	{
		int length = v.length;

		DoubleBuffer buffer = createDoubleBuffer(length * 2);

		int i = 0;
		for(; i < length; i++)
		{
			Tup2dR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToTuple2DBuffer(DoubleBuffer buffer, Tup2dR... v)
	{
		int i = 0;
		for(; i < v.length; i++)
		{
			Tup2dR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
		}

		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToTuple2DBuffer(List<Tup2dR> v)
	{
		int length = v.size();

		DoubleBuffer buffer = createDoubleBuffer(length * 2);

		int i = 0;
		for(; i < length; i++)
		{
			Tup2dR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToTuple2DBuffer(DoubleBuffer buffer, List<Tup2dR> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
		{
			Tup2dR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
		}

		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToTuple3FBuffer(Tup3fR... v)
	{
		int length = v.length;
		
		FloatBuffer buffer = createFloatBuffer(length * 3);

		int i = 0;
		for(; i < length; i++)
		{
			Tup3fR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToTuple3FBuffer(FloatBuffer buffer, Tup3fR... v)
	{
		int i = 0;
		for(; i < v.length; i++)
		{
			Tup3fR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToTuple3FBuffer(List<Tup3fR> v)
	{
		int length = v.size();
		
		FloatBuffer buffer = createFloatBuffer(length * 3);

		int i = 0;
		for(; i < length; i++)
		{
			Tup3fR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToTuple3FBuffer(FloatBuffer buffer, List<Tup3fR> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
		{
			Tup3fR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToTuple3DBuffer(Tup3dR... v)
	{
		int length = v.length;
		
		DoubleBuffer buffer = createDoubleBuffer(length * 3);

		int i = 0;
		for(; i < length; i++)
		{
			Tup3dR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToTuple3DBuffer(DoubleBuffer buffer, Tup3dR... v)
	{
		int i = 0;
		for(; i < v.length; i++)
		{
			Tup3dR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToTuple3DBuffer(List<Tup3dR> v)
	{
		int length = v.size();
		
		DoubleBuffer buffer = createDoubleBuffer(length * 3);

		int i = 0;
		for(; i < length; i++)
		{
			Tup3dR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToTuple3DBuffer(DoubleBuffer buffer, List<Tup3dR> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
		{
			Tup3dR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
		}

		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToTuple4FBuffer(Tup4fR... v)
	{
		int length = v.length;
		
		FloatBuffer buffer = createFloatBuffer(length * 4);

		int i = 0;
		for(; i < length; i++)
		{
			Tup4fR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToTuple4FBuffer(FloatBuffer buffer, Tup4fR... v)
	{
		int i = 0;
		for(; i < v.length; i++)
		{
			Tup4fR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}

		return buffer;
	}
	
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToTuple4FBuffer(List<Tup4fR> v)
	{
		int length = v.size();
		
		FloatBuffer buffer = createFloatBuffer(length * 4);

		int i = 0;
		for(; i < length; i++)
		{
			Tup4fR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}

		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToTuple4FBuffer(FloatBuffer buffer, List<Tup4fR> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
		{
			Tup4fR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}

		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToTuple4DBuffer(Tup4dR... v)
	{
		int length = v.length;

		DoubleBuffer buffer = createDoubleBuffer(length * 4);
		
		int i = 0;
		for(; i < length; i++)
		{
			Tup4dR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}
		
		return buffer;
	}

	/**
	 * Copies the given tuples to the DoubleBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToTuple4DBuffer(DoubleBuffer buffer, Tup4dR... v)
	{
		int i = 0;
		for(; i < v.length; i++)
		{
			Tup4dR current = v[i];
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToTuple4DBuffer(List<Tup4dR> v)
	{
		int length = v.size();

		DoubleBuffer buffer = createDoubleBuffer(length * 4);
		
		int i = 0;
		for(; i < length; i++)
		{
			Tup4dR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToTuple4DBuffer(DoubleBuffer buffer, List<Tup4dR> v)
	{
		int i = 0;
		for(; i < v.size(); i++)
		{
			Tup4dR current = v.get(i);
			buffer.put(current.getX());
			buffer.put(current.getY());
			buffer.put(current.getZ());
			buffer.put(current.getW());
		}
		
		return buffer;
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer copyToFlippedByteBuffer(byte... v)
	{
		ByteBuffer buffer = copyToByteBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ByteBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ByteBuffer.
	 */
	public static ByteBuffer copyToFlippedByteBuffer(ByteBuffer buffer, byte... v)
	{
		copyToByteBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer copyToFlippedByteBuffer(List<Byte> v)
	{
		ByteBuffer buffer = copyToByteBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ByteBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ByteBuffer.
	 */
	public static ByteBuffer copyToFlippedByteBuffer(ByteBuffer buffer, List<Byte> v)
	{
		copyToByteBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer copyToFlippedShortBuffer(short... v)
	{
		ShortBuffer buffer = copyToShortBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ShortBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ShortBuffer.
	 */
	public static ShortBuffer copyToFlippedShortBuffer(ShortBuffer buffer, short... v)
	{
		copyToShortBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer copyToFlippedShortBuffer(List<Short> v)
	{
		ShortBuffer buffer = copyToShortBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the ShortBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The ShortBuffer.
	 */
	public static ShortBuffer copyToFlippedShortBuffer(ShortBuffer buffer, List<Short> v)
	{
		copyToShortBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Int-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer copyToFlippedIntBuffer(int... v)
	{
		IntBuffer buffer = copyToIntBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the IntBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The IntBuffer.
	 */
	public static IntBuffer copyToFlippedIntBuffer(IntBuffer buffer, int... v)
	{
		copyToIntBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Int-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer copyToFlippedIntBuffer(List<Integer> v)
	{
		IntBuffer buffer = copyToIntBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the IntBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The IntBuffer.
	 */
	public static IntBuffer copyToFlippedIntBuffer(IntBuffer buffer, List<Integer> v)
	{
		copyToIntBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer copyToFlippedLongBuffer(long... v)
	{
		LongBuffer buffer = copyToLongBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the LongBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The LongBuffer.
	 */
	public static LongBuffer copyToFlippedLongBuffer(LongBuffer buffer, long... v)
	{
		copyToLongBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer copyToFlippedLongBuffer(List<Long> v)
	{
		LongBuffer buffer = copyToLongBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Copies the given elements to the LongBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The LongBuffer.
	 */
	public static LongBuffer copyToFlippedLongBuffer(LongBuffer buffer, List<Long> v)
	{
		copyToLongBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Float-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(float... v)
	{
		FloatBuffer buffer = copyToFloatBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the FloatBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(FloatBuffer buffer, float... v)
	{
		copyToFloatBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(List<Float> v)
	{
		FloatBuffer buffer = copyToFloatBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given elements to the FloatBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedFloatBuffer(FloatBuffer buffer, List<Float> v)
	{
		copyToFloatBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(double... v)
	{
		DoubleBuffer buffer = copyToDoubleBuffer(v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(DoubleBuffer buffer, double... v)
	{
		copyToDoubleBuffer(buffer, v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(List<Double> v)
	{
		DoubleBuffer buffer = copyToDoubleBuffer(v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Copies the given elements to the DoubleBuffer and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedDoubleBuffer(DoubleBuffer buffer, List<Double> v)
	{
		copyToDoubleBuffer(buffer, v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(Tup2fR... v)
	{
		FloatBuffer buffer = copyToTuple2FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(FloatBuffer buffer, Tup2fR... v)
	{
		copyToTuple2FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(List<Tup2fR> v)
	{
		FloatBuffer buffer = copyToTuple2FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(FloatBuffer buffer, List<Tup2fR> v)
	{
		copyToTuple2FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(Tup2dR... v)
	{
		DoubleBuffer buffer = copyToTuple2DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(DoubleBuffer buffer, Tup2dR... v)
	{
		copyToTuple2DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(List<Tup2dR> v)
	{
		DoubleBuffer buffer = copyToTuple2DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(DoubleBuffer buffer, List<Tup2dR> v)
	{
		copyToTuple2DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(Tup3fR... v)
	{
		FloatBuffer buffer = copyToTuple3FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(FloatBuffer buffer, Tup3fR... v)
	{
		copyToTuple3FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(List<Tup3fR> v)
	{
		FloatBuffer buffer = copyToTuple3FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(FloatBuffer buffer, List<Tup3fR> v)
	{
		copyToTuple3FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(Tup3dR... v)
	{
		DoubleBuffer buffer = copyToTuple3DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(DoubleBuffer buffer, Tup3dR... v)
	{
		copyToTuple3DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(List<Tup3dR> v)
	{
		DoubleBuffer buffer = copyToTuple3DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(DoubleBuffer buffer, List<Tup3dR> v)
	{
		copyToTuple3DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(Tup4fR... v)
	{
		FloatBuffer buffer = copyToTuple4FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(FloatBuffer buffer, Tup4fR... v)
	{
		copyToTuple4FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(List<Tup4fR> v)
	{
		FloatBuffer buffer = copyToTuple4FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The FloatBuffer.
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(FloatBuffer buffer, List<Tup4fR> v)
	{
		copyToTuple4FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(Tup4dR... v)
	{
		DoubleBuffer buffer = copyToTuple4DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(DoubleBuffer buffer, Tup4dR... v)
	{
		copyToTuple4DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(List<Tup4dR> v)
	{
		DoubleBuffer buffer = copyToTuple4DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The DoubleBuffer.
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(DoubleBuffer buffer, List<Tup4dR> v)
	{
		copyToTuple4DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
}
