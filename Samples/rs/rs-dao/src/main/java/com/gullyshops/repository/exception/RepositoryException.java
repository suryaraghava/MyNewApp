package com.gullyshops.repository.exception;

/**
 * 
 * @author Munisekhar
 *
 */
public class RepositoryException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
