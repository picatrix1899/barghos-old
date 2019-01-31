# Querry Input

A querry input is a special parameter in a function. If a function would normally need to return a new instance of something ( e.g.
the cross-product function of a three dimensional vector), the calling function has no way to use own instance management.
The querry input is usually the same type as the return value of the function and is used as a container for the result of the function.
With this the calling method has full control over instance management. If the querry input is `null` a new instance of the corresponding
type is generated.

Vec3f.java
```java
public static Vec3f add(ITup3R v1, ITup3R v2, Vec3f res) // v3 is a querry input
{
	res = res != null ? res : new Vec3f();
	res.set(v1.getUniX() + v2.getUniX(), v1.getUniY() + v2.getUniY(), v1.getUniZ() + v2.getUniZ());
	return res;
}
```
