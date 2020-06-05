package org.barghos.core.util;


public interface FunctionWithException<T,R>
{
	R apply(T t) throws Exception;
}
