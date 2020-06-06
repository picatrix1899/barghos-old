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

package org.barghos.core.util;

import java.lang.reflect.Array;
import java.util.List;


/**
 * 
 * @author picatrix1899
 *
 */
public class ListUtils
{
	/**
	 * Finds the occurences of "element" in "list" and return their indices.
	 * @param list The list to search.
	 * @param element The value to find.
	 * @return An array of the indices of each occurence of "element" in "list".
	 */
	public static <A> int[] indicesOf(List<A> list, A element)
	{
		int occurences = ListUtils.occurrencesOf(list, element);

		if(occurences == 0) return null;
		
		int[] out = new int[occurences]; 
		
		int index = 0;
		
		int i = 0;
		for(; i < list.size(); i++)
		{
			
			if(list.get(i).equals(element) || list.get(i) == element)
			{
				out[index] = i;
				index++;
			}		
		}
		
		return out;
	}
	
	/**
	 * Counts the occurences of "a" in "list".
	 * @param list The list to search.
	 * @param element The value to find.
	 * @return The total count of occurences of "a" in "list".
	 */
	public static <A> int occurrencesOf(List<A> list, A element)
	{
		int i = 0;
		
		for(A val : list)
		{
			if(val.equals(element) || val == element)
			{
				i++;
			}
		}
		
		return i;
	}
	
	/**
	 * Converts a generic {@link List} into an array using the given class.
	 * @param list The list to convert.
	 * @param clazz The type of the List and of the resulting array.
	 * @return An array of given type with the elements of list.
	 */
	public static <A> A[] ListToArray(List<A> list, Class<A> clazz)
	{
		
		@SuppressWarnings("unchecked")
		A[] out = (A[]) Array.newInstance(clazz, list.size());
		
		out = list.<A>toArray(out);
		
		return out;
	
	}
	
	/**
	 * Converts a {@link List} of {@link Integer} into an int array.
	 * @param list The list to convert.
	 * @return An int array with the elements of a
	 */
	public static int[] toIntArray(List<Integer> list)
	{
		int[] out = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{
			out[i] = list.get(i);
		}
		
		return out;
	}
	
	/**
	 * Converts a {@link List} of {@link Byte} into an byte array.
	 * @param list The list to convert.
	 * @return An byte array with the elements of a
	 */
	public static byte[] toByteArray(List<Byte> list)
	{
		byte[] out = new byte[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{
			out[i] = list.get(i);
		}
		
		return out;
	}
	
	/**
	 * Converts a {@link List} of {@link Float} into an float array.
	 * @param list The list to convert.
	 * @return An float array with the elements of a
	 */
	public static float[] toFloatArray(List<Float> list)
	{
		float[] out = new float[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{
			out[i] = list.get(i);
		}
		
		return out;
	}
	
	/**
	 * Prints a List of all items in a List. This is equivalent to interate through a list and call toString for every element.
	 * @param list
	 * @return
	 */
	public static <T> String iterativeToString(List<T> list)
	{
		int size = list.size();
		
		if(size == 0) return "{}";
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("{\n");
		
		for(int i = 0; i < size ; i++)
			builder.append(list.get(i) + "\n");
		
		builder.append("}\n");
		
		return builder.toString();
	}
}