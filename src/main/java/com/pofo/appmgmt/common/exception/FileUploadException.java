package com.pofo.appmgmt.common.exception;

public class FileUploadException extends RuntimeException {

	private static final long serialVersionUID = -5945460323042361036L;

	public FileUploadException() {
		super();
	}
	
	public FileUploadException(final String message) {
		super(message);
	}
	
	public FileUploadException(String message, Throwable e) {
		super(message, e);
	}
}
