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

import org.barghos.structs.api.dmap.IDMap2R;
import org.barghos.structs.api.dmap.IDMap2W;

/**
 * Packet system with 2 entries
 * @author picatrix1899
 * @category DMaps
 */
public class DMap2<A,B> implements IDMap2W<A,B>, IDMap2R<A,B>
{
	
	
	private volatile A a = null;
	private volatile B b = null;

	
	
	/**
	 * "Null" constructor <br>
	 * initialize all entries with null
	 */
	public DMap2() { }
	/**
	 * Constructor for cloning
	 * @param dmap : The DMap for cloning
	 */
	public DMap2(IDMap2R<A,B> dmap) { this(dmap.getA(), dmap.getB()); }
	
	/**
	 * Constructor with initial values
	 *  @param a : Value a
	 *  @param b : Value b
	 */
	public DMap2(A a, B b) { set(a, b); }

	
	
	/** {@inheritDoc} **/
	@Override
	public DMap2<A,B> setA(A a) { this.a = a; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap2<A,B> setB(B b) { this.b = b; return this; }
	
	/** {@inheritDoc} **/
	@Override
	public DMap2<A,B> set(IDMap2R<A,B> dmap) { return set(dmap.getA(), dmap.getB()); }
	
	/** {@inheritDoc} **/
	@Override
	public DMap2<A,B> set(A a, B b) { return setA(a).setB(b); }
	


	
	
	
	/** {@inheritDoc} */
	@Override
	public A getA() { return this.a; }
	
	/** {@inheritDoc} */
	@Override
	public B getB() { return this.b; }
	
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode()
	{
		int hash = 0;
		
		hash = 37 * hash + (this.a != null ? this.a.hashCode() : 0);
		hash = 37 * hash + (this.b != null ? this.b.hashCode() : 0);
		
		return hash;
	}
	
	
	/** {@inheritDoc} */
	@Override
	public String toString()
	{
		return "DMap2(\n" +
				this.a.toString() +
				"\n,\n" +
				this.b.toString() + 
				"\n)";
	}
	
}
