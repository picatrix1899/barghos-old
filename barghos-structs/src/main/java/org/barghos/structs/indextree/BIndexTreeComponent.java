package org.barghos.structs.indextree;

public class BIndexTreeComponent<T,E>
{
	private BIndexTreeNode<T,E> parent;
	protected E evalData;
	
	protected int weight;
	
	public BIndexTreeComponent() { }
	
	public BIndexTreeComponent(E evalData)
	{
		this.evalData = evalData;
	}
	
	public E getEvaluationData()
	{
		return this.evalData;
	}
	
	public BIndexTreeNode<T,E> getParent()
	{
		return this.parent;
	}
	
	public void setParent(BIndexTreeNode<T,E> parent)
	{
		this.parent = parent;
	}
	
	public boolean hasParent()
	{
		return this.parent != null;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
}
