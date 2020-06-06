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

public class BIndexTreeNode<T,E> extends BIndexTreeComponent<T,E>
{	
	private BIndexTreeComponent<T,E> a;
	private BIndexTreeComponent<T,E> b;
	
	public void setEvaluationData(E evalData)
	{
		this.evalData = evalData;
	}

	public void setBranchA(BIndexTreeComponent<T,E> a)
	{
		this.a = a;
		this.a.setParent(this);
	}
	
	public void setBranchB(BIndexTreeComponent<T,E> b)
	{
		this.b = b;
		this.b.setParent(this);
	}
	
	public BIndexTreeComponent<T,E> getBranchA()
	{
		return this.a;
	}
	
	public BIndexTreeComponent<T,E> getBranchB()
	{
		return this.b;
	}
	
	public void updateWeight(boolean updateBranch)
	{
		int weight = 1;
		
		weight += this.a.getWeight();
		if(this.b != null) weight += this.b.getWeight();
		
		this.weight = weight;
		
		if(updateBranch)
		{
			if(hasParent())
			{
				getParent().updateWeight(true);
			}
		}
	}
}
