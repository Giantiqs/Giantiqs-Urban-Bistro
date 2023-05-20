package com.example.test.bistro_classes.bistro_domains;

public class HistoryDomain {

    int id, quantity;
    Double fee;
    String username, productName, time, date;

    public HistoryDomain(int id, String username, String productName, int quantity, String date, String time, Double fee) {
        this.id = id;
        this.quantity = quantity;
        this.fee = fee;
        this.username = username;
        this.productName = productName;
        this.time = time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
