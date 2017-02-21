package com.gullyshops.exception;

/**
 * 
 * @author Munisekhar
 *
 */
public class UserTypeMisMatchException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public UserTypeMisMatchException(int errCode, String errMsg) {
		super(errCode, errMsg);
	}

	public UserTypeMisMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserTypeMisMatchException(String message) {
		super(message);
	}

	public UserTypeMisMatchException(Throwable cause) {
		super(cause);
	}
}
