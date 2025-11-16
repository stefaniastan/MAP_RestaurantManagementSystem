package com.example.map_proiect_restaurant.model;

import com.example.map_proiect_restaurant.repository.InFileRepository;
import java.util.List;

public class Customer implements InFileRepository.IdProvider {

    private String id;
    private String name;
    private List<Order> orders;
    private String adress;
    private String email;

    public Customer() {}

    public Customer(String id, String name, List<Order> orders, String adress, String email) {
        this.id = id;
        this.name = name;
        this.orders = orders;
        this.adress = adress;
        this.email = email;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
