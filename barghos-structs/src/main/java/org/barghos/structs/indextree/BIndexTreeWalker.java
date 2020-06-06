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
