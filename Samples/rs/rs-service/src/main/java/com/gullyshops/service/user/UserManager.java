package com.gullyshops.service.user;

import java.util.List;

import com.gullyshops.exception.ServiceException;
import com.gullyshops.model.User;
import com.gullyshops.service.core.AbstractService;

public interface UserManager extends AbstractService<User> {
	
	public boolean exists( String userName ) throws ServiceException, IllegalArgumentException;
	
	public User findOne( int userId) throws ServiceException , IllegalArgumentException;
	
	public User findOne( String userName ) throws ServiceException , IllegalArgumentException;
	
	public User findOne(String userName, String password) throws ServiceException;
	
	public List<User> findAll() throws ServiceException;
	
	public boolean updatePassword( int userId, String password ) throws ServiceException, IllegalArgumentException;
	
}