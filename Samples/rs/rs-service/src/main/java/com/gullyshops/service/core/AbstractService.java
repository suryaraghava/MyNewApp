package com.gullyshops.service.core;

import java.util.List;

import com.gullyshops.exception.ServiceException;

public interface AbstractService<T> {

	void save(T bean) throws ServiceException, IllegalArgumentException;

	void save(List<T> beans) throws ServiceException, IllegalArgumentException;

	boolean update(T bean) throws ServiceException, IllegalArgumentException;

}

