package com.gullyshops.repository.user;

import java.util.List;

import com.gullyshops.exception.ElementNotFoundException;
import com.gullyshops.model.User;
import com.gullyshops.repository.core.GenericRepository;

/**
 * 
 * @author Munisekhar
 *
 */
public interface UserRepository extends GenericRepository<User> {
	
	public boolean exists( String userName );
	
	public User findOne( int userId) throws ElementNotFoundException;
	
	public User findOne( String userName );
	
	User findOne(String userName, String password);
	
	List<User> findAll();
	
	public boolean updatePassword( int userId, String password );

}
