package com.gullyshops.repository.core;

import java.util.List;

import com.gullyshops.exception.ElementNotFoundException;
import com.gullyshops.repository.exception.RepositoryException;


/**
 * 
 * @author Munisekhar
 *
 * @param <T>
 */

public interface GenericRepository<T> {

	void save(T bean) throws RepositoryException;

	void save(T bean, boolean generatedKeyRequired) throws RepositoryException;
	void save(List<T> beans) throws RepositoryException;

	T queryForObject(String sql, Class<T> elementType) throws RepositoryException;

	T queryForObject(String sql, Object[] params, Class<T> elementType) throws RepositoryException;

	List<T> queryForList(String sql, Class<T> elementType) throws RepositoryException;

	List<T> queryForList(String sql, Object[] params, Class<T> elementType) throws RepositoryException;

	boolean update(T bean) throws ElementNotFoundException;

	boolean update(String sql) throws RepositoryException;

	boolean update(String sql, Object[] params) throws RepositoryException;
	
	boolean delete(String sql) throws RepositoryException;

	boolean delete(String sql, Object[] params) throws RepositoryException;

	void postInsert(T bean, int autoIncrementedId);

	String  getSqlSelect();
	
	String  getSqlInsert();

	String  getSqlUpdate();
	
	String  getSqlDelete();
	
	int count(String sql) throws RepositoryException;
	
	int count(String sql, Object[] params) throws RepositoryException;

}

