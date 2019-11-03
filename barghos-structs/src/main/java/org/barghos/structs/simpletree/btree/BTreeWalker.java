package org.barghos.structs.simpletree.btree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.barghos.structs.simpletree.TreeEvaluation;


public class BTreeWalker<T,E>
{
	private BTree<T,E> tree;
	private ArrayList<BTreeLeaf<T,E>> leafes;
	private ArrayList<T> values;
	
	public BTreeWalker(BTree<T,E> tree)
	{
		this.tree = tree;
		this.leafes = new ArrayList<BTreeLeaf<T,E>>();
		this.values = new ArrayList<T>();
	}
	
	public ArrayList<T> walk(TreeEvaluation<E> evaluation)
	{
		ArrayList<BTreeLeaf<T,E>> leafes = walkToLeaf(evaluation);
		ArrayList<T> out = new ArrayList<T>();
		
		for(BTreeLeaf<T,E> leaf : leafes)
			out.add(leaf.data);
			
		return out;
	}
	
	public List<T> getValueList()
	{
		return this.values;
	}
	
	public ArrayList<BTreeLeaf<T,E>> walkToLeaf(TreeEvaluation<E> evaluation)
	{
		BTreeNode<T,E> node = this.tree;
		
		ArrayList<BTreeLeaf<T,E>> out = new ArrayList<BTreeLeaf<T,E>>();
		
		if(node.a == null) return out;
		
		walkDeep(out, node, evaluation);
		
		return out;
	}
	
	public void walkDeep(ArrayList<BTreeLeaf<T,E>> list, BTreeNode<T,E> node, TreeEvaluation<E> evaluation)
	{
		if(evaluation.eval(node.a.evalData))
		{
			if(node.a instanceof BTreeNode)
			{
				walkDeep(list, (BTreeNode<T,E>)node.a, evaluation);
			}
			else
			{
				list.add((BTreeLeaf<T,E>)node.a);
			}
		}
		
		if(node.b != null)
		{
			if(evaluation.eval(node.b.evalData))
			{
				if(node.b instanceof BTreeNode)
				{
					walkDeep(list, (BTreeNode<T,E>)node.b, evaluation);
				}
				else
				{
					list.add((BTreeLeaf<T,E>)node.b);
				}
			}
		}
	}
	
	public void refreshLeafList()
	{
		this.leafes = new ArrayList<BTreeLeaf<T,E>>();
		
		if(this.tree.a != null)
			iterativeWalk(leafes, this.tree);
	}
	
	public Iterator<BTreeLeaf<T,E>> leafIterator()
	{
		return this.leafes.iterator();
	}

	public Iterator<T> valueIterator()
	{
		return this.values.iterator();
	}
	
	private void iterativeWalk(ArrayList<BTreeLeaf<T,E>> leafes, BTreeNode<T,E> currentNode)
	{
		if(currentNode.a instanceof BTreeNode)
		{
			iterativeWalk(leafes, (BTreeNode<T,E>)currentNode.a);
		}
		else
		{
			leafes.add((BTreeLeaf<T,E>)currentNode.a);
			values.add(((BTreeLeaf<T,E>)currentNode.a).data);
		}
		if(currentNode.b != null)
		{
			if(currentNode.b instanceof BTreeNode)
			{
				iterativeWalk(leafes, (BTreeNode<T,E>)currentNode.b);
			}
			else
			{
				leafes.add((BTreeLeaf<T,E>)currentNode.b);
				values.add(((BTreeLeaf<T,E>)currentNode.b).data);
			}
		}
	}
}
