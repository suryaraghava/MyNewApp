package com.gullyshops.exception;

/**
 * 
 * @author Munisekhar
 *
 */
public class AlreadyExistsException extends ServiceException {

	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	public AlreadyExistsException(int errCode, String errMsg) {
		super(errCode, errMsg);
	}

	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyExistsException(String message) {
		super(message);
	}

	public AlreadyExistsException(Throwable cause) {
		super(cause);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
