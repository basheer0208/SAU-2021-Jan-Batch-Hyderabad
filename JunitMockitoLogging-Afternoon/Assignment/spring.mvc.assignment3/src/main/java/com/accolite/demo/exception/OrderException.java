package com.accolite.demo.exception;

public class OrderException extends Exception {
	
	private String message;

	  public OrderException(String message) {
	    super();
	    this.message = message;
	    System.out.println(message);
	  }
	  
//	  public OrderException() {}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}

}
