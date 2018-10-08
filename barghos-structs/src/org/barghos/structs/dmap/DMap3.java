
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
