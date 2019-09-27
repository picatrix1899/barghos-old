package org.barghos.core;


public interface FunctionWithException<T,R>
{
	R apply(T t) throws Exception;
}
