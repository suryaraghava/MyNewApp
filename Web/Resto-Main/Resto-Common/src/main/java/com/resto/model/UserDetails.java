package com.resto.model;

import java.io.Serializable;

public class UserDetails implements Serializable{
	
	private int iduserdetails ;
    private String username ;
    private String passcode ;
    private String firstname ;
    private String lastname ;
    private String email ;
    private String phone ;
    
	public int getIduserdetails() {
		return iduserdetails;
	}
	public void setIduserdetails(int iduserdetails) {
		this.iduserdetails = iduserdetails;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

    
	
}
