package com.example.betav2;

import java.util.Arrays;

public class Restaurant {

    private String Location ;
    private dish[] menu;
    private int Delivery ;
    private float riting;
    private String site;

    public Restaurant(String location, dish[] menu, int delivery, float riting, String site) {
        Location = location;
        this.menu = menu;
        Delivery = delivery;
        this.riting = riting;
        this.site = site;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Location='" + Location + '\'' +
                ", menu=" + Arrays.toString(menu) +
                ", Delivery=" + Delivery +
                ", riting=" + riting +
                ", site='" + site + '\'' +
                '}';
    }
}
