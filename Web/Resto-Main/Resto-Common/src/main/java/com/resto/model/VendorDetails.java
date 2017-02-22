package com.resto.model;

import java.io.Serializable;

public class VendorDetails implements Serializable{

	private String idVendorDetails ;
    private String Name ;
    private String Email ;
    private String Phone ;
    private String City ;
    private String Address ;
    
	public String getIdVendorDetails() {
		return idVendorDetails;
	}
	public void setIdVendorDetails(String idVendorDetails) {
		this.idVendorDetails = idVendorDetails;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

    
	
}
