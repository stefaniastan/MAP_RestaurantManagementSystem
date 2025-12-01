package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SERVER")
public class Server extends Staff {

    @Column(nullable = false, length = 100)
    private String designation;

    public Server() {
        super();
    }

    public Server(String name, String rating, String designation) {
        super(name, rating);
        this.designation = designation;
    }

    // Getters and Setters
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}