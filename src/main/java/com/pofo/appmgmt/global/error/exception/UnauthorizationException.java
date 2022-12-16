package com.pofo.appmgmt.global.error.exception;

public class UnauthorizationException extends RuntimeException {

	private static final long serialVersionUID = -7395924439584649286L;

	public UnauthorizationException() {
		super();
	}
	
	public UnauthorizationException(final String message) {
		super(message);
	}
	
	public UnauthorizationException(String message, Throwable e) {
		super(message, e);
	}
}
