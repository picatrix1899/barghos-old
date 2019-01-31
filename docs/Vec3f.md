# Vec3f

## Description

The Vec3f represents a mathematical three dimensional vector. The class provides a wide range of common operations for three dimensional vectors.

## Arithmetical Operations

### Add

``java
Vec3f v1 = new Vec3f(1,0,0);
Vec3f v2 = new Vec3f(2,1,4);

Vec3f res = Vec3f.add(v1, v2, null);

/*
v1 = (1,0,0)
v2 = (2,1,4)
res = (3,1,4)
*/
``
