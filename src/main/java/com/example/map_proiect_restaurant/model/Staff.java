package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "staff_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 10)
    private String rating;

    public Staff() {}

    public Staff(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}