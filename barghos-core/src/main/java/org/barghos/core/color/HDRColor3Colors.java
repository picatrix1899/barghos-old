/*
MIT License

Copyright (c) 2019 picatrix1899

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package org.barghos.core.color;

public enum HDRColor3Colors implements HDRColor3R
{
	/**
	 * White Color constant.
	 */
	WHITE {
		public int getR() { return 255; }
		public int getG() { return 255; }
		public int getB() { return 255; }
		public float getUnityR() { return 1; }
		public float getUnityG() { return 1; }
		public float getUnityB() { return 1; }
	},
	
	/**
	 * Black Color constant.
	 */
	BLACK {
		public int getR() { return 0; }
		public int getG() { return 0; }
		public int getB() { return 0; }
		public float getUnityR() { return 0; }
		public float getUnityG() { return 0; }
		public float getUnityB() { return 0; }
	},

	/**
	 * Red Color constant.
	 */
	RED {
		public int getR() { return 255; }
		public int getG() { return 0; }
		public int getB() { return 0; }
		public float getUnityR() { return 1; }
		public float getUnityG() { return 0; }
		public float getUnityB() { return 0; }
	},
	
	/**
	 * Green Color constant.
	 */
	GREEN {
		public int getR() { return 0; }
		public int getG() { return 255; }
		public int getB() { return 0; }
		public float getUnityR() { return 0; }
		public float getUnityG() { return 1; }
		public float getUnityB() { return 0; }
	},
	
	/**
	 * Blue Color constant.
	 */
	BLUE {
		public int getR() { return 0; }
		public int getG() { return 0; }
		public int getB() { return 255; }
		public float getUnityR() { return 0; }
		public float getUnityG() { return 0; }
		public float getUnityB() { return 1; }
	},
	
	/** 
	 * Yellow Color constant.
	 */
	YELLOW {
		public int getR() { return 255; }
		public int getG() { return 255; }
		public int getB() { return 0; }
		public float getUnityR() { return 1; }
		public float getUnityG() { return 1; }
		public float getUnityB() { return 0; }
	},
	
	/**
	 * Purple Color constant.
	 */
	PURPLE {
		public int getR() { return 128; }
		public int getG() { return 0; }
		public int getB() { return 128; }
		public float getUnityG() { return 0; }
	},
	
	/** 
	 * Gold Color constant.
	 */
	GOLD {
		public int getR() { return 255; }
		public int getG() { return 215; }
		public int getB() { return 0; }
		public float getUnityR() { return 1; }
		public float getUnityB() { return 0; }
	},
	
	/**
	 * Orange Color constant.
	 */
	ORANGE {
		public int getR() { return 255; }
		public int getG() { return 140; }
		public int getB() { return 0; }
		public float getUnityR() { return 1; }
		public float getUnityB() { return 0; }
	},
	
	/** 
	 * Grey Color constant.
	 */
	GREY {
		public int getR() { return 128; }
		public int getG() { return 128; }
		public int getB() { return 128; }
	},
;

	@Override
	public float getUnityR() { return (int)Math.round(getR() / 255); }
	
	@Override
	public float getUnityG() { return (int)Math.round(getG() / 255); }
	
	@Override
	public float getUnityB() { return (int)Math.round(getB() / 255); }
}
