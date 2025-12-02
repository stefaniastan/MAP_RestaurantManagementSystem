package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CHEF")
public class Chef extends Staff {

    @Column(nullable = false)
    private Integer age;

    @Column(length = 100)
    private String specialization;

    public Chef() {
        super();
    }

    public Chef(String name, String rating, Integer age, String specialization) {
        super(name, rating);
        this.age = age;
        this.specialization = specialization;
    }

    // Getters and Setters
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}