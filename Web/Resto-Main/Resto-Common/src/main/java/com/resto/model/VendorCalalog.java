package com.resto.model;

import java.io.Serializable;

public class VendorCalalog implements Serializable{
	
	private int idvendorCatalog ;
    private int idVendorDetails ;
    private int idCatalog ;
    
	public int getIdvendorCatalog() {
		return idvendorCatalog;
	}
	public void setIdvendorCatalog(int idvendorCatalog) {
		this.idvendorCatalog = idvendorCatalog;
	}
	public int getIdVendorDetails() {
		return idVendorDetails;
	}
	public void setIdVendorDetails(int idVendorDetails) {
		this.idVendorDetails = idVendorDetails;
	}
	public int getIdCatalog() {
		return idCatalog;
	}
	public void setIdCatalog(int idCatalog) {
		this.idCatalog = idCatalog;
	}

    
	
}
