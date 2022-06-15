package com.pofo.appmgmt.common.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 6569330219210485989L;

	public ValidationException() {
		super();
	}
	
	public ValidationException(final String message) {
		super(message);
	}
	
	public ValidationException(String message, Throwable e) {
		super(message, e);
	}
}
