package com.resto.web.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.resto.model.User;

/**
 * 
 * @author Munisekhar
 *
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = 1L;
	private User user;
	
    public CurrentUser(User user, Set<GrantedAuthority> authorities) {
        super(user.getUserName(),user.getPassword(), true, true, true, true, authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
