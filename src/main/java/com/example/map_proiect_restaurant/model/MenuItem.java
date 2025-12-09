package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Name is required") //new
    @Size(max = 100)  //new
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Price is required")  //new
    @PositiveOrZero(message = "Price must be 0 or positive")  //new
    private Double price;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<OrderLine> orderLines;


    public MenuItem() {}

    public MenuItem(String name, Double price) {
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}