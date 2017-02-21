package com.gullyshops.model;

import java.io.Serializable;

public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user id. */
	private int userId;
    
    /** The user name. */
    private String userName;
    
    /** The password. */
    private String password;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The gender. */
    private String gender;
    
    /** The email. */
    private String email;
    
    /** The height. */
    private int height;
    
    /** The weight. */
    private double weight;
    
    /** The date. */
    private int date;
    
    /** The month. */
    private int month;
    
    /** The year. */
    private int year;
    
    /** The image. */
    private String image;
    
    /** The is pass change req. */
    private boolean isPassChangeReq;
    
    /** The phone. */
    private String phone;
    
    /** The created date. */
    private long createdDate;
    
    /** The created by. */
    private int createdBy;
    
    /** The last updated by. */
    private int lastUpdatedBy;
    
    /** The last updated date. */
    private long lastUpdatedDate;
    
    /**
     * Instantiates a new user.
     */
    public User() {

    }

	/**
	 * Instantiates a new user.
	 *
	 * @param userId the user id
	 * @param userName the user name
	 * @param password the password
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param gender the gender
	 * @param email the email
	 * @param height the height
	 * @param weight the weight
	 * @param date the date
	 * @param month the month
	 * @param year the year
	 * @param image the image
	 * @param isPassChangeReq the is pass change req
	 * @param phone the phone
	 * @param createdDate the created date
	 * @param createdBy the created by
	 * @param lastUpdatedBy the last updated by
	 * @param lastUpdatedDate the last updated date
	 */
	public User(int userId, String userName, String password, String firstName, String lastName, String gender,
			String email, int height, double weight, int date, int month, int year, String image,
			boolean isPassChangeReq, String phone, long createdDate, int createdBy, int lastUpdatedBy,
			long lastUpdatedDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.height = height;
		this.weight = weight;
		this.date = date;
		this.month = month;
		this.year = year;
		this.image = image;
		this.isPassChangeReq = isPassChangeReq;
		this.phone = phone;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public int getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the month.
	 *
	 * @param month the new month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Checks if is pass change req.
	 *
	 * @return true, if is pass change req
	 */
	public boolean isPassChangeReq() {
		return isPassChangeReq;
	}

	/**
	 * Sets the pass change req.
	 *
	 * @param isPassChangeReq the new pass change req
	 */
	public void setPassChangeReq(boolean isPassChangeReq) {
		this.isPassChangeReq = isPassChangeReq;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public long getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public int getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the last updated by.
	 *
	 * @return the last updated by
	 */
	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * Sets the last updated by.
	 *
	 * @param lastUpdatedBy the new last updated by
	 */
	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * Gets the last updated date.
	 *
	 * @return the last updated date
	 */
	public long getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * Sets the last updated date.
	 *
	 * @param lastUpdatedDate the new last updated date
	 */
	public void setLastUpdatedDate(long lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
    
    
}
