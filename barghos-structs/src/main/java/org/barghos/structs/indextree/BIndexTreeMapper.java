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
