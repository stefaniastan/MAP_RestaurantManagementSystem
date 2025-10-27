package com.example.map_proiect_restaurant.model;

import java.util.List;

public class Customer {
    private String Id;
    private String Name;
    private List<Order> orders;

    public Customer(String Id, String Name, List<Order> orders) {
        this.Id = Id;
        this.Name = Name;
        this.orders = orders;
    }

    public String getId(){
        return Id;
    }

    public void setId(String Id){
        this.Id = Id;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void setOrders(List<Order> orders){
        this.orders = orders;
    }
}
