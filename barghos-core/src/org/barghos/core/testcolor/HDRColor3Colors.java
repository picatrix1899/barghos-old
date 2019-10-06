package org.barghos.core.testcolor;

import org.barghos.core.testcolor.api.IHDRColor3R;

public enum HDRColor3Colors implements IHDRColor3R
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

	@Override
	public int getDimensions() { return 3; }

}
