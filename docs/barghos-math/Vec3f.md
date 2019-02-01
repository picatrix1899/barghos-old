# Vec3f

## Description

The Vec3f represents a mathematical three dimensional vector. The class provides a wide range of common operations for three dimensional vectors.

## Contents

* [Static Arithmetical Operations](#static-arithmetical-operations)
	* [Add](#add-static)
		* [Add (vector + vector) without quarry input](#add-vector--vector-without-quarry-input)
		* [Add (vector + vector) with quarry input](#add-vector--vector-with-quarry-input)
		* [Add (vector + value) without quarry input](#add-vector--value-without-quarry-input)
		* [Add (vector + value) with quarry input](#add-vector--value-with-quarry-input)
		* [Add (vector + x, y, z) without quarry input](#add-vector--x-y-z-without-quarry-input)
		* [Add (vector + x, y, z) with quarry input](#add-vector--x-y-z-with-quarry-input)
		* [Add (value + vector) without quarry input](#add-value--vector-without-quarry-input)
		* [Add (value + vector) with quarry input](#add-value--vector-with-quarry-input)
		* [Add (x, y, z + vector) without quarry input](#add-x-y-z--vector-without-quarry-input)
		* [Add (x, y, z + vector) with quarry input](#add-x-y-z--vector-with-quarry-input)

## Static Arithmetical Operations

[**&laquo;To The Top&raquo;**](#)

### Add (Static)

Adds two vectors or any kind of three dimensional tuple together and optionally safes the result in a vector as [Quarry Input](../QuarryInput.md). The result vector is then returned. It can be either the [Quarry Input](../QuarryInput.md) `res` or the newly generated [Vec3f](Vec3f.md).

[**&laquo;To The Top&raquo;**](#)

#### Add (vector + vector) without quarry input 

Adds `v1` and `v2` together and safes and returns the result in a new [Vec3f](Vec3f.md).

| Component | Operation   |
| --------- | ----------  |
| x         | v1.x + v2.x |
| y         | v1.y + v2.y |
| z         | v1.z + v2.z |

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

[**&laquo;To The Top&raquo;**](#)

#### Add (vector + vector) with quarry input

Adds `v1` and `v2` together and safes and returns the result in the [Quarry Input](../QuarryInput.md) `v3`.

| Component | Operation   |
| --------- | ----------  |
| x         | v1.x + v2.x |
| y         | v1.y + v2.y |
| z         | v1.z + v2.z |

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

[**&laquo;To The Top&raquo;**](#)

#### Add (vector + value) without quarry input

Adds to every component in `v1` the value of `value` and safes and returns the result in a new [Vec3f](Vec3f.md).

| Component | Operation    |
| --------- | -----------  |
| x         | v1.x + value |
| y         | v1.y + value |
| z         | v1.z + value |

```java
Vec3f v1 = new Vec3f(1,0,0);
float value = 3;

Vec3f res = Vec3f.add(v1, value, null);

/*
v1 = (1,0,0)
value = 3
res = (4,3,3)
*/
```

```java
Vec3f v1 = new Vec3f(1,0,0);
double value = 3;

Vec3f res = Vec3f.add(v1, value, null);

/*
v1 = (1,0,0)
value = 3
res = (4,3,3)
*/
```

[**&laquo;To The Top&raquo;**](#)

#### Add (vector + value) with quarry input

Adds to every component in `v1` the value of `value` and safes and returns the result in the [Quarry Input](../QuarryInput.md) `v3`.

| Component | Operation    |
| --------- | -----------  |
| x         | v1.x + value |
| y         | v1.y + value |
| z         | v1.z + value |

```java
Vec3f v1 = new Vec3f(1,0,0);
float value = 3;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(v1, value, v3);

/*
v1 = (1,0,0)
value = 3
v3 = (4,3,3)
res = v3
*/
```

```java
Vec3f v1 = new Vec3f(1,0,0);
double value = 3;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(v1, value, v3);

/*
v1 = (1,0,0)
value = 3
v3 = (4,3,3)
res = v3
*/
```

[**&laquo;To The Top&raquo;**](#)

#### Add (vector + x, y, z) without quarry input

Adds to every component in `v1` the coresponding value and safes and returns the result in a new [Vec3f](Vec3f.md).

| Component | Operation |
| --------- | ----------|
| x         | v1.x + x  |
| y         | v1.y + y  |
| z         | v1.z + z  |

```java
Vec3f v1 = new Vec3f(1,0,0);
float x = 3;
float y = 1;
float z = 2;

Vec3f res = Vec3f.add(v1, x, y, z, null);

/*
v1 = (1,0,0)
x = 3
y = 1
z = 2
res = (4,1,2)
*/
```

```java
Vec3f v1 = new Vec3f(1,0,0);
double x = 3;
double y = 1;
double z = 2;

Vec3f res = Vec3f.add(v1, x, y, z, null);

/*
v1 = (1,0,0)
x = 3
y = 1
z = 2
res = (4,1,2)
*/
```

[**&laquo;To The Top&raquo;**](#)

#### Add (vector + x, y, z) with quarry input

Adds to every component in `v1` the coresponding value and safes and returns the result in the [Quarry Input](../QuarryInput.md) `v3`.

| Component | Operation    |
| --------- | -----------  |
| x         | v1.x + x |
| y         | v1.y + y |
| z         | v1.z + z |

```java
Vec3f v1 = new Vec3f(1,0,0);
float x = 3;
float y = 1;
float z = 2;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(v1, x, y, z, v3);

/*
v1 = (1,0,0)
x = 3
y = 1
z = 2
v3 = (4,1,2)
res = v3
*/
```

```java
Vec3f v1 = new Vec3f(1,0,0);
double x = 3;
double y = 1;
double z = 2;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(v1, x, y, z, v3);

/*
v1 = (1,0,0)
x = 3
y = 1
z = 2
v3 = (4,1,2)
res = v3
*/
```

[**&laquo;To The Top&raquo;**](#)

#### Add (value + vector) without quarry input

Adds to `value` each component in `v2` and safes and returns the result in a new [Vec3f](Vec3f.md).

| Component | Operation    |
| --------- | -----------  |
| x         | value + v1.x |
| y         | value + v1.y |
| z         | value + v1.z |

```java
Vec3f v2 = new Vec3f(1,0,0);
float value = 3;

Vec3f res = Vec3f.add(value, v2, null);

/*
value = 3
v2 = (1,0,0)
res = (4,3,3)
*/
```

```java
Vec3f v2 = new Vec3f(1,0,0);
double value = 3;

Vec3f res = Vec3f.add(value, v2, null);

/*
value = 3
v2 = (1,0,0)
res = (4,3,3)
*/
```

[**&laquo;To The Top&raquo;**](#)

#### Add (value + vector) with quarry input

Adds to `value` each component in `v2` and safes and returns the result in the [Quarry Input](../QuarryInput.md) `v3`.

| Component | Operation    |
| --------- | -----------  |
| x         | v1.x + value |
| y         | v1.y + value |
| z         | v1.z + value |

```java
Vec3f v2 = new Vec3f(1,0,0);
float value = 3;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(value, v2, v3);

/*
value = 3
v2 = (1,0,0)
v3 = (4,3,3)
res = v3
*/
```

```java
Vec3f v2 = new Vec3f(1,0,0);
double value = 3;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(value, v2, v3);

/*
value = 3
v2 = (1,0,0)
v3 = (4,3,3)
res = v3
*/
```

[**&laquo;To The Top&raquo;**](#)

#### Add (x, y, z + vector) without quarry input

Adds to `x, y and z` the coresponding component in `v2` and safes and returns the result in a new [Vec3f](Vec3f.md).

| Component | Operation |
| --------- | ----------|
| x         | x + v1.x  |
| y         | y + v1.y  |
| z         | z + v1.z  |

```java
Vec3f v1 = new Vec3f(1,0,0);
float x = 3;
float y = 1;
float z = 2;

Vec3f res = Vec3f.add(v1, x, y, z, null);

/*
v1 = (1,0,0)
x = 3
y = 1
z = 2
res = (4,1,2)
*/
```

```java
Vec3f v1 = new Vec3f(1,0,0);
double x = 3;
double y = 1;
double z = 2;

Vec3f res = Vec3f.add(v1, x, y, z, null);

/*
v1 = (1,0,0)
x = 3
y = 1
z = 2
res = (4,1,2)
*/
```

[**&laquo;To The Top&raquo;**](#)

#### Add (x, y, z + vector) with quarry input

Adds to `x, y and z` the coresponding component in `v2` and safes and returns the result in the [Quarry Input](../QuarryInput.md) `v3`.

| Component | Operation    |
| --------- | -----------  |
| x         | x + v1.x |
| y         | y + v1.y |
| z         | z + v1.z |

```java
Vec3f v2 = new Vec3f(1,0,0);
float x = 3;
float y = 1;
float z = 2;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(x, y, z, v2, v3);

/*
x = 3
y = 1
z = 2
v2 = (1,0,0)
v3 = (4,1,2)
res = v3
*/
```

```java
Vec3f v2 = new Vec3f(1,0,0);
double x = 3;
double y = 1;
double z = 2;
Vec3f v3 = new Vec3f();

Vec3f res = Vec3f.add(x, y, z, v2, v3);

/*
x = 3
y = 1
z = 2
v2 = (1,0,0)
v3 = (4,1,2)
res = v3
*/
```
