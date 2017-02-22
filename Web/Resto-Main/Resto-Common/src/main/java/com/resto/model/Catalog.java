package com.resto.model;

import java.io.Serializable;

public class Catalog implements Serializable{

	private int idcatalog;
    private String name;
    private String price;
    private String details;
    
	public int getIdcatalog() {
		return idcatalog;
	}
	public void setIdcatalog(int idcatalog) {
		this.idcatalog = idcatalog;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

    
	
}
