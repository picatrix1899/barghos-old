package org.barghos.math.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.barghos.math.matrix.Mat4f;
import org.barghos.math.point.Point3f;

public class PointSet3f implements FiniteGeometricObject
{
	private List<Point3f> points = new ArrayList<>();
	private float minX;
	private float minY;
	private float minZ;
	private float maxX;
	private float maxY;
	private float maxZ;
	
	private boolean isDirty;
	
	public PointSet3f() {}
	
	public PointSet3f(PointSet3f set)
	{
		assert(set != null);
		set(set);
	}
	
	public PointSet3f(Point3f... points)
	{
		assert(points != null);
		assert(points.length > 0);
		
		set(points);
	}
	
	public PointSet3f(Collection<Point3f> c)
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
	
	public PointSet3f set(Point3f...points)
	{
		assert(points != null);
		assert(points.length > 0);
		
		this.points.clear();
		
		for(int i = 0; i < points.length; i++)
			this.points.add(points[i]);
		
		this.isDirty = true;
		
		return this;
	}

	public PointSet3f set(Collection<Point3f> c)
	{
		assert(c != null);
		this.points.clear();
		this.points.addAll(c);
		
		this.isDirty = true;
		return this;
	}
	
	public PointSet3f add(Point3f... points)
	{
		assert(points != null);
		assert(points.length > 0);
		
		for(int i = 0; i < points.length; i++)
			this.points.add(points[i]);
		
		this.isDirty = true;
		
		return this;
	}
	
	public PointSet3f add(Collection<Point3f> c)
	{
		assert(c != null);
		this.points.addAll(c);
		this.isDirty = true;
		return this;
	}
	
	public PointSet3f transform(Mat4f t)
	{
		Point3f[] p = new Point3f[this.points.size()];
		
		for(int i = 0; i < this.points.size(); i++)
			p[i] = t.transform(this.points.get(i), (Point3f)null);
		
		return set(p);
	}
	
	public PointSet3f transform(Mat4f t, PointSet3f res)
	{
		res = res != null ? res : new PointSet3f();
		
		Point3f[] p = new Point3f[this.points.size()];
		
		for(int i = 0; i < this.points.size(); i++)
			p[i] = t.transform(this.points.get(i), (Point3f)null);
		
		return res.set(p);
	}
	
	public PointSet3f getPointSet()
	{
		return new PointSet3f(this);
	}
	
	public Point3f[] getPoints()
	{
		return this.points.toArray(new Point3f[this.points.size()]);
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
		
		Point3f current;
		
		for(int i = 0; i < this.points.size(); i++)
		{
			current = this.points.get(i);
			
			if(current.x < minX)
				minX = current.x;
			
			if(current.y < minY)
				minY = current.y;
			
			if(current.z < minZ)
				minZ = current.z;
			
			if(current.x > maxX)
				maxX = current.x;
			
			if(current.y > maxY)
				maxY = current.y;
			
			if(current.z > maxZ)
				maxZ = current.z;
		}
		
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
		
		this.isDirty = false;
	}
	
	public float getMinX()
	{
		if(this.isDirty) calculateExtremes();

		return this.minX;
	}
	
	public float getMinY()
	{
		if(this.isDirty) calculateExtremes();

		return this.minY;
	}
	
	public float getMinZ()
	{
		if(this.isDirty) calculateExtremes();
		
		return this.minZ;
	}
	
	public float getMaxX()
	{
		if(this.isDirty) calculateExtremes();

		return this.maxX;
	}
	
	public float getMaxY()
	{
		if(this.isDirty) calculateExtremes();

		return this.maxY;
	}
	
	public float getMaxZ()
	{
		if(this.isDirty) calculateExtremes();

		return this.maxZ;
	}
}
