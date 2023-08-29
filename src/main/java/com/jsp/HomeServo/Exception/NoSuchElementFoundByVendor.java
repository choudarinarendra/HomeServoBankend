package com.jsp.HomeServo.Exception;

public class NoSuchElementFoundByVendor extends RuntimeException {
	private static String message="Id is not present";

	public NoSuchElementFoundByVendor(String message) {
		super(message);
		
	}

	public NoSuchElementFoundByVendor() {
		super(message);
	}
}
