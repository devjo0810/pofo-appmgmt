package com.pofo.appmgmt.common.exception;

public class NotLoginException extends RuntimeException {

	private static final long serialVersionUID = 2304777189845780460L;
	
	public NotLoginException() {
		super();
	}
	
	public NotLoginException(final String message) {
		super(message);
	}
	
	public NotLoginException(String message, Throwable e) {
		super(message, e);
	}
}
