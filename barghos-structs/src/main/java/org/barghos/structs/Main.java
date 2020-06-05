package org.barghos.structs;

import org.barghos.structs.indextree.BIndexSourceTree;
import org.barghos.structs.indextree.BIndexTree;
import org.barghos.structs.indextree.BIndexTreeBuilder;
import org.barghos.structs.indextree.BIndexTreeComponent;
import org.barghos.structs.indextree.BIndexTreeMapper;
import org.barghos.structs.indextree.BIndexTreeNode;
import org.barghos.structs.indextree.BIndexTreeWalker;
import org.barghos.structs.indextree.TreeEvaluation;

public class Main
{

	public static void main(String[] args)
	{
		BIndexSourceTree<String,Test> source = new BIndexSourceTree<>();
		
		BIndexTree<String,Test,Test> tree = source.generateNewTree(new TreeBuilder(), new TreeWalker());
		
		source.add("Test1", new Test(1, 5));
		source.add("Test2", new Test(7, 10));
		source.add("Test3", new Test(3, 6));
		source.add("Test4", new Test(1, 3));
		
		System.out.println(new BIndexTreeMapper().map(tree));
		
		System.out.println(tree.get(new Test(1, 3)));
	}

	static class TreeWalker extends BIndexTreeWalker<String,Test,Test>
	{

		public TreeWalker()
		{
			super(new TreeEvaluation<Test>() {

				public boolean eval(Test data, Test compareData)
				{
					return (compareData.min <= data.min && compareData.max >= data.min) || (compareData.min <= data.max && compareData.max >= data.max);
				}
				
			});
		}

	}
	
	static class TreeBuilder extends BIndexTreeBuilder<String,Test,Test>
	{

		protected Test getData(Test provider)
		{
			return provider;
		}

		protected void recalculateEvalData(BIndexTreeNode<String,Test> node)
		{
			if(node.getEvaluationData() == null)
			{
				node.setEvaluationData(new Test(node.getBranchA().getEvaluationData().min, node.getBranchA().getEvaluationData().max));
			}

			if(node.getBranchA() != null)
			{
				node.getEvaluationData().min = Math.min(node.getEvaluationData().min , node.getBranchA().getEvaluationData().min);
				node.getEvaluationData().max = Math.max(node.getEvaluationData().max, node.getBranchA().getEvaluationData().max);
			}
			if(node.getBranchB() != null)
			{
				node.getEvaluationData().min = Math.min(node.getEvaluationData().min , node.getBranchB().getEvaluationData().min);
				node.getEvaluationData().max = Math.max(node.getEvaluationData().max, node.getBranchB().getEvaluationData().max);
			}
		}

		protected boolean contains(Test nodeData, Test compareData)
		{
			return (compareData.min < nodeData.min && compareData.max > nodeData.min) || (compareData.min < nodeData.max && compareData.max > nodeData.max);
		}

		protected boolean getClosest(BIndexTreeComponent<String,Test> a, BIndexTreeComponent<String,Test> b, Test newEvalData)
		{
			int minEA = a.getEvaluationData().min - newEvalData.min;
			int minEB = b.getEvaluationData().min - newEvalData.min;
			
			int maxEA = a.getEvaluationData().max - newEvalData.max;
			int maxEB = b.getEvaluationData().max - newEvalData.max;

			int smallest = minEA;
			boolean out = true;
			
			if(minEB < smallest)
			{
				smallest = minEB;
				out = false;
			}
			
			if(maxEA < smallest)
			{
				smallest = maxEA;
				out = true;
			}
			
			if(maxEB < smallest)
			{
				smallest = maxEB;
				out = false;
			}
			
			return out;
		}


	}
	
	static class Test
	{
		public int min;
		public int max;
		
		public Test()
		{
			
		}
		
		public Test(int min, int max)
		{
			this.min = min;
			this.max = max;
		}
		
		public String toString()
		{
			return "Test(min: " + min + ", max: " + max + ")";
		}
	}
}
