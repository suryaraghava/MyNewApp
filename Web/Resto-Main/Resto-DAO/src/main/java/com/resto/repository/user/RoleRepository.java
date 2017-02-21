package com.resto.repository.user;

import java.util.List;

import com.resto.model.Role;
import com.resto.repository.core.GenericRepository;
import com.resto.repository.exception.RepositoryException;

/**
 * 
 * @author Munisekhar
 *
 */
public interface RoleRepository extends GenericRepository<Role> {
	
	public List<Role> findBy( int userId) throws RepositoryException;
	

}
