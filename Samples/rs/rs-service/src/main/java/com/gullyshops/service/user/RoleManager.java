package com.gullyshops.service.user;

import java.util.List;

import com.gullyshops.exception.ServiceException;
import com.gullyshops.model.Role;
import com.gullyshops.service.core.AbstractService;

public interface RoleManager extends AbstractService<Role> {
	
	
	public List<Role> findBy(int userId) throws ServiceException , IllegalArgumentException;
	
}
