package com.resto.web.security;

/**
 * 
 * @author Munisekhar
 *
 */
public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
