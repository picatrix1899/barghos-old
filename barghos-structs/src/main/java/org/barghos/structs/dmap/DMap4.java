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

import org.barghos.structs.api.dmap.IDMap4R;
import org.barghos.structs.api.dmap.IDMap4W;

/**
 * Packet system with 3 entries
 * 
 * @author picatrix1899
 */
public class DMap4<A,B,C,D> implements IDMap4W<A,B,C,D>, IDMap4R<A,B,C,D>
{

	private volatile A a = null;
	private volatile B b = null;
	private volatile C c = null;
	private volatile D d = null;
	
	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap4() { }
	
	/**
	 * Constructor for cloning
	 * 
	 * @param dmap : The DMap for cloning
	 */
	public DMap4(IDMap4R<A,B,C,D> dmap)
	{
		this(dmap.getA(), dmap.getB(), dmap.getC(), dmap.getD());
	}
	
	/**
	 * Constructor with initial values
	 */
	public DMap4(A a, B b, C c, D d)
	{
		set(a, b, c, d);
	}

	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setA(A a) { this.a = a; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setB(B b) { this.b = b; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setC(C c) { this.c = c; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> setD(D d) { this.d = d; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> set(IDMap4R<A,B,C,D> dmap) { return set(dmap.getA(), dmap.getB(), dmap.getC(), dmap.getD()); }
	

	
	/** {@inheritDoc} **/
	@Override
	public DMap4<A,B,C,D> set(A a, B b, C c, D d) { return setA(a).setB(b).setC(c).setD(d); }
	

	
	
	
	/** {@inheritDoc} **/
	@Override
	public A getA() { return this.a; }
	
	/** {@inheritDoc} **/
	@Override
	public B getB() { return this.b; }
	
	/** {@inheritDoc} **/
	@Override
	public C getC() { return this.c; }
	
	/** {@inheritDoc} **/
	@Override
	public D getD() { return this.d; }
	
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 1;
		
		hash = 37 * hash + (this.a != null ? this.a.hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.hashCode() : 0);
		hash = 37 * hash + (this.c != null ? this.c.hashCode() : 0);
		hash = 37 * hash + (this.d != null ? this.d.hashCode() : 0);
		
		return hash;
	}
	
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "DMap4(\n" +
				this.a.toString() +
				"\n,\n" +
				this.b.toString() + 
				"\n,\n" +
				this.c.toString() + 
				"\n,\n" +
				this.d.toString() + 
				"\n)";
	}

}
