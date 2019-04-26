package org.barghos.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CheckTest
{

	@Test
	void testIsTrue()
	{
		assertTrue(Check.isTrue(true));
		assertFalse(Check.isTrue(false));
	}

	@Test
	void testIsTrueArray()
	{
		assertTrue(Check.isTrue(true, true, true));
		assertFalse(Check.isTrue(true, false, true));
		assertFalse(Check.isTrue(false, false, false));
	}

	@Test
	void testIsTrueOOO()
	{
		assertTrue(Check.isTrueOOO(true, true, true));
		assertTrue(Check.isTrueOOO(true, false, true));
		assertFalse(Check.isTrueOOO(false, false, false));
	}

	@Test
	void testIsFalse()
	{
		assertTrue(Check.isFalse(false));
		assertFalse(Check.isFalse(true));
	}

	@Test
	void testIsFalseArray()
	{
		assertTrue(Check.isFalse(false, false, false));
		assertFalse(Check.isFalse(false, true, false));
		assertFalse(Check.isFalse(true, true, true));
	}

	@Test
	void testIsFalseOOO()
	{
		assertTrue(Check.isFalseOOO(false, false, false));
		assertTrue(Check.isFalseOOO(false, true, false));
		assertFalse(Check.isFalseOOO(true, true, true));
	}

	@Test
	void testIsEqualBooleanBoolean()
	{
		assertTrue(Check.isEqual(true, true));
		assertTrue(Check.isEqual(false, false));
		assertFalse(Check.isEqual(true, false));
		assertFalse(Check.isEqual(false, true));
	}

	@Test
	void testIsEqualIntInt()
	{
		assertTrue(Check.isEqual(3, 3));
		assertFalse(Check.isEqual(3, 5));
	}

	@Test
	void testIsEqualLongLong()
	{
		assertTrue(Check.isEqual(3l, 3l));
		assertFalse(Check.isEqual(3l, 5l));
	}

	@Test
	void testIsEqualFloatFloat()
	{
		assertTrue(Check.isEqual(3.1f, 3.1f));
		assertFalse(Check.isEqual(3.1f, 5.1f));
	}

	@Test
	void testIsEqualDoubleDouble()
	{
		assertTrue(Check.isEqual(3.1, 3.1));
		assertFalse(Check.isEqual(3.1, 5.1));
	}

	@Test
	void testIsEqualStringString()
	{
		assertTrue(Check.isEqual((String)null, (String)null));
		assertFalse(Check.isEqual((String)null, ""));
		assertTrue(Check.isEqual("test", "test"));
		assertFalse(Check.isEqual("test", "lorem"));
	}

	@Test
	void testIsEqualAA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualBooleanBooleanArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualStringStringArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualAAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualOOOBooleanBooleanArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualOOOIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualOOOLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualOOOFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualOOODoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualOOOStringStringArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEqualOOOAAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsValueNull()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsNullA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsNullAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsNullOOO()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenIntIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenLongLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenFloatFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenDoubleDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenDoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenOOOIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenOOOLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenOOOFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInBetweenOOODoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeIntIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeLongLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeFloatFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeDoubleDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeDoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeOOOIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeOOOLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeOOOFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsInRangeOOODoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowOOOIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowOOOLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowOOOFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsBelowOOODoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveOOOIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveOOOLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveOOOFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsAboveOOODoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsNullOrEmptyString()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsNullOrEmptyAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsNullOrEmptyListOfA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEmptyListOfA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEmptyAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEmptyString()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotTrueBoolean()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotTrueBooleanArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotTrueOOO()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotFalseBoolean()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotFalseBooleanArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotFalseOOO()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualBooleanBoolean()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualStringString()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualAA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualBooleanBooleanArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualStringStringArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualAAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualOOOBooleanBooleanArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualOOOIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualOOOLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualOOOFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualOOODoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualOOOStringStringArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEqualOOOAAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotNullA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotNullAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotNullOOO()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenIntIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenLongLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenFloatFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenDoubleDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenDoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenOOOIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenOOOLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenOOOFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInBetweenOOODoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeIntIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeLongLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeFloatFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeDoubleDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeDoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeOOOIntIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeOOOLongLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeOOOFloatFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotInRangeOOODoubleDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowOOOIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowOOOLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowOOOFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotBelowOOODoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveIntInt()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveLongLong()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveFloatFloat()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveDoubleDouble()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveDoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveOOOIntIntArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveOOOLongLongArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveOOOFloatFloatArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotAboveOOODoubleDoubleArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotNullOrEmptyString()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotNullOrEmptyAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotNullOrEmptyListOfA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEmptyListOfA()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEmptyAArray()
	{
		fail("Not yet implemented");
	}

	@Test
	void testNotEmptyString()
	{
		fail("Not yet implemented");
	}

}
