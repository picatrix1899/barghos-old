# Vec3f

## Description

The Vec3f represents a mathematical three dimensional vector. The class provides a wide range of common operations for three dimensional vectors.

## Contents

[Arithmetical Operations](#arithmetical_operations)

## Arithmetical Operations

### Add (Static)

Adds two vectors or any kind of three dimensional tuple together and optionally safes the result in a vector as querry input `res`. If the querry input `res` is `null` a new instance of Vec3f with the resulting values is generated instead. The result vector is then returned. It can be either the querry input `res` or the newly generated Vec3f.

#### Add without querry input

Adds `v1` and `v2` together and returns a new Vec3f with the resulting values.

```java
Vec3f v1 = new Vec3f(1,0,0);
Vec3f v2 = new Vec3f(2,1,4);

Vec3f res = Vec3f.add(v1, v2, null);

/*
v1 = (1,0,0)
v2 = (2,1,4)
res = (3,1,4)
*/
```

#### Add with querry input

Adds `v1` and `v2` together and safes the result in `v3`. It then returns `v3`.

```java
Vec3f v1 = new Vec3f(1,0,0),
Vec3f v2 = new Vec3f(2,1,4);
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(v1, v2, v3);

/*
v1 = (1,0,0)
v2 = (2,1,4)
v3 = (3,1,4)
res = v3
*/
```
