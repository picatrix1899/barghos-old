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

package org.barghos.structs.simpletree.btree;

public abstract class BTreeBuilder<T,E>
{
	protected BTree<T,E> tree;
	
	public BTreeBuilder(BTree<T,E> tree)
	{
		this.tree = tree;
	}

	public void add(T data, E evalData)
	{
		BTreeNode<T,E> currentNode = this.tree;
		
		BTreeLeaf<T,E> leaf = generateLeafFromData(data, evalData);
		
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
	
	protected abstract void recalculateEvalData(BTreeNode<T,E> node);
	
	protected abstract boolean isInRange(E oldEvalData, E newEvalData);
	
	protected abstract boolean getClosest(BTreeContent<T,E> a, BTreeContent<T,E> b, E newEvalData);
	
	public void recalculateEvalDataForBranch(BTreeNode<T,E> node)
	{
		recalculateEvalData(node);
		
		if(node.parent != null)
		{
			recalculateEvalDataForBranch(node.parent);
		}
	}
	
	private void addLeafToNode(BTreeNode<T,E> node, BTreeLeaf<T,E> leaf, boolean a)
	{
		leaf.parent = node;
		
		if(a)
			node.a = leaf;
		else
			node.b = leaf;
	}
	
	private void addDeep(BTreeLeaf<T,E> newLeaf, BTreeNode<T,E> currentNode)
	{
		if(currentNode.b == null)
		{
			addLeafToNode(currentNode, newLeaf, false);
			recalculateEvalDataForBranch(currentNode);
		}
		else
		{
			if(isInRange(currentNode.a.evalData, newLeaf.evalData))
			{
				if(currentNode.a instanceof BTreeNode)
				{
					addDeep(newLeaf, (BTreeNode<T,E>)currentNode.a);
				}
				else
				{
					extendToNode(currentNode, newLeaf, true);
					recalculateEvalDataForBranch(currentNode);
				}
			}
			else if(isInRange(currentNode.b.evalData, newLeaf.evalData))
			{
				if(currentNode.b instanceof BTreeNode)
				{
					addDeep(newLeaf, (BTreeNode<T,E>)currentNode.b);
				}
				else
				{
					extendToNode(currentNode, newLeaf, false);
					recalculateEvalDataForBranch(currentNode);
				}
			}
			else
			{
				boolean closest = getClosest(currentNode.a, currentNode.b, newLeaf.evalData);
				
				BTreeContent<T,E> closestContent = closest ? currentNode.a : currentNode.b;
				
				if(closestContent instanceof BTreeNode)
				{
					addDeep(newLeaf, (BTreeNode<T,E>)closestContent);
				}
				else
				{
					extendToNode(currentNode, newLeaf, closest);
					recalculateEvalDataForBranch(currentNode);
				}
			}
		}
	}
	
	private BTreeLeaf<T,E> generateLeafFromData(T data, E evalData)
	{
		BTreeLeaf<T,E> leaf = new BTreeLeaf<T,E>();
		leaf.data = data;
		leaf.evalData = evalData;
		
		return leaf;
	}
	
	private void extendToNode(BTreeNode<T,E> previousNode, BTreeLeaf<T,E> newLeaf, boolean a)
	{
		BTreeLeaf<T,E> currentLeaf = (BTreeLeaf<T,E>)(a ? previousNode.a : previousNode.b);
		BTreeNode<T,E> newNode = new BTreeNode<T,E>();
		
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
