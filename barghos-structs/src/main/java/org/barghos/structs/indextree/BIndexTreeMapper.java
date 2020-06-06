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

public class BIndexTreeMapper
{
	public String map(BIndexTree<?,?,?> tree)
	{
		BIndexDataTree<?,?> root = tree.getDataTree();
		StringBuilder builder = new StringBuilder();
		
		builder.append("BIndexTree: [\n");
		
		if(root.getBranchA() == null)
		{
			builder.append(" A:\n");
			builder.append(" B:\n");
		}
		else
		{
			iterativeMap(root, builder, 1);
		}
		
		builder.append("]\n");
		return builder.toString();
	}
	
	public void iterativeMap(BIndexTreeComponent<?,?> c, StringBuilder builder, int indent)
	{
		String spacing = " ".repeat(indent);
		
		if(c instanceof BIndexTreeLeaf)
		{
			BIndexTreeLeaf<?,?> leaf = (BIndexTreeLeaf<?,?>)c;
			builder.append(spacing + "Leaf: " + leaf.evalData.toString() + " -> " + leaf.getValue().toString() + "\n");
		}
		else
		{
			BIndexTreeNode<?,?> node = (BIndexTreeNode<?,?>)c;
			builder.append(spacing + "Node: " + node.getEvaluationData() + "\n");
			builder.append(spacing + "A:\n");
			if(node.getBranchA() != null) iterativeMap(node.getBranchA(), builder, indent + 1);
			builder.append(spacing + "B:\n");
			if(node.getBranchB() != null) iterativeMap(node.getBranchB(), builder, indent + 1);
		}
	}
}
