package com.gullyshops.exception;

/**
 * 
 * @author Munisekhar
 *
 */
public class DataNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(int errCode, String errMsg) {
		super(errCode, errMsg);
	}

	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotFoundException(String message) {
		super(message);
	}

	public DataNotFoundException(Throwable cause) {
		super(cause);
	}
}
