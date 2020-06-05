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

package org.barghos.core.exception;

/**
 * @author picatrix1899
 *
 * Thrown to indicate that a method has been passed an argument that is null but must not be null.
 */
public class ArgumentNullException extends IllegalArgumentException
{
	private static final long serialVersionUID = 1L;
	
	private String argument;
	
	public ArgumentNullException()
	{
		super();
	}
	
	public ArgumentNullException(String argument)
	{
		super();
		this.argument = argument;
	}
	
	public ArgumentNullException(String argument, String message)
	{
		super(message);
		this.argument = argument;
	}
	
	public ArgumentNullException(String argument, String message, Throwable cause)
	{
		super(message, cause);
		this.argument = argument;
	}
	
	public String getMessage()
	{
		StringBuilder builder = new StringBuilder();
		if(!this.argument.isBlank())
		{
			builder.append("Argument: ");
			builder.append(this.argument);
		}
		
		if(super.getMessage() != null && !super.getMessage().isBlank())
		{
			if(!this.argument.isBlank()) builder.append("; Message: ");
			
			builder.append(super.getMessage());
		}
		
		return builder.toString();
	}
}
