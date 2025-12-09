package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "chefs")
@DiscriminatorValue("CHEF")
@PrimaryKeyJoinColumn(name = "id")
public class Chef extends Staff {

    @Column(nullable = false)
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @Column(length = 100)
    @Size(max = 100)
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