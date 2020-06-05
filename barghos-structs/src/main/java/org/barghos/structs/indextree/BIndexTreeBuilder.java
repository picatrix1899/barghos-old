package org.barghos.structs.indextree;

public abstract class BIndexTreeBuilder<T,P,E>
{
	public void add(BIndexDataTree<T,E> source, T value, P evalData)
	{
		BIndexTreeLeaf<T,E> leaf = new BIndexTreeLeaf<>(value, getData(evalData));
		addDeep(leaf, source);
	}
	
	protected abstract E getData(P provider);
	
	protected abstract void recalculateEvalData(BIndexTreeNode<T,E> node);
	
	protected abstract boolean contains(E nodeData, E compareData);
	
	protected abstract boolean getClosest(BIndexTreeComponent<T,E> a, BIndexTreeComponent<T,E> b, E newEvalData);
	
	public void recalculateEvalDataForBranch(BIndexTreeNode<T,E> node)
	{
		recalculateEvalData(node);
		
		if(node.hasParent()) recalculateEvalDataForBranch(node.getParent());
	}
	
	private void addDeep(BIndexTreeLeaf<T,E> newLeaf, BIndexTreeNode<T,E> currentNode)
	{
		if(currentNode.getBranchA() == null)
		{
			currentNode.setBranchA(newLeaf);
			recalculateEvalDataForBranch(currentNode);
			return;
		}
		
		if(currentNode.getBranchA() != null && contains(currentNode.getBranchA().evalData, newLeaf.evalData))
		{
			if(currentNode.getBranchA() instanceof BIndexTreeNode)
			{
				addDeep(newLeaf, (BIndexTreeNode<T,E>)currentNode.getBranchA());
				return;
			}

			extendToNode(currentNode, newLeaf, true);
			recalculateEvalDataForBranch(currentNode);
			return;
		}
		
		if(currentNode.getBranchB() == null)
		{
			currentNode.setBranchB(newLeaf);
			recalculateEvalDataForBranch(currentNode);
			return;
		}
		
		if(currentNode.getBranchB() != null && contains(currentNode.getBranchB().evalData, newLeaf.evalData))
		{
			if(currentNode.getBranchB() instanceof BIndexTreeNode)
			{
				addDeep(newLeaf, (BIndexTreeNode<T,E>)currentNode.getBranchB());
				return;
			}

			extendToNode(currentNode, newLeaf, false);
			recalculateEvalDataForBranch(currentNode);
			return;
		}
			
		boolean closest = getClosest(currentNode.getBranchA(), currentNode.getBranchB(), newLeaf.evalData);
		
		BIndexTreeComponent<T,E> closestContent = closest ? currentNode.getBranchA() : currentNode.getBranchB();
		
		if(closestContent instanceof BIndexTreeNode)
		{
			addDeep(newLeaf, (BIndexTreeNode<T,E>)closestContent);
			return;
		}
		
		extendToNode(currentNode, newLeaf, closest);
		recalculateEvalDataForBranch(currentNode);
	}
	
	private void extendToNode(BIndexTreeNode<T,E> previousNode, BIndexTreeLeaf<T,E> newLeaf, boolean a)
	{
		BIndexTreeLeaf<T,E> currentLeaf = (BIndexTreeLeaf<T,E>)(a ? previousNode.getBranchA() : previousNode.getBranchB());
		BIndexTreeNode<T,E> newNode = new BIndexTreeNode<>();
		
		newNode.setBranchA(currentLeaf);
		newNode.setBranchB(newLeaf);
		
		recalculateEvalData(newNode);

		if(a)
			previousNode.setBranchA(newNode);
		else
			previousNode.setBranchB(newNode);
	}
}
