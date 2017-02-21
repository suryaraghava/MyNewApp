package com.gullyshops.repository.user.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.gullyshops.model.Role;
import com.gullyshops.repository.core.impl.GenericRepositoryImpl;
import com.gullyshops.repository.exception.RepositoryException;
import com.gullyshops.repository.user.RoleRepository;

/**
 * 
 * @author Munisekhar
 *
 */
@Repository("roleRepo")
public class RoleRepositoryImpl extends GenericRepositoryImpl<Role> implements RoleRepository {

	private static final String SQL_SELECT = 
			"select role_id, user_id, role_name from role where user_id = ?";

	private static final String SQL_INSERT = 
			"insert into user (user_id, role_name) values(:userId,:roleName)";
	
	private static final String SQL_UPDATE = null;

	private static final String SQL_DELETE = 
			"delete from user where user_id = ?";

	@Override
	public void postInsert(Role bean, int autoIncrementedId) {
		bean.setRoleId(autoIncrementedId);
	}
	
	@Override
	public List<Role> findBy(int userId) throws RepositoryException {
		return queryForList(SQL_SELECT, new Object[]{userId}, Role.class);
	}

	@Override
	public String getSqlSelect() {
		return SQL_SELECT ;
	}

	@Override
	public String getSqlInsert() {
		return SQL_INSERT ;
	}

	@Override
	public String getSqlUpdate() {
		return SQL_UPDATE ;
	}

	@Override
	public String getSqlDelete() {
		return SQL_DELETE ;
	}

}
