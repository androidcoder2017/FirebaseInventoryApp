package com.example.a15056112.firebaseinventoryapp;

import java.io.Serializable;

/**
 * Created by 15056112 on 1/8/2017.
 */

public class Inventory implements Serializable {
    private String id;
    private String name;
    private int price;
    private boolean logo;

    public Inventory() {

    }

    public Inventory(String name, int price, boolean logo) {
        this.name = name;
        this.price = price;
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isLogo() {
        return logo;
    }

    public void setLogo(boolean logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return name + "\n" + price;
    }

}
