package com.cg.mra.exceptions;

public class InvalidCustomerException extends Exception{

	public InvalidCustomerException()
	{
		System.err.println("Given Account ID does not exist");
	}
}
