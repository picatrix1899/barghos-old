package org.barghos.structs.indextree;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BIndexSourceTree<T,P>
{
	private List<Entry> data = new ArrayList<>();
	
	private List<WeakReference<BIndexTree<T,P,?>>> trees = new ArrayList<>();

	public void add(T value, P provider)
	{
		trees.removeIf((element) -> element.get() == null);
		
		this.data.add(new Entry(value, provider));
		
		for(WeakReference<BIndexTree<T,P,?>> tree : trees) 
		{
			BIndexTree<T,P,?> t = tree.get();
			if(t != null)
			{
				t.add(value, provider, false);
			}
		}
	}
	
	public void add(T value, P provider, BIndexTree<T,P,?> origin)
	{
		trees.removeIf((element) -> element.get() == null);
		
		this.data.add(new Entry(value, provider));
		
		for(WeakReference<BIndexTree<T,P,?>> tree : trees) 
		{
			BIndexTree<T,P,?> t = tree.get();
			if(t != null)
			{
				if(!t.equals(origin))
				{
					t.add(value, provider, false);
				}
			}
		}
	}
	
	public T get(int index)
	{
		return this.data.get(index).value;
	}
	
	public <E> BIndexTree<T,P,E> generateNewTree(BIndexTreeBuilder<T,P,E> builder, BIndexTreeWalker<T,P,E> walker)
	{
		BIndexTree<T,P,E> tree = new BIndexTree<>(builder, walker, this);
		
		this.trees.add(new WeakReference<>(tree));
		
		return tree;
	}
	
	public Iterator<Entry> iterator()
	{
		return this.data.iterator();
	}
	
	final class Entry
	{
		private Entry(T value, P provider)
		{
			this.value = value;
			this.evalDataProvider = provider;
		}
		
		T value;
		P evalDataProvider;
	}
}
