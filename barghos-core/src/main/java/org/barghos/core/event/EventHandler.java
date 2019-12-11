package org.barghos.core.event;

public interface EventHandler<T>
{
	abstract void raise(T args);
}
