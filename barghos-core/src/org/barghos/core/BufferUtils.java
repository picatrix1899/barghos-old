
package org.barghos.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.List;

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
	private static ByteOrder order = ByteOrder.nativeOrder();
	
	private BufferUtils() { }
	
	/**
	 * Creates a Byte-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer createByteBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size).order(order);
	}
	
	/**
	 * Creates a Short-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer createShortBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 1).order(order).asShortBuffer();
	}
	
	/**
	 * Creates a Int-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer createIntBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 2).order(order).asIntBuffer();
	}
	
	/**
	 * Creates a Long-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer createLongBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 3).order(order).asLongBuffer();
	}	
	
	/**
	 * Creates a Float-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer createFloatBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 2).order(order).asFloatBuffer();
	}		
	
	/**
	 * Creates a Double-Buffer with given size.
	 * @param size The size of the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer createDoubleBuffer(int size)
	{
		return ByteBuffer.allocateDirect(size << 3).order(order).asDoubleBuffer();
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer wrapByteBuffer(byte... v)
	{
		assert(v != null);
		assert(v.length != 0);

		return ByteBuffer.allocateDirect(v.length).order(order).put(v);
	}
	
	/**
	 * Creates a Byte-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer wrapByteBuffer(List<Byte> v)
	{
		assert(v != null);
		assert(!v.isEmpty());
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(v.size()).order(order);
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
 	
	/**
	 * Creates a Short-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer wrapShortBuffer(short... v)
	{
		assert(v != null);
		assert(v.length != 0);

		return ByteBuffer.allocateDirect(v.length << 1).order(order).asShortBuffer().put(v);
	}
	
	/**
	 * Creates a Short-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Short-Buffer.
	 */
	public static ShortBuffer wrapShortBuffer(List<Short> v)
	{
		assert(v != null);
		assert(!v.isEmpty());
		
		ShortBuffer buffer = ByteBuffer.allocateDirect(v.size() << 1).order(order).asShortBuffer();
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Int-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer wrapIntBuffer(int... v)
	{
		assert(v != null);
		assert(v.length != 0);

		return ByteBuffer.allocateDirect(v.length << 2).order(order).asIntBuffer().put(v);
	}	
	
	/**
	 * Creates a Int-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Int-Buffer.
	 */
	public static IntBuffer wrapIntBuffer(List<Integer> v)
	{
		assert(v != null);
		assert(!v.isEmpty());
		
		IntBuffer buffer = ByteBuffer.allocateDirect(v.size() << 2).order(order).asIntBuffer();
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
 	
	
	/**
	 * Creates a Long-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer wrapLongBuffer(long... v)
	{
		assert(v != null);
		assert(v.length != 0);

		return ByteBuffer.allocateDirect(v.length << 3).order(order).asLongBuffer().put(v);
	}	
	
	/**
	 * Creates a Long-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Long-Buffer.
	 */
	public static LongBuffer wrapLongBuffer(List<Long> v)
	{
		assert(v != null);
		assert(!v.isEmpty());
		
		LongBuffer buffer = ByteBuffer.allocateDirect(v.size() << 3).order(order).asLongBuffer();
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapFloatBuffer(float... v)
	{
		assert(v != null);
		assert(v.length != 0);
		
		return ByteBuffer.allocateDirect(v.length << 2).order(order).asFloatBuffer().put(v);
	}
	
	/**
	 * Creates a Float-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapFloatBuffer(List<Float> v)
	{
		assert(v != null);
		assert(!v.isEmpty());
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(v.size() << 2).order(order).asFloatBuffer();
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapDoubleBuffer(double... v)
	{
		assert(v != null);
		assert(v.length != 0);

		return ByteBuffer.allocateDirect(v.length << 3).order(order).asDoubleBuffer().put(v);
	}
	
	/**
	 * Creates a Double-Buffer from the given elements.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapDoubleBuffer(List<Float> v)
	{
		assert(v != null);
		assert(!v.isEmpty());
		
		DoubleBuffer buffer = ByteBuffer.allocateDirect(v.size() << 3).order(order).asDoubleBuffer();
		for(int i = 0; i < v.size(); i++)
			buffer.put(v.get(i));
		
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
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		float[] f = new float[length * 2];

		ITup2fR current;
		for(int i = 0, b = 0; i < length; i++, b += 2)
		{
			current = v[i];
			f[b] = current.getX();
			f[b + 1] = current.getY();
		}
		
		return ByteBuffer.allocateDirect((length * 2) << 2).order(order).asFloatBuffer().put(f);
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapTuple2DBuffer(ITup2dR... v)
	{
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;

		double[] d = new double[length * 2];
		
		ITup2dR current;
		for(int i = 0, b = 0; i < length; i++, b += 2)
		{
			current = v[i];
			
			d[b] = current.getX();
			d[b + 1] = current.getY();
		}

		return ByteBuffer.allocateDirect((length * 2) << 3).order(order).asDoubleBuffer().put(d);
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapTuple3FBuffer(ITup3fR... v)
	{
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		float[] f = new float[length * 3];

		ITup3fR current;
		for(int i = 0, b = 0; i < length; i++, b += 3)
		{
			current = v[i];
			
			f[b] = current.getX();
			f[b + 1] = current.getY();
			f[b + 2] = current.getZ();
		}

		return ByteBuffer.allocateDirect((length * 3) << 2).order(order).asFloatBuffer().put(f);
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapTuple3DBuffer(ITup3dR... v)
	{
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		double[] d = new double[length * 3];

		ITup3dR current;
		for(int i = 0, b = 0; i < length; i++, b += 3)
		{
			current = v[i];
			
			d[b] = current.getX();
			d[b + 1] = current.getY();
			d[b + 2] = current.getZ();
		}

		return ByteBuffer.allocateDirect((length * 3) << 3).order(order).asDoubleBuffer().put(d);
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Float-Buffer.
	 */
	public static FloatBuffer wrapTuple4FBuffer(ITup4fR... v)
	{
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		float[] f = new float[length * 4];

		ITup4fR current;
		for(int i = 0, b = 0; i < length; i++, b += 4)
		{
			current = v[i];
			
			f[b] = current.getX();
			f[b + 1] = current.getY();
			f[b + 2] = current.getZ();
			f[b + 3] = current.getW();
		}

		return ByteBuffer.allocateDirect((length * 4) << 2).order(order).asFloatBuffer().put(f);
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Double-Buffer.
	 */
	public static DoubleBuffer wrapTuple4DBuffer(ITup4dR... v)
	{
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;

		double[] d = new double[v.length * 4];

		ITup4dR current;
		for(int i = 0, b = 0; i < v.length; i++, b += 4)
		{
			current = v[i];
			
			d[b] = current.getX();
			d[b + 1] = current.getY();
			d[b + 2] = current.getZ();
			d[b + 3] = current.getW();
		}
		
		return ByteBuffer.allocateDirect((length * 4) << 3).order(order).asDoubleBuffer().put(d);
	}

	/**
	 * Creates a Byte-Buffer from the given elements and flips it so it can be read.
	 * @param v The elements that should be saved in the buffer.
	 * @return The new Byte-Buffer.
	 */
	public static ByteBuffer wrapFlippedByteBuffer(byte... v)
	{
		assert(v != null);
		assert(v.length != 0);
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(v.length).order(order).put(v);
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
		assert(v != null);
		assert(v.length != 0);
		
		ShortBuffer buffer = ByteBuffer.allocateDirect(v.length << 1).order(order).asShortBuffer().put(v);
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
		assert(v != null);
		assert(v.length != 0);
		
		IntBuffer buffer = ByteBuffer.allocateDirect(v.length << 2).order(order).asIntBuffer().put(v);
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
		assert(v != null);
		assert(v.length != 0);
		
		LongBuffer buffer = ByteBuffer.allocateDirect(v.length << 3).order(order).asLongBuffer().put(v);
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
		assert(v != null);
		assert(v.length != 0);
		
		FloatBuffer buffer = ByteBuffer.allocateDirect(v.length << 2).order(order).asFloatBuffer().put(v);
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
		assert(v != null);
		assert(v.length != 0);
		
		DoubleBuffer buffer = ByteBuffer.allocateDirect(v.length << 3).order(order).asDoubleBuffer().put(v);
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
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		float[] f = new float[length * 2];

		ITup2fR current;
		for(int i = 0, b = 0; i < length; i++, b += 2)
		{
			current = v[i];
			f[b] = current.getX();
			f[b + 1] = current.getY();
		}

		FloatBuffer buffer = ByteBuffer.allocateDirect((length * 2) << 2).order(order).asFloatBuffer().put(f);
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
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;

		double[] d = new double[length * 2];
		
		ITup2dR current;
		for(int i = 0, b = 0; i < length; i++, b += 2)
		{
			current = v[i];
			
			d[b] = current.getX();
			d[b + 1] = current.getY();
		}

		DoubleBuffer buffer = ByteBuffer.allocateDirect((length * 2) << 3).order(order).asDoubleBuffer().put(d);
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
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		float[] f = new float[length * 3];

		ITup3fR current;
		for(int i = 0, b = 0; i < length; i++, b += 3)
		{
			current = v[i];
			
			f[b] = current.getX();
			f[b + 1] = current.getY();
			f[b + 2] = current.getZ();
		}

		FloatBuffer buffer = ByteBuffer.allocateDirect((length * 3) << 2).order(order).asFloatBuffer().put(f);
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
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		double[] d = new double[length * 3];

		ITup3dR current;
		for(int i = 0, b = 0; i < length; i++, b += 3)
		{
			current = v[i];
			
			d[b] = current.getX();
			d[b + 1] = current.getY();
			d[b + 2] = current.getZ();
		}

		DoubleBuffer buffer = ByteBuffer.allocateDirect((length * 3) << 3).order(order).asDoubleBuffer().put(d);
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
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;
		
		float[] f = new float[length * 4];

		ITup4fR current;
		for(int i = 0, b = 0; i < length; i++, b += 4)
		{
			current = v[i];
			
			f[b] = current.getX();
			f[b + 1] = current.getY();
			f[b + 2] = current.getZ();
			f[b + 3] = current.getW();
		}

		FloatBuffer buffer = ByteBuffer.allocateDirect((length * 4) << 2).order(order).asFloatBuffer().put(f);
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
		assert(v != null);
		assert(v.length != 0);
		assert(Check.notNull(v));
		
		int length = v.length;

		double[] d = new double[v.length * 4];

		ITup4dR current;
		for(int i = 0, b = 0; i < v.length; i++, b += 4)
		{
			current = v[i];
			
			d[b] = current.getX();
			d[b + 1] = current.getY();
			d[b + 2] = current.getZ();
			d[b + 3] = current.getW();
		}

		DoubleBuffer buffer = ByteBuffer.allocateDirect((length * 4) << 3).order(order).asDoubleBuffer().put(d);
		buffer.flip();
		
		return buffer;
	}
	
}
