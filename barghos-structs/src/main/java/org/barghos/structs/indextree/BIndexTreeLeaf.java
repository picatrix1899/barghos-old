package org.barghos.structs.indextree;

public class BIndexTreeLeaf<T,E> extends BIndexTreeComponent<T,E>
{
	private T value;
	
	public BIndexTreeLeaf(T value, E evalData)
	{
		this.value = value;
		this.evalData = evalData;
		this.weight = 1;
	}
	
	public T getValue()
	{
		return this.value;
	}
}
