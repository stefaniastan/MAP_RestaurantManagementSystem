package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "servers")
@DiscriminatorValue("SERVER")
@PrimaryKeyJoinColumn(name = "id")
public class Server extends Staff {

    @Column(nullable = false)
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @Column(length = 100)
    private String designation;

    public Server() {
        super();
    }

    public Server(String name, String rating, Integer age, String designation) {
        super(name, rating);
        this.age = age;
        this.designation = designation;
    }

    // Getters and Setters
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
//