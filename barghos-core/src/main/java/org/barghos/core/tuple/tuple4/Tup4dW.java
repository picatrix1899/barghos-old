package org.barghos.core.tuple.tuple4;


public interface Tup4dW
{
	Tup4dW setX(double x);
	Tup4dW setY(double y);
	Tup4dW setZ(double z);
	Tup4dW setW(double w);
	
	Tup4dW set(Tup4dR t);
	Tup4dW set(double x, double y, double z, double w);
}
