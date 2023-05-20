package com.example.test.dump;

import java.io.Serializable;

public class RewardsDomain implements Serializable {

    private String title, pic, desc;
    Double fee;
    private int numberInCart;

    public RewardsDomain(String title, String pic, String desc, Double fee) {
        this.title = title;
        this.pic = pic;
        this.desc = desc;
        this.fee = fee;
    }

    public RewardsDomain(String title, String pic, String desc, Double fee, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.desc = desc;
        this.fee = fee;
        this.numberInCart = numberInCart;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
