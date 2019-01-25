
package org.barghos.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import org.barghos.core.api.tuple.ITup2dR;
import org.barghos.core.api.tuple.ITup2fR;
import org.barghos.core.api.tuple.ITup3dR;
import org.barghos.core.api.tuple.ITup3fR;
import org.barghos.core.api.tuple.ITup4dR;
import org.barghos.core.api.tuple.ITup4fR;


/**
 * This class contains methods for creating different buffers more easiely.
 */
public class BufferUtils
{
	
	/**
	 * Creates a Byte-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer createByteBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
	}
	
	/**
	 * Creates a Short-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer createShortBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 1).order(ByteOrder.nativeOrder()).asShortBuffer();
	}
	
	/**
	 * Creates a Int-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer createIntBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
	}
	
	/**
	 * Creates a Long-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer createLongBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 3).order(ByteOrder.nativeOrder()).asLongBuffer();
	}	
	
	/**
	 * Creates a Float-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer createFloatBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
	}		
	
	/**
	 * Creates a Double-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer createDoubleBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 3).order(ByteOrder.nativeOrder()).asDoubleBuffer();
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer wrapByteBuffer(byte... v)
	{
		assert(v.length != 0);
		ByteBuffer buffer = createByteBuffer(v.length);
		buffer.put(v);
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer wrapShortBuffer(short... v)
	{
		assert(v.length != 0);
		ShortBuffer buffer = createShortBuffer(v.length);
		buffer.put(v);
		
		return buffer;
	}
	
	/**
	 * Creates a Int-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer wrapIntBuffer(int... v)
	{
		assert(v.length != 0);
		IntBuffer buffer = createIntBuffer(v.length);
		buffer.put(v);
		
		return buffer;
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer wrapLongBuffer(long... v)
	{
		assert(v.length != 0);
		LongBuffer buffer = createLongBuffer(v.length);
		buffer.put(v);
		
		return buffer;
	}	
	
	/**
	 * Creates a Float-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapFloatBuffer(float... v)
	{
		assert(v.length != 0);
		FloatBuffer buffer = createFloatBuffer(v.length);
		buffer.put(v);
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public final static DoubleBuffer wrapDoubleBuffer(double... v)
	{
		assert(v.length != 0);
		DoubleBuffer buffer = createDoubleBuffer(v.length);
		buffer.put(v);
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapTuple2FBuffer(ITup2fR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		int dim = 2;
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		ITup2fR current;
		
		for(int i = 0; i < v.length; i++)
		{
			block = i * dim;
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
		}
		
		FloatBuffer buffer = createFloatBuffer(f.length);
		buffer.put(f);
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapTuple2DBuffer(ITup2dR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		int dim = 2;
		
		double[] d = new double[v.length * dim];
		
		int block = 0;
		
		ITup2dR current;
		
		for(int i = 0; i < v.length; i++)
		{
			block = i * dim;
			current = v[i];
			
			d[block] = current.getX();
			d[block + 1] = current.getY();
		}
		
		DoubleBuffer buffer = createDoubleBuffer(d.length);
		buffer.put(d);
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapTuple3FBuffer(ITup3fR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		int dim = 3;
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		ITup3fR current;
		
		for(int i = 0; i < v.length; i++)
		{
			block = i * dim;
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			f[block + 2] = current.getZ();
		}
		
		FloatBuffer buffer = createFloatBuffer(f.length);
		
		buffer.put(f);
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapTuple3DBuffer(ITup3dR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		int dim = 3;
		
		double[] d = new double[v.length * dim];
		
		int block = 0;
		
		ITup3dR current;
		
		for(int i = 0; i < v.length; i++)
		{
			block = i * dim;
			current = v[i];
			
			d[block] = current.getX();
			d[block + 1] = current.getY();
			d[block + 2] = current.getZ();
		}
		
		DoubleBuffer buffer = createDoubleBuffer(d.length);
		
		buffer.put(d);
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapTuple4FBuffer(ITup4fR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		int dim = 4;
		
		float[] f = new float[v.length * dim];
		
		int block = 0;
		
		ITup4fR current;
		
		for(int i = 0; i < v.length; i++)
		{
			block = i * dim;
			current = v[i];
			
			f[block] = current.getX();
			f[block + 1] = current.getY();
			f[block + 2] = current.getZ();
			f[block + 3] = current.getW();
		}
		
		FloatBuffer buffer = createFloatBuffer(f.length);
		
		buffer.put(f);
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapTuple4DBuffer(ITup4dR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		int dim = 4;
		
		double[] d = new double[v.length * dim];
		
		int block = 0;
		
		ITup4dR current;
		
		for(int i = 0; i < v.length; i++)
		{
			block = i * dim;
			current = v[i];
			
			d[block] = current.getX();
			d[block + 1] = current.getY();
			d[block + 2] = current.getZ();
			d[block + 3] = current.getW();
		}
		
		DoubleBuffer buffer = createDoubleBuffer(d.length);
		
		buffer.put(d);
		
		return buffer;
	}

	/**
	 * Creates a Byte-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer wrapFlippedByteBuffer(byte... v)
	{
		assert(v.length != 0);
		ByteBuffer buffer = wrapByteBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Short-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer wrapFlippedShortBuffer(short... v)
	{
		assert(v.length != 0);
		ShortBuffer buffer = wrapShortBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Int-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer wrapFlippedIntBuffer(int... v)
	{
		assert(v.length != 0);
		IntBuffer buffer = wrapIntBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer wrapFlippedLongBuffer(long... v)
	{
		assert(v.length != 0);
		LongBuffer buffer = wrapLongBuffer(v);
		buffer.flip();
		
		return buffer;
	}	
	
	/**
	 * Creates a Float-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapFlippedFloatBuffer(float... v)
	{
		assert(v.length != 0);
		FloatBuffer buffer = wrapFloatBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapFlippedDoubleBuffer(double... v)
	{
		assert(v.length != 0);
		DoubleBuffer buffer = wrapDoubleBuffer(v);
		buffer.flip();

		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapFlippedTuple2FBuffer(ITup2fR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		FloatBuffer buffer = wrapTuple2FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapFlippedTuple2DBuffer(ITup2dR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		DoubleBuffer buffer = wrapTuple2DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapFlippedTuple3FBuffer(ITup3fR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		FloatBuffer buffer = wrapTuple3FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapFlippedTuple3DBuffer(ITup3dR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		DoubleBuffer buffer = wrapTuple3DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapFlippedTuple4FBuffer(ITup4fR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		FloatBuffer buffer = wrapTuple4FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapFlippedTuple4DBuffer(ITup4dR... v)
	{
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		DoubleBuffer buffer = wrapTuple4DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
}
