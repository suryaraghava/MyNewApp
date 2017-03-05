package com.restaurant.model;

/**
 * Created by Munisekhar on 2/23/2017.
 */
public class Item {
    private int id;
    private String name;
    private String image;
    private double mrpPrice;
    private double offerPrice;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(double mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
