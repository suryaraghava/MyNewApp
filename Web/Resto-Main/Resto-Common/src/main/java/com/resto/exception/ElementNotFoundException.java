package com.resto.exception;

/**
 * 
 * @author Munisekhar
 *
 */
public class ElementNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;
	
	public ElementNotFoundException(String errMsg) {
		super(404, errMsg);
	}

	public ElementNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElementNotFoundException(Throwable cause) {
		super(cause);
	}
}
