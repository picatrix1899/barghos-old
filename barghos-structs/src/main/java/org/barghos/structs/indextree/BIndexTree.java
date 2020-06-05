package org.barghos.structs.indextree;

import java.util.Iterator;
import java.util.List;

public class BIndexTree<T,P,E>
{
	private BIndexSourceTree<T,P> source;
	private BIndexTreeBuilder<T,P,E> builder;
	private BIndexTreeWalker<T,P,E> walker;
	private BIndexDataTree<T,E> tree;
	
	public BIndexTree(BIndexTreeBuilder<T,P,E> builder, BIndexTreeWalker<T,P,E> walker, BIndexSourceTree<T,P> source)
	{
		this.source = source;
		this.builder = builder;
		this.walker = walker;
		this.tree = new BIndexDataTree<>();
		createFromExistingTree();
	}
	
	public void add(T value, P provider)
	{
		this.builder.add(this.tree, value, provider);
		
		this.source.add(value, provider);
	}

	public void add(T value, P provider, boolean distribute)
	{
		this.builder.add(this.tree, value, provider);
		
		if(distribute) this.source.add(value, provider);
	}
	
	public List<T> get(E base)
	{
		return walker.get(this.tree, base);
	}
	
	public BIndexDataTree<T,E> getDataTree()
	{
		return this.tree;
	}
	
	public void createFromExistingTree()
	{
		Iterator<BIndexSourceTree<T,P>.Entry> it = this.source.iterator();
		for(BIndexSourceTree<T,P>.Entry entry = null; it.hasNext(); entry = it.next())
			this.builder.add(this.tree, entry.value, entry.evalDataProvider);
	}
}
