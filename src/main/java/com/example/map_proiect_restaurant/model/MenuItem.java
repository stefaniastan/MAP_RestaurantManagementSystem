package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuItem implements InFileRepository.IdProvider{
    private String id;
    private String name;
    private double price;

    public MenuItem() {}

    public MenuItem(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
