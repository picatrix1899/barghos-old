# Vec3f

## Description

The Vec3f represents a mathematical three dimensional vector. The class provides a wide range of common operations for three dimensional vectors.

## Contents

* [Static Arithmetical Operations](#static-arithmetical-operations)
	* [Add](#add-static)
		* [Add (vector + vector) without quarry input](add-vector--vector-without-quarry-input)
		* [Add (vector + vector) with quarry input](add-vector--vectory-with-quarry-input)
		* [Add (vector + value) without quarry input](add-vector--value-without-quarry-input)
		* [Add (vector + value) with quarry input](add-vector--value-with-quarry-input)
		
## Static Arithmetical Operations

### Add (Static)

Adds two vectors or any kind of three dimensional tuple together and optionally safes the result in a vector as [Querry Input](QuerryInput.md). The result vector is then returned. It can be either the [Querry Input](QuerryInput.md) `res` or the newly generated [Vec3f](Vec3f.md).

#### Add (vector + vector) without querry input 

Adds `v1` and `v2` together and safes and returns the result in a new [Vec3f](Vec3f.md).

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

#### Add (vector + vector) with querry input

Adds `v1` and `v2` together and safes and returns the result in the [Querry Input](QuerryInput.md) `v3`.

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

#### Add (vector + value) without querry input

Adds to every component in `v1` the value of `scalar` and safes and returns the result in a new [Vec3f](Vec3f.md).

```java
Vec3f v1 = new Vec3f(1,0,0);
float scalar = 3;

Vec3f res = Vec3f.add(v1, scalar, null);

/*
v1 = (1,0,0)
scalar = 3
res = (4,3,3)
*/
```

```java
Vec3f v1 = new Vec3f(1,0,0);
double scalar = 3;

Vec3f res = Vec3f.add(v1, scalar, null);

/*
v1 = (1,0,0)
scalar = 3
res = (4,3,3)
*/
```

#### Add (vector + value) with querry input

Adds to every component in `v1` the value of `scalar` and safes and returns the result in the [Querry Input](QuerryInput.md) `v3`.

```java
Vec3f v1 = new Vec3f(1,0,0);
float scalar = 3;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(v1, scalar, v3);

/*
v1 = (1,0,0)
scalar = 3
v3 = (4,3,3)
res = v3
*/
```

```java
Vec3f v1 = new Vec3f(1,0,0);
double scalar = 3;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(v1, scalar, v3);

/*
v1 = (1,0,0)
scalar = 3
v3 = (4,3,3)
res = v3
*/
```
