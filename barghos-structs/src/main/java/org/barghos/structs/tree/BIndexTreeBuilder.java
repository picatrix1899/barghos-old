package org.barghos.structs.tree;


public abstract class BIndexTreeBuilder<T,E>
{
	public BIndexTree<T,E> tree;

	void setTree(BIndexTree<T,E> tree)
	{
		this.tree = tree;
	}
	
	public void add(int index, E evalData)
	{
		BIndexTreeNode<E> currentNode = this.tree;
		
		BIndexTreeLeaf<E> leaf = generateLeafFromData(index, evalData);
		
		if(currentNode.a == null)
		{
			addLeafToNode(currentNode, leaf, true);
			recalculateEvalData(currentNode);
		}
		else
		{
			addDeep(leaf, currentNode);
		}
	}
	
	public void optimize()
	{
		
	}
	
	public void remove()
	{
		
	}
	
	protected abstract void recalculateEvalData(BIndexTreeNode<E> node);
	
	protected abstract boolean isInRange(E oldEvalData, E newEvalData);
	
	protected abstract boolean getClosest(BIndexTreeContent<E> a, BIndexTreeContent<E> b, E newEvalData);
	
	public void recalculateEvalDataForBranch(BIndexTreeNode<E> node)
	{
		recalculateEvalData(node);
		
		if(node.parent != null)
		{
			recalculateEvalDataForBranch(node.parent);
		}
	}
	
	private void addLeafToNode(BIndexTreeNode<E> node, BIndexTreeLeaf<E> leaf, boolean a)
	{
		leaf.parent = node;
		
		if(a)
			node.a = leaf;
		else
			node.b = leaf;
	}
	
	private void addDeep(BIndexTreeLeaf<E> newLeaf, BIndexTreeNode<E> currentNode)
	{
		if(currentNode.b == null)
		{
			addLeafToNode(currentNode, newLeaf, false);
			recalculateEvalDataForBranch(currentNode);
		}
		else
		{
			if(isInRange(currentNode.a.evaluationData, newLeaf.evaluationData))
			{
				if(currentNode.a instanceof BIndexTreeNode)
				{
					addDeep(newLeaf, (BIndexTreeNode<E>)currentNode.a);
				}
				else
				{
					extendToNode(currentNode, newLeaf, true);
					recalculateEvalDataForBranch(currentNode);
				}
			}
			else if(isInRange(currentNode.b.evaluationData, newLeaf.evaluationData))
			{
				if(currentNode.b instanceof BIndexTreeNode)
				{
					addDeep(newLeaf, (BIndexTreeNode<E>)currentNode.b);
				}
				else
				{
					extendToNode(currentNode, newLeaf, false);
					recalculateEvalDataForBranch(currentNode);
				}
			}
			else
			{
				boolean closest = getClosest(currentNode.a, currentNode.b, newLeaf.evaluationData);
				
				BIndexTreeContent<E> closestContent = closest ? currentNode.a : currentNode.b;
				
				if(closestContent instanceof BIndexTreeNode)
				{
					addDeep(newLeaf, (BIndexTreeNode<E>)closestContent);
				}
				else
				{
					extendToNode(currentNode, newLeaf, closest);
					recalculateEvalDataForBranch(currentNode);
				}
			}
		}
	}
	
	private BIndexTreeLeaf<E> generateLeafFromData(int index, E evalData)
	{
		BIndexTreeLeaf<E> leaf = new BIndexTreeLeaf<E>();
		leaf.index = index;
		leaf.evaluationData = evalData;
		
		return leaf;
	}
	
	private void extendToNode(BIndexTreeNode<E> previousNode, BIndexTreeLeaf<E> newLeaf, boolean a)
	{
		BIndexTreeLeaf<E> currentLeaf = (BIndexTreeLeaf<E>)(a ? previousNode.a : previousNode.b);
		BIndexTreeNode<E> newNode = new BIndexTreeNode<E>();
		
		newNode.a = currentLeaf;
		newNode.b = newLeaf;
		recalculateEvalData(newNode);
		
		currentLeaf.parent = newNode;
		newNode.parent = previousNode;
		
		if(a)
			previousNode.a = newNode;
		else
			previousNode.b = newNode;
	}
}
