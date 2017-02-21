package com.resto.service.user.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resto.exception.ServiceException;
import com.resto.model.User;
import com.resto.repository.exception.ExceptionTranslator;
import com.resto.repository.exception.RepositoryException;
import com.resto.repository.user.UserRepository;
import com.resto.service.user.UserManager;

@Service("userManager")
@Transactional
public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) throws ServiceException {
		try{
			userRepository.save(user,true);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
	}
	
	@Override
	public boolean exists(String userName) throws ServiceException, IllegalArgumentException {
		try{
			return userRepository.exists(userName);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return false;
	}

	@Override
	public User findOne(int userId) throws ServiceException, IllegalArgumentException {
		try{
			return userRepository.findOne(userId);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return null;
	}

	@Override
	public User findOne(String userName) throws ServiceException, IllegalArgumentException {
		try{
			return userRepository.findOne(userName);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return null;
	}
	
	@Override
	public User findOne(String userName, String password) throws ServiceException {
		try{
			return userRepository.findOne(userName, password);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return null;
	}

	@Override
	public boolean update(User user) throws ServiceException, IllegalArgumentException {
		try{
			return userRepository.update(user);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return false;
	}
	
	@Override
	public boolean updatePassword(int userId, String password) throws ServiceException, IllegalArgumentException {
		try{
			return userRepository.updatePassword(userId, password);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return false;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAll() throws ServiceException {
		try{
			return userRepository.findAll();
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return null;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Override
	public void save(List<User> beans) throws ServiceException, IllegalArgumentException {
		// TODO Auto-generated method stub
	}
	
}

