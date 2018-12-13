package org.barghos.structs.dmaplist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.barghos.structs.dmap.DMap2;

public class DMapArrayList2<A,B> 
{

	private ArrayList<DMap2<A,B>> entries = new ArrayList<DMap2<A,B>>();
	
	public final Map<A,B> ABMapping = null;
	public final Map<B,A> BAMapping = null;
	public final List<DMap2<A,B>> ABList = null;
	public final List<A> AList = null;
	public final List<B> BList = null;
	
	public int size()
	{
		return this.entries.size();
	}
	
	public void clear()
	{
		this.entries.clear();
	}
	
	
	
	public class DMapArrayList2_DMapList implements List<DMap2<A,B>>
	{
		@Override
		public boolean add(DMap2<A,B> arg0) { return entries.add(arg0); }

		@Override
		public void add(int arg0, DMap2<A,B> arg1) { entries.add(arg0, arg1); }

		@Override
		public boolean addAll(Collection<? extends DMap2<A,B>> arg0)
		{
			return entries.addAll(arg0);
		}

		@Override
		public boolean addAll(int arg0, Collection<? extends DMap2<A,B>> arg1)
		{
			return entries.addAll(arg0, arg1);
		}

		@Override
		public void clear()
		{
			entries.clear();
		}

		@Override
		public boolean contains(Object arg0)
		{	
			return entries.contains(arg0);
		}

		@Override
		public boolean containsAll(Collection<?> arg0)
		{
			return entries.containsAll(arg0);
		}

		@Override
		public DMap2<A,B> get(int arg0)
		{
			return entries.get(arg0);
		}

		@Override
		public int indexOf(Object arg0)
		{
			return entries.indexOf(arg0);
		}

		@Override
		public boolean isEmpty()
		{
			return entries.isEmpty();
		}

		@Override
		public Iterator<DMap2<A,B>> iterator()
		{
			return entries.iterator();
		}

		@Override
		public int lastIndexOf(Object arg0)
		{
			return entries.lastIndexOf(arg0);
		}

		@Override
		public ListIterator<DMap2<A,B>> listIterator()
		{
			return entries.listIterator();
		}

		@Override
		public ListIterator<DMap2<A,B>> listIterator(int arg0)
		{
			return entries.listIterator(arg0);
		}

		@Override
		public boolean remove(Object o)
		{
			return entries.remove(o);
		}

		@Override
		public DMap2<A,B> remove(int index)
		{
			return entries.remove(index);
		}

		@Override
		public boolean removeAll(Collection<?> c)
		{
			return entries.removeAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c)
		{
			return entries.retainAll(c);
		}

		@Override
		public DMap2<A,B> set(int index, DMap2<A,B> element)
		{
			return entries.set(index, element);
		}

		@Override
		public int size()
		{
			return entries.size();
		}

		@Override
		public List<DMap2<A,B>> subList(int fromIndex, int toIndex)
		{
			return entries.subList(fromIndex, toIndex);
		}

		@SuppressWarnings("unchecked")
		@Override
		public DMap2<A,B>[] toArray()
		{
			return (DMap2<A,B>[]) entries.toArray();
		}

		@Override
		public <T> T[] toArray(T[] a)
		{
			return entries.toArray(a),
		}
	}

	
	public class DMapArrayList2_AB_Map implements Map<A,B>
	{

		@Override
		public void clear()
		{
			throw new NotImplementedException();
		}

		@Override
		public boolean containsKey(Object key)
		{
			throw new NotImplementedException();
		}

		@Override
		public boolean containsValue(Object value)
		{
			throw new NotImplementedException();
		}

		@Override
		public Set<Entry<A,B>> entrySet()
		{
			throw new NotImplementedException();
		}

		@Override
		public B get(Object key)
		{
			throw new NotImplementedException();
		}

		@Override
		public boolean isEmpty()
		{
			throw new NotImplementedException();
		}

		@Override
		public Set<A> keySet()
		{
			throw new NotImplementedException();
		}

		@Override
		public B put(A key, B value)
		{
			throw new NotImplementedException();
		}

		@Override
		public void putAll(Map<? extends A,? extends B> m)
		{
			throw new NotImplementedException();
		}

		@Override
		public B remove(Object key)
		{
			throw new NotImplementedException();
		}

		@Override
		public int size()
		{
			throw new NotImplementedException();
		}

		@Override
		public Collection<B> values()
		{
			throw new NotImplementedException();
		}
		
	}
	
	public class DMapArrayList2_BA_Map implements Map<B,A>
	{

		@Override
		public void clear()
		{
			throw new NotImplementedException();
		}

		@Override
		public boolean containsKey(Object key)
		{
			throw new NotImplementedException();
		}

		@Override
		public boolean containsValue(Object value)
		{
			throw new NotImplementedException();
		}

		@Override
		public Set<Entry<B,A>> entrySet()
		{
			throw new NotImplementedException();
		}

		@Override
		public A get(Object key)
		{
			throw new NotImplementedException();
		}

		@Override
		public boolean isEmpty()
		{
			throw new NotImplementedException();
		}

		@Override
		public Set<B> keySet()
		{
			throw new NotImplementedException();
		}

		@Override
		public A put(B key, A value)
		{
			throw new NotImplementedException();
		}

		@Override
		public void putAll(Map<? extends B,? extends A> m)
		{
			throw new NotImplementedException();
		}

		@Override
		public A remove(Object key)
		{
			throw new NotImplementedException();
		}

		@Override
		public int size()
		{
			throw new NotImplementedException();
		}

		@Override
		public Collection<A> values()
		{
			throw new NotImplementedException();
		}
		
	}
}
