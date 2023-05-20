package com.example.test.bistro_classes.bistro_domains;

import java.io.Serializable;

public class ItemDomain implements Serializable {

    private String title, pic, description;
    Double fee;
    int num_in_cart;

    public ItemDomain(String title, String pic, String description, Double fee) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
    }

    public ItemDomain(String title, String pic, String description, Double fee, int num_in_cart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.num_in_cart = num_in_cart;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNum_in_cart() {
        return num_in_cart;
    }

    public void setNum_in_cart(int num_in_cart) {
        this.num_in_cart = num_in_cart;
    }
}
