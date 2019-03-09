package com.cg.mra.exceptions;

public class ImproperInputException extends Exception{

	public ImproperInputException()
	{
		System.err.println("Invalid. Mobile number should be of 10 digits");
	}
}
