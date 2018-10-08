package org.barghos.structs.tree;


public class BIndexTree<T,E> extends BIndexTreeNode<E>
{
	public BTree<T,E> tree;
	
	public BIndexTreeBuilder<T,E> builder;
	public BIndexTreeWalker<T,E> walker;
	
	public BIndexTree(BTree<T,E> tree)
	{
		this.tree = tree;
	}
	
	public void add(T data, E evalData)
	{
		this.tree.add(data, evalData);
	}
	
	void broadcastAdd(int index, E evalData)
	{
  		 this.builder.add(index, evalData);
	}
	
	void setBuilder(BIndexTreeBuilder<T,E> builder)
	{
		this.builder = builder;
	}
	
	void setWalker(BIndexTreeWalker<T,E> walker)
	{
		this.walker = walker;
	}
}
