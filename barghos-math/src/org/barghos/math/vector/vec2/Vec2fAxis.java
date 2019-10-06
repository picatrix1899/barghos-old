package org.barghos.math.vector.vec2;

import org.barghos.math.Maths;
import org.barghos.math.vector.vec2.api.IVec2fR;

public enum Vec2fAxis implements IVec2fR
{
	/** The Zero Vector as constant. */
	ZERO {
		public float getX() { return 0; }
		public float getY() { return 0; }
	},
	
	/** The One Vector as constant. */
	ONE {
		public float getX() { return 1; }
		public float getY() { return 1; }
	},

	/** The positive x-axis normal as constant. */
	AXIS_X {
		public float getX() { return 1; }
		public float getY() { return 0; }
	},
	
	/** The positive y-axis normal as constant. */
	AXIS_Y {
		public float getX() { return 0; }
		public float getY() { return 1; }
	},

	/** The negative x-axis normal as constant. */
	AXIS_NX {
		public float getX() { return 0; }
		public float getY() { return -1; }
	},
	
	/** The negative y-axis normal as constant. */
	AXIS_NY {
		public float getX() { return 0; }
		public float getY() { return -1; }
	},

	/** The diagonal axis normal of positive x and positive y as constant. */
	AXIS_XY {
		public float getX() { return Maths.INV_SQRT2f; }
		public float getY() { return Maths.INV_SQRT2f; }
	},
	
	/** The diagonal axis normal of negative x and positive y as constant. */
	AXIS_NXY {
		public float getX() { return -Maths.INV_SQRT2f; }
		public float getY() { return Maths.INV_SQRT2f; }
	},
	
	/** The diagonal axis normal of positive x and negative y as constant. */
	AXIS_XNY {
		public float getX() { return Maths.INV_SQRT2f; }
		public float getY() { return -Maths.INV_SQRT2f; }
	},
	
	/** The diagonal axis normal of negative x and negative y as constant. */
	AXIS_NXNY {
		public float getX() { return -Maths.INV_SQRT2f; }
		public float getY() { return -Maths.INV_SQRT2f; }
	},
;
}
