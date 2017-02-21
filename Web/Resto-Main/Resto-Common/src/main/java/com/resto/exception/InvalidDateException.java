package com.resto.exception;

import java.io.IOException;

/**
 * 
 * @author Munisekhar
 *
 */
public class InvalidDateException extends IOException {

	private static final long serialVersionUID = 1L;
	
	public InvalidDateException(String errMsg) {
		super(errMsg);
	}

	public InvalidDateException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDateException(Throwable cause) {
		super(cause);
	}

}
