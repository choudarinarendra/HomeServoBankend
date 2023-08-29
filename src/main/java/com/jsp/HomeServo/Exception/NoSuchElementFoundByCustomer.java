package com.jsp.HomeServo.Exception;

public class NoSuchElementFoundByCustomer extends RuntimeException{
	private static String message="in valid id in your program";

	public NoSuchElementFoundByCustomer(String message) {
		super(message);
		
	}

	public NoSuchElementFoundByCustomer() {
		super(message);
	}

}
