package com.resto.service.user;

import java.util.List;

import com.resto.exception.ServiceException;
import com.resto.model.Role;
import com.resto.service.core.AbstractService;

public interface RoleManager extends AbstractService<Role> {
	
	
	public List<Role> findBy(int userId) throws ServiceException , IllegalArgumentException;
	
}
