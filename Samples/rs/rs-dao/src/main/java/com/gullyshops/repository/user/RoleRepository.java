package com.gullyshops.repository.user;

import java.util.List;

import com.gullyshops.model.Role;
import com.gullyshops.repository.core.GenericRepository;
import com.gullyshops.repository.exception.RepositoryException;

/**
 * 
 * @author Munisekhar
 *
 */
public interface RoleRepository extends GenericRepository<Role> {
	
	public List<Role> findBy( int userId) throws RepositoryException;
	

}
