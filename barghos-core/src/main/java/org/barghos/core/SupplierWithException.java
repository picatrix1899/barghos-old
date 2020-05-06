package org.barghos.core;


public interface SupplierWithException<R>
{
	R get() throws Exception;
}
