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

package org.barghos.math;

import org.barghos.core.tuple.tuple3.Tup3fR;
import org.barghos.math.vector.vec3.Vec3;

/**
 * @author picatrix1899
 *
 */
public class Transform3 implements ITransform3
{
	protected final Vec3 position = new Vec3();
	protected final EulerAngles3f orientation = new EulerAngles3f();
	protected final Vec3 size = new Vec3();
	
	public Transform3()
	{
		this.size.set(1.0f, 1.0f, 1.0f);
	}
	
	public Transform3(Transform3 t)
	{
		set(t);
	}
	
	public Transform3(Tup3fR position, EulerAngles3f orientation, Tup3fR size)
	{
		set(position, orientation, size);
	}

	public Transform3 set(Transform3 t)
	{
		t.getPosition(this.position);
		t.getOrientation(this.orientation);
		t.getSize(this.size);
		return this;
	}
	
	public Transform3 set(Tup3fR position, EulerAngles3f orientation, Tup3fR size)
	{
		return setPosition(position).setOrientation(orientation).setSize(size);
	}
	
	public Transform3 setPosition(Tup3fR position)
	{
		this.position.set(position); return this;
	}
	
	public Transform3 setPosition(float x, float y, float z)
	{
		this.position.set(x, y, z); return this;
	}
	
	public Transform3 setOrientation(EulerAngles3f orientation)
	{
		this.orientation.set(orientation); return this;
	}
	
	public Transform3 setOrientation(float pitch, float yaw, float roll)
	{
		this.orientation.set(pitch, yaw, roll); return this;
	}
	
	public Transform3 setSize(Tup3fR size)
	{
		this.size.set(size); return this;
	}
	
	public Transform3 setSize(float scalar)
	{
		this.size.set(scalar, scalar, scalar); return this;
	}
	
	public Transform3 setSize(float x, float y, float z)
	{
		this.size.set(x, y, z); return this;
	}
	
	public Vec3 getPosition()
	{
		return new Vec3(this.position);
	}

	public Vec3 getPosition(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.position);
	}
	
	public EulerAngles3f getOrientation()
	{
		return new EulerAngles3f(this.orientation);
	}

	public EulerAngles3f getOrientation(EulerAngles3f res)
	{
		if(res == null) res = new EulerAngles3f();
		return res.set(this.orientation);
	}
	
	public Vec3 getSize()
	{
		return new Vec3(this.size);
	}
	
	public Vec3 getSize(Vec3 res)
	{
		if(res == null) res = new Vec3();
		return res.set(this.size);
	}
	
	public String toString()
	{
		return "transform3(position= " + this.position + ", orientation=" + this.orientation + ", size=" + this.size + ")";
	}
}
