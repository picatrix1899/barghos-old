package org.barghos.core;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
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
import org.barghos.core.tuple.Tup2d;
import org.barghos.core.tuple.Tup2f;
import org.barghos.core.tuple.Tup3d;
import org.barghos.core.tuple.Tup3f;
import org.barghos.core.tuple.Tup4d;
import org.barghos.core.tuple.Tup4f;

import org.junit.jupiter.api.Test;


class BufferUtilsTest
{

	@Test
	void testCreateByteBuffer()
	{
		ByteBuffer buffer = BufferUtils.createByteBuffer(13);
		
		assertEquals(13, buffer.capacity());
	}

	@Test
	void testCreateShortBuffer()
	{
		ShortBuffer buffer = BufferUtils.createShortBuffer(13);
		
		assertEquals(13, buffer.capacity());
	}

	@Test
	void testCreateIntBuffer()
	{
		IntBuffer buffer = BufferUtils.createIntBuffer(13);
		
		assertEquals(13, buffer.capacity());
	}

	@Test
	void testCreateLongBuffer()
	{
		LongBuffer buffer = BufferUtils.createLongBuffer(13);
		
		assertEquals(13, buffer.capacity());
	}

	@Test
	void testCreateFloatBuffer()
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(13);
		
		assertEquals(13, buffer.capacity());
	}

	@Test
	void testCreateDoubleBuffer()
	{
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(13);
		
		assertEquals(13, buffer.capacity());
	}

	@Test
	void testWrapByteBuffer()
	{
		ByteBuffer buffer = BufferUtils.wrapByteBuffer((byte)1, (byte)2, (byte)3, (byte)4, (byte)5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(5, buffer.position());
		
		buffer.flip();
		
		byte[] b = new byte[5];
		
		buffer.get(b);
		
		assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, b);
	}

	@Test
	void testWrapShortBuffer()
	{
		ShortBuffer buffer = BufferUtils.wrapShortBuffer((short)1, (short)2, (short)3, (short)4, (short)5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(5, buffer.position());
		
		buffer.flip();
		
		short[] b = new short[5];
		
		buffer.get(b);
		
		assertArrayEquals(new short[] {1, 2, 3, 4, 5}, b);
	}

	@Test
	void testWrapIntBuffer()
	{
		IntBuffer buffer = BufferUtils.wrapIntBuffer(1, 2, 3, 4, 5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(5, buffer.position());
		
		buffer.flip();
		
		int[] b = new int[5];
		
		buffer.get(b);
		
		assertArrayEquals(new int[] {1, 2, 3, 4, 5}, b);
	}

	@Test
	void testWrapLongBuffer()
	{
		LongBuffer buffer = BufferUtils.wrapLongBuffer(1L, 2L, 3L, 4L, 5L);
		
		assertEquals(5, buffer.capacity());
		assertEquals(5, buffer.position());
		
		buffer.flip();
		
		long[] b = new long[5];
		
		buffer.get(b);
		
		assertArrayEquals(new long[] {1L, 2L, 3L, 4L, 5L}, b);
	}

	@Test
	void testWrapFloatBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapFloatBuffer(1.1f, 2.2f, 3.3f, 4.4f, 5.5f);
		
		assertEquals(5, buffer.capacity());
		assertEquals(5, buffer.position());
		
		buffer.flip();
		
		float[] b = new float[5];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 2.2f, 3.3f, 4.4f, 5.5f}, b);
	}

	@Test
	void testWrapDoubleBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapDoubleBuffer(1.1, 2.2, 3.3, 4.4, 5.5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(5, buffer.position());
		
		buffer.flip();
		
		double[] b = new double[5];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 2.2, 3.3, 4.4, 5.5}, b);
	}

	@Test
	void testWrapTuple2FBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapTuple2FBuffer(new Tup2f(1.1f, 1.2f), new Tup2f(2.1f, 2.2f), new Tup2f(3.1f, 3.2f));
		
		assertEquals(6, buffer.capacity());
		assertEquals(6, buffer.position());
		
		buffer.flip();
		
		float[] b = new float[6];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 1.2f, 2.1f, 2.2f, 3.1f, 3.2f}, b);
	}

	@Test
	void testWrapTuple2DBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapTuple2DBuffer(new Tup2d(1.1, 1.2), new Tup2d(2.1, 2.2), new Tup2d(3.1, 3.2));
		
		assertEquals(6, buffer.capacity());
		assertEquals(6, buffer.position());
		
		buffer.flip();
		
		double[] b = new double[6];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 1.2, 2.1, 2.2, 3.1, 3.2}, b);
	}

	@Test
	void testWrapTuple3FBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapTuple3FBuffer(new Tup3f(1.1f, 1.2f, 1.3f), new Tup3f(2.1f, 2.2f, 2.3f), new Tup3f(3.1f, 3.2f, 3.3f));
		
		assertEquals(9, buffer.capacity());
		assertEquals(9, buffer.position());
		
		buffer.flip();
		
		float[] b = new float[9];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 1.2f, 1.3f, 2.1f, 2.2f, 2.3f, 3.1f, 3.2f, 3.3f}, b);
	}

	@Test
	void testWrapTuple3DBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapTuple3DBuffer(new Tup3d(1.1, 1.2, 1.3), new Tup3d(2.1, 2.2, 2.3), new Tup3d(3.1, 3.2, 3.3));
		
		assertEquals(9, buffer.capacity());
		assertEquals(9, buffer.position());
		
		buffer.flip();
		
		double[] b = new double[9];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 1.2, 1.3, 2.1, 2.2, 2.3, 3.1, 3.2, 3.3}, b);
	}

	@Test
	void testWrapTuple4FBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapTuple4FBuffer(new Tup4f(1.1f, 1.2f, 1.3f, 1.4f), new Tup4f(2.1f, 2.2f, 2.3f, 2.4f), new Tup4f(3.1f, 3.2f, 3.3f, 3.4f));
		
		assertEquals(12, buffer.capacity());
		assertEquals(12, buffer.position());
		
		buffer.flip();
		
		float[] b = new float[12];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 1.2f, 1.3f, 1.4f, 2.1f, 2.2f, 2.3f, 2.4f, 3.1f, 3.2f, 3.3f, 3.4f}, b);
	}

	@Test
	void testWrapTuple4DBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapTuple4DBuffer(new Tup4d(1.1, 1.2, 1.3, 1.4), new Tup4d(2.1, 2.2, 2.3, 2.4), new Tup4d(3.1, 3.2, 3.3, 3.4));
		
		assertEquals(12, buffer.capacity());
		assertEquals(12, buffer.position());
		
		buffer.flip();
		
		double[] b = new double[12];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 1.2, 1.3, 1.4, 2.1, 2.2, 2.3, 2.4, 3.1, 3.2, 3.3, 3.4}, b);
	}

	@Test
	void testWrapFlippedByteBuffer()
	{
		ByteBuffer buffer = BufferUtils.wrapFlippedByteBuffer((byte)1, (byte)2, (byte)3, (byte)4, (byte)5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(0, buffer.position());

		byte[] b = new byte[5];
		
		buffer.get(b);
		
		assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, b);
	}

	@Test
	void testWrapFlippedShortBuffer()
	{
		ShortBuffer buffer = BufferUtils.wrapFlippedShortBuffer((short)1, (short)2, (short)3, (short)4, (short)5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(0, buffer.position());
		
		short[] b = new short[5];
		
		buffer.get(b);
		
		assertArrayEquals(new short[] {1, 2, 3, 4, 5}, b);
	}

	@Test
	void testWrapFlippedIntBuffer()
	{
		IntBuffer buffer = BufferUtils.wrapFlippedIntBuffer(1, 2, 3, 4, 5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(0, buffer.position());

		int[] b = new int[5];
		
		buffer.get(b);
		
		assertArrayEquals(new int[] {1, 2, 3, 4, 5}, b);
	}

	@Test
	void testWrapFlippedLongBuffer()
	{
		LongBuffer buffer = BufferUtils.wrapFlippedLongBuffer(1L, 2L, 3L, 4L, 5L);
		
		assertEquals(5, buffer.capacity());
		assertEquals(0, buffer.position());

		long[] b = new long[5];
		
		buffer.get(b);
		
		assertArrayEquals(new long[] {1L, 2L, 3L, 4L, 5L}, b);
	}

	@Test
	void testWrapFlippedFloatBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapFlippedFloatBuffer(1.1f, 2.2f, 3.3f, 4.4f, 5.5f);
		
		assertEquals(5, buffer.capacity());
		assertEquals(0, buffer.position());
		
		float[] b = new float[5];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 2.2f, 3.3f, 4.4f, 5.5f}, b);
	}

	@Test
	void testWrapFlippedDoubleBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapFlippedDoubleBuffer(1.1, 2.2, 3.3, 4.4, 5.5);
		
		assertEquals(5, buffer.capacity());
		assertEquals(0, buffer.position());

		double[] b = new double[5];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 2.2, 3.3, 4.4, 5.5}, b);
	}

	@Test
	void testWrapFlippedTuple2FBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapFlippedTuple2FBuffer(new Tup2f(1.1f, 1.2f), new Tup2f(2.1f, 2.2f), new Tup2f(3.1f, 3.2f));
		
		assertEquals(6, buffer.capacity());
		assertEquals(0, buffer.position());

		float[] b = new float[6];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 1.2f, 2.1f, 2.2f, 3.1f, 3.2f}, b);
	}

	@Test
	void testWrapFlippedTuple2DBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapFlippedTuple2DBuffer(new Tup2d(1.1, 1.2), new Tup2d(2.1, 2.2), new Tup2d(3.1, 3.2));
		
		assertEquals(6, buffer.capacity());
		assertEquals(0, buffer.position());

		double[] b = new double[6];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 1.2, 2.1, 2.2, 3.1, 3.2}, b);
	}

	@Test
	void testWrapFlippedTuple3FBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapFlippedTuple3FBuffer(new Tup3f(1.1f, 1.2f, 1.3f), new Tup3f(2.1f, 2.2f, 2.3f), new Tup3f(3.1f, 3.2f, 3.3f));
		
		assertEquals(9, buffer.capacity());
		assertEquals(0, buffer.position());

		float[] b = new float[9];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 1.2f, 1.3f, 2.1f, 2.2f, 2.3f, 3.1f, 3.2f, 3.3f}, b);
	}

	@Test
	void testWrapFlippedTuple3DBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapFlippedTuple3DBuffer(new Tup3d(1.1, 1.2, 1.3), new Tup3d(2.1, 2.2, 2.3), new Tup3d(3.1, 3.2, 3.3));
		
		assertEquals(9, buffer.capacity());
		assertEquals(0, buffer.position());

		double[] b = new double[9];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 1.2, 1.3, 2.1, 2.2, 2.3, 3.1, 3.2, 3.3}, b);
	}

	@Test
	void testWrapFlippedTuple4FBuffer()
	{
		FloatBuffer buffer = BufferUtils.wrapFlippedTuple4FBuffer(new Tup4f(1.1f, 1.2f, 1.3f, 1.4f), new Tup4f(2.1f, 2.2f, 2.3f, 2.4f), new Tup4f(3.1f, 3.2f, 3.3f, 3.4f));
		
		assertEquals(12, buffer.capacity());
		assertEquals(0, buffer.position());

		float[] b = new float[12];
		
		buffer.get(b);
		
		assertArrayEquals(new float[] {1.1f, 1.2f, 1.3f, 1.4f, 2.1f, 2.2f, 2.3f, 2.4f, 3.1f, 3.2f, 3.3f, 3.4f}, b);
	}

	@Test
	void testWrapFlippedTuple4DBuffer()
	{
		DoubleBuffer buffer = BufferUtils.wrapFlippedTuple4DBuffer(new Tup4d(1.1, 1.2, 1.3, 1.4), new Tup4d(2.1, 2.2, 2.3, 2.4), new Tup4d(3.1, 3.2, 3.3, 3.4));
		
		assertEquals(12, buffer.capacity());
		assertEquals(0, buffer.position());

		double[] b = new double[12];
		
		buffer.get(b);
		
		assertArrayEquals(new double[] {1.1, 1.2, 1.3, 1.4, 2.1, 2.2, 2.3, 2.4, 3.1, 3.2, 3.3, 3.4}, b);
	}

	@Test
	void testWrapByteBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapByteBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapByteBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapShortBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapShortBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapShortBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapIntBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapIntBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapIntBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapLongBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapLongBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapLongBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFloatBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFloatBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFloatBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapDoubleBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapDoubleBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapDoubleBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapTuple2FBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapTuple2FBuffer((ITup2fR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple2FBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple2FBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}

		assertTrue(exception);
	}

	@Test
	void testWrapTuple2DBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapTuple2DBuffer((ITup2dR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple2DBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple2DBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapTuple3FBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapTuple3FBuffer((ITup3fR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple3FBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple3FBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapTuple3DBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapTuple3DBuffer((ITup3dR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple3DBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple3DBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapTuple4FBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapTuple4FBuffer((ITup4fR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple4FBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple4FBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapTuple4DBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapTuple4DBuffer((ITup4dR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple4DBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapTuple4DBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedByteBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedByteBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedByteBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedShortBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedShortBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedShortBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedIntBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedIntBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedIntBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedLongBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedLongBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedLongBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedFloatBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedFloatBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedFloatBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedDoubleBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedDoubleBuffer(null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedDoubleBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedTuple2FBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple2FBuffer((ITup2fR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple2FBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple2FBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}

		assertTrue(exception);
	}

	@Test
	void testWrapFlippedTuple2DBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple2DBuffer((ITup2dR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple2DBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple2DBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedTuple3FBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple3FBuffer((ITup3fR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple3FBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple3FBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedTuple3DBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple3DBuffer((ITup3dR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple3DBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple3DBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedTuple4FBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple4FBuffer((ITup4fR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple4FBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple4FBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testWrapFlippedTuple4DBufferAssertions()
	{
		boolean exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple4DBuffer((ITup4dR[])null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple4DBuffer();
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
		
		exception = false;
		
		try
		{
			BufferUtils.wrapFlippedTuple4DBuffer(null, null);
		}
		catch(AssertionError e)
		{
			exception = true;
		}
		
		assertTrue(exception);
	}
	
}
