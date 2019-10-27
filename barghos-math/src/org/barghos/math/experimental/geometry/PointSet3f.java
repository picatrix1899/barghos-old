package org.barghos.math.experimental.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.barghos.math.experimental.matrix.Mat4f;
import org.barghos.math.experimental.point.Point3;
import org.barghos.math.experimental.vector.vec3.Vec3;

public class PointSet3f implements FiniteGeometricObject
{
	private List<Point3> points = new ArrayList<>();
	private final Vec3 min = new Vec3();
	private final Vec3 max = new Vec3();
	
	private boolean isDirty;
	
	public PointSet3f() {}
	
	public PointSet3f(PointSet3f set)
	{
		assert(set != null);
		set(set);
	}
	
	public PointSet3f(Point3... points)
	{
		assert(points != null);
		assert(points.length > 0);
		
		set(points);
	}
	
	public PointSet3f(Collection<Point3> c)
	{
		assert(c != null);
		set(c);
	}
	
	public PointSet3f set() { this.points.clear(); this.isDirty = true; return this; }
	
	public PointSet3f set(PointSet3f set)
	{
		assert(set != null);
		this.points.clear();
		for(int i = 0; i < set.points.size(); i++)
			this.points.add(set.points.get(i));
		this.isDirty = true;
		return this;
	}
	
	public PointSet3f set(Point3... points)
	{
		assert(points != null);
		assert(points.length > 0);
		
		this.points.clear();
		
		for(int i = 0; i < points.length; i++)
			this.points.add(points[i]);
		
		this.isDirty = true;
		
		return this;
	}

	public PointSet3f set(Collection<Point3> c)
	{
		assert(c != null);
		this.points.clear();
		this.points.addAll(c);
		
		this.isDirty = true;
		return this;
	}
	
	public PointSet3f add(Point3... points)
	{
		assert(points != null);
		assert(points.length > 0);
		
		for(int i = 0; i < points.length; i++)
			this.points.add(points[i]);
		
		this.isDirty = true;
		
		return this;
	}
	
	public PointSet3f add(Collection<Point3> c)
	{
		assert(c != null);
		this.points.addAll(c);
		this.isDirty = true;
		return this;
	}
	
	public PointSet3f transform(Mat4f t)
	{
		Point3[] p = new Point3[this.points.size()];
		
		for(int i = 0; i < this.points.size(); i++)
			p[i] = t.transform(this.points.get(i), (Point3)null);
		
		return set(p);
	}
	
	public PointSet3f transform(Mat4f t, PointSet3f res)
	{
		res = res != null ? res : new PointSet3f();
		
		Point3[] p = new Point3[this.points.size()];
		
		for(int i = 0; i < this.points.size(); i++)
			p[i] = t.transform(this.points.get(i), (Point3)null);
		
		return res.set(p);
	}
	
	public PointSet3f getPointSet()
	{
		return new PointSet3f(this);
	}
	
	public Point3[] getPoints()
	{
		return this.points.toArray(new Point3[this.points.size()]);
	}
	
	private void calculateExtremes()
	{
		// do calculations first internal for providing atomic values.
		float minX = Float.POSITIVE_INFINITY;
		float minY = Float.POSITIVE_INFINITY;
		float minZ = Float.POSITIVE_INFINITY;
		
		float maxX = Float.NEGATIVE_INFINITY;
		float maxY = Float.NEGATIVE_INFINITY;
		float maxZ = Float.NEGATIVE_INFINITY;
		
		Point3 current;
		
		for(int i = 0; i < this.points.size(); i++)
		{
			current = this.points.get(i);
			
			if(current.getX() < minX)
				minX = current.getX();
			
			if(current.getY() < minY)
				minY = current.getY();
			
			if(current.getZ() < minZ)
				minZ = current.getZ();
			
			if(current.getX() > maxX)
				maxX = current.getX();
			
			if(current.getY() > maxY)
				maxY = current.getY();
			
			if(current.getZ() > maxZ)
				maxZ = current.getZ();
		}
		
		this.min.set(minX, minY, minZ);
		this.max.set(maxX, maxY, maxZ);
		
		this.isDirty = false;
	}
	
	public float getMinX()
	{
		if(this.isDirty) calculateExtremes();

		return this.min.getX();
	}
	
	public float getMinY()
	{
		if(this.isDirty) calculateExtremes();

		return this.min.getY();
	}
	
	public float getMinZ()
	{
		if(this.isDirty) calculateExtremes();
		
		return this.min.getZ();
	}
	
	public float getMaxX()
	{
		if(this.isDirty) calculateExtremes();

		return this.max.getX();
	}
	
	public float getMaxY()
	{
		if(this.isDirty) calculateExtremes();

		return this.max.getY();
	}
	
	public float getMaxZ()
	{
		if(this.isDirty) calculateExtremes();

		return this.max.getZ();
	}
}
