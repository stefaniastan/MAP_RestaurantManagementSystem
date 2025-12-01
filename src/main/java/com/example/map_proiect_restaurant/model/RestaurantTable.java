package com.example.map_proiect_restaurant.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant_tables")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TableStatusEnum status;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public RestaurantTable() {}

    public RestaurantTable(Integer number, TableStatusEnum status) {
        this.number = number;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public TableStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TableStatusEnum status) {
        this.status = status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // Helper method to add order
    public void addOrder(Order order) {
        orders.add(order);
        order.setTable(this);
    }

    // Helper method to remove order
    public void removeOrder(Order order) {
        orders.remove(order);
        order.setTable(null);
    }
}