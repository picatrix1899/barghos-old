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
