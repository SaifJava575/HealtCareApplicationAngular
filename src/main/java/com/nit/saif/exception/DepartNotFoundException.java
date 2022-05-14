package com.nit.saif.exception;

public class DepartNotFoundException extends RuntimeException {
	private static final long serialVersionUID=1L;
	
	public DepartNotFoundException() {
		super();
	}
	
	public DepartNotFoundException(String message) {
		super(message);
	}
}
