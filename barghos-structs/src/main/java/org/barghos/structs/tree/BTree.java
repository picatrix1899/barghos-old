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

package org.barghos.structs.tree;

import java.util.ArrayList;

public class BTree<T,E>
{
	private ArrayList<T> elements = new ArrayList<T>();
	private ArrayList<E> elementEvalData = new ArrayList<E>();
	private ArrayList<BIndexTree<T,E>> referedTrees = new ArrayList<BIndexTree<T,E>>();
	
	public void add(T data, E evalData)
	{
		int nextIndex = this.elements.size();
		
		this.elements.add(nextIndex, data);
		this.elementEvalData.add(nextIndex, evalData);
		
		for(BIndexTree<T,E> indexTree : this.referedTrees)
		{
			indexTree.broadcastAdd(nextIndex, evalData);
		}
	}
	
	public T getElement(int index) { return this.elements.get(index); }
	
	public BIndexTree<T,E> createNewIndexTree(BIndexTreeBuilder<T,E> builder, BIndexTreeWalker<T,E> walker)
	{
		BIndexTree<T,E> indexTree = new BIndexTree<T,E>(this);
		builder.setTree(indexTree);
		walker.setTree(indexTree);
		indexTree.builder = builder;
		indexTree.walker = walker;
		
		for(int i = 0; i < this.elements.size(); i++)
		{
			indexTree.broadcastAdd(i, this.elementEvalData.get(i));
		}
		
		return indexTree;
	}
}
