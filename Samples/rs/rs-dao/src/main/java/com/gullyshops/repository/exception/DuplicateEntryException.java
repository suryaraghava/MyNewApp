package com.gullyshops.repository.exception;

/**
 * 
 * @author Munisekhar
 *
 */
public class DuplicateEntryException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public DuplicateEntryException(String message) {
        super(message);
    }

    public DuplicateEntryException(Throwable cause) {
        super(cause);
    }

    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }
}
