/*
MIT License

Copyright (c) 2020 picatrix1899

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

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.util.List;

import org.barghos.core.Barghos;
import org.barghos.core.exception.ArgumentNullException;
import org.barghos.core.tuple2.api.Tup2dR;
import org.barghos.core.tuple2.api.Tup2fR;
import org.barghos.core.tuple3.api.Tup3dR;
import org.barghos.core.tuple3.api.Tup3fR;
import org.barghos.core.tuple4.api.Tup4dR;
import org.barghos.core.tuple4.api.Tup4fR;


/**
 * Provides functions for creating and filling different buffers more easiely.
 * 
 * @author picatrix1899
 * 
 * @since 1.0
 */
public abstract class BufferUtils extends BufferUtilsPrimitives
{	
	/**
	 * Creates a Float-Buffer from the given tuples.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple2FBuffer(Tup2fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		int length = v.length;

		FloatBuffer buffer = createFloatBuffer(length * 2);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple2FBuffer(FloatBuffer buffer, Tup2fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < v.length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple2FBuffer(List<Tup2fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();

		FloatBuffer buffer = createFloatBuffer(length * 2);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple2FBuffer(FloatBuffer buffer, List<Tup2fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple2DBuffer(Tup2dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		int length = v.length;

		DoubleBuffer buffer = createDoubleBuffer(length * 2);
		
		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple2DBuffer(DoubleBuffer buffer, Tup2dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < v.length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple2DBuffer(List<Tup2dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();

		DoubleBuffer buffer = createDoubleBuffer(length * 2);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple2DBuffer(DoubleBuffer buffer, List<Tup2dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple3FBuffer(Tup3fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		int length = v.length;
		
		FloatBuffer buffer = createFloatBuffer(length * 3);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple3FBuffer(FloatBuffer buffer, Tup3fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < v.length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple3FBuffer(List<Tup3fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		FloatBuffer buffer = createFloatBuffer(length * 3);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple3FBuffer(FloatBuffer buffer, List<Tup3fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple3DBuffer(Tup3dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		int length = v.length;
		
		DoubleBuffer buffer = createDoubleBuffer(length * 3);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple3DBuffer(DoubleBuffer buffer, Tup3dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < v.length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple3DBuffer(List<Tup3dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		DoubleBuffer buffer = createDoubleBuffer(length * 3);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple3DBuffer(DoubleBuffer buffer, List<Tup3dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple4FBuffer(Tup4fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		int length = v.length;
		
		FloatBuffer buffer = createFloatBuffer(length * 4);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple4FBuffer(FloatBuffer buffer, Tup4fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < v.length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple4FBuffer(List<Tup4fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();
		
		FloatBuffer buffer = createFloatBuffer(length * 4);
		
		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToTuple4FBuffer(FloatBuffer buffer, List<Tup4fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple4DBuffer(Tup4dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		int length = v.length;

		DoubleBuffer buffer = createDoubleBuffer(length * 4);
		
		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple4DBuffer(DoubleBuffer buffer, Tup4dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < v.length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple4DBuffer(List<Tup4dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		int length = v.size();

		DoubleBuffer buffer = createDoubleBuffer(length * 4);

		for(int i = 0; i < length; i++)
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
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToTuple4DBuffer(DoubleBuffer buffer, List<Tup4dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		for(int i = 0; i < v.size(); i++)
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
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(Tup2fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		FloatBuffer buffer = copyToTuple2FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(FloatBuffer buffer, Tup2fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		copyToTuple2FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(List<Tup2fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		FloatBuffer buffer = copyToTuple2FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple2FBuffer(FloatBuffer buffer, List<Tup2fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToTuple2FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(Tup2dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		DoubleBuffer buffer = copyToTuple2DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(DoubleBuffer buffer, Tup2dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		copyToTuple2DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(List<Tup2dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		DoubleBuffer buffer = copyToTuple2DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t2.x, t2.y, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple2DBuffer(DoubleBuffer buffer, List<Tup2dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToTuple2DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(Tup3fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		FloatBuffer buffer = copyToTuple3FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(FloatBuffer buffer, Tup3fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		copyToTuple3FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(List<Tup3fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		FloatBuffer buffer = copyToTuple3FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple3FBuffer(FloatBuffer buffer, List<Tup3fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToTuple3FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(Tup3dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		DoubleBuffer buffer = copyToTuple3DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(DoubleBuffer buffer, Tup3dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		copyToTuple3DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(List<Tup3dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		DoubleBuffer buffer = copyToTuple3DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z, t2.x, t2.y, t2.z, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple3DBuffer(DoubleBuffer buffer, List<Tup3dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToTuple3DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(Tup4fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		FloatBuffer buffer = copyToTuple4FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(FloatBuffer buffer, Tup4fR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		copyToTuple4FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Float-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Float-Buffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(List<Tup4fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		FloatBuffer buffer = copyToTuple4FBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the FloatBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The FloatBuffer.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer copyToFlippedTuple4FBuffer(FloatBuffer buffer, List<Tup4fR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToTuple4FBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(Tup4dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		DoubleBuffer buffer = copyToTuple4DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(DoubleBuffer buffer, Tup4dR... v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < v.length; i++)
				if(v[i] == null) throw new RuntimeException();
		}
		
		copyToTuple4DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Creates a Double-Buffer from the given tuples and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The new Double-Buffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(List<Tup4dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(v == null) throw new ArgumentNullException("v");
		}
		
		DoubleBuffer buffer = copyToTuple4DBuffer(v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Copies the given tuples to the DoubleBuffer and flips it so it can be read.
	 * They are safed tuplewise componentwise (t1.x, t1.y, t1.z t1.w,, t2.x, t2.y, t2.z, t2.w, ...).
	 * 
	 * @param v The elements that should be saved in the buffer.
	 * 
	 * @return The DoubleBuffer.
	 * 
	 * @since 1.0
	 */
	public static DoubleBuffer copyToFlippedTuple4DBuffer(DoubleBuffer buffer, List<Tup4dR> v)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(v == null) throw new ArgumentNullException("v");
		}
		
		copyToTuple4DBuffer(buffer, v);
		buffer.flip();
		
		return buffer;
	}
	
	/**
	 * Writes the components of an implementation of {@link Tup2fR} into the given {@link FloatBuffer}
	 * in the order (x, y).
	 * 
	 * @param buffer The buffer the components should be written to.
	 * @param tuple The implementation of {@link Tup2fR} whose components should be written into the buffer.
	 * 
	 * @return The buffer that has been written to.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer put(FloatBuffer buffer, Tup2fR tuple)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(tuple == null) throw new ArgumentNullException("tuple");
		}
		
		buffer.put(tuple.getX());
		buffer.put(tuple.getY());
		
		return buffer;
	}
	
	/**
	 * Writes the components of an array of implementations of {@link Tup2fR} into the given {@link FloatBuffer}
	 * in the order (x, y).
	 * 
	 * @param buffer The buffer the components should be written to.
	 * @param tuples The implementations of {@link Tup2fR} whose components should be written into the buffer.
	 * 
	 * @return The buffer that has been written to.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer put(FloatBuffer buffer, Tup2fR... tuples)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < tuples.length; i++)
				if(tuples[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < tuples.length; i++)
		{
			Tup2fR t = tuples[i];
			buffer.put(t.getX());
			buffer.put(t.getY());
		}
		
		return buffer;
	}
	
	/**
	 * Writes the components of an implementation of {@link Tup3fR} into the given {@link FloatBuffer}
	 * in the order (x, y, z).
	 * 
	 * @param buffer The buffer the components should be written to.
	 * @param tuple The implementation of {@link Tup3fR} whose components should be written into the buffer.
	 * 
	 * @return The buffer that has been written to.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer put(FloatBuffer buffer, Tup3fR tuple)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(tuple == null) throw new ArgumentNullException("tuple");
		}
		
		buffer.put(tuple.getX());
		buffer.put(tuple.getY());
		buffer.put(tuple.getZ());
		
		return buffer;
	}
	
	/**
	 * Writes the components of an array of implementations of {@link Tup3fR} into the given {@link FloatBuffer}
	 * in the order (x, y, z).
	 * 
	 * @param buffer The buffer the components should be written to.
	 * @param tuples The implementations of {@link Tup3fR} whose components should be written into the buffer.
	 * 
	 * @return The buffer that has been written to.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer put(FloatBuffer buffer, Tup3fR... tuples)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < tuples.length; i++)
				if(tuples[i] == null) throw new RuntimeException();
		}

		for(int i = 0; i < tuples.length; i++)
		{
			Tup3fR t = tuples[i];
			buffer.put(t.getX());
			buffer.put(t.getY());
			buffer.put(t.getZ());
		}
		
		return buffer;
	}
	
	/**
	 * Writes the components of an implementation of {@link Tup4fR} into the given {@link FloatBuffer}
	 * in the order (x, y, z, w).
	 * 
	 * @param buffer The buffer the components should be written to.
	 * @param tuple The implementation of {@link Tup4fR} whose components should be written into the buffer.
	 * 
	 * @return The buffer that has been written to.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer put(FloatBuffer buffer, Tup4fR tuple)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			if(tuple == null) throw new ArgumentNullException("tuple");
		}
		
		buffer.put(tuple.getX());
		buffer.put(tuple.getY());
		buffer.put(tuple.getZ());
		buffer.put(tuple.getW());
		
		return buffer;
	}
	
	/**
	 * Writes the components of an array of implementations of {@link Tup4fR} into the given {@link FloatBuffer}
	 * in the order (x, y, z, w).
	 * 
	 * @param buffer The buffer the components should be written to.
	 * @param tuples The implementations of {@link Tup4fR} whose components should be written into the buffer.
	 * 
	 * @return The buffer that has been written to.
	 * 
	 * @since 1.0
	 */
	public static FloatBuffer put(FloatBuffer buffer, Tup4fR... tuples)
	{
		if(Barghos.BUILD_FLAG__PARAMETER_CHECKS)
		{
			if(buffer == null) throw new ArgumentNullException("buffer");
			for(int i = 0; i < tuples.length; i++)
				if(tuples[i] == null) throw new RuntimeException();
		}
		
		for(int i = 0; i < tuples.length; i++)
		{
			Tup4fR t = tuples[i];
			buffer.put(t.getX());
			buffer.put(t.getY());
			buffer.put(t.getZ());
			buffer.put(t.getW());
		}
		
		return buffer;
	}
}
