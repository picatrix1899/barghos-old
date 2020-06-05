package org.barghos.structs.indextree;

public class BIndexTreeNode<T,E> extends BIndexTreeComponent<T,E>
{	
	private BIndexTreeComponent<T,E> a;
	private BIndexTreeComponent<T,E> b;
	
	public void setEvaluationData(E evalData)
	{
		this.evalData = evalData;
	}

	public void setBranchA(BIndexTreeComponent<T,E> a)
	{
		this.a = a;
		this.a.setParent(this);
	}
	
	public void setBranchB(BIndexTreeComponent<T,E> b)
	{
		this.b = b;
		this.b.setParent(this);
	}
	
	public BIndexTreeComponent<T,E> getBranchA()
	{
		return this.a;
	}
	
	public BIndexTreeComponent<T,E> getBranchB()
	{
		return this.b;
	}
	
	public void updateWeight(boolean updateBranch)
	{
		int weight = 1;
		
		weight += this.a.getWeight();
		if(this.b != null) weight += this.b.getWeight();
		
		this.weight = weight;
		
		if(updateBranch)
		{
			if(hasParent())
			{
				getParent().updateWeight(true);
			}
		}
	}
}
