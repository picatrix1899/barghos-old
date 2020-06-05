package org.barghos.core.util;


public interface SupplierWithException<R>
{
	R get() throws Exception;
}
