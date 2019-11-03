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
