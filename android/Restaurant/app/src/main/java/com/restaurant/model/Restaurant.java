package com.restaurant.model;

/**
 * Created by Munisekhar on 2/23/2017.
 */
public class Restaurant {

    private String qrCode;
    private String name;
    private String address;
    private String details;

    public Restaurant() {

    }
    public Restaurant(String qrCode, String name) {
        this.qrCode = qrCode;
        this.name = name;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
