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

import java.util.ArrayList;
import java.util.Iterator;

import org.barghos.structs.simpletree.TreeEvaluation;


public class BIndexTreeWalker<T,E>
{
	private BIndexTree<T,E> tree;
	private ArrayList<BIndexTreeLeaf<E>> leafes = new ArrayList<BIndexTreeLeaf<E>>();
	
	void setTree(BIndexTree<T,E> tree)
	{
		this.tree = tree;
	}
	
	public ArrayList<Integer> walk(TreeEvaluation<E> evaluation)
	{
		ArrayList<BIndexTreeLeaf<E>> leafes = walkToLeaf(evaluation);
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(BIndexTreeLeaf<E> leaf : leafes)
			out.add(leaf.index);
			
		return out;
	}
	
	public ArrayList<BIndexTreeLeaf<E>> walkToLeaf(TreeEvaluation<E> evaluation)
	{
		BIndexTreeNode<E> node = this.tree;
		
		ArrayList<BIndexTreeLeaf<E>> out = new ArrayList<BIndexTreeLeaf<E>>();
		
		if(node.a == null) return out;
		
		walkDeep(out, node, evaluation);
		
		return out;
	}
	
	public void walkDeep(ArrayList<BIndexTreeLeaf<E>> list, BIndexTreeNode<E> node, TreeEvaluation<E> evaluation)
	{
		if(evaluation.eval(node.a.evaluationData))
		{
			if(node.a instanceof BIndexTreeNode)
			{
				walkDeep(list, (BIndexTreeNode<E>)node.a, evaluation);
			}
			else
			{
				list.add((BIndexTreeLeaf<E>)node.a);
			}
		}
		
		if(node.b != null)
		{
			if(evaluation.eval(node.b.evaluationData))
			{
				if(node.b instanceof BIndexTreeNode)
				{
					walkDeep(list, (BIndexTreeNode<E>)node.b, evaluation);
				}
				else
				{
					list.add((BIndexTreeLeaf<E>)node.b);
				}
			}
		}
	}
	
	public void refreshLeafList()
	{
		this.leafes = new ArrayList<BIndexTreeLeaf<E>>();
		
		if(this.tree.a != null)
			iterativeWalk(leafes, this.tree);
	}
	
	public Iterator<BIndexTreeLeaf<E>> leafIterator()
	{
		return this.leafes.iterator();
	}
	
	private void iterativeWalk(ArrayList<BIndexTreeLeaf<E>> leafes, BIndexTreeNode<E> currentNode)
	{
		if(currentNode.a instanceof BIndexTreeNode)
		{
			iterativeWalk(leafes, (BIndexTreeNode<E>)currentNode.a);
		}
		else
		{
			leafes.add((BIndexTreeLeaf<E>)currentNode.a);
		}
		if(currentNode.b != null)
		{
			if(currentNode.b instanceof BIndexTreeNode)
			{
				iterativeWalk(leafes, (BIndexTreeNode<E>)currentNode.b);
			}
			else
			{
				leafes.add((BIndexTreeLeaf<E>)currentNode.b);
			}
		}
	}
}
