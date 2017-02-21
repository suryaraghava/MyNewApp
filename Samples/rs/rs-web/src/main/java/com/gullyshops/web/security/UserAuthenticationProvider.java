package com.gullyshops.web.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gullyshops.exception.ServiceException;
import com.gullyshops.model.Role;
import com.gullyshops.model.User;
import com.gullyshops.service.user.RoleManager;
import com.gullyshops.service.user.UserManager;
import com.gullyshops.web.model.CurrentUser;
/**
 * 
 * @author Munisekhar
 *
 */
@Service("userAuth")
public class UserAuthenticationProvider implements UserDetailsService {

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private RoleManager roleManager;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			User user = userManager.findOne(username);
			if(user != null) {
				List<Role> roles = roleManager.findBy(user.getUserId());
				Set<GrantedAuthority> authorities = getRoles(roles);
				
				return new CurrentUser(user, authorities);
			} else{
				throw new UsernameNotFoundException("Invalid credentials");
			}
		} catch (IllegalArgumentException | ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Set<GrantedAuthority> getRoles(List<Role> roles) {
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		if(roles != null && roles.size() > 0) {
			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
		}
		return authorities;
	}
}
