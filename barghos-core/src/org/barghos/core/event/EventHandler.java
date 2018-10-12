package org.barghos.core.event;

public interface EventHandler<T extends EventArgs>
{
	abstract void raise(T args);
}
