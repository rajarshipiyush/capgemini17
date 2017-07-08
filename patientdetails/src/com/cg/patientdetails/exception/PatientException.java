package com.cg.patientdetails.exception;

public class PatientException extends Exception {
	
	String message;
	
	public PatientException(String message)
	{
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
