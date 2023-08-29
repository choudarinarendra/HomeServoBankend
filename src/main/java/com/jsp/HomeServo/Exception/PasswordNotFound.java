package com.jsp.HomeServo.Exception;

public class PasswordNotFound extends RuntimeException{
	private static String message="password is not currect";

	public PasswordNotFound(String message) {
		super(message);
	
	}

	public PasswordNotFound() {
		super(message);
	}
}
