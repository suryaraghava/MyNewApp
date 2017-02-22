package com.resto.model;

import java.io.Serializable;

public class Rating implements Serializable{

	private String idrating ;
    private String idUser ;
    private String rating ;
    private String idVendorDetails ;
    private String idCatalog ;
    
	public String getIdrating() {
		return idrating;
	}
	public void setIdrating(String idrating) {
		this.idrating = idrating;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getIdVendorDetails() {
		return idVendorDetails;
	}
	public void setIdVendorDetails(String idVendorDetails) {
		this.idVendorDetails = idVendorDetails;
	}
	public String getIdCatalog() {
		return idCatalog;
	}
	public void setIdCatalog(String idCatalog) {
		this.idCatalog = idCatalog;
	}

    

}
