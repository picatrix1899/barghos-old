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
