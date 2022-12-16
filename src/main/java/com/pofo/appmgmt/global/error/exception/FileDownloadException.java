package com.pofo.appmgmt.global.error.exception;

public class FileDownloadException extends RuntimeException {

	private static final long serialVersionUID = -531574244477157609L;

	public FileDownloadException() {
		super();
	}
	
	public FileDownloadException(final String message) {
		super(message);
	}
	
	public FileDownloadException(String message, Throwable e) {
		super(message, e);
	}
}
