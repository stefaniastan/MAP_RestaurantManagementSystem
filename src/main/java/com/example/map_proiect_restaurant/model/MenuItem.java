package com.example.map_proiect_restaurant.model;

public class MenuItem {
    private String Id;
    private String Name;
    private double price;

    public MenuItem(String Id, String Name, double price){
        this.Id = Id;
        this.Name = Name;
        this.price = price;
    }

    public String getId() {
        return Id;
    }
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
