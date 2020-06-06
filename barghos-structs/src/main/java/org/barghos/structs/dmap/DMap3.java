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

package org.barghos.structs.dmap;

import org.barghos.structs.api.dmap.IDMap3R;
import org.barghos.structs.api.dmap.IDMap3W;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap3<A,B,C> implements IDMap3W<A,B,C>, IDMap3R<A,B,C>
{
	
	private volatile A a = null;
	private volatile B b = null;
	private volatile C c = null;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap3() { }
	
	/**
	 * Constructor for cloning
	 * 
	 * @param dmap : The DMap for cloning
	 */
	public DMap3(IDMap3R<A,B,C> dmap) { this(dmap.getA(), dmap.getB(), dmap.getC()); }
	
	/**
	 * Constructor with initial values
	 */
	public DMap3(A a, B b, C c) { set(a, b, c); }

	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> setA(A a) { this.a = a; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> setB(B b) { this.b = b; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> setC(C c) { this.c = c; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> set(IDMap3R<A,B,C> dmap) { return set(dmap.getA(), dmap.getB(), dmap.getC()); }

	/** {@inheritDoc} **/
	@Override
	public DMap3<A,B,C> set(A a, B b, C c) { return setA(a).setB(b).setC(c); }


	
	/** {@inheritDoc} */
	@Override
	public A getA() { return this.a; }
	
	/** {@inheritDoc} */
	@Override
	public B getB() { return this.b; }
	
	/** {@inheritDoc} */
	@Override
	public C getC() { return this.c; }
	
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 0;
		
		hash = 37 * hash + (this.a != null ? this.a.hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.hashCode() : 0);
		hash = 37 * hash + (this.c != null ? this.c.hashCode() : 0);
		
		return hash;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "DMap3(\n" +
				this.a.toString() +
				"\n,\n" +
				this.b.toString() + 
				"\n,\n" +
				this.c.toString() + 
				"\n)";
	}

}
