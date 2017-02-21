package com.resto.model.message;

import java.io.Serializable;

/**
 * 
 * @author Munisekhar
 *
 */
public class Error implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String key;
	
	private String error;
	
	
	public Error(String key, String error) {
		super();
		this.key = key;
		this.error = error;
	}

	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}
}
