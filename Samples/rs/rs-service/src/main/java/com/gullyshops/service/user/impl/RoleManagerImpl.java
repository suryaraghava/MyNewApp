package com.gullyshops.service.user.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullyshops.exception.ServiceException;
import com.gullyshops.model.Role;
import com.gullyshops.repository.exception.ExceptionTranslator;
import com.gullyshops.repository.exception.RepositoryException;
import com.gullyshops.repository.user.RoleRepository;
import com.gullyshops.service.user.RoleManager;

@Service("roleManager")
public class RoleManagerImpl implements RoleManager {
	
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void save(Role role) throws ServiceException {
		try{
			roleRepository.save(role,true);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
	}
	
	@Override
	public List<Role> findBy(int roleId) throws ServiceException, IllegalArgumentException {
		try{
			return roleRepository.findBy(roleId);
		} catch(RepositoryException ex) {
			ExceptionTranslator.toServiceException(ex);
		}
		return null;
	}
	
	@Override
	public void save(List<Role> beans) throws ServiceException, IllegalArgumentException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean update(Role bean) throws ServiceException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}
	
}

