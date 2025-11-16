package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuItem implements InFileRepository.IdProvider{
    @JsonProperty("Id")
    private String Id;
    @JsonProperty("Name")
    private String Name;
    private double price;

    public MenuItem() {}

    public MenuItem(String Id, String Name, double price){
        this.Id = Id;
        this.Name = Name;
        this.price = price;
    }


    @Override
    public String getId() {
        return Id;
    }

    @Override
    public void setId(String id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
