package com.example.test.bistro_classes.bistro_domains;

import java.io.Serializable;

public class OrderDomain implements Serializable {

    String productName;
    int quantity;
    Double fee;

    public OrderDomain(String productName, int quantity, Double fee) {
        this.productName = productName;
        this.quantity = quantity;
        this.fee = fee;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
