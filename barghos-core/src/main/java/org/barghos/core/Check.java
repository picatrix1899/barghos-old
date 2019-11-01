package org.barghos.core;

import java.util.List;

import org.barghos.core.tuple.tuple3.Tup3fR;

public class Check
{
	
	private Check() {}
	
	public static boolean isTrue(boolean expression) { return expression; }
	
	
	
	public static boolean isTrue(boolean... expressions)
	{
		assert(expressions != null);
		assert(expressions.length != 0);
		for(boolean expression : expressions)
			if(!expression) return false;
		
		return true;
	}		
	
	
	
	public static boolean isTrueOOO(boolean... expressions)
	{
		assert(expressions != null);
		assert(expressions.length != 0);
		for(boolean expression : expressions)
			if(expression) return true;
		
		return false;
	}		
	
	
	
	public static boolean isFalse(boolean expression) { return !expression; }
	
	

	public static boolean isFalse(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(expression) return false;
		
		return true;
	}
	

	
	public static boolean isFalseOOO(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(!expression) return true;
		
		return false;
	}
	
	
	
	public static boolean isEqual(boolean expected, boolean value) { return value == expected; }
	public static boolean isEqual(int expected, int value) { return value == expected; }
	public static boolean isEqual(long expected, long value) { return value == expected; }
	public static boolean isEqual(float expected, float value) { return value == expected; }
	public static boolean isEqual(double expected, double value) { return value == expected; }
	
	public static boolean isEqual(String expected, String value)
	{
		if(expected == null) return value == null;
		
		return value.equals(expected);
	}
	
	public static <A> boolean isEqual(A expected, A value)
	{
		if(expected == null) return value == null;
		
		return value.equals(expected) || value == expected;
	}
	

	
	public static boolean isEqual(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(value != expected) return false;
		
		return true;
	}
	public static boolean isEqual(int expected, int... values)
	{
		for(int value : values)
			if(value != expected) return false;
		
		return true;
	}
	public static boolean isEqual(long expected, long... values)
	{
		for(long value : values)
			if(value != expected) return false;
		
		return true;
	}
	public static boolean isEqual(float expected, float...values)
	{
		for(float value : values)
			if(value != expected) return false;
		
		return true;
	}
	public static boolean isEqual(double expected, double... values)
	{
		for(double value : values)
			if(value != expected) return false;
		
		return true;
	}
	
	public static boolean isEqual(String expected, String... values)
	{
		for(String value : values)
			if(value.equals(expected)) return false;
		
		return true;
	}
	@SafeVarargs
	public static <A> boolean isEqual(A expected, A... values)
	{
		for(A value : values)
		{
			if(expected == null) if(value != null) return false;
			if(!value.equals(expected) && value != expected) return false;
		}
			
		return true;
	}
	
	
	
	
	
	public static boolean isEqualOOO(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(value == expected) return true;
		
		return false;
	}
	public static boolean isEqualOOO(int expected, int... values)
	{
		for(int value : values)
			if(value == expected) return true;
		
		return false;
	}
	public static boolean isEqualOOO(long expected, long... values)
	{
		for(long value : values)
			if(value == expected) return true;
		
		return false;
	}
	public static boolean isEqualOOO(float expected, float... values)
	{
		for(float value : values)
			if(value == expected) return true;
		
		return false;
	}
	public static boolean isEqualOOO(double expected, double... values)
	{
		for(double value : values)
			if(value == expected) return true;
		
		return false;
	}
	
	public static boolean isEqualOOO(String expected, String... values)
	{
		for(String value : values)
			if(value.equals(expected)) return true;
		
		return false;
	}
	@SafeVarargs
	public static <A> boolean isEqualOOO(A expected, A... values)
	{
		for(A value : values)
		{
			if(expected == null) if(value == null) return true;
			if(value.equals(expected) || value == expected) return true;
		}
			
		return false;
	}
	
	public static <A> boolean isValueNull(Tup3fR object)
	{
		return object.getX() == 0.0f && object.getY() == 0.0f && object.getZ() == 0.0f;
	}
	
	public static <A> boolean isNull(A object) { return object == null; }
	
	
	
	@SafeVarargs
	public static <A> boolean isNull(A... objects)
	{
		for(A object : objects)
			if(object != null) return false;
		
		return true;
	}
	
	
	
	@SafeVarargs
	public static <A> boolean isNullOOO(A... objects)
	{
		for(A object : objects)
			if(object != null) return true;
		
		return false;
	}


	
	public static boolean isInBetween(int min, int max, int value) { return min < value && value < max; }
	public static boolean isInBetween(long min, long max, long value) { return min < value && value < max; }
	public static boolean isInBetween(float min, float max, float value) { return min < value && value < max; }	
	public static boolean isInBetween(double min, double max, double value) { return min < value && value < max; }
	
	
	
	public static boolean isInBetween(int min, int max, int... values)
	{
		for(int value : values)
			if(min >= value || value >= max) return false;
		
		return true;
	}
	
	public static boolean isInBetween(long min, long max, long... values)
	{
		for(long value : values)
			if(min >= value || value >= max) return false;
		
		return true;
	}
	
	public static boolean isInBetween(float min, float max, float... values)
	{
		for(float value : values)
			if(min >= value || value >= max) return false;
		
		return true;
	}
	
	public static boolean isInBetween(double min, double max, double... values)
	{
		for(double value : values)
			if(min >= value || value >= max) return false;
		
		return true;
	}
	
	
	public static boolean isInBetweenOOO(int min, int max, int... values)
	{
		for(int value : values)
			if(min < value && value < max) return true;
		
		return false;
	}
	
	public static boolean isInBetweenOOO(long min, long max, long... values)
	{
		for(long value : values)
			if(min < value && value < max) return true;
		
		return false;
	}
	
	public static boolean isInBetweenOOO(float min, float max, float... values)
	{
		for(float value : values)
			if(min < value && value < max) return true;
		
		return false;
	}
	
	public static boolean isInBetweenOOO(double min, double max, double... values)
	{
		for(double value : values)
			if(min < value && value < max) return true;
		
		return false;
	}
	
	
	
	public static boolean isInRange(int min, int max, int value) { return min <= value && value <= max; }
	public static boolean isInRange(long min, long max, long value) { return min <= value && value <= max; }
	public static boolean isInRange(float min, float max, float value) { return min <= value && value <= max; }	
	public static boolean isInRange(double min, double max, double value) { return min <= value && value <= max; }
	
	
	
	public static boolean isInRange(int min, int max, int... values)
	{
		for(int value : values)
			if(min > value || value > max) return false;
		
		return true;
	}
	
	public static boolean isInRange(long min, long max, long... values)
	{
		for(long value : values)
			if(min > value || value > max) return false;
		
		return true;
	}
	
	public static boolean isInRange(float min, float max, float... values)
	{
		for(float value : values)
			if(min > value || value > max) return false;
		
		return true;
	}
	
	public static boolean isInRange(double min, double max, double... values)
	{
		for(double value : values)
			if(min > value || value > max) return false;
		
		return true;
	}
	
	
	
	public static boolean isInRangeOOO(int min, int max, int... values)
	{
		for(int value : values)
			if(min <= value && value <= max) return true;
		
		return false;
	}
	
	public static boolean isInRangeOOO(long min, long max, long... values)
	{
		for(long value : values)
			if(min <= value && value <= max) return true;
		
		return false;
	}
	
	public static boolean isInRangeOOO(float min, float max, float... values)
	{
		for(float value : values)
			if(min <= value && value <= max) return true;
		
		return false;
	}
	
	public static boolean isInRangeOOO(double min, double max, double... values)
	{
		for(double value : values)
			if(min <= value && value <= max) return true;
		
		return false;
	}
	
	
	
	public static boolean isBelow(int max, int value) { return value < max; }
	public static boolean isBelow(long max, long value) { return value < max; }
	public static boolean isBelow(float max, float value) { return value < max;}
	public static boolean isBelow(double max, double value) { return value < max; }
	
	
	
	public static boolean isBelow(int max, int... values)
	{
		for(int value : values)
			if(value >= max) return false;
		
		return true;
	}
	
	public static boolean isBelow(long max, long... values)
	{
		for(long value : values)
			if(value >= max) return false;
		
		return true;
	}
	
	public static boolean isBelow(float max, float... values)
	{
		for(float value : values)
			if(value >= max) return false;
		
		return true;
	}
	
	public static boolean isBelow(double max, double... values)
	{
		for(double value : values)
			if(value >= max) return false;
		
		return true;
	}
	
	
	
	public static boolean isBelowOOO(int max, int... values)
	{
		for(int value : values)
			if(value < max) return true;
		
		return false;
	}
	
	public static boolean isBelowOOO(long max, long... values)
	{
		for(long value : values)
			if(value < max) return true;
		
		return false;
	}
	
	public static boolean isBelowOOO(float max, float... values)
	{
		for(float value : values)
			if(value < max) return true;
		
		return false;
	}
	
	public static boolean isBelowOOO(double max, double... values)
	{
		for(double value : values)
			if(value < max) return true;
		
		return false;
	}
	
	
	
	public static boolean isAbove(int min, int value) { return min < value; }
	public static boolean isAbove(long min, long value) { return min < value; }
	public static boolean isAbove(float min, float value) { return min < value; }
	public static boolean isAbove(double min, double value) { return min < value; }
	
	

	public static boolean isAbove(int min, int... values)
	{
		for(int value : values)
			if(min >= value) return false;
		
		return true;
	}
	
	public static boolean isAbove(long min, long... values)
	{
		for(long value : values)
			if(min >= value) return false;
		
		return true;
	}
	
	public static boolean isAbove(float min, float... values)
	{
		for(float value : values)
			if(min >= value) return false;
		
		return true;
	}
	
	public static boolean isAbove(double min, double... values)
	{
		for(double value : values)
			if(min >= value) return false;
		
		return true;
	}
	
	
	
	public static boolean isAboveOOO(int min, int... values)
	{
		for(int value : values)
			if(min < value) return true;
		
		return false;
	}
	
	public static boolean isAboveOOO(long min, long... values)
	{
		for(long value : values)
			if(min < value) return true;
		
		return false;
	}
	
	public static boolean isAboveOOO(float min, float... values)
	{
		for(float value : values)
			if(min < value) return true;
		
		return false;
	}
	
	public static boolean isAboveOOO(double min, double... values)
	{
		for(double value : values)
			if(min < value) return true;
		
		return false;
	}
	
	

	public static boolean isNullOrEmpty(String str)
	{
		if(str == null) return true;
		
		return (str.equals("") || str == "") && str.length() == 0;
	}
	public static <A> boolean isNullOrEmpty(A[] arg)
	{
		if(arg == null) return true;
		
		return arg.length == 0;
	}
	
	public static <A> boolean isNullOrEmpty(List<A> list)
	{
		if(list == null) return true;
		
		return list.size() == 0;
	}
	
	
	
	public static <A> boolean isEmpty(List<A> list)
	{
		return list.size() == 0;
	}
	
	public static <A> boolean isEmpty(A[] arg)
	{
		return arg.length == 0;
	}
	
	public static boolean isEmpty(String str)
	{
		return (str.equals("") || str == "") && str.length() == 0;
	}
	
	
	
	
	
	public static boolean notTrue(boolean expression) { return !expression; }
	
	
	
	public static boolean notTrue(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(expression) return false;
		
		return true;
	}		
	
	
	
	public static boolean notTrueOOO(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(!expression) return true;
		
		return false;
	}	
	
	
	
	public static boolean notFalse(boolean expression) { return expression; }
	
	
	
	public static boolean notFalse(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(!expression) return false;
		
		return true;
	}
	

	
	public static boolean notFalseOOO(boolean... expressions)
	{
		for(boolean expression : expressions)
			if(expression) return true;
		
		return false;
	}

	
	
	public static boolean notEqual(boolean expected, boolean value) { return value != expected; }
	public static boolean notEqual(int expected, int value) { return value != expected; }
	public static boolean notEqual(long expected, long value) { return value != expected; }
	public static boolean notEqual(float expected, float value) { return value != expected; }
	public static boolean notEqual(double expected, double value) { return value != expected; }
	
	public static boolean notEqual(String expected, String value)
	{
		if(expected == null) return value != null;
		
		return !value.equals(expected);
	}	
	public static <A> boolean notEqual(A expected, A value)
	{
		if(expected == null) return value != null;
		
		return !expected.equals(value) && expected != value;
	}
	
	
	
	public static boolean notEqual(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(value == expected) return false;
		
		return true;
	}
	public static boolean notEqual(int expected, int... values)
	{
		for(int value : values)
			if(value == expected) return false;
		
		return true;
	}
	public static boolean notEqual(long expected, long... values)
	{
		for(long value : values)
			if(value == expected) return false;
		
		return true;
	}
	public static boolean notEqual(float expected, float...values)
	{
		for(float value : values)
			if(value == expected) return false;
		
		return true;
	}
	public static boolean notEqual(double expected, double... values)
	{
		for(double value : values)
			if(value == expected) return false;
		
		return true;
	}
	
	public static boolean notEqual(String expected, String... values)
	{
		for(String value : values)
		{
			if(expected == null) if(value == null) return false;
			
			if(value.equals(expected)) return false;
		}
		
		return true;
	}
	@SafeVarargs
	public static <A> boolean notEqual(A expected, A... values)
	{
		for(A value : values)
		{
			if(expected == null) if(value == null) return false;
			if(value.equals(expected) || value == expected) return false;
		}
		
		return true;
	}
	
	
	
	public static boolean notEqualOOO(boolean expected, boolean... values)
	{
		for(boolean value : values)
			if(value != expected) return true;
		
		return false;
	}
	public static boolean notEqualOOO(int expected, int... values)
	{
		for(int value : values)
			if(value != expected) return true;
		
		return false;
	}
	public static boolean notEqualOOO(long expected, long... values)
	{
		for(long value : values)
			if(value != expected) return true;
		
		return false;
	}
	public static boolean notEqualOOO(float expected, float... values)
	{
		for(float value : values)
			if(value != expected) return true;
		
		return false;
	}
	public static boolean notEqualOOO(double expected, double... values)
	{
		for(double value : values)
			if(value != expected) return true;
		
		return false;
	}
	
	public static boolean notEqualOOO(String expected, String... values)
	{
		for(String value : values)
		{
			if(expected == null) if(value != null) return true;
			if(!value.equals(expected)) return true;
		}
			
		
		return false;
	}
	@SafeVarargs
	public static <A> boolean notEqualOOO(A expected, A... values)
	{
		for(A value : values)
		{
			if(expected == null) if(value != null) return true;
			if(!value.equals(expected) || value != expected) return true;
		}
		
		return false;
	}
	
	public static <A> boolean notNull(A object) { return object != null; }
	
	
	
	@SafeVarargs
	public static <A> boolean notNull(A... objects)
	{
		for(A object : objects)
			if(object == null) return false;
		
		return true;
	}
	
	
	
	@SafeVarargs
	public static <A> boolean notNullOOO(A... objects)
	{
		for(A object : objects)
			if(object != null) return true;
		
		return false;
	}

	

	public static boolean notInBetween(int min, int max, int value) { return min >= value || value >= max; }
	public static boolean notInBetween(long min, long max, long value) { return min >= value || value >= max; }
	public static boolean notInBetween(float min, float max, float value) { return min >= value || value >= max; }	
	public static boolean notInBetween(double min, double max, double value) { return min >= value || value >= max; }
	
	
	
	public static boolean notInBetween(int min, int max, int... values)
	{
		for(int value : values)
			if(min < value && value < max) return false;
		
		return true;
	}
	
	public static boolean notInBetween(long min, long max, long... values)
	{
		for(long value : values)
			if(min < value && value < max) return false;
		
		return true;
	}
	
	public static boolean notInBetween(float min, float max, float... values)
	{
		for(float value : values)
			if(min < value && value < max) return false;
		
		return true;
	}
	
	public static boolean notInBetween(double min, double max, double... values)
	{
		for(double value : values)
			if(min < value && value < max) return false;
		
		return true;
	}
	
	
	
	public static boolean notInBetweenOOO(int min, int max, int... values)
	{
		for(int value : values)
			if(min >= value || value >= max) return true;
		
		return false;
	}
	
	public static boolean notInBetweenOOO(long min, long max, long... values)
	{
		for(long value : values)
			if(min >= value || value >= max) return true;
		
		return false;
	}
	
	public static boolean notInBetweenOOO(float min, float max, float... values)
	{
		for(float value : values)
			if(min >= value || value >= max) return true;
		
		return false;
	}
	
	public static boolean notInBetweenOOO(double min, double max, double... values)
	{
		for(double value : values)
			if(min >= value || value >= max) return true;
		
		return false;
	}

	
	
	public static boolean notInRange(int min, int max, int value) { return min > value || value > max; }
	public static boolean notInRange(long min, long max, long value) { return min > value || value > max; }
	public static boolean notInRange(float min, float max, float value) { return min > value || value > max; }	
	public static boolean notInRange(double min, double max, double value) { return min > value || value > max; }
	

	
	public static boolean notInRange(int min, int max, int... values)
	{
		for(int value : values)
			if(min <= value && value <= max) return false;
		
		return true;
	}
	
	public static boolean notInRange(long min, long max, long... values)
	{
		for(long value : values)
			if(min <= value && value <= max) return false;
		
		return true;
	}
	
	public static boolean notInRange(float min, float max, float... values)
	{
		for(float value : values)
			if(min <= value && value <= max) return false;
		
		return true;
	}
	
	public static boolean notInRange(double min, double max, double... values)
	{
		for(double value : values)
			if(min <= value && value <= max) return false;
		
		return true;
	}
	
	
	
	public static boolean notInRangeOOO(int min, int max, int... values)
	{
		for(int value : values)
			if(min > value || value > max) return true;
		
		return false;
	}
	
	public static boolean notInRangeOOO(long min, long max, long... values)
	{
		for(long value : values)
			if(min > value || value > max) return true;
		
		return false;
	}
	
	public static boolean notInRangeOOO(float min, float max, float... values)
	{
		for(float value : values)
			if(min > value || value > max) return true;
		
		return false;
	}
	
	public static boolean notInRangeOOO(double min, double max, double... values)
	{
		for(double value : values)
			if(min > value || value > max) return true;
		
		return false;
	}
	
	
	
	public static boolean notBelow(int max, int value) { return value >= max; }
	public static boolean notBelow(long max, long value) { return value >= max; }
	public static boolean notBelow(float max, float value) { return value >= max; }
	public static boolean notBelow(double max, double value) { return value >= max; }
	

	
	public static boolean notBelow(int max, int... values)
	{
		for(int value : values)
			if(value < max) return false;
		
		return true;
	}
	
	public static boolean notBelow(long max, long... values)
	{
		for(long value : values)
			if(value < max) return false;
		
		return true;
	}
	
	public static boolean notBelow(float max, float... values)
	{
		for(float value : values)
			if(value < max) return false;
		
		return true;
	}
	
	public static boolean notBelow(double max, double... values)
	{
		for(double value : values)
			if(value < max) return false;
		
		return true;
	}
	
	
	
	public static boolean notBelowOOO(int max, int... values)
	{
		for(int value : values)
			if(value >= max) return true;
		
		return false;
	}
	
	public static boolean notBelowOOO(long max, long... values)
	{
		for(long value : values)
			if(value >= max) return true;
		
		return false;
	}
	
	public static boolean notBelowOOO(float max, float... values)
	{
		for(float value : values)
			if(value >= max) return true;
		
		return false;
	}
	
	public static boolean notBelowOOO(double max, double... values)
	{
		for(double value : values)
			if(value >= max) return true;
		
		return false;
	}
	
	
	
	public static boolean notAbove(int min, int value) { return min >= value; }
	public static boolean notAbove(long min, long value) { return min >= value; }
	public static boolean notAbove(float min, float value) { return min >= value; }
	public static boolean notAbove(double min, double value) { return min >= value; }
	
	
	
	public static boolean notAbove(int min, int... values)
	{
		for(int value : values)
			if(min < value) return false;
		
		return true;
	}
	
	public static boolean notAbove(long min, long... values)
	{
		for(long value : values)
			if(min < value) return false;
		
		return true;
	}
	
	public static boolean notAbove(float min, float... values)
	{
		for(float value : values)
			if(min < value) return false;
		
		return true;
	}
	
	public static boolean notAbove(double min, double... values)
	{
		for(double value : values)
			if(min < value) return false;
		
		return true;
	}
	
	
	
	public static boolean notAboveOOO(int min, int... values)
	{
		for(int value : values)
			if(min >= value) return true;
		
		return false;
	}
	
	public static boolean notAboveOOO(long min, long... values)
	{
		for(long value : values)
			if(min >= value) return true;
		
		return false;
	}
	
	public static boolean notAboveOOO(float min, float... values)
	{
		for(float value : values)
			if(min >= value) return true;
		
		return false;
	}
	
	public static boolean notAboveOOO(double min, double... values)
	{
		for(double value : values)
			if(min >= value) return true;
		
		return false;
	}
	
	

	public static boolean notNullOrEmpty(String str)
	{
		if(str == null) return false;
		
		return !str.equals("") && str != "";
	}
	
	public static <A> boolean notNullOrEmpty(A[] arg)
	{
		if(arg == null) return false;
		
		return arg.length > 0;
	}
	public static <A> boolean notNullOrEmpty(List<A> list)
	{
		if(list == null) return false;
		
		return list.size() > 0;
	}
		
	public static <A> boolean notEmpty(List<A> list)
	{
		return list.size() > 0;
	}
	
	public static <A> boolean notEmpty(A[] arg)
	{
		return arg.length > 0;
	}
	
	public static boolean notEmpty(String str)
	{
		return !str.equals("") && str != "";
	}
}
