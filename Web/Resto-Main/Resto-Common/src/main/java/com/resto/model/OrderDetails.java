package com.resto.model;

import java.io.Serializable;

public class OrderDetails implements Serializable{

	private int idOrderDetails ;
    private int idCatalog ;
    private int Quantity ;
    private int idVendorDetails ;
    private int idUserDetails ;
    
	public int getIdOrderDetails() {
		return idOrderDetails;
	}
	public void setIdOrderDetails(int idOrderDetails) {
		this.idOrderDetails = idOrderDetails;
	}
	public int getIdCatalog() {
		return idCatalog;
	}
	public void setIdCatalog(int idCatalog) {
		this.idCatalog = idCatalog;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getIdVendorDetails() {
		return idVendorDetails;
	}
	public void setIdVendorDetails(int idVendorDetails) {
		this.idVendorDetails = idVendorDetails;
	}
	public int getIdUserDetails() {
		return idUserDetails;
	}
	public void setIdUserDetails(int idUserDetails) {
		this.idUserDetails = idUserDetails;
	}
    
    


	
}
