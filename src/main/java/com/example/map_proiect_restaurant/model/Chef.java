package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CHEF")
public class Chef extends Staff {

    @Column(nullable = false, length = 100)
    private String specialization;

    @Column(nullable = false)
    private Integer age;

    public Chef() {
        super();
    }

    public Chef(String name, String rating, String specialization, Integer age) {
        super(name, rating);
        this.specialization = specialization;
        this.age = age;
    }

    // Getters and Setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}