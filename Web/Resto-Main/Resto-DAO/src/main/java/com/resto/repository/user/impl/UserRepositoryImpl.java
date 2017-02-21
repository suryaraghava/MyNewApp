package com.resto.repository.user.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.resto.exception.ElementNotFoundException;
import com.resto.model.User;
import com.resto.repository.core.impl.GenericRepositoryImpl;
import com.resto.repository.user.UserRepository;


@Repository("userRepo")
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository {

	private static final String SQL_SELECT = 
			"select user_id, user_name, password, first_name, last_name, gender, email, height, weight, date, month, year, image, is_pass_change_req, phone from users where user_id = ?";

	private static final String SQL_FIND_BY_USERNAME = 
			"select * from users where USER_NAME = ?";
	
	private static final String SQL_FIND_BY_USERNAME_PWD = 
			"select * from user where user_name = ? and password = ?";

	private static final String SQL_INSERT = 
			"insert into users ( user_name, password, first_name, last_name, gender, email, height, weight, date, month, year, image, is_pass_change_req, phone) values(:userName,:password,:firstName,:lastName,:gender,:email,:height,:weight,:date,:month,:year,:image,:isPassChangeReq,:phone)";

	private static final String SQL_UPDATE = 
			"update users set user_name =:userName, password =:password, first_name =:firstName, last_name =:lastName, gender =:gender, email =:email, height =:height, weight =:weight, date =:date, month =:month, year =:year, image =:image, is_pass_change_req =:isPassChangeReq, phone =:phone where user_id =:userId";

	private static final String SQL_UPDATE_PASSWORD = 
			"update users set password =? where user_id =?";

	private static final String SQL_DELETE = 
			"delete from users where user_id = ?";
	
	private static final String SQL_FIND_ALL = 
			"select * from users";

	@Override
	public void postInsert(User bean, int autoIncrementedId) {
		bean.setUserId(autoIncrementedId);
	}

	@Override
	public boolean exists(String userName) {
		int count = count(SQL_FIND_BY_USERNAME, new Object[]{userName});
		return (count > 0) ? true:false;
	}

	@Override
	public User findOne(int userId) throws ElementNotFoundException {
		User u = queryForObject(getSqlSelect(), new Object[]{ userId }, User.class);
		if(u == null){
			throw new ElementNotFoundException("User Not Found");
		}
		return u;
	}

	@Override
	public User findOne(String userName) {
		return queryForObject(SQL_FIND_BY_USERNAME, new Object[]{ userName }, User.class);
	}
	
	@Override
	public List<User> findAll() {
		return queryForList(SQL_FIND_ALL, User.class);
	}
	
	@Override
	public User findOne(String userName, String password) {
		return queryForObject(SQL_FIND_BY_USERNAME_PWD, new Object[]{ userName, password }, User.class);
	}

	@Override
	public boolean updatePassword(int userId, String password) {
		return update(SQL_UPDATE_PASSWORD, new Object[]{password, userId});
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
