package com.gullyshops.repository.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.Assert;

import com.gullyshops.exception.ElementNotFoundException;
import com.gullyshops.repository.core.GenericRepository;
import com.gullyshops.repository.exception.ExceptionTranslator;

/**
 * 
 * @author Munisekhar
 *
 * @param <T>
 */
public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> {
	
	@Autowired
	public NamedParameterJdbcTemplate namedJdbcTemplate;
	
	
	protected GenericRepositoryImpl() {
		super();
	}

	@Override
	public void save(T bean){
		Assert.notNull(bean, "The "+bean.getClass().getName()+" must not be null");
		int result = 0;
		try {
			result = namedJdbcTemplate.update(getSqlInsert(), getParameterSource(bean));
		} catch (DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to save ("+bean.getClass().getName()+")", ex);
		}
		if (result != 1) {
			ExceptionTranslator.toRespositoryException("Unexpected return value after INSERT : " + result + " (1 expected) ");
		}
	}
	
	@Override
	public void save(T bean, boolean generatedKeyRequired){
		Assert.notNull(bean, "The "+bean.getClass().getName()+" must not be null");
		if(generatedKeyRequired){
			KeyHolder keyHolder = getKeyHolder();
			int result = 0;
			try{
				result = namedJdbcTemplate.update(getSqlInsert(), getParameterSource(bean), keyHolder);
			} catch (DataAccessException ex) {
				ExceptionTranslator.toRespositoryException("Failed to save ("+bean.getClass().getName()+")", ex);
			}
			if (result != 1) {
				ExceptionTranslator.toRespositoryException("Unexpected return value after INSERT : " + result + " (1 expected) ");
			}else{
				postInsert(bean, keyHolder.getKey().intValue());
			}
		}else{
			save(bean);
		}
	}
	
	@Override
	public void save(List<T> beans){
		Assert.notNull(beans, "List must not be null");
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(beans.toArray());
		try{
			namedJdbcTemplate.batchUpdate(getSqlInsert(), params);
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to save list of objects in the batch update", ex);
		}
	}
	
	@Override
	public T queryForObject(String sql, Class<T> elementType){
		Assert.notNull(sql, "The SQL must not be null");
		Assert.notNull(elementType, "The elementType must not be null");
		T bean = null;
		try {
			bean = namedJdbcTemplate.getJdbcOperations().queryForObject(sql, getBeanPropertyRowMapper(elementType));
		} catch (EmptyResultDataAccessException ex) {
			return null;
		} catch (DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to retrieve "+elementType.getName()+" object", ex);
		}
		return bean;
	}
	
	@Override
	public T queryForObject(String sql, Object[] params, Class<T> elementType){
		Assert.notNull(sql, "The SQL must not be null");
		Assert.notNull(params, "The params that need to be binded to the query must not be null");
		Assert.notNull(elementType, "The elementType must not be null");
		T bean = null;
		try {
			bean = namedJdbcTemplate.getJdbcOperations().queryForObject(sql, params, getBeanPropertyRowMapper(elementType));
		} catch (EmptyResultDataAccessException ex) {
			return null;
		} catch (DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to retrieve "+elementType.getName()+" object", ex);
		}
		return bean;
	}
	
	@Override
	public List<T> queryForList(String sql, Class<T> elementType){
		Assert.notNull(sql, "The SQL must not be null");
		Assert.notNull(elementType, "The elementType must not be null");
		List<T> list = null;
		try {
			list = namedJdbcTemplate.getJdbcOperations().query(sql, getBeanPropertyRowMapper(elementType));
		} catch (DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to retrieve list of "+elementType.getName()+" objects", ex);
		}
		return list;
	}
	
	@Override
	public List<T> queryForList(String sql, Object[] params, Class<T> elementType){
		Assert.notNull(sql, "The SQL must not be null");
		Assert.notNull(params, "The params that need to be binded to the query must not be null");
		Assert.notNull(elementType, "The elementType must not be null");
		List<T> list = null;
		try {
			list = namedJdbcTemplate.getJdbcOperations().query(sql, params, getBeanPropertyRowMapper(elementType));
		} catch (DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to retrieve list of "+elementType.getName()+" objects", ex);
		}
		return list;
	}
	
	@Override
	public int count(String sql){
		Assert.notNull(sql, "The SQL must not be null");
		Integer result = null;
		try{
			result = namedJdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to find", ex);
		}
		return (result != null) ? result:0;
	}
	
	@Override
	public int count(String sql, Object[] params){
		Assert.notNull(sql, "The SQL must not be null");
		Assert.notNull(params, "The params that need to be binded to the query must not be null");
		Integer result = null;
		try{
			result = namedJdbcTemplate.getJdbcOperations().queryForObject(sql, params, Integer.class);
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to find", ex);
		}
		return (result != null) ? result:0;
	}
	
	@Override
	public boolean update(T bean) throws ElementNotFoundException {
		Assert.notNull(bean, "The "+bean.getClass().getName()+" must not be null");
		int result = 0;
		try{
			result = namedJdbcTemplate.update(getSqlUpdate(), getParameterSource(bean));
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to update ("+bean.getClass().getName()+")", ex);
		}
		return result > 0;
		
	}
	
	@Override
	public boolean update(String sql){
		Assert.notNull(sql, "The SQL must not be null");
		int result = 0;
		try{
			namedJdbcTemplate.getJdbcOperations().update(sql);
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to update", ex);
		}
		return result > 0;
		
	}
	
	@Override
	public boolean update(String sql, Object[] params){
		Assert.notNull(sql, "The SQL must not be null");
		Assert.notNull(params, "The params that need to be binded to the query must not be null");
		int result = 0;
		try{
			namedJdbcTemplate.getJdbcOperations().update(sql, params);
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to update", ex);
		}
		return result > 0;
		
	}
	
	@Override
	public boolean delete(String sql){
		int result = 0;
		try{
			namedJdbcTemplate.getJdbcOperations().update(sql);
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to delete", ex);
		}
		return result > 0;
	}
	
	@Override
	public boolean delete(String sql, Object[] params){
		int result = 0;
		try{
			namedJdbcTemplate.getJdbcOperations().update(sql, params);
		} catch(DataAccessException ex) {
			ExceptionTranslator.toRespositoryException("Failed to delete", ex);
		}
		return result > 0;
	}
	
	
	protected KeyHolder getKeyHolder() {
		return new GeneratedKeyHolder();
	}
	
	protected BeanPropertySqlParameterSource getParameterSource(T bean) {
		return new BeanPropertySqlParameterSource(bean);
	}
	
	protected BeanPropertyRowMapper<T> getBeanPropertyRowMapper(Class<T> clazz) {
		
		BeanPropertyRowMapper<T> mapper = new BeanPropertyRowMapper<>(clazz);
		
		mapper.setPrimitivesDefaultedForNullValue(true);
		
		return mapper;
	}
	
	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	protected long getCurrentTimestampInMillis(){
		return System.currentTimeMillis();
	}
	
}

