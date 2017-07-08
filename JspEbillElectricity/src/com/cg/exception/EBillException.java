package com.cg.exception;

public class EBillException extends Exception {
	
	String message;
	
	public EBillException(String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

}
