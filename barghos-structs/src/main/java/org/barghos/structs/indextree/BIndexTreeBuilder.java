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
