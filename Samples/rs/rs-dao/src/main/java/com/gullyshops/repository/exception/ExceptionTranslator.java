package com.gullyshops.repository.exception;

import org.springframework.dao.DataAccessException;

import com.gullyshops.exception.ServiceException;

/**
 * 
 * @author Munisekhar
 *
 */
public final class ExceptionTranslator {
	
	public static void toRespositoryException(String msg, DataAccessException ex) {
		throw new RepositoryException(msg, ex);
	}
	
	
	public static void toRespositoryException(String msg) {
		throw new RepositoryException(msg);
	}
	
	public static void toServiceException(String msg, RepositoryException ex) throws ServiceException {
		throw new ServiceException(msg, ex);
	}
	
	public static void toServiceException(RepositoryException ex) throws ServiceException {
		throw new ServiceException(ex.getMessage(), ex);
	}
	
	public static void toServiceException(String msg) throws ServiceException {
		throw new ServiceException(msg);
	}
	
}
