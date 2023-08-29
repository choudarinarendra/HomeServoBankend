package com.jsp.HomeServo.Exception;

public class EmailNotFound extends RuntimeException{
	private static String message="enter currect email";

	public EmailNotFound(String message) {
		super(message);
		
	}

	public EmailNotFound() {
		super(message);
	}
	
}
