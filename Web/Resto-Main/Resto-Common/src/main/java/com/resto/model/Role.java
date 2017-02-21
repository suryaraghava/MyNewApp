package com.resto.model;

import java.io.Serializable;

/**
 * 
 * @author Munisekhar
 *
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private int userId;
	private String roleName;
	
	
	public Role() {

	}

	public Role(int roleId, int userId, String roleName) {
		super();
		this.roleId = roleId;
		this.userId = userId;
		this.roleName = roleName;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
