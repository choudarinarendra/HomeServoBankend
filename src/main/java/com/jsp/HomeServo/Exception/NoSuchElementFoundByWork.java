package com.jsp.HomeServo.Exception;

public class NoSuchElementFoundByWork  extends RuntimeException{
	private static String message="work id not present ";
	public NoSuchElementFoundByWork(String message) {
		super(message);
	}
  public NoSuchElementFoundByWork() {
	  super(message);
  }
}
