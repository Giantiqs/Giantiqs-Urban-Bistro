package com.example.test.testers;

public class Model {
    String drink_name, drink_detail;
    int drink_photo;
    public Model(String drink_name, String drink_detail, int drink_photo) {
        this.drink_name = drink_name;
        this.drink_detail = drink_detail;
        this.drink_photo = drink_photo;
    }

    public String get_drink_name() {
        return drink_name;
    }

    public String get_drink_detail() {
        return drink_detail;
    }

    public int get_drink_photo() {
        return drink_photo;
    }

}
