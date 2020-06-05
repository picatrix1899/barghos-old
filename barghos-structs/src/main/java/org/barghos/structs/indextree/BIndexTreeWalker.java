package org.barghos.structs.indextree;

import java.util.ArrayList;
import java.util.List;

public class BIndexTreeWalker<T,P,E>
{
	private TreeEvaluation<E> evalStrategy;
	
	public BIndexTreeWalker(TreeEvaluation<E> strategy)
	{
		this.evalStrategy = strategy;
	}

	public List<T> get(BIndexDataTree<T,E> source, E base)
	{
		if(source.getBranchA() == null) return new ArrayList<>();
		
		ArrayList<BIndexTreeLeaf<T,E>> leafes = new ArrayList<>();
		
		walkDeep(source, base, leafes, source);
		
		ArrayList<T> out = new ArrayList<>();
		
		for(BIndexTreeLeaf<T,E> leaf : leafes)
			out.add(leaf.getValue());
			
		return out;
	}
	
	public void walkDeep(BIndexDataTree<T,E> source, E base, List<BIndexTreeLeaf<T,E>> list, BIndexTreeNode<T,E> node)
	{
		if(evalStrategy.eval(node.getBranchA().evalData, base))
		{
			if(node.getBranchA() instanceof BIndexTreeNode)
			{
				walkDeep(source, base, list, (BIndexTreeNode<T,E>)node.getBranchA());
			}
			else
			{
				list.add((BIndexTreeLeaf<T,E>)node.getBranchA());
			}
		}
		
		if(node.getBranchB() != null)
		{
			if(evalStrategy.eval(node.getBranchB().evalData, base))
			{
				if(node.getBranchB() instanceof BIndexTreeNode)
				{
					walkDeep(source, base, list, (BIndexTreeNode<T,E>)node.getBranchB());
				}
				else
				{
					list.add((BIndexTreeLeaf<T,E>)node.getBranchB());
				}
			}
		}
	}
}
