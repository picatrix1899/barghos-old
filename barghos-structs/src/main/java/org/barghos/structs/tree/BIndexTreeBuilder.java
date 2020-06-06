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
