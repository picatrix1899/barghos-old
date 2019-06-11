# BufferUtils

## Description

This class provides easy and convenient ways to create java.nio Buffers for the primitive types byte, short, int, long, float and double. It also allows us to wrap a Buffer around an existing
array or set of data and optionally flip the resulting Buffer to ready it for reading. Beside of the primitive types it's also possible to wrap entire tuples. All Buffers use the native
byte order of the current System.

---

## Contents

* [Creation of empty Buffers](#creation-of-empty-buffers)
  * [CreateByteBuffer](#createbytebuffer)
  * [CreateShortBuffer](#createshortbuffer)
  * [CreateIntBuffer](#createintbuffer)
  * [CreateLongBuffer](#createlongbuffer)
  * [CreateFloatBuffer](#createfloatbuffer)
  * [CreateDoubleBuffer](#createdoublebuffer)
* [Wrapping arrays in Buffers](#wrapping-arrays-in-buffers)
  * [WrapByteBuffer](#wrapbytebuffer)
  * [WrapShortBuffer](#wrapshortbuffer)
  * [WrapIntBuffer](#wrapintbuffer)
  * [WrapLongBuffer](#wraplongbuffer)
  * [WrapFloatBuffer](#wrapfloatbuffer)
  * [WrapDoubleBuffer](#wrapdoublebuffer)
  * [WrapTuple2FBuffer](#wraptuple2fbuffer)
  * [WrapTuple3FBuffer](#wraptuple3fbuffer)
* [Wrapping arrays in Buffers and flip](#wrapping-arrays-in-buffers-and-flip)
  * [WrapFlippedByteBuffer](#wrapflippedbytebuffer)
  * [WrapFlippedShortBuffer](#wrapflippedshortbuffer)
  * [WrapFlippedIntBuffer](#wrapflippedintbuffer)
  * [WrapFlippedLongBuffer](#wrapflippedlongbuffer)
  * [WrapFlippedFloatBuffer](#wrapflippedfloatbuffer)
  * [WrapFlippedDoubleBuffer](#wrapflippeddoublebuffer)
  * [WrapFlippedTuple2FBuffer](#wrapflippedtuple2fbuffer)
  * [WrapFlippedTuple3FBuffer](#wrapflippedtuple3fbuffer)

---

## Creation of empty Buffers

This section contains all functions for creating new fixed size Buffer.

[**&laquo;To The Top&raquo;**](#)

### CreateByteBuffer

With the function `createByteBuffer(int size)` you create a new `ByteBuffer` with a fixed size.
The size is the maximum element count in the Buffer of the specific type in this case `byte`. This means that a Buffer created with `createByteBuffer(15)` can hold a total of 15 `byte` values.

```java
// Example
ByteBuffer buffer = BufferUtils.createByteBuffer(15);
```

[**&laquo;To The Top&raquo;**](#)

### CreateShortBuffer

With the function `createShortBuffer(int size)` you create a new `ShortBuffer` with a fixed size.
The size is the maximum element count in the Buffer of the specific type in this case `short`. This means that a Buffer created with `createShortBuffer(15)` can hold a total of 15 `short` values.

```java
// Example
ShortBuffer buffer = BufferUtils.createShortBuffer(15);
```

[**&laquo;To The Top&raquo;**](#)

### CreateIntBuffer

With the function `createIntBuffer(int size)` you create a new `IntBuffer` with a fixed size.
The size is the maximum element count in the Buffer of the specific type in this case `int`. This means that a Buffer created with `createIntBuffer(15)` can hold a total of 15 `int` values.

```java
// Example
IntBuffer buffer = BufferUtils.createIntBuffer(15);
```

[**&laquo;To The Top&raquo;**](#)

### CreateLongBuffer

With the function `createLongBuffer(int size)` you create a new `LongBuffer` with a fixed size.
The size is the maximum element count in the Buffer of the specific type in this case `long`. This means that a Buffer created with `createLongBuffer(15)` can hold a total of 15 `long` values.

```java
// Example
LongBuffer buffer = BufferUtils.createLongBuffer(15);
```

[**&laquo;To The Top&raquo;**](#)

### CreateFloatBuffer

With the function `createFloatBuffer(int size)` you create a new `FloatBuffer` with a fixed size.
The size is the maximum element count in the Buffer of the specific type in this case `float`. This means that a Buffer created with `createFloatBuffer(15)` can hold a total of 15 `float` values.

```java
// Example
FloatBuffer buffer = BufferUtils.createFloatBuffer(15);
```

[**&laquo;To The Top&raquo;**](#)

### CreateDoubleBuffer

With the function `createDoubleBuffer(int size)` you create a new `DoubleBuffer` with a fixed size.
The size is the maximum element count in the Buffer of the specific type in this case `double`. This means that a Buffer created with `createDoubleBuffer(15)` can hold a total of 15 `double` values.

```java
// Example
DoubleBuffer buffer = BufferUtils.createDoubleBuffer(15);
```

[**&laquo;To The Top&raquo;**](#)

---

## Wrapping arrays in Buffers

This section contains all functions to create Buffers from arrays or parameter arrays.

Beware these functions return a Buffer that is in write mode. It needs to be flipped to be able to read from it.

[**&laquo;To The Top&raquo;**](#)

## WrapByteBuffer

With the function `wrapByteBuffer(byte... data)`you create a new `ByteBuffer` with the size of data.length and put the elements of data in order into the buffer.

```java
// Example 1 - parameter array
ByteBuffer buffer = BufferUtils.wrapByteBuffer((byte)10, (byte)30, (byte)255);

// Example 2 - array
byte[] array = new byte[] { (byte)10, (byte)30, (byte)255 };
ByteBuffer buffer = BufferUtils.wrapByteBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)

## WrapShortBuffer

With the function `wrapShortBuffer(short... data)`you create a new `ShortBuffer` with the size of data.length and put the elements of data in order into the buffer.

```java
// Example 1 - parameter array
ShortBuffer buffer = BufferUtils.wrapShortBuffer((short)10, (short)30, (short)255);

// Example 2 - array
short[] array = new short[] { (short)10, (short)30, (short)255 };
ShortBuffer buffer = BufferUtils.wrapShortBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)

## WrapIntBuffer

With the function `wrapIntBuffer(int... data)`you create a new `IntBuffer` with the size of data.length and put the elements of data in order into the buffer.

```java
// Example 1 - parameter array
IntBuffer buffer = BufferUtils.wrapIntBuffer(10, 30, 255);

// Example 2 - array
int[] array = new int[] { 10, 30, 255 };
IntBuffer buffer = BufferUtils.wrapIntBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)

## WrapLongBuffer

With the function `wrapLongBuffer(long... data)`you create a new `LongBuffer` with the size of data.length and put the elements of data in order into the buffer.

```java
// Example 1 - parameter array
LongBuffer buffer = BufferUtils.wrapLongBuffer(10l, 30l, 255l);

// Example 2 - array
long[] array = new long[] { 10l, 30l, 255l };
LongBuffer buffer = BufferUtils.wrapLongBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)

## WrapFloatBuffer

With the function `wrapFloatBuffer(float... data)`you create a new `FloatBuffer` with the size of data.length and put the elements of data in order into the buffer.

```java
// Example 1 - parameter array
FloatBuffer buffer = BufferUtils.wrapFloatBuffer(10.0f, 30.0f, 255.0f);

// Example 2 - array
float[] array = new float[] { 10.0f, 30.0f, 255.0f };
FloatBuffer buffer = BufferUtils.wrapFloatBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)

## WrapDoubleBuffer

With the function `wrapDoubleBuffer(double... data)`you create a new `DoubleBuffer` with the size of data.length and put the elements of data in order into the buffer.

```java
// Example 1 - parameter array
DoubleBuffer buffer = BufferUtils.wrapDoubleBuffer(10.0d, 30.0d, 255.0d);

// Example 2 - array
double[] array = new double[] { 10.0d, 30.0d, 255.0d };
DoubleBuffer buffer = BufferUtils.wrapDoubleBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)

## WrapTuple2FBuffer

With the function `wrapTuple2FBuffer(ITup2fR... data)`you create a new `FloatBuffer` with the size of data.length * 2 and put the elements of data in order as x, y and z into the buffer. Due to the fact that the
input type is the interface `ITup2fR` it accepts any derivation e.g. `Tuple2f` or `Vec2f`.

```java
// Example 1a - parameter array
Tuple2f t1 = new Tuple2f(10.0f, 20.5f);
Tuple2f t2 = new Tuple2f(30.7f, 40.0f);
FloatBuffer buffer = BufferUtils.wrapTuple2FBuffer(t1, t2);

// Example 1b - Equivalent to Example 1a
FloatBuffer buffer = BufferUtils.wrapFloatBuffer(10.0f, 20.5f, 30.7f, 40.0f);

// Example 1c - Equivalent to Example 1a
Tuple2f t1 = new Tuple2f(10.0f, 20.5f);
Tuple2f t2 = new Tuple2f(30.7f, 40.0f);

FloatBuffer buffer = BufferUtils.wrapFloatBuffer(t1.getX(), t1.getY(), t2.getX(), t2.getY());

// Example 2 - array
Tuple2f[] array = new Tuple2f[] { new Tuple2f(10.0f,20.5f), new Tuple2f(30.7f, 40.0f) };
FloatBuffer buffer = BufferUtils.wrapTuple2FBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)

## WrapTuple3FBuffer

With the function `wrapTuple3FBuffer(ITup3fR... data)`you create a new `FloatBuffer` with the size of data.length * 3 and put the elements of data in order as x, y and z into the buffer. Due to the fact that the
input type is the interface `ITup3fR` it accepts any derivation e.g. `Tuple3f` or `Vec3f`.

```java
// Example 1a - parameter array
Tuple3f t1 = new Tuple3f(10.0f, 15.0f, 20.0f);
Tuple3f t2 = new Tuple3f(30.0f, 35.0f, 40.0f);
FloatBuffer buffer = BufferUtils.wrapTuple3FBuffer(t1, t2);

// Example 1b - Equivalent to Example 1a
FloatBuffer buffer = BufferUtils.wrapFloatBuffer(10.0f, 15.0f, 20.0f, 30.0f, 35.0f, 40.0f);

// Example 1c - Equivalent to Example 1a
Tuple3f t1 = new Tuple3f(10.0f, 15.0f, 20.0f);
Tuple3f t2 = new Tuple3f(30.0f, 35.0f, 40.0f);

FloatBuffer buffer = BufferUtils.wrapFloatBuffer(t1.getX(), t1.getY(), t1.getZ(), t2.getX(), t2.getY(), t2.getZ());

// Example 2 - array
Tuple3f[] array = new Tuple3f[] { Tuple3f(10.0f, 15.0f, 20.0f), new Tuple3f(30.0f, 35.0f, 40.0f) };
FloatBuffer buffer = BufferUtils.wrapTuple3FBuffer(array);
```

[**&laquo;To The Top&raquo;**](#)