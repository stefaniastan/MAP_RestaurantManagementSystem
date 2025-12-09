package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servers")
@DiscriminatorValue("SERVER")
@PrimaryKeyJoinColumn(name = "id")
public class Server extends Staff {

    @Column(nullable = false)
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