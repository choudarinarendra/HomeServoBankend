package com.jsp.HomeServo.Exception;

public class NoSuchElementFoundByAddress  extends RuntimeException{
	private static String message="No Id value present";
   public NoSuchElementFoundByAddress(String message) {
	   super(message);
   }
   public NoSuchElementFoundByAddress() {
	   super(message);
   }
}
