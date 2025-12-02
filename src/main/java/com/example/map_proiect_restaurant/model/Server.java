package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "servers")
public class Server extends Staff {

    @NotBlank(message = "Designation is required")
    @Column(nullable = false, length = 100)
    private String designation;

    public Server() {
        super();
    }

    public Server(String name, String rating, Integer age, String designation) {
        super(name, rating, age);
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