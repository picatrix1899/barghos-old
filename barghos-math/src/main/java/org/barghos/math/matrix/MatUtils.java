package org.barghos.math.matrix;

public class MatUtils
{
	public static float det2x2( float m0x, float m0y,
								float m1x, float m1y)
	{
		return	m0x * +m1y +
				m0y * -m1x;
	}
	
	public static float det3x3( float m0x, float m0y, float m0z,
								float m1x, float m1y, float m1z,
								float m2x, float m2y, float m2z)
	{
		return	m0x * +det2x2(m1y, m1z, m2y, m2z) +
				m0y * -det2x2(m1x, m1z, m2x, m2z) +
				m0z * +det2x2(m1x, m1y, m2x, m2y);
	}
	
	public static float det4x4(	float m0x, float m0y, float m0z, float m0w,
								float m1x, float m1y, float m1z, float m1w,
								float m2x, float m2y, float m2z, float m2w,
								float m3x, float m3y, float m3z, float m3w)
	{
		return	m0x * +det3x3(m1y, m1z, m1w, m2y, m2z, m2w, m3y, m3z, m3w) +
				m0y * -det3x3(m1x, m1z, m1w, m2x, m2z, m2w, m3x, m3z, m3w) +
				m0z * +det3x3(m1x, m1y, m1w, m2x, m2y, m2w, m3x, m3y, m3w) +
				m0w * -det3x3(m1x, m1y, m1z, m2x, m2y, m2z, m3x, m3y, m3z);
	}
	
	public static float det5x5( float m0x, float m0y, float m0z, float m0w, float m0v,
								float m1x, float m1y, float m1z, float m1w, float m1v,
								float m2x, float m2y, float m2z, float m2w, float m2v,
								float m3x, float m3y, float m3z, float m3w, float m3v,
								float m4x, float m4y, float m4z, float m4w, float m4v)
	{
		return  m0x * +det4x4(m1y, m1z, m1w, m1v, m2y, m2z, m2w, m2v, m3y, m3z, m3w, m3v, m4y, m4z, m4w, m4v) +
				m0y * -det4x4(m1x, m1z, m1w, m1v, m2x, m2z, m2w, m2v, m3x, m3z, m3w, m3v, m4x, m4z, m4w, m4v) +
				m0z * +det4x4(m1x, m1y, m1w, m1v, m2x, m2y, m2w, m2v, m3x, m3y, m3w, m3v, m4x, m4y, m4w, m4v) + 
				m0w * -det4x4(m1x, m1y, m1z, m1v, m2x, m2y, m2z, m2v, m3x, m3y, m3z, m3v, m4x, m4y, m4z, m4v) +
				m0v * +det4x4(m1x, m1y, m1z, m1w, m2x, m2y, m2z, m2w, m3x, m3y, m3z, m3w, m4x, m4y, m4z, m4w);
	}
}
