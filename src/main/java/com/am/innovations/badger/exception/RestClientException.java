package com.am.innovations.badger.exception;

public class RestClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2426466608024692340L;

	public RestClientException() {
		super();
		// 
	}

	public RestClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// 
	}

	public RestClientException(String message, Throwable cause) {
		super(message, cause);
		// 
	}

	public RestClientException(String message) {
		super(message);
		// 
	}

	public RestClientException(Throwable cause) {
		super(cause);
		// 
	}

}
