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

package org.barghos.core.test;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.barghos.core.tuple2.Tup2d;
import org.barghos.core.tuple2.Tup2f;
import org.barghos.core.tuple2.api.Tup2dR;
import org.barghos.core.tuple2.api.Tup2fR;
import org.barghos.core.tuple3.Tup3d;
import org.barghos.core.tuple3.Tup3f;
import org.barghos.core.tuple3.api.Tup3dR;
import org.barghos.core.tuple3.api.Tup3fR;
import org.barghos.core.tuple4.Tup4d;
import org.barghos.core.tuple4.api.Tup4dR;
import org.barghos.core.tuple4.Tup4f;
import org.barghos.core.tuple4.api.Tup4fR;
import org.barghos.core.util.BufferUtils;

class BufferUtilsTest
{

	@Test
	void createByteBufferTest()
	{
		ByteBuffer buffer = BufferUtils.createByteBuffer(14);
		
		assertNotNull(buffer);
		assertEquals(14, buffer.capacity());
	}

	@Test
	void createShortBufferTest()
	{
		ShortBuffer buffer = BufferUtils.createShortBuffer(14);
		
		assertNotNull(buffer);
		assertEquals(14, buffer.capacity());
	}
	
	@Test
	void createIntBufferTest()
	{
		IntBuffer buffer = BufferUtils.createIntBuffer(14);
		
		assertNotNull(buffer);
		assertEquals(14, buffer.capacity());
	}
	
	@Test
	void createLongBufferTest()
	{
		LongBuffer buffer = BufferUtils.createLongBuffer(14);
		
		assertNotNull(buffer);
		assertEquals(14, buffer.capacity());
	}
	
	@Test
	void createFloatBufferTest()
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(14);
		
		assertNotNull(buffer);
		assertEquals(14, buffer.capacity());
	}
	
	@Test
	void createDoubleBufferTest()
	{
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(14);
		
		assertNotNull(buffer);
		assertEquals(14, buffer.capacity());
	}
	
	@Test
	void copyToByteBufferArrayTest()
	{
		ByteBuffer buffer = BufferUtils.copyToByteBuffer((byte)1, (byte)2, (byte)3, (byte)4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals((byte)1, buffer.get());
		assertEquals((byte)2, buffer.get());
		assertEquals((byte)3, buffer.get());
		assertEquals((byte)4, buffer.get());
	}
	
	@Test
	void copyToByteBufferListTest()
	{
		ArrayList<Byte> list = new ArrayList<>();
		list.add((byte)1);
		list.add((byte)2);
		list.add((byte)3);
		list.add((byte)4);
		
		ByteBuffer buffer = BufferUtils.copyToByteBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals((byte)1, buffer.get());
		assertEquals((byte)2, buffer.get());
		assertEquals((byte)3, buffer.get());
		assertEquals((byte)4, buffer.get());
	}
	
	@Test
	void copyToShortBufferArrayTest()
	{
		ShortBuffer buffer = BufferUtils.copyToShortBuffer((short)1, (short)2, (short)3, (short)4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals((short)1, buffer.get());
		assertEquals((short)2, buffer.get());
		assertEquals((short)3, buffer.get());
		assertEquals((short)4, buffer.get());
	}
	
	@Test
	void copyToShortBufferListTest()
	{
		ArrayList<Short> list = new ArrayList<>();
		list.add((short)1);
		list.add((short)2);
		list.add((short)3);
		list.add((short)4);
		
		ShortBuffer buffer = BufferUtils.copyToShortBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals((short)1, buffer.get());
		assertEquals((short)2, buffer.get());
		assertEquals((short)3, buffer.get());
		assertEquals((short)4, buffer.get());
	}
	
	@Test
	void copyToIntBufferArrayTest()
	{
		IntBuffer buffer = BufferUtils.copyToIntBuffer(1, 2, 3, 4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1, buffer.get());
		assertEquals(2, buffer.get());
		assertEquals(3, buffer.get());
		assertEquals(4, buffer.get());
	}
	
	@Test
	void copyToIntBufferListTest()
	{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		IntBuffer buffer = BufferUtils.copyToIntBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1, buffer.get());
		assertEquals(2, buffer.get());
		assertEquals(3, buffer.get());
		assertEquals(4, buffer.get());
	}
	
	@Test
	void copyToLongBufferArrayTest()
	{
		LongBuffer buffer = BufferUtils.copyToLongBuffer(1l, 2l, 3l, 4l);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1l, buffer.get());
		assertEquals(2l, buffer.get());
		assertEquals(3l, buffer.get());
		assertEquals(4l, buffer.get());
	}
	
	@Test
	void copyToLongBufferListTest()
	{
		ArrayList<Long> list = new ArrayList<>();
		list.add(1l);
		list.add(2l);
		list.add(3l);
		list.add(4l);
		
		LongBuffer buffer = BufferUtils.copyToLongBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1l, buffer.get());
		assertEquals(2l, buffer.get());
		assertEquals(3l, buffer.get());
		assertEquals(4l, buffer.get());
	}
	
	@Test
	void copyToFloatBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToFloatBuffer(1.1f, 2.2f, 3.3f, 4.4f);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToFloatBufferListTest()
	{
		ArrayList<Float> list = new ArrayList<>();
		list.add(1.1f);
		list.add(2.2f);
		list.add(3.3f);
		list.add(4.4f);
		
		FloatBuffer buffer = BufferUtils.copyToFloatBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToDoubleBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToDoubleBuffer(1.1, 2.2, 3.3, 4.4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToDoubleBufferListTest()
	{
		ArrayList<Double> list = new ArrayList<>();
		list.add(1.1);
		list.add(2.2);
		list.add(3.3);
		list.add(4.4);
		
		DoubleBuffer buffer = BufferUtils.copyToDoubleBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToTuple2FBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToTuple2FBuffer(new Tup2f(1.1f, 2.2f), new Tup2f(3.3f, 4.4f));
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToTuple2FBufferListTest()
	{
		ArrayList<Tup2fR> list = new ArrayList<>();
		list.add(new Tup2f(1.1f, 2.2f));
		list.add(new Tup2f(3.3f, 4.4f));
		
		FloatBuffer buffer = BufferUtils.copyToTuple2FBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToTuple2DBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToTuple2DBuffer(new Tup2d(1.1, 2.2), new Tup2d(3.3, 4.4));
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToTuple2DBufferListTest()
	{
		ArrayList<Tup2dR> list = new ArrayList<>();
		list.add(new Tup2d(1.1, 2.2));
		list.add(new Tup2d(3.3, 4.4));
		
		DoubleBuffer buffer = BufferUtils.copyToTuple2DBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(4, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToTuple3FBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToTuple3FBuffer(new Tup3f(1.1f, 2.2f, 3.3f), new Tup3f(4.4f, 5.5f, 6.6f));
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(6, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
	}
	
	@Test
	void copyToTuple3FBufferListTest()
	{
		ArrayList<Tup3fR> list = new ArrayList<>();
		list.add(new Tup3f(1.1f, 2.2f, 3.3f));
		list.add(new Tup3f(4.4f, 5.5f, 6.6f));
		
		FloatBuffer buffer = BufferUtils.copyToTuple3FBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(6, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
	}
	
	@Test
	void copyToTuple3DBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToTuple3DBuffer(new Tup3d(1.1, 2.2, 3.3), new Tup3d(4.4, 5.5, 6.6));
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(6, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
	}
	
	@Test
	void copyToTuple3DBufferListTest()
	{
		ArrayList<Tup3dR> list = new ArrayList<>();
		list.add(new Tup3d(1.1, 2.2, 3.3));
		list.add(new Tup3d(4.4, 5.5, 6.6));
		
		DoubleBuffer buffer = BufferUtils.copyToTuple3DBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(6, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
	}
	
	@Test
	void copyToTuple4FBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToTuple4FBuffer(new Tup4f(1.1f, 2.2f, 3.3f, 4.4f), new Tup4f(5.5f, 6.6f, 7.7f, 8.8f));
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(8, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
		assertEquals(7.7f, buffer.get());
		assertEquals(8.8f, buffer.get());
	}
	
	@Test
	void copyToTuple4FBufferListTest()
	{
		ArrayList<Tup4fR> list = new ArrayList<>();
		list.add(new Tup4f(1.1f, 2.2f, 3.3f, 4.4f));
		list.add(new Tup4f(5.5f, 6.6f, 7.7f, 8.8f));
		
		FloatBuffer buffer = BufferUtils.copyToTuple4FBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(8, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
		assertEquals(7.7f, buffer.get());
		assertEquals(8.8f, buffer.get());
	}
	
	@Test
	void copyToTuple4DBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToTuple4DBuffer(new Tup4d(1.1, 2.2, 3.3, 4.4), new Tup4d(5.5, 6.6, 7.7, 8.8));
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(8, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
		assertEquals(7.7, buffer.get());
		assertEquals(8.8, buffer.get());
	}
	
	@Test
	void copyToTuple4DBufferListTest()
	{
		ArrayList<Tup4dR> list = new ArrayList<>();
		list.add(new Tup4d(1.1, 2.2, 3.3, 4.4));
		list.add(new Tup4d(5.5, 6.6, 7.7, 8.8));
		
		DoubleBuffer buffer = BufferUtils.copyToTuple4DBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(8, buffer.position());
		
		buffer.flip();
		
		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
		assertEquals(7.7, buffer.get());
		assertEquals(8.8, buffer.get());
	}
	
	@Test
	void copyToFlippedByteBufferArrayTest()
	{
		ByteBuffer buffer = BufferUtils.copyToFlippedByteBuffer((byte)1, (byte)2, (byte)3, (byte)4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals((byte)1, buffer.get());
		assertEquals((byte)2, buffer.get());
		assertEquals((byte)3, buffer.get());
		assertEquals((byte)4, buffer.get());
	}
	
	@Test
	void copyToFlippedByteBufferListTest()
	{
		ArrayList<Byte> list = new ArrayList<>();
		list.add((byte)1);
		list.add((byte)2);
		list.add((byte)3);
		list.add((byte)4);
		
		ByteBuffer buffer = BufferUtils.copyToFlippedByteBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals((byte)1, buffer.get());
		assertEquals((byte)2, buffer.get());
		assertEquals((byte)3, buffer.get());
		assertEquals((byte)4, buffer.get());
	}
	
	@Test
	void copyToFlippedShortBufferArrayTest()
	{
		ShortBuffer buffer = BufferUtils.copyToFlippedShortBuffer((short)1, (short)2, (short)3, (short)4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals((short)1, buffer.get());
		assertEquals((short)2, buffer.get());
		assertEquals((short)3, buffer.get());
		assertEquals((short)4, buffer.get());
	}
	
	@Test
	void copyToFlippedShortBufferListTest()
	{
		ArrayList<Short> list = new ArrayList<>();
		list.add((short)1);
		list.add((short)2);
		list.add((short)3);
		list.add((short)4);
		
		ShortBuffer buffer = BufferUtils.copyToFlippedShortBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals((short)1, buffer.get());
		assertEquals((short)2, buffer.get());
		assertEquals((short)3, buffer.get());
		assertEquals((short)4, buffer.get());
	}
	
	@Test
	void copyToFlippedIntBufferArrayTest()
	{
		IntBuffer buffer = BufferUtils.copyToFlippedIntBuffer(1, 2, 3, 4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1, buffer.get());
		assertEquals(2, buffer.get());
		assertEquals(3, buffer.get());
		assertEquals(4, buffer.get());
	}
	
	@Test
	void copyToFlippedIntBufferListTest()
	{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		IntBuffer buffer = BufferUtils.copyToFlippedIntBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1, buffer.get());
		assertEquals(2, buffer.get());
		assertEquals(3, buffer.get());
		assertEquals(4, buffer.get());
	}
	
	@Test
	void copyToFlippedLongBufferArrayTest()
	{
		LongBuffer buffer = BufferUtils.copyToFlippedLongBuffer(1l, 2l, 3l, 4l);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1l, buffer.get());
		assertEquals(2l, buffer.get());
		assertEquals(3l, buffer.get());
		assertEquals(4l, buffer.get());
	}
	
	@Test
	void copyToFlippedLongBufferListTest()
	{
		ArrayList<Long> list = new ArrayList<>();
		list.add(1l);
		list.add(2l);
		list.add(3l);
		list.add(4l);
		
		LongBuffer buffer = BufferUtils.copyToFlippedLongBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1l, buffer.get());
		assertEquals(2l, buffer.get());
		assertEquals(3l, buffer.get());
		assertEquals(4l, buffer.get());
	}
	
	@Test
	void copyToFlippedFloatBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToFlippedFloatBuffer(1.1f, 2.2f, 3.3f, 4.4f);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToFlippedFloatBufferListTest()
	{
		ArrayList<Float> list = new ArrayList<>();
		list.add(1.1f);
		list.add(2.2f);
		list.add(3.3f);
		list.add(4.4f);
		
		FloatBuffer buffer = BufferUtils.copyToFlippedFloatBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToFlippedDoubleBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToFlippedDoubleBuffer(1.1, 2.2, 3.3, 4.4);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToFlippedDoubleBufferListTest()
	{
		ArrayList<Double> list = new ArrayList<>();
		list.add(1.1);
		list.add(2.2);
		list.add(3.3);
		list.add(4.4);
		
		DoubleBuffer buffer = BufferUtils.copyToFlippedDoubleBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple2FBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToFlippedTuple2FBuffer(new Tup2f(1.1f, 2.2f), new Tup2f(3.3f, 4.4f));
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple2FBufferListTest()
	{
		ArrayList<Tup2fR> list = new ArrayList<>();
		list.add(new Tup2f(1.1f, 2.2f));
		list.add(new Tup2f(3.3f, 4.4f));
		
		FloatBuffer buffer = BufferUtils.copyToFlippedTuple2FBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple2DBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToFlippedTuple2DBuffer(new Tup2d(1.1, 2.2), new Tup2d(3.3, 4.4));
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple2DBufferListTest()
	{
		ArrayList<Tup2dR> list = new ArrayList<>();
		list.add(new Tup2d(1.1, 2.2));
		list.add(new Tup2d(3.3, 4.4));
		
		DoubleBuffer buffer = BufferUtils.copyToFlippedTuple2DBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(4, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple3FBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToFlippedTuple3FBuffer(new Tup3f(1.1f, 2.2f, 3.3f), new Tup3f(4.4f, 5.5f, 6.6f));
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple3FBufferListTest()
	{
		ArrayList<Tup3fR> list = new ArrayList<>();
		list.add(new Tup3f(1.1f, 2.2f, 3.3f));
		list.add(new Tup3f(4.4f, 5.5f, 6.6f));
		
		FloatBuffer buffer = BufferUtils.copyToFlippedTuple3FBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple3DBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToFlippedTuple3DBuffer(new Tup3d(1.1, 2.2, 3.3), new Tup3d(4.4, 5.5, 6.6));
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple3DBufferListTest()
	{
		ArrayList<Tup3dR> list = new ArrayList<>();
		list.add(new Tup3d(1.1, 2.2, 3.3));
		list.add(new Tup3d(4.4, 5.5, 6.6));
		
		DoubleBuffer buffer = BufferUtils.copyToFlippedTuple3DBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(6, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple4FBufferArrayTest()
	{
		FloatBuffer buffer = BufferUtils.copyToFlippedTuple4FBuffer(new Tup4f(1.1f, 2.2f, 3.3f, 4.4f), new Tup4f(5.5f, 6.6f, 7.7f, 8.8f));
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
		assertEquals(7.7f, buffer.get());
		assertEquals(8.8f, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple4FBufferListTest()
	{
		ArrayList<Tup4fR> list = new ArrayList<>();
		list.add(new Tup4f(1.1f, 2.2f, 3.3f, 4.4f));
		list.add(new Tup4f(5.5f, 6.6f, 7.7f, 8.8f));
		
		FloatBuffer buffer = BufferUtils.copyToFlippedTuple4FBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1f, buffer.get());
		assertEquals(2.2f, buffer.get());
		assertEquals(3.3f, buffer.get());
		assertEquals(4.4f, buffer.get());
		assertEquals(5.5f, buffer.get());
		assertEquals(6.6f, buffer.get());
		assertEquals(7.7f, buffer.get());
		assertEquals(8.8f, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple4DBufferArrayTest()
	{
		DoubleBuffer buffer = BufferUtils.copyToFlippedTuple4DBuffer(new Tup4d(1.1, 2.2, 3.3, 4.4), new Tup4d(5.5, 6.6, 7.7, 8.8));
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
		assertEquals(7.7, buffer.get());
		assertEquals(8.8, buffer.get());
	}
	
	@Test
	void copyToFlippedTuple4DBufferListTest()
	{
		ArrayList<Tup4dR> list = new ArrayList<>();
		list.add(new Tup4d(1.1, 2.2, 3.3, 4.4));
		list.add(new Tup4d(5.5, 6.6, 7.7, 8.8));
		
		DoubleBuffer buffer = BufferUtils.copyToFlippedTuple4DBuffer(list);
		
		assertNotNull(buffer);
		assertEquals(8, buffer.capacity());
		assertEquals(0, buffer.position());

		assertEquals(1.1, buffer.get());
		assertEquals(2.2, buffer.get());
		assertEquals(3.3, buffer.get());
		assertEquals(4.4, buffer.get());
		assertEquals(5.5, buffer.get());
		assertEquals(6.6, buffer.get());
		assertEquals(7.7, buffer.get());
		assertEquals(8.8, buffer.get());
	}
}
