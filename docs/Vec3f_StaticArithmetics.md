# Vec3f - Static Arithmetical Operation

## Contents

* [Add](#add)
  * [Add (vector - vector) without querry input](#add-vector-vector-without-querry-input)

## Add

Adds two vectors or any kind of three dimensional tuple together and optionally safes the result in a vector as [Querry Input](QuerryInput.md). The result vector is then returned. It can be either the [Querry Input](QuerryInput.md) `res` or the newly generated [Vec3f](Vec3f.md).

### Add (vector - vector) without querry input 

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

### Add (vector/vector) with querry input

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

### Add (vector/scalar) without querry input

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

### Add (vector/scalar) with querry input

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
