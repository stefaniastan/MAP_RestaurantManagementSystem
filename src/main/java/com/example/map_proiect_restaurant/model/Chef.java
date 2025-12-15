package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "chefs")
@DiscriminatorValue("CHEF")
@PrimaryKeyJoinColumn(name = "id")
public class Chef extends Staff {

    @Column(nullable = false)
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 150, message = "Age must be at most 150")
    private Integer age;

    @Column(length = 100)
    @NotBlank(message = "Specialization is required")
    @Size(min = 2, max = 100, message = "Specialization must be at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Specialization must contain letters only")
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