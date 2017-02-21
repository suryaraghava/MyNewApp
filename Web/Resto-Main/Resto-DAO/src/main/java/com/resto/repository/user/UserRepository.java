package com.resto.repository.user;

import java.util.List;

import com.resto.exception.ElementNotFoundException;
import com.resto.model.User;
import com.resto.repository.core.GenericRepository;

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
